package test1;

import com.relevantcodes.extentreports.LogStatus;
import extentsReports.ExtentManager;

import java.net.http.WebSocket.Listener;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import clients.Methods;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import listeners.Listeners;
import models.ReqResPojo;
import testBase.TestBase;
import utils.SendEmail;

public class DemoTest extends TestBase{

   // ExtentManager extentManager;
    TestBase testbase;
    Methods methods;
    ReqResPojo postPayLoad;
    JsonPath jp;
    String id;
    SendEmail sendEmail;
    Listeners listeners;

    @BeforeClass
    public void initialization() {
       // testbase = new TestBase();
        methods = new Methods();
        //extentManager = new ExtentManager();
        listeners = new Listeners();
        listeners.startExtent();
        sendEmail = new SendEmail();
        postPayLoad = ReqResPojo.builder().name("Binit").job("sdet").build();
    }

    @Test(priority = 1,description = "postRequest")
    public void postRequest() {
        
        Response response = methods.postRequest(postPayLoad);
        System.out.println(response.body());
        ReqResPojo responsePojo = new Gson().fromJson(response.body().asString(), ReqResPojo.class);
            response.then().assertThat().statusCode(201);
            Assert.assertEquals(responsePojo.getName(), postPayLoad.getName());
            Assert.assertEquals(responsePojo.getJob(), postPayLoad.getJob());
            Assert.assertTrue(responsePojo.getId()!=null);
            id = responsePojo.getId();

    }

    @Test(priority = 2,description = "getRequest")
    public void getRequest() {
        Response response = methods.getRequest(id);
            ReqResPojo responsePojo = new Gson().fromJson(response.body().asString(), ReqResPojo.class);
            response.then().assertThat().statusCode(200);
            Assert.assertEquals(responsePojo.getName(), postPayLoad.getName());
            Assert.assertEquals(responsePojo.getJob(), postPayLoad.getJob());
            Assert.assertEquals(responsePojo.getId(), id);
            Assert.assertTrue(responsePojo.getCreatedAt() != null);


    }


     @Test(priority = 3,description = "deleteRequest")
     public void deleteRequest(){
             Response response = methods.deleteRequest(id);
             Assert.assertEquals(response.getStatusCode(), "204");
    }

    @AfterClass
    public void tearDown(){
        System.out.println("In teardown");
        listeners.endExtent();
        //extentManager.extent.flush();
       // sendEmail.sendMail(extentManager.CurrentDate);
    }
}
