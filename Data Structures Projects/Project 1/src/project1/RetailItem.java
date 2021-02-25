package project1;

/**
 *
 * @author wes
 * @version 1.0
 */
public class RetailItem {
    
    private String description;
    private Integer inventory;
    private Double price;
    
    /**
     * Constructor default
     * 
     * @param description of the object
     * @param inventory amount of object
     * @param price of object
     */
    public RetailItem(String description, Integer inventory, Double price) {        
        this.description = description;
        this.inventory = inventory;
        this.price = price; 
    }
   
    /**
     * Getter to return the description of the object
     * @return description 
     */
    public String getDescription() {   
        return description;
    }
    
    /**
     * Getter to return the inventory of the object
     * @return inventory
     */
    public Integer getInventory() {      
        return inventory;     
    }
    
    /**
     * Getter to return to price of the object
     * @return the price 
     */
    public Double getPrice() {        
        return price;
    }
    
    /**
     * Setter to set the description of the object
     * @param description the description of the object
     */
    public void setDescription(String description) {       
        this.description = description;       
    }
    
    /**
     * Setter to set the inventory amount
     * @param inventory amount of object
     */
    public void setInventory(Integer inventory) {        
        this.inventory = inventory;       
    }
    
    /**
     * Setter to set the price of the object
     * @param price the price of the object
     */
    public void setPrice(Double price) {       
        this.price = price;       
    }
       
}
