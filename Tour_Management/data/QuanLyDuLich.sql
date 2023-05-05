USE [master]
GO
/****** Object:  Database [QuanLyDuLich]    Script Date: 5/5/2023 1:04:12 PM ******/
CREATE DATABASE [QuanLyDuLich]
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
/****** Object:  Table [dbo].[DiaDanh]    Script Date: 5/5/2023 1:04:12 PM ******/
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
/****** Object:  Table [dbo].[DichVu]    Script Date: 5/5/2023 1:04:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DichVu](
	[maDichVu] [nchar](10) NOT NULL,
	[phuongTienDiChuyen] [nvarchar](200) NULL,
	[chiTietDichVu] [nvarchar](200) NULL,
	[giaDichVu] [float] NULL,
 CONSTRAINT [PK_DichVu] PRIMARY KEY CLUSTERED 
(
	[maDichVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HopDongTour]    Script Date: 5/5/2023 1:04:12 PM ******/
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
/****** Object:  Table [dbo].[KhachHang]    Script Date: 5/5/2023 1:04:12 PM ******/
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
/****** Object:  Table [dbo].[NhanVien]    Script Date: 5/5/2023 1:04:12 PM ******/
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
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 5/5/2023 1:04:12 PM ******/
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
/****** Object:  Table [dbo].[TourDuLich]    Script Date: 5/5/2023 1:04:12 PM ******/
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
/****** Object:  Table [dbo].[VeTour]    Script Date: 5/5/2023 1:04:12 PM ******/
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
