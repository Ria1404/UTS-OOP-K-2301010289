import java.util.Scanner;

public class NoteManager {
    private Note[] notes;  // Array untuk menyimpan catatan
    private int count;     // Menyimpan jumlah catatan yang ada
    private Scanner scanner;

    // Constructor untuk kelas NoteManager, dengan kapasitas array
    public NoteManager(int capacity) {
        notes = new Note[capacity];  // Array untuk menampung catatan
        count = 0;
        scanner = new Scanner(System.in);
    }

    // Menambahkan catatan baru
    public void addNote() {
        if (count < notes.length) {
            try {
                System.out.print("Masukkan ID       : ");
                long id = scanner.nextLong();
                scanner.nextLine();  // Clear the buffer

                System.out.print("Masukkan Judul    : ");
                String title = scanner.nextLine();

                System.out.print("Masukkan Konten   : ");
                String content = scanner.nextLine();

                // Membuat objek Note baru dan menambahkannya ke dalam array
                notes[count] = new Note(id, title, content);
                count++;
                System.out.println("Catatan berhasil ditambahkan!\n");
            } catch (Exception e) {
                System.out.println("Input tidak valid. Pastikan ID adalah angka.");
                scanner.nextLine();  // Clear the buffer
            }
        } else {
            System.out.println("Array penuh! Tidak bisa menambah catatan.\n");
        }
    }

    // Menampilkan semua catatan
    public void displayNotes() {
        if (count == 0) {
            System.out.println("Belum ada catatan.\n");
        } else {
            for (int i = 0; i < count; i++) {
                notes[i].displayNote();  // Menampilkan setiap catatan di array
                System.out.println("----------------------------");
            }
        }
    }

    // Mengedit catatan berdasarkan ID
    public void editNote() {
        System.out.print("Masukkan ID catatan yang ingin diubah: ");
        long id = scanner.nextLong();
        scanner.nextLine();  // Clear the buffer

        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (notes[i].getId() == id) {
                found = true;
                System.out.print("Masukkan judul baru: ");
                String newTitle = scanner.nextLine();

                System.out.print("Masukkan konten baru: ");
                String newContent = scanner.nextLine();

                // Memperbarui catatan yang ditemukan
                notes[i].updateNote(newTitle, newContent);
                System.out.println("Catatan berhasil diubah!\n");
                break;
            }
        }
        if (!found) {
            System.out.println("Catatan dengan ID " + id + " tidak ditemukan.\n");
        }
    }

    // Menghapus catatan berdasarkan ID
    public void deleteNote() {
        System.out.print("Masukkan ID catatan yang ingin dihapus: ");
        long id = scanner.nextLong();
        scanner.nextLine();  // Clear the buffer

        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (notes[i].getId() == id) {
                found = true;
                // Menggeser semua catatan setelah catatan yang dihapus
                for (int j = i; j < count - 1; j++) {
                    notes[j] = notes[j + 1];
                }
                notes[count - 1] = null;  // Menghapus referensi terakhir
                count--;  // Mengurangi jumlah catatan
                System.out.println("Catatan berhasil dihapus!\n");
                break;
            }
        }
        if (!found) {
            System.out.println("Catatan dengan ID " + id + " tidak ditemukan.\n");
        }
    }

    // Mencari catatan berdasarkan ID
    public void searchNote() {
        System.out.print("Masukkan ID catatan yang ingin dicari: ");
        long id = scanner.nextLong();
        scanner.nextLine();  // Clear the buffer

        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (notes[i].getId() == id) {
                found = true;
                notes[i].displayNote();  // Menampilkan catatan yang ditemukan
                break;
            }
        }
        if (!found) {
            System.out.println("Catatan dengan ID " + id + " tidak ditemukan.\n");
        }
    }
}
