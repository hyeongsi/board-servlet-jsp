/*계정 생성 및 권한 부여*/
CREATE USER servletboard
IDENTIFIED BY servletboard;

GRANT connect, resource to servletboard;

CREATE SEQUENCE servletboard.servletboard_id_seq;

/* 계정 테이블 생성*/
DROP TABLE servletboard.member;

CREATE TABLE servletboard.member (
  userid varchar2(12) PRIMARY KEY,
  pw varchar2(16) not null,
  name varchar2(30) not null unique
);

select * from servletboard.member;

/* 게시판 테이블 생성 */
CREATE SEQUENCE servletboard.board_seq;

DROP TABLE servletboard.board;
CREATE TABLE servletboard.board (
  boardid number PRIMARY KEY,
  title varchar2(100) not null,
  boardcontent varchar2(10240) not null,
  writetime date default sysdate,
  viewcnt number default 0,
  name varchar2(30) not null
);
