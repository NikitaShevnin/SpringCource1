CREATE TABLE IF NOT EXISTS task
(
    ID          INT AUTO_INCREMENT PRIMARY KEY,
    DESCRIPTION varchar(255) NOT NULL,
    STATUS      varchar(40),
    NAME        varchar(40),
);