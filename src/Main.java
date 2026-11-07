/**
 * Class Main (terpisah dari class lain) untuk membuktikan 10 persyaratan.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== SISTEM " + PetugasMedis.NAMA_RUMAH_SAKIT.toUpperCase() + " ===\n");

        // ---------- [Syarat 3 & 4] Overloaded constructor + inheritance ----------
        System.out.println("--- Tes 1: Konstruktor overloading & Inheritance ---");
        Dokter dokter1 = new Dokter("DR-017", "KUKUH.PROF.DR.SPECIALIS");                          // konstruktor 1
        Dokter dokter2 = new Dokter("DR-002", "Sinta", "Anak", 60);             // konstruktor 2
        Perawat perawat1 = new Perawat("PR-001", "Budi", "Melati", 100);
        dokter1.tampilkanInfo(); // [Syarat 5 & 6] tampilkanInfo() Dokter memanggil super.tampilkanInfo()
        System.out.println();
        dokter2.tampilkanInfo();
        System.out.println();
        perawat1.tampilkanInfo();

        // ---------- [Syarat 1 & 2] State, behavior, konstanta, atribut final ----------
        System.out.println("\n--- Tes 2: State, Behavior, Konstanta, Final ---");
        System.out.println("Konstanta ENERGI_MAKSIMAL : " + PetugasMedis.ENERGI_MAKSIMAL);
        System.out.println("ID dokter1 (final)        : " + dokter1.getIdPegawai());
        System.out.println("Masih bertenaga? (fungsi) : " + dokter1.masihBertenaga());
        dokter1.setNama("Andi Wijaya"); // setter
        System.out.println("Nama setelah setter       : " + dokter1.getNama());

        // ---------- [Syarat 7 & 8] Abstract method + logika if/else ----------
        System.out.println("\n--- Tes 3: Abstract method & logika if/else state ---");
        // dokter2 energinya 60 -> bisa kerja 2x, lalu kelelahan
        System.out.println(dokter2.bekerja());
        System.out.println(dokter2.bekerja());
        System.out.println(dokter2.bekerja()); // energi tinggal 0 -> masuk else
        dokter2.istirahat();                   // method void
        System.out.println(dokter2.bekerja()); // bisa kerja lagi

        // ---------- [Syarat 9] Polimorfisme lewat interface ----------
        System.out.println("\n--- Tes 4: Polimorfisme lewat Interface ---");
        Pemeriksa pemeriksa1 = new Dokter("DR-003", "Rina", "Bedah", 100);
        Pemeriksa pemeriksa2 = new Perawat("PR-002", "Dewi", "Mawar", 100);
        System.out.println(pemeriksa1.periksaPasien("Pak Joko"));
        System.out.println(pemeriksa2.periksaPasien("Bu Siti"));

        // ---------- [Syarat 10] Satu subclass, dua interface ----------
        System.out.println("\n--- Tes 5: Multiple Interface (Dokter = Pemeriksa + PenangananDarurat) ---");
        Dokter dokterIgd = new Dokter("DR-004", "Hadi", "Bedah", 100);
        Pemeriksa sebagaiPemeriksa = dokterIgd;
        PenangananDarurat sebagaiDarurat = dokterIgd;
        System.out.println(sebagaiPemeriksa.periksaPasien("Pak Eko"));
        System.out.println(sebagaiDarurat.tanganiDarurat("Korban Kecelakaan"));
        System.out.println(sebagaiDarurat.tanganiDarurat("Korban Kecelakaan 2")); // energi kurang -> else

        // ---------- Bonus: Polimorfisme lewat superclass abstract ----------
        System.out.println("\n--- Tes 6: Polimorfisme lewat superclass (abstract) ---");
        PetugasMedis[] daftarPetugas = { dokter1, perawat1, dokterIgd };
        for (PetugasMedis petugas : daftarPetugas) {
            System.out.println(petugas.bekerja()); // method yang jalan sesuai tipe objek aslinya
        }
    }
}
