package com.autobot.api.products.goRests.endpoints;

import com.autobot.api.RequestSpec.SpecBuilder;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class goRestClient {


    public Response getUserList(){
        SpecBuilder specBuilder= new SpecBuilder();
        return given(specBuilder.getRequestSpecification())
                .when()
                .body("")
                .get()
                .then()
                .spec(specBuilder.getResponseSpecification())
                .extract().response();
    }
}



public e