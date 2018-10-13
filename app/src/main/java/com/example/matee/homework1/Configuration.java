package com.example.matee.homework1;


import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class Configuration extends Fragment {

    public static final String MY_PREFS_NAME = "MyPrefsFile";

    public Configuration() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_configuration, container, false);
        RadioButton radio1 = (RadioButton) view.findViewById(R.id.radio1);
        radio1.setText("Google");
        RadioButton radio2 = (RadioButton) view.findViewById(R.id.radio2);
        radio2.setText("Yandex");
        RadioButton radio3 = (RadioButton) view.findViewById(R.id.radio3);
        radio3.setText("Bing");
        RadioGroup radiogroup = (RadioGroup) view.findViewById(R.id.radiogroup);

        radio1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor editor = getActivity().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                editor.putInt("radiobutton_selected", 1);
                editor.commit();
            }
        });

        radio2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor editor = getActivity().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                editor.putInt("radiobutton_selected", 2);
                editor.commit();
            }
        });

        radio3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor editor = getActivity().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                editor.putInt("radiobutton_selected", 3);
                editor.commit();
            }
        });

        /*View viewy = inflater.inflate(R.layout.fragment_configuration, container, false);
        ImageView imageView=(ImageView) viewy.findViewById(R.id.Configuration);
        imageView.setImageResource(R.drawable.gecko);
        return viewy;*/

        return view;
    }

    // Esto estaba en un fragment

    //registerContextMenu(TVadapte?);
    /*
    @Override
    public boolean onContextoitemSelected(MenuItem item){
        AdapterView.AdapterContextomenuInfo adapter = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch(item.getItemId()){
            case R.id.men_it_replace:
                break;
            case R.id.men_it_del:
                SQLiteDatabase database = dbhelper.getWritableDatabase();
                database.delete(dbhelper.TABLE_NAME, "name"+" = ?", new String[]{ListName.get(adapter.position)));
                ListName.clear();
                DataBaseAdd();
                break;
            default:
                return super.onContextItemSelected(item);
        }
        return true;
    }*/

    /*public void DataBaseAdd(){
        SQLiteDatabase database = dbhelper.getWritableDatabase();
        Cursor cursor = database.query(dbhelper.TABLENAME, null, null, null, null, null, null, null);
        if(cursor.moveToFirst()) {
            int id_index = cursor.getColumnIndex("id");
            int name_index = cursor.getColumnIndex("name");
            do {
                ListName.add(cursor.getString(name_index));
            } while (cursor.moveToNext());
        }else{
            Toast.makeText(getActivity(); "База данных не создана", Toast.LENGHT_SHORT).show();
        }
        cursor.close();
        database.close();
    }*/

    /*
    <item "add" "ydalíth" en un nuevo android resource file y creando Menu
    Usar un motor distinto de bases de datos que no sea SQL (URM... ? )
    Hacer una base de datos en donde se puedan ir agregando alumnos y modificando las motas de cada uno y borrarlas. Tiene que mostrarse en una especie de tabla y permitir seleccionar y eso.
     */

}
