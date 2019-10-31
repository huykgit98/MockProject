-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 29, 2019 at 10:29 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mockproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `BookingID` bigint(20) NOT NULL,
  `ScheduleID` bigint(20) NOT NULL,
  `CusID` bigint(20) NOT NULL,
  `BookingDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DateStart` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Status` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`BookingID`, `ScheduleID`, `CusID`, `BookingDate`, `DateStart`, `Description`, `Status`) VALUES
(1, 1, 2, '2019-10-19 11:11:11', '2019-10-20 00:00:00', '', b'0'),
(2, 2, 5, '2019-10-15 00:00:00', '2019-10-22 00:00:00', '', b'0'),
(3, 2, 6, '2019-10-19 00:00:00', '2019-10-22 00:00:00', '', b'0'),
(4, 2, 10, '2019-10-11 00:00:00', '2019-10-20 00:00:00', '', b'0');

-- --------------------------------------------------------

--
-- Table structure for table `bus`
--

CREATE TABLE `bus` (
  `BusID` bigint(20) NOT NULL,
  `NumberPlate` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TypeID` bigint(20) NOT NULL,
  `SeatNum` int(11) NOT NULL DEFAULT '0',
  `DriverID` bigint(20) DEFAULT NULL,
  `EmpID` bigint(20) DEFAULT NULL,
  `Status` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `bus`
--

INSERT INTO `bus` (`BusID`, `NumberPlate`, `TypeID`, `SeatNum`, `DriverID`, `EmpID`, `Status`) VALUES
(1, '27B-004.52', 1, 40, 4, 2, b'0'),
(2, '27B-005.52', 1, 40, 5, 11, b'0'),
(3, '27B-006.52', 1, 40, 6, 12, b'0'),
(4, '27B-009.52', 2, 16, 7, 13, b'0'),
(5, '27B-014.52', 2, 16, 8, 14, b'0'),
(6, '27B-119.52', 1, 40, 9, 15, b'0'),
(7, '27B-999.52', 2, 16, 10, 16, b'0');

-- --------------------------------------------------------

--
-- Table structure for table `bus_type`
--

CREATE TABLE `bus_type` (
  `TypeID` bigint(20) NOT NULL,
  `TypeName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `bus_type`
--

INSERT INTO `bus_type` (`TypeID`, `TypeName`, `Description`) VALUES
(1, 'Giường Nằm', 'Xe khách loại giường nằm'),
(2, 'Ghế Ngồi', 'Xe khách loại thường');

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `CusID` bigint(20) NOT NULL,
  `Email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `FullName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Phone` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`CusID`, `Email`, `Password`, `FullName`, `Address`, `Phone`) VALUES
(1, 'asd@email.com', '123456', 'Hoàng Nguyễn Huy', 'dia chi cung cung', '0391231231'),
(2, 'khachhang1@gmail.com', '123456', 'Lê Văn Lâm', '273 An Dương Vương\r\nPhường 04, Quận 5, TP.HCM', '0387134711'),
(3, 'khachhang1@gmail.com', '123456', 'Ngô Khá Bá', '159B Dạ Nam, Phường 04, Quận 07, TP.HCM', '0389283838'),
(4, 'khachhang4@gmail.com', '123456', 'Lê Văn Lâm', '273 An Dương Vương\r\nPhường 04, Quận 5, TP.HCM', '0387134711'),
(5, 'khachhang5@gmail.com', '123456', 'Ngô Khá Bá', '159B Dạ Nam, Phường 04, Quận 07, TP.HCM', '0389283838'),
(6, 'khachhang6@gmail.com', '123456', 'Lê Văn Lâm', '273 An Dương Vương\r\nPhường 04, Quận 5, TP.HCM', '0387134711'),
(7, 'khachhang17gmail.com', '123456', 'Ngô Khá Bá', '159B Dạ Nam, Phường 04, Quận 07, TP.HCM', '0389283838'),
(8, 'khachhang18gmail.com', '123456', 'Lê Văn Lâm', '273 An Dương Vương\r\nPhường 04, Quận 5, TP.HCM', '0387134711'),
(9, 'khachhang19gmail.com', '123456', 'Ngô Khá Bá', '159B Dạ Nam, Phường 04, Quận 07, TP.HCM', '0389283838'),
(10, 'khachhang10@gmail.com', '123456', 'Lê Văn Lâm', '273 An Dương Vương\r\nPhường 04, Quận 5, TP.HCM', '0387134711'),
(11, 'khachhang11@gmail.com', '123456', 'Ngô Khá Bá', '159B Dạ Nam, Phường 04, Quận 07, TP.HCM', '0389283838');

-- --------------------------------------------------------

--
-- Table structure for table `detail`
--

CREATE TABLE `detail` (
  `BookingID` bigint(20) NOT NULL,
  `Seat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `detail`
--

INSERT INTO `detail` (`BookingID`, `Seat`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(2, 1),
(2, 2),
(3, 3),
(3, 4),
(3, 5),
(3, 6),
(4, 14);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `EmpID` bigint(20) NOT NULL,
  `FullName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Phone` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Status` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`EmpID`, `FullName`, `Address`, `Phone`, `Status`) VALUES
(1, 'Hoàng Huy', '273 An Dương VƯơng, Quận 5, TP.HCM', '0387134747', b'0'),
(2, 'Lê Liêm Sĩ', 'tòa nhà Vĩnh Phúc, Phường 3, Quận 7, TP.HCM', '0387675757', b'0'),
(3, 'Trương Minh Hương', '284 An Dương Vương, Phường 04, Quận 05, TP.HCM', '0381212312', b'0'),
(4, 'Trần Khá Kinh', '159B Dạ Nam, Phường 04, Quận 07, TP.HCM', '0389999999', b'0'),
(5, 'Đàm Vĩnh Hưng', '523A Đỗ Xuân Hợp, Phước Long B, Quận 9, Hồ Chí Minh.', '0389999999', b'0'),
(6, 'Châu Kiệt Luân', ' 19 Đường Nguyễn Hữu Thọ, Tân Hưng, Quận 7, Hồ Chí Minh', '0387787878', b'0'),
(7, 'Trấn Thành ', ' 19 Đường Nguyễn Hữu Thọ, Tân Hưng, Quận 7, Hồ Chí Minh', '0387612312', b'0'),
(8, 'Đinh Tiến Đạt', '19 Đường Nguyễn Hữu Thọ, Tân Hưng, Quận 7, Hồ Chí Minh', '0387472123', b'0'),
(9, 'Anh Đức', '19 Đường Nguyễn Hữu Thọ, Tân Hưng, Quận 7, Hồ Chí Minh', '0381212120', b'0'),
(10, 'Trường Giang', '19 Đường Nguyễn Hữu Thọ, Tân Hưng, Quận 7, Hồ Chí Minh', '0389990000', b'0'),
(11, 'Khá Bảnh', '19 Đường Nguyễn Hữu Thọ, Tân Hưng, Quận 7, Hồ Chí Minh', '0387777777', b'0'),
(12, 'Châu Đại Dương', '19 Đường Nguyễn Hữu Thọ, Tân Hưng, Quận 7, Hồ Chí Minh', '0386676767', b'0'),
(13, 'Ông Cao Thắng', '9 Đường Nguyễn Hữu Thọ, Tân Hưng, Quận 7, Hồ Chí Minh', '0387771111', b'0'),
(14, 'Lê Thị Dạ Hương', '19 Đường Nguyễn Hữu Thọ, Tân Hưng, Quận 7, Hồ Chí Minh', '0387777711', b'0'),
(15, 'Ngô Kiến Huy', '19 Đường Nguyễn Hữu Thọ, Tân Hưng, Quận 7, Hồ Chí Minh', '0380001111', b'0'),
(16, 'Khổng Tú Quỳnh', '19 Đường Nguyễn Hữu Thọ, Tân Hưng, Quận 7, Hồ Chí Minh', '0387123155', b'0');

-- --------------------------------------------------------

--
-- Table structure for table `employee_role`
--

CREATE TABLE `employee_role` (
  `EmpID` bigint(20) NOT NULL,
  `RoleID` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `employee_role`
--

INSERT INTO `employee_role` (`EmpID`, `RoleID`) VALUES
(1, 1),
(2, 4),
(3, 2),
(4, 3),
(5, 3),
(6, 3),
(7, 3),
(8, 3),
(9, 3),
(10, 3),
(11, 4),
(12, 4),
(13, 4),
(14, 4),
(15, 4),
(16, 4);

-- --------------------------------------------------------

--
-- Table structure for table `place`
--

CREATE TABLE `place` (
  `PlaceID` bigint(20) NOT NULL,
  `PlaceName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `place`
--

INSERT INTO `place` (`PlaceID`, `PlaceName`) VALUES
(1, 'Sài Gòn'),
(2, 'Kiên Giang'),
(3, 'Quảng Ngãi'),
(4, 'Long An'),
(5, 'Đồng Nai'),
(6, 'Vũng Tàu'),
(7, 'Cà Mau'),
(8, 'Cần Thơ'),
(9, 'Hà Lội'),
(10, 'Hà Giang'),
(11, 'Hà Tĩnh'),
(12, 'Đồng Tháp'),
(13, 'Vĩnh Long'),
(14, 'Bình Phước');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `RoleID` bigint(20) NOT NULL,
  `Name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Description` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`RoleID`, `Name`, `Description`) VALUES
(1, 'admin', 'chủ tịch hội đồng quản trị'),
(2, 'ticketseller', 'thanh niên bán vé'),
(3, 'driver', 'tài xế'),
(4, 'assistant', 'lơ xe');

-- --------------------------------------------------------

--
-- Table structure for table `schedule`
--

CREATE TABLE `schedule` (
  `ScheduleID` bigint(20) NOT NULL,
  `BusID` bigint(20) DEFAULT NULL,
  `TimeStart` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `StartPlace` bigint(20) NOT NULL,
  `FinishPlace` bigint(20) NOT NULL,
  `Price` decimal(13,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Schedule';

--
-- Dumping data for table `schedule`
--

INSERT INTO `schedule` (`ScheduleID`, `BusID`, `TimeStart`, `StartPlace`, `FinishPlace`, `Price`) VALUES
(1, 1, '2019-10-29 00:00:00', 1, 7, '250000'),
(2, 2, '2019-10-29 00:00:00', 1, 7, '250000'),
(3, 3, '2019-10-29 00:00:00', 1, 13, '150000'),
(4, 4, '2019-10-29 00:00:00', 2, 1, '175000'),
(5, 5, '2019-10-29 00:00:00', 2, 7, '150000'),
(6, 6, '2019-10-29 00:00:00', 1, 12, '200000'),
(7, 7, '2019-10-29 00:00:00', 1, 5, '300000'),
(8, 1, '2019-10-31 00:00:00', 1, 2, '150000');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `UserID` bigint(20) NOT NULL,
  `UserName` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Password` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `EmpID` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`UserID`, `UserName`, `Password`, `EmpID`) VALUES
(3, 'admin', '123456', 1),
(4, 'ticketseller', '123456', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`BookingID`),
  ADD KEY `FK_booking_customer` (`CusID`),
  ADD KEY `FK_booking_schedule` (`ScheduleID`);

--
-- Indexes for table `bus`
--
ALTER TABLE `bus`
  ADD PRIMARY KEY (`BusID`),
  ADD KEY `FK_BusType_Bus` (`TypeID`),
  ADD KEY `FK_bus_employee` (`DriverID`),
  ADD KEY `FK_bus_employee1` (`EmpID`);

--
-- Indexes for table `bus_type`
--
ALTER TABLE `bus_type`
  ADD PRIMARY KEY (`TypeID`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`CusID`);

--
-- Indexes for table `detail`
--
ALTER TABLE `detail`
  ADD PRIMARY KEY (`BookingID`,`Seat`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`EmpID`);

--
-- Indexes for table `employee_role`
--
ALTER TABLE `employee_role`
  ADD PRIMARY KEY (`EmpID`,`RoleID`),
  ADD KEY `FK_userrole_Employee` (`EmpID`),
  ADD KEY `FK_userrole_role` (`RoleID`);

--
-- Indexes for table `place`
--
ALTER TABLE `place`
  ADD PRIMARY KEY (`PlaceID`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`RoleID`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`ScheduleID`),
  ADD KEY `FK_Schedule_Place` (`StartPlace`),
  ADD KEY `FK_Schedule_Place1` (`FinishPlace`),
  ADD KEY `FK_Schedule_Bus` (`BusID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`UserID`),
  ADD KEY `FK_users_employee` (`EmpID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `BookingID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `bus`
--
ALTER TABLE `bus`
  MODIFY `BusID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `bus_type`
--
ALTER TABLE `bus_type`
  MODIFY `TypeID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `CusID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `EmpID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `place`
--
ALTER TABLE `place`
  MODIFY `PlaceID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `RoleID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `schedule`
--
ALTER TABLE `schedule`
  MODIFY `ScheduleID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `UserID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `FK_booking_customer` FOREIGN KEY (`CusID`) REFERENCES `customers` (`CusID`),
  ADD CONSTRAINT `FK_booking_schedule` FOREIGN KEY (`ScheduleID`) REFERENCES `schedule` (`ScheduleID`);

--
-- Constraints for table `bus`
--
ALTER TABLE `bus`
  ADD CONSTRAINT `FK_BusType_Bus` FOREIGN KEY (`TypeID`) REFERENCES `bus_type` (`TypeID`),
  ADD CONSTRAINT `FK_bus_employee` FOREIGN KEY (`DriverID`) REFERENCES `employee` (`EmpID`),
  ADD CONSTRAINT `FK_bus_employee1` FOREIGN KEY (`EmpID`) REFERENCES `employee` (`EmpID`);

--
-- Constraints for table `detail`
--
ALTER TABLE `detail`
  ADD CONSTRAINT `FK_detail_booking` FOREIGN KEY (`BookingID`) REFERENCES `booking` (`BookingID`);

--
-- Constraints for table `employee_role`
--
ALTER TABLE `employee_role`
  ADD CONSTRAINT `FK_userrole_Employee` FOREIGN KEY (`EmpID`) REFERENCES `employee` (`EmpID`),
  ADD CONSTRAINT `FK_userrole_role` FOREIGN KEY (`RoleID`) REFERENCES `roles` (`RoleID`);

--
-- Constraints for table `schedule`
--
ALTER TABLE `schedule`
  ADD CONSTRAINT `FK_Schedule_Bus` FOREIGN KEY (`BusID`) REFERENCES `bus` (`BusID`),
  ADD CONSTRAINT `FK_Schedule_Place` FOREIGN KEY (`StartPlace`) REFERENCES `place` (`PlaceID`),
  ADD CONSTRAINT `FK_Schedule_Place1` FOREIGN KEY (`FinishPlace`) REFERENCES `place` (`PlaceID`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `FK_users_employee` FOREIGN KEY (`EmpID`) REFERENCES `employee` (`EmpID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;