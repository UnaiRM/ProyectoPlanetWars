create or replace procedure DELETE_USER_SHIP(id_planeta planet.id_planet%type)
as
begin

   delete from planet_defense where id_planet = id_planeta;
   delete from planet_ship where id_planet = id_planeta;
   commit;
   
exception
   when others then
   dbms_output.put_line('ERROR: NO SE HA INDENTIFICADO EL ERROR DELETE_USER_SHIP');
   rollback;
   
end;
