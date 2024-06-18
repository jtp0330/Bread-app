package edu.sjsu.android.bread;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class BudgetPageActivity extends AppCompatActivity {
    DatabaseHelper dbh;
    EditText budget_name, num_Days, budget_limit;
    Button budget_add;

    Bundle bundle;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budgetpage);

        dbh = new DatabaseHelper(this);

        budget_name = (EditText) findViewById(R.id.et_budgetname);
        num_Days = (EditText) findViewById(R.id.et_numDays);
        budget_limit = (EditText) findViewById(R.id.et_budgetlimit);

        budget_add = (Button) findViewById(R.id.btn_add);

        //verify that credentials are valid, if yes, upload to database with db helper,
        //not, use toast and ping user
        budget_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bname = budget_name.getText().toString();
                String nDays = num_Days.getText().toString();
                String blimit = budget_limit.getText().toString();

                Intent intent = new Intent(BudgetPageActivity.this, HomePageActivity.class);
                //store data back to homepage for budget add
                bundle.putString("NAME",bname);
                bundle.putString("NUMDAYS",nDays);
                bundle.putString("LIMIT", blimit);

                intent.putExtras(bundle);
                //start homepage
                startActivity(intent);
            }
        });
    }

}
