/*계정 생성 및 권한 부여*/
CREATE USER servletboard
IDENTIFIED BY servletboard;

GRANT connect, resource to servletboard;

CREATE SEQUENCE servletboard.servletboard_id_seq;

DROP TABLE servletboard.member;
/* 계정 테이블 생성*/
CREATE TABLE servletboard.member (
  userid varchar2(12) PRIMARY KEY,
  pw varchar2(16) not null,
  name varchar2(30) not null unique
);

select * from servletboard.member;

