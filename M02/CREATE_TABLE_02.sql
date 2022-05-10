create or replace procedure CREATE_TABLE_02
as
   
begin
  
   EXECUTE IMMEDIATE 'CREATE TABLE USERS
   (ID_user numeric primary key,
   username varchar(30) unique,
   birth_date date,
   password varchar(30))';
   
   EXECUTE IMMEDIATE 'CREATE TABLE PLANET
   (ID_planet numeric primary key,
   ID_user numeric,
   name varchar(30) unique,
   technology_atack numeric,
   technology_defense numeric,
   update_defense_cost numeric,
   update_atack_cost numeric,
   crystal_quantity numeric,
   iron_quantity numeric,
   deuterium_quantity numeric,
   CONSTRAINT Planet_User_fk FOREIGN KEY (ID_user)
      REFERENCES USERS (ID_user))';
   
   EXECUTE IMMEDIATE 'CREATE TABLE SHIP
   (ID_ship numeric primary key,
   name varchar(30) unique,
   metal_cost numeric,
   crystal_cost numeric,
   deuterium_cost numeric,
   initial_armor numeric,
   armor numeric,
   base_damage numeric,
   speed numeric,
   generate_wastings numeric)';
   
   EXECUTE IMMEDIATE 'CREATE TABLE PLANET_SHIP
   (ID_planet numeric,
   ID_ship numeric,
   cuantity numeric,
   lvl numeric,
   CONSTRAINT Planet_Ship_fk FOREIGN KEY (ID_planet)
      REFERENCES PLANET (ID_planet),
   CONSTRAINT Ship_Planet_fk FOREIGN KEY (ID_ship)
      REFERENCES SHIP (ID_ship),
   PRIMARY KEY(ID_planet, ID_ship))';
   
   EXECUTE IMMEDIATE 'CREATE TABLE DEFENSE
   (ID_defense numeric primary key,
   name varchar(30) unique,
   metal_cost numeric,
   crystal_cost numeric,
   deuterium_cost numeric,
   initial_armor numeric,
   armor numeric,
   base_damage numeric,
   speed numeric,
   generate_wastings numeric)';
   
   EXECUTE IMMEDIATE 'CREATE TABLE PLANET_DEFENSE
   (ID_planet numeric,
   ID_defense numeric,
   cuantity numeric,
   lvl numeric,
   CONSTRAINT Planet_Defense_fk FOREIGN KEY (ID_planet)
      REFERENCES PLANET (ID_planet),
   CONSTRAINT Defense_Planet_fk FOREIGN KEY (ID_defense)
      REFERENCES DEFENSE (ID_defense),
   PRIMARY KEY(ID_planet, ID_defense))';
   
   EXECUTE IMMEDIATE 'CREATE TABLE BATTLE
   (ID_battle numeric primary key,
   ID_user numeric,
   unit_user_begin numeric,
   unit_user_end numeric,
   unit_enemy_begin numeric,
   unit_enemy_end numeric,
   CONSTRAINT Battle_User_fk FOREIGN KEY (ID_user)
      REFERENCES USERS (ID_user))';

exception
   when others then
   dbms_output.put_line('ERROR: NO SE HA INDENTIFICADO EL ERROR CREATE TABLE');
  
end;
 