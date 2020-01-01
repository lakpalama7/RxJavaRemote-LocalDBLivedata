package com.liveinbits.rxjavamvvmremotelocaldb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Observable;
import android.os.Bundle;
import android.util.Log;

import com.liveinbits.rxjavamvvmremotelocaldb.model.Employee;
import com.liveinbits.rxjavamvvmremotelocaldb.model.EmployeeList;
import com.liveinbits.rxjavamvvmremotelocaldb.remote.APIService;
import com.liveinbits.rxjavamvvmremotelocaldb.remote.RetroClient;
import com.liveinbits.rxjavamvvmremotelocaldb.viewmodel.EmployeeViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CustomAdapter adapter;
    private EmployeeViewModel employeeViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        employeeViewModel= ViewModelProviders.of(this).get(EmployeeViewModel.class);
       // employeeViewModel= new EmployeeViewModel(MainActivity.this);

        employeeViewModel.getLiveData().observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(List<Employee> employees) {
                adapter=new CustomAdapter(employees);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });



    }
}
