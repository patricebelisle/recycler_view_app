package com.myapplication.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myapplication.R;
import com.myapplication.models.Customer;
import com.myapplication.models.Employee;
import com.myapplication.models.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by patbelis on 18-08-06.
 */

public class PersonsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int CUSTOMER = 0;
    private static final int EMPLOYEE = 1;

    private Context context;
    private List<Person> personList = new ArrayList<>();

    public PersonsAdapter(Context context, List<Person> personList) {
        this.context = context;
        this.personList = personList;
    }

    public class CustomerViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView;
        TextView phoneNumberTextView;

        public CustomerViewHolder(View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.customer_name);
            phoneNumberTextView = itemView.findViewById(R.id.customer_phone_number);
        }

        public void setData(Customer customer) {
            nameTextView.setText(customer.getName());
            phoneNumberTextView.setText(customer.getPhoneNumber());
        }
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView;
        TextView phoneNumberTextView;
        TextView emailTextView;

        public EmployeeViewHolder(View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.employee_name);
            phoneNumberTextView = itemView.findViewById(R.id.employee_phone_number);
            emailTextView = itemView.findViewById(R.id.employee_email);
        }

        public void setData(Employee employee){
            nameTextView.setText(context.getResources().getString(R.string.employee_name_prefix, employee.getName()));
            phoneNumberTextView.setText(employee.getPhoneNumber());
            emailTextView.setText(employee.getEmail());
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case CUSTOMER:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customer_row, parent, false);
                return new CustomerViewHolder(view);
            case EMPLOYEE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_row, parent, false);
                return new EmployeeViewHolder(view);
            default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customer_row, parent, false);
                return new CustomerViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case CUSTOMER:
                CustomerViewHolder customerViewHolder = (CustomerViewHolder) holder;
                customerViewHolder.setData((Customer) personList.get(position));
                break;
            case EMPLOYEE:
                EmployeeViewHolder employeeViewHolder = (EmployeeViewHolder) holder;
                employeeViewHolder.setData((Employee) personList.get(position));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return personList.get(position) instanceof Employee ? EMPLOYEE : CUSTOMER;
    }
}
