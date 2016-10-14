package com.b_pachango.jm.recyclerlistview_test.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.b_pachango.jm.recyclerlistview_test.MainActivity;
import com.b_pachango.jm.recyclerlistview_test.R;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Splash_Screen extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);
        //animation y cargar el xml
        ImageView logo = (ImageView) findViewById(R.id.iViewLogo);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.animation_splash);
        logo.setAnimation(anim);

        //se usa para modificar la user interface
        Handler handler = new Handler();
        //runnablable ong y toempo
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash_Screen.this, MainActivity.class));
                //para acabar la activity y evitar el back button
                finish();
            }
        }, 4000);

    }
}
