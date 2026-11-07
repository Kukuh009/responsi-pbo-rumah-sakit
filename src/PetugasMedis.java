/**
 * Superclass ABSTRACT untuk semua petugas medis di rumah sakit.
 * Subclass: Dokter dan Perawat.
 */
public abstract class PetugasMedis {

    // [Syarat 2] Konstanta global (public static final)
    public static final String NAMA_RUMAH_SAKIT = "RSUD Sehat Sentosa";
    public static final int ENERGI_MAKSIMAL = 100;

    // [Syarat 2] Atribut instans kekal (private final): ID tidak boleh berubah
    private final String idPegawai;

    // [Syarat 1 & 3] Atribut (state) semuanya private
    private String nama;
    private int energi;
    private int jumlahPasienDitangani;

    // [Syarat 3] Konstruktor 1: energi otomatis penuh
    public PetugasMedis(String idPegawai, String nama) {
        this(idPegawai, nama, ENERGI_MAKSIMAL); // memanggil konstruktor 2
    }

    // [Syarat 3] Konstruktor 2 (overloading): energi awal ditentukan sendiri
    public PetugasMedis(String idPegawai, String nama, int energi) {
        this.idPegawai = idPegawai;
        this.nama = nama;
        setEnergi(energi); // lewat setter supaya nilainya divalidasi
        this.jumlahPasienDitangani = 0;
    }

    // [Syarat 7] Abstract method: wajib ditulis ulang oleh subclass
    public abstract String bekerja();

    // [Syarat 1] Method prosedur (void)
    public void istirahat() {
        setEnergi(ENERGI_MAKSIMAL);
        System.out.println(nama + " beristirahat. Energi pulih menjadi " + energi);
    }

    // [Syarat 1] Method prosedur (void)
    public void catatPasienDitangani() {
        jumlahPasienDitangani++;
    }

    // [Syarat 1] Method fungsi (mengembalikan nilai)
    public boolean masihBertenaga() {
        return energi > 0;
    }

    // Method ini akan di-override oleh subclass
    public void tampilkanInfo() {
        System.out.println("ID Pegawai       : " + idPegawai);
        System.out.println("Nama             : " + nama);
        System.out.println("Energi           : " + energi + "/" + ENERGI_MAKSIMAL);
        System.out.println("Pasien ditangani : " + jumlahPasienDitangani);
    }

    // ===== Getter & Setter =====
    // (idPegawai hanya punya getter karena bersifat final)
    public String getIdPegawai() {
        return idPegawai;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getEnergi() {
        return energi;
    }

    public void setEnergi(int energi) {
        // Validasi: energi tidak boleh kurang dari 0 atau lebih dari maksimal
        if (energi < 0) {
            this.energi = 0;
        } else if (energi > ENERGI_MAKSIMAL) {
            this.energi = ENERGI_MAKSIMAL;
        } else {
            this.energi = energi;
        }
    }

    public int getJumlahPasienDitangani() {
        return jumlahPasienDitangani;
    }

    public void setJumlahPasienDitangani(int jumlahPasienDitangani) {
        this.jumlahPasienDitangani = jumlahPasienDitangani;
    }
}
