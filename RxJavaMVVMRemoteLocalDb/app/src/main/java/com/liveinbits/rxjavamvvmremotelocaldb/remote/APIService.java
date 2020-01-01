package com.liveinbits.rxjavamvvmremotelocaldb.remote;

import com.liveinbits.rxjavamvvmremotelocaldb.model.EmployeeList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("v1/employee.php")
    Call<EmployeeList> getAll();
}
