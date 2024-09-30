package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import util.FileHelper;

/**
 *
 * Họ tên sinh viên: đặng khánh duy
 * C23A.TH1
 */
public class QLKhachHang {
    private ArrayList<KhachHang> dsKhachHang;

    public QLKhachHang() {
        dsKhachHang = new ArrayList<>();
    }

    public ArrayList<KhachHang> getDsKhachHang() {
        return dsKhachHang;
    }

    // Đọc danh sách khách hàng từ file
    public void docKhachHang(String filename) {
        ArrayList<String> data = FileHelper.readFileText(filename);
        for (String line : data) {
            String[] parts = line.split(";");
            String maso = parts[0];
            String hoten = parts[1];
            int sonhankhau = Integer.parseInt(parts[2]);
            double chisocu = Double.parseDouble(parts[3]);
            double chisomoi = Double.parseDouble(parts[4]);
            dsKhachHang.add(new KhachHang(maso, hoten, sonhankhau, chisocu, chisomoi));
        }
    }

    // Tìm số khối nước tiêu thụ thấp nhất
    public double getTieuThuThapNhat() {
        return dsKhachHang.stream().mapToDouble(KhachHang::getTieuThu).min().orElse(0);
    }

    // Tìm số khối nước tiêu thụ trung bình
    public double getTieuThuTrungBinh() {
        return dsKhachHang.stream().mapToDouble(KhachHang::getTieuThu).average().orElse(0);
    }

    // Sắp xếp danh sách khách hàng theo mức tiêu thụ tăng dần
    public void sapXepTheoTieuThu() {
        Collections.sort(dsKhachHang, Comparator.comparingDouble(KhachHang::getTieuThu));
    }

    // Ghi danh sách hóa đơn ra file
    public boolean ghiHoaDon(String filename) {
        ArrayList<String> data = new ArrayList<>();
        for (KhachHang kh : dsKhachHang) {
            String line = kh.getMaso() + ";" + kh.getHoten() + ";" + kh.getTieuThu() + ";" + kh.tinhTienTra();
            data.add(line);
        }
        return FileHelper.writeFileText(filename, data);
    }
}