/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.io.FileNotFoundException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wes
 * @version 2.7
 */
public class TagValidationTest {

    /**
     * I still don't know why I need this
     */
    public TagValidationTest() {
        //My grade on my last assignment was entered incorrectly I think could 
        //you pls check it I've email several times idk if it's going through
    }

    /*
    * Test of TagValidation constructor why am i getting points off for this
    pls Web-Cat tell me
    */
    @Test
    public void testConstructor() {
        TagValidation tagV = new TagValidation();

        assertNotNull(tagV);
    }

    /**
     * Test of checkFile method, of class TagValidation.
     */
    @Test
    public void testCheckFile() throws FileNotFoundException {
        
        assertEquals(true, TagValidation.checkFile("index.html"));   
        assertEquals(false, TagValidation.checkFile("index2.html"));
        assertEquals(false, TagValidation.checkFile("index3.html"));
        assertEquals(false, TagValidation.checkFile("index4.html"));
        assertEquals(true, TagValidation.checkFile("recipe.html"));
        
    }

}
