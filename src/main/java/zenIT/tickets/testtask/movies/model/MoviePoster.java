package zenIT.tickets.testtask.movies.model;

import javax.persistence.*;

@Entity
@Table(name = "posters")
public class MoviePoster {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long ID;

    @OneToOne(mappedBy = "poster")
    private Movie movie;

    @Column(name = "filename")
    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Lob
    @Column(name = "content")
    private byte[] content;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public MoviePoster() {
    }
}
