package kiemtra.nguyentrongthuy.entity;

import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "phongban")
public class PhongBan {
    @Id
    @Column(name = "mapb", length = 50, nullable = false, unique = true)
    @NotEmpty(message = "Mã phòng ban không được để trống!")
    @Size(max = 50, message = "Mã phòng ban không được vượt quá 50 ký tự.")
    private String mapb;

    @Column(name = "hoten", length = 50, nullable = false, unique = true)
    @NotEmpty(message = "Họ tên không được để trống")
    @Size(max = 50, message = "Tên không được vượt quá 50 ký tự.")
    private String hoten;

    @Fetch(FetchMode.JOIN)
    @OneToMany(mappedBy = "phongban", cascade = CascadeType.ALL)
    private List<NhanVien> books;

    public String getMapb() {
        return mapb;
    }

    public void setMapb(String mapb) {
        this.mapb = mapb;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public List<NhanVien> getBooks() {
        return books;
    }

    public void setBooks(List<NhanVien> books) {
        this.books = books;
    }

    public PhongBan() {
    }
    
}
