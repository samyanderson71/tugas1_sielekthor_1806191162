package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.model.PembelianModel;
import apap.tugas.sielekthor.repository.PembelianDb;
import apap.tugas.sielekthor.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
@Transactional
public class PembelianServiceImpl implements PembelianService{

        @Autowired
        PembelianDb pembelianDb;

        @Override
        public void addPembelian(PembelianModel pembelianModel) {
            String nomorInvoice = checkNomorInvoice(pembelianModel);

            pembelianModel.setNomorInvoice(nomorInvoice);
            pembelianDb.save(pembelianModel);
        }

        @Override
        public String checkNomorInvoice(PembelianModel pembelianModel) {
            String firstChara= "1" ;
            try {
                firstChara = pembelianModel.getMemberModel().getNamaMember().toLowerCase().substring(0,1);
            }
            catch (NoSuchElementException e){
                firstChara = pembelianModel.getMemberModel().getNamaMember().toLowerCase().substring(0);
            }
            ;
            String first = Integer.toString((Integer.valueOf(firstChara)- 96) % 10);


            String second = pembelianModel.getNamaAdmin().substring(-1).toUpperCase();
//            String third = pembelianModel.getNamaPilot().toUpperCase();

//            third = third.substring(third.length() - 2, third.length());
            LocalDate tanggalPembelian = pembelianModel.getTanggalPembelian().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int month = tanggalPembelian.getMonthValue();
            int date = tanggalPembelian.getDayOfMonth();
            int year = tanggalPembelian.getYear();
            int tanggalBulanPembelian = (month+date)*5;

            String third = Integer.toString(date) + Integer.toString(month);
            String fourth = "00";
            if(pembelianModel.getIsCash()){
                fourth = "01";
            }else{
                fourth = "02";
            }


            String fifth = (Integer.toString(tanggalBulanPembelian));
            if(fifth.length()<3){
                fifth = "0"+fifth;
            }
            String sixth = randomString().toUpperCase();

            try{
                while(true) {
                    getPembelianByNomorInvoice(first + second + third + fourth + fifth + sixth);
                    sixth = randomString();
                }
            } catch(NoSuchElementException e) {
                return first + second + third + fourth + fifth + sixth;
            }
        }

        @Override
        public String randomString() {
            int leftLimit = 97;
            int rightLimit = 122;
            int targetStringLength = 2;
            Random random = new Random();

            String generatedString = random.ints(leftLimit, rightLimit + 1)
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();

            String result = generatedString.toUpperCase();
            return result;
        }

    @Override
        public List<PembelianModel> getAllPembelian() { return pembelianDb.findAll(Sort.by(Sort.Direction.ASC, "namaPembelian")); }

    @Override
    public PembelianModel getByIdPembelian(Long idPembelian) {
        return pembelianDb.findByIdPembelian(idPembelian).get();
    }

    @Override
        public PembelianModel getPembelianByNomorInvoice(String nomorInvoice){
            return pembelianDb.findByNomorInvoice(nomorInvoice).get();
        }

//        @Override
//        public PembelianModel updatePembelian(PembelianModel pembelianModel){
//            String nomorInvoice = checkNomorInvoice(pembelianModel);
//
//            pembelianModel.setNomorInvoice(nomorInvoice);
//            pembelianDb.save(pembelianModel);
//            return pembelianModel;
//        }

        @Override
        public PembelianModel deletePembelian(PembelianModel pembelianModel) {
            pembelianDb.delete(pembelianModel);

            return pembelianModel;
        }

        @Override
        public List<Boolean> getPembelianMemberModelAndIsCash(MemberModel memberModel, Boolean isCash) {
            return pembelianDb.findByMemberModelAndIsCash(memberModel, isCash);
        }

        @Override
        public List<Boolean> getPembelianMemberModel(MemberModel memberModel) {
            return pembelianDb.findByMemberModel(memberModel);
        }

        public List<Boolean> getPembelianIsCash(Boolean isCash) {
            return pembelianDb.findByIsCash(isCash);
        }

    @Override
    public List<PembelianModel> getTotalPembelianMember() {
        return null; //masih sementara
    }


//        @Override
//        public List<PembelianModel> getTotalPembelianMember(){
//            Calendar cal = Calendar.getInstance();
//            cal.add(Calendar.MONTH, -1);
//            Date tanggal = cal.getTime();
//            return pembelianDb.findByThisMonth(tanggal);
//        }


}
