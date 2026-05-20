package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() { return title; }
    public int getLength() { return length; }

    @Override
    public void play() {
        if (this.length <= 0) {
            System.out.println("Loi: Track '" + this.title + "' co thoi luong <= 0 nen khong the phat!");
            return;
        }
        System.out.println("Dang phat bai hat (Track): " + this.title);
        System.out.println("Thoi luong bai hat: " + this.length + " giay.");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Track)) return false;
        Track other = (Track) obj;
        return this.title.equalsIgnoreCase(other.title) && this.length == other.length;
    }
}