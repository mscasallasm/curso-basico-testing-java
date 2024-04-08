package org.platzi.javatest.movies.data;

import org.platzi.javatest.movies.model.Genre;
import org.platzi.javatest.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MovieRepositoryJdbc implements MovieRepository {

    private JdbcTemplate jdbcTemplate;

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {

        Object[] args = { id };

        return jdbcTemplate.queryForObject("SELECT * FROM movies WHERE id = ?", args, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {
        return jdbcTemplate.query("SELECT * FROM movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        jdbcTemplate.update("INSERT INTO movies (name, minutes, genre, director) values (?,?,?,?)", movie.getName(), movie.getMinutes(), movie.getGenre().toString(), movie.getDirector());
    }





    private static RowMapper<Movie> movieMapper = (rs, rowNum) -> new Movie(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getInt("minutes"),
            Genre.valueOf(rs.getString("genre")),
            rs.getString("director")
    );

    public Collection<Movie> findByName(String name) {
        //        Usando Like de mysql, el inconveniente es que la db esta configurada con el collate ci y tiene en cuenta que sea mayuscula
        //        String likePattern = "%" + name + "%";
        //
        //        Object[] args = new String[]{(likePattern)};
        //
        //        return jdbcTemplate.query("SELECT * FROM movies WHERE name LIKE ?", new Object[]{likePattern}, movieMapper);

        List<Movie> resultado = new ArrayList<>();

        List<Movie> movies = jdbcTemplate.query("SELECT * FROM movies", movieMapper);

        for (Movie movie : movies) {
            if (movie.getName().toLowerCase().contains(name.toLowerCase())) {
                resultado.add(movie);
            }
        }

        return resultado;

    }

    public Collection<Movie> findByDirector(String director) {
        List<Movie> resultado = new ArrayList<>();

        List<Movie> movies = jdbcTemplate.query("SELECT * FROM movies", movieMapper);

        for (Movie movie : movies) {
            if (movie.getDirector().toLowerCase().contains(director.toLowerCase())) {
                resultado.add(movie);
            }
        }

        return resultado;
    }

//    Reto 3
//    Queremos implementar nuevas opciones de búsqueda en nuestra aplicación de películas.
//
//    Buscar películas por nombre
//    En nuestra aplicación de películas queremos poder buscar películas por nombre.
//
//    Implementa la función findByName en MovieService, y añade un test para probar que funciona correctamente. Ten en cuenta que queremos que esta función encuentre películas que contengan una parte del nombre indicado, así que si buscamos “Super” queremos obtener películas como “Super 8” o “Superman”.
//
//    Pista: puedes usar la función contains.
//
//    Si es necesario, añade más películas en el test, para que hayan películas que contengan las mismas palabras.
//
//    Trata de que la función devuelva las películas aunque busquemos “super” en minúsculas.
//
//    Pista: puedes usar la función toLowerCase.
//
//    Reto extra: Buscar películas por director
//    También queremos añadir el director de las películas y poder buscarlas por director.
//
//    Añade el atributo director en la clase Movie. Tendrás que añadirlo también en los constructores de Movie, y actualizar los tests para indicar este dato. Puedes poner nombres de directores inventados si no quieres buscar los nombres reales (p.ej. “director1”, “director2”, etc). En los tests no importa que los datos sean inventados.
//
//    Una vez hayas añadido el atributo director, implementa la función findByDirector en MovieService, y añade un test para probar que funciona correctamente. Puedes usar la misma técnica que en findByName, y dejar buscar por una parte del nombre del director.
}
