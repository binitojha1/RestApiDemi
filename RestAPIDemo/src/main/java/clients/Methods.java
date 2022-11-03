package clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.ReqResPojo;
import testBase.TestBase;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class Methods extends TestBase {

    RequestSpecification reqSpf = RestAssured.given().log().all();

    public Response postRequest(ReqResPojo payLoad) {

        reqSpf.baseUri(properties.getProperty("baseURI"));
        reqSpf.basePath(properties.getProperty("basePath"));
        reqSpf.contentType(ContentType.JSON);
        reqSpf.body(payLoad);
        Response res = reqSpf.post();
return res;

    }


    public Response getRequest(String userID){
      //  RequestSpecification reqSpf = RestAssured.given().log().all();
        reqSpf.baseUri(properties.getProperty("baseURI"));
        reqSpf.basePath(properties.getProperty("basePath")+userID);
        reqSpf.contentType(ContentType.JSON).log().all();
        return reqSpf.get();

    }

    public Response deleteRequest(String userID){
       // RequestSpecification reqSpf = RestAssured.given().log().all();
        reqSpf.baseUri(properties.getProperty("baseURI"));
        reqSpf.basePath(properties.getProperty("basePath")+userID);
        reqSpf.contentType(ContentType.JSON);
        return reqSpf.delete();
    }

}
