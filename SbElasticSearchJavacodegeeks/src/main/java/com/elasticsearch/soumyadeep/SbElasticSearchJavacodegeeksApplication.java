package com.elasticsearch.soumyadeep;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SbElasticSearchJavacodegeeksApplication implements CommandLineRunner {
	

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SbElasticSearchJavacodegeeksApplication.class, args);
    }

    @Autowired
    private MovieService movieService;

    private static final Logger logger = LoggerFactory.getLogger(SbElasticSearchJavacodegeeksApplication.class);

// add star wars and
// princess bride as a movie
// to elastic search
    private void addSomeMovies() {
        Movie starWars = getFirstMovie();
        movieService.addMovie(starWars);

        Movie princessBride = getSecondMovie();
        movieService.addMovie(princessBride);
    }

    private Movie getSecondMovie() {
        Movie secondMovie = new Movie();
        secondMovie.setId("two");
        //secondMovie.setRating(8.4d);
        secondMovie.setName("ThePrincessBride");

        //List < Genre >  princessPrideGenre = new ArrayList < Genre >();
        //princessPrideGenre.add(new Genre("ACTION"));
        //princessPrideGenre.add(new Genre("ROMANCE"));
        //secondMovie.setGenre(princessPrideGenre);

        return secondMovie;
    }


    private Movie getFirstMovie() {
        Movie firstMovie = new Movie();
        firstMovie.setId("one");
        //firstMovie.setRating(9d);
        firstMovie.setName("StarWars");

        //List < Genre >  starWarsGenre = new ArrayList < Genre >();
        //starWarsGenre.add(new Genre("ACTION"));
        //starWarsGenre.add(new Genre("SCI_FI"));
        //firstMovie.setGenre(starWarsGenre);

        return firstMovie;
    }

    public void run(String... args) throws Exception {
        addSomeMovies();
        // We indexed star wars and pricess bride to our movie
        // listing in elastic search

        //Lets query if we have a movie with Star Wars as name
        List < Movie > starWarsNameQuery = movieService.getByName("StarWars");
        logger.info("Content of star wars name query is {}", starWarsNameQuery);

        //Lets query if we have a movie with The Princess Bride as name
        List < Movie >  brideQuery = movieService.getByName("ThePrincessBride");
        logger.info("Content of princess bride name query is {}", brideQuery);
    }
}