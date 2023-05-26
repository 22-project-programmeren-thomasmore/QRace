CREATE TABLE if not exists HIGHSCORES (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL,
    score INT NOT NULL,
    highscore_date DATE NOT NULL);

CREATE TABLE if not exists GAMES (
    raceId  int,
    host    varchar(50),
    player2 varchar(50),
    player3 varchar(50),
    player4 varchar(50));
    
CREATE TABLE if not exists QUESTIONS (
    ID  int AUTO_INCREMENT PRIMARY KEY NOT NULL,
    QUESTION_TEXT VARCHAR(100) NOT NULL,
    CORRECT_ANSWER VARCHAR(100) NOT NULL,
    ANSWER1 VARCHAR(100),
    ANSWER2 VARCHAR(100),
    ANSWER3 VARCHAR(100),
    ANSWER4 VARCHAR(100),
    GROUP_PARAMETER VARCHAR(50) NOT NULL,
    LANGUAGE VARCHAR(2) NOT NULL,
    ARCHIVED BOOLEAN NOT NULL DEFAULT FALSE);
