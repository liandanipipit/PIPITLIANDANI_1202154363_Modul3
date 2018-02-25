package com.pipitliandani.android.pipitliandani_1202154363_modul3;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView; //mendeklarasikan variabel recyclerView
    private ArrayList<Water> waters; //mendeklarasikan variabel water
    private RecyclerAdapter rAdapter; //mendeklarasikan variabel rAdapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =(RecyclerView)findViewById(R.id.recyclerView); //mencari RecyclerView dengan id recyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //mengatur layout recyclerView
        waters = new ArrayList<>(); //mendeklarasikan variabel array
        rAdapter = new RecyclerAdapter(this, waters); //mendeklarasikan nilai RecyclerAdapter
        recyclerView.setAdapter(rAdapter); //mengatur adapter variabel recyclerView

        initializeData(); //mengambil data

        //Helper class untuk membuat tipe action swipe to dismiss serta drag and drop functionality
        ItemTouchHelper helper =new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN
                        | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT ) {


             // Method yang mendefinisikan fungsi drag and drop

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();
                Collections.swap(waters, from, to);
                rAdapter.notifyItemMoved(from, to);
                return true;
            }
           //method untuk menbuat fungsi dismiss ketika objek di swiped
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                waters.remove(viewHolder.getAdapterPosition());
                rAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());

            }
        });

        helper.attachToRecyclerView(recyclerView); //Attach the helper to the RecyclerView

    }
    //methode untuk menginisiasi data
    private void initializeData(){
        String[] waterTitle = getResources().getStringArray(R.array.water_titles); //mendapat nilai array dengan nama water_titles
        String[] waterSubtitle = getResources().getStringArray(R.array.water_subtitle);  //mendapat nilai array dengan nama water_subtitles
        String[] waterDesc = getResources().getStringArray(R.array.desc);  //mendapat nilai array dengan nama desc
        TypedArray imageResources = getResources().obtainTypedArray(R.array.list_images); //mendapatkan nilai gambar
        waters.clear();
        //Membuat ArrayList dari objek Water dengan titles, images
        // and information about each water
        for (int i=0; i<waterTitle.length; i++){ //perulangan untuk membuat arraylist
            waters.add(new Water(waterTitle[i], waterSubtitle[i], waterDesc[i], imageResources.getResourceId(i,0)));
        }

        //Recycle imageResource
        imageResources.recycle();
        //memberitahu adapter terhada perubahan yang dibuat
        rAdapter.notifyDataSetChanged();


    }
    //method untuk mereset data
    public void resetWater(View v){

        initializeData();
    }

}
