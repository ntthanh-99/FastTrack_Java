package com.thanhnt.coffee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "coffee")
public class Coffee {
    @Id
    private int id;
    private String title;
    private String description;
    private String[] ingredients;
    private String image;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return id == coffee.id && Objects.equals(title, coffee.title) && Objects.equals(description, coffee.description) && Objects.deepEquals(ingredients, coffee.ingredients) && Objects.equals(image, coffee.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, Arrays.hashCode(ingredients), image);
    }
}
