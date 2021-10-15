package apap.tugas.sielekthor.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

    @Entity
    @Table(name = "pembelian")
    public class PembelianModel implements Serializable {
        @Id
        @Column(name = "id_pembelian")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idPembelian;

        @NotNull
        @Column(name = "nama_admin")
        private String namaAdmin;

        @NotNull
        @Size(min=13, max = 13)
        @Column(name = "nomor_invoice", unique=true)
        private String nomorInvoice;

        @NotNull
        @Column(name = "total")
        private Long total;

        @NotNull
        @Temporal(TemporalType.DATE)
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @Column(name = "tanggal_pembelian")
        private Date tanggalPembelian;

        @NotNull
        @Column(name = "isCash")
        private Boolean isCash;


        @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
        private PembelianBarangModel pembelianBarangModel;

        @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
        private MemberModel memberModel;

        public PembelianModel() {
        }

        public Long getIdPembelian() {
            return idPembelian;
        }

        public void setIdPembelian(Long idPembelian) {
            this.idPembelian = idPembelian;
        }

        public String getNamaAdmin() {
            return namaAdmin;
        }

        public void setNamaAdmin(String namaAdmin) {
            this.namaAdmin = namaAdmin;
        }

        public String getNomorInvoice() {
            return nomorInvoice;
        }

        public void setNomorInvoice(String nomorInvoice) {
            this.nomorInvoice = nomorInvoice;
        }

        public Long getTotal() {
            return total;
        }

        public void setTotal(Long total) {
            this.total = total;
        }

        public Date getTanggalPembelian() {
            return tanggalPembelian;
        }

        public void setTanggalPembelian(Date tanggalPembelian) {
            this.tanggalPembelian = tanggalPembelian;
        }

        public Boolean getIsCash() {
            return isCash;
        }

        public void setIsCash(Boolean isCash) {
            this.isCash = isCash;
        }


        public PembelianBarangModel getPembelianBarangModel() {
            return pembelianBarangModel;
        }

        public void setPembelianBarangModel(PembelianBarangModel pembelianBarangModel) {
            this.pembelianBarangModel = pembelianBarangModel;
        }

        public MemberModel getMemberModel() {
            return this.memberModel;
        }

        public void setMemberModel(MemberModel memberModel) {
            this.memberModel = memberModel;
        }



    }

