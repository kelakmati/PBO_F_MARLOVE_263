package com.praktikum.main;

import com.praktikum.users.*;
import com.praktikum.data.Database;
import java.util.Scanner;

public class Main {
    private final Admin admin;
    private final Mahasiswa mahasiswa;

    public Main() {
        admin = new Admin("Marlove Salim", "202410370110263", "Admin263", "password263");
        mahasiswa = new Mahasiswa("Marlove Salim", "202410370110263");
        Database.userList.add(admin);
        Database.userList.add(mahasiswa);
    }

    public void menu() {
        System.out.println("Pilih login sebagai: ");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.println("0. Keluar");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            menu();
            System.out.print("Pilih jenis login (1-2): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 1) {
                System.out.print("Masukkan username: ");
                String username = scanner.nextLine();
                System.out.print("Masukkan password: ");
                String password = scanner.nextLine();
                admin.login(username, password);
                admin.displayInfo();
                admin.displayAppMenu();
                break;
            } else if (pilihan == 2) {
                System.out.print("Masukkan nama: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan NIM: ");
                String nim = scanner.nextLine();

                boolean found = false;
                for (User user : Database.userList) {
                    if (user instanceof Mahasiswa && user.getNama().equals(nama) && user.getNim().equals(nim)) {
                        user.displayInfo();
                        user.displayAppMenu();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Login gagal. Mahasiswa tidak ditemukan.");
                }
                break;
            } else if (pilihan == 0) {
                System.out.println("Terima Kasih!");
            } else {
                System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }
}
