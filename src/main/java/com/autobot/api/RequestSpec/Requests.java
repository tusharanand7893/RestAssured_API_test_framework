package com.autobot.api.RequestSpec;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Requests {

    public Response getRequest(String requestPath){
        SpecificationBuilder specificationBuilder = new SpecificationBuilder();
        return given(specificationBuilder.getRequestSpecification())
                .when().get(requestPath)
                .then().spec(specificationBuilder.getResponseSpecification())
                .extract()
                .response();
    }

    public Response postRequest(String requestPath, Object payload){
        SpecificationBuilder specificationBuilder = new SpecificationBuilder();
        return given(specificationBuilder.getRequestSpecification())
                .when()
                .body(payload)
                .post(requestPath)
                .then().spec(specificationBuilder.getResponseSpecification())
                .extract()
                .response();
    }
}
