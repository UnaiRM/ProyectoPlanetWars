create or replace procedure DROP_TABLE_01
as
     comando VARCHAR(100);
     comando2 VARCHAR(100);
     comando3 VARCHAR(100);
     comando4 VARCHAR(100);
     comando5 VARCHAR(100);
     comando6 VARCHAR(100);
     comando7 VARCHAR(100);
begin
    comando := 'DROP TABLE BATTLE';
    comando2 := 'DROP TABLE PLANET_SHIP';
    comando3 := 'DROP TABLE PLANET_DEFENSE';
    comando4 := 'DROP TABLE DEFENSE';
    comando5 := 'DROP TABLE SHIP';
    comando6 := 'DROP TABLE PLANET';
    comando7 := 'DROP TABLE USERS';

execute immediate  comando;
execute immediate  comando2;
execute immediate  comando3;
execute immediate  comando4;
execute immediate  comando5;
execute immediate  comando6;
execute immediate  comando7;

end;
/
set serveroutput on
begin
drop_table_01;
end;