package com.hcmus.tranngocyennhi0105.radiobutton;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RadioGroup rdgThoiGian;
    RelativeLayout ManHinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdgThoiGian = (RadioGroup) findViewById(R.id.radioGroupThoiGian);
        ManHinh = (RelativeLayout) findViewById(R.id.ManHinh);

        // Cung co the dung isChecked de kiem tra cho tung radionButton có được Checked hay không!
        rdgThoiGian.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            // Giống như là checkbox sự kiện thau đổi khi vừa kích vào không cần sử dụng button tổng!
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //checkedId trả về id của Radion Button được check
                switch (checkedId)
                {
                    case R.id.radioButtonSang: // Lấy id của button đã chọn theo tên đã đặt bên kia.
                        ManHinh.setBackgroundColor(Color.rgb(159,153,241));
                        break; // Nhớ là phải có break.
                    case R.id.radioButtonTrua:
                        ManHinh.setBackgroundColor(Color.YELLOW);
                        break;
                    case R.id.radioButtonChieu:
                        ManHinh.setBackgroundColor(Color.GREEN);
                        break;
                }
            }
        });
    }
}
