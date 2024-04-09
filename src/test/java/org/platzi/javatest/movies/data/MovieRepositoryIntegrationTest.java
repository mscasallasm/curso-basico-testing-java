package org.platzi.javatest.movies.data;

import org.junit.*;
import org.platzi.javatest.movies.model.Genre;
import org.platzi.javatest.movies.model.Movie;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class MovieRepositoryIntegrationTest {

    private MovieRepositoryJdbc movieRepository;
    private DataSource dataSource;

    @Before
    public void setUp() throws Exception {
        dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        movieRepository = new MovieRepositoryJdbc(jdbcTemplate);
    }

    @Test
    public void load_all_movies() throws SQLException {

        Collection<Movie> movies = movieRepository.findAll();

        assertEquals(Arrays.asList(
                new Movie(1,"Dark Knight", 152, Genre.COMEDY, "director1"),
                new Movie(2,"Memento", 113, Genre.THRILLER, "director2"),
                new Movie(3,"Matrix", 136, Genre.ACTION, "director3"),
                new Movie(4,"Maria", 114, Genre.ACTION, "director2"),
                new Movie(5,"Macarena", 125, Genre.ACTION, "director1")

        ), movies);
    }

    @Test
    public void load_movie_by_id() {
        Movie movie = movieRepository.findById(2);

        assertEquals(
                new Movie(2,"Memento", 113, Genre.THRILLER, "director2")
        , movie);
    }

    @Test
    public void load_movie_by_name() {
        Collection<Movie> movies = movieRepository.findByName("ma");

        assertEquals(Arrays.asList(
                new Movie(3,"Matrix", 136, Genre.ACTION, "director3"),
                new Movie(4,"Maria", 114, Genre.ACTION, "director2"),
                new Movie(5,"Macarena", 125, Genre.ACTION, "director1")
        ), movies);
    }

    @Test
    public void load_movie_by_director() {
        Collection<Movie> movies = movieRepository.findByDirector("or3");

        assertEquals(Arrays.asList(
                new Movie(3,"Matrix", 136, Genre.ACTION, "director3")
        ), movies);
    }

    @Test
    public void insert_a_movie() {
        Movie movie = new Movie("Super 8", 112, Genre.THRILLER, "director4");

        movieRepository.saveOrUpdate(movie);

        Movie movieFromDb = movieRepository.findById(6);

        assertEquals( movieFromDb, new Movie(6,"Super 8", 112, Genre.THRILLER, "director4") );
    }

    @Test
    public void load_movie_by_minutes_and_genre() {
        Collection<Movie> movies = movieRepository.findMoviesByTemplate(new Movie(null, 152, Genre.ACTION, null));

        assertEquals( Arrays.asList(
                new Movie(1,"Dark Knight", 152, Genre.COMEDY, "director1"),
                new Movie(3,"Matrix", 136, Genre.ACTION, "director3"),
                new Movie(4,"Maria", 114, Genre.ACTION, "director2"),
                new Movie(5,"Macarena", 125, Genre.ACTION, "director1")
        ), movies);
    }

    @Test
    public void load_movie_by_name_and_minutes() {
        Collection<Movie> movies = movieRepository.findMoviesByTemplate(new Movie("Maria", 125, null, null));

        assertEquals( Arrays.asList(
                new Movie(4,"Maria", 114, Genre.ACTION, "director2"),
                new Movie(5,"Macarena", 125, Genre.ACTION, "director1")
        ), movies);

    }

    @Test
    public void load_movie_by_name_genre_and_minutes() {
        Collection<Movie> movies = movieRepository.findMoviesByTemplate(new Movie("Maria", 125, Genre.COMEDY, null));

        assertEquals( Arrays.asList(
                new Movie(1,"Dark Knight", 152, Genre.COMEDY, "director1"),
                new Movie(4,"Maria", 114, Genre.ACTION, "director2"),
                new Movie(5,"Macarena", 125, Genre.ACTION, "director1")
        ), movies);

    }
    @After
    public void tearDown() throws Exception {

        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files");
    }
}