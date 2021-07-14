/**********************************/
/* Table Name: 관리자 */
/**********************************/
CREATE TABLE ADMIN(
    ADMINNO                           NUMBER(10)     NOT NULL    PRIMARY KEY,
    ID                                VARCHAR2(20)     NOT NULL,
    NAME                              VARCHAR2(300)    NOT NULL,
    PASSWORD                          VARCHAR2(100)    NOT NULL,
    AUTHORITY                         VARCHAR2(20)     NOT NULL,
    ENABLED                           NUMBER(38)     NOT NULL,
    RDATE                             DATE     NOT NULL
);