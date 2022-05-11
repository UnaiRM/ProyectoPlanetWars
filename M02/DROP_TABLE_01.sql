create or replace procedure DROP_TABLE_01
as
begin
   execute immediate  'DROP TABLE BATTLE';
   execute immediate  'DROP TABLE PLANET_SHIP';
   execute immediate  'DROP TABLE PLANET_DEFENSE';
   execute immediate  'DROP TABLE DEFENSE';
   execute immediate  'DROP TABLE SHIP';
   execute immediate  'DROP TABLE PLANET';
   execute immediate  'DROP TABLE USERS';
exception
   when others then
   dbms_output.put_line('ERROR: NO SE HA INDENTIFICADO EL ERROR DROP TABLE');
end;