import java.util.ArrayList;
import java.util.Scanner;

// Song class
class Song {
    private String title;
    private String artist;

    // Constructor
    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    // To display song details
    public String toString() {
        return "🎵 " + title + " by " + artist;
    }
}

// Playlist class
class Playlist {
    private ArrayList<Song> songs;

    // Constructor
    public Playlist() {
        songs = new ArrayList<>();
    }

    // Add song to playlist
    public void addSong(Song song) {
        songs.add(song);
        System.out.println("✅ Song added to playlist!");
    }

    // Remove song by index
    public void removeSong(int index) {
        if (index >= 0 && index < songs.size()) {
            System.out.println("❌ Removed: " + songs.get(index));
            songs.remove(index);
        } else {
            System.out.println("⚠️ Invalid index!");
        }
    }

    // Display playlist
    public void showPlaylist() {
        if (songs.isEmpty()) {
            System.out.println("📭 Playlist is empty.");
        } else {
            System.out.println("🎧 Your Playlist:");
            for (int i = 0; i < songs.size(); i++) {
                System.out.println((i + 1) + ". " + songs.get(i));
            }
        }
    }
}

// Main application
public class SongPlaylistApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Playlist myPlaylist = new Playlist();

        int choice;
        do {
            System.out.println("\n🎼 Song Playlist App");
            System.out.println("1. Add Song");
            System.out.println("2. View Playlist");
            System.out.println("3. Remove Song");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter song title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter artist name: ");
                    String artist = sc.nextLine();
                    Song newSong = new Song(title, artist);
                    myPlaylist.addSong(newSong);
                    break;

                case 2:
                    myPlaylist.showPlaylist();
                    break;

                case 3:
                    myPlaylist.showPlaylist();
                    System.out.print("Enter song number to remove: ");
                    int index = sc.nextInt() - 1;
                    myPlaylist.removeSong(index);
                    break;

                case 4:
                    System.out.println("🎶 Thank you for using Song Playlist App!");
                    break;

                default:
                    System.out.println("⚠️ Invalid choice. Try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}
