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
public class DisplayFragment extends Fragment {
    public DisplayFragment() {
        // Required empty public constructor
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
    public void onShortClick(View v){

    }
    @OnLongClick(R.id.imb_display_delete)
    public void onLongClick(View v){
        
    }

}
