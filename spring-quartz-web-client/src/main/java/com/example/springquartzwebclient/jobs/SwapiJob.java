package com.example.springquartzwebclient.jobs;

import com.example.springquartzwebclient.client.api.impl.SwapiApiService;
import com.example.springquartzwebclient.client.responses.FilmResponse;
import com.example.springquartzwebclient.client.responses.PageSwapiResponse;
import com.example.springquartzwebclient.client.responses.PlanetResponse;
import com.example.springquartzwebclient.utils.HttpUtils;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SwapiJob implements Job {

    private static final Logger LOGGER = LoggerFactory.getLogger(SwapiJob.class);

    @Autowired
    private SwapiApiService swapiApiService;
    
    @Override
    public void execute(final JobExecutionContext jobExecutionContext) throws JobExecutionException {
        
        LOGGER.info("Starting swapi job");

        final PageSwapiResponse<FilmResponse> pageFilmResponse = this.swapiApiService.getAllFilms();
        final FilmResponse randomFilmResponse = pageFilmResponse.getResults().stream()
                .findAny()
                .orElseThrow();

        pageFilmResponse.getResults().parallelStream().forEachOrdered(film -> {

            if (randomFilmResponse.getUrl().equals(film.getUrl())) {
                final Integer id = HttpUtils.extractIdFromUrl(film.getUrl());
    
                final FilmResponse filmResponse = this.swapiApiService.getFilm(id);
    
                LOGGER.info("Random film with ID {} is {}", id, filmResponse);
            }
        });

        final PageSwapiResponse<PlanetResponse> pagePlanetResponse = this.swapiApiService.getAllPlanets();
        final PlanetResponse randomPlanet = pagePlanetResponse.getResults().stream()
                .findAny()
                .orElseThrow();

        pagePlanetResponse.getResults().parallelStream().forEachOrdered(planet -> {

            if (randomPlanet.getUrl().equals(planet.getUrl())) {
                final Integer id = HttpUtils.extractIdFromUrl(planet.getUrl());

                final PlanetResponse planetResponse = this.swapiApiService.getPlanet(id);

                LOGGER.info("Random planet with ID {} is {}", id, planetResponse);
            }
        });

        LOGGER.info("Ended swapi job ... OK");
    }

}
