/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import DataStructures.*;
import Exceptions.EmptyCollectionException;
import Exceptions.InvalidArgumentException;

/**
 *
 * @author Wes
 * @version 1
 */
public class Fundraiser {

    private final SinglyLinkedList<Donation> donations;

    /**
     * initialize donations
     */
    public Fundraiser() {

        this.donations = new SinglyLinkedList<>();

    }

    /**
     * create string of names and addresses
     *
     * @return string of names and addresses
     */
    public String addressLabels() {

        String temp = "";
        String result = "";

        if (donations.isEmpty()) {
            return result;
        } else {

            for (int i = 0; i < donations.size(); i++) {

                try {
                    temp = "";

                    temp += donations.get(i).getDonor().getName();
                    temp += "\n";
                    temp += donations.get(i).getDonor().getAddress();
                    temp += "\n\n";

                    if (!result.contains(temp)) {
                        result += temp;
                    }
                } catch (InvalidArgumentException | EmptyCollectionException ex) {
                    System.out.println("Invalid Arguement");
                }

            }

            return result;

        }

    }

    /**
     * adds a new donation into donations list
     *
     * @param newDonation item to add
     */
    public void addDonation(Donation newDonation) {

        donations.add(newDonation);

    }

    /**
     * returns list for testing
     *
     * @return donations list
     */
    public SinglyLinkedList<Donation> getDonations() {

        return donations;

    }

    /**
     * returns a string with names and numbers of all donors in donations list
     *
     * @return string with names and numbers of all donors in donations list
     */
    public String donorReport() {

        String temp = "";
        String result = "";

        if (donations.isEmpty()) {
            return result;
        } else {

            for (int i = 0; i < donations.size(); i++) {

                temp = "";

                try {
                    temp += donations.get(i).getDonor().getName();
                    temp += "\t";
                    temp += donations.get(i).getDonor().getPhone();
                    temp += "\n";

                    if (!result.contains(temp)) {
                        result += temp;
                    }

                } catch (InvalidArgumentException | EmptyCollectionException e) {
                    System.out.println(e);
                }

            }

            return result;

        }

    }

    /**
     * returns a string with all purposes and the total amount of money donated
     * to that cause
     *
     * @return string with all purposes and the total amount of money donated to
     * that cause
     */
    public String donationTypeReport() {

        String temp1 = "";
        String temp2 = "";
        String result = "";
        double num1;
        double num2;

        if (donations.isEmpty()) {
            return "0.00";
        } else {

            try {
                for (int i = 0; i < donations.size(); i++) {

                    temp1 = donations.get(i).getPurpose();
                    num1 = donations.get(i).getAmount();

                    if (result.contains(temp1)) {
                        continue;
                    }

                    for (int j = (1 + i); j < donations.size(); j++) {

                        temp2 = donations.get(j).getPurpose();
                        num2 = donations.get(j).getAmount();

                        if (temp1.equals(temp2)) {
                            num1 += num2;
                        }

                    }

                    temp1 += "\t";
                    temp1 += String.format("%.2f", num1);
                    temp1 += "\n";
                    result += temp1;

                }

            } catch (InvalidArgumentException | EmptyCollectionException e) {
                System.out.println(e);
            }

        }

        return result;

    }

}
