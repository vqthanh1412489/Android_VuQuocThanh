package com.hcmus.tranngocyennhi.alertdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    // Hàm bắt phím Back khi nhấn:
    @Override
    public void onBackPressed() {
        //XacNhanThoat();
        //super.onBackPressed(); // Có thể xóa luôn nè
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
        //XacNhanThoat();
    }

    private void XacNhanThoat() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        //để biết cái Alert Dialog nó ở bên màn hình này nhé!

        builder.setTitle("Thong bao");
        builder.setIcon(R.drawable.facebook);
        builder.setMessage("Ban co muon thoat");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //finish();
                MainActivity.super.onBackPressed(); // Thoát app. Cần thêm MainActivity đằng trước!
            }
        });

        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }
}
