package com.elasticsearch.soumyadeep;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public List < Movie >  getByName(String name) {
        return repository.findByName(name);
    }
    public void addMovie(Movie movie) {
        repository.save(movie);
    }
}