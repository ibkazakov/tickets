package zenIT.tickets.testtask.movies.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zenIT.tickets.testtask.movies.model.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

}
