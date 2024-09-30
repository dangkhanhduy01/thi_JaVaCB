package gui;

import javax.swing.JFrame;

/**
 *
 * Họ tên sinh viên: đặng khánh duy
 * C23A.TH1
 */
public class Program {
    public static void main(String[] args) {
        FrmQLKhachHang frame = new FrmQLKhachHang("Quản lý khách hàng tiêu thụ nước");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}