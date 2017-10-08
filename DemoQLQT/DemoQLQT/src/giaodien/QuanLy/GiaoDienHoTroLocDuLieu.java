package giaodien.QuanLy;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import java.awt.Color;

public class GiaoDienHoTroLocDuLieu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ButtonGroup group ;
	private JRadioButton rdbtnThuoc,rdbtnTinhTrang,rdbtnNV;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public GiaoDienHoTroLocDuLieu() {
		setResizable(false);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 250, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "B\u1EA3ng c\u1EA7n l\u1ECDc d\u1EEF li\u1EC7u", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 224, 108);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		rdbtnThuoc = new JRadioButton("Danh Sách Thuốc",true);
		rdbtnThuoc.setBounds(6, 15, 212, 23);
		panel.add(rdbtnThuoc);
		
		rdbtnNV = new JRadioButton("Danh Sách Nhân Viên");
		rdbtnNV.setBounds(6, 45, 212, 23);
		panel.add(rdbtnNV);
		
		rdbtnTinhTrang = new JRadioButton("Danh Sách Tình Trạng");
		rdbtnTinhTrang.setBounds(6, 75, 212, 23);
		panel.add(rdbtnTinhTrang);
		
		group=new ButtonGroup();
		group.add(rdbtnNV);
		group.add(rdbtnThuoc);
		group.add(rdbtnTinhTrang);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 118, 224, 309);
		contentPanel.add(layeredPane);
		
		JPanel panelDanhSachThuoc = new JPanel();
		panelDanhSachThuoc.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "T\u00F9y ch\u1EC9nh b\u1ED9 l\u1ECDc", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDanhSachThuoc.setBounds(0, 0, 224, 309);
		layeredPane.add(panelDanhSachThuoc);
		panelDanhSachThuoc.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Loại");
		lblNewLabel.setBounds(10, 38, 46, 14);
		panelDanhSachThuoc.add(lblNewLabel);
		
		JLabel lblNcc = new JLabel("NCC");
		lblNcc.setBounds(10, 63, 46, 14);
		panelDanhSachThuoc.add(lblNcc);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(83, 38, 131, 20);
		panelDanhSachThuoc.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(83, 63, 131, 20);
		panelDanhSachThuoc.add(comboBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("Kiểu sắp xếp");
		lblNewLabel_1.setBounds(10, 94, 87, 14);
		panelDanhSachThuoc.add(lblNewLabel_1);
		
		JLabel lblDLiuLc = new JLabel("Dữ liệu lọc");
		lblDLiuLc.setBounds(10, 20, 87, 14);
		panelDanhSachThuoc.add(lblDLiuLc);
		
		JRadioButton rdbtnTngDn = new JRadioButton("Tăng dần");
		rdbtnTngDn.setBounds(10, 115, 87, 23);
		panelDanhSachThuoc.add(rdbtnTngDn);
		
		JRadioButton rdbtnGimDn = new JRadioButton("Giảm dần");
		rdbtnGimDn.setBounds(109, 115, 109, 23);
		panelDanhSachThuoc.add(rdbtnGimDn);
		
		JPanel panelDanhSachNV = new JPanel();
		panelDanhSachNV.setBounds(0, 0, 224, 309);
		layeredPane.add(panelDanhSachNV);
		
		JPanel panleTinhTrang = new JPanel();
		panleTinhTrang.setBounds(0, 0, 224, 309);
		layeredPane.add(panleTinhTrang);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
