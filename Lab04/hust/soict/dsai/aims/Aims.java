package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initSampleData();

        int choice;
        while (true) {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    handleViewStore();
                    break;
                case 2:
                    handleUpdateStore();
                    break;
                case 3:
                    handleSeeCart();
                    break;
                case 0:
                    System.out.println("Cam on ban da su dung he thong AIMS. Tam biet!");
                    System.exit(0);
                default:
                    System.out.println("Lua chon khong hop le. Vui long nhap lai (0-3).");
            }
        }
    }

    private static void initSampleData() {
        Book book = new Book(1, "Lap trinh OOP Java", "Sach hoc tap", 25.5f);
        book.addAuthor("Nguyen Van A");
        
        DigitalVideoDisc dvd = new DigitalVideoDisc(2, "Mat Biec", "Phim Tinh Cam", 12.0f, 110, "Victor Vu");
        
        CompactDisc cd = new CompactDisc(3, "Album Chill", "Nhac tre", 18.5f, "Duc Tri", "Son Tung");
        cd.addTrack(new Track("Chay Ngay Di", 210));
        cd.addTrack(new Track("Chung Ta Cua Hien Tai", 305));

        store.addMedia(book);
        store.addMedia(dvd);
        store.addMedia(cd);
    }

    public static void showMenu() {
        System.out.println("\n====== HE THONG QUAN LY CUA HANG AIMS ======");
        System.out.println("1. View store (Xem cua hang)");
        System.out.println("2. Update store (Cap nhat san pham trong kho)");
        System.out.println("3. See current cart (Xem gio hang hien tai)");
        System.out.println("0. Exit (Thoat chuong trinh)");
        System.out.println("============================================");
        System.out.print("Vui long chon so (0-3): ");
    }

    private static void handleViewStore() {
        while (true) {
            store.printStore();
            storeMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.print("Nhap tieu de san pham muon xem chi tiet: ");
                    String title = scanner.nextLine();
                    Media m = store.searchByTitle(title);
                    if (m != null) {
                        System.out.println("\nThong tin chi tiet: " + m.toString());
                        handleMediaDetailsMenu(m);
                    } else {
                        System.out.println("Khong tim thay san pham nay trong kho.");
                    }
                    break;
                case 2:
                    System.out.print("Nhap tieu de san pham muon mua: ");
                    title = scanner.nextLine();
                    m = store.searchByTitle(title);
                    if (m != null) cart.addMedia(m);
                    else System.out.println("Khong tim thay san pham nay.");
                    break;
                case 3:
                    System.out.print("Nhap tieu de san pham muon phat thu: ");
                    title = scanner.nextLine();
                    m = store.searchByTitle(title);
                    if (m != null && m instanceof Playable) {
                        ((Playable) m).play();
                    } else {
                        System.out.println("San pham khong ho tro tinh nang phat thu (hoac khong tim thay)!");
                    }
                    break;
                case 4:
                    cart.printCart();
                    break;
                default:
                    System.out.println("Lua chon sai dinh dang.");
            }
        }
    }

    public static void storeMenu() {
        System.out.println("\n--- OPTIONS CUA HANG ---");
        System.out.println("1. See a media's details (Xem chi tiet san pham)");
        System.out.println("2. Add a media to cart (Them san pham vao gio)");
        System.out.println("3. Play a media (Phat thu dia CD/DVD)");
        System.out.println("4. See current cart (Xem nhanh gio hang)");
        System.out.println("0. Back (Quay lai Menu chinh)");
        System.out.println("-------------------------");
        System.out.print("Vui long chon so (0-4): ");
    }

    private static void handleMediaDetailsMenu(Media m) {
        mediaDetailsMenu();
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                cart.addMedia(m);
                break;
            case 2:
                if (m instanceof Playable) {
                    ((Playable) m).play();
                } else {
                    System.out.println("Sach khong the phat am thanh!");
                }
                break;
            case 0:
                break;
        }
    }

    public static void mediaDetailsMenu() {
        System.out.println("\n--- THAO TAC CHI TIET ---");
        System.out.println("1. Add to cart (Them vao gio)");
        System.out.println("2. Play (Phat thu)");
        System.out.println("0. Back (Quay lai)");
        System.out.println("-------------------------");
        System.out.print("Vui long chon so (0-2): ");
    }

    private static void handleUpdateStore() {
        System.out.println("\n--- CAP NHAT KHO HANG ---");
        System.out.println("1. Them mot san pham moi vao Store");
        System.out.println("2. Xoa mot san pham khoi Store");
        System.out.print("Lua chon cua ban: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.print("Nhap xo ten dia phim DVD moi: ");
            String title = scanner.nextLine();
            System.out.print("Nhap gia tien: ");
            float cost = scanner.nextFloat();
            store.addMedia(new DigitalVideoDisc(store.searchByTitle(title) == null ? 99 : 100, title, "Giai tri", cost, 90, "Chua ro"));
            System.out.println("Da cap nhat them dia phim moi len ke.");
        } else if (choice == 2) {
            System.out.print("Nhap ten san pham muon go ke: ");
            String title = scanner.nextLine();
            Media m = store.searchByTitle(title);
            if (m != null) {
                store.removeMedia(m);
                System.out.println("Da go san pham khoi he thong cua hang.");
            } else {
                System.out.println("Khong tim thay san pham de go.");
            }
        }
    }

    private static void handleSeeCart() {
        while (true) {
            cart.printCart();
            cartMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.print("Nhap tieu de san pham muon loc: ");
                    String title = scanner.nextLine();
                    Media found = cart.searchByTitle(title);
                    if (found != null) System.out.println("Ket qua loc: " + found.toString());
                    else System.out.println("Khong co san pham nay trong gio.");
                    break;
                case 2:
                    System.out.println("1. Sap xep theo Ten | 2. Sap xep theo Gia tien");
                    int sortChoice = scanner.nextInt();
                    if (sortChoice == 1) cart.sortCartByTitle();
                    else cart.sortCartByCost();
                    break;
                case 3:
                    System.out.print("Nhap ten san pham muon bo khoi gio: ");
                    title = scanner.nextLine();
                    found = cart.searchByTitle(title);
                    if (found != null) cart.removeMedia(found);
                    else System.out.println("San pham khong co trong gio hang.");
                    break;
                case 4:
                    System.out.print("Nhap ten dia muon nghe/xem thu: ");
                    title = scanner.nextLine();
                    found = cart.searchByTitle(title);
                    if (found != null && found instanceof Playable) ((Playable) found).play();
                    else System.out.println("San pham khong phat thu duoc.");
                    break;
                case 5:
                    System.out.println("\n[THONG BAO] Don hang cua ban da duoc khoi tao thanh cong tren he thong!");
                    cart.emptyCart();
                    System.out.println("Gio hang hien tai da duoc dua ve trang thai trong.");
                    return;
            }
        }
    }

    public static void cartMenu() {
        System.out.println("\n--- THAO TAC VOI GIO HANG ---");
        System.out.println("1. Filter medias in cart (Loc san pham trong gio)");
        System.out.println("2. Sort medias in cart (Sap xep san pham)");
        System.out.println("3. Remove media from cart (Xoa san pham khoi gio)");
        System.out.println("4. Play a media (Phat thu dia trong gio)");
        System.out.println("5. Place order (Xac nhan dat hang thanh cong)");
        System.out.println("0. Back (Quay lai Menu chinh)");
        System.out.println("-----------------------------");
        System.out.print("Vui long chon so (0-5): ");
    }
}