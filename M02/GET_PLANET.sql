create or replace procedure GET_PLANET (p_id in out planet.id_planet%TYPE, p_user out planet.id_user%TYPE,
p_name out planet.name%TYPE, p_tecno_attack out planet.technology_atack%TYPE, p_tecno_defense out planet.technology_defense%TYPE,
p_upt_defense out planet.update_defense_cost%TYPE, p_upt_attack out planet.update_atack_cost%TYPE,
p_crystal out planet.crystal_quantity%TYPE, p_iron out planet.iron_quantity%TYPE, p_deuterium out planet.deuterium_quantity%TYPE)

as
   existe int;
   
   excp_planet exception;
   
begin
   select count(id_planet) into existe from planet where id_planet = p_id;
   
   if existe = 0 then
      raise excp_planet;
      
   end if;
   
   select * into p_id, p_user, p_name, p_tecno_attack, p_tecno_defense, p_upt_defense, p_upt_attack, p_crystal, p_iron, p_deuterium
   from planet where id_planet = p_id;
   
exception
   when excp_planet then
   DBMS_OUTPUT.PUT_LINE('ERROR: EL ID DEL PLANETA NO EXISTE');
   
   when others then
   dbms_output.put_line('ERROR: NO SE HA INDENTIFICADO EL ERROR');
   
end;
