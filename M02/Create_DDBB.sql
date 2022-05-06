create or replace procedure CREATE_TABLE_02
as
     create1 VARCHAR(500);
     create2 VARCHAR(500);
     create3 VARCHAR(500);
     create4 VARCHAR(500);
     create5 VARCHAR(500);
     create6 VARCHAR(500);
     create7 VARCHAR(500);
     
begin
    create1 := 'CREATE TABLE USERS
  (ID_user numeric primary key,
  username varchar(30) unique,
  birth_date date,
  password varchar(30))';
  
    create2 := '
CREATE TABLE PLANET
  (ID_planet numeric primary key,
  ID_user numeric,
  name varchar(30) unique,
  technology_atack numeric,
  technology_defense numeric,
  update_defense_cost numeric,
  update_atack_cost numeric,
  crystal_quantity numeric,
  metal_quantity numeric,
  deuterium_quantity numeric,
  CONSTRAINT Planet_User_fk FOREIGN KEY (ID_user) REFERENCES USERS (ID_user))';
  
    create3 := '
CREATE TABLE SHIP
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
  
    create4 := '
CREATE TABLE PLANET_SHIP
  (ID_planet numeric,
  ID_ship numeric,
  ship_quantity numeric,
  ship_level numeric,
   CONSTRAINT Planet_Ship_fk FOREIGN KEY (ID_planet) REFERENCES PLANET (ID_planet),
   CONSTRAINT Ship_Planet_fk FOREIGN KEY (ID_ship) REFERENCES SHIP (ID_ship),
   PRIMARY KEY(ID_planet, ID_ship))';
   
    create5 := '
CREATE TABLE DEFENSE
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

    create6 := '
CREATE TABLE PLANET_DEFENSE
  (ID_planet numeric,
  ID_defense numeric,
  defense_quantity numeric,
  defense_level numeric,
  CONSTRAINT Planet_Defense_fk FOREIGN KEY (ID_planet) REFERENCES PLANET (ID_planet),
  CONSTRAINT Defense_Planet_fk FOREIGN KEY (ID_defense) REFERENCES DEFENSE (ID_defense),
  PRIMARY KEY(ID_planet, ID_defense))';

    create7:= '
CREATE TABLE BATTLE
  (ID_battle numeric primary key,
  ID_user numeric,
  unit_user_begin numeric,
  unit_user_end numeric,
  unit_enemy_begin numeric,
  unit_enemy_end numeric,
  CONSTRAINT Battle_User_fk FOREIGN KEY (ID_user) REFERENCES USERS (ID_user))';
  
  EXECUTE IMMEDIATE create1;
  EXECUTE IMMEDIATE create2;
  EXECUTE IMMEDIATE create3;
  EXECUTE IMMEDIATE create4;
  EXECUTE IMMEDIATE create5;
  EXECUTE IMMEDIATE create6;
  EXECUTE IMMEDIATE create7;
  end;
  /
  set serveroutput on
  begin
  CREATE_TABLE_02;
  end;
 