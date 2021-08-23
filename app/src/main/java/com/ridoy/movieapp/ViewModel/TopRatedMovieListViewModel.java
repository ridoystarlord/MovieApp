package com.ridoy.movieapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ridoy.movieapp.Model.ModelClass.Result;
import com.ridoy.movieapp.Model.Repository.MovieRepository;

import java.util.List;

public class TopRatedMovieListViewModel extends AndroidViewModel {

    private MovieRepository topRatedMovieRepository;

    public TopRatedMovieListViewModel(@NonNull Application application) {
        super(application);
        topRatedMovieRepository=MovieRepository.getInstance(application);
    }
    public LiveData<List<Result>> getTopRatedMovieResult(){

        return topRatedMovieRepository.getTopRatedMovieList();
    }
}
