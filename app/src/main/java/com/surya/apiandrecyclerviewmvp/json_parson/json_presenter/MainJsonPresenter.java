package com.surya.apiandrecyclerviewmvp.json_parson.json_presenter;

import com.surya.apiandrecyclerviewmvp.api.ApiInterface;
import com.surya.apiandrecyclerviewmvp.json_parson.json_model.Employee;
import com.surya.apiandrecyclerviewmvp.json_parson.json_model.EmployeeDTO;
import com.surya.apiandrecyclerviewmvp.json_parson.CallApiForResponse;
import com.surya.apiandrecyclerviewmvp.json_parson.json_view.IJsonView;


public class MainJsonPresenter implements IJsonPresenter{
    IJsonView iJsonView;
    EmployeeDTO employeeDTO;

    public MainJsonPresenter(IJsonView iJsonView) {
        this.iJsonView = iJsonView;
    }

    @Override
    public void callApi(ApiInterface apiInterface) {
        employeeDTO = new EmployeeDTO();
        CallApiForResponse callApiForResponse = new CallApiForResponse(apiInterface, iJsonView);
        callApiForResponse.apiCall();

    }

    @Override
    public void onResponseSuccess(EmployeeDTO employeeDTO) {
        iJsonView.setDataToRecyclerView(employeeDTO.getEmployee());
    }

    @Override
    public void holderClickListener(Employee employee) {
        iJsonView.showToast(employee.getName()+ "\n"+ employee.getDob()+"\n"+employee.getSalary());
    }
}
