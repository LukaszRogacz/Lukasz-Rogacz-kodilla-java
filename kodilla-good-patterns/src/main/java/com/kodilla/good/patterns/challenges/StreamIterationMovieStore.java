package com.kodilla.good.patterns.challenges;

import java.util.stream.Collectors;

public class StreamIterationMovieStore {
    public static void main(String[] args) {
        MovieStore movieStore=new MovieStore();

        String movieList=movieStore.getMovies().values().stream()
                .flatMap(s-> s.stream())
                .map(s -> s.toString())
                .collect(Collectors.joining(" ! "));

        System.out.println(movieList);
    }
}
