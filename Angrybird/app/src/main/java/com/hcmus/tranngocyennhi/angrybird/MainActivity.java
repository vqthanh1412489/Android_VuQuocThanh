package com.hcmus.tranngocyennhi.angrybird;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {

    ImageView imgTemp, imgSelect;
    public static ArrayList<String> mangTenHinh;
    TextView txtScore;

    int REQUEST_CODE_MAINACTIVITY2 = 247;
    int idHinh;
    Integer Score = 100;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddControl();

        // Lưu dữ liệu đơn giản (1 kiểu, 1 dữ liệu cho 1 Biến SharedPreferences):
        sharedPreferences = getSharedPreferences("score", MODE_PRIVATE); // Score đặt chơi thôi

        // Lấy dữ liệu ra:
        Score = sharedPreferences.getInt("diemSo", 0); // o la so mặc định

        if (Score == 0) {
            Score = 100;
        }

        AddEvents();
    }

    private void AddEvents() {
        String[] Name = getResources().getStringArray(R.array.arrayAngrebird); // Chua ten hinh

        // Đổ tên hình vào danh sách mangTenHinh // Chuyển kiểu String thành ArrayList
        mangTenHinh = new ArrayList<>(Arrays.asList(Name));
        txtScore.setText("" + Score);
        DoiHinh();

        imgSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Score > 0 && Score < 200) {
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivityForResult(intent, REQUEST_CODE_MAINACTIVITY2);
                } else if (Score >= 200) {
                    Toast.makeText(MainActivity.this, "Win", Toast.LENGTH_SHORT).show();

                } else {
                    //Toast.makeText(MainActivity.this, "Hết điểm - yêu cầu nộp card", Toast.LENGTH_SHORT).show();

                    final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Thông báo");
                    builder.setIcon(R.drawable.replay);
                    builder.setMessage("Thua! Chơi lại!");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            txtScore.setText(100 + "");
                            Score = Integer.parseInt(txtScore.getText().toString());
                        }
                    });

                    builder.setNegativeButton("EndGame", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();// TrucNgoc!
                        }
                    });

                    builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder.create().show();
                }
            }
        });
    }

    private void DoiHinh() {
        //Đảo mảng
        Collections.shuffle(mangTenHinh);
        // Ten hinh, loai, ten Packet
        idHinh = getResources().getIdentifier(mangTenHinh.get(0), "drawable", getPackageName());
        // Chuyển từ chuỗi "tên hình" sang ID trong Resource (ở đây là drawable):

        imgTemp.setImageResource(idHinh);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String _score = txtScore.getText().toString();
        Score = Integer.parseInt(_score);
        if (requestCode == REQUEST_CODE_MAINACTIVITY2 && resultCode == RESULT_OK && data != null) {

            String tenHinhChon = data.getStringExtra("hinhchon");
            //Gán hình
            int idHinhchon = getResources().getIdentifier(tenHinhChon, "drawable", getPackageName());
            imgSelect.setImageResource(idHinhchon);

            //So sanh id
            if (idHinh == idHinhchon) {
                Toast.makeText(this, "Đúng rồi! +10đ", Toast.LENGTH_SHORT).show();
                Score = Score + 10;

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("diemSo", Score);
                editor.commit(); // Xác định lưu


            } else {
                Toast.makeText(this, "Sai rồi con chó! -10đ", Toast.LENGTH_SHORT).show();
                Score -= 50;

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("diemSo", Score);
                editor.commit();
            }
        }

        //Không cho Back về để quay lại xem hình: khi chưa chọn
        if (requestCode == REQUEST_CODE_MAINACTIVITY2 && resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Mày chưa chọn hình! Tao đổi lại nhé! Ngu à! Trừ Mày 50đ", Toast.LENGTH_SHORT).show();
            Score -= 50;
            DoiHinh();
        }
        txtScore.setText(String.valueOf(Score));
    }


    private void AddControl() {
        imgTemp = (ImageView) findViewById(R.id.imageViewTemp);
        imgSelect = (ImageView) findViewById(R.id.imageViewSelect);
        txtScore = (TextView) findViewById(R.id.textViewScore);
    }

    // Bắt sự kiện người dùng chọn Menu:
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Trả về item thôi. Để bắ được sự kiện nào thì cần gọi id của nó để so sánh với cái mình đã đặt bên file .xml

        // Get id của menu đó ra khi chọn: Đặt menu bên file xml
        switch (item.getItemId()) {
            case R.id.menuSetting:
                Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuReload:
                DoiHinh();
                break;
            case R.id.menuShare:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    // Tao Menu: Gọi nó ra
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Gắn menu vào:
        getMenuInflater().inflate(R.menu.menu_reload, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
