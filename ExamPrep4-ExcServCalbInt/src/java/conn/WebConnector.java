/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conn;

import entity.Group;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author Bancho
 */
public class WebConnector implements Callable<Group> {

    private final String url;
    
    public WebConnector(String url){
        this.url = url;
    }
    
    @Override
    public Group call() throws Exception {
        Document doc = Jsoup.connect(url).get();
        Group group = new Group();
        group.setAuthors(getAuthors(doc));
        group.setClass_(getClass_(doc));
        group.setGroupNum(getGroupNum(doc));
        group.setUrl(url);
        return group;
    }
    
    private ArrayList<String> getAuthors(Document doc){
        Elements elmAuthors = doc.select("#authors");
        String allAuthors = elmAuthors.text();
        String[] split = allAuthors.split(",");
        ArrayList<String> authors = new ArrayList<String>();
        for (String split1 : split) {
            authors.add(split1);
        }
        return authors;
    }
    
    private String getClass_(Document doc){
        Elements elmClass = doc.select("#class");
        return elmClass.text();
    }
    
    private String getGroupNum(Document doc){
        Elements elmGroupNum = doc.select("#group");
        return elmGroupNum.text();
    }
}
