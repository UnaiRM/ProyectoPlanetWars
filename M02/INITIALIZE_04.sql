create or replace procedure INITIALIZE_04(boton_reset int)
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
/
begin
   initialize_04(1);
end;