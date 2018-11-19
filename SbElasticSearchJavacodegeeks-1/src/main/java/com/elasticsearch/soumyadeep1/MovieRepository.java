package com.elasticsearch.soumyadeep1;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface MovieRepository extends ElasticsearchRepository < Movie, Long > {
    public List < Movie >  findByName(String name);

    public List < Movie>  findByRatingBetween(Double beginning, Double end);
}