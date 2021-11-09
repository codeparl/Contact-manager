package contactaddress.models;

import java.io.Serializable;

public class AddressBook implements Serializable {
    

    private int id;
    private String firstName;
    private String lastname;
    private String middelName;
    private String phone;
    private String email;
    private String address1, address2, state,city,postalCode, country;
    /**
     * @param id
     * @param firstName
     * @param lastname
     * @param phone
     * @param email
     * @param address1
     * @param address2
     * @param state
     * @param city
     * @param postalCode
     * @param country
     */
    public AddressBook(int id, String firstName,String middleName, String lastname, String phone, String email, String address1,
            String address2, String state, String city, String postalCode, String country) {
        this.id = id;
        this.firstName = firstName;
        this.middelName =  middleName;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.state = state;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    
    /**
     * 
     */
    public AddressBook() {
    }


    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }
    /**
     * @return the middelName
     */
    public String getMiddelName() {
        return middelName;
    }


    /**
     * @param middelName the middelName to set
     */
    public void setMiddelName(String middelName) {
        this.middelName = middelName;
    }


    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }
    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @return the address1
     */
    public String getAddress1() {
        return address1;
    }
    /**
     * @param address1 the address1 to set
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }
    /**
     * @return the address2
     */
    public String getAddress2() {
        return address2;
    }
    /**
     * @param address2 the address2 to set
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }
    /**
     * @return the state
     */
    public String getState() {
        return state;
    }
    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }
    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }
    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }
    /**
     * @return the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }
    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }
    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    @Override
    public String toString() {
        return "AddressBook [address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", country="
                + country + ", email=" + email + ", firstName=" + firstName + ", id=" + id + ", lastname=" + lastname
                + ", phone=" + phone + ", postalCode=" + postalCode + ", state=" + state + "]";
    }

    
    

}
