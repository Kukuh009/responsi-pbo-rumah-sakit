/**
 * Subclass 1: Dokter.
 * [Syarat 10] Mengimplementasikan DUA interface sekaligus.
 */
public class Dokter extends PetugasMedis implements Pemeriksa, PenangananDarurat {

    private static final int BIAYA_ENERGI_PERIKSA = 30;
    private static final int BIAYA_ENERGI_DARURAT = 50;

    private String spesialisasi;

    // [Syarat 3 & 5] Konstruktor 1 -> memanggil super(...)
    public Dokter(String idPegawai, String nama) {
        super(idPegawai, nama);
        this.spesialisasi = "Umum";
    }

    // [Syarat 3 & 5] Konstruktor 2 (overloading) -> memanggil super(...)
    public Dokter(String idPegawai, String nama, String spesialisasi, int energi) {
        super(idPegawai, nama, energi);
        this.spesialisasi = spesialisasi;
    }

    // [Syarat 6 & 8] Implementasi abstract method + logika if/else yang
    // MEMBACA energi (getEnergi) dan MENGUBAH state (setEnergi, catatPasien)
    @Override
    public String bekerja() {
        if (getEnergi() >= BIAYA_ENERGI_PERIKSA) {
            setEnergi(getEnergi() - BIAYA_ENERGI_PERIKSA);
            catatPasienDitangani();
            return "dr. " + getNama() + " berhasil memeriksa pasien. Sisa energi: " + getEnergi();
        } else {
            return "dr. " + getNama() + " terlalu lelah (energi " + getEnergi() + "), harus istirahat!";
        }
    }

    // Implementasi interface Pemeriksa
    @Override
    public String periksaPasien(String namaPasien) {
        return "[Periksa] Pasien " + namaPasien + " -> " + bekerja();
    }

    // Implementasi interface PenangananDarurat
    @Override
    public String tanganiDarurat(String namaPasien) {
        if (getEnergi() >= BIAYA_ENERGI_DARURAT) {
            setEnergi(getEnergi() - BIAYA_ENERGI_DARURAT);
            catatPasienDitangani();
            return "[DARURAT] dr. " + getNama() + " menangani " + namaPasien
                    + ". Sisa energi: " + getEnergi();
        } else {
            return "[DARURAT] dr. " + getNama() + " tidak cukup energi, panggil dokter lain!";
        }
    }

    // [Syarat 5 & 6] Override + super.namaMethod()
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo(); // memanggil method milik superclass
        System.out.println("Jabatan          : Dokter");
        System.out.println("Spesialisasi     : " + spesialisasi);
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    public void setSpesialisasi(String spesialisasi) {
        this.spesialisasi = spesialisasi;
    }
}
