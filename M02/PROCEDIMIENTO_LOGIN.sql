create or replace procedure LOGIN(user in users.username%TYPE, password in users.password%TYPE, resultado out int)
as
   existe_user int;
   existe_password int;
   
   excp_user exception;
   excp_password exception;
   
begin
   select count(username) into existe_user from users where username = user;
   --SI EL USUARIO ES INCORRECTO EL RESULTADO ES UN 0
   if existe_user = 0 then
      resultado := 0;
      raise excp_user;
   
   end if;
   
   select password into existe_password from users where username = user;
   --SI EL USUARIO ES CORRECTO Y LA PASSWORD ES INCORRECTA EL RESULTADO ES UN -1
   if existe_password != password then
      resultado := -1;
      raise excp_password;
   
   end if;
   --SI EL USUARIO Y LA PASSWORD SON CORRECTAS EL RESULTADO ES UN 1
   resultado := 1;
   DBMS_OUTPUT.PUT_LINE('SE HA LOGEADO CORRECTAMENTE');
   
exception
   when excp_user then
   DBMS_OUTPUT.PUT_LINE('ERROR: EL USUARIO NO EXISTE');

   when excp_password then
   DBMS_OUTPUT.PUT_LINE('ERROR: LA CONTRASENYA ES INCORRECTA');
   
   when others then
   dbms_output.put_line('ERROR: NO SE HA INDENTIFICADO EL ERROR');
   
end;
/
set SERVEROUTPUT ON
declare
   x int;
   
begin
   login('Andes', '123', x);
   DBMS_OUTPUT.PUT_LINE(x);
end;