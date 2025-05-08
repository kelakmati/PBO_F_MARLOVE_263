package app;

import Perpustakaan.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Buku sudah tetap (tanpa input manual)
        Buku buku1 = new NonFiksi("Madilog", "Tan Malaka");
        Buku buku2 = new Fiksi("HainumLee: Sang Putri Kelapa", "Lilis Hw");
        Anggota anggota1 = new Anggota("Marlove Salim", "F263");
        Anggota anggota2 = new Anggota("Safira", "F233");

        System.out.println();
        buku1.displayInfo();
        buku2.displayInfo();

        System.out.println();
        anggota1.displayInfo();
        anggota2.displayInfo();

        // Proses otomatis setelah input
        System.out.println();
        anggota1.pinjamBuku(buku1);
        anggota2.pinjamBuku(buku2, 7);

        // Proses pengembalian otomatis
        System.out.println();
        anggota1.kembalikanBuku(buku1);
        anggota2.kembalikanBuku(buku2);

        input.close();}
}
