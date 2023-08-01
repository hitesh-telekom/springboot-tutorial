package com.example.demo.controllers;

import com.example.demo.models.MongoDataset;
import com.example.demo.repository.DatasetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    private DatasetRepository datasetRepository;

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    public void setDatasetRepository(DatasetRepository datasetRepository) {
        this.datasetRepository = datasetRepository;
    }

//    @RequestMapping("/")
//    public String index(){
//        System.out.println("Inside index route");
//        return "index";
//    }

    @RequestMapping("/datasets")
    public String datasets(ModelMap modelMap, @ModelAttribute MongoDataset dataset){
        modelMap.addAttribute("dataset", new MongoDataset());

        List<MongoDataset> datasets = this.datasetRepository.findAll();
        System.out.println("datasets = " + datasets);
        modelMap.addAttribute("datasets", datasets);
        return "datasets";
    }

    @RequestMapping("/")
    public String index(ModelMap model){
        model.addAttribute("appName", appName);
        return "home";
    }

}
