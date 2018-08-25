package com.example.android.music;

/**
 * Created by Gikonyo hannah on 17.04.2018.
 */

public class Music {

    public String artist;
    public String name;
    public int song;

    public Music(String name, String artist, int song) {
        this.name = name;
        this.artist = artist;
        this.song = song;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getSong() {
        return song;
    }

    public void setSong(int song) {
        this.song = song;
    }
}
