package com.example.matee.homework1;


import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;
import static com.example.matee.homework1.Configuration.MY_PREFS_NAME;


/**
 * A simple {@link Fragment} subclass.
 */
public class Search extends Fragment {

    public static final String MY_PREFS_NAME = "MyPrefsFile";
    private EditText outputet;
    private Integer radiobutton_option = 0;

    public Search() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        outputet = (EditText) view.findViewById(R.id.et);
        outputet.setText("Введите текст");
        outputet.setSelectAllOnFocus(true);
        Button button_search2 = (Button) view.findViewById(R.id.button_search2);


        SharedPreferences prefs = getActivity().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        radiobutton_option = prefs.getInt("radiobutton_selected", 0); // "0" is the default value.


        if(radiobutton_option == 1){
            button_search2.setText("Искать в Google!");
        }else if(radiobutton_option == 2){
            button_search2.setText("Искать в Яндекс!");
        }else if(radiobutton_option == 3){
            button_search2.setText("Искать в Bing!");
        }else{
            button_search2.setText("Искать");
        }

        button_search2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //https://www.google.com/#q=
                if(radiobutton_option == 1){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/#q=" + outputet.getText())));
                }else if(radiobutton_option == 2){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://yandex.ru/search/?text=" + outputet.getText())));
                }else if(radiobutton_option == 3){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bing.com/search?q=" + outputet.getText())));
                }else{
                    Toast.makeText(getActivity().getApplicationContext(), "Нужно выбрать SearchEngine!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

}
