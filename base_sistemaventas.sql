-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-07-2022 a las 18:26:38
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `base_sistemaventas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `codigo` int(9) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `nit` int(20) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `genero` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`codigo`, `nombre`, `nit`, `correo`, `genero`) VALUES
(1, 'Abramo', 100001, 'adahill0@mail.ru', 'm'),
(3, 'Codi', 100003, 'cjervois2@joomla.org', 'm'),
(5, 'Jamie', 100005, 'jbrosi4@redcross.org', 'f'),
(7, 'Joye', 100007, 'jgrange6@disqus.com', 'm'),
(8, 'Amos', 100008, 'arulf7@ow.ly', 'f'),
(11, 'Adham', 100011, 'afoyea@a8.net', 'm'),
(13, 'Steve', 100013, 'sstillyc@auda.org.au', 'f'),
(17, 'Guillermo', 100017, 'gpondg@blogspot.com', 'f'),
(19, 'Zora', 100019, 'zbinesteadi@hhs.gov', 'm'),
(21, 'Helen', 100021, 'hsedenk@engadget.com', 'm'),
(22, 'Goldy', 100022, 'gbettlesonl@about.me', 'f'),
(23, 'Leila', 100023, 'ledworthyem@hibu.com', 'm'),
(24, 'Allx', 100024, 'abaudoun@aol.com', 'm'),
(25, 'Everett', 100025, 'ekunzeo@nba.com', 'f'),
(27, 'Karlens', 100027, 'kdenizetq@loc.gov', 'm'),
(29, 'Junia', 100029, 'jgrovess@va.gov', 'm'),
(33, 'Ludwig', 100033, 'lirnysw@unicef.org', 'f'),
(35, 'Kathi', 100035, 'ksnelley@google.it', 'm'),
(36, 'Erny', 100036, 'efassumz@cisco.com', 'm'),
(39, 'Korie', 100039, 'klies12@t.co', 'f'),
(42, 'Obidiah', 100042, 'ocurtiss15@usa.gov', 'm'),
(43, 'Errol', 100043, 'emessam16@cdbaby.com', 'm'),
(51, 'Eveline', 100051, 'eomarkey1e@ask.com', 'f'),
(54, 'Lorettalorna', 100054, 'lboarder1h@irs.gov', 'f'),
(56, 'Spencer', 100056, 'shouseman1j@dell.com', 'm'),
(61, 'Rafe', 100061, 'rkolis1o@time.com', 'm'),
(63, 'Berget', 100063, 'bettery1q@scribd.com', 'f'),
(64, 'Hanson', 100064, 'helmes1r@google.it', 'm'),
(67, 'Bay', 100067, 'bhellwing1u@xing.com', 'f'),
(69, 'Blythe', 100069, 'bjahn1w@t.co', 'm'),
(70, 'Nance', 100070, 'nkobelt1x@nifty.com', 'f'),
(73, 'Consolata123', 100073, 'cladel20@time.com', 'f');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `codigo` int(9) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `cantidad` int(9) DEFAULT NULL,
  `precio` int(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`codigo`, `nombre`, `descripcion`, `cantidad`, `precio`) VALUES
(6, 'Milk - Skim', 'Graham, Miller and Weissnat', 100, 259),
(7, 'Herb Du Provence - Primerba', 'Emard, Haag and Larkin', 39, 100),
(8, 'Cookies - Englishbay Wht', 'Keebler, Bogisich and Mann', 56, 621),
(9, 'Coffee Cup 8oz 5338cd', 'Simonis-Mohr', 2, 777),
(10, 'Lettuce - Boston Bib', 'Cremin-Hintz', 11, 987),
(11, 'Noodles - Cellophane, Thin', 'Skiles, Block and Konopelski', 66, 570),
(12, 'Mushroom - King Eryingii', 'Kilback, Goyette and Padberg', 64, 5),
(13, 'Tortillas - Flour, 8', 'Mohr and Sons', 38, 774),
(14, 'Chevere Logs', 'Macejkovic, Heathcote and Keeling', 37, 401),
(15, 'Tea - Decaf Lipton', 'Ledner-Abshire', 2, 363),
(16, 'Lettuce - Iceberg', 'Osinski-Runolfsdottir', 9, 83),
(17, 'Chips Potato Salt Vinegar 43g', 'Mueller, Moen and Kirlin', 41, 978),
(18, 'Mushroom - Oyster, Fresh', 'Hudson-Beahan', 44, 962),
(19, 'Peas - Pigeon, Dry', 'Jakubowski, Morissette and Kulas', 35, 877),
(20, 'Gatorade - Xfactor Berry', 'Kassulke-Hand', 79, 840),
(21, 'Smoked Tongue', 'Haley LLC', 30, 667),
(22, 'Carrots - Mini, Stem On', 'Gislason, Runolfsson and Murazik', 35, 192),
(23, 'Cake - Pancake', 'Barrows Inc', 53, 501),
(24, 'Sauce - Vodka Blush', 'Torp, Howe and Daniel', 30, 382),
(25, 'Rice - Wild', 'Grant-Leffler', 13, 970),
(26, 'Rolled Oats', 'Ward and Sons', 26, 348),
(27, 'Miso - Soy Bean Paste', 'Leffler Inc', 28, 526),
(28, 'Parsley Italian - Fresh', 'McCullough-Trantow', 86, 950),
(29, 'Carroway Seed', 'Cummerata and Sons', 32, 993),
(30, 'Beef - Bresaola', 'Jones LLC', 79, 789),
(31, 'Sausage - Blood Pudding', 'Bailey, Powlowski and Hermiston', 53, 287),
(32, 'Sausage - Blood Pudding', 'Morissette and Sons', 27, 905),
(33, 'Appetizer - Mango Chevre', 'Bruen LLC', 73, 859),
(34, 'Squeeze Bottle', 'Barton and Sons', 27, 692),
(35, 'Ham - Virginia', 'Schowalter-Anderson', 62, 392),
(36, 'Wine - Riesling Dr. Pauly', 'Wyman-Ritchie', 40, 634),
(37, 'Pastrami', 'Kutch, Roberts and Koelpin', 92, 145),
(38, 'Mince Meat - Filling', 'Crooks-Olson', 75, 597),
(39, 'Mushroom - Crimini', 'Lockman, Hansen and Maggio', 20, 972),
(40, 'Cookie Double Choco', 'Ryan LLC', 93, 130),
(41, 'Pear - Packum', 'Ledner Inc', 2, 539),
(42, 'Peach - Halves', 'VonRueden, Langworth and Ebert', 42, 604),
(43, 'Radish - Black, Winter, Organic', 'Stiedemann, Jerde and Kilback', 45, 87),
(44, 'Beets - Candy Cane, Organic', 'Walsh-Walter', 13, 314),
(45, 'Juice - Propel Sport', 'Jast-Bogan', 2, 862),
(46, 'Island Oasis - Banana Daiquiri', 'Kessler Inc', 33, 490),
(47, 'Bread - White, Unsliced', 'Morar, Leuschke and Lehner', 77, 931),
(48, 'Wine - Pinot Noir Stoneleigh', 'Keebler Inc', 83, 635),
(49, 'Cake - Dulce De Leche', 'Daniel-Glover', 15, 348),
(50, 'Bay Leaf Fresh', 'Koelpin Group', 19, 392),
(51, 'Beer - Camerons Auburn', 'Osinski Group', 23, 679),
(52, 'Potatoes - Yukon Gold, 80 Ct', 'Will-Hackett', 78, 644),
(53, 'Soap - Hand Soap', 'Rempel-Romaguera', 10, 568),
(54, 'Broom - Angled', 'Johnston, Gleason and Beatty', 82, 562),
(55, 'Milk - Chocolate 500ml', 'Hayes-Harvey', 62, 264),
(56, 'Chickhen - Chicken Phyllo', 'Bayer-Nolan', 95, 653),
(57, 'Ecolab - Solid Fusion', 'Durgan, Welch and Leffler', 75, 941),
(58, 'Relish', 'Hegmann, Rau and Thiel', 73, 172),
(59, 'Beef Striploin Aaa', 'Maggio-Schiller', 50, 157),
(60, 'Chicken - Livers', 'Hoppe-Mann', 12, 750),
(61, 'Pepsi - Diet, 355 Ml', 'O\'Conner and Sons', 39, 277),
(62, 'Yoplait Drink', 'Heidenreich, Braun and Kiehn', 24, 684),
(63, 'Table Cloth 81x81 Colour', 'Huel and Sons', 37, 901),
(64, 'Bandage - Fexible 1x3', 'Kihn Group', 17, 970),
(65, 'Egg - Salad Premix', 'Anderson, Spencer and Legros', 30, 520),
(66, 'Garbage Bag - Clear', 'Bergstrom, Witting and Lubowitz', 82, 585),
(67, 'Bread - Dark Rye', 'VonRueden Inc', 34, 575),
(68, 'Wine - Rosso Del Veronese Igt', 'Mohr-McDermott', 20, 600),
(69, 'Pheasants - Whole', 'Waters Inc', 4, 117),
(70, 'Cookie Dough - Chunky', 'Ondricka, Hauck and Runolfsdottir', 38, 665),
(71, 'Soup Campbells Split Pea And Ham', 'Heidenreich Inc', 83, 811),
(72, 'Coconut - Creamed, Pure', 'Huel and Sons', 11, 34),
(73, 'Pastry - Chocolate Chip Muffin', 'Schuster-Runte', 39, 211),
(74, 'Bagel - Everything', 'Tremblay, Goldner and Gislason', 77, 945),
(75, 'Potatoes - Yukon Gold, 80 Ct', 'Rogahn and Sons', 6, 399),
(76, 'Stainless Steel Cleaner Vision', 'Russel, Ruecker and Stehr', 82, 694),
(77, 'Squash - Pepper', 'Osinski and Sons', 20, 396),
(78, 'Pork - Back Ribs', 'Kertzmann, Abshire and Terry', 98, 343),
(79, 'Wine - White, Riesling, Henry Of', 'Schuster-Dach', 5, 763),
(80, 'Barramundi', 'Hodkiewicz Group', 57, 331),
(81, 'Sesame Seed', 'Sauer, Murray and Haag', 64, 820),
(82, 'Vol Au Vents', 'Sanford and Sons', 66, 552),
(83, 'Sauce - Thousand Island', 'Runte Inc', 49, 281),
(84, 'Sambuca - Opal Nera', 'Reinger LLC', 56, 950),
(85, 'Soup Campbells Split Pea And Ham', 'Ondricka-Johns', 37, 196),
(86, 'Lettuce - Lolla Rosa', 'Moore, Kshlerin and Hand', 26, 811),
(87, 'Extract - Lemon', 'Lynch, Douglas and Dickens', 95, 981),
(88, 'Bread - Sour Batard', 'Cartwright-Jacobson', 86, 581),
(89, 'Juice - Grapefruit, 341 Ml', 'Grant, Hermiston and Kohler', 11, 542),
(90, 'Shrimp - Black Tiger 16/20', 'Brown, Gerhold and Stracke', 53, 667),
(91, 'Table Cloth 81x81 White', 'Murray-Homenick', 58, 190),
(92, 'Chocolate - Dark Callets', 'Skiles-Lang', 71, 207),
(93, 'Garlic Powder', 'Hills-Morar', 12, 897),
(94, 'C - Plus, Orange', 'Runolfsdottir LLC', 91, 52),
(95, 'Sproutsmustard Cress', 'Kohler, Mitchell and Stiedemann', 1, 625),
(96, 'Bread - Sour Sticks With Onion', 'Klocko and Sons', 96, 157),
(97, 'Chocolate - Unsweetened', 'Klein-Kuvalis', 90, 539),
(98, 'Tomatoes - Roma', 'Parisian-Bauch', 24, 532),
(99, 'Crab Brie In Phyllo', 'Auer Inc', 68, 180),
(100, 'Chocolate Liqueur - Godet White', 'Beier-Kautzer', 13, 445),
(101, 'Veal Inside - Provimi', 'VonRueden-Zulauf', 27, 537),
(102, 'Muffin - Mix - Strawberry Rhubarb', 'Luettgen-Beer', 55, 167),
(103, 'Pork - Butt, Boneless', 'Bruen-Friesen', 82, 572),
(104, 'Mushroom - Shitake, Dry', 'Bartoletti Group', 19, 198),
(105, 'Tomatillo', 'Batz Inc', 15, 597),
(106, 'Crab Meat Claw Pasteurise', 'Olson-Cruickshank', 62, 971),
(107, 'Soup - French Can Pea', 'Witting Inc', 14, 96),
(108, 'Shichimi Togarashi Peppeers', 'Dietrich-Lang', 24, 794),
(109, 'Halibut - Whole, Fresh', 'Gottlieb-Friesen', 4, 166),
(110, 'Apricots Fresh', 'Tremblay, Halvorson and Reinger', 77, 974),
(111, 'Cake - Box Window 10x10x2.5', 'Koss-Littel', 1, 776),
(112, 'Russian Prince', 'Bernhard, Skiles and Green', 55, 211),
(113, 'Appetizer - Sausage Rolls', 'Considine LLC', 30, 34),
(114, 'Mushroom - Chanterelle, Dry', 'Marquardt and Sons', 90, 785),
(115, 'Vacuum Bags 12x16', 'Smitham-Quitzon', 32, 341),
(116, 'Wine - Maipo Valle Cabernet', 'Kihn, Cartwright and Cummings', 44, 861),
(117, 'Dc - Sakura Fu', 'Nikolaus-Moore', 16, 863),
(118, 'Chicken - Base, Ultimate', 'Rolfson and Sons', 38, 873),
(119, 'Lid - Translucent, 3.5 And 6 Oz', 'Hammes-Olson', 99, 369),
(120, '7up Diet, 355 Ml', 'Jones, Abbott and Hirthe', 91, 53),
(121, 'Coffee - Cafe Moreno', 'Spencer, Cruickshank and Kihn', 68, 796),
(122, 'Tea - Orange Pekoe', 'Treutel, Connelly and Gibson', 10, 530),
(123, 'Turkey - Oven Roast Breast', 'Mraz, Herman and Bogisich', 83, 833),
(124, 'Pecan Raisin - Tarts', 'Brakus-Kassulke', 75, 107),
(125, 'Beef - Shank', 'Cummerata-Wiegand', 83, 89),
(126, 'Oil - Olive Bertolli', 'Smitham-Torphy', 20, 138),
(127, 'Bagelers - Cinn / Brown', 'Douglas Inc', 37, 379),
(128, 'Taro Root', 'Gutkowski, Nicolas and Bahringer', 74, 392),
(129, 'Ecolab - Hobart Washarm End Cap', 'Bayer, Johns and Breitenberg', 52, 272),
(130, 'Calvados - Boulard', 'Deckow and Sons', 32, 793),
(131, 'Cut Wakame - Hanawakaba', 'Auer LLC', 87, 220),
(132, 'Mushroom - Trumpet, Dry', 'Hegmann-Baumbach', 41, 483),
(133, 'Cookies - Assorted', 'Macejkovic, Pouros and Kuhn', 11, 978),
(134, 'Jolt Cola - Red Eye', 'Shields LLC', 97, 576),
(135, 'Marsala - Sperone, Fine, D.o.c.', 'Hoeger and Sons', 13, 315),
(136, 'Mikes Hard Lemonade', 'Nienow LLC', 47, 367),
(137, 'Bandage - Flexible Neon', 'Jast-Barton', 58, 484),
(138, 'Longos - Assorted Sandwich', 'Runte-Erdman', 13, 758),
(139, 'Tomatoes - Yellow Hot House', 'Herman Inc', 19, 554),
(140, 'Huck White Towels', 'Gutmann-Lebsack', 20, 215),
(141, 'Tart - Lemon', 'Yundt-VonRueden', 12, 439),
(142, 'Cheese - Parmesan Grated', 'Kshlerin-Kunze', 26, 304),
(143, 'Shiratamako - Rice Flour', 'Bailey Inc', 24, 45),
(144, 'Wheat - Soft Kernal Of Wheat', 'Durgan-Ritchie', 76, 278),
(145, 'Beef - Bones, Marrow', 'Rolfson LLC', 89, 894),
(146, 'Coriander - Seed', 'Schmitt, Ritchie and Ortiz', 74, 750),
(147, 'Tea - Mint', 'Stehr and Sons', 69, 704),
(148, 'Lid Tray - 12in Dome', 'Stark, Padberg and Pouros', 71, 333),
(149, 'Beef - Flank Steak', 'Balistreri-Ryan', 55, 624),
(151, 'Rompe Tormentas', 'Arma de Thor', 1, 100);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sucursales`
--

CREATE TABLE `sucursales` (
  `codigo` int(9) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `telefono` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `sucursales`
--

INSERT INTO `sucursales` (`codigo`, `nombre`, `direccion`, `correo`, `telefono`) VALUES
(3, 'Metz-Reinger', '279 Larry Lane', 'jitskovitz2@friendfeed.com', 3),
(4, 'Kreiger and Sons', '8 Novick Lane', 'eboraston3@apache.org', 4),
(5, 'Jaskolski Inc', '333 Bartelt Circle', 'rheinreich4@nsw.gov.au', 5),
(6, 'Dickinson-Schoen', '34 Delaware Way', 'afuster5@unblog.fr', 6),
(7, 'Hermiston-Brekke', '47391 Rowland Road', 'bsegot6@abc.net.au', 7),
(8, 'Schamberger, Shields and Corwin', '9552 Sommers Point', 'ehartburn7@about.me', 8),
(9, 'Harvey Group', '3730 Sundown Plaza', 'ctrees8@fema.gov', 9),
(10, 'Deckow-Walter', '62 Troy Street', 'jpim9@altervista.org', 10),
(11, 'Bednar and Sons', '07 Texas Pass', 'clevisa@linkedin.com', 11),
(12, 'McCullough Group', '898 Elka Center', 'dtronib@dailymail.co.uk', 12),
(13, 'Harris, McKenzie and Hintz', '66403 Morningstar Hill', 'gfoldc@amazonaws.com', 13),
(14, 'Volkman-Kuphal', '29 Leroy Alley', 'wdayleyd@tinypic.com', 14),
(15, 'Rogahn, Bins and Wintheiser', '80988 Ridgeview Hill', 'fjanoute@ycombinator.com', 15),
(16, 'Collier-Kulas', '86 Heath Plaza', 'jyounglovef@nymag.com', 16),
(17, 'Johnston and Sons', '0261 Nancy Trail', 'pharlingg@tinypic.com', 17),
(18, 'Macejkovic-VonRueden', '09 Lillian Hill', 'mespinhah@jiathis.com', 18),
(19, 'Bailey Group', '3586 Amoth Crossing', 'wgerriti@bloomberg.com', 19),
(20, 'Shields-Dickens', '64597 Walton Center', 'lwishamj@google.com.au', 20),
(21, 'Mayer, Roob and Wiza', '0 Manitowish Way', 'pbernardeschik@dion.ne.jp', 21),
(22, 'O\'Reilly LLC', '516 Forest Dale Crossing', 'sbirkinshawl@geocities.jp', 22),
(23, 'Stokes-Aufderhar', '8370 Texas Hill', 'mpykem@clickbank.net', 23),
(24, 'Hettinger-Erdman', '400 Pankratz Circle', 'pciobutaron@virginia.edu', 24),
(25, 'Schinner and Sons', '6114 Marquette Trail', 'ciacoboo@studiopress.com', 25),
(26, 'Abshire and Sons', '76776 Service Avenue', 'hwillersonp@list-manage.com', 26),
(27, 'Kautzer, Parker and Parker', '3 Thompson Avenue', 'jbalsdoneq@cornell.edu', 27),
(28, 'Greenfelder-Gerhold', '63383 Stoughton Terrace', 'ialdenr@omniture.com', 28),
(29, 'Daniel Group', '792 Golf Court', 'sbailes@bloglovin.com', 29),
(30, 'Waelchi, Johnston and King', '07014 Pepper Wood Terrace', 'kroskellyt@icq.com', 30),
(31, 'Weimann-Gutmann', '4815 Florence Way', 'avinnicombeu@nps.gov', 31),
(32, 'Runte-Jacobs', '98 Oxford Pass', 'bdumbletonv@amazon.com', 32),
(33, 'Gutmann LLC', '71 Bultman Place', 'bsawneyw@mozilla.org', 33),
(34, 'Harris-Heaney', '6 Leroy Alley', 'eocarranx@facebook.com', 34),
(35, 'Dach LLC', '5736 Chive Lane', 'ccurtissy@google.de', 35),
(36, 'Bogisich, Torphy and Lakin', '37 Service Avenue', 'blauxmannz@prweb.com', 36),
(37, 'Kuhn, Douglas and Davis', '20 Lotheville Court', 'erenachowski10@networkadvertising.org', 37),
(38, 'Bechtelar Inc', '02429 Atwood Place', 'jkillock11@yandex.ru', 38),
(39, 'Thompson-Kemmer', '2226 Rigney Pass', 'ccruz12@bigcartel.com', 39),
(41, 'Junior', 'zona 21', 'jnfg', 1234);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vendedores`
--

CREATE TABLE `vendedores` (
  `codigo` int(9) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `caja` int(20) DEFAULT NULL,
  `ventas` int(20) DEFAULT NULL,
  `genero` varchar(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `vendedores`
--

INSERT INTO `vendedores` (`codigo`, `nombre`, `caja`, `ventas`, `genero`) VALUES
(1, 'Katrinka', 101, 0, 'm'),
(2, 'Katleen', 102, 0, 'm'),
(3, 'Felizio', 103, 0, 'm'),
(4, 'Arnie', 104, 0, 'f'),
(5, 'Edwin', 105, 0, 'f'),
(6, 'Laurens', 106, 0, 'f'),
(7, 'Allianora', 107, 0, 'm'),
(8, 'Johnnie', 108, 0, 'f'),
(9, 'Kala', 109, 0, 'm'),
(10, 'Terrijo', 110, 0, 'm'),
(11, 'Broderick', 111, 0, 'f'),
(12, 'Junia', 112, 0, 'm'),
(13, 'Myrah', 113, 0, 'm'),
(14, 'Wendeline', 114, 0, 'm'),
(15, 'Malcolm', 115, 0, 'm'),
(16, 'Otis', 116, 0, 'm'),
(17, 'Sanford', 117, 0, 'm'),
(18, 'Bar', 118, 0, 'm'),
(19, 'Dulcia', 119, 0, 'm'),
(20, 'Lynelle', 120, 0, 'm'),
(21, 'Thane', 121, 0, 'f'),
(22, 'Hadria', 122, 0, 'f'),
(23, 'Jeth', 123, 0, 'm'),
(24, 'Ax', 124, 0, 'm'),
(25, 'Ray', 125, 0, 'm'),
(26, 'Saree', 126, 0, 'f'),
(27, 'Milton', 127, 0, 'f'),
(28, 'Brietta', 128, 0, 'm'),
(29, 'Edgardo', 129, 0, 'm'),
(30, 'Celle', 130, 0, 'f'),
(31, 'Vonni', 131, 0, 'f'),
(32, 'Audry', 132, 0, 'f'),
(33, 'Quintus', 133, 0, 'm'),
(34, 'Jammie', 134, 0, 'f'),
(35, 'Sigismondo', 135, 0, 'm'),
(36, 'Woodrow', 136, 0, 'f'),
(37, 'Armand', 137, 0, 'm'),
(38, 'Carce', 138, 0, 'm'),
(39, 'Damaris', 139, 0, 'm'),
(40, 'Libbi', 140, 0, 'm'),
(41, 'Graham', 141, 0, 'f'),
(42, 'Ollie', 142, 0, 'f'),
(43, 'Beilul', 143, 0, 'f'),
(44, 'Carolee', 144, 0, 'm'),
(45, 'Valery', 145, 0, 'm'),
(46, 'Alicia', 146, 0, 'm'),
(47, 'Selle', 147, 0, 'f'),
(48, 'Cindra', 148, 0, 'm'),
(49, 'Loni', 149, 0, 'm'),
(50, 'Ferdinanda', 150, 0, 'm'),
(51, 'Giovanni', 151, 0, 'f'),
(52, 'Gawen', 152, 0, 'm'),
(53, 'Violette', 153, 0, 'm'),
(54, 'Raquel', 154, 0, 'm'),
(55, 'Pandora', 155, 0, 'm'),
(56, 'Marve', 156, 0, 'f'),
(57, 'Lenee', 157, 0, 'm'),
(58, 'Marji', 158, 0, 'f'),
(59, 'Conrado', 159, 0, 'f'),
(60, 'Lynde', 160, 0, 'm'),
(61, 'Sisely', 161, 0, 'f'),
(62, 'Willey', 162, 0, 'm'),
(63, 'Sharl', 163, 0, 'f'),
(64, 'Hannis', 164, 0, 'f'),
(65, 'Allen', 165, 0, 'm'),
(66, 'Kelwin', 166, 0, 'f'),
(67, 'Zerk', 167, 0, 'f'),
(68, 'Talbot', 168, 0, 'm'),
(69, 'Jacqueline', 169, 0, 'm'),
(70, 'Nessy', 170, 0, 'f'),
(71, 'Hale', 171, 0, 'm'),
(72, 'Garrick', 172, 0, 'm'),
(73, 'Davidde', 173, 0, 'm'),
(74, 'Leonardo', 174, 0, 'f'),
(75, 'Wolfy', 175, 0, 'f'),
(76, 'Skippie', 176, 0, 'f'),
(77, 'Corena', 177, 0, 'm'),
(78, 'Charmion', 178, 0, 'f'),
(79, 'Mariellen', 179, 0, 'f'),
(80, 'Ashlee', 180, 0, 'm'),
(81, 'Kristofer', 181, 0, 'f'),
(82, 'Darla', 182, 0, 'm'),
(83, 'Bonny', 183, 0, 'f'),
(84, 'Regine', 184, 0, 'f'),
(85, 'Tracee', 185, 0, 'm'),
(86, 'Hughie', 186, 0, 'm'),
(87, 'Cobbie', 187, 0, 'm'),
(88, 'Monika', 188, 0, 'f'),
(89, 'Ramsay', 189, 0, 'm'),
(90, 'Oralie', 190, 0, 'f'),
(91, 'Kenneth', 191, 0, 'f'),
(92, 'Marylynne', 192, 0, 'm'),
(93, 'Rochelle', 193, 0, 'm'),
(94, 'Anica', 194, 0, 'm'),
(95, 'Stan', 195, 0, 'f'),
(96, 'Donnie', 196, 0, 'f'),
(97, 'Jenna', 197, 0, 'f'),
(98, 'Colene', 198, 0, 'm'),
(99, 'Marlo', 199, 0, 'm'),
(100, 'Saloma', 200, 0, 'f'),
(101, 'Karalynn', 201, 0, 'f'),
(102, 'Dacy', 202, 0, 'm'),
(103, 'Kendra', 203, 0, 'm'),
(104, 'Hildegarde', 204, 0, 'm'),
(105, 'Sutherlan', 205, 0, 'm'),
(106, 'June', 206, 0, 'f'),
(107, 'Meggy', 207, 0, 'm'),
(108, 'Cristina', 208, 0, 'm'),
(109, 'Colly', 209, 0, 'f'),
(110, 'Alexandro', 210, 0, 'f'),
(111, 'Zolly', 211, 0, 'f'),
(112, 'Roberto', 212, 0, 'm'),
(113, 'Claudette', 213, 0, 'f'),
(114, 'Candide', 214, 0, 'm'),
(115, 'Zorah', 215, 0, 'm'),
(116, 'Nancee', 216, 0, 'f'),
(117, 'Kory', 217, 0, 'f'),
(118, 'Stanislaus', 218, 0, 'f'),
(119, 'Orran', 219, 0, 'f'),
(120, 'Margery', 220, 0, 'm'),
(121, 'Etta', 221, 0, 'm'),
(122, 'Callie', 222, 0, 'f'),
(123, 'Jolynn', 223, 0, 'f'),
(124, 'Jesselyn', 224, 0, 'm'),
(125, 'Cirillo', 225, 0, 'f'),
(126, 'Laney', 226, 0, 'm'),
(127, 'Minny', 227, 0, 'f'),
(128, 'Vin', 228, 0, 'm'),
(129, 'Karita', 229, 0, 'f'),
(130, 'Rickie', 230, 0, 'f'),
(131, 'Tris', 231, 0, 'f'),
(132, 'Aile', 232, 0, 'm'),
(133, 'Grover', 233, 0, 'f'),
(134, 'Flora', 234, 0, 'm'),
(135, 'Jeffry', 235, 0, 'm'),
(136, 'Gustavus', 236, 0, 'f'),
(137, 'Ada', 237, 0, 'm'),
(138, 'Jenn', 238, 0, 'f'),
(139, 'Nata', 239, 0, 'm'),
(140, 'Merissa', 240, 0, 'f'),
(141, 'Tate', 241, 0, 'm'),
(142, 'Prent', 242, 0, 'f'),
(143, 'Rickie', 243, 0, 'f'),
(144, 'Meridith', 244, 0, 'f'),
(145, 'Reina', 245, 0, 'f'),
(146, 'Ellsworth', 246, 0, 'm'),
(147, 'Prentice', 247, 0, 'f'),
(148, 'Nanny', 248, 0, 'm'),
(149, 'Ofelia', 249, 0, 'f'),
(150, 'Birk', 250, 0, 'm'),
(151, 'Deirdre', 251, 0, 'f'),
(152, 'Ashly', 252, 0, 'f'),
(153, 'Lucias', 253, 0, 'f'),
(154, 'Urban', 254, 0, 'm'),
(155, 'Bronny', 255, 0, 'f'),
(156, 'Averyl', 256, 0, 'm'),
(157, 'Sheilakathryn', 257, 0, 'm'),
(158, 'Vinnie', 258, 0, 'f'),
(159, 'Ferdinand', 259, 0, 'f'),
(160, 'Peirce', 260, 0, 'm'),
(161, 'Oliver', 261, 0, 'f'),
(162, 'Letizia', 262, 0, 'f'),
(163, 'Inglis', 263, 0, 'f'),
(164, 'Tisha', 264, 0, 'm'),
(165, 'Thomasin', 265, 0, 'm'),
(166, 'Joyann', 266, 0, 'm'),
(167, 'Glenine', 267, 0, 'm'),
(168, 'Ashia', 268, 0, 'f'),
(169, 'Clarice', 269, 0, 'f'),
(170, 'Gerrard', 270, 0, 'm'),
(171, 'Aurore', 271, 0, 'm'),
(172, 'Ashlen', 272, 0, 'f'),
(173, 'Celeste', 273, 0, 'f'),
(174, 'Alecia', 274, 0, 'f'),
(175, 'Fannie', 275, 0, 'f'),
(176, 'Luke', 276, 0, 'm'),
(177, 'Lilian', 277, 0, 'm'),
(178, 'Bertram', 278, 0, 'm'),
(179, 'Giacopo', 279, 0, 'f'),
(180, 'Maggi', 280, 0, 'f'),
(181, 'Roxy', 281, 0, 'f'),
(182, 'Burch', 282, 0, 'f'),
(183, 'Kip', 283, 0, 'f'),
(184, 'Ruthi', 284, 0, 'm'),
(185, 'Avictor', 285, 0, 'm'),
(186, 'Rosamond', 286, 0, 'f'),
(187, 'Chad', 287, 0, 'f'),
(188, 'Karin', 288, 0, 'm'),
(189, 'Brandon', 289, 0, 'f'),
(190, 'Remus', 290, 0, 'f'),
(191, 'Millisent', 291, 0, 'f'),
(192, 'Karissa', 292, 0, 'm'),
(193, 'Bayard', 293, 0, 'm'),
(194, 'Agnella', 294, 0, 'f'),
(195, 'Britta', 295, 0, 'f'),
(196, 'Jeffry', 296, 0, 'f'),
(197, 'Natalee', 297, 0, 'm'),
(200, 'Christean', 350, 0, 'f'),
(201, 'Junior', 100, 100, 'm');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `sucursales`
--
ALTER TABLE `sucursales`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `vendedores`
--
ALTER TABLE `vendedores`
  ADD PRIMARY KEY (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
