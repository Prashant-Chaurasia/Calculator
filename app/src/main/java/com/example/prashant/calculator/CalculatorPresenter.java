package com.example.prashant.calculator;

/**
 * Created by prashant on 22/3/17.
 */

public class CalculatorPresenter implements CalculatorContract.ForwardInputIteractionToPresenter,
        CalculatorContract.ForwardDisplayIteractionToPresenter {

    private CalculatorContract.PublishToView publishResult;

    //Parameter is an object of DisplayFragment .
    public CalculatorPresenter(CalculatorContract.PublishToView publishResult){
        this.publishResult = publishResult;
    }

    @Override
    public void onDeleteShortClick() {

    }

    @Override
    public void onDeleteLongClick() {

    }

    @Override
    public void onNumberClick(int number) {

    }

    @Override
    public void onOperatorClick(String operator) {

    }

    @Override
    public void onDecimalClick() {

    }

    @Override
    public void onEvaluateClick() {

    }
}
