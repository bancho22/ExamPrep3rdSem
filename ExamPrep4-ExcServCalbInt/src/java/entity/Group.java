/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;

/**
 *
 * @author Bancho
 */
public class Group {
    
    private String groupNum, class_, url;
    private ArrayList<String> authors;

    public Group() {
    }
    
    
    public Group(String groupNum, String class_, ArrayList<String> authors, String url){
        this.groupNum = groupNum;
        this.class_ = class_;
        this.authors = authors;
        this.url = url;
    }

    public String getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(String groupNum) {
        this.groupNum = groupNum;
    }

    public String getClass_() {
        return class_;
    }

    public void setClass_(String class_) {
        this.class_ = class_;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        String theAuthors = "";
        for (String author : authors) {
            theAuthors += author + ", ";
        }
        theAuthors.substring(0, theAuthors.length() - 2);
        return "Group{" + "groupNum=" + groupNum + ", class_=" + class_ + ", authors=" + theAuthors + ", url=" + url + '}';
    }
    
    
    
}
