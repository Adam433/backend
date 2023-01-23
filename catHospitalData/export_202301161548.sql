-- cat_hospital_up.bill_table definition

CREATE TABLE `bill_table` (
  `bill_id` int NOT NULL AUTO_INCREMENT,
  `usage` int NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sell_price` double NOT NULL,
  `record_id` int NOT NULL,
  PRIMARY KEY (`bill_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- cat_hospital_up.cats_table definition

CREATE TABLE `cats_table` (
  `cat_id` int NOT NULL AUTO_INCREMENT,
  `nickname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cat_owner` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `birthday` bigint NOT NULL,
  `key` bigint NOT NULL,
  `sex` int NOT NULL,
  `sterilize` int NOT NULL,
  PRIMARY KEY (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- cat_hospital_up.inStocks_table definition

CREATE TABLE `inStocks_table` (
  `in_stock_id` int NOT NULL AUTO_INCREMENT,
  `type` int NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `key` bigint NOT NULL,
  `consumed` int NOT NULL,
  `sell_price` double NOT NULL,
  `brand` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `amount` int DEFAULT NULL,
  PRIMARY KEY (`in_stock_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- cat_hospital_up.inbound_table definition

CREATE TABLE `inbound_table` (
  `inbound_id` int NOT NULL AUTO_INCREMENT,
  `key` bigint NOT NULL,
  `amount` int NOT NULL,
  `batch_number` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `staff` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `purchase_price` double NOT NULL,
  `in_stock_id` int NOT NULL,
  PRIMARY KEY (`inbound_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- cat_hospital_up.permission_table definition

CREATE TABLE `permission_table` (
  `permission_id` int NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `permission_column` int NOT NULL DEFAULT '0',
  `url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- cat_hospital_up.records_table definition

CREATE TABLE `records_table` (
  `record_id` int NOT NULL AUTO_INCREMENT,
  `cat_id` int NOT NULL,
  `key` bigint NOT NULL,
  `staff_id` int NOT NULL,
  `weight` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `diagnosis` varchar(3000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `reserve` int NOT NULL DEFAULT '0',
  `bill_status` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- cat_hospital_up.role_permission definition

CREATE TABLE `role_permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `permission_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- cat_hospital_up.roles_table definition

CREATE TABLE `roles_table` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `katagaki` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `role_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- cat_hospital_up.showed_staff definition

CREATE TABLE `showed_staff` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `staff_id` int NOT NULL,
  `permission_id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=182 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- cat_hospital_up.staff_role definition

CREATE TABLE `staff_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_id` int NOT NULL,
  `staff_id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- cat_hospital_up.staff_table definition

CREATE TABLE `staff_table` (
  `staff_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `real_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `key` bigint NOT NULL,
  `intro` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `zaishoku` int NOT NULL,
  `avatar` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- cat_hospital_up.treatment_table definition

CREATE TABLE `treatment_table` (
  `treatment_id` int NOT NULL AUTO_INCREMENT,
  `record_id` int NOT NULL,
  `in_stock_id` int NOT NULL,
  `usage` int NOT NULL DEFAULT '0',
  `done` tinyint(1) NOT NULL,
  PRIMARY KEY (`treatment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- cat_hospital_up.vaccine_table definition

CREATE TABLE `vaccine_table` (
  `vaccine_id` int NOT NULL AUTO_INCREMENT,
  `cat_id` int NOT NULL,
  `date` bigint NOT NULL,
  PRIMARY KEY (`vaccine_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- cat_hospital_up.vermifuge_table definition

CREATE TABLE `vermifuge_table` (
  `vermifuge_id` int NOT NULL AUTO_INCREMENT,
  `cat_id` int NOT NULL,
  `date` bigint NOT NULL,
  PRIMARY KEY (`vermifuge_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO cat_hospital_up.bill_table (`usage`,name,sell_price,record_id) VALUES
	 (1,'洁牙',270.0,10),
	 (1,'注射麻醉',170.0,10),
	 (1,'洁牙',270.0,11),
	 (1,'注射麻醉',170.0,11);
INSERT INTO cat_hospital_up.cats_table (nickname,cat_owner,phone_number,birthday,`key`,sex,sterilize) VALUES
	 ('茂茂','茂茂主人','13987654321',1670326224147,1673681156724,1,1),
	 ('圈圈0','圈圈主人','18182288338',1452000276082,1673784728805,1,0),
	 ('圈圈1','圈圈主人','18182288338',1452000276082,1673681163106,1,0),
	 ('圈圈2','圈圈主人','18182288338',1452000276082,1673681167833,1,0),
	 ('猫咪3','客人3','13787654323',1502371531282,1661261153936,1,0);
INSERT INTO cat_hospital_up.inStocks_table (`type`,name,`key`,consumed,sell_price,brand,amount) VALUES
	 (0,'呼吸麻醉',1643644261100,21,122.0,NULL,NULL),
	 (1,'妙三多',1643644261010,102,175.0,'Pfizer',10),
	 (1,'大宠爱',1673607477274,0,84.0,'Zoetis',10),
	 (0,'缝合',1673612914187,0,20.0,NULL,NULL);
INSERT INTO cat_hospital_up.inbound_table (`key`,amount,batch_number,staff,purchase_price,in_stock_id) VALUES
	 (1671105159482,72,'20220809','张佳佳',65.0,2),
	 (1673599123559,30,'22211122','张佳佳',66.0,2),
	 (1673603995840,10,'20231010','张佳佳',72.0,2),
	 (1673608724999,10,'20231122','张佳佳',21.0,3);
INSERT INTO cat_hospital_up.permission_table (permission_name,permission_column,url) VALUES
	 ('用户列表',14,'/user/list'),
	 ('添加用户',14,'/user/add'),
	 ('用户信息维护',14,'/user/edit'),
	 ('角色权限',15,'/right/role'),
	 ('页面显示控制',15,'/right/page'),
	 ('库存管理',16,'/inStock/list'),
	 ('定价管理',16,'/inStock/pricing'),
	 ('待医生处理病历',17,'/todo/doctor'),
	 ('待助理处理病历',17,'/todo/assistant'),
	 ('预约就诊表',17,'/todo/reserve');
INSERT INTO cat_hospital_up.permission_table (permission_name,permission_column,url) VALUES
	 ('宠物档案',18,'/archives/cats'),
	 ('病历档案',18,'/archives/records'),
	 ('新建病历',18,'/archives/addrecord'),
	 ('人员管理',0,'/user'),
	 ('权限管理',0,'/right'),
	 ('库存及定价管理',0,'/inStock'),
	 ('待办事项',0,'/todo'),
	 ('档案管理',0,'/archives');
INSERT INTO cat_hospital_up.records_table (cat_id,`key`,staff_id,weight,diagnosis,reserve,bill_status) VALUES
	 (5,1671753960000,1,'2kg','<ul>
<li>1</li>
<li>2</li>
<li>3</li>
<li>4</li>
<li>5</li>
<li></li>
</ul>
',1,0),
	 (1,1673748360000,1,'未称重','<p></p>',0,0),
	 (1,1673921160000,1,'未称重','<p></p>',0,0),
	 (1,1673838360000,1,'未称重','<p></p>',0,0),
	 (1,1673831160000,1,'未称重','<p></p>',0,0),
	 (5,1661583337012,1,'2kg','<ul>
<li>1</li>
<li>2</li>
<li>3</li>
<li>4</li>
<li>5</li>
<li>6</li>
<li>7</li>
<li>8</li>
<li>9</li>
<li>0</li>
</ul>
',1,2),
	 (5,1661583337012,1,'2kg','<ul>
<li>1</li>
<li>2</li>
<li>3</li>
<li>4</li>
<li>5</li>
<li>6</li>
<li>7</li>
<li>8</li>
<li>9</li>
<li>0</li>
</ul>
',1,2),
	 (3,1673762760000,1,'未称重','<p></p>',1,0),
	 (4,1673681533847,1,'未称重','<p>22</p>
',0,0),
	 (1,1673834760000,1,'未称重','<p></p>',0,0);
INSERT INTO cat_hospital_up.role_permission (role_id,permission_id) VALUES
	 ('2','3'),
	 ('2','5'),
	 ('2','8'),
	 ('2','9'),
	 ('2','10'),
	 ('2','11'),
	 ('2','12'),
	 ('2','13'),
	 ('3','3'),
	 ('3','5');
INSERT INTO cat_hospital_up.role_permission (role_id,permission_id) VALUES
	 ('3','6'),
	 ('3','9'),
	 ('3','10'),
	 ('3','11'),
	 ('3','12'),
	 ('3','13'),
	 ('4','3'),
	 ('2','14'),
	 ('2','15'),
	 ('2','17');
INSERT INTO cat_hospital_up.role_permission (role_id,permission_id) VALUES
	 ('2','18'),
	 ('3','14'),
	 ('3','15'),
	 ('3','16'),
	 ('3','17'),
	 ('3','18'),
	 ('4','14'),
	 ('1','14'),
	 ('1','1'),
	 ('1','2');
INSERT INTO cat_hospital_up.role_permission (role_id,permission_id) VALUES
	 ('1','3'),
	 ('1','15'),
	 ('1','4'),
	 ('1','5'),
	 ('1','16'),
	 ('1','6'),
	 ('1','7'),
	 ('1','17'),
	 ('1','8'),
	 ('1','9');
INSERT INTO cat_hospital_up.role_permission (role_id,permission_id) VALUES
	 ('1','10'),
	 ('1','18'),
	 ('1','11'),
	 ('1','12'),
	 ('1','13');
INSERT INTO cat_hospital_up.roles_table (katagaki,role_name) VALUES
	 ('院长','ROLE_admin'),
	 ('医生','ROLE_doctor'),
	 ('助理','ROLE_assistant'),
	 ('游客','ROLE_guest');
INSERT INTO cat_hospital_up.showed_staff (staff_id,permission_id) VALUES
	 (2,1),
	 (2,2),
	 (2,3),
	 (2,4),
	 (2,5),
	 (2,6),
	 (2,7),
	 (2,8),
	 (2,9),
	 (2,10);
INSERT INTO cat_hospital_up.showed_staff (staff_id,permission_id) VALUES
	 (2,11),
	 (2,12),
	 (2,14),
	 (2,15),
	 (2,16),
	 (2,17),
	 (2,18),
	 (1,1),
	 (1,2),
	 (1,3);
INSERT INTO cat_hospital_up.showed_staff (staff_id,permission_id) VALUES
	 (1,4),
	 (1,5),
	 (1,6),
	 (1,7),
	 (1,8),
	 (1,9),
	 (1,10),
	 (1,11),
	 (1,12),
	 (1,14);
INSERT INTO cat_hospital_up.showed_staff (staff_id,permission_id) VALUES
	 (1,15),
	 (1,16),
	 (1,17),
	 (1,18),
	 (5,1),
	 (5,2),
	 (5,3),
	 (5,4),
	 (5,5),
	 (5,6);
INSERT INTO cat_hospital_up.showed_staff (staff_id,permission_id) VALUES
	 (5,7),
	 (5,8),
	 (5,9),
	 (5,10),
	 (5,11),
	 (5,12),
	 (5,13),
	 (5,14),
	 (5,15),
	 (5,16);
INSERT INTO cat_hospital_up.showed_staff (staff_id,permission_id) VALUES
	 (5,17),
	 (5,18),
	 (3,3),
	 (3,5),
	 (3,6),
	 (3,8),
	 (3,9),
	 (3,10),
	 (3,11),
	 (3,12);
INSERT INTO cat_hospital_up.showed_staff (staff_id,permission_id) VALUES
	 (3,14),
	 (3,15),
	 (3,16),
	 (3,17),
	 (3,18);
INSERT INTO cat_hospital_up.staff_role (role_id,staff_id) VALUES
	 (1,1),
	 (2,1),
	 (4,4),
	 (2,5),
	 (3,5),
	 (2,2),
	 (2,3),
	 (3,3);
INSERT INTO cat_hospital_up.staff_table (username,password,real_name,`key`,intro,zaishoku,avatar) VALUES
	 ('admin123','$2a$10$4h7C2ThHt/xLHeQV8nL2BuUL5AsPjRNayvOzY/ZKxA.qxlXg2gqk6','张佳佳',1502173286454,'<h3><span style="color: rgb(0,168,133);">・経歴</span></h3>
<p><span style="font-size: 10px;">平成18年4月</span><br><span style="font-size: 10px;">はとがや動物病院副院長</span><br><span style="font-size: 10px;">平成21年4月</span><br><span style="font-size: 10px;">どうぶつ園通りの動物病院院長（旭川）</span></p>
<h3><span style="color: rgb(0,168,133);">・業績</span></h3>
<p><span style="font-size: 10px;">AO Vet Table Instructor</span><br><span style="font-size: 10px;">DePuySynthes骨折セミナー講師・インストラクター</span></p>
<h3><span style="color: rgb(0,168,133);">・資格</span></h3>
<p><span style="font-size: 10px;">AO Principle course 修了<br>AO Advance course　修了<br>Synthes Vet TPLO seminar 修了<br>Synthes Vet Spine seminar Advance 修了</span></p>
<h3><span style="color: rgb(0,168,133);">・所属学会</span></h3>
<p><span style="font-size: 10px;font-family: Arial;">日獣医麻酔外科学会<br>獣医神経病学会<br>北獣協<br>旭川小動物臨床研究会 </span></p>
',1,'http://p0.itc.cn/images01/20201218/03697d2d279144c0a4b05e4cb2016aae.jpeg'),
	 ('test33','$2a$10$relIywBoP07T206gfTzkaefGxee.EO1fNIAwks9wP0iOyLGBJMI2S','黄医生',1502173286454,'<p>sdfd</p>
',1,'http://p0.itc.cn/images01/20201218/03697d2d279144c0a4b05e4cb2016aae.jpeg'),
	 ('luyisheng','$2a$10$eHP.ISgrwT5oMGViwa4Tkuk1cCO7hqvftv2MIafqg71iD6ldmWXT2','路医生',1672651800588,'<p>test</p>
',1,'http://p0.itc.cn/images01/20201218/03697d2d279144c0a4b05e4cb2016aae.jpeg'),
	 ('luyisheng2','$2a$10$2FBFXHBzmi2xEGOGb12tRuVSHkCGHMrg/qODtAe6/gCogoKgRfSSK','卢医生',1673429551362,'<p>test</p>
',1,'http://p0.itc.cn/images01/20201218/03697d2d279144c0a4b05e4cb2016aae.jpeg'),
	 ('liuyisheng','$2a$10$A0PfdyaYQ504fTw3XcDAh./16A/tu3YAXJH9XDBPIElhCQ8Iiq/Pm','刘医生',1672738492697,'<p>test22</p>
',1,'http://p0.itc.cn/images01/20201218/03697d2d279144c0a4b05e4cb2016aae.jpeg');
INSERT INTO cat_hospital_up.treatment_table (record_id,in_stock_id,`usage`,done) VALUES
	 (10,3,1,1),
	 (10,1,1,1),
	 (14,3,1,1),
	 (5,2,1,1),
	 (5,2,2,1),
	 (1,3,1,0),
	 (1,1,1,1);
INSERT INTO cat_hospital_up.vaccine_table (cat_id,`date`) VALUES
	 (5,1640964461000),
	 (5,1643642861000),
	 (5,1646062061000),
	 (1,1670326524147),
	 (1,1673936310859),
	 (2,1675167125551);
INSERT INTO cat_hospital_up.vermifuge_table (cat_id,`date`) VALUES
	 (5,1640964461000),
	 (5,1643642861000),
	 (5,1646062061000),
	 (1,1670326524147),
	 (2,1672747927101);
