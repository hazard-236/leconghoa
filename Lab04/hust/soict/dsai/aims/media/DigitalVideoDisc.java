package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    }

    @Override
    public void play() {
        if (this.getLength() <= 0) {
            System.out.println("Loi: Dia phim DVD '" + this.getTitle() + "' co thoi luong <= 0 nen khong the phat!");
            return;
        }
        System.out.println("Dang phat phim DVD: " + this.getTitle());
        System.out.println("Dao dien: " + this.getDirector() + " | Thoi luong: " + this.getLength() + " phut.");
    }

    @Override
    public String toString() {
        return "[DVD] ID: " + getId() + " - Tieu de: " + getTitle() + 
               " - Danh muc: " + getCategory() + " - Dao dien: " + getDirector() + 
               " - Thoi luong: " + getLength() + " phut - Gia: $" + getCost();
    }
}