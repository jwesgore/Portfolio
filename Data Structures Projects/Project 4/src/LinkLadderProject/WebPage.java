package LinkLadderProject;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * WebPage class simulates the info that would be scraped from a page for
 * a hyperlink graph.
 * @author Brian Thompson
 * @version 18/4/2018
 */
public class WebPage implements Comparable<WebPage> {
    private String pageName;
    private int pageId;
    private ArrayList<WebPage> linksTo;

    public WebPage(String pageName, int pageId) {
        this.pageName = pageName;
        this.pageId = pageId;
        this.linksTo = new ArrayList<>();
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public ArrayList<WebPage> getLinksTo() {
        return linksTo;
    }

    public void setLinksTo(ArrayList<WebPage> linksTo) {
        this.linksTo = linksTo;
    }
    
    public void addLink(WebPage p) {
        this.linksTo.add(p);
    }
    
    public void removeLink(WebPage p) {
        this.linksTo.remove(p);
    }
    
    @Override
    public int compareTo(WebPage o) {
         return this.pageId - o.getPageId();
    }
    
    public boolean equals(Object other) {
        if (other == null) return false;
        if (!(other instanceof WebPage)) return false;
        WebPage o = (WebPage) other;
        return this.compareTo(o) == 0;
    }

    @Override
    public String toString() {
        return "WebPage{" + "pageName=" + pageName + ", pageId=" + pageId + '}';
    }

    
    
    
    
    
    
    
    
}
