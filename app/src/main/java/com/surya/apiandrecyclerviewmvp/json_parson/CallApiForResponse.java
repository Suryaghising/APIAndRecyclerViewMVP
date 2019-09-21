package com.surya.apiandrecyclerviewmvp.json_parson;


import com.surya.apiandrecyclerviewmvp.api.ApiInterface;
import com.surya.apiandrecyclerviewmvp.json_parson.json_model.EmployeeDTO;
import com.surya.apiandrecyclerviewmvp.json_parson.json_view.IJsonView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallApiForResponse {

    ApiInterface apiInterface;
    IJsonView iJsonView;
    EmployeeDTO employeeDTO;

    public CallApiForResponse(ApiInterface apiInterface, IJsonView iJsonView) {
        this.apiInterface = apiInterface;
        this.iJsonView = iJsonView;
    }

    public void apiCall(){
        employeeDTO = new EmployeeDTO();
        iJsonView.progressDialogShow();
        Call<EmployeeDTO> call = apiInterface.getListOfEmployees();
        call.enqueue(new Callback<EmployeeDTO>() {
            @Override
            public void onResponse(Call<EmployeeDTO> call, Response<EmployeeDTO> response) {

                if (response.isSuccessful()) {
                    employeeDTO = response.body();
                    iJsonView.progressDialogHide();
                    iJsonView.onSuccess(employeeDTO);
                } else {
                    iJsonView.showToast("Response not successful.\n"+response.message());
                    iJsonView.progressDialogHide();
                }
            }

            @Override
            public void onFailure(Call<EmployeeDTO> call, Throwable t) {
                iJsonView.showToast("Response on failure.\n"+t.getMessage());
                iJsonView.progressDialogHide();
            }
        });
    }

}
