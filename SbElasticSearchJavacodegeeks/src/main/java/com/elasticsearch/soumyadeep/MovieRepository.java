package com.elasticsearch.soumyadeep;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface MovieRepository extends ElasticsearchRepository < Movie, Long > {
	
    public List < Movie >  findByName(String name);

}