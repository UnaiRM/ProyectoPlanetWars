create or replace procedure CREATE_TABLE_02
as
   
begin
   EXECUTE IMMEDIATE 'CREATE TABLE USERS
   (ID_user numeric primary key,
   username varchar(30) unique not null,
   birth_date date not null,
   password varchar(30) not null)';
   
   EXECUTE IMMEDIATE 'CREATE TABLE PLANET
   (ID_planet numeric primary key,
   ID_user numeric not null,
   name varchar(30) unique not null,
   technology_atack numeric not null,
   technology_defense numeric not null,
   update_defense_cost numeric not null,
   update_atack_cost numeric not null,
   crystal_quantity numeric not null,
   metal_quantity numeric not null,
   deuterium_quantity numeric not null,
   CONSTRAINT Planet_User_fk FOREIGN KEY (ID_user)
      REFERENCES USERS (ID_user))';
   
   EXECUTE IMMEDIATE 'CREATE TABLE SHIP
   (ID_ship numeric primary key,
   name varchar(30) unique not null,
   metal_cost numeric not null,
   crystal_cost numeric not null,
   deuterium_cost numeric not null,
   initial_armor numeric not null,
   armor numeric not null,
   base_damage numeric not null,
   speed numeric not null,
   generate_wastings numeric not null)';
   
   EXECUTE IMMEDIATE 'CREATE TABLE PLANET_SHIP
   (ID_planet numeric not null,
   ID_ship numeric not null,
   quantity numeric not null,
   level_defense numeric not null,
   level_atack numeric not null,
   CONSTRAINT Planet_Ship_fk FOREIGN KEY (ID_planet)
      REFERENCES PLANET (ID_planet),
   CONSTRAINT Ship_Planet_fk FOREIGN KEY (ID_ship)
      REFERENCES SHIP (ID_ship),
   PRIMARY KEY(ID_planet, ID_ship))';
   
   EXECUTE IMMEDIATE 'CREATE TABLE DEFENSE
   (ID_defense numeric primary key,
   name varchar(30) unique not null,
   metal_cost numeric not null,
   crystal_cost numeric not null,
   deuterium_cost numeric not null,
   initial_armor numeric not null,
   armor numeric not null,
   base_damage numeric not null,
   speed numeric not null,
   generate_wastings numeric not null)';
   
   EXECUTE IMMEDIATE 'CREATE TABLE PLANET_DEFENSE
   (ID_planet numeric not null,
   ID_defense numeric not null,
   quantity numeric not null,
   level_defense numeric not null,
   level_atack numeric not null,
   CONSTRAINT Planet_Defense_fk FOREIGN KEY (ID_planet)
      REFERENCES PLANET (ID_planet),
   CONSTRAINT Defense_Planet_fk FOREIGN KEY (ID_defense)
      REFERENCES DEFENSE (ID_defense),
   PRIMARY KEY(ID_planet, ID_defense))';
   
   EXECUTE IMMEDIATE 'CREATE TABLE BATTLE
   (ID_battle numeric primary key,
   ID_user numeric not null,
   unit_user_begin numeric not null,
   unit_user_end numeric not null,
   unit_enemy_begin numeric not null,
   unit_enemy_end numeric not null,
   CONSTRAINT Battle_User_fk FOREIGN KEY (ID_user)
      REFERENCES USERS (ID_user))';
   commit;

exception
   when others then
   dbms_output.put_line('ERROR: NO SE HA INDENTIFICADO EL ERROR CREATE TABLE');
   rollback;
   
end;
 