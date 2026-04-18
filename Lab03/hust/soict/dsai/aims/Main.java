package Lab03.hust.soict.dsai.aims;

import Lab03.hust.soict.dsai.aims.cart.Cart;
import Lab03.hust.soict.dsai.aims.disc.DigitalVideoDisc;
import Lab03.hust.soict.dsai.aims.store.Store;

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();
        
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Vua Su Tu");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");
        cart.addDigitalVideoDisc(dvd1, dvd2);
        DigitalVideoDisc[] danhSach = {dvd3, new DigitalVideoDisc("Cinderella")};
        cart.addDigitalVideoDisc(danhSach);
        
        System.out.println("ID cua dia Aladdin la: " + dvd3.getId());
        System.out.println("Tong so dia trong gio: " + cart.getQtyOrdered());
    }
}