USE [MASTER]
GO

Create database [QuanLyDuLich]
GO

USE [QuanLyDuLich]
GO
/****** Object:  Table [dbo].[DiaDanh]    Script Date: 5/5/2023 1:18:30 PM ******/
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
/****** Object:  Table [dbo].[DichVu]    Script Date: 5/5/2023 1:18:30 PM ******/
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
/****** Object:  Table [dbo].[HopDongTour]    Script Date: 5/5/2023 1:18:30 PM ******/
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
/****** Object:  Table [dbo].[KhachHang]    Script Date: 5/5/2023 1:18:30 PM ******/
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
/****** Object:  Table [dbo].[NhanVien]    Script Date: 5/5/2023 1:18:30 PM ******/
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
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 5/5/2023 1:18:30 PM ******/
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
/****** Object:  Table [dbo].[TourDuLich]    Script Date: 5/5/2023 1:18:30 PM ******/
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
/****** Object:  Table [dbo].[VeTour]    Script Date: 5/5/2023 1:18:30 PM ******/
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
GO
INSERT [dbo].[DichVu] ([maDichVu], [phuongTienDiChuyen], [chiTietDichVu], [giaDichVu]) VALUES (N'DV001     ', N'Xe đạp', N'Cho thuê xe đạp tại địa điểm A', 50000)
INSERT [dbo].[DichVu] ([maDichVu], [phuongTienDiChuyen], [chiTietDichVu], [giaDichVu]) VALUES (N'DV002     ', N'Xe ô tô', N'Thuê 48 giờ', 5000000)
INSERT [dbo].[DichVu] ([maDichVu], [phuongTienDiChuyen], [chiTietDichVu], [giaDichVu]) VALUES (N'DV003     ', N'Tàu hỏa', N'Vé đi 2 chiều', 300000)
INSERT [dbo].[DichVu] ([maDichVu], [phuongTienDiChuyen], [chiTietDichVu], [giaDichVu]) VALUES (N'DV004     ', N'Máy bay', N'Vé đi 2 chiều', 3000000)
INSERT [dbo].[DichVu] ([maDichVu], [phuongTienDiChuyen], [chiTietDichVu], [giaDichVu]) VALUES (N'DV005     ', N'Tàu cao tốc', N'Vé đi 2 chiều', 600000)
GO
INSERT [dbo].[HopDongTour] ([maHopDong], [thoiGianLap], [ghiChu], [tongTien], [maNhanVien], [maKhachHang], [maTour], [maDichVu]) VALUES (N'HD001     ', CAST(N'2023-05-05' AS Date), N'', 13000000, N'NV002     ', N'KH002     ', N'TDL004    ', N'DV002     ')
INSERT [dbo].[HopDongTour] ([maHopDong], [thoiGianLap], [ghiChu], [tongTien], [maNhanVien], [maKhachHang], [maTour], [maDichVu]) VALUES (N'HD002     ', CAST(N'2023-05-05' AS Date), N'2 em mi nơ và khách sạn phòng có 2 ghế tình yêu', 3550000, N'NV001     ', N'KH004     ', N'TDL002    ', N'DV001     ')
GO
INSERT [dbo].[KhachHang] ([maKhachHang], [soCCCD_HC], [tenKhachHang], [gioiTinh], [ngaySinh], [email], [soDienThoai]) VALUES (N'KH001     ', N'096203000820  ', N'Lê Hoàng Nam', 1, CAST(N'2003-01-31' AS Date), N'lehoangnam.31123@gmail.com                        ', N'0858484522     ')
INSERT [dbo].[KhachHang] ([maKhachHang], [soCCCD_HC], [tenKhachHang], [gioiTinh], [ngaySinh], [email], [soDienThoai]) VALUES (N'KH002     ', N'051203000318  ', N'Lê Minh Bảo', 1, CAST(N'2003-08-03' AS Date), N'leminhbao.iuh@gmail.com                           ', N'0399405711     ')
INSERT [dbo].[KhachHang] ([maKhachHang], [soCCCD_HC], [tenKhachHang], [gioiTinh], [ngaySinh], [email], [soDienThoai]) VALUES (N'KH003     ', N'096503349566  ', N'Phạm nhật LinH', 1, CAST(N'2019-05-18' AS Date), N'linhpham@gmail.com                                ', N'0858484546     ')
INSERT [dbo].[KhachHang] ([maKhachHang], [soCCCD_HC], [tenKhachHang], [gioiTinh], [ngaySinh], [email], [soDienThoai]) VALUES (N'KH004     ', N'030316612345  ', N'Trần Vinh Tỷ Tỷ', 0, CAST(N'2000-07-31' AS Date), N'vinhtyty@gmail.com                                ', N'0966061611     ')
GO
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [gioiTinh], [ngaySinh], [diaChi], [email], [soDienThoai], [chucVu]) VALUES (N'NV001     ', N'Lê Minh Bảo', 1, CAST(N'2003-08-03' AS Date), N'Nguyễn Văn Khối, Gò Vấp, HCM', N'leminhbao.iuh@gmail.com                           ', N'0399405711     ', N'Quản lý kinh doanh')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [gioiTinh], [ngaySinh], [diaChi], [email], [soDienThoai], [chucVu]) VALUES (N'NV002     ', N'Lê Hoàng Nam', 1, CAST(N'2003-01-31' AS Date), N'835 Nguyễn Kiệm, Gò Vấp, HCm', N'lehoangnam.31123@gmail.com                        ', N'0858484522     ', N'Quản lý kinh doanh')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [gioiTinh], [ngaySinh], [diaChi], [email], [soDienThoai], [chucVu]) VALUES (N'NV003     ', N'Phạm Nhật Linh', 1, CAST(N'2002-05-28' AS Date), N'Gò Vấp, HCM', N'nhatlinh.2003@gmail.com                           ', N'0862538733     ', N'Quản lý kinh doanh')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [gioiTinh], [ngaySinh], [diaChi], [email], [soDienThoai], [chucVu]) VALUES (N'NV004     ', N'Trần Hiển Vinh', 1, CAST(N'2003-05-31' AS Date), N'Gò Vấp, HCM', N'vinhtran@gmail.com                                ', N'0963005233     ', N'Nhân viên bán hàng')
GO
INSERT [dbo].[TaiKhoan] ([maNhanVien], [matKhau]) VALUES (N'NV001     ', N'$2a$10$CbqiI.9IKXRv00yEGmjKlOszbaodXMJKf5LlmSG3bUFvQqr.9gWaG                                        ')
INSERT [dbo].[TaiKhoan] ([maNhanVien], [matKhau]) VALUES (N'NV002     ', N'$2a$10$qX8PRnjdi3n0wAYZQ6.ozujZkBHPaO7KTNe5YazOon/4XLMfEm6Ce                                        ')
INSERT [dbo].[TaiKhoan] ([maNhanVien], [matKhau]) VALUES (N'NV003     ', N'$2a$10$ssmeytW1lc.qMQ1ECQYzMOwvnn7G2UDpvDaLHmpKc8HWbX90v2/hG                                        ')
INSERT [dbo].[TaiKhoan] ([maNhanVien], [matKhau]) VALUES (N'NV004     ', N'$2a$10$qqeqRYZoigbkCpr3UyKYC.s2D4amlFI.uHl2Jl8jY3aBT/V0ZY0xi                                        ')
GO
INSERT [dbo].[TourDuLich] ([maTour], [tenTour], [moTa], [ngayDi], [noiDi], [soNgayDuKien], [giaTour], [trangThaiTour], [maDiaDanh]) VALUES (N'TDL001    ', N'Tour Hạ Long 3 ngày 2 đêm', N'Khám phá vịnh Hạ Long tuyệt đẹp', CAST(N'2023-06-10' AS Date), N'Hà Nội', 3, 4500000, 1, N'DD001     ')
INSERT [dbo].[TourDuLich] ([maTour], [tenTour], [moTa], [ngayDi], [noiDi], [soNgayDuKien], [giaTour], [trangThaiTour], [maDiaDanh]) VALUES (N'TDL002    ', N'Tour Đà Nẵng 2 ngày 1 đêm', N'Khám phá vùng đất Đà Nẵng', CAST(N'2023-07-03' AS Date), N'An Giang', 2, 3500000, 0, N'DD002     ')
INSERT [dbo].[TourDuLich] ([maTour], [tenTour], [moTa], [ngayDi], [noiDi], [soNgayDuKien], [giaTour], [trangThaiTour], [maDiaDanh]) VALUES (N'TDL003    ', N'Tour Phú Quốc 4 ngày 3 đêm', N'Thư giãn trên bãi biển Phú Quốc', CAST(N'2023-08-20' AS Date), N'Hồ Chí Minh', 4, 6000000, 1, N'DD003     ')
INSERT [dbo].[TourDuLich] ([maTour], [tenTour], [moTa], [ngayDi], [noiDi], [soNgayDuKien], [giaTour], [trangThaiTour], [maDiaDanh]) VALUES (N'TDL004    ', N'Tour Huế - Hội An 5 ngày 4 đêm', N'Thăm quan các di tích lịch sử', CAST(N'2023-09-15' AS Date), N'Đà Nẵng', 5, 8000000, 1, N'DD004     ')
GO
INSERT [dbo].[VeTour] ([maVe], [maHopDong]) VALUES (N'VT001     ', N'HD001     ')
INSERT [dbo].[VeTour] ([maVe], [maHopDong]) VALUES (N'VT002     ', N'HD002     ')
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
