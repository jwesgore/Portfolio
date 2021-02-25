/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkLadderProject;

import DataStructures.Vertex;
import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Exceptions.InvalidArgumentException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A simulation class for the HyperLinkGraph.
 * @author Brian Thompson
 * @version 18/4/2018
 */
public class HyperLinkGraphSim {
    
    private static WebPage[] pages;
    
    public static void main(String[] args) throws Exception {
        HyperLinkGraph<WebPage> webGraph = createGraph();
        
        System.out.println( "Path from Donald Trump to Communism: "+ 
                webGraph.getPathBetween(new Vertex(pages[8]), new Vertex(pages[10])));
        
        System.out.println("Connected: " + webGraph.isGraphConnected());
        System.out.println("Complete: " + webGraph.isGraphComplete());
        System.out.println("Inclusiveness: " + webGraph.inclusiveness());
        System.out.println("Density: " + webGraph.density());
        System.out.println("BreadthFirstTraversal from Barack Obama: " 
                + webGraph.breadthFirstTraversal(new Vertex(pages[5])));
        System.out.println("Is There a Link Ladder From Kabbalah to Philosophy? " 
                + webGraph.isALinkLadder(new Vertex(pages[0]), new Vertex(pages[24])));
        
        
    }
    
    public static HyperLinkGraph<WebPage> createGraph() {
        pages = new WebPage[25];
        pages[0] = new WebPage("Kabbalah", 0);
        pages[1] = new WebPage("Jewish Mysticism", 1);
        pages[2] = new WebPage("Judaism", 2);
        pages[3] = new WebPage("Religion", 3);
        pages[4] = new WebPage("Philosophy of Religion", 4);
        pages[5] = new WebPage("Barack Obama", 5);
        pages[6] = new WebPage("Democratic Party", 6);
        pages[7] = new WebPage("President of the USA", 7);
        pages[8] = new WebPage("Donald Trump", 8);
        pages[9] = new WebPage("Republican Party", 9);
        pages[10] = new WebPage("Communism", 10);
        pages[11] = new WebPage("Socialism", 11);
        pages[12] = new WebPage("Alt-Right", 12);
        pages[13] = new WebPage("Bernie Sanders", 13);
        pages[14] = new WebPage("Democratic Socialism", 14);
        pages[15] = new WebPage("Politics", 15);
        pages[16] = new WebPage("Political Philosophy", 16);
        pages[17] = new WebPage("Inception", 17);
        pages[18] = new WebPage("Christopher Nolan", 18);
        pages[19] = new WebPage("Cinema", 19);
        pages[20] = new WebPage("Film Studies", 20);
        pages[21] = new WebPage("Film Criticism", 21);
        pages[22] = new WebPage("Democracy", 22);
        pages[23] = new WebPage("Government Types", 23);
        pages[24] = new WebPage("Philosophy", 24);
        
        pages[0].addLink(pages[1]);
        pages[0].addLink(pages[2]);
        pages[0].addLink(pages[3]);
        
        pages[1].addLink(pages[0]);
        pages[1].addLink(pages[2]);
        pages[1].addLink(pages[3]);
        
        pages[2].addLink(pages[1]);
        pages[2].addLink(pages[3]);
        
        pages[3].addLink(pages[2]);
        pages[3].addLink(pages[4]);
        
        pages[4].addLink(pages[3]);
        pages[4].addLink(pages[10]);
        pages[4].addLink(pages[24]);
        
        pages[5].addLink(pages[6]);
        pages[5].addLink(pages[7]);
        pages[5].addLink(pages[10]);
        pages[5].addLink(pages[11]);
        
        pages[6].addLink(pages[7]);
        pages[6].addLink(pages[15]);
        pages[6].addLink(pages[16]);
        
        pages[7].addLink(pages[6]);
        pages[7].addLink(pages[8]);
        pages[7].addLink(pages[15]);
        pages[7].addLink(pages[22]);
        pages[7].addLink(pages[23]);
        
        pages[8].addLink(pages[9]);
        pages[8].addLink(pages[12]);
        pages[8].addLink(pages[15]);
        
        pages[9].addLink(pages[6]);
        pages[9].addLink(pages[15]);
        pages[9].addLink(pages[16]);
        pages[9].addLink(pages[22]);
        pages[9].addLink(pages[23]);
        
        pages[10].addLink(pages[3]);
        pages[10].addLink(pages[15]);
        pages[10].addLink(pages[16]);
        pages[10].addLink(pages[23]);
        pages[10].addLink(pages[24]);
        
        
        pages[11].addLink(pages[14]);
        pages[11].addLink(pages[15]);
        pages[11].addLink(pages[16]);
        pages[11].addLink(pages[23]);
        
        pages[12].addLink(pages[16]);
        
        pages[11].addLink(pages[6]);
        pages[11].addLink(pages[7]);
        pages[13].addLink(pages[11]);
        pages[13].addLink(pages[14]);
        
        pages[14].addLink(pages[15]);
        pages[14].addLink(pages[16]);
        pages[14].addLink(pages[22]);
        pages[14].addLink(pages[23]);
        
        pages[15].addLink(pages[6]);
        pages[15].addLink(pages[9]);
        pages[15].addLink(pages[10]);
        pages[15].addLink(pages[11]);
        pages[15].addLink(pages[16]);
        pages[15].addLink(pages[22]);
        pages[15].addLink(pages[23]);
        
        pages[16].addLink(pages[10]);
        pages[16].addLink(pages[11]);
        pages[16].addLink(pages[22]);
        pages[16].addLink(pages[23]);
        pages[16].addLink(pages[24]);
        
        pages[17].addLink(pages[18]);
        pages[17].addLink(pages[19]);
        
        pages[18].addLink(pages[17]);
        pages[18].addLink(pages[19]);
        
        pages[19].addLink(pages[20]);
        pages[19].addLink(pages[21]);
        
        pages[20].addLink(pages[19]);
        pages[20].addLink(pages[21]);
        
        pages[21].addLink(pages[19]);
        pages[21].addLink(pages[20]);
        pages[21].addLink(pages[24]);
        
        pages[22].addLink(pages[6]);
        pages[22].addLink(pages[7]);
        pages[22].addLink(pages[9]);
        pages[22].addLink(pages[23]);
        
        pages[23].addLink(pages[7]);
        pages[23].addLink(pages[10]);
        pages[23].addLink(pages[11]);
        pages[23].addLink(pages[15]);
        pages[23].addLink(pages[16]);
        pages[23].addLink(pages[22]);
        
        pages[24].addLink(pages[3]);
        pages[24].addLink(pages[4]);
        pages[24].addLink(pages[10]);
        pages[24].addLink(pages[12]);
        pages[24].addLink(pages[16]);
        pages[24].addLink(pages[21]);
        
        HyperLinkGraph<WebPage> graph = new HyperLinkGraph<>();
        for (WebPage p : pages) {
            try {   
                graph.addVertex(p);
            } catch (InvalidArgumentException ex) {
                Logger.getLogger(HyperLinkGraphSim.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
        
        for (WebPage p : pages) {
            for (WebPage l : p.getLinksTo()) {
                try {
                    graph.addEdge(p, l);
                } catch (EmptyCollectionException | InvalidArgumentException
                        | ElementNotFoundException ex) {
                    Logger.getLogger(HyperLinkGraphSim.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return graph;
    }
    
}
