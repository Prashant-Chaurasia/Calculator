package com.example.prashant.calculator;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment implements CalculatorContract.PublishToView {


    private CalculatorContract.ForwardDisplayIteractionToPresenter forwardInteraction;

    public void setPresenter(CalculatorContract.ForwardDisplayIteractionToPresenter forwardInteraction){
        this.forwardInteraction = forwardInteraction;
    }


    public DisplayFragment() {
        // Required empty public constructor
    }


    public DisplayFragment newInstance(){
        return new DisplayFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    //Butterknife use ..

    @BindView(R.id.tv_display) //equivalent to findViewById ..
    TextView display;

    @OnClick(R.id.imb_display_delete)
    public void onDeleteShortClick(View v){

    }
    @OnLongClick(R.id.imb_display_delete)
    public void onDeleteLongClick(View v){
        forwardInteraction.onDeleteShortClick();
    }

    @Override
    public void showResult(String result) {
    forwardInteraction.onDeleteLongClick();
    }

    @Override
    public void showToastMessage(String message) {

    }
}
