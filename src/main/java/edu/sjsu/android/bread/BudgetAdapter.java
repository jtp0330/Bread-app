package edu.sjsu.android.bread;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class BudgetAdapter extends RecyclerView.Adapter<BudgetAdapter.ViewHolder> {

    private ArrayList<Budget> budgetList;
    private Context context;

    public BudgetAdapter(ArrayList<Budget>bL, Context c)
    {
        this.budgetList = bL;
        this.context = c;
    }

    @NonNull
    @Override
    public BudgetAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.budget_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        Budget budget = budgetList.get(position);
        holder.budgetName.setText(budget.getBudgetName());
        holder.numDays.setText(budget.getNumOfDays());
        holder.spendLimit.setText(budget.getSpendingLimit());
    }

    @Override
    public int getItemCount()
    {
        return budgetList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView budgetName, numDays, spendLimit;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            budgetName = itemView.findViewById(R.id.id_budgetName);
            numDays = itemView.findViewById(R.id.id_numDays);
            budgetName = itemView.findViewById(R.id.id_spendLimit);
        }


    }






}


