public class Main {
    public static void main(String[] args) {
        //membuat 2 object
        Hewan hewan1 = new Hewan();
        Hewan hewan2 = new Hewan();

        //menetapkan nama tiap object
        hewan1.Nama = "Kucing";
        hewan2.Nama = "Anjing";

        hewan1.Jenis = "Mamalia";
        hewan2.Jenis = "Mamalia";

        hewan1.Suara = "Nyann~~";
        hewan2.Suara = "Woof-woof!!";

        //memanggil methode pada kedua object dari kelas Hewan
        hewan1.tampilkanInfo();
        hewan2.tampilkanInfo();
    }
}
