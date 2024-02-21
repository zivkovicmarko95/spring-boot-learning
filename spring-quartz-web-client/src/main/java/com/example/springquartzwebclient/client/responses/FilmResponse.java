package com.example.springquartzwebclient.client.responses;

import java.util.List;
import java.util.Objects;

public class FilmResponse {

    private final String title;
    private final String episodeId;
    private final String openingCrawl;
    private final String director;
    private final String producer;
    private final String releaseDate;
    private final List<String> characters;
    private final List<String> planets;
    private final List<String> starships;
    private final List<String> vehicles;
    private final List<String> species;
    private final String created;
    private final String edited;
    private final String url;

    public FilmResponse(String title, String episodeId, String openingCrawl, String director, String producer, String releaseDate, List<String> characters, List<String> planets, List<String> starships, List<String> vehicles, List<String> species, String created, String edited, String url) {
        this.title = title;
        this.episodeId = episodeId;
        this.openingCrawl = openingCrawl;
        this.director = director;
        this.producer = producer;
        this.releaseDate = releaseDate;
        this.characters = characters;
        this.planets = planets;
        this.starships = starships;
        this.vehicles = vehicles;
        this.species = species;
        this.created = created;
        this.edited = edited;
        this.url = url;
    }

    public String getTitle() {
        return this.title;
    }


    public String getEpisodeId() {
        return this.episodeId;
    }


    public String getOpeningCrawl() {
        return this.openingCrawl;
    }


    public String getDirector() {
        return this.director;
    }


    public String getProducer() {
        return this.producer;
    }


    public String getReleaseDate() {
        return this.releaseDate;
    }


    public List<String> getCharacters() {
        return this.characters;
    }


    public List<String> getPlanets() {
        return this.planets;
    }


    public List<String> getStarships() {
        return this.starships;
    }


    public List<String> getVehicles() {
        return this.vehicles;
    }


    public List<String> getSpecies() {
        return this.species;
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
        if (!(o instanceof FilmResponse)) {
            return false;
        }
        FilmResponse filmResponse = (FilmResponse) o;
        return Objects.equals(title, filmResponse.title) && Objects.equals(episodeId, filmResponse.episodeId) && Objects.equals(openingCrawl, filmResponse.openingCrawl) && Objects.equals(director, filmResponse.director) && Objects.equals(producer, filmResponse.producer) && Objects.equals(releaseDate, filmResponse.releaseDate) && Objects.equals(characters, filmResponse.characters) && Objects.equals(planets, filmResponse.planets) && Objects.equals(starships, filmResponse.starships) && Objects.equals(vehicles, filmResponse.vehicles) && Objects.equals(species, filmResponse.species) && Objects.equals(created, filmResponse.created) && Objects.equals(edited, filmResponse.edited) && Objects.equals(url, filmResponse.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, episodeId, openingCrawl, director, producer, releaseDate, characters, planets, starships, vehicles, species, created, edited, url);
    }

    @Override
    public String toString() {
        return "{" +
            " title='" + getTitle() + "'" +
            ", episodeId='" + getEpisodeId() + "'" +
            ", openingCrawl='" + getOpeningCrawl() + "'" +
            ", director='" + getDirector() + "'" +
            ", producer='" + getProducer() + "'" +
            ", releaseDate='" + getReleaseDate() + "'" +
            ", characters='" + getCharacters() + "'" +
            ", planets='" + getPlanets() + "'" +
            ", starships='" + getStarships() + "'" +
            ", vehicles='" + getVehicles() + "'" +
            ", species='" + getSpecies() + "'" +
            ", created='" + getCreated() + "'" +
            ", edited='" + getEdited() + "'" +
            ", url='" + getUrl() + "'" +
            "}";
    }


}
