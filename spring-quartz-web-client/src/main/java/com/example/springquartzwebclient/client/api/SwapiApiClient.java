package com.example.springquartzwebclient.client.api;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import com.example.springquartzwebclient.client.responses.FilmResponse;
import com.example.springquartzwebclient.client.responses.PageSwapiResponse;
import com.example.springquartzwebclient.client.responses.PersonResponse;
import com.example.springquartzwebclient.client.responses.PlanetResponse;
import com.example.springquartzwebclient.client.responses.SpeciesResponse;
import com.example.springquartzwebclient.client.responses.StarshipResponse;
import com.example.springquartzwebclient.client.responses.VehicleResponse;

public interface SwapiApiClient {
    
    @GetExchange("https://swapi.dev/api/people/{id}/")
    PersonResponse getPerson(
            @PathVariable final int id
    );

    @GetExchange("https://swapi.dev/api/planets/{id}/")
    PlanetResponse getPlanet(
            @PathVariable final int id
    );

    @GetExchange("https://swapi.dev/api/films/{id}/")
    FilmResponse getFilm(
            @PathVariable final int id
    );

    @GetExchange("https://swapi.dev/api/starships/{id}/")
    StarshipResponse getStarship(
            @PathVariable final int id
    );

    @GetExchange("https://swapi.dev/api/vehicles/{id}/")
    VehicleResponse getVehicle(
            @PathVariable final int id
    );

    @GetExchange("https://swapi.dev/api/species/{id}/")
    SpeciesResponse getSpecies(
            @PathVariable final int id
    );

    @GetExchange("https://swapi.dev/api/people/")
    List<PersonResponse> getAllPeople();

    @GetExchange("https://swapi.dev/api/planets/")
    List<PlanetResponse> getAllPlanets();

    @GetExchange("https://swapi.dev/api/films/")
    List<FilmResponse> getAllFilms();

    @GetExchange("https://swapi.dev/api/starships/")
    List<StarshipResponse> getAllStarships();

    @GetExchange("https://swapi.dev/api/vehicles/")
    PageSwapiResponse<VehicleResponse> getAllVehicles();

    @GetExchange("https://swapi.dev/api/species/")
    List<SpeciesResponse> getAllSpecies();

}
