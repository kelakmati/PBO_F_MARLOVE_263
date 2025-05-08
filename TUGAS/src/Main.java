import java.util.Scanner;

// Kelas utama untuk menjalankan program login
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin("Admin263", "password263");
        Mahasiswa mahasiswa = new Mahasiswa("Marlove Salim", "202410370110263", "202410370110263");

        System.out.println("Pilih login sebagai:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan: ");
        int pilihan = scanner.nextInt();

        if (pilihan == 1) {
            admin.login();
        } else if (pilihan == 2) {
            mahasiswa.login();
        } else {
            System.out.println("Pilihan tidak valid!");
        }
    }
}