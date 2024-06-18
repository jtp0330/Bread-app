package edu.sjsu.android.bread;

import androidx.core.app.NotificationCompat;

///////////////////////////////////////////////////////////////////
/*
Name: edu.sjsu.android.bread.Budget
Author:Jared
Description: Created a com.example.bread.Budget Class based on the Class Diagram
fro Bread Design Document. Feel free to Edit.
*/
///////////////////////////////////////////////////////////////////
public class Budget {

    private int numOfDays;
    private int spendingLimit;
    //dummy variable used to notify user on phone
    private int notifyLim = 10;

    //constructor
    public Budget(int n,int s)
    {
        this.numOfDays = n;
        this.spendingLimit = s;
    }
    //setter method for
    public void setNumOfDays(int days)
    {
        this.numOfDays = days;
    }

    public void setSpendingLimit(int limit)
    {
        this.spendingLimit = limit;
    }

    //getter methods
    public int getNumOfDays()
    {
        return this.numOfDays;
    }

    public int getSpendingLimit()
    {
        return this.spendingLimit;
    }

    //returns a boolean, which is used by BudgetManager
    //for sending a notification
    public boolean isAlmostTime(int days)
    {

        if(this.numOfDays - days <= notifyLim)
        {
            return true;
        }
        return false;
    }

    public boolean isAlmostBudget(int spendingLimit)
    {
        if(this.spendingLimit - spendingLimit <= 10)
        {
            return true;
        }
        return false;

    }
    //updates spending limit whenever new transaction is added
    public void checkSpendingLimit(int amount)
    {
        this.spendingLimit += amount;
    }

}
