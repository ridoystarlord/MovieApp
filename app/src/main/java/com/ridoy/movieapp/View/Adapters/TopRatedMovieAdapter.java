package com.ridoy.movieapp.View.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ridoy.movieapp.R;
import com.ridoy.movieapp.Model.ModelClass.Result;
import com.ridoy.movieapp.databinding.SingleMovieViewBinding;

import java.util.List;

public class TopRatedMovieAdapter extends RecyclerView.Adapter<TopRatedMovieAdapter.TopRatedMovieViewHolder> {

    Context context;
    List<Result> resultList;

    public TopRatedMovieAdapter(Context context, List<Result> resultList) {
        this.context = context;
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public TopRatedMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.single_movie_view,parent,false);
        return new TopRatedMovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopRatedMovieAdapter.TopRatedMovieViewHolder holder, int position) {
        Result result=resultList.get(position);

        holder.binding.movieTitleTV.setText(result.getTitle());
        holder.binding.movieRatingTV.setText(result.getVoteAverage().toString());
        holder.binding.movieReleaseDateTV.setText(result.getReleaseDate());
        Glide.with(context).load("https://image.tmdb.org/t/p/w500/"+result.getPosterPath()).into(holder.binding.imageView);
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class TopRatedMovieViewHolder extends RecyclerView.ViewHolder {
        SingleMovieViewBinding binding;
        public TopRatedMovieViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=SingleMovieViewBinding.bind(itemView);
        }
    }
}
