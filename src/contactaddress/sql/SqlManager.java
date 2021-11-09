package contactaddress.sql;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import contactaddress.gui.messages.Message;
import contactaddress.models.AddressBook;

public class SqlManager {

    private HashMap<String, String> sqlStatmentMap;
    private String key = null;
    private Connection connection;

    public SqlManager(Connection connection) {

        this.connection = connection;
        sqlStatmentMap = new HashMap<>();
    }

    public String[] readSql(String file) {
        String[] sql = null;
        String data = "";
        try {

            Path filePath = Paths.get(SqlManager.class.getResource(file).toURI());
            data = Files.readString(filePath);
        } catch (IOException | URISyntaxException e) {
            Message.showError(e.getMessage(), "File Not Found");
        }
        sql = data.split(";");
        return sql;

    }

    public HashMap<String, String> getSqlStatement() {

        String[] sqlStatements = readSql("tables.sql");

        for (String stmt : sqlStatements) {
            StringBuilder sb = new StringBuilder();
            stmt.lines().forEach((line) -> {
                if (line.startsWith("--")) {
                    key = line;
                } else {
                    sb.append(line).append("\n");
                }
            });
            if (key != null) {
                sqlStatmentMap.put(key.trim().substring(2), sb.toString());

            }

            sb.delete(0, sb.length());
            key = null;

        }

        return sqlStatmentMap;
    }

    public boolean isTableExist(String sTablename) throws SQLException {
        if (connection != null) {
            DatabaseMetaData dbmd = connection.getMetaData();
            ResultSet rs = dbmd.getTables(null, null, sTablename.toUpperCase(), null);
            if (rs.next())
                return true;
        }
        return false;
    }



    public int insertAddress(String sql, AddressBook ab, int id) {
        int result = 0;
        try {
            PreparedStatement newAddress = connection.prepareStatement(sql);
            
            newAddress.setString(1, ab.getFirstName());
            newAddress.setString(2, ab.getLastname());
            newAddress.setString(3, ab.getMiddelName());
            newAddress.setString(4, ab.getPhone());
            newAddress.setString(5, ab.getEmail());
            newAddress.setString(6, ab.getAddress1());
            newAddress.setString(7, ab.getAddress2());
            newAddress.setString(8, ab.getCity());
            newAddress.setString(9, ab.getState());
            newAddress.setString(10, ab.getPostalCode());
            newAddress.setString(11, ab.getCountry());

            if(id != -1)
            newAddress.setInt(12, ab.getId());
            

            result = newAddress.executeUpdate();

        } catch (SQLException e) {

           Message.showError(e.getMessage(), "SQL Error");
        }

        return result;
    }

    public boolean createTable(String sql, String name) {
        boolean bCreatedTables = false;
        Statement statement = null;
        try {
            if (!isTableExist(name)) {
                statement = connection.createStatement();
                statement.execute(sql);
                bCreatedTables = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return bCreatedTables;
    }

    public ArrayList<AddressBook> getAllAddress(String sql) {

        // use arrayList to collect all contact addresses in the table
        ArrayList<AddressBook> addressList = new ArrayList<>();

        try {
            ResultSet rs = (connection.prepareStatement(sql)).executeQuery();

            while (rs.next()) {

                AddressBook ab = new AddressBook(rs.getInt("ID"), rs.getString("FIRSTNAME"),rs.getString("MIDDLENAME"), rs.getString("LASTNAME"),
                        rs.getString("PHONE"), rs.getString("EMAIL"), rs.getString("ADDRESS1"),
                        rs.getString("ADDRESS2"), rs.getString("STATE"), rs.getString("CITY"),
                        rs.getString("POSTALCODE"), rs.getString("COUNTRY"));

                addressList.add(ab);

            }
        } catch (SQLException e) {
            Message.showError(e.getMessage(), "SQL Error");
        }
        return addressList;
    }

    public HashMap<Integer, String> onlyContactNames(String sql) {

        // use HashMap to collect all contact names only
        // to be used in the JList
        HashMap<Integer, String> contactNames = new HashMap<>();

        try {
            ResultSet rs = (connection.prepareStatement(sql)).executeQuery();

            while (rs.next()) {
                String fullName = rs.getString("FIRSTNAME");
                fullName += " " + rs.getString("LASTNAME");
                contactNames.put(rs.getInt("ID"), fullName);
            }
        } catch (SQLException e) {
            Message.showError(e.getMessage(), "SQL Error");
        }
        return contactNames;

    }


    public AddressBook getAddressDetails(String sql, int id){

        AddressBook  details  =  null;
        try {
            PreparedStatement  pst =  connection.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                details = new AddressBook(rs.getInt("ID"), rs.getString("FIRSTNAME"),rs.getString("MIDDLENAME"), rs.getString("LASTNAME"),
                rs.getString("PHONE"), rs.getString("EMAIL"), rs.getString("ADDRESS1"),
                rs.getString("ADDRESS2"), rs.getString("STATE"), rs.getString("CITY"),
                rs.getString("POSTALCODE"), rs.getString("COUNTRY"));  
            }
            

            
        } catch (SQLException e) {
            Message.showError(e.getMessage(), "SQL Error");
        }

return details;
    } 


    public int deleteContact(int id){

        String sql  =  getSqlStatement().get("delete contact");
        int result = 0;
 try {
    PreparedStatement  pStatement = connection.prepareStatement(sql);
    pStatement.setInt(1, id);
    result =  pStatement.executeUpdate();
} catch (SQLException e) {
    Message.showError(e.getMessage(), "SQL Error");
}
 
return result;
    }
}
