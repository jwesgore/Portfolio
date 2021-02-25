package project3;

import DataStructures.*;
import java.io.*;
import Exceptions.EmptyCollectionException;

/**
 *
 * @author Wesley Gore
 * @version 1.0
 */
public class TagValidation {

    /**
     *
     * @param filename thats the file
     * @return hopefully true
     * @throws FileNotFoundException hopefully not
     */
    static public boolean checkFile(String filename) throws FileNotFoundException {

        FileReader fr = new FileReader(filename);

        try {

            // set up variables for use
            StringBuilder sb = new StringBuilder();
            LinkedQueue<String> list = new LinkedQueue<>();
            char temp;
            // while loop to build queue up with parameters
            while (fr.ready()) {

                temp = (char) fr.read();

                //build string to add to queue
                if (temp == '<') {
                    //loop adding next char until either a space or end of tag
                    do {
                        //in case of newline
                        if (temp == '\n') {
                            break;
                        }
                        //continue to add to string
                        sb.append(temp);
                        temp = (char) fr.read();
                    } while (temp != ' ' && temp != '>' && fr.ready());

                    //in case attributes came after tag, look for end of tag
                    while (temp != '>' && fr.ready()) {
                        temp = (char) fr.read();
                    }

                    //add to queue and reset string builder
                    sb.append(temp);
                    list.enqueue(sb.toString());
                    sb.setLength(0);
                }

            }

            //builds the open stack
            LinkedStack<String> open = new LinkedStack<>();
            String deq;
            String pop;
            while (!list.isEmpty()) {

                //take first element from queue
                deq = list.dequeue();

                //test if current element is closing tag, else add to stack
                if (deq.startsWith("</")) {

                    //remove recent element on stack
                    pop = open.pop().substring(1);

                    //test if tags match
                    if (!deq.substring(2).contentEquals(pop)) {
                        return false;
                    }

                } else {
                    open.push(deq);
                }

            }

            //if stack is empty, then the code worked
            return open.isEmpty();
        } catch (IOException | EmptyCollectionException ex) {
            return false;
        }

    }

}
