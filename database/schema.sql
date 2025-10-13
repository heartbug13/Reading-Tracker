DROP TABLE MEMBER;
DROP TABLE AUTHOR;
DROP TABLE BOOK;
DROP TABLE GENRE;
DROP TABLE BADGE;
DROP TABLE REVIEW;
DROP TABLE MEMBER_BOOK;
DROP TABLE GOAL;
DROP TABLE READING_SESSION;
DROP TABLE BOOK_BADGE;
DROP TABLE BOOK_GENRE; 

CREATE TABLE MEMBER (
    UserID CHAR(4),
    FirstName VARCHAR(15),
    LastName VARCHAR(20),
    Phone CHAR(12),
    Email VARCHAR(50),
    UserName VARCHAR(30),
    Password VARCHAR(128)
);


CREATE TABLE AUTHOR (
    AuthorID CHAR(4),
    FirstName VARCHAR(15),
    LastName VARCHAR(20)
);

CREATE TABLE BOOK (
    BookID CHAR(4),
    AuthorID CHAR(4),
    BookTitle VARCHAR(60),
    BookDescription VARCHAR(200),
    CoverURL VARCHAR(255),
    PublihsedYear NUMBER
);

CREATE TABLE GENRE (
    GenreID CHAR(4),
    GenreName VARCHAR(50)
);

CREATE TABLE BADGE (
    BadgeID CHAR(4),
    BageDescription VARCHAR(100),
    BadgeName VARCHAR(60)
);

CREATE TABLE REVIEW (
    ReviewID CHAR(4),
    UserID CHAR(4),
    BookID CHAR(4),
    Rating NUMBER(1),
    ReviewDescription VARCHAR(500)
);

CREATE TABLE MEMBER_BOOK (
    BookID CHAR(4),
    UserID CHAR(4),
    Status VARCHAR(11),
    StartDate DATE,
    EndDate DATE
);

CREATE TABLE GOAL (
    UserID CHAR(4),
    GoalID CHAR(4),
    GoalDescription VARCHAR(100),
    GoalStatus VARCHAR(11),
    StartDate DATE,
    EndDate DATE
);

CREATE TABLE READING_SESSION (
    SessionID CHAR(4),
    BookID CHAR(4),
    UserID CHAR(4),
    Duration NUMBER(4,1),
    SessionDate DATE
);

CREATE TABLE BOOK_BADGE (
    BookID CHAR(4),
    BadgeID CHAR(4)
);

CREATE TABLE BOOK_GENRE (
    BookID CHAR(4),
    BadgeID CHAR(4)
);