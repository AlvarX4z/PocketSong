package alfrasan.novatada.musicapitestjava;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Test {

    @GET("{songGroup}/{songName}?apikey=CXS5RvuDuOIy93tsBpSkthRS9CcxjeE5GDYNuCOz0pOAc9v70ImcUjg5EG5d1vHX")
    public Call<FragmentInfo> find(@Path("songGroup") String songGroupURL, @Path("songName") String songNameURL);

}
