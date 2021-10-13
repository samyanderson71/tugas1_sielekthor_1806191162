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
public class TipeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 30)
    @Column(name = "nama_tipe", nullable = false)
    private String namaTipe;


    @NotNull
    @Size(max = 120)
    @Column(name = "deskripsi_tipe", nullable = false)
    private String deskripsiTipe;

        //  Relasi dengan TipeModel
    @OneToMany(mappedBy = "tipe", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TipeModel> listTipe;

//    //  Relasi dengan MenuModel
//    @ManyToMany
//    @JoinTable(
//            name = "cabang_menu",
//            joinColumns = @JoinColumn(name = "no_cabang"),
//            inverseJoinColumns = @JoinColumn(name = "no_menu"))
//    List<PembelianModel> listMenu;
//}

}