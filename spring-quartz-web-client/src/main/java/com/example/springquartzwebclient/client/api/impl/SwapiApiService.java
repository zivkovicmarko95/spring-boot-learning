package com.example.springquartzwebclient.client.api.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.springquartzwebclient.client.api.SwapiApiClient;
import com.example.springquartzwebclient.client.responses.FilmResponse;
import com.example.springquartzwebclient.client.responses.PageSwapiResponse;
import com.example.springquartzwebclient.client.responses.PersonResponse;
import com.example.springquartzwebclient.client.responses.PlanetResponse;
import com.example.springquartzwebclient.client.responses.SpeciesResponse;
import com.example.springquartzwebclient.client.responses.StarshipResponse;
import com.example.springquartzwebclient.client.responses.VehicleResponse;

@Service
public class SwapiApiService implements SwapiApiClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(SwapiApiService.class);

    private final SwapiApiClient swapiApiClient;

    public SwapiApiService(final SwapiApiClient swapiApiClient) {
        this.swapiApiClient = swapiApiClient;
    }

    @Override
    public PersonResponse getPerson(final int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPerson'");
    }

    @Override
    public PlanetResponse getPlanet(final int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPlanet'");
    }

    @Override
    public FilmResponse getFilm(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFilm'");
    }

    @Override
    public StarshipResponse getStarship(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStarship'");
    }

    @Override
    public VehicleResponse getVehicle(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getVehicle'");
    }

    @Override
    public SpeciesResponse getSpecies(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSpecies'");
    }

    @Override
    public List<PersonResponse> getAllPeople() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPeople'");
    }

    @Override
    public List<PlanetResponse> getAllPlanets() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPlanets'");
    }

    @Override
    public List<FilmResponse> getAllFilms() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllFilms'");
    }

    @Override
    public List<StarshipResponse> getAllStarships() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllStarships'");
    }

    @Override
    public PageSwapiResponse<VehicleResponse> getAllVehicles() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllVehicles'");
    }

    @Override
    public List<SpeciesResponse> getAllSpecies() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllSpecies'");
    }
    
}
