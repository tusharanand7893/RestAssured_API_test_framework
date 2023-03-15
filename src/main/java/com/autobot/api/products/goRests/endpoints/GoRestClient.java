package com.autobot.api.products.goRests.endpoints;

import com.autobot.api.RequestSpec.Requests;
import com.autobot.api.RequestSpec.SpecificationBuilder;
import com.autobot.api.products.goRests.payload.CreateUserPayload;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class GoRestClient {


    public Response getUserList(){
        String endPointPath="/public/v2/users";
        Requests requests= new Requests();
        return requests.getRequest(endPointPath);
    }

    public Response postUserLists(CreateUserPayload createUserPayload){
        String endPointPath="/public/v2/users";
        Requests requests= new Requests();
        return requests.postRequest(endPointPath,createUserPayload);
    }
}



