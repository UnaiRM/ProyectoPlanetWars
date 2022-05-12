create or replace procedure eliminarFlota(id_planeta planet.id_planet%type)
as
begin

delete from planet_defense where id_planet = id_planeta;
delete from planet_ship where id_planet = id_planeta;
   
exception
when others then
   dbms_output.put_line('ERROR: NO SE HA INDENTIFICADO EL ERROR DROP TABLE');

end;