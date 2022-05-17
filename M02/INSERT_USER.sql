create or replace procedure INSERT_USER(nombre users.username%type, pas users.password%type, res out int)
as
    cantidadUsuarios int;
    verNombre int;
    id_usuario int;
    nombre_existe_exc exception;
    
begin
    select count(username) into verNombre from users where username = nombre;
    if verNombre != 0 then
        res := 0;
        raise nombre_existe_exc;
        
    end if;
    select count(id_user) into cantidadUsuarios from users;
    
    if cantidadUsuarios is null then
        id_usuario := 1;
    else 
       select max(id_user)+1 into id_usuario from users;
    end if;
     insert into USERS(id_user, username,birth_date,password)
     values (id_usuario, nombre, current_date, pas);
     res := 1;
   commit;
    
exception
    when nombre_existe_exc then
    dbms_output.put_line('ERROR: YA EXISTE UN USUARIO CON ESE NOMRE');
    when others then
        dbms_output.put_line('ERROR: Fallo desconocido');

end;