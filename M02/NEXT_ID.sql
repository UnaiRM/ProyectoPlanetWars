create or replace procedure NEXT_ID(next_id out int)
as

begin
   select max(id_planet)+1 into next_id from planet;
   if next_id is null then
      next_id := 1;
      
   end if;
   
   DBMS_OUTPUT.PUT_LINE('SE HA COMPLETADO EL PROCESO CORRECTAMENTE');
   
exception
   when others then
   dbms_output.put_line('ERROR: NO SE HA INDENTIFICADO EL ERROR NEXT_ID');
   rollback;
   
end;