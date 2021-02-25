/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import Exceptions.EmptyCollectionException;
import Exceptions.InvalidArgumentException;
import java.text.ParseException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wes
 * @version 1
 */
public class FundraiserTest {

    /**
     * Constructor for creating lists
     *
     */
    public FundraiserTest() {
        //no code to test
    }

    /**
     * Test of addressLabels method, of class Fundraiser.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testAddressLabels() throws ParseException {

        Fundraiser test = new Fundraiser();

        Donor guy1 = new Donor("Ringo", "London", "111-111-1111");
        Donation don1 = new Donation("pizza party", 1.00, guy1);

        Donor guy2 = new Donor("John", "Yorkshire", "222-222-2222");
        Donation don2 = new Donation("dance party", 4.00, guy2);

        Donor guy3 = new Donor("Paul", "The Castle", "333-333-3333");
        Donation don3 = new Donation("pizza party", 3.75, guy3);

        Donor guy4 = new Donor("George", "Heaven", "444-444-4444");
        Donation don4 = new Donation("slumber party", 2.50, guy4);

        assertEquals(test.addressLabels(), "");

        test.addDonation(don1);
        test.addDonation(don2);
        test.addDonation(don3);
        test.addDonation(don4);

        assertEquals(test.getDonations().size(), 4);

        String report = "Ringo\nLondon\n\n"
                + "John\nYorkshire\n\n"
                + "Paul\nThe Castle\n\n"
                + "George\nHeaven\n\n";

        assertEquals(test.addressLabels(), report);

        test.addDonation(don4);
        test.addDonation(don1);

        assertEquals(test.getDonations().size(), 6);
        assertEquals(test.addressLabels(), report);
        
        Donation empty = new Donation();
        
        test.addDonation(empty);
        test.addressLabels();
        
    }

    /**
     * Test of addDonation method, of class Fundraiser.
     *
     * @throws java.text.ParseException
     * @throws Exceptions.InvalidArgumentException
     * @throws Exceptions.EmptyCollectionException
     */
    @Test
    public void testAddDonation() throws ParseException,
            InvalidArgumentException, EmptyCollectionException {

        Fundraiser test = new Fundraiser();
        Donor guy1 = new Donor("Ringo", "London", "111-111-1111");
        Donation don1 = new Donation("pizza party", 1.00, guy1, "01/01/2020");

        Donor guy2 = new Donor("John", "London", "222-222-2222");
        Donation don2 = new Donation("dance party", 4.00, guy2, "01/01/2020");

        test.addDonation(don1);

        assertEquals(test.getDonations().size(), 1);

        assertEquals(test.getDonations().get(0), don1);

        test.addDonation(don2);
        test.addDonation(don1);

        assertEquals(test.getDonations().size(), 3);

        assertEquals(test.getDonations().get(0), don1);
        assertEquals(test.getDonations().get(1), don2);
        assertEquals(test.getDonations().get(2), don1);

    }

    /**
     * Test of getDonations method, of class Fundraiser.
     *
     * @throws java.text.ParseException
     * @throws Exceptions.InvalidArgumentException
     * @throws Exceptions.EmptyCollectionException
     */
    @Test
    public void testGetDonations() throws ParseException,
            InvalidArgumentException, EmptyCollectionException {
        Fundraiser test = new Fundraiser();
        Fundraiser test2 = new Fundraiser();
        Donor guy1 = new Donor("Ringo", "London", "111-111-1111");
        Donation don1 = new Donation("pizza party", 1.00, guy1, "01/01/2020");

        Donor guy2 = new Donor("John", "London", "222-222-2222");
        Donation don2 = new Donation("dance party", 4.00, guy2, "01/01/2020");

        assertEquals(test.getDonations().size(), 0);

        test.addDonation(don1);
        test.addDonation(don2);

        test2.getDonations().add(don1);
        test2.getDonations().add(don2);

        assertEquals(test.getDonations().get(0), test2.getDonations().get(0));
        assertEquals(test.getDonations().get(1), test2.getDonations().get(1));
        

    }

    /**
     * Test of donorReport method, of class Fundraiser.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testDonorReport() throws ParseException {
        Fundraiser test = new Fundraiser();

        Donor guy1 = new Donor("Ringo", "London", "111-111-1111");
        Donation don1 = new Donation("pizza party", 1.00, guy1);

        Donor guy2 = new Donor("John", "London", "222-222-2222");
        Donation don2 = new Donation("dance party", 4.00, guy2);

        assertEquals(test.donorReport(), "");

        test.addDonation(don1);
        test.addDonation(don2);

        assertEquals(test.getDonations().size(), 2);

        String report = "Ringo\t111-111-1111\n"
                + "John\t222-222-2222\n";

        assertEquals(test.donorReport(), report);

        test.addDonation(don1);
        test.addDonation(don2);

        assertEquals(test.getDonations().size(), 4);
        assertEquals(test.donorReport(), report);

    }

    /**
     * Test of donationTypeReport method, of class Fundraiser.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testDonationTypeReport() throws ParseException {

        Fundraiser test = new Fundraiser();

        Donor guy1 = new Donor("Ringo", "London", "111-111-1111");
        Donation don1 = new Donation("pizza party", 1.00, guy1, "01/01/2020");

        Donor guy2 = new Donor("John", "London", "222-222-2222");
        Donation don2 = new Donation("dance party", 4.00, guy2, "01/01/2020");

        Donor guy3 = new Donor("Paul", "London", "333-333-3333");
        Donation don3 = new Donation("pizza party", 3.75, guy3, "01/01/2020");

        Donor guy4 = new Donor("George", "London", "444-444-4444");
        Donation don4 = new Donation("slumber party", 2.50, guy4, "01/01/2020");

        assertEquals(test.donationTypeReport(), "0.00");

        test.addDonation(don1);
        test.addDonation(don2);

        assertEquals(test.getDonations().size(), 2);

        String report = "pizza party\t1.00\n"
                + "dance party\t4.00\n";

        assertEquals(test.donationTypeReport(), report);

        test.addDonation(don3);
        test.addDonation(don4);

        assertEquals(test.getDonations().size(), 4);

        report = "pizza party\t4.75\n"
                + "dance party\t4.00\n"
                + "slumber party\t2.50\n";

        assertEquals(test.donationTypeReport(), report);

    }

}
