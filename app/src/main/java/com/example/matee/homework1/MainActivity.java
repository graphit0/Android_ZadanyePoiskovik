package com.example.matee.homework1;

import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String MY_PREFS_NAME = "MyPrefsFile";
    private Button button_config, button_search, button_exit;
    private Fragment frag;
    //private Configuration config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_config = findViewById(R.id.button_config);
        button_search = findViewById(R.id.button_search);
        button_exit = findViewById(R.id.button_exit);

        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.remove("radiobutton_selected");
        editor.commit();

        frag = new ByDefault();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.shown_fragment, frag);
        transaction.commit();

        button_config.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "К настройкам", Toast.LENGTH_SHORT);
                toast.show();

                findViewById(R.id.imageView).setVisibility(View.INVISIBLE);
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                frag = new Configuration();
                transaction.replace(R.id.shown_fragment, frag);
                transaction.commit();
            }
        });

        button_search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "К поиску", Toast.LENGTH_SHORT);
                toast.show();

                findViewById(R.id.imageView).setVisibility(View.INVISIBLE);
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                frag = new Search();
                transaction.replace(R.id.shown_fragment, frag);
                transaction.commit();
            }
        });

        button_exit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Пока!", Toast.LENGTH_SHORT);
                toast.show();

                button_exit.postDelayed(new Runnable() {
                    public void run() {
                        button_exit.setClickable(true);
                    }
                }, 1000);

                finish();
                System.exit(0);
            }
        });
    }
}
