// Mendefinisikan interface Diagnosable
public interface Diagnosable {
    // Deklarasi metode abstrak untuk melakukan diagnosa
    // Parameter:
    // - keluhan: String yang berisi deskripsi keluhan hewan
    // - namaDokter: String yang berisi nama dokter yang mendiagnosa
    // - obat: Objek Obat yang akan diresepkan
    // - dosis: Integer yang menentukan dosis obat yang diberikan
    void diagnosa(String keluhan, String namaDokter, Obat obat, int dosis);
}
