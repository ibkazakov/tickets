package zenIT.tickets.testtask.movies.dto.mapper;

import org.springframework.stereotype.Component;
import zenIT.tickets.testtask.movies.dto.MovieDto;
import zenIT.tickets.testtask.movies.dto.MoviePosterDto;
import zenIT.tickets.testtask.movies.model.Movie;
import zenIT.tickets.testtask.movies.model.MoviePoster;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieMapper {
    public MoviePosterDto toDto(MoviePoster moviePoster) {
        MoviePosterDto moviePosterDto = new MoviePosterDto();
        moviePosterDto.setID(moviePoster.getID());
        moviePosterDto.setFileName(moviePoster.getFilename());
        moviePosterDto.setSize((long)moviePoster.getContent().length);
        return moviePosterDto;
    }

    public MovieDto toDto(Movie movie) {
        MovieDto movieDto = new MovieDto();
        movieDto.setId(movie.getID());
        movieDto.setDescription(movie.getDescription());
        movieDto.setGenre(movie.getGenre());
        movieDto.setName(movie.getName());
        movieDto.setMoviePoster(toDto(movie.getPoster()));
        return movieDto;
    }

    public List<MovieDto> toDto(List<Movie> movies) {
        List<MovieDto> movieDtoList = new ArrayList<>();
        for(Movie movie : movies) {
            movieDtoList.add(toDto(movie));
        }
        return movieDtoList;
    }
}
