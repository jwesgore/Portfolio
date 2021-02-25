/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

/**
 *
 * @author Wes
 * @version 1.0
 */
public class TransactionTest {
    
    public TransactionTest() {
    }

    /**
     * Test of purchaseItem method, of class Transaction.
     */
    @Test
    public void testPurchaseItem_RetailItem() {
        System.out.println("purchaseItem");
        RetailItem obj = new RetailItem("test", 1, 1.1);
        Transaction instance = new Transaction();
        
        //set up lists
        ArrayList<RetailItem> testList = new ArrayList<>();
        ArrayList<RetailItem> realList = new ArrayList<>();
        realList = instance.makeVisible(realList);
        
        //add items to list
        instance.purchaseItem(obj);
        testList.add(obj);
        
        //test elemets
        assertEquals(testList, realList);
        
        assertEquals(testList.get(0), realList.get(0));
        
        assertEquals(testList.size(), realList.size());
        
    }

    /**
     * Test of purchaseItem method, of class Transaction.
     */
    @Test
    public void testPurchaseItem_RetailItem_Integer() {
        System.out.println("purchaseItem");
        RetailItem obj = new RetailItem("test", 1, 1.1);
        Transaction instance = new Transaction();
        
        //set up lists
        ArrayList<RetailItem> testList = new ArrayList<>();
        ArrayList<RetailItem> realList = new ArrayList<>();
        realList = instance.makeVisible(realList);
        
        //add items to list
        instance.purchaseItem(obj, 5);
        testList.add(obj);
        testList.add(obj);
        testList.add(obj);
        testList.add(obj);
        testList.add(obj);
        
        //test elements
        assertEquals(testList, realList);
        
        assertEquals(testList.get(0), realList.get(0));
        
        assertEquals(testList.get(4), realList.get(4));
        
        assertEquals(testList.size(), realList.size());
        
    }

    /**
     * Test of getTotal method, of class Transaction.
     */
    @Test
    public void testGetTotal() {
        System.out.println("getTotal");
        RetailItem obj = new RetailItem("test", 1, 1.1);
        Transaction instance = new Transaction();

        //add items to list
        instance.purchaseItem(obj, 5);
         
        //test that list is equal to value
        assertEquals(5.50, instance.getTotal(), 0.0);
        
        //make list empty
        instance.cancelPurchase();
        
        //test total is zero
        assertEquals(0.0, instance.getTotal(), 0.0);
    }

    /**
     * Test of receipt method, of class Transaction.
     */
    @Test
    public void testReceipt() {
        System.out.println("receipt");
        Transaction instance = new Transaction();
        
    }

    /**
     * Test of cancelPurchase method, of class Transaction.
     */
    @Test
    public void testCancelPurchase() {
        System.out.println("cancelPurchase");
        RetailItem obj = new RetailItem("test", 1, 1.1);
        Transaction instance = new Transaction();
        
        //set up list
        ArrayList<RetailItem> realList = new ArrayList<>();
        realList = instance.makeVisible(realList);
        
        //add items to list
        instance.purchaseItem(obj, 5);
        
        //test that list is not zero
        assertEquals(5, realList.size());
        
        //make list empty
        instance.cancelPurchase();
        
        //test list is empty
        assertEquals(0, realList.size());
    }

    /**
     * Test of completePurchase method, of class Transaction.
     */
    @Test
    public void testCompletePurchase() {
        System.out.println("completePurchase");
        Transaction instance = new Transaction();
        instance.completePurchase();
        
    }

    /**
     * Test of makeVisible method, of class Transaction.
     */
    @Test
    public void testMakeVisible() {
    }
    
}
