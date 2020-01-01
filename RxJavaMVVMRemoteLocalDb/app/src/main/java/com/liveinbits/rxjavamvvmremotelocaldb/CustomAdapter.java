package com.liveinbits.rxjavamvvmremotelocaldb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.liveinbits.rxjavamvvmremotelocaldb.model.Employee;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private List<Employee> employeeList;
    public CustomAdapter(List<Employee> employeeList){
        this.employeeList=employeeList;
    }
    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        Employee employee=employeeList.get(position);
        holder.bind(employee);
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView firstname,lastname,age;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            firstname=itemView.findViewById(R.id.firstname);
            lastname=itemView.findViewById(R.id.lastname);
            age=itemView.findViewById(R.id.age);
        }

        public void bind(Employee employee) {
            this.firstname.setText(employee.getFirstname());
            this.lastname.setText(employee.getLastname());
         this.age.setText(employee.getAge());
        }
    }
}
