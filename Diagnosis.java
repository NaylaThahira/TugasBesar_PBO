// Mendefinisikan kelas Diagnosis
public class Diagnosis {
    // Deklarasi atribut private untuk menyimpan informasi diagnosis
    private String namaHewan;         // Nama hewan yang didiagnosa
    private String penyakit;          // Penyakit yang didiagnosa
    private String namaDokter;        // Nama dokter yang memberikan diagnosis
    private String namaObat;          // Nama obat yang diberikan
    private int dosis;                // Dosis obat yang diberikan

    // Konstruktor untuk menginisialisasi objek Diagnosis dengan data tertentu
    public Diagnosis(String namaHewan, String penyakit, String namaDokter, String namaObat, int dosis) {
        this.namaHewan = namaHewan;    // Menginisialisasi nama hewan
        this.penyakit = penyakit;     // Menginisialisasi penyakit
        this.namaDokter = namaDokter; // Menginisialisasi nama dokter
        this.namaObat = namaObat;     // Menginisialisasi nama obat
        this.dosis = dosis;           // Menginisialisasi dosis obat
    }

    // Getter untuk mendapatkan nama hewan
    public String getNamaHewan() {
        return namaHewan; // Mengembalikan nama hewan
    }

    // Getter untuk mendapatkan penyakit yang didiagnosa
    public String getPenyakit() {
        return penyakit; // Mengembalikan penyakit
    }

    // Getter untuk mendapatkan nama dokter yang memberikan diagnosis
    public String getNamaDokter() {
        return namaDokter; // Mengembalikan nama dokter
    }

    // Getter untuk mendapatkan nama obat yang diberikan
    public String getNamaObat() {
        return namaObat; // Mengembalikan nama obat
    }

    // Getter untuk mendapatkan dosis obat
    public int getDosis() {
        return dosis; // Mengembalikan dosis obat
    }

    // Setter untuk memperbarui dosis obat jika diperlukan
    public void setDosis(int dosis) {
        this.dosis = dosis; // Memperbarui nilai dosis obat
    }

    // Override metode toString() untuk memberikan representasi string dari objek Diagnosis
    @Override
    public String toString() {
        // Mengembalikan informasi diagnosis dalam format yang mudah dibaca
        return "Hewan: " + namaHewan + ", Penyakit: " + penyakit  +
               ", Obat: " + namaObat + ", Dosis: " + dosis + "mg" + ", Dokter: " + namaDokter;
    }
}
