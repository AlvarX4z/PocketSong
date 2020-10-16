package alfrasan.novatada.musicapitestjava.Classes;

public final class Track {

    private String name;
    private String text;
    private Lang lang;

    public Track() {}

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getText() { return text; }
    public void setText(String value) { this.text = value; }

    public Lang getLang() { return lang; }
    public void setLang(Lang value) { this.lang = value; }

}
