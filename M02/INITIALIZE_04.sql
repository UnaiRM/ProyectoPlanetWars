create or replace procedure INITIALIZE_04
as
   boton_reset int := 0;
   
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
      DBMS_OUTPUT.PUT_LINE('CREATE, INSERT');
      CREATE_TABLE_02;
      DBMS_OUTPUT.put_line('SE HA CREADO LA TABLA 0');
      INSERT_DATA_03;
      DBMS_OUTPUT.put_line('SE HA INSERTADO LA TABLA 0');
   else--PARA EL BOTON RESET
      if boton_reset = 1 then
         DBMS_OUTPUT.put_line('BOTON RESET');
         DROP_TABLE_01;
         DBMS_OUTPUT.put_line('SE HA BORRADO LA TABLA 1');
         CREATE_TABLE_02;
         DBMS_OUTPUT.put_line('SE HA CREADO LA TABLA 1');
         INSERT_DATA_03;
         DBMS_OUTPUT.put_line('SE HA INSERTADO LA TABLA 1');
         
      end if;
   end if;
end;
