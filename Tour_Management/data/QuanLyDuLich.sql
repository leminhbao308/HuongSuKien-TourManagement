USE [master]
GO
/****** Object:  Database [QuanLyDuLich]    Script Date: 5/2/2023 1:41:39 AM ******/
CREATE DATABASE [QuanLyDuLich]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLyDuLich', FILENAME = N'D:\DATA\QuanLyDuLich\QuanLyDuLich.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QuanLyDuLich_log', FILENAME = N'D:\DATA\QuanLyDuLich\QuanLyDuLich_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [QuanLyDuLich] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyDuLich].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyDuLich] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyDuLich] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyDuLich] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyDuLich] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyDuLich] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyDuLich] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QuanLyDuLich] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyDuLich] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyDuLich] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyDuLich] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyDuLich] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyDuLich] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyDuLich] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyDuLich] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyDuLich] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QuanLyDuLich] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyDuLich] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyDuLich] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyDuLich] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyDuLich] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyDuLich] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyDuLich] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyDuLich] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QuanLyDuLich] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyDuLich] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyDuLich] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyDuLich] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyDuLich] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QuanLyDuLich] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QuanLyDuLich] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [QuanLyDuLich] SET QUERY_STORE = OFF
GO
USE [QuanLyDuLich]
GO
/****** Object:  Table [dbo].[DiaDanh]    Script Date: 5/2/2023 1:41:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DiaDanh](
	[maDiaDanh] [nchar](10) NOT NULL,
	[tenDiaDanh] [nvarchar](200) NULL,
	[tinhThanh] [nvarchar](200) NULL,
 CONSTRAINT [PK_DiaDanh] PRIMARY KEY CLUSTERED 
(
	[maDiaDanh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DichVu]    Script Date: 5/2/2023 1:41:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DichVu](
	[maDichVu] [nchar](10) NOT NULL,
	[phuongTienDiChuyen] [nvarchar](200) NULL,
	[giaDichVu] [float] NULL,
 CONSTRAINT [PK_DichVu] PRIMARY KEY CLUSTERED 
(
	[maDichVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HopDongTour]    Script Date: 5/2/2023 1:41:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HopDongTour](
	[maHopDong] [nchar](10) NOT NULL,
	[thoiGianLap] [date] NULL,
	[ghiChu] [nvarchar](200) NULL,
	[tongTien] [float] NULL,
	[maNhanVien] [nchar](10) NULL,
	[maKhachHang] [nchar](10) NULL,
	[maTour] [nchar](10) NULL,
	[maDichVu] [nchar](10) NULL,
 CONSTRAINT [PK_HopDongTour] PRIMARY KEY CLUSTERED 
(
	[maHopDong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 5/2/2023 1:41:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKhachHang] [nchar](10) NOT NULL,
	[soCCCD_HC] [nchar](14) NULL,
	[tenKhachHang] [nvarchar](50) NULL,
	[gioiTinh] [bit] NULL,
	[ngaySinh] [date] NULL,
	[email] [char](50) NULL,
	[soDienThoai] [char](15) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[maKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 5/2/2023 1:41:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNhanVien] [nchar](10) NOT NULL,
	[tenNhanVien] [nvarchar](100) NULL,
	[gioiTinh] [bit] NULL,
	[ngaySinh] [date] NULL,
	[diaChi] [nvarchar](100) NULL,
	[email] [char](50) NULL,
	[soDienThoai] [char](15) NULL,
	[chucVu] [nvarchar](50) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 5/2/2023 1:41:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[maNhanVien] [nchar](10) NOT NULL,
	[matKhau] [nchar](100) NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TourDuLich]    Script Date: 5/2/2023 1:41:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TourDuLich](
	[maTour] [nchar](10) NOT NULL,
	[tenTour] [nvarchar](120) NULL,
	[moTa] [nvarchar](200) NULL,
	[ngayDi] [date] NULL,
	[noiDi] [nvarchar](120) NULL,
	[soNgayDuKien] [int] NULL,
	[giaTour] [float] NULL,
	[trangThaiTour] [bit] NULL,
	[maDiaDanh] [nchar](10) NULL,
 CONSTRAINT [PK_TourDuLich] PRIMARY KEY CLUSTERED 
(
	[maTour] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[VeTour]    Script Date: 5/2/2023 1:41:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VeTour](
	[maVe] [nchar](10) NOT NULL,
	[maHopDong] [nchar](10) NULL,
 CONSTRAINT [PK_VeTour] PRIMARY KEY CLUSTERED 
(
	[maVe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[DiaDanh] ([maDiaDanh], [tenDiaDanh], [tinhThanh]) VALUES (N'DD001     ', N'Lăng Bác Hồ', N'Hà Nội')
INSERT [dbo].[DiaDanh] ([maDiaDanh], [tenDiaDanh], [tinhThanh]) VALUES (N'DD002     ', N'Cầu rồng', N'Đà Nẵng')
INSERT [dbo].[DiaDanh] ([maDiaDanh], [tenDiaDanh], [tinhThanh]) VALUES (N'DD003     ', N'IUH đại học công nghiệp', N'Hồ Chí Minh')
INSERT [dbo].[DiaDanh] ([maDiaDanh], [tenDiaDanh], [tinhThanh]) VALUES (N'DD004     ', N'Cung Đình Huế', N'Thừa Thiên Huế')
INSERT [dbo].[DiaDanh] ([maDiaDanh], [tenDiaDanh], [tinhThanh]) VALUES (N'DD005     ', N'Bãi Biển Nha Trang', N'Khánh Hòa')
INSERT [dbo].[DiaDanh] ([maDiaDanh], [tenDiaDanh], [tinhThanh]) VALUES (N'DD04      ', N'Cung Đình Huế', N'Thừa Thiên Huế')
GO
INSERT [dbo].[DichVu] ([maDichVu], [phuongTienDiChuyen], [giaDichVu]) VALUES (N'DV001     ', N'Xe máy', 500000)
INSERT [dbo].[DichVu] ([maDichVu], [phuongTienDiChuyen], [giaDichVu]) VALUES (N'DV002     ', N'Xe ô tô', 1000000)
INSERT [dbo].[DichVu] ([maDichVu], [phuongTienDiChuyen], [giaDichVu]) VALUES (N'DV003     ', N'Tàu hỏa', 250000)
INSERT [dbo].[DichVu] ([maDichVu], [phuongTienDiChuyen], [giaDichVu]) VALUES (N'DV004     ', N'Máy bay', 3000000)
INSERT [dbo].[DichVu] ([maDichVu], [phuongTienDiChuyen], [giaDichVu]) VALUES (N'DV005     ', N'Tàu cao tốc', 500000)
GO
INSERT [dbo].[HopDongTour] ([maHopDong], [thoiGianLap], [ghiChu], [tongTien], [maNhanVien], [maKhachHang], [maTour], [maDichVu]) VALUES (N'HD001     ', CAST(N'2023-05-02' AS Date), N'Khách hàng yêu cầu đặt phòng khách sạn 4 sao', 50000000, N'NV001     ', N'KH001     ', N'TDL001    ', N'DV001     ')
INSERT [dbo].[HopDongTour] ([maHopDong], [thoiGianLap], [ghiChu], [tongTien], [maNhanVien], [maKhachHang], [maTour], [maDichVu]) VALUES (N'HD002     ', CAST(N'2023-05-03' AS Date), N'Khách hàng yêu cầu đặt vé máy bay', 4000000, N'NV002     ', N'KH002     ', N'TDL002    ', N'DV001     ')
INSERT [dbo].[HopDongTour] ([maHopDong], [thoiGianLap], [ghiChu], [tongTien], [maNhanVien], [maKhachHang], [maTour], [maDichVu]) VALUES (N'HD003     ', CAST(N'2023-05-04' AS Date), N'Khách hàng yêu c?u thay d?i ch? ?', 6500000, N'NV003     ', N'KH003     ', N'TDL003    ', N'DV003     ')
INSERT [dbo].[HopDongTour] ([maHopDong], [thoiGianLap], [ghiChu], [tongTien], [maNhanVien], [maKhachHang], [maTour], [maDichVu]) VALUES (N'HD004     ', CAST(N'2023-05-02' AS Date), N'Yêu cầu đặt phòng vip khách sạn gần nhất', 8500000, N'NV002     ', N'KH004     ', N'TDL004    ', N'DV001     ')
GO
INSERT [dbo].[KhachHang] ([maKhachHang], [soCCCD_HC], [tenKhachHang], [gioiTinh], [ngaySinh], [email], [soDienThoai]) VALUES (N'KH001     ', N'12345678912345', N'Nguyễn Văn A', 1, CAST(N'1990-01-01' AS Date), N'nguyenvana@gmail.com                              ', N'0901234567     ')
INSERT [dbo].[KhachHang] ([maKhachHang], [soCCCD_HC], [tenKhachHang], [gioiTinh], [ngaySinh], [email], [soDienThoai]) VALUES (N'KH002     ', N'98765432112345', N'Trần Thị B', 0, CAST(N'1995-05-05' AS Date), N'tranthib@gmail.com                                ', N'0909876543     ')
INSERT [dbo].[KhachHang] ([maKhachHang], [soCCCD_HC], [tenKhachHang], [gioiTinh], [ngaySinh], [email], [soDienThoai]) VALUES (N'KH003     ', N'45678912345678', N'Phạm Văn C', 1, CAST(N'1985-10-10' AS Date), N'phamvanc@gmail.com                                ', N'0912345678     ')
INSERT [dbo].[KhachHang] ([maKhachHang], [soCCCD_HC], [tenKhachHang], [gioiTinh], [ngaySinh], [email], [soDienThoai]) VALUES (N'KH004     ', N'65432198765432', N'Huỳnh Thị D', 0, CAST(N'2000-07-07' AS Date), N'huynhthid@gmail.com                               ', N'0987654321     ')
INSERT [dbo].[KhachHang] ([maKhachHang], [soCCCD_HC], [tenKhachHang], [gioiTinh], [ngaySinh], [email], [soDienThoai]) VALUES (N'KH005     ', N'78912345612345', N'Lê Văn E', 1, CAST(N'1999-12-25' AS Date), N'levane@gmail.com                                  ', N'0978123456     ')
GO
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [gioiTinh], [ngaySinh], [diaChi], [email], [soDienThoai], [chucVu]) VALUES (N'MNV001    ', N'Nguyễn Văn A', 1, CAST(N'1990-01-01' AS Date), N'123 Đường ABC, Quận XYZ, TP.HCM', N'nguyenvana@gmail.com                              ', N'0987654321     ', N'Quản lý kinh doanh')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [gioiTinh], [ngaySinh], [diaChi], [email], [soDienThoai], [chucVu]) VALUES (N'NV001     ', N'Nguyễn Văn A', 1, CAST(N'1990-01-01' AS Date), N'123 Đường ABC, Quận XYZ, TP.HCM', N'nguyenvana@gmail.com                              ', N'0987654321     ', N'Quản lý kinh doanh')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [gioiTinh], [ngaySinh], [diaChi], [email], [soDienThoai], [chucVu]) VALUES (N'NV002     ', N'Nguyễn Văn B', 1, CAST(N'2000-01-01' AS Date), N'123 Đường ABC, Quận ABC, TP.HCM', N'nguyenvana@gmail.com                              ', N'0987654333     ', N'Nhân viên bán hàng')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [gioiTinh], [ngaySinh], [diaChi], [email], [soDienThoai], [chucVu]) VALUES (N'NV003     ', N'Nguyễn Văn C', 0, CAST(N'2000-09-01' AS Date), N'123 Đường ABC, Quận ABC, TP.HCM', N'nguyenvanc@gmail.com                              ', N'09876544444    ', N'Nhân viên bán hàng')
GO
INSERT [dbo].[TourDuLich] ([maTour], [tenTour], [moTa], [ngayDi], [noiDi], [soNgayDuKien], [giaTour], [trangThaiTour], [maDiaDanh]) VALUES (N'TDL001    ', N'Tour Hạ Long 3 ngày 2 đêm', N'Khám phá vịnh Hạ Long tuyệt đẹp', CAST(N'2023-06-10' AS Date), N'Hà Nội', 3, 4500000, 1, N'DD001     ')
INSERT [dbo].[TourDuLich] ([maTour], [tenTour], [moTa], [ngayDi], [noiDi], [soNgayDuKien], [giaTour], [trangThaiTour], [maDiaDanh]) VALUES (N'TDL002    ', N'Tour Sapa 2 ngày 1 đêm', N'Khám phá vùng đất Sapa', CAST(N'2023-07-05' AS Date), N'Hà Nội', 2, 3500000, 1, N'DD002     ')
INSERT [dbo].[TourDuLich] ([maTour], [tenTour], [moTa], [ngayDi], [noiDi], [soNgayDuKien], [giaTour], [trangThaiTour], [maDiaDanh]) VALUES (N'TDL003    ', N'Tour Phú Quốc 4 ngày 3 đêm', N'Thư giãn trên bãi biển Phú Quốc', CAST(N'2023-08-20' AS Date), N'Hồ Chí Minh', 4, 6000000, 1, N'DD003     ')
INSERT [dbo].[TourDuLich] ([maTour], [tenTour], [moTa], [ngayDi], [noiDi], [soNgayDuKien], [giaTour], [trangThaiTour], [maDiaDanh]) VALUES (N'TDL004    ', N'Tour Huế - Hội An 5 ngày 4 đêm', N'Thăm quan các di tích lịch sử', CAST(N'2023-09-15' AS Date), N'Đà Nẵng', 5, 8000000, 1, N'DD004     ')
GO
INSERT [dbo].[VeTour] ([maVe], [maHopDong]) VALUES (N'VT001     ', N'HD001     ')
INSERT [dbo].[VeTour] ([maVe], [maHopDong]) VALUES (N'VT002     ', N'HD002     ')
INSERT [dbo].[VeTour] ([maVe], [maHopDong]) VALUES (N'VT003     ', N'HD003     ')
INSERT [dbo].[VeTour] ([maVe], [maHopDong]) VALUES (N'VT004     ', N'HD004     ')
GO
ALTER TABLE [dbo].[HopDongTour]  WITH CHECK ADD  CONSTRAINT [FK_HopDongTour_DichVu] FOREIGN KEY([maDichVu])
REFERENCES [dbo].[DichVu] ([maDichVu])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[HopDongTour] CHECK CONSTRAINT [FK_HopDongTour_DichVu]
GO
ALTER TABLE [dbo].[HopDongTour]  WITH CHECK ADD  CONSTRAINT [FK_HopDongTour_KhachHang] FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[HopDongTour] CHECK CONSTRAINT [FK_HopDongTour_KhachHang]
GO
ALTER TABLE [dbo].[HopDongTour]  WITH CHECK ADD  CONSTRAINT [FK_HopDongTour_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[HopDongTour] CHECK CONSTRAINT [FK_HopDongTour_NhanVien]
GO
ALTER TABLE [dbo].[HopDongTour]  WITH CHECK ADD  CONSTRAINT [FK_HopDongTour_TourDuLich] FOREIGN KEY([maTour])
REFERENCES [dbo].[TourDuLich] ([maTour])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[HopDongTour] CHECK CONSTRAINT [FK_HopDongTour_TourDuLich]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_NhanVien]
GO
ALTER TABLE [dbo].[TourDuLich]  WITH CHECK ADD  CONSTRAINT [FK_TourDuLich_DiaDanh] FOREIGN KEY([maDiaDanh])
REFERENCES [dbo].[DiaDanh] ([maDiaDanh])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[TourDuLich] CHECK CONSTRAINT [FK_TourDuLich_DiaDanh]
GO
ALTER TABLE [dbo].[VeTour]  WITH CHECK ADD  CONSTRAINT [FK_VeTour_HopDongTour] FOREIGN KEY([maHopDong])
REFERENCES [dbo].[HopDongTour] ([maHopDong])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[VeTour] CHECK CONSTRAINT [FK_VeTour_HopDongTour]
GO
USE [master]
GO
ALTER DATABASE [QuanLyDuLich] SET  READ_WRITE 
GO
