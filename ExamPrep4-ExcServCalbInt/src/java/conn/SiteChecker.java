/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conn;

import entity.Group;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author Bancho
 */
public class SiteChecker {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        SiteChecker sc = new SiteChecker();
        //ArrayList<Group> groups = sc.getAllGroupsInfo();
        for (Group group : sc.getAllGroupsInfo()) {
            System.out.println(group.toString());
        }
    }

    public ArrayList<Group> getAllGroupsInfo() throws InterruptedException, ExecutionException {

        List<String> urls = new ArrayList<String>() {
            {

                //Class A
                add("http://cphbusinessjb.cloudapp.net/CA2/");
                add("http://ca2-ebski.rhcloud.com/CA2New/");
                add("http://ca2-chrislind.rhcloud.com/CA2Final/");
                add("http://ca2-pernille.rhcloud.com/NYCA2/");
                add("https://ca2-jonasrafn.rhcloud.com:8443/company.jsp");
                add("http://ca2javathehutt-smcphbusiness.rhcloud.com/ca2/index.jsp");

                //Class B
                add("https://ca2-ssteinaa.rhcloud.com/CA2/");
                add("http://tomcat-nharbo.rhcloud.com/CA2/");
                add("https://ca2-cphol24.rhcloud.com/3.semCa.2/");
                add("https://ca2-ksw.rhcloud.com/DeGuleSider/");
                add("http://ca2-ab207.rhcloud.com/CA2/index.html");
                add("http://ca2-sindt.rhcloud.com/CA2/index.jsp");
                add("http://ca2gruppe8-tocvfan.rhcloud.com/");
                add("https://ca-ichti.rhcloud.com/CA2/");

                //Class COS
                add("https://ca2-9fitteen.rhcloud.com:8443/CA2/");
                add("https://cagroup04-coolnerds.rhcloud.com/CA_v1/index.html");
                add("http://catwo-2ndsemester.rhcloud.com/CA2/");
            }
        };

        ExecutorService executor = Executors.newCachedThreadPool();
        ArrayList<Future> futures = new ArrayList<Future>();
        ArrayList<Group> groups = new ArrayList<Group>();

        for (String url : urls) {
            Callable<Group> task = new WebConnector(url);
            futures.add(executor.submit(task));
        }
        
        executor.shutdown();
        
        for (Future future : futures) {
            try{
                groups.add((Group) future.get());
            }catch(java.util.concurrent.ExecutionException ex){
                //nothing
            }
        }
        
        return groups;
    }

}
