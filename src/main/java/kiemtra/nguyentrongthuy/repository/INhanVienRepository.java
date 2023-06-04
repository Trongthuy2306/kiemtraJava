package kiemtra.nguyentrongthuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kiemtra.nguyentrongthuy.entity.NhanVien;


@Repository
public interface INhanVienRepository extends JpaRepository<NhanVien, String> {
}