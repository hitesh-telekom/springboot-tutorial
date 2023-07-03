package com.example.demo.controllers;

import com.example.demo.models.Dataset;
import com.example.demo.services.DatasetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DatasetController {

    @Autowired
    private DatasetService datasetService;

    @GetMapping("/datasets")
    public ResponseEntity<List<Dataset>> getAllDataset(){
        List<Dataset> datasets = datasetService.getAllDatasets();
        return ResponseEntity.ok().header("Created-By", "Hitesh").header("New-Header", "Value1").body(datasets);
    }

    @GetMapping("/datasets/{datasetId}")
    public ResponseEntity<Dataset> getDataset(@PathVariable("datasetId") String datasetId){
        Dataset dataset = datasetService.getDataset(datasetId);
        if(dataset == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().body(dataset);
    }

    @PostMapping("/datasets")
    public ResponseEntity<Dataset> createDataset(@RequestBody Dataset dataset){
        System.out.println("adding new dataset");
        Dataset datasetCreated = datasetService.addDataset(dataset);
        return ResponseEntity.ok(datasetCreated);
    }

    @PatchMapping("/datasets")
    public ResponseEntity<Dataset> updateDataset(@RequestBody Dataset dataset){
        Dataset updatedDataset = this.datasetService.updateDataset(dataset);
        if(updatedDataset == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(updatedDataset);
    }

    @DeleteMapping("/datasets")
    public ResponseEntity<String> deleteDataset(@RequestParam String datasetId){
        boolean status = this.datasetService.deleteDataset(datasetId);
        if(status){
            return ResponseEntity.ok("Successfully deleted dataset");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to delete dataset");
    }


}
