package com.liveinbits.rxjavamvvmremotelocaldb.RoomModel;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.liveinbits.rxjavamvvmremotelocaldb.model.Employee;

@Database(entities = Employee.class,version = 1,exportSchema = false)
public abstract class EmployeeDb extends RoomDatabase {

    public abstract EmployeeDao empdao();
}
