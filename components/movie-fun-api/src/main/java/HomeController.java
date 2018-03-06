package org.superbiz.moviefun.moviesapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.superbiz.moviefun.albums.Album;
import org.superbiz.moviefun.albumsapi.AlbumFixtures;
import org.superbiz.moviefun.albums.AlbumsRepository;

import java.util.Map;

@Controller
public class HomeController {

    private final MoviesClient moviesBean;
    private final AlbumsRepository albumsRepository;
    private final MovieFixtures movieFixtures;
    private final AlbumFixtures albumFixtures;

    public HomeController(MoviesClient moviesBean, AlbumsRepository albumsRepository, MovieFixtures movieFixtures, AlbumFixtures albumFixtures) {
        this.moviesBean = moviesBean;
        this.albumsRepository = albumsRepository;
        this.movieFixtures = movieFixtures;
        this.albumFixtures = albumFixtures;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/setup")
    public String setup(Map<String, Object> model) {
        for (MovieInfo movie : movieFixtures.load()) {
            moviesBean.addMovie(movie);
        }

        for (Album album : albumFixtures.load()) {
            albumsRepository.addAlbum(album);
        }

        model.put("movies", moviesBean.getMovies());
        model.put("albums", albumsRepository.getAlbums());

        return "setup";
    }
}
