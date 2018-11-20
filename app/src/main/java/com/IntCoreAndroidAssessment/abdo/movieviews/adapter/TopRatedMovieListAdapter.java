package com.IntCoreAndroidAssessment.abdo.movieviews.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.IntCoreAndroidAssessment.abdo.R;
import com.IntCoreAndroidAssessment.abdo.model.Movie;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopRatedMovieListAdapter extends RecyclerView.Adapter<TopRatedMovieListAdapter.DataViewHolder> {

    private ArrayList<Movie> movies;

    public TopRatedMovieListAdapter() {
        this.movies = new ArrayList<>();
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.top_rated_movie_item, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.movieName.setText(movie.getOriginalTitle());
        holder.movieOverview.setText(movie.getOverview());
        holder.movieReleaseDate.setText(movie.getReleaseDate());
        holder.favIcon.setOnClickListener(v -> {

            markMovieAsFavourite(holder, (ImageView) v);

        });
    }

    private void markMovieAsFavourite(@NonNull DataViewHolder holder, ImageView v) {

        Integer integer = (Integer) v.getTag();
        integer = integer == null ? R.drawable.ic_empty : integer;
        switch (integer) {
            case R.drawable.ic_gold:
                changeMovieStateIcon(holder, v, R.drawable.ic_empty);
                break;
            case R.drawable.ic_empty:
                changeMovieStateIcon(holder, v, R.drawable.ic_gold);
            default:
                break;
        }
    }

    private void changeMovieStateIcon(@NonNull DataViewHolder holder, ImageView v, int ic_empty) {
        holder.favIcon.setImageResource(ic_empty);
        v.setTag(ic_empty);
    }

    public void setTopRatedMovieList(List<Movie> movieList) {
        if (movies == null) {
            return;
        }
        movies.clear();
        movies.addAll(movieList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class DataViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.movie_name)
        TextView movieName;
        @BindView(R.id.movie_overview)
        TextView movieOverview;
        @BindView(R.id.movie_release_date)
        TextView movieReleaseDate;
        @BindView(R.id.fav_icon)
        ImageView favIcon;


        public DataViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
