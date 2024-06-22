This application is used as configuration server

- If the configurations is required to be accessed, it can be done through this endpoint and you can see the values of properties:
    GET localhost:8080/application/default

- If you want to update all the clients, you have to access busrefresh endpoint:
    POST localhost:8080/actuator/busrefresh

The configuration will be automatically pulled down from all the subscribed clients when the busrefresh endpoint is accessed.