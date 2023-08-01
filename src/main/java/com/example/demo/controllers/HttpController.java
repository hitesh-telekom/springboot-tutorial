package com.example.demo.controllers;

import com.example.demo.models.MongoDataset;
import com.example.demo.models.Post;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HttpController {
    private final RestTemplate restTemplate;

    public HttpController(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    @GetMapping("/requests/params")
    public void requestWithParams(@RequestParam(value = "userId", required = false) Optional<String> userId, @RequestParam(value = "postId", required = false) Optional<String> postId){
        if(userId.isPresent()){
            String url = "https://jsonplaceholder.typicode.com/posts?userId" + userId;
            Post post = this.restTemplate.getForObject(url, Post.class);
            System.out.println("post from get call with ? = " + post);
        }

        if(postId.isPresent()){
            String url2 = "https://jsonplaceholder.typicode.com/posts/{id}";
            Post post2 = this.restTemplate.getForObject(url2, Post.class, postId);
            System.out.println("post from {} = " + post2);
        }

    }

    @GetMapping("/requests/custom-headers")
    public Post getPostCustomHeaders() {
        String url = "https://jsonplaceholder.typicode.com/posts/{id}";

        // create headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-request-source", "desktop");

        HttpEntity<?> request = new HttpEntity<>(headers);

        ResponseEntity<Post> response = this.restTemplate.exchange(url, HttpMethod.GET, request, Post.class, 1);
        if(response.getStatusCode() == HttpStatus.OK){
            return response.getBody();
        }

        return null;
    }

    @GetMapping("requests/create-post")
    public Post createPost(){
        String url = "https://jsonplaceholder.typicode.com/posts";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        Map<String, Object> map = new HashMap<>();
        map.put("userId", 1);
        map.put("title", "Introduction to spring boot");
        map.put("body", "Spring boot is a java framework");

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(map, headers);

        ResponseEntity<Post> response = this.restTemplate.postForEntity(url, request, Post.class);
        System.out.println(response);

        if(response.getStatusCode() == HttpStatus.CREATED){
            return response.getBody();
        }

        return null;
    }




}
