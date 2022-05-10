create or replace procedure GET_SHIP_06 (s_id in ship.id_ship%TYPE, s_name out ship.name%TYPE,
s_metal out ship.metal_cost%TYPE, s_crystal out ship.crystal_cost%TYPE, s_deuterium out ship.deuterium_cost%TYPE,
s_initial out ship.initial_armor%TYPE, s_armor out ship.armor%TYPE, s_base out ship.base_damage%TYPE,
s_speed out ship.speed%TYPE, s_generate out ship.generate_wastings%TYPE)

as   
   existe int;
   
   excp_existe exception;
   
begin
--VERIFICA QUE LA ID EXISTA
   select count(id_ship) into existe from ship where id_ship = s_id;
   if existe = 0 then
      raise excp_existe;
      
   end if;
---DEVUELVE LOS DATOS  
   select name, metal_cost, crystal_cost, deuterium_cost, initial_armor, armor, base_damage,speed, generate_wastings
   into s_name, s_metal, s_crystal, s_deuterium, s_initial, s_armor, s_base, s_speed, s_generate from ship
   where id_ship = s_id;
   
exception
   when excp_existe then
   dbms_output.put_line('ERROR: LA ID '||' NO EXISTE');
   
   when others then
   dbms_output.put_line('ERROR: NO SE HA INDENTIFICADO EL ERROR');
   
end;
