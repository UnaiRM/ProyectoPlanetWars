create or replace package planet_wars
as
   procedure DROP_TABLE_01;
   
   procedure CREATE_TABLE_02;
   
   procedure INSERT_DATA_03;
   
   procedure INITIALIZE_04(boton_reset int);
   
   procedure GET_DEFENSE_05 (d_id defense.id_defense%TYPE, d_name out defense.name%TYPE,
   d_metal out defense.metal_cost%TYPE, d_crystal out defense.crystal_cost%TYPE, d_deuterium out defense.deuterium_cost%TYPE,
   d_initial out defense.initial_armor%TYPE, d_armor out defense.armor%TYPE, d_base out defense.base_damage%TYPE,
   d_speed out defense.speed%TYPE, d_generate out defense.generate_wastings%TYPE);
   
   procedure GET_SHIP_06 (s_id in ship.id_ship%TYPE, s_name out ship.name%TYPE,
   s_metal out ship.metal_cost%TYPE, s_crystal out ship.crystal_cost%TYPE, s_deuterium out ship.deuterium_cost%TYPE,
   s_initial out ship.initial_armor%TYPE, s_armor out ship.armor%TYPE, s_base out ship.base_damage%TYPE,
   s_speed out ship.speed%TYPE, s_generate out ship.generate_wastings%TYPE);
   
   procedure GET_PLANET (p_id in out planet.id_planet%TYPE, p_user out planet.id_user%TYPE,
   p_name out planet.name%TYPE, p_tecno_attack out planet.technology_atack%TYPE, p_tecno_defense out planet.technology_defense%TYPE,
   p_upt_defense out planet.update_defense_cost%TYPE, p_upt_attack out planet.update_atack_cost%TYPE,
   p_crystal out planet.crystal_quantity%TYPE, p_iron out planet.metal_quantity%TYPE, p_deuterium out planet.deuterium_quantity%TYPE);
   
   procedure LOGIN(user in users.username%TYPE, password in users.password%TYPE, p_user out int,
   lista_id out varchar);
   
   procedure INSERT_PLANET_SHIP(id_planeta planet_ship.id_planet%type, id_defensa planet_ship.id_ship%type,
   cantidad planet_ship.quantity%type, nivel_ataque planet_ship.level_atack%type, nivel_defensa planet_ship.level_defense%type);
   
   procedure INSERT_PLANET_DEFENSE(id_planeta planet_ship.id_planet%type, id_defensa planet_ship.id_ship%type,
   cantidad planet_ship.quantity%type, nivel_ataque planet_ship.level_atack%type, nivel_defensa planet_ship.level_defense%type);
   
   procedure INSERT_PLANET(next_id planet.id_planet%TYPE,id_user planet.id_user%type, nombre planet.name%type,
   tec_ataque planet.technology_atack%type, tec_defensa planet.technology_defense%type, update_defensa planet.update_defense_cost%type,
   update_ataque planet.update_atack_cost%type, cristal planet.crystal_quantity%type, metal planet.metal_quantity%type,
   deuterium planet.deuterium_quantity%type);
   
   procedure UPDATE_PLANET(id_planeta planet.id_planet%type,  nombre planet.name%type, tec_ataque planet.technology_atack%type,
   tec_defensa planet.technology_defense%type, update_defensa planet.update_defense_cost%type, update_ataque planet.update_atack_cost%type,
   cristal planet.crystal_quantity%type, metal planet.metal_quantity%type, deuterium planet.deuterium_quantity%type);
   
   procedure DELETE_SHIP;

end;
/
create or replace package body planet_wars
as
   procedure DROP_TABLE_01
   as
   begin
      execute immediate  'DROP TABLE BATTLE';
      execute immediate  'DROP TABLE PLANET_SHIP';
      execute immediate  'DROP TABLE PLANET_DEFENSE';
      execute immediate  'DROP TABLE DEFENSE';
      execute immediate  'DROP TABLE SHIP';
      execute immediate  'DROP TABLE PLANET';
      execute immediate  'DROP TABLE USERS';
      commit;
      
   exception
      when others then
      dbms_output.put_line('ERROR: NO SE HA INDENTIFICADO EL ERROR DROP TABLE');
      rollback;
      
   end;
-------------------------------------------------------------------------------------   
   procedure CREATE_TABLE_02
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
-----------------------------------------------------------------------------------------
   procedure INSERT_DATA_03
   as
      
   begin
   --INSERCIÓN USUARIOS
      execute immediate  'INSERT INTO USERS VALUES (1,''Unai'',current_date,''1234'')';
      execute immediate  'INSERT INTO USERS VALUES (2,''Andres'',current_date,''1234'')';
      execute immediate  'INSERT INTO USERS VALUES (3,''Alex'',current_date,''1234'')';
      execute immediate  'INSERT INTO USERS VALUES (4,''Eduard'',current_date,''1234'')';
   --INSERCIÓN NAVES
      execute immediate  'INSERT INTO SHIP VALUES(1,''Light Hunter'',3000,0,50,400,0,80,3,20)';
      execute immediate  'INSERT INTO SHIP VALUES(2,''Heavy Hunter'',6500,0,50,1000,0,150,7,30)';
      execute immediate  'INSERT INTO SHIP VALUES(3,''Battle Ship'',45000,0,7000,6000,0,1000,45,60)';
      execute immediate  'INSERT INTO SHIP VALUES(4,''Armored Ship'',30000,0,15000,8000,0,700,70,75)';
   --INSERCIÓN DEFENSA
      execute immediate  'INSERT INTO DEFENSE VALUES(1,''Missile Launcher'',2000,0,0,200,0,80,5,10)';
      execute immediate  'INSERT INTO DEFENSE VALUES(2,''Ion Cannon'',4000,0,500,1200,0,250,12,25)';
      execute immediate  'INSERT INTO DEFENSE VALUES(3,''Plasma Cannon'',50000,0,5000,7000,0,2000,30,50)';
      commit;
   
   exception
      when others then
      dbms_output.put_line('ERROR: NO SE HA INDENTIFICADO EL ERROR INSERT DATA');
      rollback;
   end;
------------------------------------------------------------------------------------------
   procedure INITIALIZE_04(boton_reset int)
   as   
      existe_b int;
      existe_d int;
      existe_p int;
      existe_pd int;
      existe_ps int;
      existe_s int;
      existe_u int;
      total int;
      
   begin
      select count(*) into existe_b from tab where tname=upper('BATTLE');
      select count(*) into existe_d from tab where tname=upper('DEFENSE');
      select count(*) into existe_p from tab where tname=upper('PLANET');
      select count(*) into existe_pd from tab where tname=upper('PLANET_DEFENSE');
      select count(*) into existe_ps from tab where tname=upper('PLANET_SHIP');
      select count(*) into existe_s from tab where tname=upper('SHIP');
      select count(*) into existe_u from tab where tname=upper('USERS');
      
      total := existe_b + existe_d + existe_p + existe_pd + existe_ps + existe_s + existe_u;
   
      if total != 7 then
         --PARA CUANDO SE INICIA EL PROGRAMA
         CREATE_TABLE_02;
         DBMS_OUTPUT.put_line('SE HA CREADO LA TABLA');
         INSERT_DATA_03;
         DBMS_OUTPUT.put_line('SE HA INSERTADO LA TABLA');
         
      else
         --PARA EL BOTON RESET
         if boton_reset = 1 then
            DBMS_OUTPUT.put_line('BOTON RESET');
            DROP_TABLE_01;
            DBMS_OUTPUT.put_line('SE HA BORRADO LA TABLA, BOTON RESET');
            CREATE_TABLE_02;
            DBMS_OUTPUT.put_line('SE HA CREADO LA TABLA, BOTON RESET');
            INSERT_DATA_03;
            DBMS_OUTPUT.put_line('SE HA INSERTADO LA TABLA, BOTON RESET');
            
         end if;
      end if;
      
   exception
      when others then
      dbms_output.put_line('ERROR: NO SE HA INDENTIFICADO EL ERROR INSERT DATA');
      
   end;
-------------------------------------------------------------------------------------
   procedure GET_DEFENSE_05 (d_id defense.id_defense%TYPE, d_name out defense.name%TYPE,
   d_metal out defense.metal_cost%TYPE, d_crystal out defense.crystal_cost%TYPE, d_deuterium out defense.deuterium_cost%TYPE,
   d_initial out defense.initial_armor%TYPE, d_armor out defense.armor%TYPE, d_base out defense.base_damage%TYPE,
   d_speed out defense.speed%TYPE, d_generate out defense.generate_wastings%TYPE)
   
   as
      existe int;
      
      excp_existe exception;
      
   begin
   --VERIFICA QUE LA ID EXISTA
      select count(id_defense) into existe from defense where id_defense = d_id;
      if existe = 0 then
         raise excp_existe;
         
      end if;
   --DEVUELVE LOS DATOS
      select name, metal_cost, crystal_cost, deuterium_cost, initial_armor, armor, base_damage,speed, generate_wastings
      into d_name, d_metal, d_crystal, d_deuterium, d_initial, d_armor, d_base, d_speed, d_generate from defense
      where id_defense = d_id;
      
   exception
      when excp_existe then
      dbms_output.put_line('ERROR: LA ID '||' NO EXISTE');
      
      when others then
      dbms_output.put_line('ERROR: NO SE HA INDENTIFICADO EL ERROR');
      
   end;
--------------------------------------------------------------------------------------------------------------
   procedure GET_SHIP_06 (s_id in ship.id_ship%TYPE, s_name out ship.name%TYPE,
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
--------------------------------------------------------------------------------------------
   procedure GET_PLANET (p_id in out planet.id_planet%TYPE, p_user out planet.id_user%TYPE,
   p_name out planet.name%TYPE, p_tecno_attack out planet.technology_atack%TYPE, p_tecno_defense out planet.technology_defense%TYPE,
   p_upt_defense out planet.update_defense_cost%TYPE, p_upt_attack out planet.update_atack_cost%TYPE,
   p_crystal out planet.crystal_quantity%TYPE, p_iron out planet.metal_quantity%TYPE, p_deuterium out planet.deuterium_quantity%TYPE)

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
-------------------------------------------------------------------------------------------------------
   procedure LOGIN(user in users.username%TYPE, password in users.password%TYPE, p_user out int,
   lista_id out varchar)
   as
      existe_user int;
      existe_password int;
      existe_planet int;
      
      planet_id int;
      cursor c1 is select id_planet from planet where id_user = p_user;
      
      excp_user exception;
      excp_password exception;
      
   begin
      select count(username) into existe_user from users where username = user;
      --SI EL USUARIO ES INCORRECTO EL RESULTADO ES UN 0
      if existe_user = 0 then
         p_user := 0;
         raise excp_user;
      
      end if;
      
      select password into existe_password from users where username = user;
      --SI EL USUARIO ES CORRECTO Y LA PASSWORD ES INCORRECTA EL RESULTADO ES UN -1
      if existe_password != password then
         p_user := -1;
         raise excp_password;
      
      end if;
      select id_user into p_user from users where username = user;--DEVUELVE LA ID DEL USUARIO
      --SI EL USUARIO Y LA PASSWORD SON CORRECTAS EL RESULTADO ES MAYOR QUE 0
      
      open c1;
      
      loop
         fetch c1 into planet_id;
         exit when c1%notfound;
         if lista_id is null then
            lista_id := to_char(planet_id);
            
         else
            lista_id := lista_id||','||to_char(planet_id);
         end if;
      end loop;
      
      close c1;
      
      if lista_id is null then
         lista_id := 0;
      end if;
      DBMS_OUTPUT.PUT_LINE('SE HA LOGEADO CORRECTAMENTE');
      
   exception
      when excp_user then
      DBMS_OUTPUT.PUT_LINE('ERROR: EL USUARIO NO EXISTE');
   
      when excp_password then
      DBMS_OUTPUT.PUT_LINE('ERROR: LA CONTRASENYA ES INCORRECTA');
      
      when others then
      dbms_output.put_line('ERROR: NO SE HA INDENTIFICADO EL ERROR');
      
   end;
-------------------------------------------------------------------------------------------------------
   procedure INSERT_PLANET_SHIP(id_planeta planet_ship.id_planet%type, id_defensa planet_ship.id_ship%type,
   cantidad planet_ship.quantity%type, nivel_ataque planet_ship.level_atack%type, nivel_defensa planet_ship.level_defense%type)
   as
   
   begin
      insert into PLANET_SHIP values (id_planeta, id_defensa, cantidad, nivel_ataque, nivel_defensa);
      commit;
   
   exception
      when others then
      dbms_output.put_line('ERROR: NO SE HA INDENTIFICADO EL ERROR INSERT DATA');
      rollback;
   
   end;
----------------------------------------------------------------------------------------------------------
   procedure INSERT_PLANET_DEFENSE(id_planeta planet_ship.id_planet%type, id_defensa planet_ship.id_ship%type,
   cantidad planet_ship.quantity%type, nivel_ataque planet_ship.level_atack%type, nivel_defensa planet_ship.level_defense%type)
   as
   
   begin
      insert into PLANET_DEFENSE values (id_planeta, id_defensa, cantidad, nivel_ataque, nivel_defensa);
      commit;
      
   exception
      when others then
      dbms_output.put_line('ERROR: NO SE HA INDENTIFICADO EL ERROR INSERT DATA');
      rollback;
   
   end;
-------------------------------------------------------------------------------------------------------------
   procedure INSERT_PLANET(next_id planet.id_planet%TYPE,id_user planet.id_user%type, nombre planet.name%type,
   tec_ataque planet.technology_atack%type, tec_defensa planet.technology_defense%type, update_defensa planet.update_defense_cost%type,
   update_ataque planet.update_atack_cost%type, cristal planet.crystal_quantity%type, metal planet.metal_quantity%type,
   deuterium planet.deuterium_quantity%type)
   as
   
   begin
   
      insert into PLANET (id_planet, id_user, name, technology_atack, technology_defense, update_defense_cost, update_atack_cost,
      crystal_quantity, metal_quantity, deuterium_quantity)
      values (next_id, id_user, nombre, tec_ataque, tec_defensa, update_defensa, update_ataque, cristal, metal, deuterium);
      commit;
      
      DBMS_OUTPUT.PUT_LINE('SE HA INSERTADO LA FILA CORRECTAMENTE');
      
   exception
      when others then
      dbms_output.put_line('ERROR: NO SE HA INDENTIFICADO EL ERROR INSERT DATA');
      rollback;
   
   end;
--------------------------------------------------------------------------------------------------------------
   procedure UPDATE_PLANET(id_planeta planet.id_planet%type,  nombre planet.name%type, tec_ataque planet.technology_atack%type,
   tec_defensa planet.technology_defense%type, update_defensa planet.update_defense_cost%type, update_ataque planet.update_atack_cost%type,
   cristal planet.crystal_quantity%type, metal planet.metal_quantity%type, deuterium planet.deuterium_quantity%type)
   as
   
   begin
      update planet
      set  name = nombre, technology_atack = tec_ataque, technology_defense = tec_defensa, update_defense_cost = update_defensa,
      update_atack_cost = update_ataque where id_planet = id_planeta;
      commit;
   
   exception
      when others then
      dbms_output.put_line('ERROR: NO SE HA INDENTIFICADO EL ERROR INSERT DATA');
      rollback;
      
   end;
----------------------------------------------------------------------------------------------------------------
   procedure DELETE_SHIP
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
      commit;
   
      
   exception
      when others then
      dbms_output.put_line('ERROR: NO SE HA INDENTIFICADO EL ERROR DROP TABLE');
      rollback;
   
   end;
end;