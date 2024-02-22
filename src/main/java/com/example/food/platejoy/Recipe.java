package com.example.food.platejoy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "RecipeSharing")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    @Id
    private ObjectId id;
    private String name;
    private String cuisine;
    private String course;
    private String ingredients;
    private List<String> instructions;

    // constructors, getters, adn setter

    // constructors
//    public Recipe() {
//        //default constructor
//    }
//
//    public Recipe(String name, String ingredients, String instructions, String cuisine, String course) {
//        this.name = name;
//        this.cuisine = cuisine;
//        this.course
//
//    }
}
