package kiemtra.nguyentrongthuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kiemtra.nguyentrongthuy.entity.PhongBan;
@Repository
public interface IPhongBanRepository extends JpaRepository<PhongBan, String> {
}
