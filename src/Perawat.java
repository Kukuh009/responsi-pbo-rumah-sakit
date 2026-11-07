/**
 * Subclass 2: Perawat.
 * Hanya mengimplementasikan satu interface (Pemeriksa).
 */
public class Perawat extends PetugasMedis implements Pemeriksa {

    private static final int BIAYA_ENERGI_MERAWAT = 20;

    private String ruangan;

    // Konstruktor 1
    public Perawat(String idPegawai, String nama) {
        super(idPegawai, nama);
        this.ruangan = "IGD";
    }

    // Konstruktor 2 (overloading)
    public Perawat(String idPegawai, String nama, String ruangan, int energi) {
        super(idPegawai, nama, energi);
        this.ruangan = ruangan;
    }

    // [Syarat 6 & 8] Implementasi abstract method dengan if/else + ubah state
    @Override
    public String bekerja() {
        if (getEnergi() >= BIAYA_ENERGI_MERAWAT) {
            setEnergi(getEnergi() - BIAYA_ENERGI_MERAWAT);
            catatPasienDitangani();
            return "Perawat " + getNama() + " merawat pasien di ruang " + ruangan
                    + ". Sisa energi: " + getEnergi();
        } else {
            return "Perawat " + getNama() + " kelelahan (energi " + getEnergi() + "), butuh istirahat!";
        }
    }

    @Override
    public String periksaPasien(String namaPasien) {
        return "[Cek tensi & suhu] Pasien " + namaPasien + " -> " + bekerja();
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jabatan          : Perawat");
        System.out.println("Ruangan          : " + ruangan);
    }

    public String getRuangan() {
        return ruangan;
    }

    public void setRuangan(String ruangan) {
        this.ruangan = ruangan;
    }
}
