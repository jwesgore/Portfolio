package project1;

import java.util.*;
/**
 *
 * @author wes
 * @version 1.0
 */
public class Transaction {
   
    private ArrayList<RetailItem> items = new ArrayList<>();
    /**
     * Im not sure what this does
     */
    public Transaction() {      
        /*
        im trying my best
        */       
    }

    /**
     * Returns value of items as public list for testing
     * @param items set equal to items list
     * @return local items
     */
    public ArrayList makeVisible(ArrayList items) {
        items = this.items;
        return items;
    }
    
    /**
     * Adds a single item into the list
     * @param obj imported RetailItem
     */
    public void purchaseItem( RetailItem obj ) {        
        items.add(obj);
    }
    
    /**
     * Adds multiple of the same item
     * @param obj imported RetailItem
     * @param quantity amount of item
     */
    public void purchaseItem( RetailItem obj, Integer quantity) {
        for (int i = 0; i < quantity; i++ ) {
            items.add(obj);
        }
    }
    
    /**
     * Sums up the total price of items in list
     * @return price rounded to 2 decimals
     */
    public Double getTotal() {

        double price = 0.0;
        
        //add price of all items in list
        price = items.stream().map((objs) -> 
                objs.getPrice()).reduce(price, (accumulator, _item) ->
                        accumulator + _item);
     
        //return total
        return Math.round(price * 100.0) / 100.0;
    }
       
    /**
     * organize the retail item list into a receipt
     * @return string to print out receipt
     */
    public String receipt() {
        
        //arrays for receipt
        ArrayList<String> receipt = new ArrayList<>();
        ArrayList<Integer> amount = new ArrayList<>();
        ArrayList<Double> price = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        
        //build String and Integer list with descriptions and amount
        items.forEach((obj) -> {
            if (receipt.contains(obj.getDescription())) {           
                amount.set( receipt.indexOf(obj.getDescription()),
                        amount.get(receipt.indexOf(obj.getDescription())) + 1);
            } else {
                receipt.add(obj.getDescription());
                amount.add(1);
                price.add(obj.getPrice());
            }
        });
       
        int i = 0;
        for (String str : receipt) {
            
            //build string
            sb.append(str).append("\t");
            sb.append(amount.get(i)).append("\t");
            sb.append(price.get(i) * amount.get(i));
            
            //add newline if not the last item
            if (i != receipt.size() - 1) {
                sb.append("\n");
            }
            
            i++;
        }
        
        //return new string
        return sb.toString();
    }
    
    /**
     * removes all items from the retail item list
     */
    public void cancelPurchase() {
        items.clear();
    }
    
    /**
     * adjusts inventory and clears retail item list
     */
    public void completePurchase() {
        
        //go through items list and reduce ivenetory by one
        items.forEach((obj) -> {
            obj.setInventory(obj.getInventory() - 1);
        });
        
        items.clear();
    }
    
}
