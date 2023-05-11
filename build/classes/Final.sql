-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 10, 2023 lúc 09:29 AM
-- Phiên bản máy phục vụ: 10.4.27-MariaDB
-- Phiên bản PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `libarymanager`
--
CREATE DATABASE IF NOT EXISTS `libarymanager` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `libarymanager`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `auth`
--

CREATE TABLE `auth` (
  `nhom` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `id_quyen` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `auth`
--

INSERT INTO `auth` (`nhom`, `id_quyen`) VALUES
('ADMIN', 1),
('STAFF', 2),
('NV_KHO', 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `book`
--

CREATE TABLE `book` (
  `isbn` varchar(32) NOT NULL,
  `ten_sach` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `danh_muc` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tac_gia` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `id_nxb` int(11) NOT NULL,
  `tai_ban` int(11) NOT NULL DEFAULT 1,
  `nam_xuatban` date NOT NULL,
  `so_luong` int(11) NOT NULL DEFAULT 1,
  `status` bit(1) NOT NULL DEFAULT b'1'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `book`
--

INSERT INTO `book` (`isbn`, `ten_sach`, `danh_muc`, `tac_gia`, `id_nxb`, `tai_ban`, `nam_xuatban`, `so_luong`, `status`) VALUES
('978-604-346-142-8', 'Hiệu ứng chim mồi', 'tâm lý , kinh doanh', 'hạo nhiên , quốc khách', 7, 1, '2023-01-01', 30, b'1'),
('978-604-356-499-0', 'Hai vạn dặm dưới biển', 'văn học', 'jules verne', 1, 1, '2022-06-02', 30, b'1'),
('978-604-88-6796-6', 'Anh em nhà wright là ai ?', 'tiểu sử ', 'James Buckley Jr., Tim Foley', 1, 1, '2018-09-19', 15, b'1'),
('978-604-314-544-1', 'Leonardo da Vinci là ai ?', 'Văn học', 'Roberta Edwards , True Keylley', 1, 1, '2021-02-23', 40, b'1');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chi_tiet_muontra`
--

CREATE TABLE `chi_tiet_muontra` (
  `id_muontra` int(11) NOT NULL,
  `isbn_book` varchar(32) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chi_tiet_muontra`
--

INSERT INTO `chi_tiet_muontra` (`id_muontra`, `isbn_book`) VALUES
(1, '978-604-314-544-1'),
(1, '978-604-88-6796-6'),
(14, '978-604-88-6796-6'),
(15, '978-604-346-142-8'),
(15, '978-604-356-499-0'),
(15, '978-604-88-6796-6'),
(16, '978-604-314-544-1'),
(16, '978-604-346-142-8'),
(16, '978-604-356-499-0'),
(16, '978-604-88-6796-6'),
(17, '978-604-346-142-8'),
(17, '978-604-356-499-0');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhan_vien`
--

CREATE TABLE `nhan_vien` (
  `id_nv` int(11) NOT NULL,
  `ten_nv` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ngay_sinh` date NOT NULL,
  `phone` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ten_nhom` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` bit(1) NOT NULL DEFAULT b'0'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhan_vien`
--

INSERT INTO `nhan_vien` (`id_nv`, `ten_nv`, `ngay_sinh`, `phone`, `ten_nhom`, `username`, `password`, `status`) VALUES
(1, 'Nguyễn Văn An', '2003-12-17', '0909999999', 'ADMIN', 'admin123', '12345', b'1'),
(2, 'Trần Ngọc Bình', '2001-08-22', '0909999999', 'STAFF', 'binh123', '12345', b'1'),
(3, 'Phan Anh Vũ', '1996-10-10', '0909999999', 'STAFF', 'vu123', '12345', b'1'),
(4, 'Hồ Thị Vui', '2001-11-11', '0999999999', 'NV_KHO', 'vui123', '12345', b'1'),
(5, 'Luân Nguyễn ', '2023-05-23', '123456789', 'ADMIN', 'Luan12345', '123456', b'1');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nxb`
--

CREATE TABLE `nxb` (
  `id_nxb` int(11) NOT NULL,
  `ten_nxb` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dia_chi` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nxb`
--

INSERT INTO `nxb` (`id_nxb`, `ten_nxb`, `dia_chi`, `email`) VALUES
(1, 'NXB DÂN TRÍ', 'QUẬN ĐỐNG ĐA HÀ NỘI', 'nxbdantri@gmail.com'),
(2, 'NXB LAO ĐỘNG', '175 GIẢNG VÕ HÀ NỘI', 'info@nxblaodong.com.vn'),
(5, 'NXB KIM ĐỒNG', '55 Quang Trung, Hà Nội', 'info@nxbkimdong.com.vn'),
(7, 'NXB KINH TẾ', '279 NGUYỄN TRI PHƯƠNG P5 Q10 TP.HCM', 'nxb@euh.edu.vn'),
(6, 'NXB HỘI NHÀ VĂN', 'HAI BÀ TRƯNG Q3 TPHCM', 'nxbhoinhavan@yahoo.com.vn'),
(9, 'NXB THẾ GIỚI', 'NGUYỄN THỊ MINH KHAI Q1 TPHCM', 'nxbthegioi@gmail.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieu_muontra`
--

CREATE TABLE `phieu_muontra` (
  `id` int(11) NOT NULL,
  `id_the` int(11) NOT NULL,
  `id_nv` int(11) NOT NULL,
  `ngay_tao` date NOT NULL,
  `desc` text CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` bit(1) NOT NULL DEFAULT b'0',
  `ngay_tra` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phieu_muontra`
--

INSERT INTO `phieu_muontra` (`id`, `id_the`, `id_nv`, `ngay_tao`, `desc`, `status`, `ngay_tra`) VALUES
(1, 1, 2, '2023-05-19', 'ok', b'1', '2023-05-20'),
(14, 3, 1, '2023-05-09', 'ok', b'1', '2023-05-19'),
(17, 1, 1, '2023-05-10', 'test', b'1', '2023-05-18'),
(16, 1, 1, '2023-05-10', 'test', b'1', '2023-05-11');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `quyen`
--

CREATE TABLE `quyen` (
  `id_quyen` int(11) NOT NULL,
  `crud_user` bit(1) NOT NULL DEFAULT b'0',
  `crud_book` bit(1) NOT NULL DEFAULT b'0',
  `crud_nxb` bit(1) NOT NULL DEFAULT b'0',
  `crud_quyen` bit(1) NOT NULL DEFAULT b'0',
  `crud_thethuvien` bit(1) NOT NULL DEFAULT b'0',
  `crud_muontra` bit(1) NOT NULL DEFAULT b'0'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `quyen`
--

INSERT INTO `quyen` (`id_quyen`, `crud_user`, `crud_book`, `crud_nxb`, `crud_quyen`, `crud_thethuvien`, `crud_muontra`) VALUES
(1, b'1', b'1', b'1', b'1', b'1', b'1'),
(2, b'0', b'1', b'1', b'0', b'0', b'1'),
(3, b'0', b'1', b'1', b'0', b'0', b'0');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `the_thuvien`
--

CREATE TABLE `the_thuvien` (
  `id_the` int(11) NOT NULL,
  `ngay_tao` date NOT NULL,
  `ngay_hethan` date NOT NULL,
  `desc` text CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ten_docgia` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `the_thuvien`
--

INSERT INTO `the_thuvien` (`id_the`, `ngay_tao`, `ngay_hethan`, `desc`, `ten_docgia`, `phone`) VALUES
(1, '2023-05-08', '2023-11-16', 'ok', 'Nguyễn Hoàng Luân', '09999999'),
(3, '2023-05-08', '2023-09-05', 'thoing', 'Luân Nguyễn', '09999999'),
(6, '2023-05-10', '2023-05-11', 'nothing', 'Trúc Anh Đài', '09999999'),
(8, '2023-05-10', '2023-05-11', 'nothing', 'Lưu Sơn Bá', '093309099');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `auth`
--
ALTER TABLE `auth`
  ADD PRIMARY KEY (`nhom`),
  ADD UNIQUE KEY `nhom` (`nhom`),
  ADD KEY `FK_ROLEAUTH` (`id_quyen`);

--
-- Chỉ mục cho bảng `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`isbn`),
  ADD KEY `fk_book_nxb` (`id_nxb`);

--
-- Chỉ mục cho bảng `chi_tiet_muontra`
--
ALTER TABLE `chi_tiet_muontra`
  ADD PRIMARY KEY (`id_muontra`,`isbn_book`),
  ADD KEY `fk_chitietmuontra_sach` (`isbn_book`);

--
-- Chỉ mục cho bảng `nhan_vien`
--
ALTER TABLE `nhan_vien`
  ADD PRIMARY KEY (`id_nv`),
  ADD UNIQUE KEY `username` (`username`),
  ADD KEY `FK_STAFFAUTH` (`ten_nhom`);

--
-- Chỉ mục cho bảng `nxb`
--
ALTER TABLE `nxb`
  ADD PRIMARY KEY (`id_nxb`);

--
-- Chỉ mục cho bảng `phieu_muontra`
--
ALTER TABLE `phieu_muontra`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_STAFFORDER` (`id_nv`),
  ADD KEY `FK_CARDOREDER` (`id_the`);

--
-- Chỉ mục cho bảng `quyen`
--
ALTER TABLE `quyen`
  ADD PRIMARY KEY (`id_quyen`);

--
-- Chỉ mục cho bảng `the_thuvien`
--
ALTER TABLE `the_thuvien`
  ADD PRIMARY KEY (`id_the`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `nhan_vien`
--
ALTER TABLE `nhan_vien`
  MODIFY `id_nv` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `nxb`
--
ALTER TABLE `nxb`
  MODIFY `id_nxb` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `phieu_muontra`
--
ALTER TABLE `phieu_muontra`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT cho bảng `quyen`
--
ALTER TABLE `quyen`
  MODIFY `id_quyen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `the_thuvien`
--
ALTER TABLE `the_thuvien`
  MODIFY `id_the` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
