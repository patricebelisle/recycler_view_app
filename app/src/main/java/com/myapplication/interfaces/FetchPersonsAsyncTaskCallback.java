package com.myapplication.interfaces;

import com.myapplication.models.Person;

/**
 * Created by patbelis on 18-08-06.
 */

public interface FetchPersonsAsyncTaskCallback {
    void onSuccess(Person[] persons);
}
