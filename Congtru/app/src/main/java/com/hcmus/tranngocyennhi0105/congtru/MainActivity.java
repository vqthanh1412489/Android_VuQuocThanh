package com.hcmus.tranngocyennhi0105.congtru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtSo;
    Button btnCong, btnTru;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSo = (TextView) findViewById(R.id.textViewSo);
        btnCong = (Button) findViewById(R.id.buttonCong);
        btnTru = (Button) findViewById(R.id.buttonTru);

        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer _so = Integer.parseInt(txtSo.getText().toString());
                _so--;
                if (_so < 10 && _so >= 0){
                    txtSo.setText("0" + _so);
                }
                else{
                    txtSo.setText("" + _so);
                }

            }
        });

        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer _so = Integer.parseInt(txtSo.getText().toString());
                _so++;
                if (_so < 10 && _so >= 0){
                    txtSo.setText("0" + _so);
                }
                else{
                    txtSo.setText("" + _so);
                }
            }
        });
    }
}
