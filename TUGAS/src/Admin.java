import java.util.Scanner;

public class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan username: ");
        String inputUsername = scanner.next();
        System.out.print("Masukkan password: ");
        String inputPassword = scanner.next();

        if (inputUsername.equals(getUsername()) && inputPassword.equals(getPassword())) {
            displayInfo();
        } else {
            System.out.println("Login Admin gagal!");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Username = " + getUsername());
        System.out.println("Password = " + getPassword());
    }
}