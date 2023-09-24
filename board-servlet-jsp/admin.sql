/*
계정 생성 및 권한 부여
사용자명: servletboard
암호: servletboard
*/

CREATE USER servletboard
IDENTIFIED BY servletboard;

GRANT connect, resource to servletboard;


DROP SEQUENCE servletboard.member_seq;
DROP SEQUENCE servletboard.board_seq;
DROP SEQUENCE servletboard.board_comment_seq;

DROP TABLE servletboard.member;
DROP TABLE servletboard.board;
DROP TABLE servletboard.board_writter;
DROP TABLE servletboard.board_comment;

/* 계정 테이블 생성*/
CREATE TABLE servletboard.member (
  id number primary key,
  userid varchar2(12) not null unique,
  pw varchar2(16) not null,
  name varchar2(30) not null unique
);
CREATE SEQUENCE servletboard.member_seq;

/* 게시판 테이블 생성 */
CREATE TABLE servletboard.board (
  boardid number PRIMARY KEY,
  title varchar2(200) not null,
  boardcontent varchar2(4000) not null,
  writetime date default sysdate,
  viewcnt number default 0,
  name varchar2(30) not null 
);
CREATE SEQUENCE servletboard.board_seq;

/* 게시글 작성자 테이블 생성 */
CREATE TABLE servletboard.board_writter(
  boardid number not null,
  id number not null,
  constraint board_writter_boardid_fk foreign key(boardid)
  references servletboard.board(boardid)
  on delete cascade
);

/* 댓글 테이블 생성 */
CREATE TABLE servletboard.board_comment(
  commentid number PRIMARY KEY,
  content varchar2(200) not null,
  writetime date default sysdate,
  
  parent_commentid number,
  boardid number,
  id number,
  
  constraint board_comment_parent_cid_fk foreign key(parent_commentid)
  references servletboard.board_comment(commentid)
  on delete cascade,
  
  constraint board_comment_boardid_fk foreign key(boardid)
  references servletboard.board(boardid)
  on delete cascade,
  
  constraint board_comment_id_fk foreign key(id)
  references servletboard.member(id)
  on delete cascade
);
CREATE SEQUENCE servletboard.board_comment_seq;