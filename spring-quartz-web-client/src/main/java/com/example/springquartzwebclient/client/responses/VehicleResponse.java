package com.example.springquartzwebclient.client.responses;

import java.util.List;
import java.util.Objects;

public class VehicleResponse {
    
    private final String name;
    private final String model;
    private final String manufacturer;
    private final String costInCredits;
    private final String length;
    private final String maxAtmospheringSpeed;
    private final String crew;
    private final String passengers;
    private final String cargoCapacity;
    private final String consumables;
    private final List<String> films;
    private final List<String> pilots;
    private final String vehicleClass;
    private final String created;
    private final String edited;
    private final String url;

    public VehicleResponse(String name, String model, String manufacturer, String costInCredits, String length, String maxAtmospheringSpeed, String crew, String passengers, String cargoCapacity, String consumables, List<String> films, List<String> pilots, String vehicleClass, String created, String edited, String url) {
        this.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
        this.costInCredits = costInCredits;
        this.length = length;
        this.maxAtmospheringSpeed = maxAtmospheringSpeed;
        this.crew = crew;
        this.passengers = passengers;
        this.cargoCapacity = cargoCapacity;
        this.consumables = consumables;
        this.films = films;
        this.pilots = pilots;
        this.vehicleClass = vehicleClass;
        this.created = created;
        this.edited = edited;
        this.url = url;
    }

    public String getName() {
        return this.name;
    }


    public String getModel() {
        return this.model;
    }


    public String getManufacturer() {
        return this.manufacturer;
    }


    public String getCostInCredits() {
        return this.costInCredits;
    }


    public String getLength() {
        return this.length;
    }


    public String getMaxAtmospheringSpeed() {
        return this.maxAtmospheringSpeed;
    }


    public String getCrew() {
        return this.crew;
    }


    public String getPassengers() {
        return this.passengers;
    }


    public String getCargoCapacity() {
        return this.cargoCapacity;
    }


    public String getConsumables() {
        return this.consumables;
    }


    public List<String> getFilms() {
        return this.films;
    }


    public List<String> getPilots() {
        return this.pilots;
    }


    public String getVehicleClass() {
        return this.vehicleClass;
    }


    public String getCreated() {
        return this.created;
    }


    public String getEdited() {
        return this.edited;
    }


    public String getUrl() {
        return this.url;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof VehicleResponse)) {
            return false;
        }
        VehicleResponse vehicleResponse = (VehicleResponse) o;
        return Objects.equals(name, vehicleResponse.name) && Objects.equals(model, vehicleResponse.model) && Objects.equals(manufacturer, vehicleResponse.manufacturer) && Objects.equals(costInCredits, vehicleResponse.costInCredits) && Objects.equals(length, vehicleResponse.length) && Objects.equals(maxAtmospheringSpeed, vehicleResponse.maxAtmospheringSpeed) && Objects.equals(crew, vehicleResponse.crew) && Objects.equals(passengers, vehicleResponse.passengers) && Objects.equals(cargoCapacity, vehicleResponse.cargoCapacity) && Objects.equals(consumables, vehicleResponse.consumables) && Objects.equals(films, vehicleResponse.films) && Objects.equals(pilots, vehicleResponse.pilots) && Objects.equals(vehicleClass, vehicleResponse.vehicleClass) && Objects.equals(created, vehicleResponse.created) && Objects.equals(edited, vehicleResponse.edited) && Objects.equals(url, vehicleResponse.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, model, manufacturer, costInCredits, length, maxAtmospheringSpeed, crew, passengers, cargoCapacity, consumables, films, pilots, vehicleClass, created, edited, url);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", model='" + getModel() + "'" +
            ", manufacturer='" + getManufacturer() + "'" +
            ", costInCredits='" + getCostInCredits() + "'" +
            ", length='" + getLength() + "'" +
            ", maxAtmospheringSpeed='" + getMaxAtmospheringSpeed() + "'" +
            ", crew='" + getCrew() + "'" +
            ", passengers='" + getPassengers() + "'" +
            ", cargoCapacity='" + getCargoCapacity() + "'" +
            ", consumables='" + getConsumables() + "'" +
            ", films='" + getFilms() + "'" +
            ", pilots='" + getPilots() + "'" +
            ", vehicleClass='" + getVehicleClass() + "'" +
            ", created='" + getCreated() + "'" +
            ", edited='" + getEdited() + "'" +
            ", url='" + getUrl() + "'" +
            "}";
    }
    

}
