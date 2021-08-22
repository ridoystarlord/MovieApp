package com.ridoy.movieapp.Service.Network;

import com.ridoy.movieapp.Service.Model.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {
    @GET("3/movie/top_rated?api_key=9ea48bd385ad3db7de609ff59b0cfe55")
    Call<MovieModel> getTopRatedMovieList();
}
