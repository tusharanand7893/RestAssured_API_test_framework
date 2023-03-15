package com.autobot.api.goRest;

import com.autobot.api.products.goRests.endpoints.GoRestClient;
import com.autobot.api.products.goRests.payload.CreateUserPayload;
import com.autobot.api.products.goRests.response.GetUserListsResponse;
import com.google.inject.Inject;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Test
public class GoRestTests {


    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    String access_token="c354630aece27980ca0f7033d621b0d05a5a7c4d7cf552498593df652169096e";

    @BeforeClass
    public void beforeClass(){
        RequestSpecBuilder requestSpecBuilder= new RequestSpecBuilder()
                .setBaseUri("https://gorest.co.in")
                .setBasePath("")
                .addHeader("Authorization","Bearer "+access_token)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL);
        requestSpecification=requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder= new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .log(LogDetail.ALL);
        responseSpecification=responseSpecBuilder.build();
    }

    @Test
    public void validateGetUserLists(){
        GoRestClient goRestClient=new GoRestClient();
        List<GetUserListsResponse> getUserListsResponses=goRestClient.getUserList().body().jsonPath().getList("", GetUserListsResponse.class);
        System.out.println("printed++ "+getUserListsResponses);
        for(GetUserListsResponse userList: getUserListsResponses){
            System.out.println(userList.getName());
            userList.AssertBodyResult();
        }

    }

    @Test
    public void validateGetUserLists1(){
        GetUserListsResponse getUserListsResponseList= given(requestSpecification)
                .when().get("/public/v2/users")
                .then().spec(responseSpecification)
                .assertThat().statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .as(GetUserListsResponse.class);

    }

    @Test
    public void validateCreateUserLists(){
        CreateUserPayload createUserPayload=new CreateUserPayload();
              createUserPayload.setName("Tenali");
              createUserPayload.setEmail("tenali.ramakrishna@15ce.com");
              createUserPayload.setStatus("active");
              createUserPayload.setGender("male");
        given(requestSpecification)
                .when()
                .body(createUserPayload)
                .post("/public/v2/users")
                .then().spec(responseSpecification)
                .assertThat()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY)
                .body("field",equalTo("email"),"message",equalTo("has already been taken"));


    }

    @Test
    public void validateCreateUserLists1(){
        CreateUserPayload createUserPayload=new CreateUserPayload();
        createUserPayload.setName("Tenali");
        createUserPayload.setEmail("tenali.ramakrishna@15ce.com");
        createUserPayload.setStatus("active");
        createUserPayload.setGender("male");
        GoRestClient goRestClient=new GoRestClient();
        Response response= goRestClient.postUserLists(createUserPayload);
        System.out.println(response.toString());


    }


}
