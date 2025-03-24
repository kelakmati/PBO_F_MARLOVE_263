//membuat superclass
public class KarakterGame {
    //atribut privat nama dan kesehatan
    private String nama;
    private int kesehatan;

    public KarakterGame(String nama, int kesehatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
    }
    // getter dan setter untuk atribut nama dan kesehatan
    public String getNama(){
        return nama;
    }

    public int getKesehatan(){
        return kesehatan;
    }

    public void setNama (String nama){
        this.nama = nama;
    }

    public void setKesehatan (int kesehatan){
        this.kesehatan = kesehatan;
    }
    //memiliki methode serang(KarakterGame target)
    public void serang(KarakterGame target){
        System.out.println(nama + "menyerang" + target.getNama());
    }
}
