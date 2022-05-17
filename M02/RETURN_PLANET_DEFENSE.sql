create or replace procedure RETURN_PLANET_DEFENSE(id_p int, res out varchar)
as
   cursor c1 is select id_defense, quantity, level_defense, level_atack from planet_defense where id_planet = id_p;
   all_c varchar(500);
   id_d int;
   quant int;
   lvl_d int;
   lvl_s int;
   
   ver_id int;
   excp_id exception;
   
begin
   select count(id_planet) into ver_id from planet_defense where id_planet = id_p;
   if ver_id = 0 then
      raise excp_id;
      
   end if;
   
   open c1;
   loop
      all_c := '0';
      fetch c1 into id_d, quant, lvl_d, lvl_s;
         exit when c1%notfound;
            if all_c = '0' then
               all_c := to_char(id_d);
               all_c := all_c||','||to_char(quant);
               all_c := all_c||','||to_char(lvl_d);
               all_c := all_c||','||to_char(lvl_s);
               all_c := all_c||';';
               
               if res is null then
                  res := all_c;
               
               else
                  res := res||all_c;
                  
               end if;
            end if;
   end loop;
   close c1;

exception
   when excp_id then
   DBMS_OUTPUT.PUT_LINE('EL ID_PLANET '||id_p||' NO EXISTE');
   rollback;
   
   when others then
   dbms_output.put_line('ERROR: NO SE HA INDENTIFICADO EL ERROR RETURN_PLANET_DEFENSE');
   rollback;
   
end;