CREATE TABLE if not exists HIGH_SCORES (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(255) NOT NULL,
    score INT NOT NULL,
    highscore_date DATE NOT NULL,
    archive boolean DEFAULT FALSE);
CREATE SEQUENCE IF NOT EXISTS HIGHSCORE_SEQ;
-- use line below to resset the highscore seq to 1 again
-- ALTER SEQUENCE HIGHSCORE_SEQ RESTART WITH 1;
-- INSERT INTO HIGH_SCORES (user_name, score, highscore_date, archive)
-- VALUES
-- ();


CREATE TABLE if not exists GAMES (
    raceId  int,
    host    varchar(50),
    player2 varchar(50),
    player3 varchar(50),
    player4 varchar(50));

-- INSERT INTO HIGH_SCORES (user_name, score, highscore_date)
-- VALUES ('test', '1', '2023-05-27');


CREATE TABLE if not exists questions (
    ID  int AUTO_INCREMENT PRIMARY KEY NOT NULL,
    QUESTION_TEXT VARCHAR(255) NOT NULL UNIQUE,
    ANSWER1 VARCHAR(255) NOT NULL,
    ANSWER2 VARCHAR(255),
    ANSWER3 VARCHAR(255),
    ANSWER4 VARCHAR(255),
    CORRECT_ANSWER VARCHAR(255) NOT NULL,
    GROUP_PARAMETER VARCHAR(50) NOT NULL,
    LANGUAGE VARCHAR(2) NOT NULL,
    ARCHIVED BOOLEAN DEFAULT FALSE);

ALTER TABLE questions ALTER COLUMN archived SET DEFAULT FALSE;
INSERT INTO questions (QUESTION_TEXT, ANSWER1, ANSWER2, ANSWER3, ANSWER4, CORRECT_ANSWER, GROUP_PARAMETER, LANGUAGE)
VALUES
-- nl
-- Group 1: Auto
    ('Wat is de oudste speelgoedauto ter wereld?', 'Model T Ford', 'Mercedes-Benz', 'Volkswagen Kever', 'Toyota Corolla', 'Model T Ford', 'Group 1', 'nl'),
    ('Welke autofabrikant produceerde de eerste massaal geproduceerde auto?', 'Ford', 'Mercedes-Benz', 'Volkswagen', 'Toyota', 'Ford', 'Group 1', 'nl'),
    ('Welk automerk staat bekend om zijn sportwagens zoals de 911?', 'Porsche', 'Ferrari', 'Lamborghini', 'Bugatti', 'Porsche', 'Group 1', 'nl'),
    ('Welke auto wordt vaak geassocieerd met James Bond?', 'Aston Martin', 'BMW', 'Lexus', 'Jaguar', 'Aston Martin', 'Group 1', 'nl'),
    ('Welke auto staat bekend als een icoon van de Amerikaanse auto-industrie?', 'Chevrolet Corvette', 'Ford Mustang', 'Dodge Challenger', 'Cadillac Escalade', 'Ford Mustang', 'Group 1', 'nl'),
    ('In welk jaar werd de eerste auto met verbrandingsmotor gebouwd?', '1886', '1901', '1920', '1955', '1886', 'Group 1', 'nl'),
    ('Welke auto wordt vaak geassocieerd met de hippiecultuur in de jaren ''60?', 'Volkswagen Kever', 'Ford Mustang', 'Chevrolet Camaro', 'Mini Cooper', 'Volkswagen Kever', 'Group 1', 'nl'),
    ('Welke autofabrikant staat bekend om zijn luxe en prestigieuze voertuigen?', 'Mercedes-Benz', 'Toyota', 'Honda', 'Hyundai', 'Mercedes-Benz', 'Group 1', 'nl'),
    ('Welke auto won de titel "Auto van het Jaar 2022"?', 'Volvo XC40', 'Tesla Model 3', 'Audi A4', 'Mazda MX-5', 'Volvo XC40', 'Group 1', 'nl'),
    ('Welk automerk produceerde de eerste hybride auto voor massaproductie?', 'Toyota', 'Honda', 'Lexus', 'Nissan', 'Toyota', 'Group 1', 'nl'),
-- Group 2: Poppen
    ('Wie is de bekendste pop ter wereld?', 'Barbie', 'Teddybeer', 'Cabbage Patch Kids', 'Raggedy Ann', 'Barbie', 'Group 2', 'nl'),
    ('Welk bedrijf produceert de poppenlijn Monster High?', 'Mattel', 'Hasbro', 'Lego', 'Playmobil', 'Mattel', 'Group 2', 'nl'),
    ('Welke pop werd geïnspireerd door een stripverhaal uit België?', 'Suske en Wiske', 'Kuifje', 'Smurfen', 'Lucky Luke', 'Kuifje', 'Group 2', 'nl'),
    ('Welk type pop staat bekend om zijn knuffelbaarheid en zachte vulling?', 'Knuffelpop', 'Modepop', 'Porseleinen pop', 'Houten pop', 'Knuffelpop', 'Group 2', 'nl'),
    ('Welke pop werd geïntroduceerd als de tegenhanger van Barbie en heeft een meer realistisch lichaamsbeeld?', 'Lammily', 'Bratz', 'Sindy', 'Troll', 'Lammily', 'Group 2', 'nl'),
    ('Welke poppenlijn was gebaseerd op de personages uit een populaire tekenfilmserie?', 'My Little Pony', 'Strawberry Shortcake', 'Care Bears', 'Rainbow Brite', 'My Little Pony', 'Group 2', 'nl'),
    ('Welke pop werd geassocieerd met de beroemde uitspraak "Mama!"?', 'Baby Born', 'Cabbage Patch Kids', 'Baby Alive', 'Chou Chou', 'Baby Born', 'Group 2', 'nl'),
    ('Welke pop werd geïntroduceerd in 1959 en staat bekend om haar modieuze kleding en accessoires?', 'Barbie', 'Blythe', 'American Girl', 'Skipper', 'Barbie', 'Group 2', 'nl'),
    ('Welk bedrijf produceert de poppenlijn Lalaloopsy?', 'MGA Entertainment', 'Spin Master', 'Fisher-Price', 'Playmates Toys', 'MGA Entertainment', 'Group 2', 'nl'),
    ('Welke pop werd beroemd door haar verhaal als een levend speelgoed in een kinderdagverblijf?', 'Jessie', 'Bo Peep', 'Hamm', 'Bullseye', 'Jessie', 'Group 2', 'nl'),
-- Group 3: Bouwsets
    ('Welk bouwsetmerk heeft een themapark in Denemarken?', 'LEGO', 'K''NEX', 'Mega Bloks', 'Playmobil', 'LEGO', 'Group 3', 'nl'),
    ('Welke bouwset is gebaseerd op de films en personages van Star Wars?', 'LEGO Star Wars', 'Mega Bloks Halo', 'K''NEX Mario Kart', 'Playmobil City Life', 'LEGO Star Wars', 'Group 3', 'nl'),
    ('Welk bouwsetmerk is bekend om zijn plastic bouwstenen met noppen?', 'LEGO', 'K''NEX', 'Mega Bloks', 'Lincoln Logs', 'LEGO', 'Group 3', 'nl'),
    ('Welk bouwsetmerk biedt een verscheidenheid aan sets met thema''s zoals kastelen, piraten en ruimtevaart?', 'Playmobil', 'LEGO Technic', 'Mega Bloks First Builders', 'K''NEX Super Mario', 'Playmobil', 'Group 3', 'nl'),
    ('Welk bouwsetmerk staat bekend om zijn magnetische bouwstenen?', 'Geomag', 'LEGO Classic', 'Mega Bloks Barbie', 'K''NEX Thrill Rides', 'Geomag', 'Group 3', 'nl'),
    ('Welke bouwset is ontworpen om te worden aangesloten op een interactieve app?', 'LEGO Hidden Side', 'Mega Bloks Power Rangers', 'K''NEX Mario Kart', 'Playmobil City Action', 'LEGO Hidden Side', 'Group 3', 'nl'),
    ('Welk bouwsetmerk biedt een reeks bouwstenen die kunnen worden gebruikt om functionele machines te bouwen?', 'K''NEX', 'LEGO Creator', 'Mega Bloks Despicable Me', 'Playmobil Dollhouse', 'K''NEX', 'Group 3', 'nl'),
    ('Welk bouwsetmerk staat bekend om zijn grote, stevige bouwstenen voor jonge kinderen?', 'Mega Bloks', 'LEGO DUPLO', 'K''NEX Mighty Makers', 'Playmobil 1.2.3', 'LEGO DUPLO', 'Group 3', 'nl'),
    ('Welke bouwset is ontworpen om te worden gebruikt in combinatie met elektronische circuits?', 'LittleBits', 'LEGO Mindstorms', 'Mega Bloks Skylanders', 'K''NEX Education', 'LittleBits', 'Group 3', 'nl'),
    ('Welk bouwsetmerk is bekend om zijn modulaire gebouwen en stadslandschappen?', 'LEGO Creator Expert', 'Mega Bloks American Girl', 'K''NEX Super Mario', 'Playmobil Wild Life', 'LEGO Creator Expert', 'Group 3', 'nl'),
-- Group 4: Puzzels
    ('Welk type puzzel bestaat uit negen vierkante stukken die in een vierkant patroon zijn gerangschikt?', 'Schuifpuzzel', 'Legpuzzel', 'Woordzoeker', 'Sudoku', 'Schuifpuzzel', 'Group 4', 'nl'),
    ('Welke puzzel bestaat uit een rechthoekig raster met cijfers die aanwijzingen geven voor de plaatsing van bepaalde cijfers?', 'Sudoku', 'Cryptogram', 'Kruiswoordpuzzel', 'Kakuro', 'Sudoku', 'Group 4', 'nl'),
    ('Welke puzzel bestaat uit stukjes die moeten worden samengevoegd om een afbeelding of patroon te vormen?', 'Legpuzzel', 'Schaakpuzzel', 'Rubiks kubus', 'Tangram', 'Legpuzzel', 'Group 4', 'nl'),
    ('Welke puzzel bestaat uit een rooster van zwarte en witte vakjes die moeten worden gevuld met letters om woorden te vormen?', 'Kruiswoordpuzzel', 'Cryptogram', 'Sudoku', 'Woordzoeker', 'Kruiswoordpuzzel', 'Group 4', 'nl'),
    ('Welke puzzel bestaat uit een verzameling stukjes die moeten worden gerangschikt om een driedimensionale structuur te vormen?', '3D-puzzel', 'Schuifpuzzel', 'Tangram', 'Rubiks kubus', '3D-puzzel', 'Group 4', 'nl'),
    ('Welke puzzel bestaat uit een verzameling cijfers die moeten worden geordend volgens een bepaalde logica?', 'Logische puzzel', 'Kruiswoordpuzzel', 'Sudoku', 'Cryptogram', 'Logische puzzel', 'Group 4', 'nl'),
    ('Welke puzzel bestaat uit een reeks cryptische aanwijzingen die moeten worden opgelost om een woord of zin te vinden?', 'Cryptogram', 'Kakuro', 'Kruiswoordpuzzel', 'Sudoku', 'Cryptogram', 'Group 4', 'nl'),
    ('Welke puzzel bestaat uit een set van zeven geometrische stukken die kunnen worden gecombineerd om verschillende vormen te vormen?', 'Tangram', 'Legpuzzel', 'Schaakpuzzel', 'Rubiks kubus', 'Tangram', 'Group 4', 'nl'),
    ('Welke puzzel bestaat uit een reeks getallen en wiskundige operatoren die moeten worden gecombineerd om een bepaald doelgetal te bereiken?', 'Rekenpuzzel', 'Sudoku', 'Kruiswoordpuzzel', 'Cryptogram', 'Rekenpuzzel', 'Group 4', 'nl'),
    ('Welke puzzel bestaat uit een set van 27 kleine kubussen die kunnen worden geroteerd om een grotere kubus te vormen?', 'Rubiks kubus', 'Schuifpuzzel', 'Legpuzzel', 'Tangram', 'Rubiks kubus', 'Group 4', 'nl'),
-- Group 5: Knuffels
    ('Welk knuffeldier staat bekend om zijn zwarte en witte strepen?', 'Zebra', 'Tijger', 'Panda', 'Luipaard', 'Zebra', 'Group 5', 'nl'),
    ('Welk knuffeldier wordt vaak geassocieerd met Australië en heeft een buidel om zijn jongen te dragen?', 'Kangoeroe', 'Koala', 'Wombat', 'Emoe', 'Kangoeroe', 'Group 5', 'nl'),
    ('Welk knuffeldier wordt beschouwd als het nationale symbool van China?', 'Panda', 'Olifant', 'Giraf', 'Kameel', 'Panda', 'Group 5', 'nl'),
    ('Welk knuffeldier staat bekend om zijn lange nek en gevlekte vacht?', 'Giraf', 'Leeuw', 'Nijlpaard', 'Krokodil', 'Giraf', 'Group 5', 'nl'),
    ('Welk knuffeldier is bekend om zijn grote oren en lange slurf?', 'Olifant', 'Koala', 'Zebra', 'Gorilla', 'Olifant', 'Group 5', 'nl'),
    ('Welk knuffeldier staat bekend om zijn zwart-witte vacht en bamboe eten?', 'Panda', 'Koala', 'Tijger', 'Pinguïn', 'Panda', 'Group 5', 'nl'),
    ('Welk knuffeldier wordt vaak geassocieerd met de Noordpool en heeft een witte vacht en zwarte neus?', 'IJsbeer', 'Walrus', 'Pinguïn', 'Orka', 'IJsbeer', 'Group 5', 'nl'),
    ('Welk knuffeldier wordt vaak afgebeeld als een roze varken met een gekrulde staart?', 'Varken', 'Ezel', 'Konijn', 'Schaap', 'Varken', 'Group 5', 'nl'),
    ('Welk knuffeldier staat bekend om zijn harige uiterlijk en zijn liefde voor honing?', 'Beer', 'Lynx', 'Vos', 'Wasbeer', 'Beer', 'Group 5', 'nl'),
    ('Welk knuffeldier wordt vaak geassocieerd met de jungle en heeft een brullende roep?', 'Leeuw', 'Tijger', 'Aap', 'Krokodil', 'Leeuw', 'Group 5', 'nl'),
-- fr
-- Group 1: Voitures
    ('Quelle est la plus ancienne voiture-jouet au monde ?', 'Modèle T Ford', 'Mercedes-Benz', 'Coccinelle Volkswagen', 'Toyota Corolla', 'Modèle T Ford', 'Group 1', 'fr'),
    ('Quel constructeur automobile a produit la première voiture produite en série ?', 'Ford', 'Mercedes-Benz', 'Volkswagen', 'Toyota', 'Ford', 'Group 1', 'fr'),
    ('Quelle marque de voiture est connue pour ses voitures de sport telles que la 911 ?', 'Porsche', 'Ferrari', 'Lamborghini', 'Bugatti', 'Porsche', 'Group 1', 'fr'),
    ('Quelle voiture est souvent associée à James Bond ?', 'Aston Martin', 'BMW', 'Lexus', 'Jaguar', 'Aston Martin', 'Group 1', 'fr'),
    ('Quelle voiture est considérée comme une icône de l''industrie automobile américaine ?', 'Chevrolet Corvette', 'Ford Mustang', 'Dodge Challenger', 'Cadillac Escalade', 'Ford Mustang', 'Group 1', 'fr'),
    ('En quelle année la première voiture à moteur à combustion interne a-t-elle été construite ?', '1886', '1901', '1920', '1955', '1886', 'Group 1', 'fr'),
    ('Quelle voiture est souvent associée à la culture hippie des années 60 ?', 'Coccinelle Volkswagen', 'Ford Mustang', 'Chevrolet Camaro', 'Mini Cooper', 'Coccinelle Volkswagen', 'Group 1', 'fr'),
    ('Quel constructeur automobile est connu pour ses véhicules de luxe et prestigieux ?', 'Mercedes-Benz', 'Toyota', 'Honda', 'Hyundai', 'Mercedes-Benz', 'Group 1', 'fr'),
    ('Quelle voiture a remporté le titre de "Voiture de l''année 2022" ?', 'Volvo XC40', 'Tesla Model 3', 'Audi A4', 'Mazda MX-5', 'Volvo XC40', 'Group 1', 'fr'),
    ('Quelle marque automobile a produit la première voiture hybride pour la production de masse ?', 'Toyota', 'Honda', 'Lexus', 'Nissan', 'Toyota', 'Group 1', 'fr'),
-- fr
-- Group 2: Poupées
    ('Quelle est la poupée la plus célèbre au monde ?', 'Barbie', 'Ours en peluche', 'Cabbage Patch Kids', 'Raggedy Ann', 'Barbie', 'Group 2', 'fr'),
    ('Quelle entreprise produit la ligne de poupées Monster High ?', 'Mattel', 'Hasbro', 'Lego', 'Playmobil', 'Mattel', 'Group 2', 'fr'),
    ('Quelle poupée a été inspirée par une bande dessinée belge ?', 'Suske et Wiske', 'Tintin', 'Les Schtroumpfs', 'Lucky Luke', 'Tintin', 'Group 2', 'fr'),
    ('Quel type de poupée est connu pour sa douceur et son rembourrage moelleux ?', 'Poupée en peluche', 'Poupée de mode', 'Poupée en porcelaine', 'Poupée en bois', 'Poupée en peluche', 'Group 2', 'fr'),
    ('Quelle poupée a été introduite en tant que contrepartie de Barbie et présente une image corporelle plus réaliste ?', 'Lammily', 'Bratz', 'Sindy', 'Troll', 'Lammily', 'Group 2', 'fr'),
    ('Quelle ligne de poupées était basée sur les personnages d''une série animée populaire ?', 'My Little Pony', 'Strawberry Shortcake', 'Care Bears', 'Rainbow Brite', 'My Little Pony', 'Group 2', 'fr'),
    ('Quelle poupée était associée à la célèbre phrase "Maman !" ?', 'Baby Born', 'Cabbage Patch Kids', 'Baby Alive', 'Chou Chou', 'Baby Born', 'Group 2', 'fr'),
    ('Quelle poupée a été introduite en 1959 et est connue pour ses vêtements et accessoires à la mode ?', 'Barbie', 'Blythe', 'American Girl', 'Skipper', 'Barbie', 'Group 2', 'fr'),
    ('Quelle entreprise produit la ligne de poupées Lalaloopsy ?', 'MGA Entertainment', 'Spin Master', 'Fisher-Price', 'Playmates Toys', 'MGA Entertainment', 'Group 2', 'fr'),
    ('Quelle poupée est devenue célèbre grâce à son histoire en tant que jouet vivant dans une garderie ?', 'Jessie', 'Bo Peep', 'Hamm', 'Bullseye', 'Jessie', 'Group 2', 'fr'),
-- Group 3: Ensembles de construction
    ('Quelle marque d''ensembles de construction possède un parc à thème au Danemark ?', 'LEGO', 'K''NEX', 'Mega Bloks', 'Playmobil', 'LEGO', 'Group 3', 'fr'),
    ('Quel ensemble de construction est basé sur les films et les personnages de Star Wars ?', 'LEGO Star Wars', 'Mega Bloks Halo', 'K''NEX Mario Kart', 'Playmobil City Life', 'LEGO Star Wars', 'Group 3', 'fr'),
    ('Quelle marque d''ensembles de construction est connue pour ses briques en plastique avec des tenons ?', 'LEGO', 'K''NEX', 'Mega Bloks', 'Lincoln Logs', 'LEGO', 'Group 3', 'fr'),
    ('Quelle marque d''ensembles de construction propose une variété d''ensembles sur des thèmes tels que les châteaux, les pirates et l''espace ?', 'Playmobil', 'LEGO Technic', 'Mega Bloks First Builders', 'K''NEX Super Mario', 'Playmobil', 'Group 3', 'fr'),
    ('Quelle marque d''ensembles de construction est connue pour ses briques magnétiques ?', 'Geomag', 'LEGO Classic', 'Mega Bloks Barbie', 'K''NEX Thrill Rides', 'Geomag', 'Group 3', 'fr'),
    ('Quel ensemble de construction est conçu pour être utilisé avec une application interactive ?', 'LEGO Hidden Side', 'Mega Bloks Power Rangers', 'K''NEX Mario Kart', 'Playmobil City Action', 'LEGO Hidden Side', 'Group 3', 'fr'),
    ('Quelle marque d''ensembles de construction propose une gamme de briques permettant de construire des machines fonctionnelles ?', 'K''NEX', 'LEGO Creator', 'Mega Bloks Despicable Me', 'Playmobil Dollhouse', 'K''NEX', 'Group 3', 'fr'),
    ('Quelle marque d''ensembles de construction est connue pour ses grosses briques solides destinées aux jeunes enfants ?', 'Mega Bloks', 'LEGO DUPLO', 'K''NEX Mighty Makers', 'Playmobil 1.2.3', 'LEGO DUPLO', 'Group 3', 'fr'),
    ('Quel ensemble de construction est conçu pour être utilisé en combinaison avec des circuits électroniques ?', 'LittleBits', 'LEGO Mindstorms', 'Mega Bloks Skylanders', 'K''NEX Education', 'LittleBits', 'Group 3', 'fr'),
    ('Quelle marque d''ensembles de construction est connue pour ses bâtiments modulaires et ses paysages urbains ?', 'LEGO Creator Expert', 'Mega Bloks American Girl', 'K''NEX Super Mario', 'Playmobil Wild Life', 'LEGO Creator Expert', 'Group 3', 'fr'),
-- Group 4: Puzzles
    ('Quel type de puzzle se compose de neuf pièces carrées disposées selon un motif carré ?', 'Puzzle coulissant', 'Puzzle d''assemblage', 'Mots croisés', 'Sudoku', 'Puzzle coulissant', 'Group 4', 'fr'),
    ('Quel puzzle est composé d''une grille rectangulaire avec des chiffres donnant des indications pour la placement de certains chiffres ?', 'Sudoku', 'Cryptogramme', 'Mots croisés', 'Kakuro', 'Sudoku', 'Group 4', 'fr'),
    ('Quel puzzle est composé de pièces qui doivent être assemblées pour former une image ou un motif ?', 'Puzzle d''assemblage', 'Puzzle d''échecs', 'Rubik''s Cube', 'Tangram', 'Puzzle d''assemblage', 'Group 4', 'fr'),
    ('Quel puzzle est composé d''une grille de cases noires et blanches à remplir avec des lettres pour former des mots ?', 'Mots croisés', 'Cryptogramme', 'Sudoku', 'Mots cachés', 'Mots croisés', 'Group 4', 'fr'),
    ('Quel puzzle est composé d''un ensemble de pièces qui doivent être arrangées pour former une structure tridimensionnelle ?', 'Puzzle 3D', 'Puzzle coulissant', 'Tangram', 'Rubik''s Cube', 'Puzzle 3D', 'Group 4', 'fr'),
    ('Quel puzzle est composé d''un ensemble de nombres et d''opérateurs mathématiques qui doivent être combinés pour atteindre un certain nombre cible ?', 'Puzzle mathématique', 'Sudoku', 'Mots croisés', 'Cryptogramme', 'Puzzle mathématique', 'Group 4', 'fr'),
    ('Quel puzzle est composé d''une série d''indices cryptiques qui doivent être résolus pour trouver un mot ou une phrase ?', 'Cryptogramme', 'Kakuro', 'Mots croisés', 'Sudoku', 'Cryptogramme', 'Group 4', 'fr'),
    ('Quel puzzle est composé d''un ensemble de sept pièces géométriques pouvant être combinées pour former différentes formes ?', 'Tangram', 'Puzzle d''assemblage', 'Puzzle d''échecs', 'Rubik''s Cube', 'Tangram', 'Group 4', 'fr'),
    ('Quel puzzle est composé d''une série de nombres et d''opérateurs mathématiques qui doivent être combinés pour atteindre un nombre cible spécifique ?', 'Puzzle mathématique', 'Sudoku', 'Mots croisés', 'Cryptogramme', 'Puzzle mathématique', 'Group 4', 'fr'),
    ('Quel puzzle est composé d''un ensemble de 27 petits cubes pouvant être tournés pour former un plus grand cube ?', 'Rubik''s Cube', 'Puzzle coulissant', 'Puzzle d''assemblage', 'Tangram', 'Rubik''s Cube', 'Group 4', 'fr'),
-- Group 5: Peluches
    ('Quel animal en peluche est connu pour ses rayures noires et blanches ?', 'Zèbre', 'Tigre', 'Panda', 'Léopard', 'Zèbre', 'Group 5', 'fr'),
    ('Quel animal en peluche est souvent associé à l''Australie et a une poche pour porter ses petits ?', 'Kangourou', 'Koala', 'Wombat', 'Émeu', 'Kangourou', 'Group 5', 'fr'),
    ('Quel animal en peluche est considéré comme le symbole national de la Chine ?', 'Panda', 'Éléphant', 'Girafe', 'Chameau', 'Panda', 'Group 5', 'fr'),
    ('Quel animal en peluche est connu pour son long cou et son pelage tacheté ?', 'Girafe', 'Lion', 'Hippopotame', 'Crocodile', 'Girafe', 'Group 5', 'fr'),
    ('Quel animal en peluche est connu pour ses grandes oreilles et sa longue trompe ?', 'Éléphant', 'Koala', 'Zèbre', 'Gorille', 'Éléphant', 'Group 5', 'fr'),
    ('Quel animal en peluche est connu pour son pelage noir et blanc et son appétit pour le bambou ?', 'Panda', 'Koala', 'Tigre', 'Pingouin', 'Panda', 'Group 5', 'fr'),
    ('Quel animal en peluche est souvent associé à l''Arctique et a un pelage blanc et un nez noir ?', 'Ours polaire', 'Morse', 'Pingouin', 'Orque', 'Ours polaire', 'Group 5', 'fr'),
    ('Quel animal en peluche est souvent représenté comme un cochon rose avec une queue en tire-bouchon ?', 'Cochon', 'Âne', 'Lapin', 'Mouton', 'Cochon', 'Group 5', 'fr'),
    ('Quel animal en peluche est connu pour son apparence poilue et son amour pour le miel ?', 'Ours', 'Lynx', 'Renard', 'Raton laveur', 'Ours', 'Group 5', 'fr'),
    ('Quel animal en peluche est souvent associé à la jungle et émet un rugissement ?', 'Lion', 'Tigre', 'Singe', 'Crocodile', 'Lion', 'Group 5', 'fr'),    
-- en
-- Group 1: car
    ('What is the oldest toy car in the world?', 'Model T Ford', 'Mercedes-Benz', 'Volkswagen Beetle', 'Toyota Corolla', 'Model T Ford', 'Group 1', 'en'),
    ('Which automaker produced the first mass-produced car?', 'Ford', 'Mercedes-Benz', 'Volkswagen', 'Toyota', 'Ford', 'Group 1', 'en'),
    ('Which car brand is known for its sports cars like the 911?', 'Porsche', 'Ferrari', 'Lamborghini', 'Bugatti', 'Porsche', 'Group 1', 'en'),
    ('Which car is often associated with James Bond?', 'Aston Martin', 'BMW', 'Lexus', 'Jaguar', 'Aston Martin', 'Group 1', 'en'),
    ('Which car is considered an icon of the American automotive industry?', 'Chevrolet Corvette', 'Ford Mustang', 'Dodge Challenger', 'Cadillac Escalade', 'Ford Mustang', 'Group 1', 'en'),
    ('In what year was the first internal combustion engine car built?', '1886', '1901', '1920', '1955', '1886', 'Group 1', 'en'),
    ('Which car is often associated with the hippie culture in the 1960s?', 'Volkswagen Beetle', 'Ford Mustang', 'Chevrolet Camaro', 'Mini Cooper', 'Volkswagen Beetle', 'Group 1', 'en'),
    ('Which automaker is known for its luxury and prestigious vehicles?', 'Mercedes-Benz', 'Toyota', 'Honda', 'Hyundai', 'Mercedes-Benz', 'Group 1', 'en'),
    ('Which car won the "Car of the Year 2022" title?', 'Volvo XC40', 'Tesla Model 3', 'Audi A4', 'Mazda MX-5', 'Volvo XC40', 'Group 1', 'en'),
    ('Which car brand produced the first mass-produced hybrid car?', 'Toyota', 'Honda', 'Lexus', 'Nissan', 'Toyota', 'Group 1', 'en'),
-- Group 2: Dolls
    ('Who is the most famous doll in the world?', 'Barbie', 'Teddy bear', 'Cabbage Patch Kids', 'Raggedy Ann', 'Barbie', 'Group 2', 'en'),
    ('Which company produces the Monster High doll line?', 'Mattel', 'Hasbro', 'Lego', 'Playmobil', 'Mattel', 'Group 2', 'en'),
    ('Which doll was inspired by a Belgian comic book?', 'Suske en Wiske', 'Tintin', 'Smurfs', 'Lucky Luke', 'Tintin', 'Group 2', 'en'),
    ('Which type of doll is known for its cuddliness and soft stuffing?', 'Plush doll', 'Fashion doll', 'Porcelain doll', 'Wooden doll', 'Plush doll', 'Group 2', 'en'),
    ('Which doll was introduced as the counterpart to Barbie and has a more realistic body image?', 'Lammily', 'Bratz', 'Sindy', 'Troll', 'Lammily', 'Group 2', 'en'),
    ('Which doll line was based on characters from a popular animated TV series?', 'My Little Pony', 'Strawberry Shortcake', 'Care Bears', 'Rainbow Brite', 'My Little Pony', 'Group 2', 'en'),
    ('Which doll was associated with the famous phrase "Mama!"?', 'Baby Born', 'Cabbage Patch Kids', 'Baby Alive', 'Chou Chou', 'Baby Born', 'Group 2', 'en'),
    ('Which doll was introduced in 1959 and is known for her fashionable clothing and accessories?', 'Barbie', 'Blythe', 'American Girl', 'Skipper', 'Barbie', 'Group 2', 'en'),
    ('Which company produces the Lalaloopsy doll line?', 'MGA Entertainment', 'Spin Master', 'Fisher-Price', 'Playmates Toys', 'MGA Entertainment', 'Group 2', 'en'),
    ('Which doll became famous for her story as a living toy in a daycare?', 'Jessie', 'Bo Peep', 'Hamm', 'Bullseye', 'Jessie', 'Group 2', 'en'),
-- Group 3: Building Sets
    ('Which building set brand has a theme park in Denmark?', 'LEGO', 'K''NEX', 'Mega Bloks', 'Playmobil', 'LEGO', 'Group 3', 'en'),
    ('Which building set is based on the movies and characters from Star Wars?', 'LEGO Star Wars', 'Mega Bloks Halo', 'K''NEX Mario Kart', 'Playmobil City Life', 'LEGO Star Wars', 'Group 3', 'en'),
    ('Which building set brand is known for its plastic building bricks with studs?', 'LEGO', 'K''NEX', 'Mega Bloks', 'Lincoln Logs', 'LEGO', 'Group 3', 'en'),
    ('Which building set brand offers a variety of sets with themes such as castles, pirates, and space?', 'Playmobil', 'LEGO Technic', 'Mega Bloks First Builders', 'K''NEX Super Mario', 'Playmobil', 'Group 3', 'en'),
    ('Which building set brand is known for its magnetic building bricks?', 'Geomag', 'LEGO Classic', 'Mega Bloks Barbie', 'K''NEX Thrill Rides', 'Geomag', 'Group 3', 'en'),
    ('Which building set is designed to be connected to an interactive app?', 'LEGO Hidden Side', 'Mega Bloks Power Rangers', 'K''NEX Mario Kart', 'Playmobil City Action', 'LEGO Hidden Side', 'Group 3', 'en'),
    ('Which building set brand offers a range of bricks that can be used to build functional machines?', 'K''NEX', 'LEGO Creator', 'Mega Bloks Despicable Me', 'Playmobil Dollhouse', 'K''NEX', 'Group 3', 'en'),
    ('Which building set brand is known for its large, sturdy bricks for young children?', 'Mega Bloks', 'LEGO DUPLO', 'K''NEX Mighty Makers', 'Playmobil 1.2.3', 'LEGO DUPLO', 'Group 3', 'en'),
    ('Which building set is designed to be used in conjunction with electronic circuits?', 'LittleBits', 'LEGO Mindstorms', 'Mega Bloks Skylanders', 'K''NEX Education', 'LittleBits', 'Group 3', 'en'),
    ('Which building set brand is known for its modular buildings and cityscapes?', 'LEGO Creator Expert', 'Mega Bloks American Girl', 'K''NEX Super Mario', 'Playmobil Wild Life', 'LEGO Creator Expert', 'Group 3', 'en'),
-- Group 4: Puzzles
    ('What type of puzzle consists of nine square pieces arranged in a square pattern?', 'Sliding puzzle', 'Jigsaw puzzle', 'Word search', 'Sudoku', 'Sliding puzzle', 'Group 4', 'en'),
    ('Which puzzle consists of a rectangular grid with numbers that give clues to the placement of certain numbers?', 'Sudoku', 'Cryptogram', 'Crossword puzzle', 'Kakuro', 'Sudoku', 'Group 4', 'en'),
    ('Which puzzle consists of pieces that need to be assembled to form an image or pattern?', 'Jigsaw puzzle', 'Chess puzzle', 'Rubik''s Cube', 'Tangram', 'Jigsaw puzzle', 'Group 4', 'en'),
    ('Which puzzle consists of a grid of black and white squares to be filled with letters to form words?', 'Crossword puzzle', 'Cryptogram', 'Sudoku', 'Word search', 'Crossword puzzle', 'Group 4', 'en'),
    ('Which puzzle consists of a collection of pieces that need to be arranged to form a three-dimensional structure?', '3D puzzle', 'Sliding puzzle', 'Tangram', 'Rubik''s Cube', '3D puzzle', 'Group 4', 'en'),
    ('Which puzzle consists of a set of numbers and mathematical operators that need to be combined to reach a certain target number?', 'Math puzzle', 'Sudoku', 'Crossword puzzle', 'Cryptogram', 'Math puzzle', 'Group 4', 'en'),
    ('Which puzzle consists of a series of cryptic clues that need to be solved to find a word or phrase?', 'Cryptogram', 'Kakuro', 'Crossword puzzle', 'Sudoku', 'Cryptogram', 'Group 4', 'en'),
    ('Which puzzle consists of a set of seven geometric pieces that can be combined to form different shapes?', 'Tangram', 'Jigsaw puzzle', 'Chess puzzle', 'Rubik''s Cube', 'Tangram', 'Group 4', 'en'),
    ('Which puzzle consists of a series of numbers and mathematical operators that need to be combined to reach a specific target number?', 'Math puzzle', 'Sudoku', 'Crossword puzzle', 'Cryptogram', 'Math puzzle', 'Group 4', 'en'),
    ('Which puzzle consists of a set of 27 small cubes that can be rotated to form a larger cube?', 'Rubik''s Cube', 'Sliding puzzle', 'Jigsaw puzzle', 'Tangram', 'Rubik''s Cube', 'Group 4', 'en'),
-- Group 5: Stuffed Animals
    ('Which stuffed animal is known for its black and white stripes?', 'Zebra', 'Tiger', 'Panda', 'Leopard', 'Zebra', 'Group 5', 'en'),
    ('Which stuffed animal is often associated with Australia and has a pouch to carry its young?', 'Kangaroo', 'Koala', 'Wombat', 'Emu', 'Kangaroo', 'Group 5', 'en'),
    ('Which stuffed animal is considered the national symbol of China?', 'Panda', 'Elephant', 'Giraffe', 'Camel', 'Panda', 'Group 5', 'en'),
    ('Which stuffed animal is known for its long neck and spotted coat?', 'Giraffe', 'Lion', 'Hippo', 'Crocodile', 'Giraffe', 'Group 5', 'en'),
    ('Which stuffed animal is known for its large ears and long trunk?', 'Elephant', 'Koala', 'Zebra', 'Gorilla', 'Elephant', 'Group 5', 'en'),
    ('Which stuffed animal is known for its black-and-white coat and love for bamboo?', 'Panda', 'Koala', 'Tiger', 'Penguin', 'Panda', 'Group 5', 'en'),
    ('Which stuffed animal is often associated with the Arctic and has a white coat and black nose?', 'Polar bear', 'Walrus', 'Penguin', 'Orca', 'Polar bear', 'Group 5', 'en'),
    ('Which stuffed animal is often depicted as a pink pig with a curly tail?', 'Pig', 'Donkey', 'Rabbit', 'Sheep', 'Pig', 'Group 5', 'en'),
    ('Which stuffed animal is known for its furry appearance and its love for honey?', 'Bear', 'Lynx', 'Fox', 'Raccoon', 'Bear', 'Group 5', 'en'),
    ('Which stuffed animal is often associated with the jungle and has a roaring sound?', 'Lion', 'Tiger', 'Monkey', 'Crocodile', 'Lion', 'Group 5', 'en');

