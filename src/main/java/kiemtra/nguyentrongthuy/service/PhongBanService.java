package kiemtra.nguyentrongthuy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kiemtra.nguyentrongthuy.entity.PhongBan;
import kiemtra.nguyentrongthuy.repository.IPhongBanRepository;

@Service
public class PhongBanService {
    @Autowired
    private IPhongBanRepository phongBanRepository;

    public List<PhongBan> getAllPhongBans(){
        
        return phongBanRepository.findAll();
    }
}
