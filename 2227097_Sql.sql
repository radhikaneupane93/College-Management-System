-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3307
-- Generation Time: Feb 09, 2023 at 10:04 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cms`
--

-- --------------------------------------------------------

--
-- Table structure for table `assignmentanswer`
--

CREATE TABLE `assignmentanswer` (
  `AssignmentAnswerId` int(11) NOT NULL,
  `StudentId` int(11) NOT NULL,
  `ModuleName` varchar(50) NOT NULL,
  `AssignmentAnswer1` varchar(100) NOT NULL,
  `AssignmentAnswer2` varchar(100) NOT NULL,
  `AssignmentSubmitted` varchar(10) NOT NULL DEFAULT 'NO'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `assignmentanswer`
--

INSERT INTO `assignmentanswer` (`AssignmentAnswerId`, `StudentId`, `ModuleName`, `AssignmentAnswer1`, `AssignmentAnswer2`, `AssignmentSubmitted`) VALUES
(1, 2, 'OODP', 'Class', 'Inheritance ', 'YES'),
(2, 2, 'AI', 'Regression', 'Panda/Numpy', 'YES'),
(3, 2, 'NMC', 'Thread', 'Concurrent Programming', 'YES');

-- --------------------------------------------------------

--
-- Table structure for table `assignmentmark`
--

CREATE TABLE `assignmentmark` (
  `assignmentmarkid` int(11) NOT NULL,
  `teacherid` int(11) NOT NULL,
  `studentid` int(11) NOT NULL,
  `ModuleName` varchar(30) NOT NULL,
  `assignmentMarks` int(11) NOT NULL,
  `marksAdded` varchar(20) NOT NULL DEFAULT 'NO'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `assignmentmark`
--

INSERT INTO `assignmentmark` (`assignmentmarkid`, `teacherid`, `studentid`, `ModuleName`, `assignmentMarks`, `marksAdded`) VALUES
(1, 3, 2, 'OODP', 90, 'YES'),
(2, 5, 2, 'AI', 100, 'YES'),
(3, 4, 2, 'NMC', 100, 'YES');

-- --------------------------------------------------------

--
-- Table structure for table `assignmentquestionpaper`
--

CREATE TABLE `assignmentquestionpaper` (
  `AssignmentId` int(11) NOT NULL,
  `AssignmentQuestionNo1` text NOT NULL,
  `AssignmentQuestionNo2` text NOT NULL,
  `ModuleName` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `assignmentquestionpaper`
--

INSERT INTO `assignmentquestionpaper` (`AssignmentId`, `AssignmentQuestionNo1`, `AssignmentQuestionNo2`, `ModuleName`) VALUES
(1, 'Differentiate between class and object. Give examples.', 'What is Inheritance? How can we apply inheritance in Java?', 'OODP'),
(2, 'What is a Thread?', 'What is Concurrent programming?', 'NMC'),
(3, 'What is a linear regression?', 'Panda and Numpy usage?', 'AI');

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `Courseid` int(11) NOT NULL,
  `CourseName` varchar(20) NOT NULL,
  `CourseDescription` varchar(100) NOT NULL,
  `NoOfModules` int(11) NOT NULL,
  `LengthOfTheCourse` int(11) NOT NULL,
  `CourseType` varchar(20) NOT NULL,
  `IsCourseActivated` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`Courseid`, `CourseName`, `CourseDescription`, `NoOfModules`, `LengthOfTheCourse`, `CourseType`, `IsCourseActivated`) VALUES
(2, 'BIBM', 'Related to business management', 30, 4, 'UnderGraduate', 'YES'),
(3, 'BIBM', 'RELATED TO BUSINESS', 50, 4, 'UnderGraduate', 'YES');

-- --------------------------------------------------------

--
-- Table structure for table `instructor`
--

CREATE TABLE `instructor` (
  `ID` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `MobileNumber` varchar(10) NOT NULL,
  `Address` varchar(25) NOT NULL,
  `ModuleAssigned` varchar(10) NOT NULL,
  `QualifiedDegree` varchar(20) NOT NULL,
  `Gender` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `instructor`
--

INSERT INTO `instructor` (`ID`, `Name`, `MobileNumber`, `Address`, `ModuleAssigned`, `QualifiedDegree`, `Gender`) VALUES
(1, 'Shital Sapkota', '9876355674', 'Gyaneshwor', 'AI', 'Master\'s in IT', 'Female'),
(4, 'Ravi KC', '9876354739', 'Jorpati', 'NMC', 'Master\'s in IT', 'Male'),
(5, 'AI', '9875467834', 'Saraswatinagar', 'AI', 'Software Engineering', 'Female'),
(7, 'Ram', '2345678op', 'asdasd', 'AI', 'BE', 'Male'),
(9, 'Ritika Parajuli', '83849484', 'Kritipur', 'AI', 'BIT', 'Female');

-- --------------------------------------------------------

--
-- Table structure for table `module`
--

CREATE TABLE `module` (
  `ModuleName` varchar(25) NOT NULL,
  `CourseName` varchar(25) NOT NULL,
  `Level` varchar(25) NOT NULL,
  `Semester` varchar(20) NOT NULL,
  `CreditValue` int(11) NOT NULL,
  `OptionalModule` varchar(20) NOT NULL DEFAULT 'No'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `module`
--

INSERT INTO `module` (`ModuleName`, `CourseName`, `Level`, `Semester`, `CreditValue`, `OptionalModule`) VALUES
('AI', 'BIT', 'Level 5', '1st Semester', 360, 'NO'),
('Finance', 'BIBM', 'Level 6', '1st Semester', 420, 'NO');

-- --------------------------------------------------------

--
-- Table structure for table `report`
--

CREATE TABLE `report` (
  `ReportId` int(11) NOT NULL,
  `StudentId` int(11) NOT NULL,
  `AverageMarks` float NOT NULL,
  `Grade` varchar(20) NOT NULL,
  `Remarks` varchar(100) NOT NULL,
  `IsReportGenerated` varchar(20) NOT NULL DEFAULT 'NO'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `report`
--

INSERT INTO `report` (`ReportId`, `StudentId`, `AverageMarks`, `Grade`, `Remarks`, `IsReportGenerated`) VALUES
(1, 2, 96.6667, 'A', 'Progression to Level 6', 'YES');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `StudentId` int(11) NOT NULL,
  `StudentName` varchar(20) NOT NULL,
  `Address` varchar(20) NOT NULL,
  `Level` varchar(10) NOT NULL,
  `Semester` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`StudentId`, `StudentName`, `Address`, `Level`, `Semester`) VALUES
(1, 'Nabina', 'Gothatar', '6', '2'),
(2, 'Radhika Neupane', 'Dakshindhoka', '5', '1'),
(3, 'Anjali Shrestha', 'Gokarna', '5', '1'),
(4, 'Rejina Neupane', 'Dakshindhoka', '5', '2');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `first_name` varchar(25) NOT NULL,
  `last_name` varchar(25) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `systemusers` varchar(50) NOT NULL,
  `password` varchar(25) NOT NULL,
  `confirmPassword` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`ID`, `username`, `first_name`, `last_name`, `gender`, `systemusers`, `password`, `confirmPassword`) VALUES
(9, 'radhika', 'Radhika', 'Neupane', 'Female', 'Admin', 'radhika', 'radhika'),
(10, 'subash', 'Subash', 'Bista', 'Male', 'Instructor', 'subash', 'subash'),
(11, 'raj', 'Raj', 'Shrestha', 'Male', 'Instructor', 'raj', 'raj'),
(12, 'jeshmi', 'Jeshmi', 'Rajak', 'Female', 'Instructor', 'jeshmi', 'jeshmi'),
(13, 'anjali', 'Anjali', 'Shrestha', 'Female', 'Student', 'anjali', 'anjali'),
(14, 'nabina', 'Nabina', 'Shrestha', 'Female', 'Student', 'nabina', 'nabina'),
(15, 'saurav', 'Saurav', 'Koirala', 'Male', 'Student', 'saurav', 'saurav');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `assignmentanswer`
--
ALTER TABLE `assignmentanswer`
  ADD PRIMARY KEY (`AssignmentAnswerId`);

--
-- Indexes for table `assignmentmark`
--
ALTER TABLE `assignmentmark`
  ADD PRIMARY KEY (`assignmentmarkid`);

--
-- Indexes for table `assignmentquestionpaper`
--
ALTER TABLE `assignmentquestionpaper`
  ADD PRIMARY KEY (`AssignmentId`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`Courseid`);

--
-- Indexes for table `instructor`
--
ALTER TABLE `instructor`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `module`
--
ALTER TABLE `module`
  ADD UNIQUE KEY `ModuleName` (`ModuleName`);

--
-- Indexes for table `report`
--
ALTER TABLE `report`
  ADD PRIMARY KEY (`ReportId`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`StudentId`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `assignmentanswer`
--
ALTER TABLE `assignmentanswer`
  MODIFY `AssignmentAnswerId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `assignmentmark`
--
ALTER TABLE `assignmentmark`
  MODIFY `assignmentmarkid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `assignmentquestionpaper`
--
ALTER TABLE `assignmentquestionpaper`
  MODIFY `AssignmentId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `Courseid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `instructor`
--
ALTER TABLE `instructor`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `report`
--
ALTER TABLE `report`
  MODIFY `ReportId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `StudentId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
