package com.autobot.api.products.goRests.endpoints;

import com.autobot.api.RequestSpec.Requests;
import com.autobot.api.RequestSpec.SpecificationBuilder;
import com.autobot.api.modules.ConfigModule;
import com.autobot.api.products.goRests.payload.CreateUserPayload;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GoRestClient {
    Requests requests= new Requests();

    public Response getUserList(){

        Map<String, Object> headers= new HashMap<>();
        headers.put("Authorization","Bearer c354630aece27980ca0f7033d621b0d05a5a7c4d7cf552498593df652169096e");
        return requests.getRequest(EndpointRoutes.GO_REST_BASE_URI,EndpointRoutes.USER_LIST_PATH,headers);
    }

    public Response postUserLists(CreateUserPayload createUserPayload){
        Map<String, Object> headers= new HashMap<>();
        headers.put("Authorization","Bearer c354630aece27980ca0f7033d621b0d05a5a7c4d7cf552498593df652169096e");
        return requests.postRequest(ConfigModule.getInstance().getGoRestBaseURI(), EndpointRoutes.USER_LIST_PATH,createUserPayload,headers);
    }
}



