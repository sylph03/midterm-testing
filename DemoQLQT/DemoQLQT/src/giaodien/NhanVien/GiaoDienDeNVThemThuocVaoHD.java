package giaodien.NhanVien;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.DanhSachDuLieu;
import entity.CTHoaDonBan;
import entity.ThongTinThuoc;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class GiaoDienDeNVThemThuocVaoHD extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tablemodel;
	private JScrollPane jscr;
	private JTextField textField;
	private JTextField textField_1;
	DanhSachDuLieu ds = new DanhSachDuLieu();
	GiaoDienLapHoaDon lhd ;

	public GiaoDienDeNVThemThuocVaoHD() {
		setTitle("Thêm thuốc");
		setBounds(500, 100, 490, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		
		String[] header="Tên thuốc;Số lượng;Đơn vị tính;Đơn giá".split(";");
		tablemodel = new DefaultTableModel(header,0);
		contentPane.add(jscr = new JScrollPane (table= new JTable(tablemodel)));
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblTen = new JLabel("Tên: ");
		lblTen.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTen.setBounds(20, 15, 37, 14);
		contentPane.add(lblTen);
		
		textField = new JTextField();
		textField.setBounds(57, 12, 130, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnTim = new JButton("");
		btnTim.setIcon(new ImageIcon(GiaoDienDeNVThemThuocVaoHD.class.getResource("/ser/search.png")));
		btnTim.setBounds(189, 12, 20, 20);
		contentPane.add(btnTim);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnThem.setIcon(new ImageIcon(GiaoDienDeNVThemThuocVaoHD.class.getResource("/ser/add.png")));
		btnThem.setBounds(387, 101, 79, 23);
		contentPane.add(btnThem);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(254, 12, 129, 20);
		contentPane.add(comboBox);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(GiaoDienDeNVThemThuocVaoHD.class.getResource("/ser/search.png")));
		button.setBounds(387, 12, 20, 20);
		contentPane.add(button);
		
		JLabel lblLoai = new JLabel("Loại:");
		lblLoai.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLoai.setBounds(220, 15, 37, 14);
		contentPane.add(lblLoai);
		
		JLabel lblSoLuong = new JLabel("Nhập số lượng:");
		lblSoLuong.setBounds(390, 52, 89, 14);
		contentPane.add(lblSoLuong);
		
		textField_1 = new JTextField();
		textField_1.setBounds(387, 70, 77, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnThoat = new JButton("Hủy");
		btnThoat.setIcon(new ImageIcon(GiaoDienDeNVThemThuocVaoHD.class.getResource("/ser/cancel.png")));
		btnThoat.setBounds(387, 131, 79, 23);
		btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		contentPane.add(btnThoat);
		jscr.setBounds(0, 45, 383, 186);
		
		try {
			ds.docThuoc();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(ThongTinThuoc thuoc : ds.listThuoc)
		{
			Object[] row ={thuoc.getTenThuoc(),thuoc.getSoLuong(),thuoc.getDonViTinh(),thuoc.getGiaBan()};
			tablemodel.addRow(row);
		}
	}
}
