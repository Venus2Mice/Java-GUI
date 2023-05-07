CREATE DATABASE LibaryManager;
USE LibaryManager;

CREATE TABLE `nxb`
(
	`id_nxb` INT AUTO_INCREMENT,
	`ten_nxb` varchar(32) CHARACTER SET utf8 NOT NULL,
	`dia_chi` text CHARACTER SET utf8 NOT NULL,
	`email` text CHARACTER SET utf8 NOT NULL,
	PRIMARY KEY (`id_nxb`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
INSERT INTO `nxb` (`ten_nxb`, `dia_chi`, `email`) VALUES
('NXB DÂN TRÍ','QUẬN ĐỐNG ĐA HÀ NỘI','nxbdantri@gmail.com');



CREATE TABLE `quyen`
(
	`id_quyen` INT AUTO_INCREMENT,
	`crud_user` BIT NOT NULL DEFAULT 0,
	`crud_book` BIT NOT NULL DEFAULT 0,
	`crud_nxb` BIT NOT NULL DEFAULT 0,
	`crud_quyen` BIT NOT NULL DEFAULT 0,
	`crud_thethuvien` BIT NOT NULL DEFAULT 0,
	`curd_muontra` BIT NOT NULL DEFAULT 0,
    PRIMARY KEY (`id_quyen`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `book`
(
	`isbn` VARCHAR(32) ,
	`ten_sach` text CHARACTER SET utf8 NOT NULL ,
	`danh_muc` text CHARACTER SET utf8 NOT NULL ,
	`tac_gia` varchar(32) CHARACTER SET utf8 NOT NULL ,
	`id_nxb` INT NOT NULL ,
	`tai_ban` INT NOT NULL DEFAULT 1,
	`nam_xuatban` DATE NOT NULL,
	`so_luong` INT NOT NULL DEFAULT 1,
	`status` BIT NOT NULL DEFAULT 1,
	PRIMARY KEY (`isbn`),
	CONSTRAINT `fk_book_nxb` FOREIGN KEY (`id_nxb`) REFERENCES `nxb`(`id_nxb`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `auth`
(
	`nhom` varchar(32) CHARACTER SET utf8 ,
	`id_quyen` INT NOT NULL,
	PRIMARY KEY (`nhom`),
	CONSTRAINT `FK_ROLEAUTH` FOREIGN KEY (`id_quyen`) REFERENCES `quyen`(`id_quyen`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `nhan_vien`
(
	`id_nv` INT AUTO_INCREMENT,
	`ten_nv` varchar(32) CHARACTER SET utf8 NOT NULL,
	`ngay_sinh` DATE NOT NULL,
	`phone` varchar(32) CHARACTER SET utf8 NOT NULL,
	`ten_nhom` varchar(32) CHARACTER SET utf8 NOT NULL ,
	`username` varchar(32) CHARACTER SET utf8 NOT NULL,
	`password` varchar(32) CHARACTER SET utf8 NOT NULL,
	`status` BIT NOT NULL DEFAULT 0,
	PRIMARY KEY (`id_nv`),
	CONSTRAINT `FK_STAFFAUTH` FOREIGN KEY (`ten_nhom`) REFERENCES `auth`(`nhom`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `nhan_vien` (`id_nv`, `ten_nv`, `ngay_sinh`, `phone`, `ten_nhom`, `username`, `password`, `status`) VALUES
(1,'Nguyễn Văn An','2000-11-11','0909999999','admin','admin123','12345','1'),
(2,'Trần Ngọc Bình','1999-11-11','0909999999','staff','binh123','12345','1'),
(3,'Phan Anh Vũ','2003-11-11','0909999999','staff','vu123','12345','1'),
(4,'Hồ Thị Vui','2001-11-11','0909999999','manager','vui123','12345','1');

CREATE TABLE `the_thuvien`
(
	`id_the` INT AUTO_INCREMENT,
	`ngay_tao` DATE NOT NULL,
	`ngay_hethan` DATE NOT NULL,
	`desc` text CHARACTER SET utf8 ,
	`ten_docgia` varchar(32) CHARACTER SET utf8 NOT NULL,
	`phone` INT(11) NOT NULL,
	PRIMARY KEY (`id_the`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `phieu_muontra`
(
	`id` INT AUTO_INCREMENT,
	`id_the` INT NOT NULL,
	`id_nv` INT NOT NULL,
	`ngay_tao` DATE NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `FK_STAFFORDER` FOREIGN KEY (`id_nv`) REFERENCES `nhan_vien`(`id_nv`),
	CONSTRAINT `FK_CARDOREDER` FOREIGN KEY (`id_the`) REFERENCES `the_thuvien`(`id_the`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `chi_tiet_muontra`
(
	`id_muontra` INT NOT NULL,
	`isbn_book` VARCHAR(32) NOT NULL,
	`desc` text CHARACTER SET utf8,
	`status` BIT NOT NULL DEFAULT 0,
	`ngay_tra` DATE ,
	CONSTRAINT `pk_chitiet_muontra` PRIMARY KEY (`id_muontra`,`isbn_book`),
	CONSTRAINT `fk_chitietmuontra_phieumuontra` FOREIGN KEY (`id_muontra`) REFERENCES `phieu_muontra`(`id`),
	CONSTRAINT `fk_chitietmuontra_sach` FOREIGN KEY (`isbn_book`) REFERENCES `book`(`isbn`)

) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

ALTER TABLE `nxb` AUTO_INCREMENT =1;

ALTER TABLE `quyen` AUTO_INCREMENT =1;

ALTER TABLE `nhan_vien` AUTO_INCREMENT =1;

ALTER TABLE `the_thuvien` AUTO_INCREMENT =1;

ALTER TABLE `phieu_muontra` AUTO_INCREMENT =1;


