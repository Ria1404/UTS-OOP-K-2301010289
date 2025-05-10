import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Membuat objek NoteManager dengan kapasitas 100 catatan
        NoteManager manager = new NoteManager(100);  
        int choice;

        do {
            System.out.println("===== MENU APLIKASI CATATAN =====");
            System.out.println("1. Tambah Catatan");
            System.out.println("2. Tampilkan Semua Catatan");
            System.out.println("3. Ubah Catatan");
            System.out.println("4. Hapus Catatan");
            System.out.println("5. Cari Catatan");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu (1-6): ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer

            switch (choice) {
                case 1:
                    manager.addNote();
                    break;
                case 2:
                    manager.displayNotes();
                    break;
                case 3:
                    manager.editNote();
                    break;
                case 4:
                    manager.deleteNote();
                    break;
                case 5:
                    manager.searchNote();
                    break;
                case 6:
                    System.out.println("Terima kasih telah menggunakan aplikasi catatan!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih menu yang benar.\n");
            }
        } while (choice != 6);
    }
}
