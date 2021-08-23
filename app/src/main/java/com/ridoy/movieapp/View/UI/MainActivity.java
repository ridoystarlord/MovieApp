package com.ridoy.movieapp.View.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.ridoy.movieapp.Model.ModelClass.Result;
import com.ridoy.movieapp.View.Adapters.TopRatedMovieAdapter;
import com.ridoy.movieapp.ViewModel.TopRatedMovieListViewModel;
import com.ridoy.movieapp.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private TopRatedMovieListViewModel topRatedMovieListViewModel;
    TopRatedMovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        topRatedMovieListViewModel=new ViewModelProvider(this).get(TopRatedMovieListViewModel.class);

        topRatedMovieListViewModel.getTopRatedMovieResult().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {
                adapter=new TopRatedMovieAdapter(MainActivity.this,results);
                binding.movielistRV.setAdapter(adapter);
            }
        });
    }
}