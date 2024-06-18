package edu.sjsu.android.bread;

public class Budget {
    private String bName;
    private int numOfDays;
    private int spendingLimit;

    public Budget(String bn, int numOfDays, int spendingLimit) {
        this.bName = bn;
        this.numOfDays = numOfDays;
        this.spendingLimit = spendingLimit;
    }

    public String getBudgetName()
    {return this.bName;}
    public int getNumOfDays() { return this.numOfDays; }
    public int getSpendingLimit() {
        return this.spendingLimit;
    }
    public void setBudgetName(String bn){this.bName = bn;}
    public void setNumOfDays(int days) {
        this.numOfDays = days;
    }
    public void setSpendingLimit(int amount) {
        this.spendingLimit = amount;
    }

    public boolean isAlmostTime(int days) {
        return false; //Subject to modify
    }

    public boolean isAlmostBudget(int spendingLimit) {
        return false; //Subject to modify
    }

    public void checkSpendingLimit(int amount) {
        this.spendingLimit += amount;
    }

}
