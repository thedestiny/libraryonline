/*
Navicat MySQL Data Transfer

Source Server         : sysroot
Source Server Version : 50710
Source Host           : 127.0.0.1:3306
Source Database       : mylibrary

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2016-06-06 18:09:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `guanli` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'flash', '123');
INSERT INTO `admin` VALUES ('2', 'queen', '456');
INSERT INTO `admin` VALUES ('3', 'jim', '123');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  `press` varchar(50) DEFAULT NULL,
  `station` varchar(255) DEFAULT '在库',
  `btime` int(20) DEFAULT '0' COMMENT '借阅次数',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('2', '100102', '石头记', '曹雪芹', '中国文艺出版社', '借出', '1');
INSERT INTO `book` VALUES ('3', '100103', '红楼梦', '曹雪芹', '中国文艺出版社', '借出', '1');
INSERT INTO `book` VALUES ('7', '100201', '水浒传', '施耐庵', '中国商务出版社', '在库', '0');
INSERT INTO `book` VALUES ('9', '100203', '水浒传', '施耐庵', '中国商务出版社', '在库', '0');
INSERT INTO `book` VALUES ('11', '100205', '水浒传', '施耐庵', '中国商务出版社', '在库', '0');
INSERT INTO `book` VALUES ('13', '100301', '平凡的世界', '路遥', '新华社出版社', '在库', '1');
INSERT INTO `book` VALUES ('14', '100302', '平凡的世界', '路遥', '新华社出版社', '借出', '1');
INSERT INTO `book` VALUES ('15', '100303', '平凡的世界', '路遥', '新华社出版社', '在库', '0');
INSERT INTO `book` VALUES ('16', '100304', '平凡的世界', '路遥', '新华社出版社', '在库', '2');
INSERT INTO `book` VALUES ('17', '100305', '平凡的世界', '路遥', '新华社出版社', '在库', '1');
INSERT INTO `book` VALUES ('18', '100306', '平凡的世界', '路遥', '新华社出版社', '在库', '0');
INSERT INTO `book` VALUES ('19', '100307', '平凡的世界', '路遥', '新华社出版社', '在库', '1');
INSERT INTO `book` VALUES ('21', '100401', '狼图腾', '杨克', '河南大学出版社', '在库', '0');
INSERT INTO `book` VALUES ('22', '100402', '狼图腾', '杨克', '河南大学出版社', '在库', '0');
INSERT INTO `book` VALUES ('23', '100403', '狼图腾', '杨克', '河南大学出版社', '在库', '0');
INSERT INTO `book` VALUES ('24', '100404', '狼图腾', '杨克', '河南大学出版社', '在库', '0');
INSERT INTO `book` VALUES ('25', '100405', '狼图腾', '杨克', '河南大学出版社', '在库', '0');
INSERT INTO `book` VALUES ('26', '100406', '狼图腾', '杨克', '河南大学出版社', '在库', '0');
INSERT INTO `book` VALUES ('27', '100407', '狼图腾', '杨克', '河南大学出版社', '在库', '0');
INSERT INTO `book` VALUES ('28', '100408', '狼图腾', '杨克', '河南大学出版社', '在库', '0');
INSERT INTO `book` VALUES ('29', '100409', '狼图腾', '杨克', '河南大学出版社', '在库', '0');
INSERT INTO `book` VALUES ('30', '100410', '狼图腾', '杨克', '河南大学出版社', '借出', '1');
INSERT INTO `book` VALUES ('31', '100501', '基督山', '大仲马', '中国大学出版社', '在库', '0');
INSERT INTO `book` VALUES ('32', '100502', '基督山', '大仲马', '中国大学出版社', '在库', '1');
INSERT INTO `book` VALUES ('33', '100503', '基督山', '大仲马', '中国大学出版社', '在库', '0');
INSERT INTO `book` VALUES ('34', '100504', '基督山', '大仲马', '中国大学出版社', '在库', '0');
INSERT INTO `book` VALUES ('35', '100505', '基督山', '大仲马', '中国大学出版社', '在库', '0');
INSERT INTO `book` VALUES ('43', '100701', '史记', '司马迁', '中国人民出版社', '在库', '0');
INSERT INTO `book` VALUES ('44', '100702', '史记', '司马迁', '中国人民出版社', '在库', '0');
INSERT INTO `book` VALUES ('47', '100801', '红岩', '共产党', '中国重工出版社', '在库', '0');
INSERT INTO `book` VALUES ('48', '100802', '红岩', '共产党', '中国重工出版社', '借出', '1');
INSERT INTO `book` VALUES ('49', '100803', '红岩', '共产党', '中国重工出版社', '在库', '0');
INSERT INTO `book` VALUES ('50', '100901', '国富论', '亚当斯密', '英国皇家出版社', '借出', '1');
INSERT INTO `book` VALUES ('51', '100902', '马克思', '马克思', '中国机械出版社', '在库', '0');
INSERT INTO `book` VALUES ('72', '100601', 'HeadFirst', '乔斯坦', '作家从出版社', '借出', '1');
INSERT INTO `book` VALUES ('73', '100602', 'HeadFirst', '乔斯坦', '作家从出版社', '在库', '0');
INSERT INTO `book` VALUES ('77', '100309', '苏菲的世界', '乔斯坦', '中国人民出版社', '在库', '0');
INSERT INTO `book` VALUES ('79', '100807', '三国演义', '罗贯中', '中国人民出版社', '在库', '0');
INSERT INTO `book` VALUES ('80', '100609', '苏菲的世界', '都梁', '中国人民出版社', '在库', '0');
INSERT INTO `book` VALUES ('82', '100105', '京华烟云', '林语堂', '作家从出版社', '在库', '1');
INSERT INTO `book` VALUES ('83', '101101', '边城', '沈从文', '中国文艺出版社', '在库', '0');
INSERT INTO `book` VALUES ('84', '101102', '边城', '沈从文', '中国文艺出版社', '在库', '0');
INSERT INTO `book` VALUES ('85', '101103', '边城', '沈从文', '中国文艺出版社', '在库', '0');
INSERT INTO `book` VALUES ('86', '101104', '边城', '沈从文', '中国文艺出版社', '借出', '1');
INSERT INTO `book` VALUES ('87', '101105', '边城', '沈从文', '中国文艺出版社', '在库', '0');
INSERT INTO `book` VALUES ('88', '100101', '苏菲的世界', '都梁', '中国人民出版社', '借出', '2');
INSERT INTO `book` VALUES ('90', '101202', '亮剑李云龙', '都梁', '作家从出版社', '借出', '1');
INSERT INTO `book` VALUES ('91', '101203', '亮剑', '都梁', '作家从出版社', '在库', '0');
INSERT INTO `book` VALUES ('92', '100206', '苏菲的世界', '乔斯坦', '作家从出版社', '借出', '1');

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL,
  `user` varchar(20) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `ctime` int(20) DEFAULT '0' COMMENT '借阅次数',
  `count` int(20) DEFAULT '0' COMMENT '当前借阅数目',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of card
-- ----------------------------
INSERT INTO `card` VALUES ('2', '3002', '3002', 'jim', '156374', '2', '1');
INSERT INTO `card` VALUES ('3', '3003', '3003', 'jack', '151391', '3', '2');
INSERT INTO `card` VALUES ('5', '3005', '3005', 'flash', '156374', '2', '1');
INSERT INTO `card` VALUES ('7', '3001', '3001', 'joe', '147654', '9', '4');
INSERT INTO `card` VALUES ('8', '3006', '3006', 'tom', '156987', '1', '1');
INSERT INTO `card` VALUES ('14', '3007', '3007', 'queen', '132689', '2', '2');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bcode` varchar(50) DEFAULT NULL,
  `ccode` varchar(50) DEFAULT NULL,
  `bcstate` varchar(50) DEFAULT NULL,
  `brtime` varchar(50) DEFAULT NULL,
  `retime` varchar(50) DEFAULT NULL,
  `bday` int(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_BOOK_RECORD` (`bcode`),
  KEY `FK_CARD_RECORD` (`ccode`),
  CONSTRAINT `FK_BOOK_RECORD` FOREIGN KEY (`bcode`) REFERENCES `book` (`code`),
  CONSTRAINT `FK_CARD_RECORD` FOREIGN KEY (`ccode`) REFERENCES `card` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=142 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('120', '100101', '3001', '已还', '2016-06-04', '2016-06-04', '1');
INSERT INTO `record` VALUES ('121', '100304', '3001', '已还', '2016-06-04', '2016-06-04', '1');
INSERT INTO `record` VALUES ('122', '100305', '3003', '已还', '2016-06-04', '2016-06-04', '1');
INSERT INTO `record` VALUES ('123', '100101', '3006', '借出', '2016-06-04', null, null);
INSERT INTO `record` VALUES ('125', '100410', '3003', '借出', '2016-06-04', null, null);
INSERT INTO `record` VALUES ('126', '100105', '3005', '已还', '2016-06-04', '2016-06-04', '1');
INSERT INTO `record` VALUES ('127', '100307', '3001', '已还', '2016-06-04', '2016-06-04', '1');
INSERT INTO `record` VALUES ('128', '100502', '3001', '已还', '2016-06-04', '2016-06-04', '1');
INSERT INTO `record` VALUES ('130', '101202', '3002', '借出', '2016-06-04', null, null);
INSERT INTO `record` VALUES ('131', '100901', '3003', '借出', '2016-06-04', null, null);
INSERT INTO `record` VALUES ('132', '100304', '3001', '已还', '2016-06-04', '2016-06-06', '3');
INSERT INTO `record` VALUES ('134', '100102', '3005', '借出', '2016-06-04', null, null);
INSERT INTO `record` VALUES ('135', '100601', '3001', '借出', '2016-06-04', null, null);
INSERT INTO `record` VALUES ('136', '100301', '3002', '已还', '2016-06-04', '2016-06-04', '1');
INSERT INTO `record` VALUES ('137', '101104', '3001', '借出', '2016-06-06', null, null);
INSERT INTO `record` VALUES ('138', '100206', '3007', '借出', '2016-06-06', null, null);
INSERT INTO `record` VALUES ('139', '100802', '3007', '借出', '2016-06-06', null, null);
INSERT INTO `record` VALUES ('140', '100103', '3001', '借出', '2016-06-06', null, null);
INSERT INTO `record` VALUES ('141', '100302', '3001', '借出', '2016-06-06', null, null);

-- ----------------------------
-- View structure for view_bc
-- ----------------------------
DROP VIEW IF EXISTS `view_bc`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_bc` AS select `card`.`code` AS `ccode`,`card`.`user` AS `user`,`book`.`code` AS `bcode`,`book`.`title` AS `title`,`book`.`author` AS `author`,`book`.`press` AS `press`,`record`.`bcstate` AS `station`,`record`.`brtime` AS `brtime`,`record`.`retime` AS `retime`,`record`.`bday` AS `bday` from ((`record` join `card` on((`record`.`ccode` = `card`.`code`))) join `book` on((`record`.`bcode` = `book`.`code`))) ;

-- ----------------------------
-- Procedure structure for PRO_bobook
-- ----------------------------
DROP PROCEDURE IF EXISTS `PRO_bobook`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRO_bobook`(IN `bcode` varchar(50),IN `ccode` varchar(50),OUT `msg` varchar(50))
BEGIN
	#Routine body goes here...
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET t_error=1;
	SELECT DATE_FORMAT(NOW(),'%Y-%m-%d') INTO @tim;
	SELECT id INTO @bid FROM book WHERE `code`=`bcode` and station='在库';
	SELECT id INTO @cid FROM card WHERE `code`=`ccode`;
	SELECT @bid;
	SELECT @cid;
	SELECT bcode;
	SELECT ccode;
	IF ISNULL(@bid) || ISNULL(@cid)  THEN
	SET t_error=1;
	END IF;
	START TRANSACTION;
	UPDATE book SET book.station='借出',book.btime=book.btime+1 WHERE book.id=@bid;
	UPDATE card SET card.ctime=card.ctime+1 ,card.count=card.count+1 WHERE card.id=@cid;
	INSERT INTO record (bcode,ccode,bcstate,brtime) VALUES(`bcode`,`ccode`,'借出',@tim);
	IF t_error=1 THEN 
	ROLLBACK;
	SET msg='bf';
	ELSE
	COMMIT;
	SET msg='bs';
	end IF;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for PRO_rebook
-- ----------------------------
DROP PROCEDURE IF EXISTS `PRO_rebook`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRO_rebook`(IN `bcde` varchar(50),IN `ccde` varchar(50),OUT `msg` varchar(50))
BEGIN
	#Routine body goes here...
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET t_error=1;
	SELECT DATE_FORMAT(NOW(),'%Y-%m-%d') INTO @tim1;
	SELECT `id` INTO @bid FROM `book` WHERE `code` =  bcde and `station` = '借出';
	SELECT `id` INTO @cid FROM `card` WHERE `code` = ccde;
	SELECT `brtime` , `id` INTO @tim0 , @rid  FROM `record` WHERE `bcode` = bcde AND `ccode` = ccde AND `bcstate` = '借出';
	-- SELECT id INTO @rid FROM record WHERE bcode = bcde AND ccode = ccde AND bcstate = '借出';
	SELECT DATEDIFF( @tim1, @tim0 ) INTO @dif; 
	IF ISNULL(@rid) || ISNULL(@bid) || ISNULL(@cid) THEN
	SET t_error = 1;
	END IF;
  SELECT @bid;
  SELECT @cid;
  SELECT @rid;
	SELECT @dif;
	SELECT @tim0;
	START TRANSACTION;
	UPDATE `book` SET `station` ='在库' WHERE `id` = @bid;
	UPDATE `card` SET `count` = `count` - 1 WHERE `id` = @cid;
	UPDATE `record` SET `bcstate` ='已还', `bday` = @dif + 1, `retime` = @tim1 WHERE `id` = @rid;
	IF t_error = 1 THEN 
			ROLLBACK;
			SET msg = 'rf';
	ELSE
			COMMIT;
			SET msg = 'rs';
	END IF;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for PRO_rebookv
-- ----------------------------
DROP PROCEDURE IF EXISTS `PRO_rebookv`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRO_rebookv`(IN `bcde` varchar(50),OUT `msg` varchar(50),OUT `de` varchar(50))
BEGIN
	#Routine body goes here...
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET t_error=1;
	SELECT DATE_FORMAT(NOW(),'%Y-%m-%d') INTO @tim1;
	SELECT `code` INTO @bde FROM book WHERE `code` = bcde and station = '借出';
	SELECT `brtime`,`id` INTO @tim0, @rid FROM record WHERE bcode = bcde AND bcstate = '借出';
	-- SELECT id INTO @rid FROM record WHERE bcode = bcode AND bcstate = '借出';
	SELECT ccode INTO @cd FROM record WHERE id = @rid;
	SELECT `code` INTO @cde FROM card WHERE `code` = @cd;
	-- SELECT id INTO @bid FROM book WHERE code =  bcode and station = '借出';
	-- SELECT id INTO @cid FROM card WHERE code = ccode;

	SELECT DATEDIFF( @tim1, @tim0 ) INTO @dif; 
	IF ISNULL(@rid) || ISNULL(@cde) || ISNULL(@bde) THEN
	SET t_error = 1;
	END IF;
	START TRANSACTION;
	UPDATE book SET station ='在库' WHERE `code`=@bde;
	UPDATE card SET count = count - 1 WHERE `code`=@cde;
	UPDATE record SET bcstate='已还', retime = @tim1, bday = @dif + 1 WHERE id = @rid;
	IF t_error = 1 THEN 
			ROLLBACK;
			SET msg = 'rf';
			SET de = @cde;
	ELSE
			COMMIT;
			SET msg = 'rs';
			SET de = @cde;
	END IF;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for p_select
-- ----------------------------
DROP PROCEDURE IF EXISTS `p_select`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `p_select`(IN `table` varchar(500),IN `size` int,IN `num` int,OUT `total` int)
BEGIN
	#Routine body goes here...
  SET @b = `size`*(`num` - 1);
  # 判断表是否存在
	#SELECT COUNT(1) INTO @istable FROM information_schema.`TABLES` t 
	#WHERE t.TABLE_SCHEMA = 'mylibrary' AND t.TABLE_NAME ='table';
	#IF @istable=1 THEN  
	SET @str_sql1 = CONCAT('select count(1) into @tt from ',`table`);
	PREPARE exec1 FROM @str_sql1;
	EXECUTE exec1;
  SET total=@tt;
	
	#END IF;
	SET @str_sql2 = CONCAT('select * from ', `table` , ' limit ', @b , ' , ',`size`);
	PREPARE exec2 FROM @str_sql2;
	EXECUTE exec2;
	
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for divide
-- ----------------------------
DROP FUNCTION IF EXISTS `divide`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `divide`(`a` int,`b` int) RETURNS int(11)
BEGIN
	#Routine body goes here...
	RETURN a-b ;
END
;;
DELIMITER ;
