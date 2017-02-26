package com.hcmus.tranngocyennhi.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    ImageView imgTranslate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imgTranslate = (ImageView) findViewById(R.id.imageViewTranslate);

        final Animation animationTranslate = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
        imgTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animationTranslate);
            }
        });
    }
}
