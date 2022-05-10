create or replace procedure INSERT_DATA_03
as
   
begin
--INSERCIÓN USUARIOS
   execute immediate  'INSERT INTO USERS VALUES (1,''Unai'',current_date,''1234'')';
   execute immediate  'INSERT INTO USERS VALUES (2,''Andres'',current_date,''1234'')';
   execute immediate  'INSERT INTO USERS VALUES (3,''Alex'',current_date,''1234'')';
   execute immediate  'INSERT INTO USERS VALUES (4,''Eduard'',current_date,''1234'')';
--INSERCIÓN NAVES
   execute immediate  'INSERT INTO SHIP VALUES(1,''Light Hunter'',3000,0,50,400,0,80,3,20)';
   execute immediate  'INSERT INTO SHIP VALUES(2,''Heavy Hunter'',6500,0,50,1000,0,150,7,30)';
   execute immediate  'INSERT INTO SHIP VALUES(3,''Battle Ship'',45000,0,7000,6000,0,1000,45,60)';
   execute immediate  'INSERT INTO SHIP VALUES(4,''Armored Ship'',30000,0,15000,8000,0,700,70,75)';
--INSERCIÓN DEFENSA
   execute immediate  'INSERT INTO DEFENSE VALUES(1,''Missile Launcher'',2000,0,0,200,0,80,5,10)';
   execute immediate  'INSERT INTO DEFENSE VALUES(2,''Ion Cannon'',4000,0,500,1200,0,250,12,25)';
   execute immediate  'INSERT INTO DEFENSE VALUES(3,''Plasma Cannon'',50000,0,5000,7000,0,2000,30,50)';

exception
   when others then
   dbms_output.put_line('ERROR: NO SE HA INDENTIFICADO EL ERROR INSERT DATA');

end;