INSERT INTO [dbo].[HopDongTour]
           ([maHopDong]
           ,[thoiGianLap]
           ,[ghiChu]
           ,[tongTien]
           ,[maNhanVien]
           ,[maKhachHang]
           ,[maTour]
           ,[maDichVu])
     VALUES
           ('HD004'
           ,'2023-05-02'
           ,N'Yêu cầu đặt phòng vip khách sạn gần nhất'
           ,(SELECT giaTour + giaDichVu FROM TourDuLich t, DichVu d WHERE t.maTour = 'TDL004' AND d.maDichVu = 'DV001')
           ,'NV002'
           ,'KH004'
           ,'TDL004'
           ,'DV001')
