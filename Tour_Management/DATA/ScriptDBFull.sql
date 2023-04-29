USE [master]
GO
/****** Object:  Database [DBQuanLyDuLich]    Script Date: 4/29/2023 8:10:15 AM ******/
CREATE DATABASE [DBQuanLyDuLich]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'DBQuanLyDuLich', FILENAME = N'D:\DATA\DBQuanLyDuLich\DBQuanLyDuLich.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'DBQuanLyDuLich_log', FILENAME = N'D:\DATA\DBQuanLyDuLich\DBQuanLyDuLich_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [DBQuanLyDuLich] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DBQuanLyDuLich].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DBQuanLyDuLich] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [DBQuanLyDuLich] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [DBQuanLyDuLich] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [DBQuanLyDuLich] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [DBQuanLyDuLich] SET ARITHABORT OFF 
GO
ALTER DATABASE [DBQuanLyDuLich] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [DBQuanLyDuLich] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [DBQuanLyDuLich] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [DBQuanLyDuLich] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [DBQuanLyDuLich] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [DBQuanLyDuLich] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [DBQuanLyDuLich] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [DBQuanLyDuLich] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [DBQuanLyDuLich] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [DBQuanLyDuLich] SET  DISABLE_BROKER 
GO
ALTER DATABASE [DBQuanLyDuLich] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [DBQuanLyDuLich] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [DBQuanLyDuLich] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [DBQuanLyDuLich] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [DBQuanLyDuLich] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [DBQuanLyDuLich] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [DBQuanLyDuLich] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [DBQuanLyDuLich] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [DBQuanLyDuLich] SET  MULTI_USER 
GO
ALTER DATABASE [DBQuanLyDuLich] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [DBQuanLyDuLich] SET DB_CHAINING OFF 
GO
ALTER DATABASE [DBQuanLyDuLich] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [DBQuanLyDuLich] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [DBQuanLyDuLich] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [DBQuanLyDuLich] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [DBQuanLyDuLich] SET QUERY_STORE = OFF
GO
USE [DBQuanLyDuLich]
GO
/****** Object:  Table [dbo].[DiaDanh]    Script Date: 4/29/2023 8:10:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DiaDanh](
	[maDiaDanh] [nchar](10) NOT NULL,
	[tenDiaDanh] [nvarchar](50) NULL,
	[tinhThanh] [nvarchar](50) NULL,
 CONSTRAINT [PK_DiaDanh] PRIMARY KEY CLUSTERED 
(
	[maDiaDanh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DichVu]    Script Date: 4/29/2023 8:10:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DichVu](
	[maDichVu] [nchar](10) NOT NULL,
	[phuongTienDiChuyen] [nvarchar](50) NULL,
	[chiTietDichVu] [nvarchar](200) NULL,
	[giaDichVu] [float] NULL,
 CONSTRAINT [PK_DichVuu] PRIMARY KEY CLUSTERED 
(
	[maDichVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HopDongTour]    Script Date: 4/29/2023 8:10:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HopDongTour](
	[maHopDong] [nchar](10) NOT NULL,
	[thoiGianLap] [nchar](10) NULL,
	[ghiChu] [nvarchar](2000) NULL,
	[tongTien] [float] NULL,
	[daThanhToan] [float] NULL,
	[maNhanVien] [nchar](10) NULL,
	[maKhachHang] [nchar](10) NULL,
 CONSTRAINT [PK_HopDongTour] PRIMARY KEY CLUSTERED 
(
	[maHopDong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 4/29/2023 8:10:15 AM ******/
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
	[diaChi] [nvarchar](50) NULL,
	[email] [nchar](30) NULL,
	[soDienThoai] [nchar](10) NULL,
	[tienTour] [float] NULL,
	[maTour] [nchar](10) NULL,
	[maDichVu] [nchar](10) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[maKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 4/29/2023 8:10:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNhanVien] [nchar](10) NOT NULL,
	[tenNhanVien] [nvarchar](50) NULL,
	[gioiTinh] [bit] NULL,
	[ngaySinh] [date] NULL,
	[diaChi] [nvarchar](50) NULL,
	[email] [nchar](30) NULL,
	[soDienThoai] [nchar](10) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 4/29/2023 8:10:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[maTaiKhoan] [nchar](10) NOT NULL,
	[maDangNhap] [nchar](100) NULL,
	[matKhau] [nchar](100) NULL,
	[maNhanVien] [nchar](10) NULL,
 CONSTRAINT [PK_TaiKhoann] PRIMARY KEY CLUSTERED 
(
	[maTaiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TourDuLich]    Script Date: 4/29/2023 8:10:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TourDuLich](
	[maTour] [nchar](10) NOT NULL,
	[tenTour] [nvarchar](50) NULL,
	[moTa] [nvarchar](200) NULL,
	[ngayDi] [date] NULL,
	[noiDi] [nvarchar](50) NULL,
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
/****** Object:  Table [dbo].[VeTour]    Script Date: 4/29/2023 8:10:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VeTour](
	[maVe] [nchar](10) NOT NULL,
	[maKhachHang] [nchar](10) NULL,
 CONSTRAINT [PK_VeTour] PRIMARY KEY CLUSTERED 
(
	[maVe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[DiaDanh] ([maDiaDanh], [tenDiaDanh], [tinhThanh]) VALUES (N'DD001     ', N'Phú Qu?c', N'Kiên Giang')
INSERT [dbo].[DiaDanh] ([maDiaDanh], [tenDiaDanh], [tinhThanh]) VALUES (N'DD002     ', N'H?i An', N'Qu?ng Nam')
INSERT [dbo].[DiaDanh] ([maDiaDanh], [tenDiaDanh], [tinhThanh]) VALUES (N'DD003     ', N'Ðà L?t', N'Lâm Ð?ng')
INSERT [dbo].[DiaDanh] ([maDiaDanh], [tenDiaDanh], [tinhThanh]) VALUES (N'DD004     ', N'Vung Tàu', N'Bà R?a - Vung Tàu')
INSERT [dbo].[DiaDanh] ([maDiaDanh], [tenDiaDanh], [tinhThanh]) VALUES (N'DD005     ', N'H? Long', N'Qu?ng Ninh')
GO
INSERT [dbo].[DichVu] ([maDichVu], [phuongTienDiChuyen], [chiTietDichVu], [giaDichVu]) VALUES (N'DV001     ', N'Xe máy', N'Có khách s?n ngh? chân', 100000)
INSERT [dbo].[DichVu] ([maDichVu], [phuongTienDiChuyen], [chiTietDichVu], [giaDichVu]) VALUES (N'DV0010    ', N'Tau hoa', N'ok', 5000000)
INSERT [dbo].[DichVu] ([maDichVu], [phuongTienDiChuyen], [chiTietDichVu], [giaDichVu]) VALUES (N'DV002     ', N'Xe mô tô', N'Có khách s?n ngh? chân', 500000)
INSERT [dbo].[DichVu] ([maDichVu], [phuongTienDiChuyen], [chiTietDichVu], [giaDichVu]) VALUES (N'DV003     ', N'Ô tô 4 ch?', N'Có khách s?n ngh? chân', 1000000)
GO
INSERT [dbo].[HopDongTour] ([maHopDong], [thoiGianLap], [ghiChu], [tongTien], [daThanhToan], [maNhanVien], [maKhachHang]) VALUES (N'HD001     ', N'2023-02-01', N'Thanh toan tien mat', 5100000, 1000000, N'NV001     ', N'KH001     ')
INSERT [dbo].[HopDongTour] ([maHopDong], [thoiGianLap], [ghiChu], [tongTien], [daThanhToan], [maNhanVien], [maKhachHang]) VALUES (N'HD002     ', N'2023-02-01', N'Thanh toan tien mat', 3500000, 2000000, N'NV002     ', N'KH002     ')
GO
INSERT [dbo].[KhachHang] ([maKhachHang], [soCCCD_HC], [tenKhachHang], [gioiTinh], [ngaySinh], [diaChi], [email], [soDienThoai], [tienTour], [maTour], [maDichVu]) VALUES (N'KH_Test   ', N'test          ', N'test', 0, CAST(N'2023-04-22' AS Date), N'test', N'test                          ', N'test      ', 100, N'TDL001    ', N'DV001     ')
INSERT [dbo].[KhachHang] ([maKhachHang], [soCCCD_HC], [tenKhachHang], [gioiTinh], [ngaySinh], [diaChi], [email], [soDienThoai], [tienTour], [maTour], [maDichVu]) VALUES (N'KH_Test2  ', N'test succes   ', N'test', 0, CAST(N'2023-04-22' AS Date), N'test', N'test                          ', N'test      ', 100, N'TDL001    ', N'DV001     ')
INSERT [dbo].[KhachHang] ([maKhachHang], [soCCCD_HC], [tenKhachHang], [gioiTinh], [ngaySinh], [diaChi], [email], [soDienThoai], [tienTour], [maTour], [maDichVu]) VALUES (N'KH001     ', N'12345678901234', N'Nguyen Van A', 1, CAST(N'2000-01-01' AS Date), N'123 Nguyen Trai, Quan 1, TP.HCM', N'nguyenvana@gmail.com          ', N'0901234567', 5100000, N'TDL001    ', N'DV001     ')
INSERT [dbo].[KhachHang] ([maKhachHang], [soCCCD_HC], [tenKhachHang], [gioiTinh], [ngaySinh], [diaChi], [email], [soDienThoai], [tienTour], [maTour], [maDichVu]) VALUES (N'KH002     ', N'12345678901254', N'Nguyen Van B', 0, CAST(N'2000-02-01' AS Date), N'123 Nguyen Du, Quan 1, TP.HCM', N'nguyenvanb@gmail.com          ', N'0901234565', 3500000, N'TDL002    ', N'DV002     ')
GO
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [gioiTinh], [ngaySinh], [diaChi], [email], [soDienThoai]) VALUES (N'NV001     ', N'Nguyễn Văn A', 1, CAST(N'1990-01-01' AS Date), N'Hà Nội', N'nva@gmail.com                 ', N'0987654321')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [gioiTinh], [ngaySinh], [diaChi], [email], [soDienThoai]) VALUES (N'NV002     ', N'Trần Thị B', 0, CAST(N'1995-05-05' AS Date), N'Hồ Chí Minh', N'ttb@gmail.com                 ', N'0123456789')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [gioiTinh], [ngaySinh], [diaChi], [email], [soDienThoai]) VALUES (N'NV003     ', N'Lê Văn C', 1, CAST(N'1985-11-11' AS Date), N'Đà Nẵng', N'lvc@gmail.com                 ', N'0912345678')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [gioiTinh], [ngaySinh], [diaChi], [email], [soDienThoai]) VALUES (N'NV004     ', N'Phạm Thị D', 0, CAST(N'1992-02-02' AS Date), N'Hải Phòng', N'ptd@gmail.com                 ', N'0976543210')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [gioiTinh], [ngaySinh], [diaChi], [email], [soDienThoai]) VALUES (N'NV005     ', N'Vũ Văn E', 1, CAST(N'1988-08-08' AS Date), N'Bình Dương', N'vve@gmail.com                 ', N'0901234567')
GO
INSERT [dbo].[TaiKhoan] ([maTaiKhoan], [maDangNhap], [matKhau], [maNhanVien]) VALUES (N'TK001     ', N'user01                                                                                              ', N'password01                                                                                          ', N'NV001     ')
INSERT [dbo].[TaiKhoan] ([maTaiKhoan], [maDangNhap], [matKhau], [maNhanVien]) VALUES (N'TK002     ', N'user02                                                                                              ', N'password02                                                                                          ', N'NV002     ')
INSERT [dbo].[TaiKhoan] ([maTaiKhoan], [maDangNhap], [matKhau], [maNhanVien]) VALUES (N'TK003     ', N'user03                                                                                              ', N'password03                                                                                          ', N'NV003     ')
INSERT [dbo].[TaiKhoan] ([maTaiKhoan], [maDangNhap], [matKhau], [maNhanVien]) VALUES (N'TK004     ', N'user04                                                                                              ', N'password04                                                                                          ', N'NV004     ')
INSERT [dbo].[TaiKhoan] ([maTaiKhoan], [maDangNhap], [matKhau], [maNhanVien]) VALUES (N'TK005     ', N'user05                                                                                              ', N'password05                                                                                          ', N'NV005     ')
GO
INSERT [dbo].[TourDuLich] ([maTour], [tenTour], [moTa], [ngayDi], [noiDi], [soNgayDuKien], [giaTour], [trangThaiTour], [maDiaDanh]) VALUES (N'TDL001    ', N'Tour Phú Qu?c', N'Tour du l?ch 3 ngày 2 dêm t?i Phú Qu?c', CAST(N'2023-05-01' AS Date), N'Hà N?i', 3, 5000000, 1, N'DD001     ')
INSERT [dbo].[TourDuLich] ([maTour], [tenTour], [moTa], [ngayDi], [noiDi], [soNgayDuKien], [giaTour], [trangThaiTour], [maDiaDanh]) VALUES (N'TDL002    ', N'Tour H?i An', N'Tour du l?ch 2 ngày 1 dêm t?i H?i An', CAST(N'2023-06-15' AS Date), N'H? Chí Minh', 2, 3000000, 0, N'DD002     ')
INSERT [dbo].[TourDuLich] ([maTour], [tenTour], [moTa], [ngayDi], [noiDi], [soNgayDuKien], [giaTour], [trangThaiTour], [maDiaDanh]) VALUES (N'TDL003    ', N'Tour Ðà L?t', N'Tour du l?ch 4 ngày 3 dêm t?i Ðà L?t', CAST(N'2023-07-20' AS Date), N'Hà N?i', 4, 8000000, 1, N'DD003     ')
INSERT [dbo].[TourDuLich] ([maTour], [tenTour], [moTa], [ngayDi], [noiDi], [soNgayDuKien], [giaTour], [trangThaiTour], [maDiaDanh]) VALUES (N'TDL004    ', N'Tour Vung Tàu', N'Tour du l?ch 2 ngày 1 dêm t?i Vung Tàu', CAST(N'2023-08-05' AS Date), N'H? Chí Minh', 2, 2500000, 0, N'DD004     ')
INSERT [dbo].[TourDuLich] ([maTour], [tenTour], [moTa], [ngayDi], [noiDi], [soNgayDuKien], [giaTour], [trangThaiTour], [maDiaDanh]) VALUES (N'TDL005    ', N'Tour H? Long', N'Tour du l?ch 3 ngày 2 dêm t?i H? Long', CAST(N'2023-09-10' AS Date), N'Hà N?i', 3, 6000000, 1, N'DD005     ')
INSERT [dbo].[TourDuLich] ([maTour], [tenTour], [moTa], [ngayDi], [noiDi], [soNgayDuKien], [giaTour], [trangThaiTour], [maDiaDanh]) VALUES (N'test      ', N'test', N'test', CAST(N'2023-04-21' AS Date), N'test', 1, 1, 0, N'DD001     ')
INSERT [dbo].[TourDuLich] ([maTour], [tenTour], [moTa], [ngayDi], [noiDi], [soNgayDuKien], [giaTour], [trangThaiTour], [maDiaDanh]) VALUES (N'test00    ', N'test', N'test', CAST(N'2023-04-21' AS Date), N'test', 1, 1, 0, N'DD001     ')
INSERT [dbo].[TourDuLich] ([maTour], [tenTour], [moTa], [ngayDi], [noiDi], [soNgayDuKien], [giaTour], [trangThaiTour], [maDiaDanh]) VALUES (N'test03    ', N'test', N'test', CAST(N'2023-04-21' AS Date), N'test', 1, 1, 0, N'DD001     ')
INSERT [dbo].[TourDuLich] ([maTour], [tenTour], [moTa], [ngayDi], [noiDi], [soNgayDuKien], [giaTour], [trangThaiTour], [maDiaDanh]) VALUES (N'test1     ', N'test', N'test', CAST(N'2023-04-21' AS Date), N'test', 1, 1, 0, N'DD001     ')
INSERT [dbo].[TourDuLich] ([maTour], [tenTour], [moTa], [ngayDi], [noiDi], [soNgayDuKien], [giaTour], [trangThaiTour], [maDiaDanh]) VALUES (N'test111   ', N'test success', N'test', CAST(N'2023-04-22' AS Date), N'test', 1, 1, 0, N'DD001     ')
INSERT [dbo].[TourDuLich] ([maTour], [tenTour], [moTa], [ngayDi], [noiDi], [soNgayDuKien], [giaTour], [trangThaiTour], [maDiaDanh]) VALUES (N'test1111  ', N'test', N'test', CAST(N'2023-04-21' AS Date), N'test', 1, 1, 0, N'DD001     ')
GO
INSERT [dbo].[VeTour] ([maVe], [maKhachHang]) VALUES (N'VT001     ', N'KH001     ')
INSERT [dbo].[VeTour] ([maVe], [maKhachHang]) VALUES (N'VT002     ', N'KH002     ')
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
ALTER TABLE [dbo].[KhachHang]  WITH CHECK ADD  CONSTRAINT [FK_KhachHang_DichVu] FOREIGN KEY([maDichVu])
REFERENCES [dbo].[DichVu] ([maDichVu])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[KhachHang] CHECK CONSTRAINT [FK_KhachHang_DichVu]
GO
ALTER TABLE [dbo].[KhachHang]  WITH CHECK ADD  CONSTRAINT [FK_KhachHang_TourDuLich] FOREIGN KEY([maTour])
REFERENCES [dbo].[TourDuLich] ([maTour])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[KhachHang] CHECK CONSTRAINT [FK_KhachHang_TourDuLich]
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
ALTER TABLE [dbo].[VeTour]  WITH CHECK ADD  CONSTRAINT [FK_VeTour_KhachHang] FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[VeTour] CHECK CONSTRAINT [FK_VeTour_KhachHang]
GO
USE [master]
GO
ALTER DATABASE [DBQuanLyDuLich] SET  READ_WRITE 
GO
