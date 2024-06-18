package edu.sjsu.android.bread;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

///////////////////////////////////////////////////////////////////
/*
Name: com.example.bread.BudgetManager
Author:Jared
Description: Created a com.example.bread.BudgetManager Class based on the Class Diagram
fro Bread Design Document. Manages interactions between system and SQLite Database.
Acts as Model. Feel free to Edit.
*/
///////////////////////////////////////////////////////////////////

public class BudgetManager {
    //access Database, using databasehelper instance
    //acknowledge that login was successful, open dashboard UI
    //when press add button, select open add budget UI
    //send message saying that add was sucessful

    private DatabaseHelper dbh;
    private Context context;
    private SQLiteDatabase breadDB;
    private ArrayList<Budget> budgets;

    private int bID;
    private String url;
    private UserAccount user;

    public BudgetManager(Context c)
    {
        this.context = c;
    }
    //open database
    public BudgetManager open() throws SQLException
    {
        dbh = new DatabaseHelper(context);
        breadDB = dbh.getWritableDatabase();
        return this;

    }
    //close database
    public void close()
    {
        dbh.close();
    }
    //updates the database with a new transaction
    //returns true upon successful update
    public boolean addTransaction()
    {
        return true;
    }
    //return true if transaction data is in database
    public boolean verifyTransaction(Transaction trans)
    {
        return true;
    }
    //updates database by removing transaction trans, return true if successful
    public boolean deleteTransaction(Transaction trans)
    {
        return true;
    }

    public boolean editTransaction(Transaction trans)
    {
        return true;
    }
    //finds transaction data from database, then loads into a new Transaction object
    //for return
    public Transaction findTransaction(int id)
    {
        Transaction t = new Transaction(id, "test",10.0,"dummy transaction");
        return t;
    }

    public boolean sendTimeReminder()
    {
        return true;
    }

    public boolean sendBudgetReminder()
    {
        return true;
    }














}
