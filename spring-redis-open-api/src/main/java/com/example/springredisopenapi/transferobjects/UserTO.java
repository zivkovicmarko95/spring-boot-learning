package com.example.springredisopenapi.transferobjects;

import java.util.Set;

import com.example.springredisopenapi.enums.GenderEnum;

public record UserTO(String id, String name, String email, GenderEnum gender,
    Set<String> groupIds) {
    
}
