package alfrasan.novatada.musicapitestjava.Classes;

public final class Result {

    private Artist artist;
    private Track track;
    private Copyright copyright;
    private long probability;
    private long similarity;

    public Result() {}

    public Artist getArtist() { return artist; }
    public void setArtist(Artist value) { this.artist = value; }

    public Track getTrack() { return track; }
    public void setTrack(Track value) { this.track = value; }

    public Copyright getCopyright() { return copyright; }
    public void setCopyright(Copyright value) { this.copyright = value; }

    public long getProbability() { return probability; }
    public void setProbability(long value) { this.probability = value; }

    public long getSimilarity() { return similarity; }
    public void setSimilarity(long value) { this.similarity = value; }

}
