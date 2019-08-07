package interview.cmush.shauri;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UshauriApiService {
    @GET("fortune")
    Call<Fortune> getFortune();
}
