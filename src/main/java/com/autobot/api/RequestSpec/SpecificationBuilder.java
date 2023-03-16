package com.autobot.api.RequestSpec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecificationBuilder {

    public RequestSpecification getRequestSpecification(String uri){
        return new RequestSpecBuilder()
                .setBaseUri(uri)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

    }

    public ResponseSpecification getResponseSpecification(){
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }
}
