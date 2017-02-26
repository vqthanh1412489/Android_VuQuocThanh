package com.hcmus.tranngocyennhi0105.seekbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SeekBar skVolume;
    //Có thể kéo, không như progreeBar
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        skVolume = (SeekBar) findViewById(R.id.seekBarVolume);

        skVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            // Khi thay dổi giá trị
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Biến progress trả về giá trị hiện tại của Seekbar
                if (progress == 0){
                    Toast.makeText(MainActivity.this, "Min", Toast.LENGTH_SHORT).show();
                    seekBar.setThumb(getResources().getDrawable(R.drawable.o));
                }
                if (progress == seekBar.getMax()){
                    Toast.makeText(MainActivity.this, "Max", Toast.LENGTH_SHORT).show();
                    seekBar.setThumb(getResources().getDrawable(R.drawable.x));
                }
            }

            // vừa chạm vào
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // ...
            }
            // vừa bỏ ra
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //...
            }
        });
    }
}
