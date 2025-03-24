//subclass dari karakterGame
public class Musuh extends KarakterGame{
    public Musuh(String nama, int kesehatan){
        super(nama, kesehatan); //mewarisi KarakterGame dan menggunakan super()
    }

    //meng-override method serang(karakterGame target)
    @Override
    public void serang(KarakterGame target) {
        //menampilkan pesan
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Snake Bite!");
        target.setKesehatan(target.getKesehatan() - 15); //mengurangi poin kesehatan target
        System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan()); //menampilkan update terbaru dari kesehatan target
    }
}
