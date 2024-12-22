import java.util.*; // Mengimpor library untuk menggunakan Scanner dan collection
import java.sql.*; // Mengimpor library untuk bekerja dengan database SQL

// Definisi kelas utama
public class klinikHewan {
    private static Scanner scanner = new Scanner(System.in); // Scanner untuk input dari pengguna
    private static Connection connection; // Variabel untuk koneksi ke database

    // Metode utama
    public static void main(String[] args) {
        try {
            connectToDatabase(); // Menghubungkan ke database

            // Perulangan utama untuk menampilkan menu dan menangani pilihan pengguna
            while (true) {
                tampilkanMenu(); // Menampilkan menu utama
                int pilihan = scanner.nextInt(); // Membaca input pilihan pengguna
                scanner.nextLine(); // Konsumsi newline
                switch (pilihan) { // Menangani pilihan menu
                    case 1 -> tambahDataHewan(); // Menambah data hewan
                    case 2 -> hapusDataHewan(); // Menghapus data hewan
                    case 3 -> lihatDataHewan(); // Melihat data hewan
                    case 4 -> tambahStokObat(); // Menambah stok obat
                    case 5 -> lihatStokObat(); // Melihat stok obat
                    case 6 -> keluarProgram(); // Keluar dari program
                    default -> System.out.println("Pilihan tidak valid. Coba lagi."); // Menangani input tidak valid
                }
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage()); // Menangani kesalahan
        }
    }

    // Metode untuk menghubungkan ke database
    private static void connectToDatabase() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/db_klinikhewan"; // URL database
        String user = "root"; // Username database
        String password = "nayla08"; // Password database
        connection = DriverManager.getConnection(url, user, password); // Membuat koneksi ke database
        System.out.println("Koneksi ke database berhasil."); // Konfirmasi koneksi berhasil
    }

    // Metode untuk menampilkan menu utama
    private static void tampilkanMenu() {
        System.out.println("\n=== Sistem Pendataan Klinik Hewan ===");
        System.out.println("1. Tambah Data Hewan dan Diagnosa");
        System.out.println("2. Hapus Data Hewan");
        System.out.println("3. Lihat Data Hewan");
        System.out.println("4. Tambah Stok Obat");
        System.out.println("5. Lihat Stok Obat");
        System.out.println("6. Keluar Program");
        System.out.print("Masukkan pilihan Anda: ");
    }

    // Metode untuk menambah data hewan dan diagnosa
    private static void tambahDataHewan() {
        try {
            // Membaca input data hewan dari pengguna
            System.out.print("Masukkan ID Hewan: ");
            String idHewan = scanner.nextLine();
            System.out.print("Masukkan Nama Hewan: ");
            String namaHewan = scanner.nextLine();
            System.out.print("Masukkan Jenis Hewan: ");
            String jenisHewan = scanner.nextLine();
            System.out.print("Masukkan Berat Hewan (kg): ");
            Double berat = scanner.nextDouble();  // Menyimpan input berat
            scanner.nextLine(); // Konsumsi newline
            System.out.print("Masukkan Nama Pemilik: ");
            String namaPemilik = scanner.nextLine();
            System.out.println("==== HEWAN DITAMBAHKAN ====");
            System.out.print("Masukkan Penyakit: ");
            String penyakit = scanner.nextLine();
            System.out.print("Masukkan Nama Obat: ");
            String namaObat = scanner.nextLine();
            System.out.print("Masukkan Dosis Obat (mg): ");
            int dosis = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline
            System.out.print("Masukkan Nama Dokter: ");
            String namaDokter = scanner.nextLine();
    
            // Mengecek stok obat yang diminta
            String cekStokObatSQL = "SELECT stockObat FROM obat WHERE namaObat = ?";
            PreparedStatement cekStokStmt = connection.prepareStatement(cekStokObatSQL);
            cekStokStmt.setString(1, namaObat); // Mengisi parameter query
            ResultSet rs = cekStokStmt.executeQuery();
    
            if (rs.next()) { // Jika obat ditemukan
                int stok = rs.getInt("stockObat"); // Mendapatkan stok obat
                if (stok >= dosis) { // Jika stok cukup
                    // Mengurangi stok obat
                    String kurangiStokSQL = "UPDATE obat SET stockObat = stockObat - ? WHERE namaObat = ?";
                    PreparedStatement kurangiStokStmt = connection.prepareStatement(kurangiStokSQL);
                    kurangiStokStmt.setInt(1, dosis); // Mengisi parameter dosis
                    kurangiStokStmt.setString(2, namaObat); // Mengisi parameter nama obat
                    kurangiStokStmt.executeUpdate();
    
                    // Menambahkan data hewan ke tabel klinkhewan
                    String sqlKlinikHewan = "INSERT INTO klinkhewan (idHewan, namaHewan, jenisHewan, berat, namaPemilik, penyakit, namaObat, dosis, namaDokter) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement psKlinikHewan = connection.prepareStatement(sqlKlinikHewan);
                    psKlinikHewan.setString(1, idHewan);
                    psKlinikHewan.setString(2, namaHewan);
                    psKlinikHewan.setString(3, jenisHewan);
                    psKlinikHewan.setDouble(4, berat); // Menambahkan data berat
                    psKlinikHewan.setString(5, namaPemilik);
                    psKlinikHewan.setString(6, penyakit);
                    psKlinikHewan.setString(7, namaObat);
                    psKlinikHewan.setInt(8, dosis);
                    psKlinikHewan.setString(9, namaDokter);
                    psKlinikHewan.executeUpdate();
    
                    System.out.println("Data hewan dan diagnosa berhasil ditambahkan.");
                } else {
                    System.out.println("Stok obat tidak cukup untuk dosis yang diminta.");
                }
            } else {
                System.out.println("Obat dengan nama tersebut tidak ditemukan. Silakan tambahkan obat ke database terlebih dahulu.");
            }
        } catch (SQLException e) {
            System.out.println("Gagal menambahkan data hewan: " + e.getMessage());
        }
    }

    // Metode untuk menghapus data hewan
    private static void hapusDataHewan() {
        try {
            System.out.print("Masukkan ID Hewan untuk menghapus data: ");
            String idHewan = scanner.nextLine();

            // Menghapus data hewan berdasarkan ID
            String sql = "DELETE FROM klinkhewan WHERE idHewan = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, idHewan);

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) { // Jika ada data yang dihapus
                System.out.println("Data hewan berhasil dihapus.");
            } else { // Jika tidak ada data yang cocok
                System.out.println("Data untuk ID hewan tersebut tidak ditemukan.");
            }
        } catch (SQLException e) {
            System.out.println("Gagal menghapus data hewan: " + e.getMessage());
        }
    }

    // Metode untuk melihat data hewan
    private static void lihatDataHewan() {
        try {
            // Query untuk mengambil semua data dari tabel klinkhewan
            String sql = "SELECT * FROM klinkhewan";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            System.out.println("\nData Klinik Hewan:");
            while (resultSet.next()) { // Iterasi melalui hasil query
                System.out.println(
                    "ID Hewan: " + resultSet.getString("idHewan") +
                    ", Nama Hewan: " + resultSet.getString("namaHewan") +
                    ", Jenis Hewan: " + resultSet.getString("jenisHewan") +
                    ", Pemilik: " + resultSet.getString("namaPemilik") +
                    ", Penyakit: " + resultSet.getString("penyakit") +
                    ", Dokter: " + resultSet.getString("namaDokter") +
                    ", Obat: " + resultSet.getString("namaObat") +
                    ", Dosis: " + resultSet.getInt("dosis") + " mg"
                );
            }
        } catch (SQLException e) {
            System.out.println("Gagal mengambil data klinik hewan: " + e.getMessage());
        }
    }

    // Metode untuk menambah stok obat
    private static void tambahStokObat() {
        try {
            System.out.print("Masukkan ID Obat: ");
            String idObat = scanner.nextLine();
            System.out.print("Masukkan Nama Obat: ");
            String namaObat = scanner.nextLine();
            System.out.print("Masukkan Jumlah Stok Obat (mg): ");
            int stok = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            // Query untuk menambah stok obat (atau memperbarui jika sudah ada)
            String sql = "INSERT INTO obat (idObat, namaObat, stockObat) VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE stockObat = stockObat + ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, idObat);
            preparedStatement.setString(2, namaObat);
            preparedStatement.setInt(3, stok);
            preparedStatement.setInt(4, stok);
            preparedStatement.executeUpdate();

            System.out.println("Stok obat berhasil ditambahkan.");
        } catch (SQLException e) {
            System.out.println("Gagal menambahkan stok obat: " + e.getMessage());
        }
    }

    // Metode untuk melihat stok obat
    private static void lihatStokObat() {
        try {
            // Query untuk mengambil semua data dari tabel obat
            String sql = "SELECT * FROM obat";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            System.out.println("\nDaftar Obat dan Stok:");
            while (resultSet.next()) { // Iterasi melalui hasil query
                System.out.println(
                    "Nama Obat: " + resultSet.getString("namaObat") +
                    ", Stok: " + resultSet.getInt("stockObat") + " mg"
                );
            }
        } catch (SQLException e) {
            System.out.println("Gagal mengambil stok obat: " + e.getMessage());
        }
    }

    // Metode untuk keluar dari program
    private static void keluarProgram() {
        try {
            if (connection != null) { // Jika koneksi ada
                connection.close(); // Menutup koneksi
            }
            System.out.println("Terima kasih telah menggunakan Sistem Pendataan Klinik Hewan. Program selesai.");
            System.exit(0); // Keluar dari program
        } catch (SQLException e) {
            System.out.println("Gagal menutup koneksi database: " + e.getMessage());
        }
    }
}

