package com.kodilla.good.patterns.challenges;

public class Item {
    private int ItemID;
    private String ItemName;
    private String ItemDescription;

    public Item(int itemID, String itemName, String itemDescription) {
        ItemID = itemID;
        ItemName = itemName;
        ItemDescription = itemDescription;
    }

    public int getItemID() {
        return ItemID;
    }

    public String getItemName() {
        return ItemName;
    }

    public String getItemDescription() {
        return ItemDescription;
    }
}
