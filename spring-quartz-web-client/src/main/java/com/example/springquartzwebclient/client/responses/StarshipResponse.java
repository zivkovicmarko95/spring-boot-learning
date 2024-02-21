package com.example.springquartzwebclient.client.responses;

import java.util.List;
import java.util.Objects;

public class StarshipResponse {
    
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
    private final String hyperdriveRating;
    private final String MGLT;
    private final String starshipClass;
    private final String created;
    private final String edited;
    private final String url;

    public StarshipResponse(String name, String model, String manufacturer, String costInCredits, String length, String maxAtmospheringSpeed, String crew, String passengers, String cargoCapacity, String consumables, List<String> films, List<String> pilots, String hyperdriveRating, String MGLT, String starshipClass, String created, String edited, String url) {
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
        this.hyperdriveRating = hyperdriveRating;
        this.MGLT = MGLT;
        this.starshipClass = starshipClass;
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


    public String getHyperdriveRating() {
        return this.hyperdriveRating;
    }


    public String getMGLT() {
        return this.MGLT;
    }


    public String getStarshipClass() {
        return this.starshipClass;
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
        if (!(o instanceof StarshipResponse)) {
            return false;
        }
        StarshipResponse starshipResponse = (StarshipResponse) o;
        return Objects.equals(name, starshipResponse.name) && Objects.equals(model, starshipResponse.model) && Objects.equals(manufacturer, starshipResponse.manufacturer) && Objects.equals(costInCredits, starshipResponse.costInCredits) && Objects.equals(length, starshipResponse.length) && Objects.equals(maxAtmospheringSpeed, starshipResponse.maxAtmospheringSpeed) && Objects.equals(crew, starshipResponse.crew) && Objects.equals(passengers, starshipResponse.passengers) && Objects.equals(cargoCapacity, starshipResponse.cargoCapacity) && Objects.equals(consumables, starshipResponse.consumables) && Objects.equals(films, starshipResponse.films) && Objects.equals(pilots, starshipResponse.pilots) && Objects.equals(hyperdriveRating, starshipResponse.hyperdriveRating) && Objects.equals(MGLT, starshipResponse.MGLT) && Objects.equals(starshipClass, starshipResponse.starshipClass) && Objects.equals(created, starshipResponse.created) && Objects.equals(edited, starshipResponse.edited) && Objects.equals(url, starshipResponse.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, model, manufacturer, costInCredits, length, maxAtmospheringSpeed, crew, passengers, cargoCapacity, consumables, films, pilots, hyperdriveRating, MGLT, starshipClass, created, edited, url);
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
            ", hyperdriveRating='" + getHyperdriveRating() + "'" +
            ", MGLT='" + getMGLT() + "'" +
            ", starshipClass='" + getStarshipClass() + "'" +
            ", created='" + getCreated() + "'" +
            ", edited='" + getEdited() + "'" +
            ", url='" + getUrl() + "'" +
            "}";
    }


}
