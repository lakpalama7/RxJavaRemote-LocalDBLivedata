package com.liveinbits.rxjavamvvmremotelocaldb.RoomModel;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.liveinbits.rxjavamvvmremotelocaldb.model.Employee;
import com.liveinbits.rxjavamvvmremotelocaldb.model.EmployeeList;

import java.util.List;

@Dao
public interface EmployeeDao {

    @Query("select * from employee")
    LiveData<List<Employee>> getAllEmployee();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertEmployee(Employee employee);
}
