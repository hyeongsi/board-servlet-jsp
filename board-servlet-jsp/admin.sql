/*계정 생성 및 권한 부여*/
CREATE USER servletboard
IDENTIFIED BY servletboard;

GRANT connect, resource to servletboard;

CREATE SEQUENCE servletboard.servletboard_id_seq;

/* 계정 테이블 생성*/
CREATE SEQUENCE servletboard.member_seq;

DROP TABLE servletboard.member;
CREATE TABLE servletboard.member (
  id number primary key,
  userid varchar2(12) not null unique,
  pw varchar2(16) not null,
  name varchar2(30) not null unique
);

select * from servletboard.member;

/* 게시판 테이블 생성 */
DROP SEQUENCE servletboard.board_seq;
CREATE SEQUENCE servletboard.board_seq;

DROP TABLE servletboard.board;
CREATE TABLE servletboard.board (
  boardid number PRIMARY KEY,
  title varchar2(200) not null,
  boardcontent varchar2(4000) not null,
  writetime date default sysdate,
  viewcnt number default 0,
  name varchar2(30) not null 
);

DROP TABLE servletboard.board_writter;
CREATE TABLE servletboard.board_writter(
  boardid number,
  id number not null,
  constraint board_writter_boardid_fk foreign key(boardid)
  references servletboard.board(boardid)
  on delete cascade
);

insert into servletboard.board (boardid, title, boardcontent, name)
values (servletboard.board_seq.nextval, '제목1', '내용1', '홍길동');

insert into servletboard.board_writter (boardid, id)
values (servletboard.board_seq.currval, 1);
commit;

