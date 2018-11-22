-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-10-2018 a las 13:11:50
-- Versión del servidor: 10.1.36-MariaDB
-- Versión de PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `easybooking`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aerolinea`
--

CREATE TABLE `aerolinea` (
  `ID_AEROLINEA` bigint(20) NOT NULL,
  `NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `aerolinea`
--

INSERT INTO `aerolinea` (`ID_AEROLINEA`, `NAME`) VALUES
(21, 'Iberia'),
(22, 'Vueling');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aeropuerto`
--

CREATE TABLE `aeropuerto` (
  `ID_AEROPUERTO` bigint(20) NOT NULL,
  `NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `ID_RESERVA` bigint(20) NOT NULL,
  `COMISION` double NOT NULL,
  `COSTE` double NOT NULL,
  `EMAILUSUARIO` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `ID_VUELO` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`ID_RESERVA`, `COMISION`, `COSTE`, `EMAILUSUARIO`, `ID_VUELO`) VALUES
(21, 20, 50, 'jonaso@opendeusto.es', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sequence_table`
--

CREATE TABLE `sequence_table` (
  `SEQUENCE_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `NEXT_VAL` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `sequence_table`
--

INSERT INTO `sequence_table` (`SEQUENCE_NAME`, `NEXT_VAL`) VALUES
('org.datanucleus.samples.jdo.tutorial.Aerolinea', 31),
('org.datanucleus.samples.jdo.tutorial.Aeropuerto', 31),
('org.datanucleus.samples.jdo.tutorial.Reserva', 31),
('org.datanucleus.samples.jdo.tutorial.Vuelo', 31);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `EMAIL` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `AER` bigint(20) NOT NULL,
  `NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `PAYMETHOD` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `SISAUTH` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`EMAIL`, `AER`, `NAME`, `PAYMETHOD`, `SISAUTH`) VALUES
('jonaso@opendeusto.es', 0, 'yon', 'paypal', 'google+');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vuelo`
--

CREATE TABLE `vuelo` (
  `ID_VUELO` bigint(20) NOT NULL,
  `ID_AER` bigint(20) NOT NULL,
  `ID_DESTINO` bigint(20) NOT NULL,
  `ID_ORIGEN` bigint(20) NOT NULL,
  `LLEGADA` timestamp NULL DEFAULT NULL,
  `SALIDA` timestamp NULL DEFAULT NULL,
  `TOTASIENTOS` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `vuelo`
--

INSERT INTO `vuelo` (`ID_VUELO`, `ID_AER`, `ID_DESTINO`, `ID_ORIGEN`, `LLEGADA`, `SALIDA`, `TOTASIENTOS`) VALUES
(21, 0, 0, 0, NULL, NULL, 10);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aerolinea`
--
ALTER TABLE `aerolinea`
  ADD PRIMARY KEY (`ID_AEROLINEA`);

--
-- Indices de la tabla `aeropuerto`
--
ALTER TABLE `aeropuerto`
  ADD PRIMARY KEY (`ID_AEROPUERTO`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`ID_RESERVA`);

--
-- Indices de la tabla `sequence_table`
--
ALTER TABLE `sequence_table`
  ADD PRIMARY KEY (`SEQUENCE_NAME`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`EMAIL`);

--
-- Indices de la tabla `vuelo`
--
ALTER TABLE `vuelo`
  ADD PRIMARY KEY (`ID_VUELO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
