package client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.shine.his.usrcenter.pojo.User;

/**
 * Created by claude on 15-6-3.
 */
public class ClientTest {
    private static String serverUri = "http://localhost:8080/";

    private static void updateStu() {
        User user = new User();
        user.setId(9999);
        user.setName("S  TU999");
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(serverUri + "/update");
        String s = null;
        s = JSON.toJSONString(user);
        Response response = target.request().buildPost(Entity.entity(s, MediaType.APPLICATION_JSON)).invoke();
        System.out.print(response.getStatus());
        response.close();
    }

        public static void deleteStu(){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(serverUri + "/delete/STU999");
        Response response = target.request().delete();
        System.out.print(response.getStatus());
        response.close();
    }

    public void addUser() {
        User user = new User();
        user.setName("STU999");
        user.setEmail(user.getName() + "@163.com");
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(serverUri + "users/newUser");
        String s = null;
        s = JSON.toJSONString(user);
        Response response = target.request().buildPut(Entity.entity(s, MediaType.APPLICATION_JSON)).invoke();
        System.out.print(response.getStatus());
        response.close();
    }
    @Test
    public void test(){
         Client client = ClientBuilder.newClient();
         WebTarget target = client.target("http://localhost:8080/ShineHIS/storeDrugMaster/insertInStoreDrug");
         String s = "";
         Response response = target.request().buildPut(Entity.entity(s, MediaType.APPLICATION_JSON)).invoke();
         System.out.print(response.getStatus());
         response.close();
    }
}