package mediaPlayer;

import java.util.*;
	public class MusicPlayer extends MediaPlayer {
	    private LinkedList<String> playlist;

	    public MusicPlayer() {
	        playlist = new LinkedList<>();
	    }

	    public void addSong(String song) {
	        playlist.addLast(song);
	        System.out.println("Added: " + song);
	    }

	    public void removeSong(String song) {
	        if (playlist.remove(song)) {
	            System.out.println("Removed: " + song);
	        } else {
	            System.out.println("Song not found: " + song);
	        }
	    }

	    public void playNext() {
	        if (!playlist.isEmpty()) {
	            String nextSong = playlist.poll();
	            play(nextSong);
	        } else {
	            System.out.println("No songs in the queue.");
	        }
	    }

	    public void showPlaylist() {
	        System.out.println("Current Playlist: " + playlist);
	    }
	}

