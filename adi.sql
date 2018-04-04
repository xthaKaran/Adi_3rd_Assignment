-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 01, 2018 at 06:41 AM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `adi`
--

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

CREATE TABLE `company` (
  `cid` int(11) NOT NULL,
  `name` varchar(55) NOT NULL,
  `address` varchar(50) NOT NULL,
  `email` varchar(55) NOT NULL,
  `contact` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`cid`, `name`, `address`, `email`, `contact`) VALUES
(17, 'Softwarica company', 'dilibazer', 'softwarica@gmail.com', '9819853807'),
(18, 'Apple Company', 'Koteshwo', 'apple@gmail.com', '9999999081'),
(19, 'HP', 'New Road', 'hp@gmail.com', '9898989898989'),
(20, 'Raman ', 'kapan', 'raman@gmail.com', '982748357'),
(21, 'lhew', 'jdhfgj', 'fjdj@gmail.com', '123'),
(22, 'Apple Company', 'Kote', 'apple@gmail.com', '9999999081'),
(23, 'hjgh', 'ytyrt', 'ytrt@gmail.com', '56467');

-- --------------------------------------------------------

--
-- Table structure for table `cost`
--

CREATE TABLE `cost` (
  `id` int(11) NOT NULL,
  `location` varchar(44) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cost`
--

INSERT INTO `cost` (`id`, `location`, `price`) VALUES
(1, 'Kathmandu', 200),
(2, 'Ilam', 800),
(3, 'Lalitpur', 300),
(4, 'Bhaktpur', 300),
(5, 'Pokhera', 500),
(6, 'Biratnagar', 600),
(7, 'Bharatpur', 400),
(8, 'Birganj', 500),
(9, 'Butwal', 500),
(10, 'Dharan', 700),
(11, 'Dhangadhi', 700),
(12, 'Janakpur', 500),
(13, 'Hetauda', 400),
(14, 'Itahari', 750),
(15, 'Nepalganj', 700),
(16, 'Kathmandu', 200),
(17, 'Ilam', 800),
(18, 'Lalitpur', 300),
(19, 'Bhaktpur', 300),
(20, 'Pokhera', 500),
(21, 'Biratnagar', 600),
(22, 'Bharatpur', 400),
(23, 'Birganj', 500),
(24, 'Butwal', 500),
(25, 'Dharan', 700),
(26, 'Dhangadhi', 700),
(27, 'Janakpur', 500),
(28, 'Hetauda', 400),
(29, 'Itahari', 750),
(30, 'Nepalganj', 700),
(31, 'Gorkha', 350),
(32, 'Gorkha', 350);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `username` varchar(44) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `manifest`
--

CREATE TABLE `manifest` (
  `mid` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  `mname` varchar(40) NOT NULL,
  `description` varchar(100) NOT NULL,
  `date` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `manifest`
--

INSERT INTO `manifest` (`mid`, `cid`, `mname`, `description`, `date`) VALUES
(17, 17, 'printer', 'hhttht', '2018/03/31'),
(18, 19, 'printer', 'hhttht', '2018/04/01'),
(19, 17, 'printer', 'hhttht', '2018/04/01'),
(20, 17, 'printer', 'hhttht', '2018/04/01');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `pid` int(11) NOT NULL,
  `mid` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `quantity` int(11) NOT NULL,
  `weight` int(11) NOT NULL,
  `destination` varchar(40) NOT NULL,
  `date` varchar(10) NOT NULL,
  `deliverydate` varchar(20) NOT NULL,
  `delivery` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`pid`, `mid`, `name`, `quantity`, `weight`, `destination`, `date`, `deliverydate`, `delivery`) VALUES
(1, 16, 'laptop', 55, 40, 'Ilam', '2018-04-96', '2018-04-96', 'YES'),
(2, 16, 'computer', 5, 400, 'Biratnagar', '2018-04-96', '2018-04-96', 'YES');

-- --------------------------------------------------------

--
-- Table structure for table `shipment`
--

CREATE TABLE `shipment` (
  `sid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `internalCost` float NOT NULL,
  `customerCost` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shipment`
--

INSERT INTO `shipment` (`sid`, `pid`, `internalCost`, `customerCost`) VALUES
(1, 1, 1200, 1440),
(2, 2, 4600, 5520);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`cid`);

--
-- Indexes for table `cost`
--
ALTER TABLE `cost`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `manifest`
--
ALTER TABLE `manifest`
  ADD PRIMARY KEY (`mid`),
  ADD KEY `cid` (`cid`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`pid`),
  ADD KEY `mid` (`mid`);

--
-- Indexes for table `shipment`
--
ALTER TABLE `shipment`
  ADD PRIMARY KEY (`sid`),
  ADD KEY `pid` (`pid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `company`
--
ALTER TABLE `company`
  MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `cost`
--
ALTER TABLE `cost`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `manifest`
--
ALTER TABLE `manifest`
  MODIFY `mid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `pid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `shipment`
--
ALTER TABLE `shipment`
  MODIFY `sid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
