package com.surya.apiandrecyclerviewmvp.json_parson.json_presenter;

import com.surya.apiandrecyclerviewmvp.api.ApiInterface;
import com.surya.apiandrecyclerviewmvp.json_parson.json_model.Employee;
import com.surya.apiandrecyclerviewmvp.json_parson.json_model.EmployeeDTO;

public interface IJsonPresenter {
    void callApi(ApiInterface apiInterface);
    void onResponseSuccess(EmployeeDTO employeeDTO);
    void holderClickListener(Employee employee);
}
