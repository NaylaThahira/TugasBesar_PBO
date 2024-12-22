public class Obat {  
    // Deklarasi variabel instance untuk menyimpan informasi tentang obat
    private int idObat;        // ID unik untuk setiap obat
    private String namaObat;   // Nama obat
    private int stock;         // Jumlah stok obat dalam satuan mg

    // Konstruktor untuk inisialisasi objek Obat dengan nilai awal
    public Obat(int idObat, String namaObat, int stock) {
        this.idObat = idObat;        // Mengatur ID obat
        this.namaObat = namaObat;    // Mengatur nama obat
        this.stock = stock;          // Mengatur jumlah stok obat
    }

    // Getter untuk mendapatkan nilai ID obat
    public int getIdObat() {
        return idObat;               // Mengembalikan nilai ID obat
    }

    // Getter untuk mendapatkan nama obat
    public String getNamaObat() {
        return namaObat;             // Mengembalikan nama obat
    }

    // Getter untuk mendapatkan jumlah stok obat
    public int getStock() {
        return stock;                // Mengembalikan jumlah stok obat
    }

    // Setter untuk mengatur jumlah stok obat baru
    public void setStock(int stock) {
        this.stock = stock;          // Mengubah nilai stok obat dengan nilai baru
    }

    // Override metode `toString` untuk memberikan representasi string dari objek Obat
    @Override
    public String toString() {
        return "id obat: " + idObat +  // Menampilkan ID obat
               ", Nama obat: " + namaObat +  // Menampilkan nama obat
               ", Jumlah stok: " + stock + " mg";  // Menampilkan jumlah stok obat
    }
}
