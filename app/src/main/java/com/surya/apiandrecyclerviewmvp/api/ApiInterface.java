package com.surya.apiandrecyclerviewmvp.api;

import com.surya.apiandrecyclerviewmvp.json_parson.json_model.EmployeeDTO;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("retrofit/json_object.json")
    Call<EmployeeDTO> getListOfEmployees();

}
