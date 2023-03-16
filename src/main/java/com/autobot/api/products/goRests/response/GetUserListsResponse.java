package com.autobot.api.products.goRests.response;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.assertj.core.api.SoftAssertions;

@Getter
@Setter
public class GetUserListsResponse {

        public int id;
        public String name;
        public String email;
        public String gender;
        public String status;

        public void AssertBodyResult(){
                SoftAssertions soft= new SoftAssertions();
              soft.assertThat(getId()).isNotNull();
        }
}
