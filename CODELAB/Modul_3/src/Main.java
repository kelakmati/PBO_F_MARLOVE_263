public class Main {
    public static void main(String[] args) {
        KarakterGame karakterGame = new KarakterGame("Karakter Umum", 100);
        Pahlawan pahlawan = new Pahlawan("Brimstone", 150);
        Musuh musuh = new Musuh("Viper", 200);

        System.out.println("Status awal :");
        System.out.println(pahlawan.getNama() + " memiliki kesehatan: " + pahlawan.getKesehatan());
        System.out.println(musuh.getNama() + " memiliki kesehatan: " + musuh.getKesehatan());

        pahlawan.serang(musuh);
        musuh.serang(pahlawan);
    }
}
