public class MusicPlaylistApp {
    public static void main(String[] args) {

        PlaylistManager manager = new PlaylistManager();

        try {
            manager.addSong(new Song("Shape of You"));
            manager.addSong(new Song("Believer"));
            manager.addSong(new Song("Shape of You")); 
        } catch (SongAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        manager.playSong();
        manager.showRecentlyPlayed();
    }
}
