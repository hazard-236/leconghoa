package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
        }
    }

    public void removeMedia(Media media) {
        itemsInStore.remove(media);
    }

    public void printStore() {
        System.out.println("\n--- CAC SAN PHAM CO TRONG CUA HANG (STORE) ---");
        if (itemsInStore.isEmpty()) {
            System.out.println("(Cua hang hien tai chua treo ke mat hang nao)");
        } else {
            for (Media m : itemsInStore) {
                System.out.println(m.toString());
            }
        }
        System.out.println("----------------------------------------------");
    }

    public Media searchByTitle(String title) {
        for (Media m : itemsInStore) {
            if (m.getTitle().equalsIgnoreCase(title)) return m;
        }
        return null;
    }
}