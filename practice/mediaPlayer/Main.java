package mediaPlayer;

public class Main {

	    public static void main(String[] args) {
	        MusicPlayer player = new MusicPlayer();

	        player.addSong("Shape of You");
	        player.addSong("Blinding Lights");
	        player.addSong("Perfect");

	        player.showPlaylist();
	        player.playNext();
	        player.playNext();
	        player.removeSong("Levitating");
	        player.playNext();
	        
	        player.showPlaylist();
	    
	    }
}
