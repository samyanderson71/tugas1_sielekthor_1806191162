package apap.tugas.sielekthor.model;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
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
public class MemberModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 30)
    @Column(name = "nama_Member", nullable = false)
    private String namaMember;

    @NotNull
    @Size(max = 30)
    @Column(name = "jenis_Kelamin", nullable = false)
    private String jenisKelamin;


    @NotNull
    @Column(name="tanggal_Lahir")
    private Date tanggalLahir;

    @NotNull
    @Column(name="tanggal_Lahir")
    private Date tanggalPendaftaran;

}