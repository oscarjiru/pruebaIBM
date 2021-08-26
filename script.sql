CREATE TABLE proveedores (
"id_proveedor" NUMBER(9,0) NOT NULL,
"nombre" VARCHAR2 (100), 
"fecha_alta" DATE,
"id_cliente" NUMBER(9,0),
 CONSTRAINT "id_proveedor_pk" PRIMARY KEY ("id_proveedor")
 );
 
 
INSERT INTO proveedores VALUES (1, "Coca-cola", null, 5);
INSERT INTO proveedores VALUES (2, "Pepsi", null, 5);
INSERT INTO proveedores VALUES (3, "Redbull", null, 6);
