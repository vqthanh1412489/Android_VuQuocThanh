package com.hcmus.tranngocyennhi0105.edittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText edtSo1, edtSo2;
    Button btnTinh;
    TextView txtKetQua;

    // Hàm kiểm tra chuỗi toàn số:
    public static boolean CheckNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '1' || str.charAt(i) > '9')
                return false;
        }
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtKetQua = (TextView) findViewById(R.id.textViewKetQua);
        btnTinh = (Button) findViewById(R.id.buttonTinh);

        edtSo1 = (EditText) findViewById(R.id.editTextSo1);
        edtSo2 = (EditText) findViewById(R.id.editTextSo2);

        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String so1 = edtSo1.getText().toString();
                String so2 = edtSo2.getText().toString();
                //Kiem tra chuoi rong
                // so1.isEmpty()
                //TextUtils.isEmpty(so1)
                //so1.matches("") : co trung voi string "" hay k
                //.equals("") : co bang voi string "" hay k
                //.trim().length() == 0
             

                // Hiển thị lỗi khi rỗng trên edittext!
                if (so1.isEmpty()){
                    edtSo1.setError("Chua nhap so 1");
                }
                if (so2.isEmpty()){
                    edtSo2.setError("Chua nhap so 2");
                }
                // Kiểm tra rỗng và nhập sai dữ liệu:
                if (CheckNumber(so1) == false || CheckNumber(so2) == false) {
                    Toast.makeText(MainActivity.this, "Nhập tham số bị sai!", Toast.LENGTH_LONG).show();
                    txtKetQua.setText("");
                }
                else if (so1.isEmpty() || so2.isEmpty()){
                    Toast.makeText(MainActivity.this, "Nhập thiếu!", Toast.LENGTH_LONG).show();
                    txtKetQua.setText("");
                }

                else{
                    Integer _so1 = Integer.parseInt(so1);
                    Integer _so2 = Integer.parseInt(so2);
                    Integer _kq = _so1 + _so2;
                    txtKetQua.setText(String.valueOf(_kq));
                }


                //Chi tiet:



            }
        });
    }
}
