package com.ridoy.movieapp.Service.Repository;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.ridoy.movieapp.Service.Model.MovieModel;
import com.ridoy.movieapp.Service.Model.Result;
import com.ridoy.movieapp.Service.Network.ApiServices;
import com.ridoy.movieapp.Service.Network.RetrofitInstrance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private static Context mCtx;
    private static volatile MovieRepository movieRepository = null;
    private List<Result> resultList;
    private MutableLiveData mutableLiveData = null;

    public static MovieRepository getInstance(Context context) {
        if (movieRepository == null) {
            mCtx = context;
            movieRepository = new MovieRepository();
        }
        return movieRepository;
    }

    public MutableLiveData<List<Result>> getTopRatedMovieList() {

        if (mutableLiveData == null) {
            mutableLiveData = new MutableLiveData();
        }
        ApiServices api = RetrofitInstrance.getRetrofitInstance().create(ApiServices.class);
        Call<MovieModel> movieCall = api.getTopRatedMovieList();
        movieCall.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {

                MovieModel movieModel = response.body();
                resultList = movieModel.getResults();
                mutableLiveData.postValue(resultList);

            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {
                Toast.makeText(mCtx, "Error: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return mutableLiveData;
    }
}
