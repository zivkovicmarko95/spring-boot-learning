package com.example.springquartzwebclient.client.api.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import com.example.springquartzwebclient.client.api.SwapiApiClient;
import com.example.springquartzwebclient.client.responses.FilmResponse;
import com.example.springquartzwebclient.client.responses.PageSwapiResponse;
import com.example.springquartzwebclient.client.responses.PersonResponse;
import com.example.springquartzwebclient.client.responses.PlanetResponse;
import com.example.springquartzwebclient.client.responses.SpeciesResponse;
import com.example.springquartzwebclient.client.responses.StarshipResponse;
import com.example.springquartzwebclient.client.responses.VehicleResponse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ExtendWith(SpringExtension.class)
class SwapiApiServiceTest {

    private static final PodamFactory PODAM_FACTORY = new PodamFactoryImpl();

    @MockBean
    private SwapiApiClient swapiApiClient;

    private SwapiApiService swapiApiService;

    @BeforeEach
    void before() {
        swapiApiService = new SwapiApiService(this.swapiApiClient);
    }

    @AfterEach
    void after() {
        verifyNoMoreInteractions(this.swapiApiClient);
    }

    @Test
    void getPerson() {

        final Integer id = PODAM_FACTORY.manufacturePojo(Integer.class);
        final PersonResponse expectedResponse = PODAM_FACTORY.manufacturePojo(PersonResponse.class);
        when(swapiApiClient.getPerson(id)).thenReturn(expectedResponse);

        final PersonResponse actualResponse = swapiApiService.getPerson(id);

        assertEquals(expectedResponse, actualResponse);

        verify(swapiApiClient).getPerson(id);
    }

    @Test
    void getPlanet() {
        
        final Integer id = PODAM_FACTORY.manufacturePojo(Integer.class);
        final PlanetResponse expectedResponse = PODAM_FACTORY.manufacturePojo(PlanetResponse.class);
        when(swapiApiClient.getPlanet(id)).thenReturn(expectedResponse);

        final PlanetResponse actualResponse = swapiApiService.getPlanet(id);

        assertEquals(expectedResponse, actualResponse);
        verify(swapiApiClient).getPlanet(id);
    }

    @Test
    void getFilm() {
        
        final Integer id = PODAM_FACTORY.manufacturePojo(Integer.class);
        final FilmResponse expectedResponse = PODAM_FACTORY.manufacturePojo(FilmResponse.class);
        when(swapiApiClient.getFilm(id)).thenReturn(expectedResponse);

        final FilmResponse actualResponse = swapiApiService.getFilm(id);

        assertEquals(expectedResponse, actualResponse);

        verify(swapiApiClient).getFilm(id);
    }

    @Test
    void getStarship() {
        
        final Integer id = PODAM_FACTORY.manufacturePojo(Integer.class);
        final StarshipResponse expectedResponse = PODAM_FACTORY.manufacturePojo(StarshipResponse.class);
        when(swapiApiClient.getStarship(id)).thenReturn(expectedResponse);

        final StarshipResponse actualResponse = swapiApiService.getStarship(id);

        assertEquals(expectedResponse, actualResponse);
        verify(swapiApiClient).getStarship(id);
    }

    @Test
    void getVehicle() {
        
        final Integer id = PODAM_FACTORY.manufacturePojo(Integer.class);
        final VehicleResponse expectedResponse = PODAM_FACTORY.manufacturePojo(VehicleResponse.class);
        when(swapiApiClient.getVehicle(id)).thenReturn(expectedResponse);

        final VehicleResponse actualResponse = swapiApiService.getVehicle(id);

        assertEquals(expectedResponse, actualResponse);
        verify(swapiApiClient).getVehicle(id);
    }

    @Test
    void getSpecies() {
        
        final Integer id = PODAM_FACTORY.manufacturePojo(Integer.class);
        final SpeciesResponse expectedResponse = PODAM_FACTORY.manufacturePojo(SpeciesResponse.class);
        when(swapiApiClient.getSpecies(id)).thenReturn(expectedResponse);

        final SpeciesResponse actualResponse = swapiApiService.getSpecies(id);

        assertEquals(expectedResponse, actualResponse);
        verify(swapiApiClient).getSpecies(id);
    }

    @Test
    void getAllPeople() {
        
        final PageSwapiResponse<PersonResponse> expectedResponse = PODAM_FACTORY.manufacturePojo(PageSwapiResponse.class, PersonResponse.class);
        when(swapiApiClient.getAllPeople()).thenReturn(expectedResponse);

        final PageSwapiResponse<PersonResponse> actualResponse = swapiApiService.getAllPeople();

        assertEquals(expectedResponse, actualResponse);
        verify(swapiApiClient).getAllPeople();
    }

    @Test
    void getAllPlanets() {
        
        final PageSwapiResponse<PlanetResponse> expectedResponse = PODAM_FACTORY.manufacturePojo(PageSwapiResponse.class, PlanetResponse.class);
        when(swapiApiClient.getAllPlanets()).thenReturn(expectedResponse);

        final PageSwapiResponse<PlanetResponse> actualResponse = swapiApiService.getAllPlanets();

        assertEquals(expectedResponse, actualResponse);
        verify(swapiApiClient).getAllPlanets();
    }

    @Test
    void getAllFilms() {
        
        final PageSwapiResponse<FilmResponse> expectedResponse = PODAM_FACTORY.manufacturePojo(PageSwapiResponse.class, FilmResponse.class);
        when(swapiApiClient.getAllFilms()).thenReturn(expectedResponse);

        final PageSwapiResponse<FilmResponse> actualResponse = swapiApiService.getAllFilms();

        assertEquals(expectedResponse, actualResponse);
        verify(swapiApiClient).getAllFilms();
    }

    @Test
    void getAllStarships() {
        
        final PageSwapiResponse<StarshipResponse> expectedResponse = PODAM_FACTORY.manufacturePojo(PageSwapiResponse.class, StarshipResponse.class);
        when(swapiApiClient.getAllStarships()).thenReturn(expectedResponse);

        final PageSwapiResponse<StarshipResponse> actualResponse = swapiApiService.getAllStarships();

        assertEquals(expectedResponse, actualResponse);
        verify(swapiApiClient).getAllStarships();
    }

    @Test
    void getAllVehicles() {
        
        final PageSwapiResponse<VehicleResponse> expectedResponse = PODAM_FACTORY.manufacturePojo(PageSwapiResponse.class, VehicleResponse.class);
        when(swapiApiClient.getAllVehicles()).thenReturn(expectedResponse);

        final PageSwapiResponse<VehicleResponse> actualResponse = swapiApiService.getAllVehicles();

        assertEquals(expectedResponse, actualResponse);
        verify(swapiApiClient).getAllVehicles();
    }

    @Test
    void getAllSpecies() {

        final PageSwapiResponse<SpeciesResponse> expectedResponse = PODAM_FACTORY.manufacturePojo(PageSwapiResponse.class, SpeciesResponse.class);
        
        when(swapiApiClient.getAllSpecies()).thenReturn(expectedResponse);

        final PageSwapiResponse<SpeciesResponse> actualResponse = swapiApiService.getAllSpecies();

        assertEquals(expectedResponse, actualResponse);
        verify(swapiApiClient).getAllSpecies();
    }

}
