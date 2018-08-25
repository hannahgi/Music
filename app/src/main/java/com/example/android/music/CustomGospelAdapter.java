package com.example.android.music;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Gikonyo hannah on 17.04.2018.
 */

public class CustomGospelAdapter extends BaseAdapter {
    public Context context;
    public int Layout;
    public Boolean flag = true;
    public ArrayList<Music> arrayList;
    MediaPlayer mediaPlayer;

    public CustomGospelAdapter(Context context, int layout, ArrayList<Music> arrayList) {
        this.context = context;
        this.Layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size ();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public class ViewHolder {
        TextView name, artist, song;
        ImageView play;
        ImageView stop;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder ();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService (context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate (Layout, null);
            viewHolder.name = (TextView) convertView.findViewById (R.id.artist);
            viewHolder.artist = (TextView) convertView.findViewById (R.id.music);
            viewHolder.play = (ImageView) convertView.findViewById (R.id.play);
            viewHolder.stop = (ImageView) convertView.findViewById (R.id.stop);
            convertView.setTag (viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag ();
        }

        final Music music = arrayList.get (position);
        viewHolder.name.setText (music.getName ());
        viewHolder.artist.setText (music.getArtist ());
        viewHolder.play.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                if (flag) {
                    mediaPlayer = MediaPlayer.create (context, music.getSong ());
                    flag = false;
                }
                if (mediaPlayer.isPlaying ()) {
                    mediaPlayer.pause ();
                    viewHolder.play.setImageResource ((R.drawable.th_stop));


                } else {
                    mediaPlayer.start ();
                    viewHolder.play.setImageResource (R.drawable.th_start);
                }
            }
        });
        viewHolder.stop.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                if (!flag) {
                    mediaPlayer.stop ();
                    mediaPlayer.release ();
                    flag = true;
                }
                viewHolder.play.setImageResource (R.drawable.th_start);
            }
        });
        return convertView;
    }
}
