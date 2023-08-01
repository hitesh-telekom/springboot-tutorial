package com.example.async.controllers;

import com.example.async.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/async")
public class GithubLookupController {
    private static final Logger logger = LoggerFactory.getLogger(GithubLookupController.class);

    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    @GetMapping("/get-user")
    public CompletableFuture<User> findUser(@RequestParam("user") String user) throws InterruptedException {
        logger.info("Looking up " + user);

        String url = "https://api.github.com/users/{user}";

        logger.info(url);

        ResponseEntity<User> response = this.restTemplate.getForEntity(url, User.class, user);
        logger.info("response" + response);

        Thread.sleep(4000L);

        if(response.getStatusCode() == HttpStatus.OK){
            return CompletableFuture.completedFuture(response.getBody());
        }
        return null;
    }


}
