create or replace procedure GET_DEFENSE_05 (d_id in out defense.id_defense%TYPE, d_name out defense.name%TYPE,
d_metal out defense.metal_cost%TYPE, d_crystal out defense.crystal_cost%TYPE, d_deuterium out defense.deuterium_cost%TYPE,
d_initial out defense.initial_armor%TYPE, d_armor out defense.armor%TYPE, d_base out defense.base_damage%TYPE,
d_speed out defense.speed%TYPE, d_generate out defense.generate_wastings%TYPE)
as   
   
begin
   select * into d_id, d_name, d_metal, d_crystal, d_deuterium, d_initial, d_armor, d_base, d_speed, d_generate from defense
   where id_defense = d_id;
   
end;