-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 13 Jun 2019 pada 10.21
-- Versi Server: 10.1.19-MariaDB
-- PHP Version: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sim`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `access_emp`
--

CREATE TABLE `access_emp` (
  `id` varchar(10) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `isdelete` enum('false','true') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `access_emp`
--

INSERT INTO `access_emp` (`id`, `name`, `isdelete`) VALUES
('Po', 'Dont know ya', 'true');

-- --------------------------------------------------------

--
-- Struktur dari tabel `access_of_emp`
--

CREATE TABLE `access_of_emp` (
  `id` varchar(10) NOT NULL,
  `employeeid` int(10) NOT NULL,
  `accessid` varchar(10) NOT NULL,
  `isdelete` enum('false','true') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `address`
--

CREATE TABLE `address` (
  `id` int(5) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `subdistrictid` varchar(10) NOT NULL,
  `isdelete` enum('false','true') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `address`
--

INSERT INTO `address` (`id`, `name`, `subdistrictid`, `isdelete`) VALUES
(4, 'Jalan kaliuranga', 'CC', 'false'),
(5, 'Jalan Pandega Marta', 'CC', 'false'),
(6, 'Jalan Sehat', 'CC', 'false'),
(7, 'Jalan Tanjung ', 'CB', 'false'),
(8, 'Jalan cibu', 'CB', 'true'),
(9, 'hinduu', 'CC', 'true');

-- --------------------------------------------------------

--
-- Struktur dari tabel `app_role`
--

CREATE TABLE `app_role` (
  `ROLE_ID` int(11) NOT NULL,
  `ROLE_NAME` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `app_role`
--

INSERT INTO `app_role` (`ROLE_ID`, `ROLE_NAME`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Struktur dari tabel `app_user`
--

CREATE TABLE `app_user` (
  `USER_ID` int(11) NOT NULL,
  `USER_NAME` varchar(36) NOT NULL,
  `ENCRYTED_PASSWORD` varchar(128) NOT NULL,
  `ENABLED` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `app_user`
--

INSERT INTO `app_user` (`USER_ID`, `USER_NAME`, `ENCRYTED_PASSWORD`, `ENABLED`) VALUES
(1, 'dbadmin1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1),
(2, 'dbuser1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `asset`
--

CREATE TABLE `asset` (
  `id` varchar(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `total` int(10) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `unitPrice` int(10) DEFAULT NULL,
  `category_id` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `auth_user`
--

CREATE TABLE `auth_user` (
  `id` int(10) NOT NULL,
  `employeeid` int(10) NOT NULL,
  `roleid` int(10) NOT NULL,
  `isdelete` enum('false','true') NOT NULL,
  `lastupdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `auth_user`
--

INSERT INTO `auth_user` (`id`, `employeeid`, `roleid`, `isdelete`, `lastupdate`) VALUES
(1, 8, 1, 'false', '2019-06-10 09:38:27'),
(2, 13, 2, 'false', '2019-06-11 07:35:55');

-- --------------------------------------------------------

--
-- Struktur dari tabel `category`
--

CREATE TABLE `category` (
  `id` varchar(10) NOT NULL,
  `type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `confirmation_token`
--

CREATE TABLE `confirmation_token` (
  `token_id` int(10) NOT NULL,
  `confirmation_token` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `employeeid` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `confirmation_token`
--

INSERT INTO `confirmation_token` (`token_id`, `confirmation_token`, `created_date`, `employeeid`) VALUES
(1, '920bcc34-9812-4340-b520-c6ae2027296e', '2019-06-13 00:37:58', 13),
(2, 'bd0260f3-e2f0-4545-b79f-8c570210cc89', '2019-06-13 01:43:40', 13),
(3, 'a5848d84-6e6c-48c4-91df-be75029f83ff', '2019-06-13 08:28:29', 13),
(4, '8fc6a8d4-6746-4388-860a-1fc09904591f', '2019-06-13 08:29:04', 13),
(5, '68fd3c63-2eee-421a-a1b8-7ecfccc101ea', '2019-06-13 09:49:57', 13);

-- --------------------------------------------------------

--
-- Struktur dari tabel `department`
--

CREATE TABLE `department` (
  `id` varchar(10) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `manager_id` int(10) DEFAULT NULL,
  `isdelete` enum('false','true') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `department`
--

INSERT INTO `department` (`id`, `name`, `manager_id`, `isdelete`) VALUES
('AD', 'Application Development', 12, 'false'),
('F', 'Finance', 15, 'false'),
('T', 'Technology', 16, 'false');

-- --------------------------------------------------------

--
-- Struktur dari tabel `detail_asset`
--

CREATE TABLE `detail_asset` (
  `id` varchar(10) NOT NULL,
  `detailName` varchar(50) DEFAULT NULL,
  `asset` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `district`
--

CREATE TABLE `district` (
  `id` varchar(10) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `provinceid` varchar(10) NOT NULL,
  `isdelete` enum('false','true') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `district`
--

INSERT INTO `district` (`id`, `name`, `provinceid`, `isdelete`) VALUES
('AA', 'Amanah', 'DKI', 'false'),
('Bantul', 'BA', 'DIY', 'true'),
('DD', 'Cobaa', 'DKI', 'true'),
('Jakbar', 'Jakarta Barat', 'DKI', 'false'),
('Jakpus', 'Jakarta Pusat', 'DKI', 'false'),
('Jaktim', 'Jakarta timur', 'DKI', 'false'),
('Jakut', 'Jakarta Utara', 'DKI', 'false'),
('KK', 'Kali Kuningan', 'DIY', 'true'),
('KM', 'Kali Meraho', 'JTG', 'true'),
('KP', 'Kulon Progo', 'DIY', 'false'),
('Pekalongan', 'PKL', 'JTG', 'true'),
('PKL', 'Pekalongan', 'JTG', 'false'),
('SL', 'Sleman', 'DIY', 'false'),
('wq', 'hinduuh', 'DKI', 'true'),
('YK', 'Yogyakarta', 'DIY', 'false');

-- --------------------------------------------------------

--
-- Struktur dari tabel `employee`
--

CREATE TABLE `employee` (
  `id` int(10) NOT NULL,
  `firstname` varchar(30) DEFAULT NULL,
  `lastname` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `dateofbirth` date DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `password` varchar(80) DEFAULT NULL,
  `job_id` varchar(10) NOT NULL,
  `address_id` int(5) DEFAULT NULL,
  `religion_id` varchar(10) DEFAULT NULL,
  `manager_id` int(10) DEFAULT NULL,
  `department_id` varchar(10) DEFAULT NULL,
  `isdelete` enum('false','true') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `employee`
--

INSERT INTO `employee` (`id`, `firstname`, `lastname`, `email`, `dateofbirth`, `hiredate`, `password`, `job_id`, `address_id`, `religion_id`, `manager_id`, `department_id`, `isdelete`) VALUES
(7, 'Rose', 'Park', 'senyawa2@gmail.com', '1996-01-01', '2007-12-31', 'goldengoal', 'IT', 4, 'is', 16, 'T', 'false'),
(8, 'Rose', 'Johansson', 'senyawa10@gmail.com', '1996-12-30', '1996-12-30', '$2a$10$zKepPJbVHojfNdUWkCEMVuj0XUW5S5h4ycr9FpWybCGE54NKX9KWS', 'Sa', 5, 'hi', 12, 'AD', 'false'),
(9, 'Mawar', 'Scarlet', 'senyawa4@gmail.com', '1996-10-12', '2010-10-12', 'senyawamawar', 'Ac', 5, 'kr', 15, 'T', 'false'),
(10, 'Luna', 'Lovegood', 'senyawa3@gmail.com', '1996-10-12', '2010-10-12', 'senyawaaaa', 'IT', 6, 'bu', 16, 'T', 'false'),
(11, 'Malaikat', 'Maut', 'malaikat@yahoo.co.id', '1996-01-01', '1997-12-29', 'senyawaprisa', 'IT', 6, 'hi', 16, 'T', 'false'),
(12, 'Falala', 'Bitariy', 'fala@gmail.com', '1996-10-01', '1996-10-01', 'senyawafala', 'Sa', 4, 'kr', 12, 'AD', 'false'),
(13, 'Lalisa', 'Lee', 'rossa.hening.w@mail.ugm.ac.id', '1996-01-01', '1996-01-01', '$2a$10$zzZQGXhN7zCLbInI7XcUw.UJ94fGdVDDygyBTvNh3ADiyxjWL9dBC', 'Ac', 6, 'hi', 15, 'F', 'false'),
(14, 'Rahmad', 'Bieber', 'senyawa0@gmail.com', '1996-10-12', '1996-01-01', 'goldencloset', 'IT', 4, 'is', 16, 'T', 'false'),
(15, 'Uki', 'Maut', 'senyawa100@gmail.com', '1996-10-12', '1996-10-12', 'senyawauki', 'Ac', 5, 'is', 15, 'F', 'false'),
(16, 'Rahmad', 'Subekti', 'senyawa100000@gmail.com', '1996-10-12', '2008-10-12', 'goldengoalooo', 'IT', 7, 'is', 16, 'T', 'false');

-- --------------------------------------------------------

--
-- Struktur dari tabel `job`
--

CREATE TABLE `job` (
  `id` varchar(10) NOT NULL,
  `jobtitle` varchar(30) DEFAULT NULL,
  `isdelete` enum('false','true') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `job`
--

INSERT INTO `job` (`id`, `jobtitle`, `isdelete`) VALUES
('Ac', 'Accountant', 'true'),
('Fi', 'Accountant', 'false'),
('IT', 'Programmer', 'false'),
('QA', NULL, 'true'),
('Sa', 'System Analyst', 'false'),
('ss', 'sayonara', 'false'),
('wq', 'wkwkwkkw', 'false');

-- --------------------------------------------------------

--
-- Struktur dari tabel `persistent_logins`
--

CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `province`
--

CREATE TABLE `province` (
  `id` varchar(10) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `isdelete` enum('false','true') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `province`
--

INSERT INTO `province` (`id`, `name`, `isdelete`) VALUES
('DIY', 'Yogyakarta', 'false'),
('DKI', 'Jakarta', 'false'),
('JTG', 'Jawa Tengah', 'false'),
('yy', 'ayo', 'true');

-- --------------------------------------------------------

--
-- Struktur dari tabel `religion`
--

CREATE TABLE `religion` (
  `id` varchar(10) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `isdelete` enum('false','true') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `religion`
--

INSERT INTO `religion` (`id`, `name`, `isdelete`) VALUES
('ae', 'aet', 'false'),
('aq', 'aqqq', 'true'),
('AT', 'Kerajaan Uburoa', 'true'),
('Att', 'athiessopo', 'true'),
('bb', 'bibi', 'true'),
('bu', 'buddha', 'false'),
('df', 'feee', 'true'),
('hh', 'hehe', 'false'),
('hi', 'hinduu', 'false'),
('id', '', 'true'),
('is', 'islamo', 'false'),
('ka', 'katolikaa', 'false'),
('Kh', 'Katolik', 'false'),
('KK', 'KKKKKss', 'true'),
('KKK', 'KKK', 'true'),
('Kl', 'KongHa', 'true'),
('Ko', 'Kong Hu Cu', 'false'),
('kr', 'kristen', 'false'),
('KS', 'sss', 'true'),
('Lo', 'Lolowlo', 'false'),
('moi', 'momoi', 'false'),
('nao', 'speechless', 'false'),
('ne', 'nnaemo', 'true'),
('ohp', 'khkjhjhkhjhkhk', 'false'),
('ok', 'okejek', 'false'),
('Op', 'owww', 'false'),
('po', 'wwjkdndk', 'false'),
('sd', 'saya', 'false'),
('sq', 'sqlaa', 'false'),
('wb', 'speechless', 'false'),
('wd', 'wendy', 'false'),
('we', 'wewe', 'false'),
('wq', 'loeee', 'false'),
('xxxx', 'jdj', 'false'),
('xxxxx', 'xxxxxxxx', 'false');

-- --------------------------------------------------------

--
-- Struktur dari tabel `role`
--

CREATE TABLE `role` (
  `id` int(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `isdelete` enum('false','true') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `role`
--

INSERT INTO `role` (`id`, `name`, `isdelete`) VALUES
(1, 'ADMIN', 'false'),
(2, 'USER', 'false'),
(3, 'department_head', 'false');

-- --------------------------------------------------------

--
-- Struktur dari tabel `subdistrict`
--

CREATE TABLE `subdistrict` (
  `id` varchar(10) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `districtid` varchar(10) NOT NULL,
  `isdelete` enum('false','true') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `subdistrict`
--

INSERT INTO `subdistrict` (`id`, `name`, `districtid`, `isdelete`) VALUES
('CB', 'Cibubur', 'Jaktim', 'false'),
('CC', 'Condongcatur', 'YK', 'false'),
('DNYL', 'Dont need your love', 'Jakbar', 'true');

-- --------------------------------------------------------

--
-- Struktur dari tabel `submission`
--

CREATE TABLE `submission` (
  `id` varchar(10) NOT NULL,
  `dateOfSubmission` date DEFAULT NULL,
  `typeOfAsset` varchar(50) DEFAULT NULL,
  `tracking_id` varchar(10) DEFAULT NULL,
  `employee_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `submission_of_asset`
--

CREATE TABLE `submission_of_asset` (
  `id` varchar(10) NOT NULL,
  `submission_id` varchar(10) NOT NULL,
  `asset_id` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `supplier`
--

CREATE TABLE `supplier` (
  `id` varchar(10) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `phoneNumber` varchar(15) DEFAULT NULL,
  `address_id` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tracking`
--

CREATE TABLE `tracking` (
  `id` varchar(10) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `dateOfPocess` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaction`
--

CREATE TABLE `transaction` (
  `id` varchar(10) NOT NULL,
  `dateTransaction` date DEFAULT NULL,
  `totalPrice` int(10) DEFAULT NULL,
  `supplier` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaction_of_asset`
--

CREATE TABLE `transaction_of_asset` (
  `id` varchar(10) NOT NULL,
  `quantity` int(10) DEFAULT NULL,
  `subTotal` int(10) DEFAULT NULL,
  `unitPrice` int(10) DEFAULT NULL,
  `asset` varchar(10) NOT NULL,
  `transaction` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `user_role`
--

CREATE TABLE `user_role` (
  `ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `user_role`
--

INSERT INTO `user_role` (`ID`) VALUES
(1),
(3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `access_emp`
--
ALTER TABLE `access_emp`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `access_of_emp`
--
ALTER TABLE `access_of_emp`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_aec_employee` (`employeeid`),
  ADD KEY `fk_aoe_a` (`accessid`);

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_address_subdistrict` (`subdistrictid`);

--
-- Indexes for table `app_role`
--
ALTER TABLE `app_role`
  ADD PRIMARY KEY (`ROLE_ID`),
  ADD UNIQUE KEY `APP_ROLE_UK` (`ROLE_NAME`);

--
-- Indexes for table `app_user`
--
ALTER TABLE `app_user`
  ADD PRIMARY KEY (`USER_ID`),
  ADD UNIQUE KEY `APP_USER_UK` (`USER_NAME`);

--
-- Indexes for table `asset`
--
ALTER TABLE `asset`
  ADD PRIMARY KEY (`id`),
  ADD KEY `asset_category_fk` (`category_id`);

--
-- Indexes for table `auth_user`
--
ALTER TABLE `auth_user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_au_empid` (`employeeid`),
  ADD KEY `fk_au_role` (`roleid`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `confirmation_token`
--
ALTER TABLE `confirmation_token`
  ADD PRIMARY KEY (`token_id`),
  ADD KEY `fk_ct_emp` (`employeeid`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_department_managerid` (`manager_id`);

--
-- Indexes for table `detail_asset`
--
ALTER TABLE `detail_asset`
  ADD PRIMARY KEY (`id`),
  ADD KEY `detail_asset_fk` (`asset`);

--
-- Indexes for table `district`
--
ALTER TABLE `district`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_district_pro` (`provinceid`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `password` (`password`),
  ADD KEY `fk_emp_job` (`job_id`),
  ADD KEY `fk_emp_address` (`address_id`),
  ADD KEY `fk_emp_reli` (`religion_id`),
  ADD KEY `fk_emp_manager` (`manager_id`),
  ADD KEY `fk_employee_depart` (`department_id`);

--
-- Indexes for table `job`
--
ALTER TABLE `job`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `persistent_logins`
--
ALTER TABLE `persistent_logins`
  ADD PRIMARY KEY (`series`);

--
-- Indexes for table `province`
--
ALTER TABLE `province`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `religion`
--
ALTER TABLE `religion`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `subdistrict`
--
ALTER TABLE `subdistrict`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_subdistrict_district` (`districtid`);

--
-- Indexes for table `submission`
--
ALTER TABLE `submission`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tracking_submission_fk` (`tracking_id`),
  ADD KEY `fk_submission_emp` (`employee_id`);

--
-- Indexes for table `submission_of_asset`
--
ALTER TABLE `submission_of_asset`
  ADD PRIMARY KEY (`id`),
  ADD KEY `asset_fk` (`asset_id`),
  ADD KEY `submission_fk` (`submission_id`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_supplier_address` (`address_id`);

--
-- Indexes for table `tracking`
--
ALTER TABLE `tracking`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id`),
  ADD KEY `transaction_supplier_fk` (`supplier`);

--
-- Indexes for table `transaction_of_asset`
--
ALTER TABLE `transaction_of_asset`
  ADD PRIMARY KEY (`id`),
  ADD KEY `asset_transaction_fk` (`asset`),
  ADD KEY `transaction_fk` (`transaction`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `auth_user`
--
ALTER TABLE `auth_user`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `confirmation_token`
--
ALTER TABLE `confirmation_token`
  MODIFY `token_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `access_of_emp`
--
ALTER TABLE `access_of_emp`
  ADD CONSTRAINT `fk_aec_employee` FOREIGN KEY (`employeeid`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `fk_aoe_a` FOREIGN KEY (`accessid`) REFERENCES `access_emp` (`id`);

--
-- Ketidakleluasaan untuk tabel `address`
--
ALTER TABLE `address`
  ADD CONSTRAINT `fk_address_subdistrict` FOREIGN KEY (`subdistrictid`) REFERENCES `subdistrict` (`id`);

--
-- Ketidakleluasaan untuk tabel `asset`
--
ALTER TABLE `asset`
  ADD CONSTRAINT `asset_category_fk` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

--
-- Ketidakleluasaan untuk tabel `auth_user`
--
ALTER TABLE `auth_user`
  ADD CONSTRAINT `fk_au_empid` FOREIGN KEY (`employeeid`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `fk_au_role` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`);

--
-- Ketidakleluasaan untuk tabel `confirmation_token`
--
ALTER TABLE `confirmation_token`
  ADD CONSTRAINT `fk_ct_emp` FOREIGN KEY (`employeeid`) REFERENCES `employee` (`id`);

--
-- Ketidakleluasaan untuk tabel `department`
--
ALTER TABLE `department`
  ADD CONSTRAINT `fk_department_managerid` FOREIGN KEY (`manager_id`) REFERENCES `employee` (`id`);

--
-- Ketidakleluasaan untuk tabel `detail_asset`
--
ALTER TABLE `detail_asset`
  ADD CONSTRAINT `detail_asset_fk` FOREIGN KEY (`asset`) REFERENCES `asset` (`id`);

--
-- Ketidakleluasaan untuk tabel `district`
--
ALTER TABLE `district`
  ADD CONSTRAINT `fk_district_pro` FOREIGN KEY (`provinceid`) REFERENCES `province` (`id`);

--
-- Ketidakleluasaan untuk tabel `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `fk_emp_address` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`),
  ADD CONSTRAINT `fk_emp_job` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`),
  ADD CONSTRAINT `fk_emp_manager` FOREIGN KEY (`manager_id`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `fk_emp_reli` FOREIGN KEY (`religion_id`) REFERENCES `religion` (`id`),
  ADD CONSTRAINT `fk_employee_depart` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`);

--
-- Ketidakleluasaan untuk tabel `subdistrict`
--
ALTER TABLE `subdistrict`
  ADD CONSTRAINT `fk_subdistrict_district` FOREIGN KEY (`districtid`) REFERENCES `district` (`id`);

--
-- Ketidakleluasaan untuk tabel `submission`
--
ALTER TABLE `submission`
  ADD CONSTRAINT `fk_submission_emp` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `tracking_submission_fk` FOREIGN KEY (`tracking_id`) REFERENCES `tracking` (`id`);

--
-- Ketidakleluasaan untuk tabel `submission_of_asset`
--
ALTER TABLE `submission_of_asset`
  ADD CONSTRAINT `asset_fk` FOREIGN KEY (`asset_id`) REFERENCES `asset` (`id`),
  ADD CONSTRAINT `submission_fk` FOREIGN KEY (`submission_id`) REFERENCES `submission` (`id`);

--
-- Ketidakleluasaan untuk tabel `supplier`
--
ALTER TABLE `supplier`
  ADD CONSTRAINT `fk_supplier_address` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`);

--
-- Ketidakleluasaan untuk tabel `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `transaction_supplier_fk` FOREIGN KEY (`supplier`) REFERENCES `supplier` (`id`);

--
-- Ketidakleluasaan untuk tabel `transaction_of_asset`
--
ALTER TABLE `transaction_of_asset`
  ADD CONSTRAINT `asset_transaction_fk` FOREIGN KEY (`asset`) REFERENCES `asset` (`id`),
  ADD CONSTRAINT `transaction_fk` FOREIGN KEY (`transaction`) REFERENCES `transaction` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
