package edu.sjsu.android.bread;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class HomePageActivity extends AppCompatActivity {
    Button buttonBudgetMe, buttonSettings, buttonClose;
    RecyclerView budgetRV;
    Bundle bundle;

    //data structure to store and display budgets with shared preferences
    private BudgetAdapter badpater;
    private ArrayList<Budget> budgets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        buttonBudgetMe = (Button)findViewById(R.id.buttonBudgetMe);
        buttonSettings = (Button)findViewById(R.id.buttonSettings);
        buttonClose = (Button)findViewById(R.id.buttonClose);

        budgetRV = findViewById(R.id.Budgets);
        //retrieve data from BudgetPage
        bundle = getIntent().getExtras();

        loadBudgets();

        buttonBudgetMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create an intent to go to the Budget Page
                Intent intent = new Intent(HomePageActivity.this, BudgetPageActivity.class);
                startActivity(intent);


            }
        });

        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create an intent to go to the Settings page
                Intent intent = new Intent(HomePageActivity.this, SettingsActivity.class);
                startActivity(intent);
                //retrive data from budget add activty
                bundle = getIntent().getExtras();
                //add new budget to arraylist
                budgets.add(new Budget(bundle.getString("NAME"),Integer.parseInt(bundle.getString("NUMDAYS")),Integer.parseInt(bundle.getString("LIMIT"))));
                //save budget
                saveBudget();
            }
        });

        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Exit the system
                finish();
                System.exit(0);
            }
        });



    }
    private void buildRecyclerView()
    {
        badpater = new BudgetAdapter(budgets, HomePageActivity.this);

        LinearLayoutManager lmanager = new LinearLayoutManager(this);
        budgetRV.setHasFixedSize(true);
        //set layout presentation of budgets and adapter
        budgetRV.setLayoutManager(lmanager);
        budgetRV.setAdapter(badpater);

    }
    //loads data(budgets) stored in sharedpreferences
    private void loadBudgets()
    {
        SharedPreferences sP = getSharedPreferences("shared preferences", MODE_PRIVATE);

        Gson gson = new Gson();

        String json = sP.getString("budgets",null);
        //get type of arraylist (Budget)


        Type type = new TypeToken<ArrayList<Budget>>() {}.getType();
        //load data from gson to json
        budgets = gson.fromJson(json,type);

        if(budgets == null) {
            budgets = new ArrayList<>();
        }

    }
    //saves data(budgets) stored in sharedpreferences
    private void saveBudget()
    {
        SharedPreferences sP = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sP.edit();

        Gson gson = new Gson();

        String json = gson.toJson(budgets);

        editor.putString("budgets",json);

        editor.apply();

        Toast.makeText(this, "Budget Saved", Toast.LENGTH_SHORT).show();
    }

}
