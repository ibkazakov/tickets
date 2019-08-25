package zenIT.tickets.testtask.movies.dto;

import java.util.Set;

public class MovieDto {
    private Long ID;

    private String name;
    private String description;
    private Set<String> genre;

    private MoviePosterDto moviePoster;


    public Long getID() {
        return ID;
    }

    public void setId(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<String> getGenre() {
        return genre;
    }

    public void setGenre(Set<String> genre) {
        this.genre = genre;
    }

    public MoviePosterDto getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(MoviePosterDto moviePoster) {
        this.moviePoster = moviePoster;
    }
}
