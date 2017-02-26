package com.hcmus.tranngocyennhi.animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgAlpha, imgScale, imgRotate;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddControl();

        // Tải hiệu ứng từ Resource vào Code animation
        final Animation animationAlpha = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_alpha);
        final Animation animationScale = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_scale);
        final Animation animationRotate = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_rotate);

        imgAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cách 1:
                //imgAvar.startAnimation(animationAlpha);
                // Cách 2:
                view.startAnimation(animationAlpha); // Sử dụng view cũng là chính nó
            }
        });

        imgScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animationScale);
            }
        });

        imgRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animationRotate);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    private void AddControl() {
        imgAlpha = (ImageView) findViewById(R.id.imageViewAvar);
        imgScale = (ImageView) findViewById(R.id.imageViewScale);
        imgRotate = (ImageView) findViewById(R.id.imageViewRotate);
        btn = (Button) findViewById(R.id.button);
    }
}
