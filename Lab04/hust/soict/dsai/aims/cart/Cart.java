package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            System.out.println("San pham '" + media.getTitle() + "' da co san trong gio hang.");
        } else {
            itemsOrdered.add(media);
            System.out.println("Da them '" + media.getTitle() + "' vao gio hang thanh cong.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("Da xoa '" + media.getTitle() + "' khoi gio hang.");
        } else {
            System.out.println("Khong tim thay san pham '" + media.getTitle() + "' trong gio.");
        }
    }

    public float totalCost() {
        float sum = 0;
        for (Media media : itemsOrdered) {
            sum += media.getCost();
        }
        return sum;
    }

    public void printCart() {
        System.out.println("\n--- CHI TIET GIO HANG CUA BAN ---");
        if (itemsOrdered.isEmpty()) {
            System.out.println("(Gio hang hien dang trong rong)");
        } else {
            for (Media m : itemsOrdered) {
                System.out.println(m.toString());
            }
        }
        System.out.println("-> TONG TIEN PHAI THANH TOAN: $" + totalCost());
        System.out.println("---------------------------------");
    }

    public Media searchByTitle(String title) {
        for (Media m : itemsOrdered) {
            if (m.getTitle().equalsIgnoreCase(title)) return m;
        }
        return null;
    }

    public void sortCartByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Da sap xep gio hang theo Ten (Title).");
    }

    public void sortCartByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Da sap xep gio hang theo Gia (Cost).");
    }

    public void emptyCart() {
        itemsOrdered.clear();
    }
}