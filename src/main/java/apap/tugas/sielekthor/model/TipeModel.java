package apap.tugas.sielekthor.model;

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
@Table(name = "tipe")
public class TipeModel {
    public Long getIdTipe() {
        return idTipe;
    }

    public void setIdTipe(Long idTipe) {
        this.idTipe = idTipe;
    }

    public String getNamaTipe() {
        return namaTipe;
    }

    public void setNamaTipe(String namaTipe) {
        this.namaTipe = namaTipe;
    }

    public String getDeskripsiTipe() {
        return deskripsiTipe;
    }

    public void setDeskripsiTipe(String deskripsiTipe) {
        this.deskripsiTipe = deskripsiTipe;
    }

    public List<BarangModel> getListBarang() {
        return listBarangModel;
    }

    public void setListTipe(List<BarangModel> listBarangModel) {
        this.listBarangModel = listBarangModel;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipe;

    @NotNull
    @Size(max = 30)
    @Column(name = "nama_tipe", nullable = false)
    private String namaTipe;


    @NotNull
    @Size(max = 120)
    @Column(name = "deskripsi_tipe", nullable = false)
    private String deskripsiTipe;

        //  Relasi dengan TipeModel
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BarangModel>listBarangModel;

//    //  Relasi dengan MenuModel
//    @ManyToMany
//    @JoinTable(
//            name = "cabang_menu",
//            joinColumns = @JoinColumn(name = "no_cabang"),
//            inverseJoinColumns = @JoinColumn(name = "no_menu"))
//    List<PembelianModel> listMenu;
//}

}