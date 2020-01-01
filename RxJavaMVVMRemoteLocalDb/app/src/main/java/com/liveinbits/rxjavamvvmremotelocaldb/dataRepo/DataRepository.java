package com.liveinbits.rxjavamvvmremotelocaldb.dataRepo;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.liveinbits.rxjavamvvmremotelocaldb.RoomModel.EmployeeDb;
import com.liveinbits.rxjavamvvmremotelocaldb.model.Employee;
import com.liveinbits.rxjavamvvmremotelocaldb.model.EmployeeList;
import com.liveinbits.rxjavamvvmremotelocaldb.remote.APIService;
import com.liveinbits.rxjavamvvmremotelocaldb.remote.RetroClient;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataRepository {

    private static DataRepository repository;
    private LiveData<List<Employee>> livedata;
    private Context context;
    private static EmployeeDb employeeDb;
    private DataRepository(Context context){
        this.context=context;
        employeeDb= Room.databaseBuilder(context, EmployeeDb.class,"employee1.db").build();
        getDataRemote();
    }
    public static DataRepository getInstance(Context context){
        if(repository==null){
            repository=new DataRepository(context);
        }
        return repository;
    }

    private void getDataRemote(){
        APIService call= RetroClient.getAPIService();
        Call<EmployeeList> emplist=call.getAll();
        emplist.enqueue(new Callback<EmployeeList>() {
            @Override
            public void onResponse(Call<EmployeeList> call, final Response<EmployeeList> response) {
                Completable.fromAction(new Action() {
                    @Override
                    public void run() throws Exception {
                        for(int i=0;i<response.body().getEmployeeList().size();i++){
                            Employee employee=response.body().getEmployeeList().get(i);
                            employeeDb.empdao().insertEmployee(employee);
                        }
                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
            }

            @Override
            public void onFailure(Call<EmployeeList> call, Throwable t) {

            }
        });
    }

    public  LiveData<List<Employee>> getLivedata() {

        livedata=employeeDb.empdao().getAllEmployee();

        return livedata;
    }
}
