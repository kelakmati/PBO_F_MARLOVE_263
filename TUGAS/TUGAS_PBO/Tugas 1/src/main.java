import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loginBerhasil = false;

        while (!loginBerhasil) {
            System.out.println("Pilih Login:");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.print("Masukkan pilihan anda: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 1) {
                System.out.print("Masukkan username: ");
                String username = scanner.nextLine();
                System.out.print("Masukkan password: ");
                String password = scanner.nextLine();

                if (username.equals("Admin263") && password.equals("Password263")) {
                    System.out.println("Login Admin berhasil!");
                    loginBerhasil = true;
                } else {
                    System.out.println("Login gagal! Username atau password salah.");
                }
            } else if (pilihan == 2) {
                boolean mahasiswaLoginBerhasil = false;
                while (!mahasiswaLoginBerhasil) {
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan NIM: ");
                    String nim = scanner.nextLine();

                    if (nama.equals("Marlove Salim") && nim.equals("202410370110263")) {
                        System.out.println("Login Mahasiswa berhasil!");
                        System.out.println("Nama: " + nama);
                        System.out.println("NIM: " + nim);
                        mahasiswaLoginBerhasil = true;
                        loginBerhasil = true;
                    } else {
                        System.out.println("Login gagal! Nama atau NIM salah.");
                    }
                }
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }

        scanner.close();
    }
}
