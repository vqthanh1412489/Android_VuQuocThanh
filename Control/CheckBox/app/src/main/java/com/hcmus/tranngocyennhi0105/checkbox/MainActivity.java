package com.hcmus.tranngocyennhi0105.checkbox;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.CollapsibleActionView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox cbAndroid, cbIOS, cbPHP;
    RelativeLayout ManHinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbAndroid = (CheckBox) findViewById(R.id.checkBoxAndroid);
        cbPHP = (CheckBox) findViewById(R.id.checkBoxPHP);
        cbIOS = (CheckBox) findViewById(R.id.checkBoxIOS);
        ManHinh = (RelativeLayout) findViewById(R.id.ManHinh);


        //Kiểm tra xem Checkbox có đc check hay không?
        //cbAndroid.isChecked(); // Trả về true nếu đã check, ngược lại là không check
        cbAndroid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // isChecked tra ket qua khi check
                if (isChecked){
                    ManHinh.setBackgroundResource(R.drawable.android);
                }
                else {
                    ManHinh.setBackgroundColor(Color.rgb(100,120,100));
                }
            }
        });
        cbPHP.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ManHinh.setBackgroundResource(R.drawable.php);
                }
                else {
                    ManHinh.setBackgroundColor(Color.YELLOW);
                }
            }
        });

        cbIOS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ManHinh.setBackgroundResource(R.drawable.ios);
                }
                else {
                    ManHinh.setBackgroundColor(Color.GREEN);
                }
            }
        });

    }
}
