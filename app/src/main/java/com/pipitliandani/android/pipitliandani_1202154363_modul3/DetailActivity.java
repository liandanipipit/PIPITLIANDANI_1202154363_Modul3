package com.pipitliandani.android.pipitliandani_1202154363_modul3;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;



public class DetailActivity extends AppCompatActivity {

    String filePict[] = {"ic_battery_30", "ic_battery_50_black", "ic_battery_60",
            "ic_battery_80", "ic_battery_90", "ic_battery_full"}; //mendeklarasikan variabel array untuk menampung list image

    int idx = 0; //index image yang akan digunakan untuk memanggil nilai array
    ImageButton btnMin, btnPlus; //mendeklarasikan variabel btnMin dan btnPlus berjenis ImageButton
    ImageView waterBattery, waterImage; //mendeklarasikan variabel waterBattery, waterImage berjenis ImageView
    TextView waterTitle, waterDescription; //mendeklarasikan variabel waterTitle, waterDescription berjenis TextView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        waterTitle = (TextView)findViewById(R.id.waterTitle); //mencari TextView dengan id waterTitle
        waterDescription = (TextView)findViewById(R.id.waterDesc); //mencari TextView dengan id waterDesc
        waterImage = (ImageView)findViewById(R.id.waterImage); //mencari TextView dengan id waterImage
        btnMin = (ImageButton) findViewById(R.id.imageButtonMin); //mencari ImageButton dengan id imageButtonMin
        btnPlus = (ImageButton) findViewById(R.id.imageButtonPlus); //mencari ImageButton dengan id imageButtonPlus
        waterBattery = (ImageView) findViewById(R.id.waterBattery); //mencari ImageButton dengan id waterBattery
        Drawable drawable = ContextCompat.getDrawable(this,
                getIntent().getIntExtra(Water.IMAGE_KEY, 0)); //mendeklarasikan variabel drawable dan mendapatkan nilai dari intent sebelumnya
        GradientDrawable gradientDrawable = new GradientDrawable(); //mendeklarasikan variabel gradientDrawable
        gradientDrawable.setColor(Color.GRAY); //mengatur warna gradientDrawable
        if (drawable != null){ //jika drawable tidak kosong
            gradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight()); //maka program akan mengatur ukuran drawable (drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight())
        }
        waterTitle.setText(getIntent().getStringExtra(Water.TITLE_KEY)); //mendapatkan nilai intent bernama TITLE_KEY dan mengaturnya kedalam variabel waterTitle
        waterDescription.setText(getIntent().getStringExtra(Water.DESC_KEY)); //mendapatkan nilai intent bernama DESC_KEY dan mengaturnya kedalam variabel waterDescription
        Glide.with(this).load(getIntent().getIntExtra(Water.IMAGE_KEY, 0)) //
                .placeholder(gradientDrawable).into(waterImage);

        //mengatur image sebagai list filePict dan index
        waterBattery.setImageResource(getResources().getIdentifier(filePict[idx], "drawable", getPackageName()));

        // button min disini bakal ngeset image lagi, tapi diliat dulu
        // kira-kira index imagenya lebihd dari 0 atau engga, soalnya kan yg paling kecil itu 0
        // kalo lebih dari 0 maka index akan di kurangi, dan ngeset image sesuai dengan index
        btnMin.setOnClickListener(new View.OnClickListener() { //membuat event ketika button min di klik
            @Override
            public void onClick(View v) {
                if(idx > 0) { //jika index lebih kecil dari 0 (karena indeks terkecil adalah 0
                    idx--; //maka indeks akan dikurangi 1
                    //mengatur gambar berdasarkan list filePict dan indeksnya
                    waterBattery.setImageResource(getResources().getIdentifier(filePict[idx], "drawable", getPackageName()));                       // waterBattery.setImageResource(getResources().getIdentifier(filePict[idx], "drawable", getPackageName()));
                    if (idx==0){ //jika indeks sama dengan nol
                        //maka akan menampilkan pesan toast bahwa air sedikit
                        Toast.makeText(DetailActivity.this, "Air Sedikit", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() { //membuat event ketika buttonPlus di klik
            @Override
            public void onClick(View v) {
                if (idx < 5){ //jika index lebih kecil dari 0 (karena indeks terkecil adalah 0
                    idx++; //maka indeks akan ditambah 1
                    //mengatur gambar berdasarkan list filePict dan indeksnya
                    waterBattery.setImageResource(getResources().getIdentifier(filePict[idx], "drawable", getPackageName()));
                    if (idx == 5){ //jika indeks sama dengan 5
                        //maka akan menampilkan pesan toast bahwa air Terisi Penuh
                        Toast.makeText(DetailActivity.this, "Air Terisi Penuh", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
    }
}
