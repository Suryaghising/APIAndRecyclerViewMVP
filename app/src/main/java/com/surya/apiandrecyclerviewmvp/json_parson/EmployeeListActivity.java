package com.surya.apiandrecyclerviewmvp.json_parson;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.surya.apiandrecyclerviewmvp.R;
import com.surya.apiandrecyclerviewmvp.api.ApiInterface;
import com.surya.apiandrecyclerviewmvp.api.RetrofitClient;
import com.surya.apiandrecyclerviewmvp.json_parson.json_model.Employee;
import com.surya.apiandrecyclerviewmvp.json_parson.json_model.EmployeeDTO;
import com.surya.apiandrecyclerviewmvp.json_parson.json_presenter.IJsonPresenter;
import com.surya.apiandrecyclerviewmvp.json_parson.json_presenter.MainJsonPresenter;
import com.surya.apiandrecyclerviewmvp.json_parson.json_view.IJsonView;

import java.util.List;

public class EmployeeListActivity extends AppCompatActivity implements IJsonView {

    IJsonPresenter jsonPresenter;
    ApiInterface apiInterface;
    ProgressBar progressBar;
    LinearLayoutManager linearLayoutManager;
    EmployeeAdapter employeeAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_list_activity);

        progressBar = findViewById(R.id.progressBarId);
        recyclerView = findViewById(R.id.recyclerViewId);

        jsonPresenter = new MainJsonPresenter(this);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        apiInterface = RetrofitClient.getInstance().getApi();

        jsonPresenter.callApi(apiInterface);

    }

    @Override
    public void onSuccess(EmployeeDTO employeeDTO) {
        jsonPresenter.onResponseSuccess(employeeDTO);
    }

    @Override
    public void progressDialogShow() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void progressDialogHide() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setDataToRecyclerView(List<Employee> employeeList) {
        employeeAdapter = new EmployeeAdapter(employeeList, this, jsonPresenter);
        recyclerView.setAdapter(employeeAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        employeeAdapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
