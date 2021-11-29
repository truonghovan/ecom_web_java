
use web_sales ;
-- ===================================== insert
insert into category(id,catename,status)
values (1,"Laptop",1),(2,"Màn Hình",1),(3,"Chuột chơi game",1),(4,"Bàn phím",1),(5,"Tai nghe",1);
#laptop
insert into detail_category(id,detailCateName,category_id,status)
values ("1","Laptop Acer","1",1),("2","Laptop Asus","1",1),("3","Laptop Dell","1",1),("4","Laptop Lenovo","1",1),("5","Laptop HP","1",1);
#ManHinh
insert into detail_category(id,detailCateName,category_id,status)
values (6,"Màn Hình Samsung",2,1),(7,"Màn Hình ASUS",2,1),(8,"Màn Hình Acer",2,1),(9,"Màn Hình Gigabyte",2,1),(10,"Màn Hình MSI",2,1);
#Chuột chơi game
insert into detail_category(id,detailCateName,category_id,status)
values(11,"Chuột Logitech",3,1),(12,"Chuột Kingston HyperX",3,1),(13,"Chuột Razer",3,1),(14,"Chuột Asus",3,1),(15,"Chuột MSI",3,1),(16,"Chuột Hãng Khác",3,1);
#bàn phím
insert into detail_category(id,detailCateName,category_id,status)
values(17,"Bàn phím Logitech",4,1),(18,"Bàn phím Kingston HyperX",4,1),(19,"Bàn phím Razer",4,1),(20,"Bàn phím Asus",4,1),(21,"Bàn phím MSI",4,1),(22,"Bàn phím Hãng Khác",4,1);
#tai nghe
insert into detail_category(id,detailCateName,category_id,status)
values(23,"Tai nghe Logitech",5,1),(24,"Tai nghe Kingston HyperX",5,1),(25,"Tai nghe Razer",5,1),(26,"Tai nghe Asus",5,1),(27,"Tai nghe MSI",5,1),(28,"Tai nghe Hãng Khác",5,1);

-- ====================
# insert Brand

insert into brand (id,brand_name,image,status)
values (1,'MSI','lg1.png',1);
insert into brand (id,brand_name,image,status)
values (2,'Acer','logo2.png',1);
insert into brand (id,brand_name,image,status)
values (3,'Asus','logo3.jpg',1);
insert into brand (id,brand_name,image,status)
values (4,'Dell','logo4.png',1);
insert into brand (id,brand_name,image,status)
values (5,'Lenovo','logo5.jpg',1);
insert into brand (id,brand_name,image,status)
values (6,'HP','logo6.png',1);

insert into brand (id,brand_name,image,status)
values (7,'Samsung','logo7.jpeg',1);
insert into brand (id,brand_name,image,status)
values (8,'Gigabyte','logo8.png',1);
insert into brand (id,brand_name,image,status)
values (9,'Logitech','logo9.png',1);
insert into brand (id,brand_name,image,status)
values (10,'Kingston HyperX','logo10.png',1);
insert into brand (id,brand_name,image,status)
values (11,'Razer','logo11.png',1);
insert into brand (id,brand_name,image,status)
values (12,'Dareu','logo12.png',1);
insert into brand (id,brand_name,image,status)
values (13,'Cooler Master','logo13.png',1);

insert into brand (id,brand_name,image,status)
values (14,'Corsier','logo14.png',1);
insert into brand (id,brand_name,image,status)
values (15,'Other','logo15.PNG',1);

-- ==============================
insert into user( email, fullname, password, phone_number, role,status,username,address)
values('haductrung392000@gmail.com'   ,"Hà Đức"      ,'duc123'	,'9410250036',	    1,1,'ducadmin',	'Obere Str. 0123'),
      ('thanhlong120098@gmail.com'    ,"Hà Đức"      ,'duc123'	,'856352694',		0,1,'ducuser',	'Avda. de la Constitución 5678'),
      ('bvnghia0000@gmail.com'        ,"Văn Nghĩa"   ,'nghia123','124536824',		1,1,'nghiaadmin','Mataderos  7890'),
      ('bvnghiauu@gmail.com' 		  ,"Văn Nghĩa"   ,'nghia123','147253689',		0,1,'nghiauser',	'7890 Hanover Sq.'),
      ('nd1@gmail.com'                ,"Dương Hùng"  ,'hung123'	,'9410250036',	    1,1,'hungadmin',	'Obere Str. 0123'),
      ('nd2@gmail.com'                ,"Dương Hùng"  ,'hung123'	,'856352694',		0,1,'hunguser',	'Avda. de la Constitución 5678'),
      ('nd3@gmail.com'                ,"Quốc Huy"    ,'huy123'	,'124536824',		1,1,'huyadmin',	'Mataderos  7890'),
      ('nd4@gmail.com'                ,"Quốc Huy"    ,'huy123'	,'147253689',		0,1,'huyuser',	'6210 Hanover po.');
     
-- 'Bảo hành 3S1 siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật' 
-- #---------------Laptop 
#lapop acer     
insert into product(product_name,image,price,describe_product,detail_category_id,brand_id,quantity,status)
values 
("Laptop gaming Acer Aspire 7 A715 41G R282","AcerR282.png",5000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',1,2,10,1),
("Laptop gaming Acer Nitro 5 AN515 55 5923","Acer5923.png",6000000,'Bảo hành   siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',1,2,15,1),
("Laptop Gaming ACER Predator Helios PH315 53 770L","Acer770L.png",5000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',1,2,6,1),
("Laptop gaming Acer Predator Helios 300 PH315 53 70U6","Acer70U6.png",8000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',1,2,9,1),

("Laptop gaming Acer Nitro 5 AN515 55 55E3","Acer55E3.png",9000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',1,2,10,1),
("Laptop gaming Acer Aspire 7 A715 41G R150","AcerR150.png",10000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',1,2,8,1),
("Laptop Acer Aspire 3 A315 56 37DV","Acer37DV.png",11000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',1,2,6,1),
("Laptop Acer Aspire 3 A315 57G 31YD","Acer31YD.png",10000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',1,2,9,1),

("Laptop Acer Aspire 5 A514 54 39KU",'Acer39KU.png',8000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',1,2,15,1),
("Laptop Acer Swift 3 S SF314 42 R5Z6",'AcerR5Z6.png',9000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',1,2,10,1),
("Laptop Acer Swift 3 SF314 42 R0TR","AcerR0TR.png",8000000,'Bảo hành 3S1 siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',1,2,8,1),
("Laptop Acer Swift 3X SF314 510G 57MR","Acer57MR.png",5000000,'Bảo hành 3S1 siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',1,2,5,1);

# laptop asus
insert into product(product_name,image,price,describe_product,detail_category_id,brand_id,quantity,status)
values 
("Laptop ASUS TUF Gaming FA506II AL012T","AsusAL012T.png",10000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',2,3,10,1),
("Laptop ASUS TUF Gaming F15 FX506LI HN039T","AsusHN039T.png",9000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',2,3,10,1),
("Laptop Gaming Asus ROG Strix G G512 IAL013T","AsusIAL013T.png",9000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',2,3,10,1),
("Laptop ASUS ROG Strix G15 G512 IAL011T","AsusIAL011T.png",15000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',2,3,10,1),

("Laptop ASUS D409DA EK499T","AsusEK499T.png",5000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',2,3,10,1),
("Laptop ASUS Expertbook P1410CJA EK354T","AsusEK354T.png",8000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',2,3,10,1),
("Laptop Asus Vivobook A515EA BQ489T","AsusBQ489T.png",6000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',2,3,10,1),
("Laptop ASUS ExpertBook P2451FA EK0229T","AsusEK0229T.png",9000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',2,3,10,1),

("Laptop Asus Vivobook S533EA BQ018T","AsusBQ018T.png",8000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',2,3,10,1),
("Laptop ASUS ZenBook Flip UX363EA HP130T","AsusHP130T.png",5000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',2,3,10,1),
("Laptop ASUS ProArt Studiobook W700G1T AV046T","AsusAV046T.png",5000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',2,3,10,1),
("Laptop ASUS ZenBook Duo UX481FL BM048T","AsusBM048T.png",5000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',2,3,10,1);

# laptop dell
insert into product(product_name,image,price,describe_product,detail_category_id,brand_id,quantity,status)
values 
("Laptop Dell G3 3500 G3500A","DellG3500A.png",9000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',3,4,10,1),
("Laptop Dell Vostro 15 5502 70231340","Dell70231340.png",8000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',3,4,10,1),
("Laptop Dell Inspiron 5490 FMKJV11","DellFMKJV11.png",6000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',3,4,10,1),
("Laptop Dell Inspiron 14 5406 N4I5047W","DellN4I5047W.png",10000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',3,4,10,1),

("Laptop Dell Vostro 15 5502 V5502A","DellV5502A.png",7000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',3,4,10,1),
("Laptop Dell Inspiron 15 7501 X3MRY1","DellX3MRY1.png",8000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',3,4,10,1),
("Laptop Dell XPS 13 JGNH61","DellJGNH61.png",15000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',3,4,10,1),
("Laptop Dell Inspiron 15 5502 1XGR11","Dell1XGR11.png",11000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',3,4,10,1),

("Laptop Dell Vostro 14 5402 V5402A","DellV5402A.png",5000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',3,4,10,1),
("Laptop Dell Vostro 15 5502 70231320","Dell70231320.png",5000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',3,4,10,1),
("Laptop Dell Vostro 15 5502 70231322","Dell70231322.png",14000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',3,4,10,1),
("Laptop Dell Vostro 15 5502 V5502B","DellV5502B.png",13000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',3,4,10,1);

# laptop lenovo
insert into product(product_name,image,price,describe_product,detail_category_id,brand_id,quantity,status)
values 
("Laptop gaming Lenovo Legion 5 15IMH05 82AU004YVN","Lonovo82AU004YVN.png",15000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',4,5,10,1),
("Laptop gaming Lenovo Legion 5P 15IMH05H 82AW005QVN","Lonovo82AW005QVN.png",14000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',4,5,10,1),
("Laptop Lenovo IdeaPad 5 14ITL05 82FE000GVN","Lonovo82FE000GVN.png",9000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',4,5,10,1),
("Laptop Lenovo ThinkPad E14 20RAS0KX00","Lonovo20RAS0KX00.png",9000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',4,5,10,1),

("Laptop Lenovo ThinkPad E14 20RAS01000","Lonovo20RAS01000.png",9000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',4,5,10,1),
("LapTop Lenovo ThinkBook 14 IIL - 20SL00MFVN","Lonovo20SL00MFVN.png",9000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',4,5,10,1),
("Laptop Lenovo IdeaPad S145-15IIL 81W8001YVN","Lonovo81W8001YVN.png",9000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',4,5,10,1),
("Laptop Lenovo ThinkBook 14-IML 20RV00BEVN","Lonovo20RV00BEVN.png",9000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',4,5,10,1),

("Laptop Lenovo Thinkpad E14 Gen 2-ITU 20TA002NVA","Lonovo20TA002NVA.png",9000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',4,5,10,1),
("Laptop Lenovo Ideapad Gaming 3 15IMH05 81Y40067VN","Lonovo81Y40067VN.png",9000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',4,5,10,1),
("Laptop Lenovo Ideapad S340 14IIL ","Lonovo14IIL.png",9000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',4,5,10,1),
("Laptop Lenovo Ideapad C340 14IML","Lonovo14IML.png",9000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',4,5,10,1);

# laptop hp
insert into product(product_name,image,price,describe_product,detail_category_id,brand_id,quantity,status)
values 
("Laptop HP 15s FQ1107TU 193Q3PA","Hp193Q3PA.png",15000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',5,6,10,1),
("Laptop HP 340s G7 224L1PA","Hp224L1PA.png",9000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',5,6,10,1),
("Laptop HP ProBook 455 G7 1A1A9PA","Hp1A1A9PA.png",10000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',5,6,10,1),
("Laptop HP 15s FQ2027TU 2Q5Y3PA","Hp2Q5Y3PA.png",8000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',5,6,10,1),

("Laptop HP 15s FQ2029TU 2Q5Y7PA","Hp2Q5Y7PA.png",8000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',5,6,10,1),
("Laptop HP ProBook 455 G7 1A1B1PA","Hp1A1B1PA.png",6000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',5,6,10,1),
("Laptop HP Envy 13 ba1027TU 2K0B1PA","Hp2K0B1PA.png",9000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',5,6,10,1),
("Laptop HP 348 G7 9PH09PA","Hp9PH09PA.png",9000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',5,6,10,1),

("Laptop HP EliteBook x360 1030 G4 6MJ72AV","Hp6MJ72AV.png",10000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',5,6,10,1),
("Laptop HP 340s G7 224L1PA5 ","Hp224L1PA5.png",15000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',5,6,10,1),
("Laptop HP Pavilion x360 14-dh0104TU 6ZF32PA","Hp6ZF32PA.png",9000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',5,6,10,1),
("LLaptop HP 15s-fq2027TU 2Q5Y3SA","Hp2Q5Y3SA.png",15000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',5,6,10,1);

-- ================================================================---
#manf hinhf samsung
insert into product(product_name,image,price,describe_product,detail_category_id,brand_id,quantity,status) #9
values 
("Màn hình LCD SAMSUNG LF27T350","SamsungLCDSAMSUNGLF27T350.jpg",6000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',6,7,10,1),
("Màn Hình cong Samsung 48.9 LC49HG90DMEXXV","SamsungLC49HG90DMEXXV.jpg",7000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',6,7,10,1),
("Màn hình LCD Samsung 24 LS24D332HSXXV","SamsungLS24D332HSXXV.jpg",8000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',6,7,5,1),
("Màn hình Samsung 27 LC27R500FHEXXV","SamsungLC27R500FHEXXV.jpg",7000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',6,7,15,1),
("Màn Hình Samsung 23.5 LS24F350FHEXXV","SamsungLS24F350FHEXXV.jpg",8000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',6,7,5,1),
("Màn Hình Samsung 18.5 LS19F350HNEXXV","SamsungLS19F350HNEXXV.jpg",5000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',6,7,4,1),
("Màn Hình cong Samsung 23.5 LC24F390FHEXXV","SamsungLC24F390FHEXXV.jpg",10000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',6,7,5,1),
("Màn Hình Samsung 23.6 LS24E360HLXV","Ss236LS24E360HLXV.png",5000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',6,7,10,1),
("Màn Hình cong Samsung 27 LC27F390FHEXXV","Ss27LC27F390FHEXXV.png",6000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',6,7,8,1);

#man hinh asus
insert into product(product_name,image,price,describe_product,detail_category_id,brand_id,quantity,status)#9
values 
("Màn Hình ASUS 23.8 VA249HE","ASUS23.8VA249HE.jpg",6000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',7,3,10,1),
("Màn hình LCD ASUS VZ279HEG1R","LCDASUSVZ279HEG1R.png",6000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',7,3,9,1),
("Màn Hình ASUS 21.5 VP228NE","ASUS21.5VP228NE.jpg",6000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',7,3,8,1),
("Màn Hình ASUS 21.5 VZ229HE","ASUS21.5VZ229HE.jpg",6000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',7,3,6,1),
("Màn hình ASUS 23.6 VP247H","ASUS23.6VP247H.png",6000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',7,3,15,1),
("Màn Hình ASUS 27 VZ27AQ","ASUS27VZ27AQ.jpg",6000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',7,3,4,1),
("Màn hình LCD Asus 27 inch VX278H","Asus27inchVX278H.jpg",6000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',7,3,8,1),
("Màn Hình ASUS ROG Strix 27 XG27VQ","ASUSROGStrix27XG27VQ.jpg",6000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',7,3,12,1),
("Màn hình LCD ASUS TUF GAMING VG27VQ","LCDASUSTUFGAMINGVG27VQ.jpg",6000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',7,3,11,1);

#man hinh acer
insert into product(product_name,image,price,describe_product,detail_category_id,brand_id,quantity,status)#9
values 
("Màn Hình Acer 19.5 S200HQL","AcerS200HQL.jpg",5000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',8,2,10,1),
("Màn Hình cong Acer 31.5 ED322QL","congAcerED322QL.jpg",6000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',8,2,8,1),
("Màn Hình Acer 18.5 EB192QA","AcerEB192QA.jpg",10000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',8,2,11,1),
("Màn Hình Acer 23.8 ET241Y","AcerET241Y.jpg",5000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',8,2,9,1),
("Màn Hình Acer 27 ET271","AcerET271.jpg",8000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',8,2,7,1),
("Màn Hình Acer 23.6 K242HQL","AcerK242HQL.jpg",6000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',8,2,8,1),
("Màn Hình Acer Nitro 27","AcerNitro27.jpg",10000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',8,2,5,1),
("Màn hình LCD ACER K222HQL","LCDACERK222HQL.jpg",4500000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',8,2,5,1),
("Màn Hình Acer 19.5 K202HQL","Acer19.5K202HQL.jpg",5800000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',7,3,10,1);

#man hinh Gigabyte
insert into product(product_name,image,price,describe_product,detail_category_id,brand_id,quantity,status)
values 
("Màn hình LCD Gigabyte Aorus AD27QD-EK","GIGABYTEAD27QD.jpg",5000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',9,8,10,1),
("Màn hình LCD GIGABYTE G27QC-EK","GIGABYTEG27QC.jpg",4500000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',9,8,10,1),
("Màn hình LCD GIGABYTE G32QC-EK","GIGABYTEG32QC.jpg",8900000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',9,8,10,1),
("Màn hình LCD GIGABYTE G27FC-EK","GIGABYTEG27FC.png",6200000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',9,8,10,1);


#Màn Hình MSI
insert into product(product_name,image,price,describe_product,detail_category_id,brand_id,quantity,status)
values 
("Màn hình LCD MSI Optix MAG322CQRV","MSIMAG322CQRV.jpg",5000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',10,1,10,1),
("Màn hình LCD MSI Pro MP221","MSIMP221.jpg",6500000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',10,1,8,1),
("Màn hình LCD MSI Pro MP241","MSIMP241.jpg",8500000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',10,1,9,1),
("Màn hình LCD MSI Optix MAG271CQR","MSIMAG271CQR.jpg",1400000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',10,1,4,1),
("Màn hình LCD MSI Optix G27C4","MSIG27C4.jpg",2100000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',10,1,10,1),
("Màn hình LCD MSI Optix G271","MSIG271.jpg",8000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',10,1,5,1),
("Màn hình LCD MSI Optix G27C5","MSIG27C5.jpg",3800000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',10,1,4,1);


#---====================================================================
#chuot choi game
#chuot logittich
insert into product(product_name,image,price,describe_product,detail_category_id,brand_id,quantity,status)
values 
("Chuột máy tính Logitech B100 (Đen)","LogitechB100.jpg",5000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',11,9,10,1),
("Chuột không dây Logitech M187 (Trắng)","LogitechM187.jpg",5000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',11,9,5,1),
("Chuột máy tính Logitech M105 (Đen)","LogitechM105.jpg",5000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',11,9,8,1);

# chuot Newmen hang khac
insert into product(product_name,image,price,describe_product,detail_category_id,brand_id,quantity,status)
values 
("Chuột máy tính Newmen M266 đen","NewmenM266.jpg",5000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',16,15,10,1),
("Chuột máy tính không dây Newmen F266 (Vàng)","NewmenF266.jpg",5000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',16,15,8,1),
("Chuột máy tính không dây Newmen F430 (Đen)","NewmenF430.jpg",5000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',16,15,9,1);
# chuot hang khac
insert into product(product_name,image,price,describe_product,detail_category_id,brand_id,quantity,status)
values 
("Chuột không dây Microsoft RJN-00017","RJN-00017.jpg",1000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',16,15,10,1),
("Chuột có dây Microsoft Classic Intellimouse","MicrosoftClassicIntellimouse.jpg",4000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',16,15,10,1),
("Chuột không dây Microsoft Arc ELG-00005 (Đen)","MicrosoftArcELG-00005.jpg",2000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',16,15,10,1);


#id 14 ban phim LOGITECH
insert into product(product_name,image,price,describe_product,detail_category_id,brand_id,quantity,status)
values 
("Bàn phím Logitech K400 Plus","K400Plus.jpg",1000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',17,9,10,1),
("Bàn phím không dây Logitech MX Keys (Đen)","MXKey.jpg",1200000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',17,9,10,1),
("Bàn phím cơ gaming Logitech G512 GX (Tactile)","LogitechG512.png",2100000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',17,9,10,1);

#id 15 ban phim DAREU
insert into product(product_name,image,price,describe_product,detail_category_id,brand_id,quantity,status)
values 
("Bàn phím Dareu EK880 Brown Switch","EK880Brown.jpg",1000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',17,12,10,1),
("Bàn phím Dareu EK880 Blue Switch","EK880Blue.jpg",1200000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',17,12,15,1),
("Bàn phím Dareu EK169 Red D Switch","EK169RedD.jpg",1900000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',17,12,8,1);

#id ban phim AKKO
insert into product(product_name,image,price,describe_product,detail_category_id,brand_id,quantity,status)
values 
("Bàn phím Akko 3108S RGB PRO Blue Switch (108 keys) (Hồng)","Akko3108S.jpg",1000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',22,15,15,1),
("Bàn phím AKKO 3087 World Tour - Tokyo Switch Pink (87 keys)","AKKO3087.jpg",1000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',22,15,11,1),
("Bàn phím cơ Akko 3108 Dragon Ball Z - Goku Orange Switch","Akko3108.jpg",1000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',22,15,4,1);

#id  tai nghe 16 JBL
insert into product(product_name,image,price,describe_product,detail_category_id,brand_id,quantity,status)
values 
("Tai nghe Gaming JBL QUANTUM 400 ( Đen)","GamingJBLQUANTUM400.jpg",1200000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',28,15,15,1),
("Tai nghe On-ear JBL T500 (Xanh dương)","OnEarJBLT500.jpg",1400000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',28,15,15,1),
("Tai Nghe Bluetooth JBL Tune T220TWSBLK (Đen)","BLTuneT220TWSBLK.jpg",1000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',28,15,15,1);


#id 17 tai nghe  Sony
insert into product(product_name,image,price,describe_product,detail_category_id,brand_id,quantity,status)
values 
("Tai nghe Sony MDR-XB550AP (Đỏ)","SonyMDRXB550AP.jpg",1200000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',28,15,10,1),
("Tai nghe On-ear Sony MDRZX310APLCE (Xanh dương)","SonyMDRZX310APLCE.png",1400000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',28,15,9,1),
("Tai nghe không dây In-ear Sony WI-SP500/BQE (Đen)","SonyWISP500.jpg",1000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',28,15,15,1);
#id 18 tai nghe PHILIPS
insert into product(product_name,image,price,describe_product,detail_category_id,brand_id,quantity,status)
values 
("Tai nghe Over-ear Philips SHP 2000 (Đen)","PhilipsSHP2000.jpg",1000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',28,15,8,1),
("Tai nghe On-ear Philips SHL 3060 (Xanh)","PhilipsSHL3060.jpg",1200000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',28,15,2,1),
("Tai nghe On-ear Philips SHM6110U (Trắng)","PhilipsSHM6110U.jpg",1600000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',28,15,2,1);

# tai nghe logittech
insert into product(product_name,image,price,describe_product,detail_category_id,brand_id,quantity,status)
values 
("Tai nghe nhét tai chống ồn T13 TOPK ","TaiNgheTOPK.png",1200000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',23,9,15,1),
("Tai Nghe Nhét Tai Mi Basic HSEJ03JY","TaiNgheHSEJ03JY.png",1100000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',23,9,15,1),
("Tai nghe có dây nhét tai Q21","TaiNgheQ21.png",3000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',23,9,15,1);
  


# Tai nghe Kingston HyperX
insert into product(product_name,image,price,describe_product,detail_category_id,brand_id,quantity,status)
values 
("Tai Nghe Nhét Tai Fontopia MDR-E9LP ","TaiNgheMDR-E9LP.png",1200000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',24,10,15,1),
("Tai Nghe Nhét Tai Mi Basic HSEJ03Jz","TaiNgheHSEJ03Jz.png",1100000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',24,10,15,1),
("Tai nghe có dây N20 âm thanh nguyên bản chất lượng cao","TaiNgheN20.png",3000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',24,10,15,1);


# Tai nghe Razer
insert into product(product_name,image,price,describe_product,detail_category_id,brand_id,quantity,status)
values 
("Tai Nghe E9LP ","TaiNgheE9LP.png",1200000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',25,11,3,1),
("Tai nghe Razer AKG","TaiNgheAKG.png",1100000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',25,11,10,1),
("Tai Nghe Nhét Tai Langsdom Super Bass JM26","TaiNgheJM26.png",3000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',25,11,8,1);


# Tai nghe Asus
insert into product(product_name,image,price,describe_product,detail_category_id,brand_id,quantity,status)
values 
("Tai nghe nhét tai có dây S17","TaiNgheS17.png",1200000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',26,3,3,1),
("Tai nghe nhét tai Jack 3.5mm BYZ","TaiNgheBYZ.png",1100000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',26,3,10,1),
("Tai Nghe Nhét Tai Sony MDR-EX15AP","TaiNgheEX15AP.png",3000000,'Bảo hành  siêu nhanh: bảo hành nhanh, trong vòng 3 ngày kể cả thứ 7 và chủ nhật',26,3,8,1);






