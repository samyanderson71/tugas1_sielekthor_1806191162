package apap.tugas.sielekthor.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;


@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter

@Entity
@Table(name = "barang")
public class BarangModel implements Serializable {

    public Long getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(Long idBarang) {
        this.idBarang = idBarang;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public Long getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(Long hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getDeskripsiBarang() {
        return deskripsiBarang;
    }

    public void setDeskripsiBarang(String deskripsiBarang) {
        this.deskripsiBarang = deskripsiBarang;
    }

    public Long getStok() {
        return stok;
    }

    public void setStok(Long stok) {
        this.stok = stok;
    }

    public Integer getJumlahGaransi() {
        return jumlahGaransi;
    }

    public void setJumlahGaransi(Integer jumlahGaransi) {
        this.jumlahGaransi = jumlahGaransi;
    }

    public TipeModel getTipeModel() {
        return tipeModel;
    }

    public void setTipeModel(TipeModel tipeModel) {
        this.tipeModel = tipeModel;
    }

    public List<PembelianBarangModel> getListPembelianBarangModel() {
        return listPembelianBarangModel;
    }

    public void setListPembelianBarangModel(List<PembelianBarangModel> listPembelianBarangModel) {
        this.listPembelianBarangModel = listPembelianBarangModel;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBarang;


    @NotNull
    @Column(name = "kode_barang")
    private String kodeBarang;

    @NotNull
    @Column(name = "harga_barang")
    private Long hargaBarang;

    @NotNull
    @Size(max = 30)
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Size(max = 30)
    @Column(name = "merk", nullable = false)
    private String merk;

    @NotNull
    @Size(max = 120)
    @Column(name = "deskripsi_barang", nullable = false)
    private String deskripsiBarang;

    @NotNull
    @Size(max = 120)
    @Column(name = "stok", nullable = false)
    private Long stok;

    @NotNull
    @Column(nullable = false)
    private Integer jumlahGaransi;


    //  Relasi dengan TipeModel
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    private TipeModel tipeModel;

    //  Relasi dengan PembelianBarangModel
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<PembelianBarangModel> listPembelianBarangModel;
//    @JoinTable(
//            name = "cabang_menu",
//            joinColumns = @JoinColumn(name = "no_cabang"),
//            inverseJoinColumns = @JoinColumn(name = "no_menu"))
//    List<PembelianModel> listMenu;
}

