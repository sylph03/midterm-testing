package giaodien.NhanVien;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import control.DanhSachDuLieu;
import entity.KhachHang;
import entity.ThongTinThuoc;
import giaodien.GiaoDienDangNhap;
import giaodien.GiaoDienThongTinNhanVien;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class GiaoDienLapHoaDon extends JFrame {

	private JFrame frmLapHoaDon;
	public JTextField txtMa;
	public JTextField txtNgay;
	public JTextField txtCMND;
	public JTextField txtTen;
	public JTextField txtSDT;
	public JTextField txtTenThuoc;
	public JTextField txtSoLuong;
	private JTable table;
	public DefaultTableModel tablemode;
	private JScrollPane scrollPane_1;
	private JTextField txtTongTien;
	private JTextField txtNguoiLap;
	private JTextArea txtaMota;
	private JComboBox cbbNgay,cbbThang,cbbNam;
	
	GiaoDienDangNhap dn;
	DanhSachDuLieu ds = new DanhSachDuLieu();
	private JTextField txtLoai;
	public GiaoDienLapHoaDon() {
		setResizable(false);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Lập hóa đơn");
		setBounds(500, 100, 490, 600);
		getContentPane().setLayout(null);
		
		JLabel lblTieuDe = new JLabel("THÔNG TIN HÓA ĐƠN");
		lblTieuDe.setForeground(new Color(75, 0, 130));
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblTieuDe.setBounds(130, 11, 258, 34);
		getContentPane().add(lblTieuDe);
		
		JCheckBox chkKeDon = new JCheckBox("Có kê đơn");
		chkKeDon.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkKeDon.setBounds(22, 103, 94, 23);
		getContentPane().add(chkKeDon);
		
		JLabel lblMa = new JLabel("Mã:");
		lblMa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMa.setBounds(22, 79, 33, 17);
		getContentPane().add(lblMa);
		
		JLabel lblNgayLap = new JLabel("Ngày:");
		lblNgayLap.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNgayLap.setBounds(127, 78, 41, 17);
		getContentPane().add(lblNgayLap);
		
		JLabel lblNguoiLap = new JLabel("Người lập:");
		lblNguoiLap.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNguoiLap.setBounds(302, 79, 65, 17);
		getContentPane().add(lblNguoiLap);
		
		txtNguoiLap = new JTextField();
		txtNguoiLap.setEnabled(false);
		txtNguoiLap.setEditable(false);
		txtNguoiLap.setBounds(366, 77, 55, 20);
		getContentPane().add(txtNguoiLap);
		txtNguoiLap.setColumns(10);
		txtNguoiLap.setText(dn.txtTK.getText());
		
		txtMa = new JTextField();
		txtMa.setEnabled(false);
		txtMa.setEditable(false);
		txtMa.setBounds(45, 77, 72, 20);
		getContentPane().add(txtMa);
		txtMa.setColumns(10);
		
		txtNgay = new JTextField();
		txtNgay.setEnabled(false);
		txtNgay.setEditable(false);
		txtNgay.setColumns(10);
		txtNgay.setBounds(162, 76, 107, 20);
		getContentPane().add(txtNgay);
		
		JPanel pnlKhachHang = new JPanel();
		pnlKhachHang.setForeground(Color.RED);
		pnlKhachHang.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin kh\u00E1ch h\u00E0ng:", TitledBorder.TRAILING, TitledBorder.TOP, null, new Color(0, 128, 0)));
		pnlKhachHang.setBounds(10, 107, 453, 133);
		getContentPane().add(pnlKhachHang);
		pnlKhachHang.setLayout(null);
		
		JLabel lblCMND = new JLabel("CMND: ");
		lblCMND.setBounds(10, 26, 67, 14);
		pnlKhachHang.add(lblCMND);
		
		JLabel lblTen = new JLabel("Tên KH:");
		lblTen.setBounds(10, 51, 67, 14);
		pnlKhachHang.add(lblTen);
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh:");
		lblNgaySinh.setBounds(10, 76, 67, 14);
		pnlKhachHang.add(lblNgaySinh);
		
		JLabel lblSdt = new JLabel("SDT:");
		lblSdt.setBounds(10, 101, 67, 14);
		pnlKhachHang.add(lblSdt);
		
		txtCMND = new JTextField();
		txtCMND.setBounds(87, 26, 134, 20);
		pnlKhachHang.add(txtCMND);
		txtCMND.setColumns(10);
		
		txtTen = new JTextField();
		txtTen.setBounds(87, 51, 167, 20);
		pnlKhachHang.add(txtTen);
		txtTen.setColumns(10);
		
		txtSDT = new JTextField();
		txtSDT.setBounds(87, 101, 167, 20);
		pnlKhachHang.add(txtSDT);
		txtSDT.setColumns(10);
		
		JButton btnKiemtra = new JButton("");
		btnKiemtra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmnd;
				cmnd = txtCMND.getText()+"";
				try {
					ds.docBangKhachHang();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(KhachHang kh : ds.listKhachHang)
				{
					if(kh.getCMND().equalsIgnoreCase(cmnd))
					{
						String[] date=kh.getNgaySinh().split("-");
						txtTen.setText(kh.getHoTenKH()+"");
						txtSDT.setText(kh.getSdt()+"");
						txtaMota.setText(kh.getMoTaKH()+"");
						cbbThang.setSelectedItem(date[1]);
						cbbNgay.setSelectedItem(date[2]);
						cbbNam.setSelectedItem(date[0]);
						
					}
				}
			}
		});
		btnKiemtra.setIcon(new ImageIcon(GiaoDienLapHoaDon.class.getResource("/ser/search.png")));
		btnKiemtra.setBounds(231, 26, 23, 21);
		pnlKhachHang.add(btnKiemtra);
		
		txtaMota = new JTextArea();
		txtaMota.setBounds(264, 46, 179, 75);
		pnlKhachHang.add(txtaMota);
		
		JLabel lblMota = new JLabel("Mô tả:");
		lblMota.setBounds(264, 26, 46, 14);
		pnlKhachHang.add(lblMota);
		
		String[] ngay={"01", "02", "03", "04", "05", "06", "07", "08", "09",
			"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23",
			"24", "25", "26", "27", "28", "29", "30", "31"};
		cbbNgay = new JComboBox(ngay);
		cbbNgay.setBounds(87, 76, 46, 20);
		pnlKhachHang.add(cbbNgay);
		
		String[] thang ={"01", "02", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
		cbbThang = new JComboBox(thang);
		cbbThang.setBounds(143, 76, 46, 20);
		pnlKhachHang.add(cbbThang);
		
		cbbNam = new JComboBox();
		cbbNam.setModel(new DefaultComboBoxModel(new String[] {"1990", "1991", "1992", "1993", "1994",
				"1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004"}));
		cbbNam.setBounds(199, 76, 55, 20);
		pnlKhachHang.add(cbbNam);
		lblCMND.setEnabled(false);
		lblNgaySinh.setEnabled(false);
		lblSdt.setEnabled(false);
		lblTen.setEnabled(false);
		lblMota.setEnabled(false);
		cbbNgay.setEnabled(false);
		cbbNgay.setEditable(false);
		cbbThang.setEnabled(false);
		cbbThang.setEditable(false);
		cbbNam.setEnabled(false);
		cbbNam.setEditable(false);
		txtCMND.setEditable(false);
		txtSDT.setEditable(false);
		txtTen.setEditable(false);
		txtaMota.setEditable(false);
		txtaMota.setBackground(Color.decode("#ffffff"));
		btnKiemtra.setEnabled(false);
		

		
		chkKeDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chkKeDon.isSelected())
				{
					pnlKhachHang.setEnabled(true);
					lblCMND.setEnabled(true);
					lblNgaySinh.setEnabled(true);
					lblSdt.setEnabled(true);
					lblTen.setEnabled(true);
					lblMota.setEnabled(true);
					txtCMND.setEditable(true);
					cbbNgay.setEnabled(true);
					cbbNgay.setEditable(true);
					cbbThang.setEnabled(true);
					cbbThang.setEditable(true);
					cbbNam.setEnabled(true);
					cbbNam.setEditable(true);
					txtSDT.setEditable(true);
					txtTen.setEditable(true);
					txtaMota.setEditable(true);
					txtaMota.setBackground(Color.decode("#ffffff"));
					btnKiemtra.setEnabled(true);
				}
				else {
					pnlKhachHang.setEnabled(false);
					lblCMND.setEnabled(false);
					lblNgaySinh.setEnabled(false);
					lblSdt.setEnabled(false);
					lblTen.setEnabled(false);
					lblMota.setEnabled(false);
					txtCMND.setEditable(false);
					cbbNgay.setEnabled(false);
					cbbNgay.setEditable(false);
					cbbThang.setEnabled(false);
					cbbThang.setEditable(false);
					cbbNam.setEnabled(false);
					cbbNam.setEditable(false);
					txtSDT.setEditable(false);
					txtTen.setEditable(false);
					txtaMota.setEditable(false);
					txtaMota.setBackground(Color.decode("#ffffff"));
					btnKiemtra.setEnabled(false);
				}
			}
		});
		
		JLabel lblThuoc = new JLabel("Tên thuốc:");
		lblThuoc.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblThuoc.setBounds(20, 251, 65, 22);
		getContentPane().add(lblThuoc);
		
		JLabel lblSl = new JLabel("Số lượng:");
		lblSl.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSl.setBounds(233, 251, 55, 22);
		getContentPane().add(lblSl);
		
		txtTenThuoc = new JTextField();
		txtTenThuoc.setBounds(81, 251, 117, 21);
		getContentPane().add(txtTenThuoc);
		txtTenThuoc.setColumns(10);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(289, 251, 33, 20);
		getContentPane().add(txtSoLuong);
		txtSoLuong.setColumns(10);
		
		JButton btnThem = new JButton("");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThem.setToolTipText("Thêm");
		btnThem.setIcon(new ImageIcon(GiaoDienLapHoaDon.class.getResource("/ser/add.png")));
		btnThem.setBounds(393, 251, 26, 23);
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String ten = txtTenThuoc.getText()+"";
				int soLuong = Integer.parseInt(txtSoLuong.getText());
				try {
					ds.docThuoc();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(ThongTinThuoc thuoc : ds.listThuoc)
				{
					if(ten.equals(thuoc.getTenThuoc()+""))
					{
						Object[] row = {ten,soLuong,thuoc.getDonViTinh(),thuoc.getGiaBan()};
						tablemode.addRow(row);
					}
				}
			}
		});
		getContentPane().add(btnThem);
		
		JButton btnXoa = new JButton("");
		btnXoa.setToolTipText("Xóa");
		btnXoa.setIcon(new ImageIcon(GiaoDienLapHoaDon.class.getResource("/ser/delete.png")));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnXoa.setBounds(426, 251, 26, 22);
		getContentPane().add(btnXoa);
		
		String [] header="Tên thuốc;Số lượng;Đơn vị tính;Giá".split(";");
		JScrollPane scrollPane = new JScrollPane();
		tablemode =new DefaultTableModel(header, 0);
		getContentPane().add(scrollPane_1 = new JScrollPane(table =new JTable(tablemode)));
		
		JLabel lblTongTien = new JLabel("Tổng tiền:");
		lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTongTien.setBounds(243, 490, 72, 20);
		getContentPane().add(lblTongTien);
		
		txtTongTien = new JTextField();
		txtTongTien.setEditable(false);
		txtTongTien.setEnabled(false);
		txtTongTien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTongTien.setBounds(326, 490, 137, 22);
		txtTongTien.setBorder(null);
		getContentPane().add(txtTongTien);
		txtTongTien.setColumns(10);
		
		JButton btnXoq = new JButton("Xong");
		btnXoq.setHorizontalAlignment(SwingConstants.LEFT);
		btnXoq.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoq.setIcon(new ImageIcon(GiaoDienLapHoaDon.class.getResource("/ser/done.png")));
		btnXoq.setBounds(188, 523, 117, 34);
		getContentPane().add(btnXoq);
		
		JButton btnMore = new JButton("");
		btnMore.setToolTipText("Chi tiết");
		btnMore.setIcon(new ImageIcon(GiaoDienLapHoaDon.class.getResource("/ser/more_01.png")));
		btnMore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GiaoDienDeNVThemThuocVaoHD().setVisible(true);
			}
		});
		btnMore.setBounds(197, 250, 26, 23);
		getContentPane().add(btnMore);
		
		
		txtLoai = new JTextField();
		txtLoai.setEditable(false);
		txtLoai.setEnabled(false);
		txtLoai.setBounds(326, 251, 33, 20);
		getContentPane().add(txtLoai);
		txtLoai.setColumns(10);
		
		JButton btnNV = new JButton("");
		btnNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new GiaoDienThongTinNhanVien().setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNV.setIcon(new ImageIcon(GiaoDienLapHoaDon.class.getResource("/ser/user.png")));
		btnNV.setBounds(425, 72, 33, 29);
		getContentPane().add(btnNV);
		scrollPane_1.setSize(453, 190);
		scrollPane_1.setLocation(10, 294);
		
		txtMa.setText("HD"+ds.demSoHDBan());
		layNgayHeThong();
	}
	public void layNgayHeThong()
	{
		Date today=new Date(System.currentTimeMillis());
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm dd/MM/yyyy");
		//SimpleDateFormat timeFormat= new SimpleDateFormat(“hh:mm:ss dd/MM/yyyy”);
		String s=timeFormat.format(today.getTime());
		txtNgay.setText(s);
	}
	
}
