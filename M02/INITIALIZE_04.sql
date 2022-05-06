create or replace procedure INITIALIZE_04 (boton_reset int)
is
   compr int;

begin
   select count(table_name) into compr from user_tables;
   
   if boton_reset = 1 then
      DROP_TABLE_01;
      CREATE_TABLE_02;
      INSERT_DATA_03;
      
   else
      if compr = 0 then
         DROP_TABLE_01;
         CREATE_TABLE_02;
         INSERT_DATA_03;
         
      end if;
   end if;
end;