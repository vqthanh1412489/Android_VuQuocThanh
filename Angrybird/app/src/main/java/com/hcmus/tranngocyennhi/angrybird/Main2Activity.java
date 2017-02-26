package com.hcmus.tranngocyennhi.angrybird;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.Collections;
//    Bỏ AppCompat để chó nó nhỏ lại như thay đổi theme của nó
public class Main2Activity extends Activity {

    TableLayout tableLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tableLayout = (TableLayout) findViewById(R.id.myTableImage);

        // App Chạy :mới gán code cho Tablelayout
        int numCol = 3;
        int numRow = 6;

        // Đảo mảng ArrayList:
        Collections.shuffle(MainActivity.mangTenHinh);
        // 6 TableRow và mỗi TableRow có 3 ImageView .Chạy 2 vòng for.
        for (int i = 1; i <= numRow; i++) {
            TableRow tableRow = new TableRow(this);
            tableLayout.addView(tableRow); // Add dòng vào layout
            for (int j = 1; j <= numCol ; j++) {
                ImageView imageView = new ImageView(this);

                final int vitri = numCol * (i-1) + j - 1; // sao cho biến vị trí chạy từ 0 - > 17 là đc. ở đây chạy theo i và j
                int idHinh = getResources().getIdentifier(MainActivity.mangTenHinh.get(vitri), "drawable", getPackageName()); // Lấy hết hình ra
                // Gọi lại mảng bên MainActivity . để static public

                imageView.setImageResource(idHinh); // gắn vào imageView trong Tablelayout.

                // Chuyển DP thành PX : để hình không bị vỡ do độ phân giải màn hình:
                int dpUnit = 80;
                Resources r = getResources();
                float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpUnit, r.getDisplayMetrics());


                TableRow.LayoutParams layoutParams= new TableRow.LayoutParams((int) px,(int) px);

//                TableRow.LayoutParams layoutParams1 = new TableRow.LayoutParams(180, 180);
                // Kích thước cua từng tấm hình là 180px, 180px

                imageView.setLayoutParams(layoutParams); // Kích hoạt...

                // add hình vào dòng
                tableRow.addView(imageView);

                //Bắt tên hình ra
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Trả lại tên để đưa qua bên kia nhé! (MainActivity)
                        Intent intent = new Intent();
                        intent.putExtra("hinhchon", MainActivity.mangTenHinh.get(vitri));
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                });

            }
        }



    }
}
