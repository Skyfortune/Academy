(*** 시스템 계정에서 ***)
CREATE USER springProject IDENTIFIED BY 1234;

GRANT CONNECT, RESOURCE, DBA TO springProject;

(***springProject 계정에서***)

--회원(유저) 테이블 설정 시작.
CREATE TABLE users(
userId varchar2(15) not null primary key unique,
userPassword varchar2(20) not null, 
userName varchar2(10) not null,
userAddress varchar2(13),
userPhone varchar2(13) not null
); --회원(유저) 테이블 설정 끝.


CREATE SEQUENCE user_seq
START with 1
increment by 1; 
--회원(유저) 시퀀스 설정 끝.
    

--과목 테이블 설정 시작.
CREATE TABLE study( -- **강의 목록을 표시할 때 사용하게 될 듯**
studyCode varchar2(15) not null primary key, -- **스터디 코드는 어떤 규칙으로?**
studyCourse varchar2(100) not null, 
studyContent varchar2(4000), --**강의 설명을 적기 때문에 4000자로 잡았음.**
studyDate varchar2(100) not null, --** 수강 기간. date ~ date 같은 포맷으로 사용할 수 있을 것**
studyPreDate varchar2(100), --** 모집 기간. date ~ date 같은 포맷으로 사용할 수 있을 것**
studyPrice number(8) not null --** 수강료는 최대 8자리까지.**
);--과목 테이블 끝.


--개인 겸 단체 게시판 설정.
CREATE TABLE bbs( 
bbsID varchar2(15) not null primary key,
bbsCategory varchar2(20), --** 카테고리 설정이 애매할 수 있어서 not null 설정 안 함**
bbsTitle varchar2(100), --** 게시물 '제목' 부분. **
bbsContent varchar2(4000) not null,  --** 게시물 '내용' 부분. 4000자로 잡았음.**
userId varchar2(15) not null, -- **관리자 아이디면 전체 게시판에 권한을 얻음.**
bbsDate date not null,
studyCode varchar2(15) not null, -- **스터디 코드를 참조해서 확인.**
--studyCourse VARCHAR2(100)
);--개인 겸 단체 게시판 설정 끝.
