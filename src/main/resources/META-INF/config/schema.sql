drop table IF EXISTS AUTOR;

create TABLE AUTHOR (
    ID INT NOT NULL AUTO_INCREMENT
    , FIRST_NAME VARCHAR(60) NOT NULL
    , LAST_NAME VARCHAR(40) NOT NULL
    , VERSION INT NOT NULL DEFAULT 0
    , UNIQUE UQ_AUTHOR_1 (FIRST_NAME, LAST_NAME)
    , PRIMARY KEY (ID)
);

drop table IF EXISTS BOOK;

create TABLE BOOK (
    ID INT NOT NULL AUTO_INCREMENT
    , TITLE VARCHAR(60) NOT NULL
    , VERSION INT NOT NULL DEFAULT 0
    , UNIQUE UQ_TITLE_1 (TITLE)
    , PRIMARY KEY (ID)
);

drop table IF EXISTS AUTHOR_TO_BOOK;

create TABLE AUTHOR_TO_BOOK (
    AUTHOR_ID INT NOT NULL,
    BOOK_ID INT NOT NULL,
    PRIMARY KEY(AUTHOR_ID, BOOK_ID),
    CONSTRAINT FK_AUTHOR_TO_BOOK_1 FOREIGN KEY (AUTHOR_ID)
    REFERENCES AUTHOR(ID) ON delete CASCADE,
    CONSTRAINT FK_AUTHOR_TO_BOOK_2 FOREIGN KEY (BOOK_ID)
    REFERENCES BOOK(ID)
);
