package zenIT.tickets.testtask.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import zenIT.tickets.testtask.movies.dao.MoviePosterRepository;
import zenIT.tickets.testtask.movies.dao.MovieRepository;
import zenIT.tickets.testtask.movies.model.Movie;
import zenIT.tickets.testtask.movies.model.MoviePoster;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MoviePosterRepository moviePosterRepository;

    public Movie createMovie(String name, String description, Set<String> genre,
                            MultipartFile poster) throws IOException {
        Movie newMovie = new Movie();
        newMovie.setName(name);
        newMovie.setDescription(description);
        newMovie.setGenre(genre);

        MoviePoster moviePoster = new MoviePoster();
        moviePoster.setFilename(poster.getOriginalFilename());
        moviePoster.setContent(poster.getBytes());

        newMovie.setPoster(moviePoster);

        movieRepository.save(newMovie);

        return newMovie;
    }

    public Movie getMovieByID(Long id) {
        try {
            return movieRepository.findById(id).get();
        }
        catch (NoSuchElementException e) {
            return null;
        }
    }

    public MoviePoster getPosterById(Long id) {
        try {
            return moviePosterRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public List<Movie> getAllMovies() {
       return StreamSupport.stream(movieRepository.findAll().spliterator(), false)
               .collect(Collectors.toList());
    }

    public boolean deleteMovieByID(Long id) {
       if (!movieRepository.existsById(id)) {
           return false;
       }
       movieRepository.deleteById(id);
       return true;
    }
}
