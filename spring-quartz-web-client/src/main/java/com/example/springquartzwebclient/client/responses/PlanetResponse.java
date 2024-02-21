package com.example.springquartzwebclient.client.responses;

import java.util.List;
import java.util.Objects;

public class PlanetResponse {
    
    private final String name;
    private final String rotationPeriod;
    private final String orbitalPeriod;
    private final String diameter;
    private final String climate;
    private final String gravity;
    private final String terrain;
    private final String surfaceWater;
    private final String population;
    private final List<String> residents;
    private final List<String> films;
    private final String created;
    private final String edited;
    private final String url;

    public PlanetResponse(String name, String rotationPeriod, String orbitalPeriod, String diameter, String climate, String gravity, String terrain, String surfaceWater, String population, List<String> residents, List<String> films, String created, String edited, String url) {
        this.name = name;
        this.rotationPeriod = rotationPeriod;
        this.orbitalPeriod = orbitalPeriod;
        this.diameter = diameter;
        this.climate = climate;
        this.gravity = gravity;
        this.terrain = terrain;
        this.surfaceWater = surfaceWater;
        this.population = population;
        this.residents = residents;
        this.films = films;
        this.created = created;
        this.edited = edited;
        this.url = url;
    }

    public String getName() {
        return this.name;
    }


    public String getRotationPeriod() {
        return this.rotationPeriod;
    }


    public String getOrbitalPeriod() {
        return this.orbitalPeriod;
    }


    public String getDiameter() {
        return this.diameter;
    }


    public String getClimate() {
        return this.climate;
    }


    public String getGravity() {
        return this.gravity;
    }


    public String getTerrain() {
        return this.terrain;
    }


    public String getSurfaceWater() {
        return this.surfaceWater;
    }


    public String getPopulation() {
        return this.population;
    }


    public List<String> getResidents() {
        return this.residents;
    }


    public List<String> getFilms() {
        return this.films;
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
        if (!(o instanceof PlanetResponse)) {
            return false;
        }
        PlanetResponse planetResponse = (PlanetResponse) o;
        return Objects.equals(name, planetResponse.name) && Objects.equals(rotationPeriod, planetResponse.rotationPeriod) && Objects.equals(orbitalPeriod, planetResponse.orbitalPeriod) && Objects.equals(diameter, planetResponse.diameter) && Objects.equals(climate, planetResponse.climate) && Objects.equals(gravity, planetResponse.gravity) && Objects.equals(terrain, planetResponse.terrain) && Objects.equals(surfaceWater, planetResponse.surfaceWater) && Objects.equals(population, planetResponse.population) && Objects.equals(residents, planetResponse.residents) && Objects.equals(films, planetResponse.films) && Objects.equals(created, planetResponse.created) && Objects.equals(edited, planetResponse.edited) && Objects.equals(url, planetResponse.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rotationPeriod, orbitalPeriod, diameter, climate, gravity, terrain, surfaceWater, population, residents, films, created, edited, url);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", rotationPeriod='" + getRotationPeriod() + "'" +
            ", orbitalPeriod='" + getOrbitalPeriod() + "'" +
            ", diameter='" + getDiameter() + "'" +
            ", climate='" + getClimate() + "'" +
            ", gravity='" + getGravity() + "'" +
            ", terrain='" + getTerrain() + "'" +
            ", surfaceWater='" + getSurfaceWater() + "'" +
            ", population='" + getPopulation() + "'" +
            ", residents='" + getResidents() + "'" +
            ", films='" + getFilms() + "'" +
            ", created='" + getCreated() + "'" +
            ", edited='" + getEdited() + "'" +
            ", url='" + getUrl() + "'" +
            "}";
    }

}
