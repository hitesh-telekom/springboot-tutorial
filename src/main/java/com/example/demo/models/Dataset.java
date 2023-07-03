package com.example.demo.models;

public class Dataset {
    private String id;
    private String name;

    private String natcoKey;

    private String natcoCode;

    private String createdBy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNatcoKey() {
        return natcoKey;
    }

    public void setNatcoKey(String natcoKey) {
        this.natcoKey = natcoKey;
    }

    public String getNatcoCode() {
        return natcoCode;
    }

    public void setNatcoCode(String natcoCode) {
        this.natcoCode = natcoCode;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Dataset(String id, String name, String natcoKey, String natcoCode, String createdBy) {
        this.id = id;
        this.name = name;
        this.natcoKey = natcoKey;
        this.natcoCode = natcoCode;
        this.createdBy = createdBy;
    }

    public Dataset(String id, String name, String createdBy) {
        this.id = id;
        this.name = name;
        this.natcoKey = "gn";
        this.natcoCode = "natco code";
        this.createdBy = createdBy;
    }

    public Dataset(){}

    @Override
    public String toString() {
        return "Dataset{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", natcoKey='" + natcoKey + '\'' +
                ", natcoCode='" + natcoCode + '\'' +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
