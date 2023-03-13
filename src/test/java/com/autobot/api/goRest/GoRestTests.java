package com.autobot.api.goRest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

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
       given(requestSpecification)
               .when().get("/public/v2/users")
               .then().spec(responseSpecification)
               .assertThat().statusCode(HttpStatus.SC_OK);


    }


}
