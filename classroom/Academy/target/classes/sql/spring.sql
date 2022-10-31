(*** 시스템 계정에서 ***)
CREATE USER springProject IDENTIFIED BY 1234;

GRANT CONNECT, RESOURCE, DBA TO springProject;

(***springProject 계정에서***)

--회원(유저) 테이블 설정 시작.
CREATE TABLE users(
userId varchar2(15) not null primary key,
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
studyCode varchar2(15) not null primary key, -- **스터디 코드는 어떤 규칙으로?** 시퀀스를 사용하기 위해 number형으로 하자. 
studyCourse varchar2(100) not null, 
studyContent varchar2(4000), --**강의 설명을 적기 때문에 4000자로 잡았음.**
studyStartDate date, --** 수강 시작 기간. 나중에 not null 처리해줄 것.
studyEndDate date not null, --** 수강 종료 기간. 나중에 not null 처리해줄 것.
studyStartTime date not null, --** 수강 시작시간. 나중에 not null 처리해줄 것.
studyEndTime date not null, --** 수강 종료 시간. 나중에 not null 처리해줄 것.
studyTeacher varchar2(10), 
studyPrice number(8) not null --** 수강료는 최대 8자리까지.**
);--과목 테이블 끝. 
--studyDuration number(3), -- 수강은 정확히 며칠 동안 이어지는가? studyDateStart에 연산해서 사용.
--studyPredate date, --** 모집 기간. date ~ date 같은 포맷으로 사용할 수 있을 것** 이를 시작일로 설정하고, 모집 기간을 정수형으로 넣어주자.
--studyPredateDuration number(3), -- 수강은 정확히 며칠 동안 이어지는가? 



--개인 겸 단체 게시판 설정.
CREATE TABLE bbs( 
bbsID number not null primary key, -- 시퀀스를 사용하기 위해 number형으로 하자. 
bbsTitle varchar2(100), --** 게시물 '제목' 부분. **
bbsContent varchar2(4000) not null,  --** 게시물 '내용' 부분. 4000자로 잡았음.**
userId varchar2(15) not null, -- **관리자 아이디면 전체 게시판에 권한을 얻음.**
bbsDate date not null,
studyCode varchar2(15) not null, -- **스터디 코드를 참조해서 확인.**

CONSTRAINT FK_bbs_userId FOREIGN KEY(userId) REFERENCES users(userid),
CONSTRAINT FK_bbs_studyCode FOREIGN KEY(studyCode) REFERENCES study(studyCode) -- 외래키 추가.
);--개인 겸 단체 게시판 설정 끝.

CREATE SEQUENCE bbs_seq
START with 1
increment by 1; 
--게시판 시퀀스 설정 끝.


CREATE TABLE attendance(

userId varchar2(15), --과정에 참가한 학생 코드.
studyCode varchar2(15), --과정 코드.
attendanceDate date, -- 출석 날짜. 
attendanceJoin date, --학생이 어떤 날, 몇 시에 출석을 시작했는지를 기록.
attendanceExit date, --학생이 어떤 날, 몇 시에 나갔는지를 기록 이후 update로 추가해줌. 

--studyCode, userid, studydate ==> 묶어서 기본키로 활용. 

CONSTRAINT PK_attendance PRIMARY KEY(userId, studyCode, attendanceDate),

CONSTRAINT FK_attendance_userId FOREIGN KEY(userId) REFERENCES users(userid),
CONSTRAINT FK_attendance_studyCode FOREIGN KEY(studyCode) REFERENCES study(studyCode) -- 외래키 추가.

);

CREATE TABLE allow(

studyAllow number(1) primary key, --허가 코드
comments varchar2(15) --코드에 따른 메세지.

);

CREATE TABLE registration(

userId varchar2(15), --수강 신청한 학생 코드. 
studyCode varchar2(15), --과정 코드.
studyAllow number(1), --과정 코드.

CONSTRAINT PK_registration PRIMARY KEY(userId, studyCode),

CONSTRAINT FK_registration_userId FOREIGN KEY(userId) REFERENCES users(userid),
CONSTRAINT FK_registration_studyCode FOREIGN KEY(studyCode) REFERENCES study(studyCode), -- 외래키 추가.
CONSTRAINT FK_registration_studyAllow FOREIGN KEY(studyAllow) REFERENCES allow(studyAllow)


); --이 테이블의 기본키 설정은 어떻게?