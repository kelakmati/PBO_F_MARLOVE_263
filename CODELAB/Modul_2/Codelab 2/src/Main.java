public class Main {
    public static void main(String[] args) {
        RekeningBank rekening1 = new RekeningBank();
        RekeningBank rekening2 = new RekeningBank();

        rekening1.nomorRekening = "202410370110263";
        rekening2.nomorRekening = "202410370110233";

        rekening1.namaPemilik = "Marlove Salim";
        rekening2.namaPemilik = "Safira";

        rekening1.saldo = 2000000;
        rekening2.saldo = 1200000;

        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();

        rekening1.setorUang(300000);
        rekening2.setorUang(500000);

        rekening1.tarikUang(3000000);
        rekening2.tarikUang(90000);

        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();

    }
}
