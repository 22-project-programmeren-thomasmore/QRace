CREATE TABLE if not exists HIGHSCORES (
    id INT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(255) NOT NULL,
    score INT NOT NULL);

CREATE TABLE GAMES (
    raceId  int,
    host    varchar(50),
    player2 varchar(50),
    player3 varchar(50),
    player4 varchar(50));