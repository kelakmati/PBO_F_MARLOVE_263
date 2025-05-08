import java.util.Scanner;

// Kelas Mahasiswa untuk menyimpan data login mahasiswa
public class Mahasiswa extends User {
    String Nim;

    public Mahasiswa (String username, String password, String Nim) {
        super(username, password);
        this.Nim = Nim;
    }

    public String getNim() {
        return Nim;
    }

    public void setNim(String nim) {
        Nim = nim;
    }

    @Override
    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Nama: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Masukkan NIM: ");
        String inputPassword = scanner.nextLine();

        if (inputUsername.equals(getUsername()) && inputPassword.equals(getPassword())) {
            displayInfo();
        } else {
            System.out.println("Login Mahasiswa gagal!");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Nama = " + getUsername());
        System.out.println("Nim = " + getPassword());
    }
}
