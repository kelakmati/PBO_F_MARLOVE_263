import java.util.Scanner;
import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        char genderChar = 0;
        int birthYear = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Masukkan nama: ");
            name = scanner.nextLine();
            if (name.matches(".*\\d.*")) {
                System.out.println("Nama tidak boleh mengandung angka. Silakan coba lagi.");
            } else {
                validInput = true;
            }
        }

        validInput = false;
        while (!validInput) {
            System.out.print("Masukkan jenis kelamin (P/L): ");
            genderChar = scanner.next().charAt(0);
            if (Character.isDigit(genderChar)) {
                System.out.println("Jenis kelamin tidak boleh mengandung angka. Silakan coba lagi.");
            } else {
                validInput = true;
            }
        }

        validInput = false;
        while (!validInput) {
            System.out.print("Masukkan tahun lahir: ");
            if (scanner.hasNextInt()) {
                birthYear = scanner.nextInt();
                validInput = true;
            } else {
                System.out.println("Tahun lahir harus berupa angka. Silakan coba lagi.");
                scanner.next();
            }
        }

        int currentYear = LocalDate.now().getYear();
        int age = currentYear - birthYear;
        String gender = (genderChar == 'L' || genderChar == 'l') ? "Laki-laki" : "Perempuan";

        System.out.println("Data Diri:");
        System.out.println("Nama: " + name);
        System.out.println("Jenis Kelamin: " + gender);
        System.out.println("Umur: " + age + " tahun");

        scanner.close();
    }
}
