package com.surya.apiandrecyclerviewmvp.json_parson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.surya.apiandrecyclerviewmvp.R;
import com.surya.apiandrecyclerviewmvp.json_parson.json_model.Employee;
import com.surya.apiandrecyclerviewmvp.json_parson.json_presenter.IJsonPresenter;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {

    List<Employee> employeeList;
    Context context;
    IJsonPresenter jsonPresenter;

    public EmployeeAdapter(List<Employee> employeeList, Context context, IJsonPresenter jsonPresenter) {
        this.employeeList = employeeList;
        this.context = context;
        this.jsonPresenter = jsonPresenter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_list_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(employeeList.get(position));
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, dob, salary;
        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameId);
            dob = itemView.findViewById(R.id.dobId);
            salary = itemView.findViewById(R.id.salaryId);
            linearLayout = itemView.findViewById(R.id.layoutId);
        }

        public void bindView(final Employee employee) {
            name.setText(employee.getName());
            dob.setText(employee.getDob());
            salary.setText(employee.getSalary());

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    jsonPresenter.holderClickListener(employee);
                }
            });
        }
    }

}
