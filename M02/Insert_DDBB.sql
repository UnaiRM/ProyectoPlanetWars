create or replace procedure CREATE_TABLE_02
as
     insert1 VARCHAR(100);
     insert2 VARCHAR(100);
     insert3 VARCHAR(100);
     insert4 VARCHAR(100);
     insert5 VARCHAR(100);
     insert6 VARCHAR(100);
     insert7 VARCHAR(100);
     insert8 VARCHAR(100);
     insert9 VARCHAR(100);
     insert10 VARCHAR(100);
     insert11 VARCHAR(100);
     insert12 VARCHAR(100);
     insert13 VARCHAR(100);
     insert14 VARCHAR(100); 
     insert15 VARCHAR(100);
     insert16 VARCHAR(100);
begin

insert1 := 'INSERT INTO USERS VALUES (1,''Unai'',current_date,''1234'')';
insert2 := 'INSERT INTO USERS VALUES (2,''Andres'',current_date,''1234'')';
insert3 := 'INSERT INTO USERS VALUES (3,''Alex'',current_date,''1234'')';
insert4 := 'INSERT INTO USERS VALUES (4,''Eduard'',current_date,''1234'')';

insert5 := 'INSERT INTO SHIP VALUES(1,''Light Hunter'',3000,0,50,400,0,80,3,20)';
insert6 := 'INSERT INTO SHIP VALUES(2,''Heavy Hunter'',6500,0,50,1000,0,150,7,30)';
insert7 := 'INSERT INTO SHIP VALUES(3,''Battle Ship'',45000,0,7000,6000,0,1000,45,60)';
insert8 := 'INSERT INTO SHIP VALUES(4,''Armored Ship'',30000,0,15000,8000,0,700,70,75)';

insert9 := 'INSERT INTO DEFENSE VALUES(1,''Missile Launcher'',2000,0,0,200,0,80,5,10)';
insert10 := 'INSERT INTO DEFENSE VALUES(2,''Ion Cannon'',4000,0,500,1200,0,250,12,25)';
insert11 := 'INSERT INTO DEFENSE VALUES(3,''Plasma Cannon'',50000,0,5000,7000,0,2000,30,50)';



execute immediate  insert1;
execute immediate  insert2;
execute immediate  insert3;
execute immediate  insert4;
execute immediate  insert5;
execute immediate  insert6;
execute immediate  insert7;
execute immediate  insert8;
execute immediate  insert9;
execute immediate  insert10;
execute immediate  insert11;

end;

