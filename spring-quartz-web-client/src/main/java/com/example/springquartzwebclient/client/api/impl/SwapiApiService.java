package com.example.springquartzwebclient.client.api.impl;

import com.example.springquartzwebclient.client.api.SwapiApiClient;
import com.example.springquartzwebclient.client.responses.FilmResponse;
import com.example.springquartzwebclient.client.responses.PageSwapiResponse;
import com.example.springquartzwebclient.client.responses.PersonResponse;
import com.example.springquartzwebclient.client.responses.PlanetResponse;
import com.example.springquartzwebclient.client.responses.SpeciesResponse;
import com.example.springquartzwebclient.client.responses.StarshipResponse;
import com.example.springquartzwebclient.client.responses.VehicleResponse;

import org.springframework.stereotype.Service;

@Service
public class SwapiApiService implements SwapiApiClient {

    private final SwapiApiClient swapiApiClient;

    public SwapiApiService(final SwapiApiClient swapiApiClient) {
        this.swapiApiClient = swapiApiClient;
    }

    @Override
    public PersonResponse getPerson(final int id) {
        
        return this.swapiApiClient.getPerson(id);
    }

    @Override
    public PlanetResponse getPlanet(final int id) {
        
        return this.swapiApiClient.getPlanet(id);
    }

    @Override
    public FilmResponse getFilm(final int id) {
        
        return this.swapiApiClient.getFilm(id);
    }

    @Override
    public StarshipResponse getStarship(final int id) {
        
        return this.swapiApiClient.getStarship(id);
    }

    @Override
    public VehicleResponse getVehicle(final int id) {
        
        return this.swapiApiClient.getVehicle(id);
    }

    @Override
    public SpeciesResponse getSpecies(final int id) {
        
        return this.swapiApiClient.getSpecies(id);
    }

    @Override
    public PageSwapiResponse<PersonResponse> getAllPeople() {
        
        return this.swapiApiClient.getAllPeople();
    }

    @Override
    public PageSwapiResponse<PlanetResponse> getAllPlanets() {
        
        return this.swapiApiClient.getAllPlanets();
    }

    @Override
    public PageSwapiResponse<FilmResponse> getAllFilms() {
        
        return this.swapiApiClient.getAllFilms();
    }

    @Override
    public PageSwapiResponse<StarshipResponse> getAllStarships() {
        
        return this.swapiApiClient.getAllStarships();
    }

    @Override
    public PageSwapiResponse<VehicleResponse> getAllVehicles() {
        
        return this.swapiApiClient.getAllVehicles();
    }

    @Override
    public PageSwapiResponse<SpeciesResponse> getAllSpecies() {
        
        return this.swapiApiClient.getAllSpecies();
    }
    
}
