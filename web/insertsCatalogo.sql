/*nombre DB ParnaDB*/
create table plan(
   
    id numeric primary key not null,
    IMAGENPARQUE varchar(100),
    COSTO_ADULTO_TEM_ALTA double,
    COSTO_ADULTO_TEM_BAJA double,
    COSTO_NIÑO_TEM_ALTA double,
    COSTO_NIÑO_TEM_BAJA double,
    HORARIO varchar(100),
    IMAGENMAPA varchar(100),
    NOMBRE varchar(100)
)

create table Orden(
   
    id numeric primary key not null,
    nombre varchar(100),
    direccion varchar(100),
    telefono varchar(30),
    ciudad varchar(30),
    pais varchar(30)

)

create table plan_orden(
    id numeric primary key not null,
    id_orden numeric not null,
    id_plan numeric not null,
    nombre_parque varchar(100),
    costo_ingreso double, 
    CONSTRAINT Orden_PlanOrdenFK FOREIGN KEY (id_orden) references Orden(id),
    CONSTRAINT Plan_PlanOrdenFK FOREIGN KEY (id_plan) references Plan(id)
)
insert into plan(ID,IMAGENPARQUE,COSTO_ADULTO_TEM_ALTA,COSTO_ADULTO_TEM_BAJA,COSTO_NIÑO_TEM_ALTA,COSTO_NIÑO_TEM_BAJA,HORARIO,IMAGENMAPA,NOMBRE)
values(1,'cocuy.png',100000,70000,70000,50000,'Lunes - Domingo 7:00AM - 5:00PM','cocuy-mapa.png','parque natural del cocuy');

insert into plan(ID,IMAGENPARQUE,COSTO_ADULTO_TEM_ALTA,COSTO_ADULTO_TEM_BAJA,COSTO_NIÑO_TEM_ALTA,COSTO_NIÑO_TEM_BAJA,HORARIO,IMAGENMAPA,NOMBRE)
values(2,'sierra-nevada.png',110000,80000,70000,50000,'Lunes - Sabado 8:00AM - 4:00PM','sierra-nevada-mapa.png','parque sierra nevada');

insert into plan(ID,IMAGENPARQUE,COSTO_ADULTO_TEM_ALTA,COSTO_ADULTO_TEM_BAJA,COSTO_NIÑO_TEM_ALTA,COSTO_NIÑO_TEM_BAJA,HORARIO,IMAGENMAPA,NOMBRE)
values(3,'tayrona.png',120000,90000,70000,50000,'Lunes - Domingo 8:00AM - 7:00PM','tayrona-mapa.png','parque natural tayrona');

insert into orden(id, nombre, direccion, telefono, ciudad, pais) values(1,'dani','streetOne','55555','pasto','colombie');
ALTER TABLE root.orden  id varchar;
