-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-10-2021 a las 06:50:50
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdcarreraprofesional`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carrera`
--

CREATE TABLE `carrera` (
  `CODCARRERA` int(11) NOT NULL,
  `NOMBCARRERA` varchar(50) NOT NULL,
  `ESTADOCARRERA` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `carrera`
--

INSERT INTO `carrera` (`CODCARRERA`, `NOMBCARRERA`, `ESTADOCARRERA`) VALUES
(1, 'SISTEMA', 'HABILITADO'),
(2, 'ADMINISTRACION', 'HABILITADO'),
(3, 'ING SOFTWARE', 'HABILITADO'),
(4, 'CONTABILIDAD', 'HABILITADO'),
(5, 'ING CIVIL', 'HABILITADO'),
(6, 'ING MECANICA', 'HABILITADO'),
(7, 'ING ROBOTICA', 'HABILITADO'),
(8, 'ING DOMOTICA', 'HABILITADO'),
(9, 'ING INDUSTRIAL', 'HABILITADO');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `carrera`
--
ALTER TABLE `carrera`
  ADD PRIMARY KEY (`CODCARRERA`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
