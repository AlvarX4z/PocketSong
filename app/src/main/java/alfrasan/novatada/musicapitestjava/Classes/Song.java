package alfrasan.novatada.musicapitestjava.Classes;

public final class Song {

    private static final String UNKNOWN_SONG = "Unknown Song";
    private static final String UNKNOWN_GROUP = "Unknown Group";
    private static final String UNKNOWN_PATH = "Unknown Path";
    private static final String UNKNOWN_LYRICS = "Lyrics unavailable";

    // ------------------------ FIELDS ------------------------

    private String name;
    private String group;
    private String path;
    private String lyrics;
    private int duration;
    private int year;

    // ------------------------ CONSTRUCTORS ------------------------

    public Song() { }

    public Song(String path) { setPath(path); }

    public Song(String name, String path) {

        setName(name);
        setPath(path);
        setGroup("");

    }

    public Song(String name, String group, String path) {

        setName(name);
        setGroup(group);
        setPath(path);

    }

    public Song(String name, String group, String path, String lyrics, int duration, int year) {

        setName(name);
        setGroup(group);
        setPath(path);
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

        if (name.equalsIgnoreCase("")) {

            this.name = UNKNOWN_SONG;

        } else { this.name = name; }

    }

    public void setGroup(String group) {

        if (group.equalsIgnoreCase("")) {

            this.group = UNKNOWN_GROUP;

        } else { this.group = group; }

    }

    public void setPath(String path) {

        if (path.equalsIgnoreCase("")) {

            this.path = UNKNOWN_PATH;

        } else { this.path = path; }

    }

    public void setLyrics(String lyrics) {

        if (lyrics.equalsIgnoreCase("")) {

            this.lyrics = UNKNOWN_LYRICS;

        } else { this.lyrics = lyrics; }

    }

    public void setDuration(int duration) { this.duration = duration; }

    public void setYear(int year) { this.year = year; }

}
