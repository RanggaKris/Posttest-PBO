package Posttest6;

import java.util.ArrayList;
import java.util.Scanner;

interface CarFunction {
    void startEngine();
    static void displayInfo() {
        System.out.println("This is a car.");
    }
}

abstract class SportCar {
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

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getMerek() {
        return merek;
    }

    public String getModel() {
        return model;
    }

    public int getTahun() {
        return tahun;
    }

    public String getWarna() {
        return warna;
    }

    public double getHarga() {
        return harga;
    }

    public abstract void showDetails();

    public final String toString() {
        return "SportCar{" +
                "merek='" + merek + '\'' +
                ", model='" + model + '\'' +
                ", tahun=" + tahun +
                ", warna='" + warna + '\'' +
                ", harga=" + harga +
                '}';
    }
}

class LuxuryCar extends SportCar implements CarFunction {
    private boolean hasMassageSeats;

    public LuxuryCar(String merek, String model, int tahun, String warna, double harga, boolean hasMassageSeats) {
        super(merek, model, tahun, warna, harga);
        this.hasMassageSeats = hasMassageSeats;
    }

    public boolean isHasMassageSeats() {
        return hasMassageSeats;
    }

    public void setHasMassageSeats(boolean hasMassageSeats) {
        this.hasMassageSeats = hasMassageSeats;
    }

    @Override
    public void showDetails() {
        System.out.println("Luxury Car Details: " + this.toString());
    }

    public void massageSeatsOn() {
        System.out.println("Massage seats are turned on.");
    }

    public void massageSeatsOff() {
        System.out.println("Massage seats are turned off.");
    }

    @Override
    public void startEngine() {
        System.out.println("Luxury car engine started.");
    }
}

class EconomyCar extends SportCar {
    private boolean isFuelEfficient;

    public EconomyCar(String merek, String model, int tahun, String warna, double harga, boolean isFuelEfficient) {
        super(merek, model, tahun, warna, harga);
        this.isFuelEfficient = isFuelEfficient;
    }

    public boolean isFuelEfficient() {
        return isFuelEfficient;
    }

    public void setFuelEfficient(boolean fuelEfficient) {
        isFuelEfficient = fuelEfficient;
    }

    @Override
    public void showDetails() {
        System.out.println("Economy Car Details: " + this.toString());
    }

    public void ecoModeOn() {
        System.out.println("Eco mode is activated.");
    }

    public void ecoModeOff() {
        System.out.println("Eco mode is deactivated.");
    }
}

class ElectricCar extends SportCar {
    private int batteryCapacity;

    public ElectricCar(String merek, String model, int tahun, String warna, double harga, int batteryCapacity) {
        super(merek, model, tahun, warna, harga);
        this.batteryCapacity = batteryCapacity;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public void showDetails() {
        System.out.println("Electric Car Details: " + this.toString());
    }

    public void chargeBattery() {
        System.out.println("Charging the battery...");
    }
}

public class GNS {
    private static final ArrayList<SportCar> mobilList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

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
        System.out.println("Pilih jenis mobil:");
        System.out.println("1. Mobil Sport");
        System.out.println("2. Mobil Luxury");
        System.out.println("3. Mobil Ekonomi");
        System.out.println("4. Mobil Listrik");
        System.out.print("Masukkan pilihan > ");
        int jenisMobil = Integer.parseInt(scanner.nextLine());

        switch (jenisMobil) {
            case 1:
                tambahSportCar();
                break;
            case 2:
                tambahLuxuryCar();
                break;
            case 3:
                tambahEconomyCar();
                break;
            case 4:
                tambahElectricCar();
                break;
            default:
                System.out.println("Pilihan tidak valid!");
        }
    }

    private static void tambahSportCar() {
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

        String hargaWithoutDots = hargaStr.replaceAll("\\.", "");
        double harga = Double.parseDouble(hargaWithoutDots);

        mobilList.add(new SportCar(merek, model, tahun, warna, harga) {
            @Override
            public void showDetails() {
                System.out.println("Sport Car Details: " + this.toString());
            }
        });
        System.out.println("Mobil baru telah ditambahkan!");
    }

    private static void tambahLuxuryCar() {
        System.out.print("Masukkan merek: ");
        String merek = scanner.nextLine();
        System.out.println("Masukkan model: ");
        String model = scanner.nextLine();
        System.out.print("Masukkan tahun: ");
        int tahun = Integer.parseInt(scanner.nextLine());
        System.out.print("Masukkan warna: ");
        String warna = scanner.nextLine();
        System.out.print("Masukkan harga: ");
        String hargaStr = scanner.nextLine();
        System.out.print("Apakah mobil memiliki kursi pijat? (true/false): ");
        boolean hasMassageSeats = Boolean.parseBoolean(scanner.nextLine());

        String hargaWithoutDots = hargaStr.replaceAll("\\.", "");
        double harga = Double.parseDouble(hargaWithoutDots);

        mobilList.add(new LuxuryCar(merek, model, tahun, warna, harga, hasMassageSeats));
        System.out.println("Mobil Luxury baru telah ditambahkan!");
    }

    private static void tambahEconomyCar() {
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
        System.out.print("Apakah mobil hemat bahan bakar? (true/false): ");
        boolean isFuelEfficient = Boolean.parseBoolean(scanner.nextLine());

        String hargaWithoutDots = hargaStr.replaceAll("\\.", "");
        double harga = Double.parseDouble(hargaWithoutDots);

        mobilList.add(new EconomyCar(merek, model, tahun, warna, harga, isFuelEfficient));
        System.out.println("Mobil ekonomi baru telah ditambahkan!");
    }

    private static void tambahElectricCar() {
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
        System.out.print("Masukkan kapasitas baterai: ");
        int batteryCapacity = Integer.parseInt(scanner.nextLine());

        String hargaWithoutDots = hargaStr.replaceAll("\\.", "");
        double harga = Double.parseDouble(hargaWithoutDots);

        mobilList.add(new ElectricCar(merek, model, tahun, warna, harga, batteryCapacity));
        System.out.println("Mobil listrik baru telah ditambahkan!");
    }
    
    private static void lihatDaftarMobil() {
        if (mobilList.isEmpty()) {
            System.out.println("Daftar mobil masih kosong!");
            return;
        }

        for (SportCar mobil : mobilList) {
            mobil.showDetails();
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
