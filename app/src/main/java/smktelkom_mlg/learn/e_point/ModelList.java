package smktelkom_mlg.learn.e_point;

/**
 * Created by Salsa on 13/01/2018.
 */

public class ModelList {
    String id_laporan, nama, nama_kategori, nama_pelanggaran, tanggal, poin;

    public ModelList() {
    }

    public ModelList(String id_laporan, String nama, String nama_kategori, String nama_pelanggaran, String tanggal, String poin) {
        this.id_laporan = id_laporan;
        this.nama = nama;
        this.nama_kategori = nama_kategori;
        this.nama_pelanggaran = nama_pelanggaran;
        this.tanggal = tanggal;
        this.poin = poin;
    }

    public String getId_laporan() {
        return id_laporan;
    }

    public void setId_laporan(String id_laporan) {
        this.nama = id_laporan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama_kategori() {
        return nama_kategori;
    }

    public void setNama_kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    }

    public String getNama_pelanggaran() {
        return nama_pelanggaran;
    }

    public void setNama_pelanggaran(String nama_pelanggaran) {
        this.nama_pelanggaran = nama_pelanggaran;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getPoin() {
        return poin;
    }

    public void setPoin(String poin) {
        this.poin = poin;
    }
}
