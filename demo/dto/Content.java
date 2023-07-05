package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Content {
    @JsonProperty(value = "price")
    private double price;

    private String id;

    private String assetId;

    private String timestamp;

    private int marketCapRank;

    private int volumeRank;

    private double volume;

    private int totalSupply;

    private int freeFloatSupply;

    private double marketCap;

    private double totalMarketCap;

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getMarketCapRank() {
        return marketCapRank;
    }

    public void setMarketCapRank(int marketCapRank) {
        this.marketCapRank = marketCapRank;
    }

    public int getVolumeRank() {
        return volumeRank;
    }

    public void setVolumeRank(int volumeRank) {
        this.volumeRank = volumeRank;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public int getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(int totalSupply) {
        this.totalSupply = totalSupply;
    }

    public int getFreeFloatSupply() {
        return freeFloatSupply;
    }

    public void setFreeFloatSupply(int freeFloatSupply) {
        this.freeFloatSupply = freeFloatSupply;
    }

    public double getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(double marketCap) {
        this.marketCap = marketCap;
    }

    public double getTotalMarketCap() {
        return totalMarketCap;
    }

    public void setTotalMarketCap(double totalMarketCap) {
        this.totalMarketCap = totalMarketCap;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}