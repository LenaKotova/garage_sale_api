CREATE TABLE USR
(
    USER_ID  BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    NAME     VARCHAR(255) NOT NULL,
    LOGIN    VARCHAR(255) NOT NULL UNIQUE,
    PASSWORD VARCHAR(255) NOT NULL
);

CREATE TABLE PRODUCT_CARD
(
    PRODUCT_CARD_ID BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    TITLE           VARCHAR(255) NOT NULL,
    DESCRIPTION     VARCHAR(255),
    PRICE           BIGINT       NOT NULL,
    USER_ID         BIGINT,
    FOREIGN KEY (USER_ID) REFERENCES USR (USER_ID)
);

create sequence hibernate_sequence start with 1 increment by 1;

INSERT INTO usr (LOGIN, NAME, PASSWORD)
VALUES ('SUPER_SALLER', 'Jo', 'iamsuperhero'),
       ('SALLER', 'Marry', 'iwonnasleep');

INSERT INTO PRODUCT_CARD (DESCRIPTION, TITLE, PRICE, USER_ID)
VALUES ('One pound for two pounds', 'Fish', 2, 1),
       ('This is the best of the best kitty', 'Kitty', 2000000, 2),
       ('', 'Sofa', 2000, 1);

commit;