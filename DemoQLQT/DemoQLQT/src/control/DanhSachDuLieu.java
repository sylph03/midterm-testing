package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.CTHoaDonBan;
import entity.CTHoaDonNhap;
import entity.HoaDonBanHang;
import entity.HoaDonNhapHang;
import entity.KhachHang;
import entity.NhanVien;
import entity.ThongTinThuoc;

public class DanhSachDuLieu {
	public ArrayList<ThongTinThuoc> listThuoc;
	public ArrayList<NhanVien> listNV;
	public ArrayList<HoaDonBanHang> listHDB;
	public ArrayList<HoaDonNhapHang> listHDN;
	public ArrayList<CTHoaDonNhap>	listThuocNhap;
	public ArrayList<CTHoaDonBan> listThuocBan;
	public ArrayList<KhachHang> listKhachHang;
	//----------------List thuốc----------------------
	public  void docThuoc() throws SQLException    //Đọc dữ liệu bên SQL và đổ vào list
	{
		listThuoc = new ArrayList<ThongTinThuoc>();
		Connection con =  KetNoiSQL.getInstance().connect();
		try 
		{
			String sql="select * from dbo.DSThuoc";
			Statement stmt =con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				String maThuoc = rs.getString(1);
				String ten = rs.getString(2);
				String loai= rs.getString(3);
				int soLuong = rs.getInt(4);
				String donViTinh = rs.getString(5);
				String ncc = rs.getString(6);
				Double giaNhap = rs.getDouble(7);
				Double giaBan = rs.getDouble(8);
				String hsd = rs.getString(9);
				ThongTinThuoc thuoc =new ThongTinThuoc(maThuoc,ten,loai,ncc,giaBan,giaNhap,hsd,soLuong,donViTinh);
				listThuoc.add(thuoc);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			con.close();
		}
	}

	public int layViTriThuocTrongList(ThongTinThuoc thuoc)
	{
		int index = -1;
		index = listThuoc.indexOf(thuoc);
		return index;
	}

	public ThongTinThuoc layThongTinThuocMoi() /////Lấy thông tin thuốc từ test field
	{
		ThongTinThuoc thuocmoi = null;
		return thuocmoi;
	}

	public boolean ThemThuoc(ThongTinThuoc thuoc)
	{
		if(listThuoc.contains(thuoc))
		{
			return false;
		}
		return listThuoc.add(thuoc);
	}


	public boolean Xoa(int index)
	{
		if(index!=-1)
		{
			listThuoc.remove(index);
			return true;
		}
		return false;
	}

	public boolean Sua(ThongTinThuoc thuocmoi)
	{
		for (ThongTinThuoc thuoc : listThuoc) 
		{
			if(thuocmoi.getMaThuoc()==thuoc.getMaThuoc())
			{
				thuoc.setTenThuoc(thuocmoi.getTenThuoc());
				thuoc.setLoai(thuocmoi.getLoai());
				thuoc.setNcc(thuocmoi.getNcc());
				thuoc.setGiaBan(thuocmoi.getGiaBan());
				thuoc.setGiaNhap(thuocmoi.getGiaNhap());
				thuoc.setHsd(thuocmoi.getHsd());
				thuoc.setSoLuong(thuocmoi.getSoLuong());
				thuoc.setDonViTinh(thuocmoi.getDonViTinh()	);
				return true;
			}
		}
		return false;
	}
	//------------------List NV-----------------------
	public  void docNV() throws SQLException ///Đọc dữ liệu nhân viên từ SQL vào list 
	{
		listNV = new ArrayList<NhanVien>();
		Connection con =  KetNoiSQL.getInstance().connect();
		try 
		{
			String sql="select * from dbo.NhanVien";
			Statement stmt =con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				String maNv = rs.getString(1);
				String hoTenNV = rs.getString(2);
				String ngaySinh= rs.getString(4);
				String gioiTinh = rs.getString(3);
				String sdt = rs.getString(5);
				String diaChi = rs.getString(6);
				String pass = rs.getString(7);
				String cmnd = rs.getString(8);
				NhanVien nv =new NhanVien(maNv, hoTenNV, ngaySinh, gioiTinh, sdt, diaChi, pass, cmnd);
				listNV.add(nv);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			con.close();
		}
	}
	public boolean suaThongTinNV(NhanVien nvmoi)
	{
		for (NhanVien nv : listNV) 
		{
			if(nvmoi.getMaNv()==nv.getMaNv())
			{
				nv.setNgaySinh(nvmoi.getNgaySinh());
				nv.setSdt(nvmoi.getSdt());
				nv.setDiaChi(nvmoi.getDiaChi());
				nv.setPass(nvmoi.getPass());
				nv.setCmnd(nvmoi.getCmnd());
				return true;
			}
		}
		return false;
	}
	//----------------------List HD bán----------------
	public  void docBangHDB() throws SQLException ///Đọc dữ liệu hóa đơn bán từ SQL vào list 
	{
		listHDB = new ArrayList<HoaDonBanHang>();
		Connection con =  KetNoiSQL.getInstance().connect();
		try 
		{
			String sql="select * from dbo.HoaDon";
			Statement stmt =con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				String maHD = rs.getString(1);
				String ngayLap = rs.getString(3);
				String maNVLap = rs.getString(2);
				String maKH = rs.getString(4);
				Double tongTien= rs.getDouble(5);
				HoaDonBanHang hdb = new HoaDonBanHang(maHD, ngayLap, maNVLap, maKH, tongTien);
				listHDB.add(hdb);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			con.close();
		}
	}
	
	public int demSoHDBan()
	{
		try {
			docBangHDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int dem=0;
		dem = listHDB.size();
		return dem+1;
	}
	//--------------------------List HD nhập-------------------
	public  void docBangHDN() throws SQLException ///Đọc dữ liệu hóa đơn nhập từ SQL vào list 
	{
		listHDN = new ArrayList<HoaDonNhapHang>();
		Connection con =  KetNoiSQL.getInstance().connect();
		try 
		{
			String sql="select * from dbo.HoaDonNhap";
			Statement stmt =con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				String maHDN = rs.getString(1);
				String ngayNhap = rs.getString(2);
				Double tongGiaNhap= rs.getDouble(3);
				HoaDonNhapHang hdn = new HoaDonNhapHang(maHDN, ngayNhap, tongGiaNhap);
				listHDN.add(hdn);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			con.close();
		}
	}
	//-------------------------List CT hóa đơn nhập-----------------------
	public  void docBangCTHoaDonNhap() throws SQLException ///Đọc dữ liệu thuốc từ SQL vào list 
	{
		listThuocNhap = new ArrayList<CTHoaDonNhap>();
		Connection con =  KetNoiSQL.getInstance().connect();
		try 
		{
			String sql="select * from dbo.ChiTietHoaDonNhap";
			Statement stmt =con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				String maHDN = rs.getString(1);
				String maThuoc = rs.getString(2);
				int soLuong = rs.getInt(3);
				String hsd = rs.getString(4);
				CTHoaDonNhap ctHDN = new CTHoaDonNhap(maHDN, maThuoc, soLuong, hsd);
				listThuocNhap.add(ctHDN);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			con.close();
		}
	}
	//---------------
	public NhanVien timNVTheoMa(String ma)
	{
		for(NhanVien nv : listNV)
			if(nv.getMaNv().equalsIgnoreCase(ma))
				return nv;
		return null;
	}
	
	//------------------------List KH---------------------
	public  void docBangKhachHang() throws SQLException ///Đọc dữ liệu KH từ SQL vào list 
	{
		listKhachHang = new ArrayList<KhachHang>();
		Connection con =  KetNoiSQL.getInstance().connect();
		try 
		{
			String sql="select * from dbo.KhachHang";
			Statement stmt =con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				String CMND = rs.getString(1);
				String tenKH = rs.getString(2);
				String NgaySinh = rs.getString(3);
				String sdt = rs.getString(4);
				String moTa = rs.getString(5);
				KhachHang kh = new KhachHang(CMND, tenKH, NgaySinh, sdt, moTa);
				listKhachHang.add(kh);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			con.close();
		}
	}

	//-----------------------Danh Sach thuốc timg kiếm thông minh----------------------
	//29-09-2017
		public String Timtenthuoc(String tenthuoc) throws SQLException
		{
			String thuoctim="";
			Connection con =KetNoiSQL.getInstance().connect();
			try 
			{
				String sql="select ten from dbo.DSThuoc where Ten like ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, tenthuoc+"%");
				ResultSet rs = pstmt.executeQuery();
				while(rs.next())
				{
					thuoctim+=rs.getString(1)+";";
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				con.close();
			}
			
			return thuoctim;
		}
}