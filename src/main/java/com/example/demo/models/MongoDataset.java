package com.example.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("dataset")
@CompoundIndexes({
        @CompoundIndex(name = "natco_properties", def = "{'natcoKey' : 1, 'natcoCode': 1}")
})
public class MongoDataset {
    @Id
    private String id;
    private String natcoCode;
    private String natcoKey;
    @Indexed
    private String name;
    private String createdBy;

    public MongoDataset(String id, String natcoCode, String natcoKey, String name, String createdBy) {
        this.id = id;
        this.natcoCode = natcoCode;
        this.natcoKey = natcoKey;
        this.name = name;
        this.createdBy = createdBy;
    }

    public MongoDataset(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNatcoCode() {
        return natcoCode;
    }

    public void setNatcoCode(String natcoCode) {
        this.natcoCode = natcoCode;
    }

    public String getNatcoKey() {
        return natcoKey;
    }

    public void setNatcoKey(String natcoKey) {
        this.natcoKey = natcoKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "MongoDataset{" +
                "natcoCode='" + natcoCode + '\'' +
                ", natcoKey='" + natcoKey + '\'' +
                ", name='" + name + '\'' +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
