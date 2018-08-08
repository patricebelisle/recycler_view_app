package com.myapplication.tasks;

import android.os.AsyncTask;

import com.myapplication.interfaces.FetchPersonsAsyncTaskCallback;
import com.myapplication.models.Customer;
import com.myapplication.models.Employee;
import com.myapplication.utils.ApiCaller;

/**
 * Created by patbelis on 18-08-06.
 */

public class FetchEmployeeTask extends AsyncTask<Void, Void, Employee[]> {

    private FetchPersonsAsyncTaskCallback fetchPersonsAsyncTaskCallback;

    public FetchEmployeeTask(FetchPersonsAsyncTaskCallback fetchPersonsAsyncTaskCallback) {
        this.fetchPersonsAsyncTaskCallback = fetchPersonsAsyncTaskCallback;
    }

    @Override
    protected Employee[] doInBackground(Void... voids) {
        return ApiCaller.getEmployees();
    }

    @Override
    protected void onPostExecute(Employee[] employees) {
        fetchPersonsAsyncTaskCallback.onSuccess(employees);
    }
}
