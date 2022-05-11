create or replace procedure insertarShipAtaque(id_planeta int, id_defensa int, cantidad int, nivel_ataque int, nivel_defensa int)
as
begin
   execute immediate  'INSERT INTO PLANET_SHIP VALUES (id_planeta, id_defensa, cantidad, nivel_ataque, nivel_defensa)';

end;
