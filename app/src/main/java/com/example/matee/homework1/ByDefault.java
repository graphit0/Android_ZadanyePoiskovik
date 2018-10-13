package com.example.matee.homework1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ByDefault extends Fragment {


    public ByDefault() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_by_default, container, false);
        TextView output= (TextView)view.findViewById(R.id.tv_bydefault);
        ImageView image = (ImageView)view.findViewById(R.id.img);
        image.setImageResource(R.drawable.androidlogo);
        //output.setText("I am the default fragment :)");
        return view;
    }

}
