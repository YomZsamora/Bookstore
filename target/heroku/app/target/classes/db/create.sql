SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS author (id int PRIMARY KEY auto_increment, authorName VARCHAR);


CREATE TABLE IF NOT EXISTS book (
    id int PRIMARY KEY auto_increment,
    bookName VARCHAR,
    noOfPages int,
    description VARCHAR,
);