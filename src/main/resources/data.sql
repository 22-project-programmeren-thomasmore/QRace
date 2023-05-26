CREATE TABLE if not exists HIGHSCORES (
    id INT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(255) NOT NULL,
    score INT NOT NULL);

CREATE TABLE if not exists GAMES (
    raceId  int,
    host    varchar(50),
    player2 varchar(50),
    player3 varchar(50),
    player4 varchar(50));


CREATE TABLE if not exists USERS(
    ID  int AUTO_INCREMENT PRIMARY KEY NOT NULL,
    email VARCHAR(50) NOT NULL,
    username VARCHAR(25) NOT NULL,
    password VARCHAR(25) NOT NULL,
    isAdmin BOOLEAN NOT NULL DEFAULT FALSE);