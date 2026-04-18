package Lab03.hust.soict.dsai.aims.cart;
import Lab03.hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[20];
    private int qtyOrdered = 0;
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (qtyOrdered < 20) {
                itemsOrdered[qtyOrdered++] = disc;
                System.out.println("Da them tu mang: " + disc.getTitle());
            }
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered < 19) {
            itemsOrdered[qtyOrdered++] = dvd1;
            itemsOrdered[qtyOrdered++] = dvd2;
            System.out.println("Da them 2 dia le.");
        }
    }

    public int getQtyOrdered() { return qtyOrdered; }
}