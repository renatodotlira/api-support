package com.support.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Builder
@Getter
@Setter
@Document(collection = "person")
public class Person{

    @Id
    private String id = UUID.randomUUID().toString();

    private String name;

}
