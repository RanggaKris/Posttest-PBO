package Posttest2;
import java.util.ArrayList;
import java.util.Scanner;

class SportCar {

    private String merek;
    private String model;
    private int tahun;
    private String warna;
    private double harga;

    public SportCar(String merek, String model, int tahun, String warna, double harga) {
        this.merek = merek;
        this.model = model;
        this.tahun = tahun;
        this.warna = warna;
        this.harga = harga;
    }

    // Getter and setter methods
    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return "SportCar{" +
                "merek='" + merek + '\'' +
                ", model='" + model + '\'' +
                ", tahun=" + tahun +
                ", warna='" + warna + '\'' +
                ", harga=" + harga +
                '}';
    }
}

public class GNS {

    private static ArrayList<SportCar> mobilList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            tampilkanMenu();
            pilihan = Integer.parseInt(scanner.nextLine());

            switch (pilihan) {
                case 1:
                    tambahMobil();
                    System.out.println("-----------------------------------------");
                    break;
                case 2:
                    lihatDaftarMobil();
                    System.out.println("-----------------------------------------");
                    break;
                case 3:
                    ubahDataMobil();
                    System.out.println("-----------------------------------------");
                    break;
                case 4:
                    hapusMobil();
                    System.out.println("-----------------------------------------");
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan program ini!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 5);
    }

    private static void tampilkanMenu() {
        System.out.println("Sistem Pendataan Sport Car GarageNeroSupremacy");
        System.out.println("-----------------------------------------");
        System.out.println("1. Tambah Mobil");
        System.out.println("2. Lihat Daftar Mobil");
        System.out.println("3. Ubah Data Mobil");
        System.out.println("4. Hapus Mobil");
        System.out.println("5. Keluar");
        System.out.print("Masukkan pilihan > ");
    }

    private static void tambahMobil() {
        System.out.print("Masukkan merek: ");
        String merek = scanner.nextLine();
        System.out.print("Masukkan model: ");
        String model = scanner.nextLine();
        System.out.print("Masukkan tahun: ");
        int tahun = Integer.parseInt(scanner.nextLine());
        System.out.print("Masukkan warna: ");
        String warna = scanner.nextLine();
        System.out.print("Masukkan harga: ");
        String hargaStr = scanner.nextLine();
        
        // Ini ngehapus titik dari harga kalo ada
        String hargaWithoutDots = hargaStr.replaceAll("\\.", "");
        double harga = Double.parseDouble(hargaWithoutDots);
    
        mobilList.add(new SportCar(merek, model, tahun, warna, harga));
        System.out.println("Mobil baru telah ditambahkan!");
    }

    private static void lihatDaftarMobil() {
        if (mobilList.isEmpty()) {
            System.out.println("Daftar mobil masih kosong!");
            return;
        }

        for (SportCar mobil : mobilList) {
            System.out.println(mobil);
        }
    }

    private static void ubahDataMobil() {
        if (mobilList.isEmpty()) {
            System.out.println("Daftar mobil masih kosong!");
            return;
        }

        System.out.print("Masukkan index mobil yang ingin diubah: ");
        int index = Integer.parseInt(scanner.nextLine());

        if (index < 0 || index >= mobilList.size()) {
            System.out.println("Index tidak valid!");
            return;
        }

        System.out.print("Masukkan merek baru: ");
        String merekBaru = scanner.nextLine();
        System.out.print("Masukkan model baru: ");
        String modelBaru = scanner.nextLine();
        System.out.print("Masukkan tahun baru: ");
        int tahunBaru = Integer.parseInt(scanner.nextLine());
        System.out.print("Masukkan warna baru: ");
        String warnaBaru = scanner.nextLine();
        System.out.print("Masukkan harga baru: ");
        double hargaBaru = Double.parseDouble(scanner.nextLine());

        mobilList.get(index).setMerek(merekBaru);
        mobilList.get(index).setModel(modelBaru);
        mobilList.get(index).setTahun(tahunBaru);
        mobilList.get(index).setWarna(warnaBaru);
        mobilList.get(index).setHarga(hargaBaru);

        System.out.println("Data mobil telah diubah!");
    }

    private static void hapusMobil() {
        if (mobilList.isEmpty()) {
            System.out.println("Daftar mobil masih kosong!");
            return;
        }

        System.out.print("Masukkan index mobil yang ingin dihapus: ");
        int index = Integer.parseInt(scanner.nextLine());

        if (index < 0 || index >= mobilList.size()) {
            System.out.println("Index tidak valid!");
            return;
        }

        mobilList.remove(index);
        System.out.println("Mobil telah dihapus!");
    }
}
