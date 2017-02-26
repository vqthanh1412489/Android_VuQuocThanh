package com.hsmus.tranngocyennhi.spinnerbasic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spMonHoc;
    ArrayList<CNew> arrayList;
    AdapterNew adapterNew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spMonHoc = (Spinner) findViewById(R.id.spinnerMonHoc);

        arrayList = new ArrayList<CNew>();

        AddMang();

        adapterNew = new AdapterNew(MainActivity.this, R.layout.line_new, arrayList);
        // Tạo khoảng cách cho các item trong Spinner
        //arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spMonHoc.setAdapter(adapterNew);

        // Không dung được onListener:

        spMonHoc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,arrayList.get(position).getNew(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void AddMang() {
        arrayList.add(new CNew("Calender",R.drawable.calender));
        arrayList.add(new CNew("Facebook",R.drawable.facebook));
        arrayList.add(new CNew("Google",R.drawable.google));
        arrayList.add(new CNew("Twitter",R.drawable.twitter));
        arrayList.add(new CNew("Yahoo",R.drawable.yahoo));

    }
}
