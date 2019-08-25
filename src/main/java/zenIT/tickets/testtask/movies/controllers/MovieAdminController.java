package zenIT.tickets.testtask.movies.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zenIT.tickets.testtask.movies.dto.mapper.MovieMapper;
import zenIT.tickets.testtask.movies.model.Movie;
import zenIT.tickets.testtask.movies.model.MoviePoster;
import zenIT.tickets.testtask.movies.service.MovieService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


@Controller
@RequestMapping("/admin/movies")
public class MovieAdminController {

    @Autowired
    MovieService movieService;

    @Autowired
    MovieMapper mapper;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity<?> addMovie(@RequestParam("name") String name, @RequestParam("description") String description,
                                   @RequestParam("genre[]") String[] genre, @RequestParam("file") MultipartFile posterFile) {
        try {
           Movie savedMovie = movieService.createMovie(name, description,
                   new HashSet<String>(Arrays.asList(genre)), posterFile);
           return ResponseEntity.ok(mapper.toDto(savedMovie));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> viewMovie(@PathVariable("id") Long id) {
        Movie movie = movieService.getMovieByID(id);
        if (movie == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mapper.toDto(movie));
    }

    @RequestMapping(value = "/poster/{id}", method = RequestMethod.GET)
    public void downloadPosterById(HttpServletResponse response,
                                   @PathVariable Long id) throws IOException {
        MoviePoster poster = movieService.getPosterById(id);
        if (poster == null) {
            response.getOutputStream().print("No such poster");
            return;
        }
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        response.getOutputStream().write(poster.getContent());
        response.getOutputStream().flush();
    }

    @RequestMapping(value = "/viewAll", method = RequestMethod.GET)
    public ResponseEntity<?> viewAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return ResponseEntity.ok(mapper.toDto(movies));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> deleteMovie(@PathVariable("id") Long id) {
        boolean isDeleted = movieService.deleteMovieByID(id);
        if (isDeleted) {
            return ResponseEntity.ok("Movie with id " + id + "has been successfully removed");
        } else {
            return ResponseEntity.ok("Movie with id " + id + "cannot be removed");
        }
    }

}
