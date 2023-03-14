package com.autobot.api.products.goRests.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserPayload {
    public String name;
    public String email;
    public String gender;
    public String status;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
