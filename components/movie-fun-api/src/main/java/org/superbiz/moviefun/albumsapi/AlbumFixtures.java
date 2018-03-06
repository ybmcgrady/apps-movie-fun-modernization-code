package org.superbiz.moviefun.albumsapi;

import org.springframework.stereotype.Component;
import org.superbiz.moviefun.albums.Album;

import java.util.List;

import static java.util.Arrays.asList;

@Component
public class AlbumFixtures {

    public List<Album> load() {
        return asList(
            new Album("Massive Attack", "Mezzanine", 1998, 9),
            new Album("Radiohead", "OK Computer", 1997, 8),
            new Album("Radiohead", "Kid A", 2000, 9)
        );
    }
}
