package zenIT.tickets.testtask.movies.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long ID;

    @Column(name = "name")
    private String name;

    @Column(name = "genre")
    @ElementCollection(targetClass = String.class)
    private Set<String> genre;

    @Column(name = "description")
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "poster_id")
    private MoviePoster poster;


    public Movie() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getGenre() {
        return genre;
    }

    public void setGenre(Set<String> genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MoviePoster getPoster() {
        return poster;
    }

    public void setPoster(MoviePoster poster) {
        this.poster = poster;
    }
}
