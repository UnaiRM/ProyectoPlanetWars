create or replace procedure GET_SHIP_06 (s_id in out ship.id_defense%TYPE, s_name out ship.name%TYPE,
s_metal out ship.metal_cost%TYPE, s_crystal out ship.crystal_cost%TYPE, s_deuterium out ship.deuterium_cost%TYPE,
s_initial out ship.initial_armor%TYPE, s_armor out ship.armor%TYPE, s_base out ship.base_damage%TYPE,
s_speed out ship.speed%TYPE, s_generate out ship.generate_wastings%TYPE)
as   
   
begin
   select * into s_id, s_name, s_metal, s_crystal, s_deuterium, s_initial, s_armor, s_base, s_speed, s_generate from ship
   where id_ship = s_id;
   
end;