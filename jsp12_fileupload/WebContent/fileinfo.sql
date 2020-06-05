-- fileinfo.sql
create table fileinfo
(
	filenum number(5) primary key, -- 파일번호
	writer varchar2(20), -- 작성자
	title varchar2(20), -- 제목
	content varchar2(100), -- 내용
	orgfilename varchar2(150), -- 전송된 파일명
	savefilename varchar2(150), -- 저장된 파일명
	filesize number(10) --파일크기
);
create sequence fileinfo_seq;