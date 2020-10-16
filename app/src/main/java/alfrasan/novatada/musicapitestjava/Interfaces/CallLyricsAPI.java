package alfrasan.novatada.musicapitestjava.Interfaces;

import alfrasan.novatada.musicapitestjava.Classes.SongAPI;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CallLyricsAPI {

    @GET("{group}/{song}?apikey=CXS5RvuDuOIy93tsBpSkthRS9CcxjeE5GDYNuCOz0pOAc9v70ImcUjg5EG5d1vHX")
    Call<SongAPI> loadLyrics(@Path("group") String group, @Path("song") String name);

}
