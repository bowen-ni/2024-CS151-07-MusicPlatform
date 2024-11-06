
import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;
import java.util.Map;

public class SongBase {
    private Map<String, Song> songMap;
    private Map<String, Playlist> playlistMap;

    public SongBase() {
        songMap = new HashMap<>();
        playlistMap = new HashMap<>();
    }

    public void addSong(Song song) {
        songMap.put(song.getName().toLowerCase(), song); // Add song to map
    }

    public void addPlaylist(Playlist playlist) {
        playlistMap.put(playlist.getName().toLowerCase(), playlist); // Add playlist to map
    }

    public boolean removeSong(Song song) {
        return songMap.remove(song.getName().toLowerCase(), song); // Efficient removal using map
    }

    public Song searchSong(String name) {
        return songMap.get(name.toLowerCase()); // Optimized search using map
    }

    public Playlist searchPlaylist(String name) {
        return playlistMap.get(name.toLowerCase()); // Optimized search using map
    }

    // Search and display song details by name (using the optimized search)
    public void searchSongByName(String name) {
        Song song = searchSong(name);
        if (song != null) {
            System.out.println("Song found: " + song.getName() + " by " + song.getArtistName());
            System.out.println("Genre: " + song.getGenre() + ", Duration: " + song.getDuration() + " seconds");
            System.out.println("Explicit: " + song.isExplicit() + ", Play Count: " + song.getPlayCount());
        } else {
            System.out.println("Song not found.");
        }
    }

    // Search and display playlist details by name (using the optimized search)
    public void searchPlaylistByName(String name) {
        Playlist playlist = searchPlaylist(name);
        if (playlist != null) {
            System.out.println("Playlist: " + playlist.getName());
            System.out.println("Songs in Playlist:");
            playlist.getSongs().forEach(song -> System.out.println("- " + song.getName()));
        } else {
            System.out.println("Playlist not found.");
        }
    }
}
