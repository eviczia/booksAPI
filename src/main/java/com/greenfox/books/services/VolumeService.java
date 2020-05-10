package com.greenfox.books.services;

import com.greenfox.books.models.entities.ReturnJSon;
import com.greenfox.books.models.entities.Volume;
import org.springframework.web.bind.annotation.PathVariable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface VolumeService {

    @GET("volumes")
    Call<ReturnJSon> receiveData(@Query("q") String searchParam);

    @GET("volumes/{volumeId}")
    Call<Volume> getBookByIdFromGoogleAPI(@Path("volumeId") String volumeId);
}
