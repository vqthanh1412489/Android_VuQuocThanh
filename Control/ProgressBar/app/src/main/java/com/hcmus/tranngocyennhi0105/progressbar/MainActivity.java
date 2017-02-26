package com.hcmus.tranngocyennhi0105.progressbar;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnDoawLoad;
    ProgressBar progressBar;
    int progressCurrent;
    long i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDoawLoad = (Button) findViewById(R.id.buttonDownLoad);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        btnDoawLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                CountDownTimer countDownTimer = new CountDownTimer(5000,500) {
                    @Override
//                    Bắt sư kiện từng giây ; ở đây là 1000
                    public void onTick(long millisUntilFinished) {
                        // Lây tra vị trí hiện tại của thanh progressBar
                        progressCurrent = progressBar.getProgress();
                        // Đặt lại vị trí cho thanh ProgressBar với giá trị mới
                        if (progressCurrent >= progressBar.getMax())
                        {
                           progressCurrent = 0;
                        }
                        progressBar.setProgress(progressCurrent + progressBar.getMax()/5);
                        //progressBar.setSecondaryProgress(progressBar.getProgress()+ 10);
                    }
                    // Hoàn thành xong
                    @Override
                    public void onFinish() {
                            Toast.makeText(MainActivity.this, "Done", Toast.LENGTH_SHORT).show();
                            start();
                            progressBar.setProgress(0);
                    }
                };
                countDownTimer.start();
            }
        });
    }
}
