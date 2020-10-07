package alfrasan.novatada.musicapitestjava;

import android.content.res.Resources;

public class Song {

    // ------------------------ FIELDS ------------------------

    private String name;
    private String group;
    private String path;
    private String lyrics;
    private int duration;
    private int year;

    // ------------------------ CONSTRUCTORS ------------------------

    public Song() { }

    public Song(String name, String group) {

        this.name = name;
        this.group = group;

    }

    public Song(String name, String group, String path) {

        setName(name);
        this.group = group;
        this.path = path;

    }

    public Song(String name, String group, String path, String lyrics, int duration, int year) {

        setName(name);
        this.group = group;
        this.path = path;
        this.lyrics = lyrics;
        this.duration = duration;
        this.year = year;

    }

    // ------------------------ GETTERS ------------------------

    public String getName() { return name; }

    public String getGroup() { return group; }

    public String getPath() { return path; }

    public String getLyrics() { return lyrics; }

    public int getDuration() { return duration; }

    public int getYear() { return year; }

    // ------------------------ SETTERS ------------------------

    public void setName(String name) {

        if (name.equalsIgnoreCase("Chlorine") || name.isEmpty()) {

            // this.name = Resources.getSystem().getString(R.string.unknown_song);
            this.name = "Bandit";

        } else { this.name = name; }

    }

    public void setGroup(String group) { this.group = group; }

    public void setPath(String path) { this.path = path; }

    public void setLyrics(String lyrics) { this.lyrics = lyrics; }

    public void setDuration(int duration) { this.duration = duration; }

    public void setYear(int year) { this.year = year; }

}
