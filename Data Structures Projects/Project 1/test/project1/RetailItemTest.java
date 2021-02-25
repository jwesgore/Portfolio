/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wes
 * @version 1.0
 */
public class RetailItemTest {
    
    /**
     * Constructor for the object
     */
    public RetailItemTest() { 
        /**
         * documentation: including all methods
         */
    }

    /**
     * Test of getDescription method, of class RetailItem.
     */
    @Test
    public void testGetDescription() {       
        RetailItem desc = new RetailItem("Some Name", 5, 2.75);
        
        assertEquals("Some Name", desc.getDescription());       
    }

    /**
     * Test of getInventory method, of class RetailItem.
     */
    @Test
    public void testGetInventory() {
        RetailItem desc = new RetailItem("Some Name", 5, 2.75);
        
        assertEquals(5,(int) desc.getInventory());
    }

    /**
     * Test of getPrice method, of class RetailItem.
     */
    @Test
    public void testGetPrice() {
        RetailItem desc = new RetailItem("Some Name", 5, 2.75);
        
        assertEquals(2.75, desc.getPrice(), 0.0);        
    }

    /**
     * Test of setDescription method, of class RetailItem.
     */
    @Test
    public void testSetDescription() {
        RetailItem desc = new RetailItem("Some Name", 5, 2.75);
        desc.setDescription("Some Name 2");
        
        assertEquals("Some Name 2", desc.getDescription());
    }

    /**
     * Test of setInventory method, of class RetailItem.
     */
    @Test
    public void testSetInventory() {
        RetailItem desc = new RetailItem("Some Name", 5, 2.75);
        desc.setInventory(10);
        
        assertEquals(10,(int) desc.getInventory());         
    }

    /**
     * Test of setPrice method, of class RetailItem.
     */
    @Test
    public void testSetPrice() {
        RetailItem desc = new RetailItem("Some Name", 5, 2.75);
        desc.setPrice(5.25);
        
        assertEquals(5.25, desc.getPrice(), 0.0);       
    }
    
}
