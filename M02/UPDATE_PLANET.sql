create or replace procedure UPDATE_PLANET(id_planeta planet.id_planet%type,  nombre planet.name%type,
tec_ataque planet.technology_atack%type, tec_defensa planet.technology_defense%type, update_defensa planet.update_defense_cost%type,
update_ataque planet.update_atack_cost%type, cristal planet.crystal_quantity%type, metal planet.metal_quantity%type,
deuterium planet.deuterium_quantity%type)
as

begin
      update planet
      set  name = nombre, technology_atack = tec_ataque, technology_defense = tec_defensa, update_defense_cost = update_defensa,
      update_atack_cost = update_ataque, crystal_quantity = cristal, metal_quantity = metal, deuterium_quantity = deuterium where id_planet = id_planeta;
      commit;
   
   exception
      when others then
      dbms_output.put_line('ERROR: NO SE HA INDENTIFICADO EL ERROR UPDATE_PLANET');
      rollback;
      
   end;