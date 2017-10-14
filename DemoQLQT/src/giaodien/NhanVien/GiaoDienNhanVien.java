package giaodien.NhanVien;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.ControlGiaoDien;
import control.DanhSachDuLieu;
import entity.CTHoaDonBan;
import entity.HoaDonBanHang;
import entity.ThongTinThuoc;
import giaodien.GiaoDienDangNhap;
import giaodien.GiaoDienThongTinNhanVien;
import giaodien.QuanLy.GiaoDienQuanLy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.security.AllPermission;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.ScrollPane;
import java.awt.Panel;
import javax.swing.ScrollPaneConstants;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.Label;
import javax.swing.JLayeredPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToggleButton;

public class GiaoDienNhanVien extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPaneDanhSachThuoc,scrollPaneDanhSachDon,scrollPaneCTHD,scrollPaneDoanhThu;
	private DefaultTableModel tablemodelThuoc,tablemodelDoanhThu,tablemodelCTHD,tablemodelDanhSachDon;
	JTable tableDanhSachThuoc,tableDanhSachDon,tableCTHD,tableDoanhThu ;
	ControlGiaoDien control = new ControlGiaoDien();
	DanhSachDuLieu ds = new DanhSachDuLieu();
	GiaoDienDangNhap dn;
	public String IDNhanVien=dn.txtTK.getText();
	private JTextField txtMaHD;
	private JTextField txtNgayLap;
	private JTextField txtNguoiLap_timkiem;
	private JTextField txtTongTien_timkiem;
	private JTextField txtTongDoanhThu;
	private JPanel panelCTHD,panelDSHD,panelDSThuoc,panelDoanhThu;
	private JComboBox cbbNgay,cbbThang,cbbNam,comboBoxNgay_DoanhThu,comboBoxThang_DoanhThu,comboBoxNam_DoanhThu;
	private JRadioButtonMenuItem chude1,chude2,chude3,chude4,chude5,chude6,chude7,chude8,chude9,chude10;
	public JToggleButton btnNhanVien;
	GiaoDienThongTinNhanVien thongtinnv = new GiaoDienThongTinNhanVien();
	GiaoDienLapHoaDon laphoadon =new GiaoDienLapHoaDon();


	public GiaoDienNhanVien() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GiaoDienNhanVien.class.getResource("/ser/pill.png")));
		setTitle("Nhân Viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 794, 21);
		contentPane.add(menuBar);

		JMenu mnNewMenu = new JMenu("Hệ thống");
		menuBar.add(mnNewMenu);

		JMenuItem mntmngXut = new JMenuItem("Đăng xuất");
		mntmngXut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					new GiaoDienDangNhap().setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		JMenu menu = new JMenu("Đổi giao diện");
		mnNewMenu.add(menu);

		chude1 = new JRadioButtonMenuItem("McWin",true);
		chude1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doiGiaoDien("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			}
		});
		menu.add(chude1);

		chude2 = new JRadioButtonMenuItem("Luna");
		chude2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doiGiaoDien("com.jtattoo.plaf.luna.LunaLookAndFeel");
			}
		});
		menu.add(chude2);

		chude3 = new JRadioButtonMenuItem("Areo");
		chude3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doiGiaoDien("com.jtattoo.plaf.aero.AeroLookAndFeel");
			}
		});
		menu.add(chude3);

		chude4 = new JRadioButtonMenuItem("Texture");
		chude4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doiGiaoDien("com.jtattoo.plaf.texture.TextureLookAndFeel");
			}
		});
		menu.add(chude4);

		chude5 = new JRadioButtonMenuItem("aluminium");
		chude5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doiGiaoDien("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
			}
		});
		menu.add(chude5);

		chude6 = new JRadioButtonMenuItem("NimBus");
		chude6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doiGiaoDien("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
			}
		});
		menu.add(chude6);

		chude7 = new JRadioButtonMenuItem("Bernstein");
		chude7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doiGiaoDien("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
			}
		});
		menu.add(chude7);

		chude8 = new JRadioButtonMenuItem("Fast");
		chude8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doiGiaoDien("com.jtattoo.plaf.fast.FastLookAndFeel");
			}
		});
		menu.add(chude8);

		chude9 = new JRadioButtonMenuItem("Graphite");
		chude9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doiGiaoDien("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
			}
		});
		menu.add(chude9);

		chude10 = new JRadioButtonMenuItem("Mint");
		chude10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doiGiaoDien("com.jtattoo.plaf.mint.MintLookAndFeel");
			}
		});
		menu.add(chude10);
		mnNewMenu.add(mntmngXut);

		JMenuItem mntmNewMenuItem = new JMenuItem("Thoát");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});

		JMenu menuTroGiup = new JMenu("Trợ giúp");
		menuBar.add(menuTroGiup);

		JMenuItem itemMnThongTinSanPham = new JMenuItem("Thông tin sản phẩm");
		menuTroGiup.add(itemMnThongTinSanPham);

		JMenuItem mntmHngDnS = new JMenuItem("Hướng dẫn sử dụng");
		menuTroGiup.add(mntmHngDnS);

		//----------------------------toolbar---------------------------------------
		ButtonGroup groupToolBar =new ButtonGroup();
		JPanel ThanhToolBar = new JPanel();
		ThanhToolBar.setOpaque(false);
		ThanhToolBar.setBounds(0, 24, 794, 80);
		contentPane.add(ThanhToolBar);
		ThanhToolBar.setLayout(new FlowLayout(FlowLayout.LEFT, 0,0));

		JToolBar toolBar = new JToolBar();
		toolBar.setMinimumSize(new Dimension(0, 0));
		ThanhToolBar.add(toolBar);
		toolBar.setVerifyInputWhenFocusTarget(false);

		JToggleButton btnTrangDangNhap = new JToggleButton("Trang chủ");
		btnTrangDangNhap.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTrangDangNhap.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTrangDangNhap.setVerticalAlignment(SwingConstants.TOP);
		btnTrangDangNhap.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnTrangDangNhap.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/home.png")));
		btnTrangDangNhap.setPreferredSize(new Dimension(90, 75));
		btnTrangDangNhap.setMaximumSize(new Dimension(100, 100));
		toolBar.add(btnTrangDangNhap);
		groupToolBar.add(btnTrangDangNhap);

		JToggleButton btnLapHoaDon =new JToggleButton("Lập hóa đơn");
		btnLapHoaDon.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLapHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnLapHoaDon.isSelected())
				{
					laphoadon.setVisible(true);
					xoaDuLieuTrongTable();
					duaDuLieuTuListVaoTable();
				}
				else
				{
					laphoadon.dispose();
				}


			}
		});
		toolBar.add(btnLapHoaDon);
		btnLapHoaDon.setIcon(new ImageIcon(GiaoDienNhanVien.class.getResource("/ser/bill.png")));
		btnLapHoaDon.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnLapHoaDon.setVerticalAlignment(SwingConstants.TOP);
		btnLapHoaDon.setPreferredSize(new Dimension(90, 75));
		btnLapHoaDon.setMaximumSize(new Dimension(100, 100));
		btnLapHoaDon.setHorizontalTextPosition(SwingConstants.CENTER);

		JToggleButton btnDanhSachThuoc = new JToggleButton("DS thuốc",true);
		btnDanhSachThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnDanhSachThuoc.isSelected())
				{
					panelCTHD.setVisible(false);
					panelDoanhThu.setVisible(false);
					panelDSHD.setVisible(false);
					panelDSThuoc.setVisible(true);
				}

			}
		});
		groupToolBar.add(btnDanhSachThuoc);
		btnDanhSachThuoc.setIcon(new ImageIcon(GiaoDienNhanVien.class.getResource("/ser/death_list.png")));
		btnDanhSachThuoc.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnDanhSachThuoc.setVerticalAlignment(SwingConstants.TOP);
		btnDanhSachThuoc.setPreferredSize(new Dimension(90, 75));
		btnDanhSachThuoc.setMaximumSize(new Dimension(100, 100));
		btnDanhSachThuoc.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDanhSachThuoc.setFont(new Font("Tahoma", Font.BOLD, 11));
		toolBar.add(btnDanhSachThuoc);

		JToggleButton btnDsHD = new JToggleButton("DS hóa đơn");
		btnDsHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnDsHD.isSelected())
				{
					panelCTHD.setVisible(false);
					panelDSThuoc.setVisible(false);
					panelDoanhThu.setVisible(false);
					panelDSHD.setVisible(true);
				}
			}
		});
		groupToolBar.add(btnDsHD);
		btnDsHD.setIcon(new ImageIcon(GiaoDienNhanVien.class.getResource("/ser/list.png")));
		btnDsHD.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnDsHD.setVerticalAlignment(SwingConstants.TOP);
		btnDsHD.setPreferredSize(new Dimension(90, 75));
		btnDsHD.setMaximumSize(new Dimension(100, 100));
		btnDsHD.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDsHD.setFont(new Font("Tahoma", Font.BOLD, 11));
		toolBar.add(btnDsHD);

		JToggleButton btnDoanhThu = new JToggleButton("Doanh thu");
		btnDoanhThu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnDoanhThu.isSelected())
				{
					panelCTHD.setVisible(false);
					panelDSThuoc.setVisible(false);
					panelDSHD.setVisible(false);
					panelDoanhThu.setVisible(true);
				}

			}
		});
		groupToolBar.add(btnDoanhThu);
		btnDoanhThu.setIcon(new ImageIcon(GiaoDienNhanVien.class.getResource("/ser/report.png")));
		btnDoanhThu.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnDoanhThu.setVerticalAlignment(SwingConstants.TOP);
		btnDoanhThu.setPreferredSize(new Dimension(90, 75));
		btnDoanhThu.setMaximumSize(new Dimension(100, 100));
		btnDoanhThu.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 11));
		toolBar.add(btnDoanhThu);

		btnNhanVien= new JToggleButton(IDNhanVien);
		btnNhanVien.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNhanVien.setVerticalAlignment(SwingConstants.TOP);
		btnNhanVien.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNhanVien.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/preferences_desktop_user.png")));
		btnNhanVien.setPreferredSize(new Dimension(90, 75));
		btnNhanVien.setMaximumSize(new Dimension(100, 100));
		toolBar.add(btnNhanVien);
		btnNhanVien.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnNhanVien.isSelected())
				{
					thongtinnv.setVisible(true);
				}
				else
					thongtinnv.dispose();

			}
		});				



		JButton btnDangXuat = new JButton("Đăng xuất");
		toolBar.add(btnDangXuat);
		btnDangXuat.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnDangXuat.setVerticalAlignment(SwingConstants.TOP);
		btnDangXuat.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDangXuat.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/application_exit.png")));
		btnDangXuat.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					dispose();
					new GiaoDienDangNhap().setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDangXuat.setPreferredSize(new Dimension(90, 75));
		btnDangXuat.setMaximumSize(new Dimension(100, 100));

		JButton btnThoat = new JButton("Thoát");
		toolBar.add(btnThoat);
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnThoat.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnThoat.setVerticalAlignment(SwingConstants.TOP);
		btnThoat.setHorizontalTextPosition(SwingConstants.CENTER);
		btnThoat.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/exit (1).png")));
		btnThoat.setPreferredSize(new Dimension(90, 75));
		btnThoat.setMaximumSize(new Dimension(100, 100));
		//-----------------------------------------header table---------------------

		String[] headerDanhSachDon="Mã hóa đơn;Người lập;Ngày lập;Tổng tiền".split(";");
		tablemodelDanhSachDon = new DefaultTableModel(headerDanhSachDon,0);

		String[] headerCTHD="Tên thuốc;Số lượng;Giá bán".split(";");
		tablemodelCTHD = new DefaultTableModel(headerCTHD,0);

		String[] headerDoanhThu="Mã đơn;Ngày lập;Người Lập;Tổng tiền".split(";");
		tablemodelDoanhThu = new DefaultTableModel(headerDoanhThu,0);


		String[] header="Mã thuốc;Tên thuốc;Loại thuốc;Nhà cung cấp;Số lượng còn;Giá bán".split(";");
		tablemodelThuoc = new DefaultTableModel(header,0);

		//----------------------------đa layer---------------------------------
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 115, 794, 430);
		contentPane.add(layeredPane);


		panelDSThuoc = new JPanel();
		panelDSThuoc.setBorder(new TitledBorder(null, "Danh s\u00E1ch thu\u1ED1c:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panelDSThuoc.setBounds(10, 11, 774, 408);
		layeredPane.add(panelDSThuoc);
		panelDSThuoc.add(scrollPaneDanhSachThuoc = new JScrollPane(tableDanhSachThuoc= new JTable(tablemodelThuoc)));
		scrollPaneDanhSachThuoc.setPreferredSize(new Dimension(750, 380));

		panelDSHD = new JPanel();
		panelDSHD.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s\u00E1ch h\u00F3a \u0111\u01A1n: ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
		layeredPane.setLayer(panelDSHD, 0);
		panelDSHD.setBounds(10, 11, 774, 408);
		layeredPane.add(panelDSHD);
		panelDSHD.setLayout(null);

		JLabel lblNgayLap_timkiem = new JLabel("Tìm theo thời gian lập:");
		lblNgayLap_timkiem.setBounds(41, 18, 141, 14);
		panelDSHD.add(lblNgayLap_timkiem);
		lblNgayLap_timkiem.setFont(new Font("Tahoma", Font.BOLD, 11));

		cbbNgay = new JComboBox();
		cbbNgay.setBounds(80, 43, 49, 25);
		panelDSHD.add(cbbNgay);
		cbbNgay.setModel(new DefaultComboBoxModel(new String[] {"All--","01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", ""}));

		cbbThang = new JComboBox();
		cbbThang.setBounds(139, 43, 49, 25);
		panelDSHD.add(cbbThang);
		cbbThang.setModel(new DefaultComboBoxModel(new String[] {"All--","01", "02", "04", "05", "06", "07", "08", "09", "10", "11", "12", ""}));

		cbbNam = new JComboBox();
		cbbNam.setBounds(198, 43, 59, 25);
		panelDSHD.add(cbbNam);
		cbbNam.setModel(new DefaultComboBoxModel(new String[] {"All--","1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998",
				"1999", "2000", "2001", "2002", "2003", "2004", "2017", "2018"}));

		JButton btnXemChiTiet = new JButton("Xem chi tiết");
		btnXemChiTiet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tableDanhSachDon.getSelectedRow();
				if (row!=-1) {
					panelDSThuoc.setVisible(false);
					panelDoanhThu.setVisible(false);
					panelDSHD.setVisible(false);
					panelCTHD.setVisible(true);

					String maHD =(String) tableDanhSachDon.getValueAt(row, 0);
					String ngay =(String) tableDanhSachDon.getValueAt(row, 2);
					String tongTien = tableDanhSachDon.getValueAt(row, 3)+"";
					try {
						ds.docBangCTHoaDonBan();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					for (CTHoaDonBan cthd : ds.listThuocBan)
					{
						if (cthd.getMaHD().equalsIgnoreCase(maHD)) {
							Object[] roww = {cthd.getTenThuoc(),cthd.getSoLuong(),cthd.getDonGia()};
							tablemodelCTHD.addRow(roww);
						}
					}
					txtMaHD.setText(maHD);
					txtNgayLap.setText(ngay);
					txtTongTien_timkiem.setText(tongTien);

				}
				else {
					JOptionPane.showMessageDialog(panelDSHD, "Vui lòng chọn hóa đơn cần xem !!!");
				}

			}
		});
		btnXemChiTiet.setBounds(156, 372, 125, 25);
		panelDSHD.add(btnXemChiTiet);

		btnXemChiTiet.setIcon(new ImageIcon(GiaoDienNhanVien.class.getResource("/ser/more_01.png")));
		btnXemChiTiet.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnTim_DSHoaDon = new JButton("Tìm");
		btnTim_DSHoaDon.setBounds(267, 43, 81, 25);
		panelDSHD.add(btnTim_DSHoaDon);
		btnTim_DSHoaDon.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTim_DSHoaDon.setIcon(new ImageIcon(GiaoDienNhanVien.class.getResource("/ser/search.png")));
		btnTim_DSHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date = control.layChuoiNgayThangNam(cbbNgay, cbbThang, cbbNam);
				try {
					ds.docBangHDB();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(int i=tablemodelDanhSachDon.getRowCount()-1;i>=0;i--)
				{
					tablemodelDanhSachDon.removeRow(i);
				}
				if(date.equals("All---All---All--"))
				{
					for (HoaDonBanHang hd : ds.listHDB)
					{
						Object[] row = {hd.getMaHD(),hd.getMaNVLap(),hd.getNgayLap(),hd.getTongTien()};
						tablemodelDanhSachDon.addRow(row);	
					}
				}
				else if(!cbbNgay.getSelectedItem().toString().equals("All--")
						&& !cbbThang.getSelectedItem().toString().equals("All--") 
						&& !cbbNam.getSelectedItem().toString().equals("All--"))
				{
					for (HoaDonBanHang hd : ds.listHDB)
					{
						if(hd.getNgayLap().equals(date))
						{
							Object[] row = {hd.getMaHD(),hd.getMaNVLap(),hd.getNgayLap(),hd.getTongTien()};
							tablemodelDanhSachDon.addRow(row);	
						}
					}
				}
				else if(!cbbThang.getSelectedItem().toString().equals("All--") 
						&& !cbbNam.getSelectedItem().toString().equals("All--")
						&& cbbNgay.getSelectedItem().toString().equals("All--"))
				{
					for(int i=1;i<=31;i++)
					{
						date = control.layChuoiThangNam(cbbThang, cbbNam)+"-"+ i +"";
						for (HoaDonBanHang hd : ds.listHDB)
						{
							if(hd.getNgayLap().equals(date))
							{
								Object[] row = {hd.getMaHD(),hd.getMaNVLap(),hd.getNgayLap(),hd.getTongTien()};
								tablemodelDanhSachDon.addRow(row);	
							}
						}
					}
				}
				else if(!cbbNam.getSelectedItem().toString().equals("All--")
						&&cbbThang.getSelectedItem().toString().equals("All--")
						&&cbbNgay.getSelectedItem().toString().equals("All--"))
				{
					for(int j=1;j<=12;j++)
					{
						for(int i=1;i<=31;i++)
						{
							if(j<10)
							{
								if(i<10)
									date = cbbNam.getSelectedItem().toString()+"-0"+j+"-0"+i+"";
								else
									date = cbbNam.getSelectedItem().toString()+"-0"+j+"-"+i+"";
							}
							if(j>=10)
							{
								if(i<10)
									date = cbbNam.getSelectedItem().toString()+"-"+j+"-0"+i+"";
								else
									date = cbbNam.getSelectedItem().toString()+"-"+j+"-"+i+"";
							}
							for (HoaDonBanHang hd : ds.listHDB)
							{
								if(hd.getNgayLap().equals(date))
								{
									Object[] row = {hd.getMaHD(),hd.getMaNVLap(),hd.getNgayLap(),hd.getTongTien()};
									tablemodelDanhSachDon.addRow(row);	
								}
							}
						}
					}
				}
				else if(cbbNam.getSelectedItem().toString().equals("All--") 
						&& !cbbThang.getSelectedItem().toString().equals("All--") 
						&& !cbbNgay.getSelectedItem().toString().equals("All--"))
				{
					JOptionPane.showMessageDialog(contentPane, "Phải chọn năm!");
				}
				else if(cbbThang.getSelectedItem().toString().equals("All--") 
						&& !cbbNgay.getSelectedItem().toString().equals("All--")
						&& !cbbNam.getSelectedItem().toString().equals("All--"))
				{
					JOptionPane.showMessageDialog(contentPane, "Phải chọn tháng!");
				}
				else if(cbbThang.getSelectedItem().toString().equals("All--") 
						&& !cbbNgay.getSelectedItem().toString().equals("All--")
						&& cbbNam.getSelectedItem().toString().equals("All--"))
				{
					JOptionPane.showMessageDialog(contentPane, "Phải chọn tháng và năm!");
				}
			}	
		});

		panelDSHD.add(scrollPaneDanhSachDon = new JScrollPane(tableDanhSachDon = new JTable(tablemodelDanhSachDon)));
		tableDanhSachDon.setForeground(new Color(165, 42, 42));
		tableDanhSachDon.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				int row = tableDanhSachDon.getSelectedRow();
			}
		});

		JLabel lblCcHan = new JLabel("Các hóa đơn đã lập:");
		lblCcHan.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCcHan.setBounds(41, 79, 176, 14);
		panelDSHD.add(lblCcHan);

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(GiaoDienNhanVien.class.getResource("/ser/doctor_doing_pill_end_a_ha.gif")));
		lblNewLabel_7.setBounds(471, 31, 280, 350);
		panelDSHD.add(lblNewLabel_7);
		scrollPaneDanhSachDon.setBounds(22, 99, 439, 262);



		panelCTHD = new JPanel();
		panelCTHD.setBounds(8, 10, 776, 409);
		layeredPane.add(panelCTHD);
		panelCTHD.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Chi ti\u1EBFt h\u00F3a \u0111\u01A1n: ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panelCTHD.setForeground(new Color(0, 255, 255));
		layeredPane.setLayer(panelCTHD, 0);
		panelCTHD.setLayout(null);

		JLabel lblMa = new JLabel("Mã hóa đơn:");
		lblMa.setBounds(31, 34, 77, 14);
		lblMa.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelCTHD.add(lblMa);

		txtMaHD = new JTextField();
		txtMaHD.setBounds(107, 30, 86, 20);
		txtMaHD.setEditable(false);
		txtMaHD.setEnabled(false);
		panelCTHD.add(txtMaHD);
		txtMaHD.setColumns(10);

		JLabel lblNgay = new JLabel("Ngày lập:");
		lblNgay.setBounds(206, 33, 62, 14);
		lblNgay.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelCTHD.add(lblNgay);

		txtNgayLap = new JTextField();
		txtNgayLap.setBounds(274, 28, 108, 20);
		txtNgayLap.setEnabled(false);
		txtNgayLap.setEditable(false);
		panelCTHD.add(txtNgayLap);
		txtNgayLap.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Người lập:");
		lblNewLabel_3.setBounds(399, 32, 67, 14);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelCTHD.add(lblNewLabel_3);

		txtNguoiLap_timkiem = new JTextField();
		txtNguoiLap_timkiem.setBounds(463, 28, 86, 20);
		txtNguoiLap_timkiem.setText(IDNhanVien);
		txtNguoiLap_timkiem.setEditable(false);
		txtNguoiLap_timkiem.setEnabled(false);
		panelCTHD.add(txtNguoiLap_timkiem);
		txtNguoiLap_timkiem.setColumns(10);

		JLabel lblNewLabel = new JLabel("Tổng tiền hóa đơn: ");
		lblNewLabel.setBounds(216, 62, 121, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelCTHD.add(lblNewLabel);

		txtTongTien_timkiem = new JTextField();
		txtTongTien_timkiem.setBounds(346, 59, 203, 20);
		txtTongTien_timkiem.setEditable(false);
		txtTongTien_timkiem.setEnabled(false);
		panelCTHD.add(txtTongTien_timkiem);
		txtTongTien_timkiem.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Danh sách thuốc bán:");
		lblNewLabel_2.setBounds(25, 65, 136, 14);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelCTHD.add(lblNewLabel_2);
		panelCTHD.add(scrollPaneCTHD = new JScrollPane(tableCTHD = new JTable(tablemodelCTHD)));

		JButton btnBack = new JButton("");
		btnBack.setContentAreaFilled(false);
		btnBack.setBorder(null);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDSThuoc.setVisible(false);
				panelDoanhThu.setVisible(false);
				panelCTHD.setVisible(false);
				panelDSHD.setVisible(true);
			}
		});
		btnBack.setToolTipText("Nhấn vào để quay lại DS hóa đơn");
		btnBack.setIcon(new ImageIcon(GiaoDienNhanVien.class.getResource("/ser/beaver.gif")));
		btnBack.setBounds(559, 121, 192, 124);
		panelCTHD.add(btnBack);

		JButton btnBack2 = new JButton("Quay lại");
		btnBack2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//------2 dòng này để xóa hết bảng cũ và hiện cái mới lên, ko có thông tin chồng lên nhau
				tablemodelCTHD.getDataVector().removeAllElements();
				tablemodelCTHD.fireTableDataChanged();
				//-----------------
				panelDSThuoc.setVisible(false);
				panelDoanhThu.setVisible(false);
				panelCTHD.setVisible(false);
				panelDSHD.setVisible(true);
			}
		});
		btnBack2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBack2.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnBack2.setVerticalAlignment(SwingConstants.TOP);
		btnBack2.setIcon(new ImageIcon(GiaoDienNhanVien.class.getResource("/ser/back4848.png")));
		btnBack2.setBounds(622, 35, 77, 75);
		panelCTHD.add(btnBack2);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(GiaoDienNhanVien.class.getResource("/ser/banner3.png")));
		lblNewLabel_5.setBounds(9, 293, 757, 110);
		panelCTHD.add(lblNewLabel_5);
		scrollPaneCTHD.setBounds(25, 84, 524, 198);

		panelDoanhThu = new JPanel();
		panelDoanhThu.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u1ED1ng k\u00EA doanh thu:", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
		layeredPane.setLayer(panelDoanhThu, 0);
		panelDoanhThu.setBounds(10, 11, 774, 408);
		layeredPane.add(panelDoanhThu);
		panelDoanhThu.setLayout(null);

		JLabel lblChon = new JLabel("Chọn mốc thời gian:");
		lblChon.setBounds(27, 21, 110, 14);
		panelDoanhThu.add(lblChon);
		lblChon.setFont(new Font("Tahoma", Font.BOLD, 11));

		comboBoxNgay_DoanhThu = new JComboBox();
		comboBoxNgay_DoanhThu.setBounds(68, 54, 49, 20);
		panelDoanhThu.add(comboBoxNgay_DoanhThu);
		comboBoxNgay_DoanhThu.setModel(new DefaultComboBoxModel(new String[] {"All--","01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", ""}));

		comboBoxThang_DoanhThu = new JComboBox();
		comboBoxThang_DoanhThu.setBounds(175, 54, 49, 20);
		panelDoanhThu.add(comboBoxThang_DoanhThu);
		comboBoxThang_DoanhThu.setModel(new DefaultComboBoxModel(new String[] {"All--","01", "02", "04", "05", "06", "07", "08", "09", "10", "11", "12", ""}));

		comboBoxNam_DoanhThu = new JComboBox();
		comboBoxNam_DoanhThu.setBounds(272, 54, 67, 20);
		panelDoanhThu.add(comboBoxNam_DoanhThu);
		comboBoxNam_DoanhThu.setModel(new DefaultComboBoxModel(new String[] {"All--","1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998",
				"1999", "2000", "2001", "2002", "2003", "2004", "2017", "2018"}));

		JLabel lblNewLabel_1 = new JLabel("Ngày:");
		lblNewLabel_1.setBounds(27, 57, 31, 14);
		panelDoanhThu.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblThng = new JLabel("Tháng:");
		lblThng.setBounds(127, 57, 38, 14);
		panelDoanhThu.add(lblThng);
		lblThng.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblNm = new JLabel("Năm:");
		lblNm.setBounds(234, 57, 28, 14);
		panelDoanhThu.add(lblNm);
		lblNm.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblNewLabel_4 = new JLabel("Tổng doanh thu:");
		lblNewLabel_4.setBounds(463, 368, 104, 15);
		panelDoanhThu.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));

		txtTongDoanhThu = new JTextField();
		txtTongDoanhThu.setBounds(572, 365, 195, 20);
		panelDoanhThu.add(txtTongDoanhThu);
		txtTongDoanhThu.setEnabled(false);
		txtTongDoanhThu.setEditable(false);
		txtTongDoanhThu.setColumns(10);

		JButton btntimDoanhThu = new JButton("Xem");
		btntimDoanhThu.setBounds(349, 51, 104, 27);
		panelDoanhThu.add(btntimDoanhThu);
		btntimDoanhThu.setIcon(new ImageIcon(GiaoDienNhanVien.class.getResource("/ser/search.png")));
		btntimDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btntimDoanhThu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String date = control.layChuoiNgayThangNam(comboBoxNgay_DoanhThu, comboBoxThang_DoanhThu, comboBoxNam_DoanhThu);
				try {
					ds.docBangHDB();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(int i=tablemodelDoanhThu.getRowCount()-1;i>=0;i--)
				{
					tablemodelDoanhThu.removeRow(i);
				}
				if(date.equals("All---All---All--"))
				{
					for (HoaDonBanHang hd : ds.listHDB)
					{
						if (hd.getMaNVLap().equalsIgnoreCase(IDNhanVien)) {
							Object[] row = {hd.getMaHD(),hd.getNgayLap(),hd.getMaNVLap(),hd.getTongTien()};
							tablemodelDoanhThu.addRow(row);
						}	
					}
					txtTongDoanhThu.setText(control.tongDoanhThu(tablemodelDoanhThu)+"");
				}
				else if(!comboBoxNgay_DoanhThu.getSelectedItem().toString().equals("All--")
						&& !comboBoxThang_DoanhThu.getSelectedItem().toString().equals("All--") 
						&& !comboBoxNam_DoanhThu.getSelectedItem().toString().equals("All--"))
				{
					for (HoaDonBanHang hd : ds.listHDB)
					{
						if(hd.getNgayLap().equals(date))
						{
							if (hd.getMaNVLap().equalsIgnoreCase(IDNhanVien)) {
								Object[] row = {hd.getMaHD(),hd.getNgayLap(),hd.getMaNVLap(),hd.getTongTien()};
								tablemodelDoanhThu.addRow(row);
							}
						}
					}
					txtTongDoanhThu.setText(control.tongDoanhThu(tablemodelDoanhThu)+"");
				}
				else if(!comboBoxThang_DoanhThu.getSelectedItem().toString().equals("All--") 
						&& !comboBoxNam_DoanhThu.getSelectedItem().toString().equals("All--")
						&& comboBoxNgay_DoanhThu.getSelectedItem().toString().equals("All--"))
				{
					for(int i=1;i<=31;i++)
					{
						date = control.layChuoiThangNam(comboBoxThang_DoanhThu, comboBoxNam_DoanhThu)+"-"+ i +"";
						for (HoaDonBanHang hd : ds.listHDB)
						{
							if(hd.getNgayLap().equals(date))
							{
								if (hd.getMaNVLap().equalsIgnoreCase(IDNhanVien)) {
									Object[] row = {hd.getMaHD(),hd.getNgayLap(),hd.getMaNVLap(),hd.getTongTien()};
									tablemodelDoanhThu.addRow(row);
								}
							}
						}
					}
					txtTongDoanhThu.setText(control.tongDoanhThu(tablemodelDoanhThu)+"");
				}
				else if(!comboBoxNam_DoanhThu.getSelectedItem().toString().equals("All--")
						&&comboBoxThang_DoanhThu.getSelectedItem().toString().equals("All--")
						&&comboBoxNgay_DoanhThu.getSelectedItem().toString().equals("All--"))
				{
					for(int j=1;j<=12;j++)
					{
						for(int i=1;i<=31;i++)
						{
							if(j<10)
							{
								if(i<10)
									date = comboBoxNam_DoanhThu.getSelectedItem().toString()+"-0"+j+"-0"+i+"";
								else
									date = comboBoxNam_DoanhThu.getSelectedItem().toString()+"-0"+j+"-"+i+"";
							}
							if(j>=10)
							{
								if(i<10)
									date = comboBoxNam_DoanhThu.getSelectedItem().toString()+"-"+j+"-0"+i+"";
								else
									date = comboBoxNam_DoanhThu.getSelectedItem().toString()+"-"+j+"-"+i+"";
							}
							for (HoaDonBanHang hd : ds.listHDB)
							{
								if(hd.getNgayLap().equals(date))
								{
									if (hd.getMaNVLap().equalsIgnoreCase(IDNhanVien)) {
										Object[] row = {hd.getMaHD(),hd.getNgayLap(),hd.getMaNVLap(),hd.getTongTien()};
										tablemodelDoanhThu.addRow(row);
									}
								}
							}
						}
					}
					txtTongDoanhThu.setText(control.tongDoanhThu(tablemodelDoanhThu)+"");
				}
				else if(comboBoxNam_DoanhThu.getSelectedItem().toString().equals("All--") 
						&& !comboBoxThang_DoanhThu.getSelectedItem().toString().equals("All--") 
						&& !comboBoxNgay_DoanhThu.getSelectedItem().toString().equals("All--"))
				{
					JOptionPane.showMessageDialog(contentPane, "Phải chọn năm!");
				}
				else if(comboBoxThang_DoanhThu.getSelectedItem().toString().equals("All--") 
						&& !comboBoxNgay_DoanhThu.getSelectedItem().toString().equals("All--")
						&& !comboBoxNam_DoanhThu.getSelectedItem().toString().equals("All--"))
				{
					JOptionPane.showMessageDialog(contentPane, "Phải chọn tháng!");
				}
				else if(comboBoxThang_DoanhThu.getSelectedItem().toString().equals("All--") 
						&& !comboBoxNgay_DoanhThu.getSelectedItem().toString().equals("All--")
						&& comboBoxNam_DoanhThu.getSelectedItem().toString().equals("All--"))
				{
					JOptionPane.showMessageDialog(contentPane, "Phải chọn tháng và năm!");
				}
			}	
		});
		panelDoanhThu.add(scrollPaneDoanhThu = new JScrollPane(tableDoanhThu = new JTable(tablemodelDoanhThu)));

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(GiaoDienNhanVien.class.getResource("/ser/doanhthu.png")));
		lblNewLabel_6.setBounds(463, 39, 301, 315);
		panelDoanhThu.add(lblNewLabel_6);
		scrollPaneDoanhThu.setBounds(31, 97, 422, 288);



		JLabel lblbanquyen = new JLabel("Made by cCc ");
		lblbanquyen.setBounds(696, 546, 88, 14);
		contentPane.add(lblbanquyen);
		lblbanquyen.setForeground(Color.LIGHT_GRAY);
		lblbanquyen.setFont(new Font("Trebuchet MS", Font.BOLD, 13));

		duaDuLieuTuListVaoTable();
		txtTongDoanhThu.setText(control.tongDoanhThu(tablemodelDoanhThu)+"");
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	void duaDuLieuTuListVaoTable()
	{
		try {
			ds.docThuoc();
			ds.docBangHDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (ThongTinThuoc thuoc : ds.listThuoc) 
		{
			Object[] row = {thuoc.getMaThuoc(),thuoc.getTenThuoc(),thuoc.getLoai(),thuoc.getNcc(),thuoc.getSoLuong(),thuoc.getGiaBan()};
			tablemodelThuoc.addRow(row);
		}
		for (HoaDonBanHang hd : ds.listHDB)
		{
			Object[] row = {hd.getMaHD(),hd.getMaNVLap(),hd.getNgayLap(),hd.getTongTien()};
			tablemodelDanhSachDon.addRow(row);
		}
		for (HoaDonBanHang hd : ds.listHDB) {
			if (hd.getMaNVLap().equalsIgnoreCase(IDNhanVien)) {
				Object[] row = {hd.getMaHD(),hd.getNgayLap(),hd.getMaNVLap(),hd.getTongTien()};
				tablemodelDoanhThu.addRow(row);
			}
		}
	}

	void xoaDuLieuTrongTable()
	{
		for(int i = tablemodelThuoc.getRowCount()-1;i>=0;i--)
			tablemodelThuoc.removeRow(i);
		for(int i = tablemodelDanhSachDon.getRowCount()-1;i>=0;i--)
			tablemodelDanhSachDon.removeRow(i);
		for(int i = tablemodelDoanhThu.getRowCount()-1;i>=0;i--)
			tablemodelDoanhThu.removeRow(i);
	}
	public void doiGiaoDien(String chude)
	{
		try
		{
			UIManager.setLookAndFeel(chude);
			SwingUtilities.updateComponentTreeUI(GiaoDienNhanVien.this);
			control.LuuChuDe(chude);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
