create database QuanLyQuayThuoc
on
	primary (name = QuanLyQuayThuocdata, filename = 'D:\CSDL\QuanLyQuayThuoc.mdf', size = 20MB, maxsize = 40MB, filegrowth = 20%)
log on
	(name = QuanLyQuayThuoclog, filename = 'D:\CSDL\QuanLyQuayThuoc.ldf', size = 5MB, maxsize = 10MB, filegrowth = 1MB)

use QuanLyQuayThuoc

create table NhanVien
(MaNV varchar(10) primary key not null, 
HoTen nvarchar(50) not null,
GioiTinh nvarchar(10) not null,
NgaySinh date not null,
SDT varchar(15),
DiaChi nvarchar(50),
Pass varchar(30) not null,
CMND varchar(30) not null
)

create table DSThuoc
(MaThuoc varchar(10) primary key not null,
Ten varchar(30) not null,
Loai nvarchar(30) not null,
SoLuong int,
DonViTinh varchar(10),
NCC nvarchar(50),
GiaNhap money,
GiaBan money,
HanSD date,
)

create table KhachHang
(CMND varchar(15) primary key not null,
TenKH nvarchar(30),
NgaySinh date,
SDT varchar(15),
MoTa nvarchar(100)
)

create table HoaDon
(MaHD varchar(10) primary key not null,
MaNVLap varchar(10) foreign key references NhanVien(MaNV),  --id của nv lập
NgayLap date,
MaKH varchar(15) foreign key references KhachHang(CMND),
TongTien money
)

create table ChiTietHoaDon
(MaHD varchar(10) foreign key references HoaDon(MaHD),
MaThuoc varchar(10) foreign key references DSThuoc(MaThuoc),
TenThuoc nvarchar(30),
SoLuong int not null,
DonGia money not null
)

create table HoaDonNhap
(MaHDN varchar(10) primary key not null,
NgayLap date,
TongGiaNhap money
)

create table ChiTietHoaDonNhap
(MaHDN varchar(10) foreign key references HoaDonNhap(MaHDN),
MaThuoc varchar(10) foreign key references DSThuoc(MaThuoc),
SoLuong int not null,
HSD date,
)


set dateformat dMy

insert NhanVien values('QL001',N'Trần Đình Chiến',N'Nam','26/03/1997','0977621504',N'312 Quang Trung','1','025534575')
insert NhanVien values('NV001',N'Trần Hùng Cường',N'Nam','10/02/1997','0987212312',N'Nguyễn Oanh','1','023344567')
insert NhanVien values('NV002',N'Nguyễn Văn Mạnh Cường',N'Nam','21/09/1997','01221212121',N'Bình Tân','1','025528124')

select * from DSThuoc

insert DSThuoc values ('A001','COTRIM STADA FORTE','Khang Sinh',500,'Vien','alibaba',900,1500,'20/10/2018')
insert DSThuoc values ('A002','COTTUF L100ML','Ho Hap',70,'Lo','alibaba',13000,20000,'20/10/2018')
insert DSThuoc values ('A003','COVERSYL 5ML L30V','Tim mach',50,'Lo','alibaba',22000,25000,'20/10/2018')
insert DSThuoc values ('A004','CURAM 625MG','Khang Sinh',1000,'Vien','alibaba',500,900,'20/10/2020')
insert DSThuoc values ('A005','CURIOSIN T15G','Dung Ngoai',20,'Hop','alibaba',30000,35000,'20/12/2018')
insert DSThuoc values ('A006','DAI DAM DUC THINH','Thuc Pham Chuc Nang',70,'Lo','alibaba',17000,22000,'20/10/2018')
insert DSThuoc values ('A007','Dactarin T10G','Dung Ngoai',200,'Tupe','alibaba',5000,7000,'20/10/2018')
insert DSThuoc values ('A008','Davic H10G x 10G','Vitamin',100,'Goi','alibaba',15000,20000,'20/10/2018')
insert DSThuoc values ('A009','Decogen H25V x 4V','Ha Sot Giam Dau',500,'Vien','alibaba',300,500,'20/10/2018')
insert DSThuoc values ('A010','Doctor Cool H3B','Ha Sot Giam Dau',70,'Lo','alibaba',10000,15000,'20/10/2018')
insert DSThuoc values ('A011','Dogalic L100V','Thuc Pham Chuc Nang',70,'Lo','alibaba',10000,15000,'20/10/2018')
insert DSThuoc values ('A012','Doctor Cool H3B','Ha Sot Giam Dau',70,'Lo','alibaba',10000,15000,'20/10/2018')
insert DSThuoc values ('A013','Doctor Cool H5B','Ha Sot Giam Dau',70,'Lo','alibaba',10000,15000,'20/10/2018')
insert DSThuoc values ('A014','Doctor Cool H9B','Ha Sot Giam Dau',70,'Lo','alibaba',10000,15000,'20/10/2018')
insert DSThuoc values ('A015','Doctor Cool H17B','Ha Sot Giam Dau',70,'Lo','alibaba',10000,15000,'20/10/2018')


insert KhachHang values ('0268585975',N'Nguyễn Đức Vũ','28/03/1997','0121354643',N'Bệnh trĩ mãn tính')
insert KhachHang values ('0287667567',N'Nguyễn Tấn Đạt','17/8/1996','0904758375',N'Xi đa thời kì cuối')
insert KhachHang values ('0278686878',N'Tùng Văn Sơn','27/6/1999','0908564664',N'Đau đầu rùa')

insert HoaDon values ('HD1','NV001','15/9/2017','0287667567',100000)
insert HoaDon values ('HD2','NV002','12/9/2017','0268585975',200000)

insert ChiTietHoaDon values('HD1','A001','COTRIM STADA FORTE',10,1500)
insert ChiTietHoaDon values('HD1','A002','COTTUF L100ML',20,3000)
insert ChiTietHoaDon values('HD1','A003','COVERSYL 5ML L30V',15,1700)
insert ChiTietHoaDon values('HD1','A004','CURAM 625MG',16,2000)

insert ChiTietHoaDon values('HD2','A001','COTRIM STADA FORTE',14,4000)
insert ChiTietHoaDon values('HD2','A002','COTTUF L100ML',15,5000)
insert ChiTietHoaDon values('HD2','A003','COVERSYL 5ML L30V',16,1900)
insert ChiTietHoaDon values('HD2','A004','CURAM 625MG',18,1500)


insert HoaDonNhap values('N001','27/6/1999',200000)
insert HoaDonNhap values('N002','26/6/2015',300000)

insert ChiTietHoaDonNhap values('N001','A001',100,'26/10/2018')
insert ChiTietHoaDonNhap values('N001','A002',200,'26/10/2018')
insert ChiTietHoaDonNhap values('N001','A003',300,'26/10/2018')
insert ChiTietHoaDonNhap values('N001','A004',400,'26/10/2018')

insert ChiTietHoaDonNhap values('N002','A005',400,'26/10/2018')
insert ChiTietHoaDonNhap values('N002','A006',500,'26/10/2018')
insert ChiTietHoaDonNhap values('N002','A007',600,'26/10/2018')
insert ChiTietHoaDonNhap values('N002','A008',700,'26/10/2018')

select * from KhachHang