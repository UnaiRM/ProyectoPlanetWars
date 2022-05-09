create or replace procedure GET_DEFENSE_05 (d_id defense.id_defense%TYPE, d_name out defense.name%TYPE,
d_metal out defense.metal_cost%TYPE, d_crystal out defense.crystal_cost%TYPE, d_deuterium out defense.deuterium_cost%TYPE,
d_initial out defense.initial_armor%TYPE, d_armor out defense.armor%TYPE, d_base out defense.base_damage%TYPE,
d_speed out defense.speed%TYPE, d_generate out defense.generate_wastings%TYPE)

as   
   existe int;
   
   excp_existe exception;
   
begin
   select count(id_defense) into existe from defense where id_defense = d_id;
   if existe = 0 then
      raise excp_existe;
      
   end if;
   
   select name, metal_cost, crystal_cost, deuterium_cost, initial_armor, armor, base_damage,speed, generate_wastings
   into d_name, d_metal, d_crystal, d_deuterium, d_initial, d_armor, d_base, d_speed, d_generate from defense
   where id_defense = d_id;
   
exception
   when excp_existe then
   dbms_output.put_line('ERROR: LA ID '||' NO EXISTE');
   
   when others then
   dbms_output.put_line('ERROR: NO SE HA INDENTIFICADO EL ERROR');
end;
