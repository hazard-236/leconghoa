package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<>();

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName) {
        authors.remove(authorName);
    }

    @Override
    public String toString() {
        return "[Sach] ID: " + getId() + " - Tieu de: " + getTitle() + 
               " - Danh muc: " + getCategory() + " - Tac gia: " + authors + 
               " - Gia: $" + getCost();
    }
}