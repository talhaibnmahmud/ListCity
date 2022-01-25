package com.example.simpleparadox.listycity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class ShowActivity extends AppCompatActivity {
    TextView textView;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.show_activity);
        textView = findViewById(R.id.textView1);
        button = findViewById(R.id.button1);
        Bundle bundle = getIntent().getExtras();
        textView.setText(bundle.getString("cityname001"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowActivity.this.finish();
            }
        });
    }
}
