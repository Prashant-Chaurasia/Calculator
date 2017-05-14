package com.example.prashant.calculator;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class InputFragment extends Fragment {

    private CalculatorContract.ForwardInputIteractionToPresenter forwardInteraction;

    public void setPresenter(CalculatorContract.ForwardInputIteractionToPresenter forwardInteraction){
        this.forwardInteraction = forwardInteraction;
    }

    public InputFragment() {
        // Required empty public constructor
    }

    public static InputFragment newInstance(){
        return new InputFragment();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_input, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    //Butterknife use ..

    @OnClick({R.id.btn_number_one,R.id.btn_number_two,R.id.btn_number_three,
            R.id.btn_number_four,R.id.btn_number_five,R.id.btn_number_six,
            R.id.btn_number_seven,R.id.btn_number_eight,R.id.btn_number_nine})
    public void onNumberClick(Button b){
        forwardInteraction.onNumberClick(
                Integer.parseInt(b.getText().toString()));
    }

    @OnClick({R.id.btn_operator_add,R.id.btn_operator_multiply,
            R.id.btn_operator_subtract, R.id.btn_operator_divide})
    public void onOperatorClick(Button b){
        forwardInteraction.onOperatorClick(
                b.getText().toString());
    }

    @OnClick(R.id.btn_decimal)
    public void onDecimalClick(Button b){
        forwardInteraction.onDecimalClick();
    }

    @OnClick(R.id.btn_evaluate)
    public void onEvaluateClick(Button b){
        forwardInteraction.onEvaluateClick();
    }
}
