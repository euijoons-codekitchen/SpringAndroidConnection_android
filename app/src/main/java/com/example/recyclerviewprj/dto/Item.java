package com.example.recyclerviewprj.dto;

public class Item {

    private String itemUrl;
    private String itemDescription;
    private boolean currentState = false;

    public Item(String itemUrl, String itemDescription) {
        this.itemUrl = itemUrl;
        this.itemDescription = itemDescription;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public boolean isCurrentState() {
        return currentState;
    }

    public void setCurrentState(boolean currentState) {
        this.currentState = currentState;
    }
}
