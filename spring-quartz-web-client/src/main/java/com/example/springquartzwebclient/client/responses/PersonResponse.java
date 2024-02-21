package com.example.springquartzwebclient.client.responses;

import java.util.List;
import java.util.Objects;

public class PersonResponse {

    private final String name;
    private final String height;
    private final String mass;
    private final String hairColor;
    private final String skinColor;
    private final String eyeColor;
    private final String birthYear;
    private final String gender;
    private final String homeworld;
    private final List<String> films;
    private final List<String> species;
    private final List<String> vehicles;
    private final List<String> starships;
    private final String created;
    private final String edited;
    private final String url;

    public PersonResponse(String name, String height, String mass, String hairColor, String skinColor, String eyeColor, String birthYear, String gender, String homeworld, List<String> films, List<String> species, List<String> vehicles, List<String> starships, String created, String edited, String url) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hairColor = hairColor;
        this.skinColor = skinColor;
        this.eyeColor = eyeColor;
        this.birthYear = birthYear;
        this.gender = gender;
        this.homeworld = homeworld;
        this.films = films;
        this.species = species;
        this.vehicles = vehicles;
        this.starships = starships;
        this.created = created;
        this.edited = edited;
        this.url = url;
    }

    public String getName() {
        return this.name;
    }


    public String getHeight() {
        return this.height;
    }


    public String getMass() {
        return this.mass;
    }


    public String getHairColor() {
        return this.hairColor;
    }


    public String getSkinColor() {
        return this.skinColor;
    }


    public String getEyeColor() {
        return this.eyeColor;
    }


    public String getBirthYear() {
        return this.birthYear;
    }


    public String getGender() {
        return this.gender;
    }


    public String getHomeworld() {
        return this.homeworld;
    }


    public List<String> getFilms() {
        return this.films;
    }


    public List<String> getSpecies() {
        return this.species;
    }


    public List<String> getVehicles() {
        return this.vehicles;
    }


    public List<String> getStarships() {
        return this.starships;
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
        if (!(o instanceof PersonResponse)) {
            return false;
        }
        PersonResponse personResponse = (PersonResponse) o;
        return Objects.equals(name, personResponse.name) && Objects.equals(height, personResponse.height) && Objects.equals(mass, personResponse.mass) && Objects.equals(hairColor, personResponse.hairColor) && Objects.equals(skinColor, personResponse.skinColor) && Objects.equals(eyeColor, personResponse.eyeColor) && Objects.equals(birthYear, personResponse.birthYear) && Objects.equals(gender, personResponse.gender) && Objects.equals(homeworld, personResponse.homeworld) && Objects.equals(films, personResponse.films) && Objects.equals(species, personResponse.species) && Objects.equals(vehicles, personResponse.vehicles) && Objects.equals(starships, personResponse.starships) && Objects.equals(created, personResponse.created) && Objects.equals(edited, personResponse.edited) && Objects.equals(url, personResponse.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, height, mass, hairColor, skinColor, eyeColor, birthYear, gender, homeworld, films, species, vehicles, starships, created, edited, url);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", height='" + getHeight() + "'" +
            ", mass='" + getMass() + "'" +
            ", hairColor='" + getHairColor() + "'" +
            ", skinColor='" + getSkinColor() + "'" +
            ", eyeColor='" + getEyeColor() + "'" +
            ", birthYear='" + getBirthYear() + "'" +
            ", gender='" + getGender() + "'" +
            ", homeworld='" + getHomeworld() + "'" +
            ", films='" + getFilms() + "'" +
            ", species='" + getSpecies() + "'" +
            ", vehicles='" + getVehicles() + "'" +
            ", starships='" + getStarships() + "'" +
            ", created='" + getCreated() + "'" +
            ", edited='" + getEdited() + "'" +
            ", url='" + getUrl() + "'" +
            "}";
    }


}
