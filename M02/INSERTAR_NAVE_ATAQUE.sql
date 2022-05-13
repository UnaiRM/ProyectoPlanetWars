create or replace procedure INSERT_SHIP_ATTACK(id_planeta planet_ship.id_planet%type, id_defensa planet_ship.id_ship%type,
cantidad planet_ship.quantity%type, nivel_ataque planet_ship.level_atack%type, nivel_defensa planet_ship.level_defense%type)
as

begin
   insert into PLANET_SHIP values (id_planeta, id_defensa, cantidad, nivel_ataque, nivel_defensa);
   commit;

exception
   when others then
   dbms_output.put_line('ERROR: NO SE HA INDENTIFICADO EL ERROR INSERT DATA');
   rollback;

end;