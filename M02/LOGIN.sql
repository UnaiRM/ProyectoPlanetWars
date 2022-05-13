create or replace procedure LOGIN(user in users.username%TYPE, password in users.password%TYPE, p_user out int,
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
/*/
set SERVEROUTPUT ON
declare
   x int;
   ux varchar(500);
   
begin
   login('Alex', '1234', x, ux);
   DBMS_OUTPUT.PUT_LINE('ID_USER: '||x ||' '||'LISTA_PLANETAS: '||ux );
end;*/
