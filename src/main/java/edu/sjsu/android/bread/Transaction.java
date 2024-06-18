package edu.sjsu.android.bread;

import java.util.Date;

public class Transaction {
    private int id;
    private String purchaseLabel;
    private double cost;
    private Date purchaseDate;
    private String category;
    private String notes;

    public Transaction(int id, String purchaseLabel, double cost, Date purchaseDate, String category, String notes) {
        this.id = id;
        this.purchaseLabel = purchaseLabel;
        this.cost = cost;
        this.purchaseDate = purchaseDate;
        this.category = category;
        this.notes = notes;
    }

    public int getId() { return this.id; }
    public String getPurchaseLabel() { return this.purchaseLabel; }
    public double getCost() { return this.cost; }
    public Date getPurchaseDate() { return this.purchaseDate; }
    public String getCategory() { return this.category; }
    public String getNotes() { return this.notes; }
}
