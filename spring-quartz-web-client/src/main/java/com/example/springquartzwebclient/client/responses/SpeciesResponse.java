package com.example.springquartzwebclient.client.responses;

import java.util.List;
import java.util.Objects;

public class SpeciesResponse {
    
    private final String name;
    private final String classification;
    private final String designation;
    private final String averageHeight;
    private final String averageLifespan;
    private final String language;
    private final List<String> films;
    private final List<String> people;
    private final String created;
    private final String edited;
    private final String url;

    public SpeciesResponse(String name, String classification, String designation, String averageHeight, String averageLifespan, String language, List<String> films, List<String> people, String created, String edited, String url) {
        this.name = name;
        this.classification = classification;
        this.designation = designation;
        this.averageHeight = averageHeight;
        this.averageLifespan = averageLifespan;
        this.language = language;
        this.films = films;
        this.people = people;
        this.created = created;
        this.edited = edited;
        this.url = url;
    }

    public String getName() {
        return this.name;
    }


    public String getClassification() {
        return this.classification;
    }


    public String getDesignation() {
        return this.designation;
    }


    public String getAverageHeight() {
        return this.averageHeight;
    }


    public String getAverageLifespan() {
        return this.averageLifespan;
    }


    public String getLanguage() {
        return this.language;
    }


    public List<String> getFilms() {
        return this.films;
    }


    public List<String> getPeople() {
        return this.people;
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
        if (!(o instanceof SpeciesResponse)) {
            return false;
        }
        SpeciesResponse speciesResponse = (SpeciesResponse) o;
        return Objects.equals(name, speciesResponse.name) && Objects.equals(classification, speciesResponse.classification) && Objects.equals(designation, speciesResponse.designation) && Objects.equals(averageHeight, speciesResponse.averageHeight) && Objects.equals(averageLifespan, speciesResponse.averageLifespan) && Objects.equals(language, speciesResponse.language) && Objects.equals(films, speciesResponse.films) && Objects.equals(people, speciesResponse.people) && Objects.equals(created, speciesResponse.created) && Objects.equals(edited, speciesResponse.edited) && Objects.equals(url, speciesResponse.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, classification, designation, averageHeight, averageLifespan, language, films, people, created, edited, url);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", classification='" + getClassification() + "'" +
            ", designation='" + getDesignation() + "'" +
            ", averageHeight='" + getAverageHeight() + "'" +
            ", averageLifespan='" + getAverageLifespan() + "'" +
            ", language='" + getLanguage() + "'" +
            ", films='" + getFilms() + "'" +
            ", people='" + getPeople() + "'" +
            ", created='" + getCreated() + "'" +
            ", edited='" + getEdited() + "'" +
            ", url='" + getUrl() + "'" +
            "}";
    }

}
