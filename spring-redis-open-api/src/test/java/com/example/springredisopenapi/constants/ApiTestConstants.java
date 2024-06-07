package com.example.springredisopenapi.constants;

public final class ApiTestConstants {
    
    private ApiTestConstants() {

    }

    public static final String API_V1 = "/api/v1";

    public static final String USERS = API_V1 + "/users";
    public static final String USERS_WITH_ID = USERS + "/{userId}";

}
