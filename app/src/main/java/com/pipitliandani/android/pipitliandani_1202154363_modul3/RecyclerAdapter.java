package com.pipitliandani.android.pipitliandani_1202154363_modul3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by User on 23/02/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private GradientDrawable gradientDrawable; //mendeklarasikan variabel gradientDrawable
    private ArrayList<Water> mwaterData; //mendeklarasikan variabel mwaterData
    private Context mcontext; //mendeklarasikan variabel mcontext

     //Constructor yang dipakai untuk menghubungkan data dan context
    RecyclerAdapter(Context context, ArrayList<Water> waterData) {
        this.mwaterData = waterData;
        this.mcontext = context;
        gradientDrawable = new GradientDrawable();
        //Menyiapkan gray placeholder
        gradientDrawable.setColor(Color.GRAY);

        //Membuat ukuran placeholder sama dengan ukuran gambar
        Drawable drawable = ContextCompat.getDrawable(mcontext, R.drawable.ades); //membuat variable drawable, dengan mcontext dan image ades
        if (drawable != null) { //jika drawable tidak sama dengan nol
            gradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight()); //mengatur ukuran placeholder supaya sama denga ukuran gambar
        }
    }

//method untuk membuat objek viewholder (ViewGroup parent, int viewType)
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerAdapter.ViewHolder(mcontext, LayoutInflater.from(mcontext)                                                                                                     //return new RecyclerAdapter.ViewHolder(mcontext, LayoutInflater.from(mcontext).inflate(R.layout.list_item, parent, false), gradientDrawable);
                .inflate(R.layout.list_item, parent, false), gradientDrawable);
    }
//method yang memasukkan the data ke viewholder.
    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
        Water currentWater = mwaterData.get(position);
        holder.bindTo(currentWater);

    }
//method untuk menentukan ukuran data set
   @Override
    public int getItemCount() {
        return mwaterData.size();
    }
//Member Variables for the holder data
    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTitleText; //mendeklarasikan variabel mTitleText
        private TextView mInfoText; //mendeklarasikan variabel  mInfoText
        private ImageView mWaterImage; //mendeklarasikan variabel mWaterImage
        private Context mContext; //mendeklarasikan variabel mContext
        private Water mCurrentWater; //mendeklarasikan variabel mCurrentWater
        private GradientDrawable mGradientDrrawable; //mendeklarasikan variabel  mGradientDrrawable

        ViewHolder(Context context, View itemView, GradientDrawable gradientDrawable) {
            super(itemView);
            mTitleText = (TextView)itemView.findViewById(R.id.title); //mencari TextView dengan id title
            mInfoText = (TextView)itemView.findViewById(R.id.subtitle); //mencari TextView dengan id subtitle
            mWaterImage = (ImageView)itemView.findViewById(R.id.imageWater);//mencari ImageView dengan id imageWater
            mContext = context;  //mendapatkan nilai context
            mGradientDrrawable = gradientDrawable; //mendapatkan nilai gradientDrawable
            itemView.setOnClickListener(this); //membuat event ketika itemView di klik

        }
        void bindTo(Water currentWater){
            mTitleText.setText(currentWater.getTitle()); //mengisi the textview mTitleText dengan data
            mInfoText.setText(currentWater.getInfo()); //mengisi the textview mInfoText dengan data
            mCurrentWater = currentWater; //mendapatkan nilai current water

           //Memuat gambar ke dalam ImageView menggunakan Glide library
            Glide.with(mContext).load(currentWater.getImageResource()).placeholder(mGradientDrrawable).into(mWaterImage);
        }

        @Override
        public void onClick (View view) {
            //mengatur intent
            Intent intent = Water.starter(mContext, mCurrentWater.getTitle(), mCurrentWater.getDesc(), mCurrentWater.getImageResource());
            //memulai aktivitas intent
            mContext.startActivity(intent);
        }

    }
}
