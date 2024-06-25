package com.crudapi.mongodb;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
//mongodb database
@Document(collection="customer")

public class Customer {

    @Id
    private String id;
    private String first_name;
    private String last_name;
    private String email;
    private String address;

    @Override
    public String toString() {
        return "Customer{" +
                "address='" + address + '\'' +
                ", ID=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}