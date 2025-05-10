public class Note {
    private long id;       // ID catatan
    private String title;  // Judul catatan
    private String content; // Konten catatan

    // Constructor dengan parameter
    public Note(long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    // Getter dan setter untuk id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // Getter dan setter untuk title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter dan setter untuk content
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Method untuk menampilkan catatan
    public void displayNote() {
        System.out.println("ID      : " + id);
        System.out.println("Title   : " + title);
        System.out.println("Content : " + content);
    }

    // Method untuk memperbarui catatan
    public void updateNote(String newTitle, String newContent) {
        this.title = newTitle;
        this.content = newContent;
    }
}

