package com.liveinbits.rxjavamvvmremotelocaldb.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.liveinbits.rxjavamvvmremotelocaldb.dataRepo.DataRepository;
import com.liveinbits.rxjavamvvmremotelocaldb.model.Employee;

import java.util.List;

public class EmployeeViewModel extends AndroidViewModel {

    private  LiveData<List<Employee>> livedata;
    private DataRepository repository;
    public EmployeeViewModel(Application application){
        super(application);
        repository=DataRepository.getInstance(application);
        livedata=repository.getLivedata();
    }

    public  LiveData<List<Employee>> getLiveData(){
        return livedata;
    }
}
