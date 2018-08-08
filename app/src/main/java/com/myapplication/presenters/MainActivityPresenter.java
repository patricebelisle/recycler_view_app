package com.myapplication.presenters;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.myapplication.MainActivity;
import com.myapplication.adapters.PersonsAdapter;
import com.myapplication.interfaces.FetchPersonsAsyncTaskCallback;
import com.myapplication.models.Person;
import com.myapplication.tasks.FetchCustomerTask;
import com.myapplication.tasks.FetchEmployeeTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by patbelis on 18-08-06.
 */

public class MainActivityPresenter {

    private static final int NUMBER_OF_TASKS_TO_EXECUTE = 2;

    private final MainActivity mainActivity;

    private List<Person> personList = new ArrayList<>();
    private int taskFinishedCounter = 0;

    public MainActivityPresenter(@NonNull final MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void onCreate() {
        new FetchCustomerTask(new FetchPersonsAsyncTaskCallback() {
            @Override
            public void onSuccess(Person[] persons) {
                onTaskSuccess(persons);
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);


        new FetchEmployeeTask(new FetchPersonsAsyncTaskCallback() {
            @Override
            public void onSuccess(Person[] persons) {
                onTaskSuccess(persons);
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    private void onTaskSuccess(Person[] persons) {
        incrementTaskFinishedCounter();
        addPersons(persons);
        if (areAllTasksExecuted()) {
            Collections.sort(this.personList);
            setAdapter(createAdapter(this.personList));
        }
    }

    private void addPersons(Person[] persons) {
        if (persons != null) {
            this.personList.addAll(Arrays.asList(persons));
        }
    }

    private void incrementTaskFinishedCounter() {
        this.taskFinishedCounter++;
    }

    private boolean areAllTasksExecuted() {
        return NUMBER_OF_TASKS_TO_EXECUTE == this.taskFinishedCounter;
    }

    private PersonsAdapter createAdapter(List<Person> persons) {
        return new PersonsAdapter(mainActivity, persons);
    }

    private void setAdapter(PersonsAdapter personsAdapter) {
        mainActivity.setAdapter(personsAdapter);
    }

}
