package project2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author aberardinelli
 * @version 2020-02-10
 */
public class Donation {
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("MM/dd/yyyy");
    private String purpose;
    private Double amount;
    private Date donatedDate;
    private Donor theDonor;
    
    /**
     * Default constructor
     */
    public Donation() {
        purpose = "";
        amount = 0.0;
        donatedDate = new Date();
        theDonor = new Donor();
    }
    
    /**
     * Constructor used to initialize purpose and amount, with today's date
     * @param newpurpose purpose value for new donation object
     * @param newamount amount value for new donation object
     * @param newdonor theDonor value for new donation object
     */
    public Donation(String newpurpose, Double newamount, Donor newdonor) {
        purpose = newpurpose;
        amount = newamount;
        theDonor = newdonor;
        donatedDate = new Date();
    }
    
    /**
     * Constructor used to initialize all class variables
     * @param newpurpose purpose value for new donation object
     * @param newamount amount value for new donation object
     * @param newdonor theDonor value for new donation object
     * @param newdate donatedDate value for new donation object
     */
    public Donation(String newpurpose, Double newamount, Donor newdonor, Date newdate) {
        purpose = newpurpose;
        amount = newamount;
        theDonor = newdonor;
        donatedDate = newdate;
    }
    
    /**
     * Constructor used to initialize all class variables
     * @param newpurpose purpose value for new donation object
     * @param newamount amount value for new donation object
     * @param newdonor theDonor value for new donation object
     * @param newdate must be a string in MM/DD/YYYY format
     * @throws ParseException if newdate is not in the correct format
     */
    public Donation(String newpurpose, Double newamount, Donor newdonor, 
            String newdate) throws ParseException {
        purpose = newpurpose;
        amount = newamount;
        donatedDate = FORMAT.parse(newdate);
    }
    
    /**
     * Purpose setter 
     * @param newpurpose purpose value for this donation object
     */
    public void setPurpose(String newpurpose) {
        purpose = newpurpose;
    }
    
    /**
     * Amount setter 
     * @param newamount amount value for this donation object
     */
    public void setAmount(Double newamount) {
        amount = newamount;
    }
    
    /**
     * Donor setter 
     * @param newdonor amount value for this donation object
     */
    public void setDonor(Donor newdonor) {
        theDonor = newdonor;
    }
    
    /**
     * Date setter 
     * @param newdate donatedDate value for this donation object
     */
    public void setDate(Date newdate) {
        donatedDate = newdate;
    }
    
    /**
     * Date setter 
     * @param newdate must be a string in MM/DD/YYYY format
     * @throws ParseException if newdate is not in the correct format
     */
    public void setDate(String newdate) throws ParseException {
        donatedDate = FORMAT.parse(newdate);
    }
    
    /**
     * Purpose getter 
     * @return current value of donation purpose
     */
    public String getPurpose() {
        return purpose;
    }
    
    /**
     * Amount getter 
     * @return current value of donation amount
     */
    public Double getAmount() {
        return amount;
    }
    
    /**
     * Donor getter 
     * @return current value of donation donor
     */
    public Donor getDonor() {
        return theDonor;
    }
    
    /**
     * Date getter 
     * @return current value of donation date
     */
    public String getDate() {
        return FORMAT.format(donatedDate);
    }
    
}
