public class KarakterGame {
    private String nama;
    public int kesehatan;

    public KarakterGame(String nama, int kesehatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

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

    public void serang(KarakterGame target){
        System.out.println(nama + "menyerang" + target.getNama());
    }
}
