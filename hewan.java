// Mendefinisikan kelas hewan
public class hewan {
    // Deklarasi atribut private untuk menyimpan informasi hewan
    private int id;                   // ID unik untuk hewan
    private String namaHewan;         // Nama hewan
    private String namaPemilik;       // Nama pemilik hewan
    private String jenisHewan;        // Jenis atau spesies hewan
    private String ciriKhusus;        // Ciri khusus yang membedakan hewan ini
    private Double berat;             // Berat hewan dalam kilogram

    // Konstruktor untuk menginisialisasi objek hewan dengan data tertentu
    public hewan(int id, String namaHewan, String namaPemilik, String jenisHewan, String ciriKhusus, Double berat) {
        this.id = id;                 // Menginisialisasi ID hewan
        this.namaHewan = namaHewan;   // Menginisialisasi nama hewan
        this.namaPemilik = namaPemilik; // Menginisialisasi nama pemilik
        this.jenisHewan = jenisHewan; // Menginisialisasi jenis hewan
        this.ciriKhusus = ciriKhusus; // Menginisialisasi ciri khusus
        this.berat = berat;           // Menginisialisasi berat hewan
    }

    // Getter untuk mendapatkan ID hewan
    public int getId() {
        return id; // Mengembalikan nilai ID hewan
    }

    // Getter untuk mendapatkan nama hewan
    public String getNamaHewan() {
        return namaHewan; // Mengembalikan nama hewan
    }

    // Getter untuk mendapatkan nama pemilik hewan
    public String getNamaPemilik() {
        return namaPemilik; // Mengembalikan nama pemilik hewan
    }

    // Getter untuk mendapatkan jenis atau spesies hewan
    public String getJenisHewan() {
        return jenisHewan; // Mengembalikan jenis hewan
    }

    // Getter untuk mendapatkan ciri khusus hewan
    public String getCiriKhusus() {
        return ciriKhusus; // Mengembalikan ciri khusus hewan
    }

    // Getter untuk mendapatkan berat hewan
    public Double getBerat() {
        return berat; // Mengembalikan berat hewan
    }

    // Override metode toString() untuk memberikan representasi string dari objek hewan
    @Override
    public String toString() {
        // Mengembalikan informasi hewan dalam format yang mudah dibaca
        return "ID Hewan: " + id +
               ", Nama Hewan: " + namaHewan +
               ", Spesies: " + jenisHewan +
               ", Pemilik: " + namaPemilik +
               ", Marking: " + ciriKhusus +
               ", Berat Hewan: " + berat + " kg";
    }
}
