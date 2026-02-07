import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

class PlaylistManager {

    private LinkedList<Song> playlist = new LinkedList<>();
    private Stack<Song> recentlyPlayed = new Stack<>();
    private Set<Song> songSet = new HashSet<>();

    public void addSong(Song song) throws SongAlreadyExistsException {
        if (songSet.contains(song)) {
            throw new SongAlreadyExistsException("Song already exists in playlist");
        }

        playlist.add(song);
        songSet.add(song);
        System.out.println(song + " added to playlist");
    }

    public void playSong() {
        if (!playlist.isEmpty()) {
            Song song = playlist.getFirst();
            recentlyPlayed.push(song);
            System.out.println("Playing: " + song);
        }
    }

    public void showRecentlyPlayed() {
        System.out.println("Recently Played: " + recentlyPlayed);
    }
}
