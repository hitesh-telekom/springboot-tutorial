package com.example.demo.services;

import com.example.demo.models.Dataset;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DatasetService {

    List<Dataset> datasets = new ArrayList<>();

    {
        datasets.add(new Dataset("id1", "YoungApp Test", "Hitesh"));
        datasets.add(new Dataset("id2", "YoungApp_Test_2", "Hitesh"));
    }

    public List<Dataset> getAllDatasets(){
        return datasets;
    }

    public Dataset addDataset(Dataset dataset){
        datasets.add(dataset);
        return dataset;
    }

    public Dataset getDataset(String datasetId){
        return datasets.stream().filter(dataset -> dataset.getId().equals(datasetId) ).findFirst().orElse(null);
    }

    public Dataset updateDataset(Dataset datasetUpdated){
        for(int i=0; i<datasets.size(); i++){
            if(datasets.get(i).getId().equals(datasetUpdated.getId())) {
                datasets.set(i, datasetUpdated);
                return datasetUpdated;
            }
        }
        return null;
    }

    public boolean deleteDataset(String datasetId){
        datasets = datasets.stream().filter(dataset -> !dataset.getId().equals(datasetId) ).toList();
        return true;
    }

}
