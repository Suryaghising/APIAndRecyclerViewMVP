package com.surya.apiandrecyclerviewmvp.json_parson.json_view;

import com.surya.apiandrecyclerviewmvp.json_parson.json_model.Employee;
import com.surya.apiandrecyclerviewmvp.json_parson.json_model.EmployeeDTO;

import java.util.List;

public interface IJsonView {

    void onSuccess(EmployeeDTO employeeDTO);
    void progressDialogShow();
    void progressDialogHide();
    void setDataToRecyclerView(List<Employee> employeeList);
    void showToast(String message);
}
