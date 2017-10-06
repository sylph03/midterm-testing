package main;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import giaodien.GiaoDienDangNhap;
import giaodien.NhanVien.GiaoDienNhanVien;
import giaodien.QuanLy.GiaoDienQuanLy;


public class Run {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try { 
					UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
					new GiaoDienDangNhap().setVisible(true);
					//new GiaoDienNhanVien().setVisible(true);
				} 
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		
	}
	
}
