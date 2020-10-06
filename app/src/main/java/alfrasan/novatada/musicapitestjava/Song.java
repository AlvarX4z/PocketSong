package alfrasan.novatada.musicapitestjava;

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

    public Song(String name, String group, String path) {

        this.name = name;
        this.group = group;
        this.path = path;

    }

    public Song(String name, String group, String path, String lyrics, int duration, int year) {

        this.name = name;
        this.group = group;
        this.path = path;
        this.lyrics = lyrics;
        this.duration = duration;
        this.year = year;

    }

    // ------------------------ GETTERS AND SETTERS ------------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
