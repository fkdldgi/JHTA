-- fileinfo.sql
create table fileinfo
(
	filenum number(5) primary key, -- ���Ϲ�ȣ
	writer varchar2(20), -- �ۼ���
	title varchar2(20), -- ����
	content varchar2(100), -- ����
	orgfilename varchar2(150), -- ���۵� ���ϸ�
	savefilename varchar2(150), -- ����� ���ϸ�
	filesize number(10) --����ũ��
);
create sequence fileinfo_seq;