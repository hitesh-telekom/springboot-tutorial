package com.example.demo.repository;

import com.example.demo.models.Dataset;
import com.example.demo.models.MongoDataset;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface DatasetRepository extends MongoRepository<MongoDataset, String> {

    @Query("{createdBy: '?0'}")
    List<Dataset> findByCreatedBy(String createdBy);

    @Query(value="{name: '?0'}", fields = "{'name':  1, 'id':  1}")
    List<Dataset> findByName(String name);

}
