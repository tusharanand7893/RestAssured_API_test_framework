package com.autobot.api.RequestSpec;

import com.autobot.api.constants.RequestType;
import com.google.inject.Inject;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import java.util.List;
import java.util.Map;

import static com.autobot.api.constants.RequestType.*;
import static io.restassured.RestAssured.given;

public class Requests {

     SpecificationBuilder specificationBuilder= new SpecificationBuilder();
    public Response getRequest(String baseUri,String requestPath, Map<String,Object> m){
        return given(specificationBuilder.getRequestSpecification(baseUri))
                .headers(m)
                .when().get(requestPath)
                .then().spec(specificationBuilder.getResponseSpecification())
                .extract()
                .response();
    }

    public Response postRequest(String baseUri,String requestPath, Object payload, Map<String,Object> m){
        return given(specificationBuilder.getRequestSpecification(baseUri))
                .headers(m)
                .when()
                .body(payload)
                .post(requestPath)
                .then().spec(specificationBuilder.getResponseSpecification())
                .extract()
                .response();
    }


 /*   public Response createRequest(String requestPath, Object payload, RequestType requestType){
        Response res;
        SpecificationBuilder specificationBuilder = new SpecificationBuilder();
        given().when();
        switch (requestType){
            case GET ->
                    res= given(specificationBuilder.getRequestSpecification())
                            .when().get(requestPath);
            case POST ->
                    given(specificationBuilder.getRequestSpecification())
                    .when()
                    .body(payload)
                    .post(requestPath)
        }
        case {
           res= given(specificationBuilder.getRequestSpecification())
                    .when().get(requestPath);
        }
        return given(specificationBuilder.getRequestSpecification())
                .when()
                .body(payload)
                .post(requestPath)
                .then().spec(specificationBuilder.getResponseSpecification())
                .extract()
                .response();
    }*/
}
