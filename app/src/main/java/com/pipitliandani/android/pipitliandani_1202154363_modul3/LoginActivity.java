package com.pipitliandani.android.pipitliandani_1202154363_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class LoginActivity extends AppCompatActivity {
    TextView user, pass; //mendeklarasikan variabel user dan pass dengan jenis TextView
    Button btnClicked; //mendeklarasikan variabel btnClicked dengan jenis Button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); //mengambil resource layout activity.login
        user = (TextView)findViewById(R.id.username); //mencari TextView dengan id username
        pass = (TextView)findViewById(R.id.password); //mencari TextView dengan id password
        btnClicked = (Button)findViewById(R.id.login); //mencari Button dengan id login
        btnClicked.setOnClickListener(new View.OnClickListener() { //membuat event saat button di klik
            @Override
            public void onClick(View v) {
                String usernameKey = user.getText().toString(); //mengambil nilai string dari variabel user
                String passKey = pass.getText().toString(); //mengambil nilai string dari variabel pass
                if (usernameKey.equals("EAD") && passKey.equals("MOBILE")){ //jika username sama dengan EAD dan password sama dengan MOBILE
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class); //maka login berhasil dan berpindah ke halaman selanjutnya
                    startActivity(intent); //memulai aktivitas intent
                }
            }
        });


    }
}
