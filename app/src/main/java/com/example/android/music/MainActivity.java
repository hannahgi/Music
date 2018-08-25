package com.example.android.music;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    public ArrayList<Music> arrayList;
    public CustomGospelAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        getSupportActionBar ().setDisplayHomeAsUpEnabled (true);
        ListView gospel_music = (ListView) findViewById (R.id.Gospel_Music);
        arrayList= new ArrayList<> ();
        arrayList.add (new Music ("Albertina Walker", "i can go to God in prayer", R.raw.albertina_walker));
        arrayList.add (new Music ("Cece Winans", "Merccy said no", R.raw.chris_tomlin));
        arrayList.add (new Music ("Chris Tomlin", "Lord i need you", R.raw.chris_tomlin));
        arrayList.add (new Music ("Doen Moen", "God is Good", R.raw.don_moen));
        arrayList.add (new Music ("jimmie de plasmist ", "Lion of Judah", R.raw.chris_tomlin));
        arrayList.add (new Music ("john P", "Level next", R.raw.john_p));
        arrayList.add (new Music ("Kirk Franklin", "Dont have to worry", R.raw.kirk_franklin));
        arrayList.add (new Music ("Sinach", "Way Maker", R.raw.sinach_joseph));
        adapter=new CustomGospelAdapter (this,R.layout.custom_gospel,arrayList);
        gospel_music.setAdapter (adapter);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId ();
        if (id == android.R.id.home) {
            this.finish ();
        }
        return super.onOptionsItemSelected (item);
}}