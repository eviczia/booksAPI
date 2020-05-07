package com.greenfox.books.services;

import com.greenfox.books.models.entities.ReturnJSon;
import com.greenfox.books.models.entities.Volume;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface VolumeService {

    @GET("/volumes")
//    Call<List<Volume>> receiveData(@Query("q") String searchParam);
    Call<ReturnJSon> receiveData(@Query("q") String searchParam);
}
