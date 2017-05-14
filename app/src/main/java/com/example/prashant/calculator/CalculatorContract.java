package com.example.prashant.calculator;

/**
 * Created by prashant on 22/3/17.
 */

public interface CalculatorContract {

    //Our view handles these methods(DisplayFragment)
    interface PublishToView{
        void showResult(String result);
        void showToastMessage(String message);
    }

    //passes click events from our DisplayFragment to the presenter
    interface ForwardDisplayIteractionToPresenter{
        void onDeleteShortClick();
        void onDeleteLongClick();
    }
    //passes click events from our InputFragemt to the presenter
    interface ForwardInputIteractionToPresenter{
        void onNumberClick(int number);
        void onOperatorClick(String operator);
        void onDecimalClick();
        void onEvaluateClick();
    }
}
