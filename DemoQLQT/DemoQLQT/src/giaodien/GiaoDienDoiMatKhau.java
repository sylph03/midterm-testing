package giaodien;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ControlGiaoDien;
import control.DanhSachDuLieu;
import entity.NhanVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class GiaoDienDoiMatKhau extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtMKCu;
	private JPasswordField txtMKMoi;
	private JPasswordField txtXacNhan;
	private JButton btnLuuMK; 
	private JButton btnHuy;
	GiaoDienDangNhap dn;
	ControlGiaoDien control = new ControlGiaoDien();
	DanhSachDuLieu ds = new DanhSachDuLieu();

	public GiaoDienDoiMatKhau() {
		setResizable(false);
		setTitle("Đổi Mật Khẩu");
		setBounds(600, 400, 296, 149);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMKCu = new JLabel("Mật khẩu cũ:");
		lblMKCu.setBounds(10, 14, 104, 14);
		contentPane.add(lblMKCu);
		
		txtMKCu = new JPasswordField();
		txtMKCu.setBounds(114, 8, 156, 20);
		contentPane.add(txtMKCu);
		txtMKCu.setColumns(10);
		
		JLabel lblMKMoi = new JLabel("Mật khẩu mới:");
		lblMKMoi.setBounds(10, 39, 104, 14);
		contentPane.add(lblMKMoi);
		
		txtMKMoi = new JPasswordField();
		txtMKMoi.setBounds(114, 33, 156, 20);
		contentPane.add(txtMKMoi);
		txtMKMoi.setColumns(10);
		
		JLabel lblMKMoi2 = new JLabel("Nhập lại mật khẩu:");
		lblMKMoi2.setBounds(10, 64, 104, 14);
		contentPane.add(lblMKMoi2);
		
		txtXacNhan = new JPasswordField();
		txtXacNhan.setBounds(114, 58, 156, 20);
		contentPane.add(txtXacNhan);
		txtXacNhan.setColumns(10);
		
		btnLuuMK = new JButton("Lưu");
		btnLuuMK.setIcon(new ImageIcon(GiaoDienDoiMatKhau.class.getResource("/ser/save.png")));
		btnLuuMK.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				int selection =JOptionPane.showConfirmDialog(contentPane, "Bạn chắc chắn sửa ?","Sửa dữ liệu",JOptionPane.YES_NO_OPTION);
				if(selection==JOptionPane.YES_OPTION)
				{
					char[] moi = txtMKMoi.getPassword();
					String passmoi=new String(moi);
					String ma = dn.txtTK.getText()+"";
					try {
						ds.docNV();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					NhanVien nv = ds.timNVTheoMa(ma);
					String mkCu = nv.getPass();
					if((txtMKCu.getText()+"").equalsIgnoreCase(mkCu))
					{
						if(txtMKMoi.getText().equalsIgnoreCase(txtXacNhan.getText()))
						{
							try {
								control.doiPass(passmoi, ma);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							JOptionPane.showMessageDialog(contentPane, "Đổi mật khẩu thành công!");
							setVisible(false);
						}
						else
						{
							JOptionPane.showMessageDialog(contentPane, "Mật khẩu mới và Nhập lại phải giống nhau!","Inane warning",JOptionPane.WARNING_MESSAGE);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(contentPane, "Mật khẩu cũ không đúng!","Inane warning",JOptionPane.WARNING_MESSAGE);
					}
					
				}
			}
		});
		btnLuuMK.setBounds(73, 86, 77, 23);
		contentPane.add(btnLuuMK);
		
		btnHuy = new JButton("Hủy");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnHuy.setIcon(new ImageIcon(GiaoDienDoiMatKhau.class.getResource("/ser/cancel.png")));
		btnHuy.setBounds(160, 86, 77, 23);
		contentPane.add(btnHuy);
	}
}
