package com.example.demo.controllers;

import com.example.demo.models.MongoDataset;
import com.example.demo.repository.DatasetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/mongo/datasets")
public class MongoDatasetController {

    private DatasetRepository datasetRepository;

    @Autowired
    public void setDatasetRepository(DatasetRepository datasetRepository) {
        this.datasetRepository = datasetRepository;
    }

    @GetMapping("")
    public ResponseEntity<List<MongoDataset>> getAllDatasets(){
        System.out.println("Get request to getAllDatasets()");
        List<MongoDataset> datasets = this.datasetRepository.findAll();
        return ResponseEntity.ok(datasets);
    }

    @GetMapping("/{datasetId}")
    public ResponseEntity<MongoDataset> getDataset(@PathVariable("datasetId") String datasetId){
        System.out.println("Get Request to getDataset() with id = " + datasetId);
        Optional<MongoDataset> dataset = this.datasetRepository.findById(datasetId);

        System.out.println(dataset);

        if(dataset.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(dataset.get());
    }

    @PostMapping("")
    public ResponseEntity<MongoDataset> addDataset(@RequestBody MongoDataset dataset){
        System.out.println("Post request to addDataset");
        MongoDataset savedDataset = this.datasetRepository.save(dataset);
        return ResponseEntity.ok().body(savedDataset);
    }

    @PatchMapping("")
    public ResponseEntity<MongoDataset> updateDataset(@RequestBody MongoDataset dataset){
        System.out.println("Patch request to updateDataset()");
        MongoDataset updatedDataset = this.datasetRepository.save(dataset);
        return ResponseEntity.ok().body(updatedDataset);
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteDataset(@RequestParam("datasetId") String datasetId){
        System.out.println("Delete request to deleteDataset() with id = " + datasetId);
        this.datasetRepository.deleteById(datasetId);
        return ResponseEntity.ok("Deleted dataset");
    }

    @GetMapping("/query/createdBy")
    public ResponseEntity<?> getDatasetsFromCreatedBy(@RequestParam("createdBy") String createdBy){
        System.out.println("Fetching all databased with createdBY = " + createdBy);
        List<MongoDataset> datasets = this.datasetRepository.findByCreatedBy(createdBy);
        return ResponseEntity.ok(datasets);
    }

    @GetMapping("/query/name")
    public ResponseEntity<?> getDatasetsFromName(@RequestParam("name") String name){
        System.out.println("Fetching all databased with createdBY = " + name);
        List<MongoDataset> datasets = this.datasetRepository.findByName(name);
        return ResponseEntity.ok(datasets);
    }

}
