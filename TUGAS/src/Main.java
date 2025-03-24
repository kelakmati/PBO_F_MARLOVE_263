import java.util.Scanner;

// Kelas utama untuk menjalankan program login
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        Mahasiswa mahasiswa = new Mahasiswa("Marlove Salim", "202410370110263");

        System.out.println("Pilih login");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Login sebagai Mahasiswa");
        System.out.print("Masukkan pilihan : ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();  // Membersihkan buffer input

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan Username: ");
                String user = scanner.nextLine();
                System.out.print("Masukkan Password: ");
                String pass = scanner.nextLine();

                if (admin.login(user, pass)) {
                    System.out.println("Login Admin Berhasil!");
                } else {
                    System.out.println("Login Admin Gagal! Username atau Password salah.");
                }
                break;

            case 2:
                System.out.print("Masukkan Nama: ");
                String namaInput = scanner.nextLine();
                System.out.print("Masukkan NIM: ");
                String nimInput = scanner.nextLine();

                if (mahasiswa.login(namaInput, nimInput)) {
                    mahasiswa.displayInfo();
                } else {
                    System.out.println("Login Mahasiswa Gagal! Nama atau NIM salah.");
                }
                break;

            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
        }

        scanner.close();
    }
}