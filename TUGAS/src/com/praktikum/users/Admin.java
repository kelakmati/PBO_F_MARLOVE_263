package com.praktikum.users;

import com.praktikum.action.AdminActions;
import com.praktikum.data.Item;
import com.praktikum.data.Database;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin extends User implements AdminActions {
    private final String username;
    private final String password;

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    @Override
    public void login(String inputUsername, String inputPassword) {
        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            System.out.println("Login sebagai admin berhasil!");
        } else {
            System.out.println("Login Gagal, coba lagi.");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
    }

    @Override
    public void ManageItems() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("== Kelola Laporan ==");
            System.out.println("1. Lihat Semua Laporan");
            System.out.println("2. Tandai Barang Telah Diambil");
            System.out.println("0. Kembali");
            System.out.print("Pilih Menu: ");
            int pilih;
            try {
                pilih = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                continue;
            }

            switch (pilih) {
                case 1:
                    for (int i = 0; i < Database.reportedItems.size(); i++) {
                        System.out.println("[" + i + "]\n" + Database.reportedItems.get(i));
                    }
                    break;
                case 2:
                    for (int i = 0; i < Database.reportedItems.size(); i++) {
                        if (Database.reportedItems.get(i).getStatus().equals("Reported")) {
                            System.out.println("[" + i + "] " + Database.reportedItems.get(i).getItemName());
                        }
                    }
                    try {
                        System.out.print("Masukkan indeks barang yang ingin ditandai: ");
                        int index = scanner.nextInt();
                        scanner.nextLine();
                        Item item = Database.reportedItems.get(index);
                        item.setStatus("Claimed");
                        System.out.println("Barang berhasil ditandai sebagai Claimed.");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Indeks tidak valid.");
                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka!");
                        scanner.nextLine();
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    @Override
    public void ManageUsers() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("== Kelola Mahasiswa ==");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("0. Kembali");
            System.out.print("Pilih Menu: ");
            int pilih;
            try {
                pilih = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                continue;
            }

            switch (pilih) {
                case 1:
                    System.out.print("Nama Mahasiswa: ");
                    String nama = scanner.nextLine();
                    System.out.print("NIM Mahasiswa: ");
                    String nim = scanner.nextLine();
                    Database.userList.add(new Mahasiswa(nama, nim));
                    System.out.println("Mahasiswa berhasil ditambahkan!");
                    break;
                case 2:
                    System.out.print("Masukkan NIM Mahasiswa yang ingin dihapus: ");
                    String targetNim = scanner.nextLine();
                    boolean found = false;
                    for (User u : Database.userList) {
                        if (u instanceof Mahasiswa && u.getNim().equals(targetNim)) {
                            Database.userList.remove(u);
                            System.out.println("Mahasiswa berhasil dihapus.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Mahasiswa tidak ditemukan.");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        while (true) {
            System.out.println("== Menu Admin ==");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
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
                ManageItems();
            } else if (pilihan == 2) {
                ManageUsers();
            } else if (pilihan == 0) {
                break;
            } else {
                System.out.println("Pilihan Tidak Valid! Coba Lagi.");
            }
        }
    }
}
