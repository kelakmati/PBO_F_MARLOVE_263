package com.praktikum.users;

import com.praktikum.action.MahasiswaActions;
import com.praktikum.data.Item;
import com.praktikum.data.Database;
import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {
    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public void login(String inputNama, String inputNim) {
        if (inputNama.equals(getNama()) && inputNim.equals(getNim())) {
            System.out.println("Login sebagai mahasiswa berhasil!");
        } else {
            System.out.println("Login gagal, coba lagi.");
        }
    }

    @Override
    public void ReportItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Nama Barang: ");
        String namaBarang = scanner.nextLine();
        System.out.print("Masukkan Deskripsi Barang: ");
        String deskripsiBarang = scanner.nextLine();
        System.out.print("Masukkan Lokasi Terakhir/Ditemukan: ");
        String lokasi = scanner.nextLine();

        Item item = new Item(namaBarang, deskripsiBarang, lokasi);
        Database.reportedItems.add(item);

        System.out.println("\nBarang berhasil dilaporkan!");
    }

    @Override
    public void ViewReportedItem() {
        if (Database.reportedItems.isEmpty()) {
            System.out.println("Belum ada laporan barang.");
            return;
        }
        System.out.println("== Daftar Barang Hilang ==");
        for (Item item : Database.reportedItems) {
            if (item.getStatus().equals("Reported")) {
                System.out.println(item);
                System.out.println("---------------------------");
            }
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        while (true) {
            System.out.println("== Menu Mahasiswa ==");
            System.out.println("1. Laporan Barang Hilang");
            System.out.println("2. Lihat Daftar Barang Hilang");
            System.out.println("0. Logout");
            System.out.print("Pilih Menu : ");
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                continue;
            }

            if(pilihan == 1){
                ReportItem();
            } else if (pilihan == 2) {
                ViewReportedItem();
            } else if (pilihan == 0) {
                break;
            } else {
                System.out.println("Pilihan Tidak Valid! Coba Lagi.");
            }
        }
    }
}
