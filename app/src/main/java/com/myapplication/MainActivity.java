package com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.myapplication.adapters.PersonsAdapter;
import com.myapplication.presenters.MainActivityPresenter;

public class MainActivity extends AppCompatActivity {

    private MainActivityPresenter mainActivityPresenter;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        setMainActivityPresenter(new MainActivityPresenter(this));
        mainActivityPresenter.onCreate();
    }

    private void setMainActivityPresenter(MainActivityPresenter mainActivityPresenter) {
        this.mainActivityPresenter = mainActivityPresenter;
    }

    private void initViews() {
        this.recyclerView = findViewById(R.id.recycler_view);
    }

    public void setAdapter(PersonsAdapter personsAdapter) {
        this.recyclerView.setAdapter(personsAdapter);
    }
}
