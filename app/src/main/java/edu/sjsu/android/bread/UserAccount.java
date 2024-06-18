package edu.sjsu.android.bread;

///////////////////////////////////////////////////////////////////
/*
Name: com.example.bread.UserAccount
Author:Jared
Description: Created a com.example.bread.UserAccount Class based on the Class Diagram
from Bread Design Document. Utilizes the Budget class. Feel free to Edit.
*/
///////////////////////////////////////////////////////////////////

public class UserAccount {

    private String purchaser_name;
    private String email;
    private String username;
    private String password;
    private Budget budget;

    public UserAccount(String p, String e, String u, String pw, Budget b){
        this.purchaser_name = p;
        this.email = e;
        this.username = u;
        this.password = pw;
        this.budget = b;
    }
    //setters/modifiers
    public void setName(String pname){this.purchaser_name = pname;}

    public void setUsername(String uname){this.username = uname;}

    public void setEmail(String em){this.email = em;}

    public void setPassword(String pw){this.password = pw;}

    public void setBudget(int numDays, int spendLim)
    {
        this.budget.setNumOfDays(numDays);
        this.budget.setSpendingLimit(spendLim);
    }
    //getters/accessors
    public String getName(){return this.purchaser_name;}

    public String getEmail(){return this.email;}

    public String getUsername(){return this.username;}

    public String getPassword(){return this.password;}

    //verifies if email is correct
    //Subject to change
    public boolean verifyEmail(String enteredEmail){ return this.email.equals(enteredEmail); }

    //helps verify login, returning true if both username and password match
    //false otherwise
    //Subject to change
    public boolean loginVerification(String enteredUname, String enteredPword) { return this.username.equals(enteredUname) && this.password.equals(enteredPword); }

}
