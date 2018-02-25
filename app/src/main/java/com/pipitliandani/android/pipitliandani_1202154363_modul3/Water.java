package com.pipitliandani.android.pipitliandani_1202154363_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by User on 24/02/2018.
 */

public class Water {
    private final int imageResource; //mendeklarasikan variabel imageResource
    private final String info; //mendeklarasikan variabel info
    private final String title; //mendeklarasikan variabel title
    private final String desc; //mendeklarasikan variabel desc

    static final String TITLE_KEY = "Title";    //membuat variabel untuk menampunga nama TITLE yang akan digunakan pada message intent
    static final String IMAGE_KEY = "Image Resource"; //membuat variabel untuk menampunga nama Image Resourc yang akan digunakan pada message intent
    static final String DESC_KEY = "Desc"; //membuat variabel untuk menampunga namaDesc yang akan digunakan pada message intent

    //Constructor untuk class data model (Water)

    public Water(String title, String info, String desc, int imageResource) {
        this.title = title;
        this.info = info;
        this.desc = desc;
        this.imageResource = imageResource;

    }
    String getTitle(){return title; } //mengambil nilai title
    String getInfo(){
        return info;
    } //mengambil nilai info
    String getDesc() {return desc; } //mengambil nilai description
    int getImageResource(){ //mengambil resource untuk image
        return imageResource;
    }
    static Intent starter(Context context, String title, String desc, @DrawableRes int imageResId){
        Intent detailIntent = new Intent(context, DetailActivity.class);  //mendeklarasikan intent
        detailIntent.putExtra(TITLE_KEY, title); //mengambil nilai key title ke intent
        detailIntent.putExtra(IMAGE_KEY, imageResId); //mengambil nilai key image ke intent
        detailIntent.putExtra(DESC_KEY, desc); //mengambil nilai key description ke intent
        return detailIntent; //mengembalikan nilai dtail intent
    }

}
