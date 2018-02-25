package com.pipitliandani.android.pipitliandani_1202154363_modul3;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {
    private static int splashInterval = 2000; //mendeklarasikan nilai interval

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE); //meminta request Window
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //mengatur Flags window
        setContentView(R.layout.activity_splash_screen); //menampilkan layout activity_splash_screen

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, LoginActivity.class); //membuat intent
                startActivity(intent); //Memulai Intent
                Toast.makeText(SplashScreen.this, "Selamat Datang", Toast.LENGTH_LONG).show(); //Membuat teks Toast
                this.finish(); //mengakhiri session
            }
            private void finish(){ //method untuk mengakhiri session

            }
        }, splashInterval); ////mengakhiri splashScreen dengan interval 2000

    }

}
