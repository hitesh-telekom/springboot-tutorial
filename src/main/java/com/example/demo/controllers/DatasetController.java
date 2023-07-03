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
    public List<Dataset> getAllDataset(){
        return datasetService.getAllDatasets();
    }

    @GetMapping("/datasets/{datasetId}")
    public ResponseEntity<Dataset> getDataset(@PathVariable("datasetId") String datasetId){
        Dataset dataset = datasetService.getDataset(datasetId);
        if(dataset == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok().body(dataset);
    }

    @PostMapping("/datasets")
    public Dataset createDataset(@RequestBody Dataset dataset){
        System.out.println("adding new dataset");
        return datasetService.addDataset(dataset);
    }

    @PatchMapping("/datasets")
    public Dataset updateDataset(@RequestBody Dataset dataset){
        return this.datasetService.updateDataset(dataset);
    }

    @DeleteMapping("/datasets")
    public boolean deleteDataset(@RequestParam String datasetId){
        return this.datasetService.deleteDataset(datasetId);
    }


}
