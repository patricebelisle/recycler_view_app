package com.myapplication.tasks;

import android.os.AsyncTask;

import com.myapplication.interfaces.FetchPersonsAsyncTaskCallback;
import com.myapplication.models.Customer;
import com.myapplication.utils.ApiCaller;

/**
 * Created by patbelis on 18-08-06.
 */

public class FetchCustomerTask extends AsyncTask<Void, Void, Customer[]> {

    private FetchPersonsAsyncTaskCallback fetchPersonsAsyncTaskCallback;

    public FetchCustomerTask(FetchPersonsAsyncTaskCallback fetchPersonsAsyncTaskCallback) {
        this.fetchPersonsAsyncTaskCallback = fetchPersonsAsyncTaskCallback;
    }

    @Override
    protected Customer[] doInBackground(Void... voids) {
        return ApiCaller.getCustomers();
    }

    @Override
    protected void onPostExecute(Customer[] customers) {
        fetchPersonsAsyncTaskCallback.onSuccess(customers);
    }
}
