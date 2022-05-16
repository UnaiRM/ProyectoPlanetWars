create or replace procedure RETURN_PLANET_DEFENSE(id_p in int, all_c out varchar)
as
   cursor c1 is select id_defense from planet_defense where id_planet = id_p;
   cursor c2 is select quantity from planet_defense where id_planet = id_p;
   cursor c3 is select level_defense from planet_defense where id_planet = id_p;
   cursor c4 is select level_atack from planet_defense where id_planet = id_p;
   x int;
   
   ver_id int;
   excp_id exception;
   
begin
   select count(id_planet) into ver_id from planet_defense where id_planet = id_p;
   
   if ver_id = 0 then
      raise excp_id;
   end if;

--CURSOR PARA LA ID_DEFENSE
   open c1;
   loop
      fetch c1 into x;
         exit when c1%notfound;
         if all_c is null then
             all_c := to_char(x);
            
         else
            all_c := all_c||','||to_char(x);
            
         end if;
   end loop;
   close c1;
   
   all_c := all_c||';';
--CURSOR PARA LA QUANTITY
   open c2;
   loop
      fetch c2 into x;
         exit when c2%notfound;
         if substr(all_c,-1,1) = ';' then
             all_c := all_c ||to_char(x);
            
         else
            all_c := all_c||','||to_char(x);
         
      end if;
   end loop;
   close c2;
   
   all_c := all_c||';';
--CURSOR PARA LEVEL_DEFENSE
   open c3;
   loop
      fetch c3 into x;
      exit when c3%notfound;
      if substr(all_c,-1,1) = ';' then
             all_c := all_c ||to_char(x);
         
      else
         all_c := all_c||','||to_char(x);
         
      end if;
   end loop;
   close c3;
   
   all_c := all_c||';';
--CURSOR PARA LEVEL_ATTACK
   open c4;
   loop
      fetch c4 into x;
      exit when c4%notfound;
      if substr(all_c,-1,1) = ';' then
             all_c := all_c ||to_char(x);
         
      else
         all_c := all_c||','||to_char(x);
         
      end if;
   end loop;
   
   close c4;

exception
   when excp_id then
   DBMS_OUTPUT.PUT_LINE('ERROR: EL ID '||id_p||' NO EXISTE');

   when others then
   dbms_output.put_line('ERROR: NO SE HA INDENTIFICADO EL ERROR RETURN_PLANET_SHIP');
   rollback;

end;