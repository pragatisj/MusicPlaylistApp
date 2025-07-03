import java.util.ArrayList;
import java.util.Scanner;

// Song class
class Song {
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String toString() {
        return "🎵 " + title + " by " + artist;
    }
}

// Playlist class
class Playlist {
    private ArrayList<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        songs.add(song);
        System.out.println("✅ Song added to playlist!");
    }

    public void removeSong(int index) {
        if (index >= 0 && index < songs.size()) {
            System.out.println("❌ Removed: " + songs.get(index));
            songs.remove(index);
        } else {
            System.out.println("⚠️ Invalid index!");
        }
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

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
public class MusicPlaylistApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Playlist myPlaylist = new Playlist();

        int choice;
        do {
            System.out.println("\n🎼 Song Playlist App");
            System.out.println("1. Add Song");
            System.out.println("2. View Playlist");
            System.out.println("3. Remove Song by Number");
            System.out.println("4. Play Songs (Start Navigation)");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter song title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter artist name: ");
                    String artist = sc.nextLine();
                    myPlaylist.addSong(new Song(title, artist));
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
                    playSongs(myPlaylist.getSongs(), sc);
                    break;

                case 5:
                    System.out.println("🎶 Thank you for using Song Playlist App!");
                    break;

                default:
                    System.out.println("⚠️ Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }

    // Navigation for playing songs
    public static void playSongs(ArrayList<Song> songs, Scanner sc) {
        if (songs.isEmpty()) {
            System.out.println("📭 Playlist is empty.");
            return;
        }

        int index = 0;
        boolean quit = false;

        System.out.println("🎶 Now Playing: " + songs.get(index));
        printPlayMenu();

        while (!quit) {
            System.out.print("\nEnter option (5 to show menu): ");
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 0:
                    System.out.println("🔚 Exiting song navigation.");
                    quit = true;
                    break;
                case 1:
                    if (index < songs.size() - 1) {
                        index++;
                        System.out.println("▶️ Now Playing: " + songs.get(index));
                    } else {
                        System.out.println("⛔ End of playlist.");
                    }
                    break;
                case 2:
                    if (index > 0) {
                        index--;
                        System.out.println("⏮️ Now Playing: " + songs.get(index));
                    } else {
                        System.out.println("⛔ Start of playlist.");
                    }
                    break;
                case 3:
                    System.out.println("🔁 Replaying: " + songs.get(index));
                    break;
                case 4:
                    System.out.println("🎧 Full Playlist:");
                    for (int i = 0; i < songs.size(); i++) {
                        System.out.println((i + 1) + ". " + songs.get(i));
                    }
                    break;
                case 5:
                    printPlayMenu();
                    break;
                case 6:
                    System.out.println("🗑️ Removed: " + songs.get(index));
                    songs.remove(index);
                    if (songs.isEmpty()) {
                        System.out.println("📭 Playlist is now empty.");
                        quit = true;
                    } else if (index >= songs.size()) {
                        index = songs.size() - 1;
                        System.out.println("▶️ Now Playing: " + songs.get(index));
                    } else {
                        System.out.println("▶️ Now Playing: " + songs.get(index));
                    }
                    break;
                default:
                    System.out.println("⚠️ Invalid option.");
            }
        }
    }

    public static void printPlayMenu() {
        System.out.println("\n📋 Menu Options:");
        System.out.println("0 - Quit");
        System.out.println("1 - Play next song");
        System.out.println("2 - Play previous song");
        System.out.println("3 - Replay current song");
        System.out.println("4 - Show playlist");
        System.out.println("5 - Show menu again");
        System.out.println("6 - Remove current song");
    }  
}



























