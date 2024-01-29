package com.example.retrofitwithrecyclerview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET ("quotes")
    Call<List<QuotesModel>> getQuotes();
}
