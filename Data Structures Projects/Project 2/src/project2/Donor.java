package project2;

/**
 *
 * @author aberardinelli
 * @version 2020-02-10
 */
public class Donor {
    private String name;
    private String address;
    private String phone;
    
    /**
     * Default constructor; initializes all variables to blank strings
     */
    public Donor() {
        name = "";
        address = "";
        phone = "";
    }
    
    /**
     * Constructor used to initialize all class variables
     * @param newname name value for new donor object
     * @param newaddress address value for new donor object
     * @param newphone phone value for new donor object
     */
    public Donor(String newname, String newaddress, String newphone) {
        name = newname;
        address = newaddress;
        phone = newphone;
    }
    
    /**
     * Name setter 
     * @param newname name value for new donor object
     */
    public void setName(String newname) {
        name = newname;
    }
    
    /**
     * Address setter 
     * @param newaddress address value for new donor object
     */
    public void setAddress(String newaddress) {
        address = newaddress;
    }
    
    /**
     * Phone setter 
     * @param newphone phone value for new donor object
     */
    public void setPhone(String newphone) {
        phone = newphone;
    }
    
    /**
     * Name getter 
     * @return current value of donor's name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Address getter 
     * @return current value of donor's address
     */
    public String getAddress() {
        return address;
    }
    
    /**
     * Phone getter 
     * @return current value of donor's phone
     */
    public String getPhone() {
        return phone;
    }
}