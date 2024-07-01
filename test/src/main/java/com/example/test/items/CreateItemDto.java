package com.example.test.items;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateItemDto {

    @NotBlank(message = "Name is required")
    @Size(max = 30, message = "Name cannot be over 30 characters")
    private String name;

    @NotBlank(message = "Description is required")
    @Size(max = 300, message = "Description cannot be over 300 characters")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
