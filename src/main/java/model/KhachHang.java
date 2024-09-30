package model;

/**
 *
 * Họ tên sinh viên: dặng khánh duy
 * C23A.TH1
 */         

  public class KhachHang {
    private String maso;
    private String hoten;
    private int sonhankhau;
    private double chisocu;
    private double chisomoi;

    // Constructor
    public KhachHang(String maso, String hoten, int sonhankhau, double chisocu, double chisomoi) {
        this.maso = maso;
        this.hoten = hoten;
        this.sonhankhau = sonhankhau;
        this.chisocu = chisocu;
        this.chisomoi = chisomoi;
    }

    // Getter và Setter
    public String getMaso() {
        return maso;
    }

    public String getHoten() {
        return hoten;
    }

    public int getSonhankhau() {
        return sonhankhau;
    }

    public double getChisocu() {
        return chisocu;
    }

    public double getChisomoi() {
        return chisomoi;
    }

    // Tính số khối nước sử dụng
    public double getTieuThu() {
        return chisomoi - chisocu;
    }

    // Tính định mức theo số nhân khẩu
    public int getDinhMuc() {
        return sonhankhau * 4;
    }

    // Tính số tiền phải trả
    public double tinhTienTra() {
        double tieuThu = getTieuThu();
        int dinhMuc = getDinhMuc();
        double giaBan = 0;

        if (tieuThu <= dinhMuc) {
            giaBan = tieuThu * 6700;
        } else if (tieuThu <= dinhMuc + 2) {
            giaBan = dinhMuc * 6700 + (tieuThu - dinhMuc) * 12900;
        } else {
            giaBan = dinhMuc * 6700 + 2 * 12900 + (tieuThu - dinhMuc - 2) * 14400;
        }

        double thueGTGT = giaBan * 0.05;
        double tdvtn = giaBan * 0.25;
        double thueTDVTN = tdvtn * 0.08;
        return giaBan + thueGTGT + tdvtn + thueTDVTN;
    }
}