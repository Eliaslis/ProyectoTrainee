-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 28-03-2021 a las 23:47:57
-- Versión del servidor: 8.0.23
-- Versión de PHP: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ejerciciojava`
USE ejerciciojava;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `student_subjects`
--

CREATE TABLE `student_subjects` (
  `student_id` int DEFAULT NULL,
  `subject_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `student_subjects`
--

INSERT INTO `student_subjects` (`student_id`, `subject_id`) VALUES
(1, 1),
(1, 4),
(1, 1),
(1, 1),
(1, 1),
(1, 2),
(1, 6),
(1, 2),
(1, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subjects`
--

CREATE TABLE `subjects` (
  `subject_id` int NOT NULL,
  `name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `description` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `subjects`
--

INSERT INTO `subjects` (`subject_id`, `name`, `description`) VALUES
(1, 'Ingenieria y Sociedad', 'Los  contenidos  mínimos  de  la  materia  pueden  ser  pensados  como  disciplinas  científicas sociales-humanas:  incluyen  economía,  ciencia  política,  sociología,  historia  de  la  industria, ética, epistemología, entre otras. '),
(2, 'Analisis Matematico I', 'Los objetivos son formar  al  estudiante  en  un  campo  que  tiende  a  promover  la  capacidad  de  plantear  problemas   y   resolver   situaciones   problemáticas   concretas, motivar  la  necesidad  de  aplicación  de  los  métodos  matemáticos  a  problemas  de  Ingeniería y reconocer que la teoría y sus aplicaciones están íntimamente relacionadas.'),
(3, 'Algebra y Geometria Analitica', 'Clases   teórico-prácticas   incentivando   la   participación   activa   de los   alumnos   y   orientadas   a   la comprensión  de  los  diferentes  temas  de  la  asignatura  en  forma  integradora,  no  sólo  como  herramientas aisladas  de  cálculo,    y  con  aplicaciones  a  disciplinas  ligadas  con  la  Ingeniería.  '),
(4, 'Quimica', 'Los objetivos son comprender la estructura de la materia, transmitir el concepto de las relaciones cuantitativas en los sistemas materiales para hacer posible su empleo en la Ingeniería y proporcionar el conocimiento fundamental de las propiedades de algunos materiales básicos'),
(5, 'Algoritmos y Estructuras de Datos', 'Los objetivos son introducir    al    alumno    en    problemas    algorítmicos    y    proceso    de    diseño    e    implementación de software. Estudio de herramientas fundamentales representativas de   los   procesos,   integrando   la   sintaxis   elemental   de   un   lenguaje   moderno.   Programación en el laboratorio asociado.'),
(6, 'Matematica Discreta', 'Desarrollar temas no abordados en el área de formación básica homogénea que se consideran necesarios para el desarrollo de asignaturas del área programación.'),
(7, 'Sistemas y Organizaciones', 'Los objetivos son formar  al  estudiante  en  la  compresión  y  reconocimiento  de  los  aportes  fundamentales de la Teoría General de Sistemas y del Enfoque Sistémico, identificar  las características de las organizaciones, comprender los procesos y funciones básicas de las organizaciones y valorar a los sistemas de información como un recurso de la organización, para la toma de decisiones.  '),
(8, 'Arquitectura de Computadoras', 'Los objetivos son aplicar los aspectos centrales que hacen a la tecnología de la computación y conceptos sobre hardware, plataformas y arquitecturas, para abordar las cuestiones vinculadas al procesamiento y a las comunicaciones.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subjects_teachers`
--

CREATE TABLE `subjects_teachers` (
  `subject_id` int NOT NULL,
  `teacher_id` int NOT NULL,
  `quotas` int DEFAULT NULL,
  `timetable` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `subjects_teachers`
--

INSERT INTO `subjects_teachers` (`subject_id`, `teacher_id`, `quotas`, `timetable`) VALUES
(4, 3, 32, '20.15'),
(6, 3, 19, '20.00'),
(6, 4, 22, '19.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `teachers`
--

CREATE TABLE `teachers` (
  `teacher_id` int NOT NULL,
  `user_id` int NOT NULL,
  `active` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `teachers`
--

INSERT INTO `teachers` (`teacher_id`, `user_id`, `active`) VALUES
(1, 15, 1),
(2, 10, 0),
(3, 11, 1),
(4, 13, 1),
(5, 14, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `user_id` int NOT NULL,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `last_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `role` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `id` int DEFAULT NULL,
  `password` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`user_id`, `name`, `last_name`, `role`, `id`, `password`) VALUES
(1, 'Elias', 'Lischinsky', 'Alumno', 43258801, 0x686f6c6161),
(2, 'Juan', 'Fernandez', 'Alumno', 68756453, 0x70656c75646f),
(3, 'Miguel', 'Andujar', 'Administrador', 31312432, 0x70696265),
(4, 'Leonardo', 'Fernandez', 'Administrador', 53454353, 0x6c6f7362657069),
(5, 'Juan', 'Alberto', 'Alumno', 432423423, 0x70656c6f746173),
(9, 'Adalberto', 'Gomez', 'Alumno', 3223423, 0x70616f6c6f73),
(10, 'Estanislao', 'Luguercio', 'Profesor', 4321324, 0x31323334),
(11, 'Juan', 'Cisneros', 'Profesor', 3245676, NULL),
(13, 'Marcelo', 'Vidal', 'Profesor', 4256789, ''),
(14, 'Pedro', 'Lambert', 'Profesor', 3214567, NULL),
(15, 'Nicolas', 'Vergesio', 'Profesor', 4567890, NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `student_subjects`
--
ALTER TABLE `student_subjects`
  ADD KEY `fk_nroal_usuarios` (`student_id`),
  ADD KEY `fk_almat_materias` (`subject_id`);

--
-- Indices de la tabla `subjects`
--
ALTER TABLE `subjects`
  ADD PRIMARY KEY (`subject_id`);

--
-- Indices de la tabla `subjects_teachers`
--
ALTER TABLE `subjects_teachers`
  ADD KEY `fk_mat` (`subject_id`),
  ADD KEY `fk_prof` (`teacher_id`);

--
-- Indices de la tabla `teachers`
--
ALTER TABLE `teachers`
  ADD PRIMARY KEY (`teacher_id`),
  ADD KEY `fk_profesor` (`user_id`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `subjects`
--
ALTER TABLE `subjects`
  MODIFY `subject_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `teachers`
--
ALTER TABLE `teachers`
  MODIFY `teacher_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `student_subjects`
--
ALTER TABLE `student_subjects`
  ADD CONSTRAINT `fk_almat_materias` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`subject_id`),
  ADD CONSTRAINT `fk_nroal_usuarios` FOREIGN KEY (`student_id`) REFERENCES `users` (`user_id`);

--
-- Filtros para la tabla `subjects_teachers`
--
ALTER TABLE `subjects_teachers`
  ADD CONSTRAINT `fk_mat` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`subject_id`),
  ADD CONSTRAINT `fk_prof` FOREIGN KEY (`teacher_id`) REFERENCES `teachers` (`teacher_id`);

--
-- Filtros para la tabla `teachers`
--
ALTER TABLE `teachers`
  ADD CONSTRAINT `fk_profesor` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
