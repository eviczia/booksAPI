package com.greenfox.books.services;

import com.greenfox.books.models.entities.ReturnJSon;
import com.greenfox.books.models.entities.Volume;
import com.greenfox.books.models.entities.VolumeInfo;
import com.greenfox.books.repositories.BookInfoRepository;
import com.greenfox.books.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private VolumeService volumeService;
    private BookRepository bookRepository;
    private BookInfoRepository bookInfoRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookInfoRepository bookInfoRepository) {
        this.bookRepository = bookRepository;
        this.bookInfoRepository = bookInfoRepository;
        buildRetrofit();
    }

    private void buildRetrofit() {
//        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/books/v1/")
                .addConverterFactory(GsonConverterFactory.create());
//                .client(httpClient.build());
        Retrofit retrofit = builder.build();
        volumeService = retrofit.create(VolumeService.class);
    }

    @Override
    public ReturnJSon processSearchTerm(String searchTerm) {
        Call<ReturnJSon> call = volumeService.receiveData(searchTerm);

        try {
            Response<ReturnJSon> response = call.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Volume getBookByIdFromGoogleAPI(String volumeId) {
        Call<Volume> call = volumeService.getBookByIdFromGoogleAPI(volumeId);
        try {
            Response<Volume> response = call.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

     /*   call.enqueue(new Callback<Volume>() {
            @Override
            public void onResponse(Call<Volume> call, Response<Volume> response) {
            }
            @Override
            public void onFailure(Call<Volume> call, Throwable t) {
            }
        });
        */
    }


/*
        try {
            Response<Volume> response = call.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
*/

    @Override
    public String keepBook(String bookId) {
        Volume chosenBook = getBookByIdFromGoogleAPI(bookId);
        bookRepository.save(chosenBook);
        VolumeInfo volumeInfo = bookRepository.findById(bookId).get().getVolumeInfo();
        bookInfoRepository.save(volumeInfo);
        System.out.println("yey");

        return ("Cool, I have new books now!");
    }

    @Override
    public ReturnJSon getMyBooks() {
        Integer myBookshelfSize = Math.toIntExact(bookRepository.count());
        ReturnJSon myBookshelf = new ReturnJSon("books#volumes", myBookshelfSize, bookRepository.findAll());
        return myBookshelf;
    }
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
        });
        */

