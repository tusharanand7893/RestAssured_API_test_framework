package com.autobot.api.products.goRests.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserPayload {
    public String name;
    public String email;
    public String gender;
    public String status;

public CreateUserPayload createUserPayload(String name,String email,String gender,String status){
    return CreateUserPayload.builder()
            .name(name)
            .email(email)
            .status(status)
            .gender(gender)
            .build();
}



}
