package web;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * StoreCheck Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>七月 20, 2015</pre>
 */
public class StoreCheckTest {
    private static String serverUri = "http://localhost:8080/";

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: newStoreCheck(String strJson)
     */
    @Test
    public void testNewStoreCheck() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: newCheckNo()
     */
    @Test
    public void testNewCheckNo() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(serverUri + "/newCheckNo");
        Response response = target.request().buildGet().invoke();
        System.out.print(response.getStatus());
        System.out.println(response.getEntity());
        response.close();
    }


} 
