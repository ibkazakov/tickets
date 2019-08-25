package zenIT.tickets.testtask.movies.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zenIT.tickets.testtask.movies.model.MoviePoster;

@Repository
public interface MoviePosterRepository extends CrudRepository<MoviePoster, Long> {
}
