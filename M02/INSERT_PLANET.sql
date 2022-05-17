create or replace procedure INSERT_PLANET(next_id planet.id_planet%TYPE,id_user planet.id_user%type, nombre planet.name%type,
tec_ataque planet.technology_atack%type, tec_defensa planet.technology_defense%type, update_defensa planet.update_defense_cost%type,
update_ataque planet.update_atack_cost%type, cristal planet.crystal_quantity%type, metal planet.metal_quantity%type,
deuterium planet.deuterium_quantity%type)
as

begin

   insert into PLANET (id_planet, id_user, name, technology_atack, technology_defense, update_defense_cost, update_atack_cost,
   crystal_quantity, metal_quantity, deuterium_quantity)
   values (next_id, id_user, nombre, tec_ataque, tec_defensa, update_defensa, update_ataque, cristal, metal, deuterium);
   commit;
   
   DBMS_OUTPUT.PUT_LINE('SE HA INSERTADO LA FILA CORRECTAMENTE');
   
exception
   when others then
   dbms_output.put_line('ERROR: NO SE HA INDENTIFICADO EL ERROR INSERT DATA');
   rollback;

end;