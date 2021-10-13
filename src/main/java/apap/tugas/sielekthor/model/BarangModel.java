package apap.tugas.sielekthor.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class BarangModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kodeBarang;

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
    @Size(max = 30)
    @Column(name = "alamat_cabang", nullable = false)
    private String alamatCabang;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private Integer jumlahGaransi;


    //  Relasi dengan TipeModel
    @ManyToOne(mappedBy = "barang", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PegawaiModel> listPegawai;

    //  Relasi dengan PembelianModel
    @ManyToMany
    @JoinTable(
            name = "cabang_menu",
            joinColumns = @JoinColumn(name = "no_cabang"),
            inverseJoinColumns = @JoinColumn(name = "no_menu"))
    List<PembelianModel> listMenu;
}
}
