package control;

import java.awt.Panel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import javax.swing.UIManager;

import javax.swing.table.DefaultTableModel;

import entity.CTHoaDonBan;
import entity.CTHoaDonNhap;
import entity.HoaDonBanHang;
import entity.HoaDonNhapHang;
import entity.KhachHang;
import entity.NhanVien;
import entity.ThongTinThuoc;

public class ControlGiaoDien {
	DanhSachDuLieu ds = new DanhSachDuLieu();
	final String filename="data.txt";
	//////Xử lý dữ liệu bên SQL
	//---------------DL Thuốc------------------------------
	public void themThuocVaoSQL(ThongTinThuoc thuoc) throws SQLException
	{
		int giaNhap = (int)Math.round(thuoc.getGiaNhap());
		int giaBan = (int)Math.round(thuoc.getGiaBan());
		Connection con =KetNoiSQL.getInstance().connect();
		try 
		{
			String sql="insert into DSThuoc values(?,?,?,?,?,?,?,?,?);";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, thuoc.getMaThuoc());
			pstmt.setString(2, thuoc.getTenThuoc());
			pstmt.setString(3, thuoc.getLoai());
			pstmt.setInt(4, thuoc.getSoLuong());
			pstmt.setString(5, thuoc.getDonViTinh());
			pstmt.setString(6, thuoc.getNcc());
			pstmt.setInt(7,giaNhap);
			pstmt.setInt(8,giaBan);
			pstmt.setString(9, thuoc.getHsd());
			pstmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			con.close();
		}
	}

	public boolean xoaThuocTrongSQL(String ma) throws SQLException
	{
		Connection con =KetNoiSQL.getInstance().connect();
		try 
		{
			String sql="delete from DSThuoc"+" where MaThuoc = ? ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,ma);
			pstmt.execute();
			return true;
		} catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();	
			con.close();
		}
		return false;
	}

	public boolean SuaDuLieuThuocTrongSQL(ThongTinThuoc thuocmoi) throws SQLException
	{
		Connection con =KetNoiSQL.getInstance().connect();
		try 
		{
			String sql="update dbo.DSThuoc set Ten=? ,Loai=? ,SoLuong=? ,DonViTinh=? ,NCC=? ,GiaNhap=? ,Giaban= ?,HanSD=? where MaThuoc = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(9,thuocmoi.getMaThuoc());
			pstmt.setString(1,thuocmoi.getTenThuoc());
			pstmt.setString(2,thuocmoi.getLoai());
			pstmt.setInt(3,thuocmoi.getSoLuong());
			pstmt.setString(4,thuocmoi.getDonViTinh());
			pstmt.setString(5,thuocmoi.getNcc());
			pstmt.setDouble(6,thuocmoi.getGiaNhap());
			pstmt.setDouble(7,thuocmoi.getGiaBan());
			pstmt.setString(8,thuocmoi.getHsd());
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();	
			con.close();
		}
		return false;
	}
	//------------------------DL Nhân Viên--------------------

	public boolean suaDuLieuNVTrongSQL(NhanVien nvmoi) throws SQLException
	{
		Connection con =KetNoiSQL.getInstance().connect();
		try 
		{
			String sql="update dbo.NhanVien set NgaySinh= ? ,SDT= ? ,DiaChi= ? ,Pass= ? ,CMND= ? where MaNV = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(6,nvmoi.getMaNv());
			pstmt.setString(1,nvmoi.getNgaySinh());
			pstmt.setString(2,nvmoi.getSdt());
			pstmt.setString(3,nvmoi.getDiaChi());
			pstmt.setString(4,nvmoi.getPass());
			pstmt.setString(5,nvmoi.getCmnd());
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();	
			con.close();
		}
		return false;
	}
	//-----------Doi pass
	public boolean doiPass(String passmoi,String maNV) throws SQLException
	{
		Connection con =KetNoiSQL.getInstance().connect();
		try 
		{
			String sql="update dbo.NhanVien set Pass=? where MaNV = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, passmoi);
			pstmt.setString(2, maNV);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();	
			con.close();
		}
		return false;
	}
	//-------------------------
	public boolean suaDiaChiVaSDT(String diaChiMoi,String sdtMoi,String maNV) throws SQLException
	{
		Connection con =KetNoiSQL.getInstance().connect();
		try 
		{
			String sql="update dbo.NhanVien set DiaChi=? ,SDT=? where MaNV = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, diaChiMoi);
			pstmt.setString(2, sdtMoi);
			pstmt.setString(3, maNV);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();	
			con.close();
		}
		return false;
	}
	//----------------------Tim Nhan Vien theo ID------------
	public  NhanVien docDuLieuNhanVien(String maNV) throws SQLException
	{
		Connection con =  KetNoiSQL.getInstance().connect();
		try 
		{
			String sql="select * from NhanVien "+"where MaNV=?";
			PreparedStatement pretamt = con.prepareStatement(sql);
			pretamt.setString(1, maNV);
			ResultSet rs = pretamt.executeQuery();
			while(rs.next())
			{
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String gioiTinh= rs.getString(3);
				String ngaySinh = rs.getString(4);
				String sDT = rs.getString(5);
				String diaChi = rs.getString(6);
				String mk = rs.getString(7);
				String cmnd = rs.getString(8);

				return  new NhanVien(ma, ten, ngaySinh, gioiTinh, sDT, diaChi, mk,cmnd);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			con.close();
		}
		return null;
	}
	//----------------------Phân quyền truy cập----------------
	public boolean PhanQuyenNV(NhanVien nv)
	{
		String[] a=nv.getMaNv().split("",3);
		String phanquyen=a[0]+a[1];
		if(phanquyen.equals("QL"))
			return true;
		else
			return false;


	}
	//----------------------DL Hóa đơn Bán---------------------

	public void themHDBVaoSQL(HoaDonBanHang hdb) throws SQLException
	{
		int tongTien = (int)Math.round(hdb.getTongTien());
		Connection con =KetNoiSQL.getInstance().connect();
		try 
		{
			String sql="insert into HoaDon values(?,?,?,?,?);";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, hdb.getMaHD());
			pstmt.setString(2, hdb.getMaNVLap());
			pstmt.setString(3, hdb.getNgayLap());
			pstmt.setString(4, hdb.getMaKH());
			pstmt.setInt(5, tongTien);
			pstmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			con.close();
		}
	}
	//-------------------DL CT hóa đơn bán--------------------
	public void themCTHoaDonBanVaoSQL(CTHoaDonBan ctHDB) throws SQLException
	{
		int donGia = (int)Math.round(ctHDB.getDonGia());
		Connection con =KetNoiSQL.getInstance().connect();
		try 
		{
			String sql="insert into dbo.ChiTietHoaDon values(?,?,?,?,?);";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ctHDB.getMaHD());
			pstmt.setString(2, ctHDB.getMaThuoc());
			pstmt.setString(3, ctHDB.getTenThuoc());
			pstmt.setInt(4, ctHDB.getSoLuong());
			pstmt.setInt(5, donGia);
			pstmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			con.close();
		}

	}

	//----------------------DL Hóa đơn Nhập-------------------

	public void themHDNVaoSQL(HoaDonNhapHang hdn) throws SQLException
	{
		int tongTien = (int)Math.round(hdn.getTongGiaNhap());
		Connection con =KetNoiSQL.getInstance().connect();
		try 
		{
			String sql="insert into HoaDonNhap values(?,?,?);";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, hdn.getMaHDN());
			pstmt.setString(2, hdn.getNgayNhap());
			pstmt.setInt(3,tongTien);
			pstmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			con.close();
		}
	}

	public boolean xoaHDNtrongSQL(String maHDN) throws SQLException
	{
		Connection con =KetNoiSQL.getInstance().connect();
		try 
		{
			String sql="delete from HoaDonNhap"+" where MaHDN = ? ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,maHDN);
			pstmt.execute();
			return true;
		} catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();	
			con.close();
		}
		return false;
	}
	//-------------------DL CT hóa đơn nhập--------------------
	public void themCTHoaDonNhapVaoSQL(CTHoaDonNhap ctHDN) throws SQLException
	{
		Connection con =KetNoiSQL.getInstance().connect();
		try 
		{
			String sql="insert into dbo.ChiTietHoaDonNhap values(?,?,?,?);";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ctHDN.getMaHDN());
			pstmt.setString(2, ctHDN.getMaThuoc());
			pstmt.setInt(3, ctHDN.getSoLuong());
			pstmt.setString(4, ctHDN.getHsd());
			pstmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			con.close();
		}

	}

	public boolean xoaCTHoaDonNhaptrongSQL(String maHDN) throws SQLException
	{
		Connection con =KetNoiSQL.getInstance().connect();
		try 
		{
			String sql="delete from ChiTietHoaDonNhap"+" where MaHDN = ? ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,maHDN);
			pstmt.execute();
			return true;
		} catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();	
			con.close();
		}
		return false;
	}
	//---------------------DL Khách Hàng------------------
	public void themKHVaoSQL (KhachHang kh) throws SQLException
	{
		Connection con =KetNoiSQL.getInstance().connect();
		try 
		{
			String sql="insert KhachHang values(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, kh.getCMND());
			pstmt.setString(2, kh.getHoTenKH());
			pstmt.setString(3, kh.getNgaySinh());
			pstmt.setString(4, kh.getSdt());
			pstmt.setString(5, kh.getMoTaKH());
			pstmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			con.close();
		}
	}
	public boolean suaDuLieuKhachHangTrongSQL(KhachHang khmoi) throws SQLException
	{
		Connection con =KetNoiSQL.getInstance().connect();
		try 
		{
			String sql="update dbo.KhachHang set MoTa=? where CMND = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,khmoi.getMoTaKH());
			pstmt.setString(2,khmoi.getCMND());
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();	
			con.close();
		}
		return false;
	}

	//---------------Hàm xử lý--------------------------
	public double tongDoanhThuCaNhan(String maNV,String ngayLap)
	{
		double tong=0;
		for(HoaDonBanHang hdb : ds.listHDB)
		{
			if(hdb.getMaNVLap().equalsIgnoreCase(maNV) && hdb.getNgayLap().equalsIgnoreCase(ngayLap))
			{
				tong+=hdb.getTongTien();
			}
		}
		return tong;
	}
	public double tongDoanhThu(DefaultTableModel tbm)
	{
		double tong = 0;
		for(int i=tbm.getRowCount()-1;i>=0;i--)
		{
			double tong2=Double.parseDouble(tbm.getValueAt(i, 3)+"");
			tong+=tong2;
		}
		return tong;
	}
	public double tinhTongGiaChoTungLoaiThuocBan(ThongTinThuoc thuoc, int soLuong)
	{
		double gia =0;
		gia = thuoc.getGiaBan()*soLuong;
		return gia;
	}
	public String layChuoiNgayThangNam(JComboBox ngay,JComboBox thang,JComboBox nam)
	{
		String date = nam.getSelectedItem().toString()+"-"+thang.getSelectedItem().toString()+"-"+ngay.getSelectedItem().toString();
		return date;
	}
	public String layChuoiThangNam(JComboBox thang,JComboBox nam)
	{
		String month = nam.getSelectedItem().toString()+"-"+thang.getSelectedItem().toString();
		return month;
	}
	public String layChuoiNam(JComboBox nam)
	{
		String year = nam.getSelectedItem().toString();
		return year;
	}

	public long kiemTraDulieuNhapSo(String s, JPanel cc, String tb) {
		try {
			long a = Long.parseLong(s);
			return a;
		}
			catch (Exception e) {
				// TODO: handle exception
			}
		 finally {
			JOptionPane.showMessageDialog(cc, tb);
			return -1;
		}
		
	}
	
		//-------------------Tim kiem doi tuong trong table ở SQL-----------------
	
	


	//-------------------Lưu chủ đề-----------------
	public String TaiChuDe()
	{
		BufferedReader br =null;
		try
		{
			if(new File(filename).exists())
			{
				br = new BufferedReader(new FileReader(filename));
				String line = br.readLine();
				if(!line.equals(""))
				{
					br.close();
					return line;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "com.jtattoo.plaf.mcwin.McWinLookAndFeel";
	}
	//
	public void LuuChuDe(String chude){
		BufferedWriter bw;
		try 
		{
			bw= new BufferedWriter(new FileWriter(filename));
			bw.write(chude);
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
	}
}