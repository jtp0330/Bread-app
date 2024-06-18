package edu.sjsu.android.bread;
///////////////////////////////////////////////////////////////////
/*
Name: edu.sjsu.android.bread.Transaction
Author:Jared
Description: Created a com.example.bread.Transaction Class based on the Class Diagram
from Bread Design Document. Feel free to Edit.
*/
///////////////////////////////////////////////////////////////////
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private int tID;
    private String purchaseLabel;
    private double cost;
    private Date purchaseDate;
    private String notes;
    //thought we are not adding categories to budget
    //private String category;

    public Transaction(int t, String pL, double c, String n)
    {
        this.tID = t;
        this.purchaseLabel = pL;
        this.cost = c;
        //gets current time in milliseconds
        //would have to print with SimpleDateFormatter for a more formatted date
        this.purchaseDate = new Date(System.currentTimeMillis());
        this.notes = n;
    }
    //getters/accessors
    public int getID()
    {
        return this.tID;
    }

    public String getPurchaseLabel()
    {
        return this.purchaseLabel;
    }

    public double getCost()
    {
        return this.cost;
    }
    //df formats purchaseDate in specified pattern
    //then return String Buffer, which can then be returned as String using toString()
    public String getDate()
    {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return df.format(this.purchaseDate).toString();
    }

    public String getNotes()
    {
        return this.notes;
    }

    /*Unused method
    * public String getCategory()
    * {
    *   return this.category;
    * }
    * */






}
