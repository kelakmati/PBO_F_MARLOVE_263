public class Main { //kelas utama
    public static void main(String[] args) {
        //membuat 3 objek
        KarakterGame karakterGame = new KarakterGame("Karakter Umum", 100);
        Pahlawan pahlawan = new Pahlawan("Brimstone", 150);
        Musuh musuh = new Musuh("Viper", 200);

        System.out.println("Status awal :"); //menampilkan status awal
        System.out.println(pahlawan.getNama() + " memiliki kesehatan: " + pahlawan.getKesehatan()); //menampilkan status kesehatan pahlawan
        System.out.println(musuh.getNama() + " memiliki kesehatan: " + musuh.getKesehatan()); //menampilkan status kesehatan musuh

        //memanggil methode serang()
        pahlawan.serang(musuh); //pahlawan menyerang musuh, poin kesehatan musuh dikurangi 20
        musuh.serang(pahlawan); //musuh menyerang pahlawan, poin kesehatan pahlawan dikurangi 15
    }
}
