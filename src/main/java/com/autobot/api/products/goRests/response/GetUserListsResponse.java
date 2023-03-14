package com.autobot.api.products.goRests.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.assertj.core.api.SoftAssertions;
import org.testng.asserts.SoftAssert;

@Getter
@Setter
@Builder
public class GetUserListsResponse {

        public int id;
        public String name;
        public String email;
        public String gender;
        public String status;

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

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

        public void AssertBodyResult(){
                SoftAssertions soft= new SoftAssertions();
                soft.assertThat(getId()).isNotNull();
        }
}
