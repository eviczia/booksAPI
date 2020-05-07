package com.greenfox.books.services;

//import com.greenfox.books.models.entities.Volume;
import com.greenfox.books.models.entities.Volume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private VolumeService volumeService;

    @Autowired
    public BookServiceImpl() {
        buildRetrofit();
    }

    private void buildRetrofit() {
//        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder builder = new Retrofit.Builder()
//                .baseUrl("https://api.github.com/users/")
                .baseUrl("https://www.googleapis.com/books/v1/")
                .addConverterFactory(JacksonConverterFactory.create());
//                .client(httpClient.build());
        Retrofit retrofit = builder.build();
        volumeService = retrofit.create(VolumeService.class);
    }



    @Override
    public List<Volume> processSearchTerm(String searchTerm) {
        Call<List<Volume>> call = volumeService.receiveData(searchTerm);
        List<Volume> queriedBooks = new ArrayList<>();
        try {
            Response<List<Volume>> response = call.execute();
            return response.body();


        } catch (IOException e) {
            e.printStackTrace();
        }

/*        call.enqueue(new Callback<List<Volume>>() {

            @Override
            public void onResponse(Call<List<Volume>> call, Response<List<Volume>> response) {
                if (response.isSuccessful()) {
                    System.out.println("great, success!");
                } else {
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<Volume>> call, Throwable t) {
                t.printStackTrace();
            }
        });*/

        return queriedBooks;
    }
}
