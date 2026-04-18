package Lab03.hust.soict.dsai.aims.store;
import Lab03.hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[100];
    private int qtyInStore = 0;

    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < 100) {
            itemsInStore[qtyInStore++] = dvd;
            System.out.println("Da them vao kho.");
        }
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) {
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j+1];
                }
                qtyInStore--;
                System.out.println("Da xoa khoi kho.");
                break;
            }
        }
    }
}