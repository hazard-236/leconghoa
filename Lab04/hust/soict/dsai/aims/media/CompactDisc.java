package hust.soict.dsai.aims.media;
import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(int id, String title, String category, float cost, String director, String artist) {
        super(id, title, category, cost, 0, director);
        this.artist = artist;
    }

    public String getArtist() { return artist; }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Bai hat '" + track.getTitle() + "' da co san trong CD nay roi.");
        } else {
            tracks.add(track);
            setLength(getLength() + track.getLength());
        }
    }

    public void removeTrack(Track track) {
        if (tracks.remove(track)) {
            setLength(getLength() - track.getLength());
        }
    }

    @Override
    public void play() {
        if (this.getLength() <= 0) {
            System.out.println("Loi: Album CD '" + this.getTitle() + "' khong co bai hat nao de phat!");
            return;
        }
        System.out.println("===== DANG PHAT ALBUM CD: " + this.getTitle().toUpperCase() + " =====");
        System.out.println("Nghe si the hien: " + this.artist + " | Tong thoi luong: " + this.getLength() + " giay.");
        System.out.println("----------------------------------------");
        for (Track track : tracks) {
            track.play();
        }
        System.out.println("========================================");
    }

    @Override
    public String toString() {
        return "[CD] ID: " + getId() + " - Album: " + getTitle() + 
               " - Danh muc: " + getCategory() + " - Ca si: " + artist + 
               " - So bai hat: " + tracks.size() + " - Tong thoi luong: " + getLength() + "s - Gia: $" + getCost();
    }
}