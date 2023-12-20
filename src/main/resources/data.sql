CREATE TABLE DEMO
(
    id    BIGINT PRIMARY KEY,
    email VARCHAR(500),
    role  VARCHAR(150)
);


CREATE TABLE FEATURE_STATE
(
    id           BIGINT PRIMARY KEY,
    feature_name VARCHAR(500),
    active       boolean
);
INSERT INTO DEMO
VALUES (1, 'weqw@email', 'USER'),
       (2, 'sdvs@email', 'ADMIN');

INSERT INTO FEATURE_STATE
VALUES (1, 'WORKS_FEATURE', true);