package com.example.prashant.calculator;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;


public class calculator extends AppCompatActivity {

    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        manager = getSupportFragmentManager();

        DisplayFragment displayFragment = DisplayFragment.newInstance();
        InputFragment inputFragment = InputFragment.newInstance();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frag_display,displayFragment);
        transaction.add(R.id.frag_input, inputFragment);
        transaction.commit();

        CalculatorPresenter presenter = new CalculatorPresenter(displayFragment);
        displayFragment.setPresenter(presenter);
        inputFragment.setPresenter(presenter);

    }
}
