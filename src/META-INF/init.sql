INSERT INTO products (`name`, `price`, `reg_date`, `status`) VALUES ('product 1', '21', '2020-01-01', 'ACTIVO');
INSERT INTO products (`name`, `price`, `reg_date`, `status`) VALUES ('product 2', '22', '2020-01-02', 'ACTIVO');
INSERT INTO products (`name`, `price`, `reg_date`, `status`) VALUES ('product 3', '23', '2020-01-03', 'ACTIVO');
INSERT INTO products (`name`, `price`, `reg_date`, `status`) VALUES ('product 4', '24', '2020-01-04', 'ACTIVO');
INSERT INTO products (`name`, `price`, `reg_date`, `status`) VALUES ('product 5', '25', '2020-01-05', 'ACTIVO');
INSERT INTO products (`name`, `price`, `reg_date`, `status`) VALUES ('product 6', '26', '2020-01-06', 'ACTIVO');
INSERT INTO products (`name`, `price`, `reg_date`, `status`) VALUES ('product 7', '27', '2020-01-07', 'ACTIVO');
INSERT INTO products (`name`, `price`, `reg_date`, `status`) VALUES ('product 8', '28', '2020-01-08', 'ACTIVO');
INSERT INTO products (`name`, `price`, `reg_date`, `status`) VALUES ('product 9', '29', '2020-01-09', 'ACTIVO');
INSERT INTO products (`name`, `price`, `reg_date`, `status`) VALUES ('product 10', '30', '2020-01-10', 'ACTIVO');


INSERT INTO customers (birthday,first_name,last_name,reg_date,status_string,salario,deudas,localtimes,status_ordinal) VALUES(curdate(),'Sandra Sarai','Hernandez Hernandez',now(),'ACTIVE',34.34,234.23,now(),0);
INSERT INTO customers (birthday,first_name,last_name,reg_date,status_string,salario,deudas,localtimes,status_ordinal) VALUES(curdate(),'Minerva','Barragan Loera',now(),'ACTIVE',23.23,234.23,now(),0);
INSERT INTO customers (birthday,first_name,last_name,reg_date,status_string,salario,deudas,localtimes,status_ordinal) VALUES(curdate(),'Luis Esteban','Araujo Hernandez',now(),'ACTIVE',54.54,234.23,now(),0);
INSERT INTO customers (birthday,first_name,last_name,reg_date,status_string,salario,deudas,localtimes,status_ordinal) VALUES(curdate(),'Hugo Esteban','Araujo Barragan',now(),'ACTIVE',98.98,234.23,now(),0);


INSERT INTO orders(reg_date,status,total,fk_customer) VALUES (now(),'ACTIVO',2345,1);
INSERT INTO orders(reg_date,status,total,fk_customer) VALUES (now(),'ACTIVO',1222,2);
INSERT INTO orders(reg_date,status,total,fk_customer) VALUES (now(),'ACTIVO',1222,3);
INSERT INTO orders(reg_date,status,total,fk_customer) VALUES (now(),'ACTIVO',2345,1);
INSERT INTO orders(reg_date,status,total,fk_customer) VALUES ('2019/10/10','ACTIVO',1222,1);
INSERT INTO orders(reg_date,status,total,fk_customer) VALUES ('2019/10/10','ACTIVO',2345,1);
INSERT INTO orders(reg_date,status,total,fk_customer) VALUES ('2019/10/10','ACTIVO',1222,1);


INSERT INTO order_lines(quantity,total,unit_price,fk_order,fk_product,ctr) VALUES(1,1,122,1,1,0);
INSERT INTO order_lines(quantity,total,unit_price,fk_order,fk_product,ctr) VALUES(2,2,122,1,2,1);
INSERT INTO order_lines(quantity,total,unit_price,fk_order,fk_product,ctr) VALUES(3,3,122,1,3,2);
INSERT INTO order_lines(quantity,total,unit_price,fk_order,fk_product,ctr) VALUES(4,4,122,1,4,3);
INSERT INTO order_lines(quantity,total,unit_price,fk_order,fk_product,ctr) VALUES(5,5,122,1,5,4);
INSERT INTO order_lines(quantity,total,unit_price,fk_order,fk_product,ctr) VALUES(6,6,122,1,6,5);
INSERT INTO order_lines(quantity,total,unit_price,fk_order,fk_product,ctr) VALUES(7,7,122,2,7,6);
INSERT INTO order_lines(quantity,total,unit_price,fk_order,fk_product,ctr) VALUES(8,8,122,2,8,7);
INSERT INTO order_lines(quantity,total,unit_price,fk_order,fk_product,ctr) VALUES(9,9,122,2,9,8);
INSERT INTO order_lines(quantity,total,unit_price,fk_order,fk_product,ctr) VALUES(10,10,122,2,2,9);


INSERT INTO clasifications (name) VALUES ("Clasificacion 1");
INSERT INTO clasifications (name) VALUES ("Clasificacion 2");
INSERT INTO clasifications (name) VALUES ("Clasificacion 3");
