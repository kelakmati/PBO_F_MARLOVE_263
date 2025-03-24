//subclass dari KarakterGame
public class Pahlawan extends KarakterGame{
    public Pahlawan(String nama, int kesehatan){
        //mewarisi KarakterGame dan menggunakan super() dalam constructor
        super(nama, kesehatan);
    }

    //meng-override method serang(KarakterGame targer)
    @Override
    public void serang(KarakterGame target){
        //menampilkan pesan
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Orbital Strike!");
        target.setKesehatan(target.getKesehatan() - 20); //mengurangi poin kesehatan dari target
        System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan()); //meng-update kesehatan target
    }
}
