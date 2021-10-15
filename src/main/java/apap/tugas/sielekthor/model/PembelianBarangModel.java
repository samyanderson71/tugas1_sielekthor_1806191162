package apap.tugas.sielekthor.model;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pembelian_barang")
public class PembelianBarangModel implements Serializable{
    public PembelianBarangModel(Long idPembelianBarang, Date tanggalGaransiPembelianBarang, BarangModel barangModel, PembelianModel pembelianModel) {
        this.idPembelianBarang = idPembelianBarang;
        this.tanggalGaransiPembelianBarang = tanggalGaransiPembelianBarang;
        this.barangModel = barangModel;
        this.pembelianModel = pembelianModel;
    }

    public Long getIdPembelianBarang() {
        return idPembelianBarang;
    }

    public void setIdPembelianBarang(Long idPembelianBarang) {
        this.idPembelianBarang = idPembelianBarang;
    }

    public Date getTanggalGaransiPembelianBarang() {
        return tanggalGaransiPembelianBarang;
    }

    public void setTanggalGaransiPembelianBarang(Date tanggalGaransiPembelianBarang) {
        this.tanggalGaransiPembelianBarang = tanggalGaransiPembelianBarang;
    }

    public BarangModel getBarangModel() {
        return barangModel;
    }

    public void setBarangModel(BarangModel barangModel) {
        this.barangModel = barangModel;
    }

    public PembelianModel getPembelianModel() {
        return pembelianModel;
    }

    public void setPembelianModel(PembelianModel pembelianModel) {
        this.pembelianModel = pembelianModel;
    }

    public PembelianBarangModel() {
    }



    @Id
    @Column(name = "id_pembelian_barang")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPembelianBarang;

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "tanggal_garansi_pembelian_barang")
    private Date tanggalGaransiPembelianBarang;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    private BarangModel barangModel;

//    @ManyToOne
//    @JoinColumn(name = "barang_id")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    BarangModel barang;


    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    private PembelianModel pembelianModel;


}
