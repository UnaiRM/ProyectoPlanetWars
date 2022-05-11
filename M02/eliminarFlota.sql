create or replace procedure eliminarFlota
as
begin
   execute immediate  'DROP TABLE PLANET_SHIP';
   
   execute immediate  'DROP TABLE PLANET_DEFENSE';
      dbms_output.put_line('Se ha eliminado correctamente la table plante_ship y planet_defense');
      
    EXECUTE IMMEDIATE 'CREATE TABLE PLANET_DEFENSE
   (ID_planet numeric,
   ID_defense numeric,
   quantity numeric,
   level_defense numeric,
   level_atack numeric,
   CONSTRAINT Planet_Defense_fk FOREIGN KEY (ID_planet)
   REFERENCES PLANET (ID_planet),
   CONSTRAINT Defense_Planet_fk FOREIGN KEY (ID_defense)
   REFERENCES DEFENSE (ID_defense),
   PRIMARY KEY(ID_planet, ID_defense))';
   
   EXECUTE IMMEDIATE 'CREATE TABLE PLANET_SHIP
   (ID_planet numeric,
   ID_ship numeric,
   quantity numeric,
   level_defense numeric,
   level_atack numeric,
   CONSTRAINT Planet_Ship_fk FOREIGN KEY (ID_planet)
   REFERENCES PLANET (ID_planet),
   CONSTRAINT Ship_Planet_fk FOREIGN KEY (ID_ship)
   REFERENCES SHIP (ID_ship),
   PRIMARY KEY(ID_planet, ID_ship))';
   
    dbms_output.put_line('Se ha creado correctamente la table plante_ship y planet_defense');

   
exception
when others then
   dbms_output.put_line('ERROR: NO SE HA INDENTIFICADO EL ERROR DROP TABLE');

end;
