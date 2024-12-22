import java.sql.*; // Mengimpor semua kelas dalam paket java.sql untuk bekerja dengan database

public class Database {
    // Mendeklarasikan variabel static untuk menyimpan objek koneksi ke database
    private static Connection connection;

    // Metode untuk menghubungkan ke database
    public static void connect() throws SQLException {
        // URL untuk koneksi ke database MySQL dengan nama database "klinik_hewan"
        String url = "jdbc:mysql://localhost:3306/klinik_hewan";
        
        // Username untuk database
        String user = "root";
        
        // Password untuk database, sesuaikan dengan konfigurasi lokal
        String password = "nayla08";
        
        // Membuat koneksi ke database menggunakan DriverManager
        connection = DriverManager.getConnection(url, user, password);
        
        // Menampilkan pesan jika koneksi berhasil
        System.out.println("Koneksi ke database berhasil.");
    }

    // Metode untuk mendapatkan objek koneksi
    public static Connection getConnection() {
        // Mengembalikan objek koneksi agar dapat digunakan di kelas lain
        return connection;
    }

    // Metode untuk menutup koneksi ke database
    public static void close() throws SQLException {
        // Memeriksa apakah koneksi tidak null dan masih terbuka
        if (connection != null && !connection.isClosed()) {
            // Menutup koneksi
            connection.close();
            
            // Menampilkan pesan jika koneksi berhasil ditutup
            System.out.println("Koneksi ke database telah ditutup.");
        }
    }
}
