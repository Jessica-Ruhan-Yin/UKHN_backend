# 理事会成员介绍
drop table if exists `council_members`;
create table `council_members`
(
    `id`    bigint auto_increment not null comment 'id',
    `name` varchar(20) comment '名字',
    `application` varchar(20) comment '职位',
    `department` varchar(80) comment '单位',
    `image` varchar(100) comment '头像',
    `introduction`  varchar(100) comment '简介',
    `email`  varchar(30) comment '邮箱',
    `details`  varchar(500) comment '详情',
    `category`   char(8) not null comment '分类',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='理事会成员介绍';

# 插入理事会成员数据
insert into `council_members` (id, name, application, department, image, introduction, email, details, category) VALUE (1,'傅哲','会长','剑桥大学','','英国巴斯大学和伦敦大学学院双硕士，剑桥大学工程系博士','fu00@163.com','英国巴斯大学和伦敦大学学院双硕士，剑桥大学工程系博士。现任剑桥大学工程系博士后研究员，华为剑桥研究所技术顾问，英中博士联合会秘书长兼大使，且持有英国皇家协会认证“Global Talent Visa”。曾获剑桥大学圣凯瑟琳学院杰出研究成果奖，剑桥大学博士全额奖学金等荣誉。已发表多篇国际学术期刊且拥有多项科技专利。在剑桥大学与浙江大学等国内外大学有过授课经历，并在清华大学，中国科学院，剑桥阿登布鲁克医院(Addenbrooke’s Hospital)，剑桥创新和创业营，光电子系统博士培训中心，以及多个国际会议上进行过学术汇报。同时多次参与和协办英国春晚，中英高层次科技创新论坛等活动。','503');
insert into `council_members` (id, name, application, department, image, introduction, email, details, category) VALUE (2,'唐明初','副会长','伦敦大学学院','','本科毕业于英国萨塞克斯大学，硕士和博士毕业于伦敦大学学院','mingchutang@hotmail.com','本科毕业于英国萨塞克斯大学，硕士和博士毕业于伦敦大学学院。现任伦敦大学学院高级博士后研究员。主要研究领域为光电半导体材料，并在相关领域国际学术期刊发表文章60余篇，包括Nature Photonics, NatureCommunication, Optica，Photonics Research 等高档次期刊，谷歌学术引用次数超过1780，h-index 22。参与过OpticsExpress, Optics Letter，Photonics Research, ACSphotonics等期刊的审稿工作。曾受邀在浙江大学，根特大学，IMEC和香港中文大学进行过学术报告。','503');
insert into `council_members` (id, name, application, department, image, introduction, email, details, category) VALUE (3,'毕挺','副会长','梅努斯大学（爱尔兰）','','本科毕业于武汉大学，硕士和博士毕业于都柏林城市大学','bt0558@163.com','本科毕业于武汉大学，硕士和博士毕业于都柏林城市大学。现任梅努斯大学助理教授。主要工作与研究方向为多媒体传输及交互、物联网通信、自适应数字化学习技术及人工智能相关领域。曾参与欧盟地平线2020大型研究项目并发表多篇国际学术期刊，现主持爱尔兰科学基金委工业界研究员基金，与华为爱尔兰研究所合作开发下一代多路径软件自定义网络体系，同时在梅努斯大学与福建大学共建的梅努斯国际工程学院负责校际双学位合作项目。','503');
insert into `council_members` (id, name, application, department, image, introduction, email, details, category) VALUE (4,'陈晶晶','秘书长','汇丰银行（伦敦）','','清华大学新闻传播学和经济管理学双学士学位,研究生毕业于剑桥大学Judge商学院','Jingjingchen1994@gmail.com','清华大学新闻传播学和经济管理学双学士学位，曾获北京市优秀毕业生、清华大学优秀毕业论文、清华大学综合奖学金等荣誉。研究生毕业于剑桥大学Judge商学院，现任汇丰银行全球绿色金融部经理，主要工作为研究银行的可持续发展策略，为对环保、节能、清洁能源、绿色交通、绿色建筑等领域提供金融服务，支持环境改善、应对气候变化和资源节约高效利用的经济活动。','503');
insert into `council_members` (id, name, application, department, image, introduction, email, details, category) VALUE (5,'王宪发','副秘书长','谷歌（伦敦）','','本科毕业于南京大学，硕士毕业于中国科学院计算技术研究所。','xin89qs@gmail.com','本科毕业于南京大学，硕士毕业于中国科学院计算技术研究所。目前就职于谷歌（伦敦），目前工作方向为云网络基础构架，职业是软件工程师。本科及硕士期间曾多次代表学校参加AMC-ICPC国际大学生程序竞赛并获得金奖及银奖的成绩，硕士期间曾获国家奖学金及优秀毕业论文等荣誉，并多次在阿里、腾讯等公司举办的机器学习竞赛中取得top10的成绩。','503');
insert into `council_members` (id, name, application, department, image, introduction, email, details, category) VALUE (6,'文璐子','副秘书长','国际行动理事会','','爱尔兰都柏林理工大学旅游学士，爱尔兰都柏林大学工商管理硕士。','wen-luzi@hotmail.com','爱尔兰都柏林理工大学旅游学士，爱尔兰都柏林大学工商管理硕士。曾任爱尔兰中国学生学者联谊会主席。现任国际行动理事会主席秘书。具体事务为专注汇聚世界政要的智慧、人脉和资源为世界的和平与发展作贡献。','503');
insert into `council_members` (id, name, application, department, image, introduction, email, details, category) VALUE (7,'李智健','理事','组织与外联','','即将毕业于英国利兹大学环境与商务文科学士，将要就读伦敦大学发展管理与规划硕士。','veg66666@gmail.com','即将毕业于英国利兹大学环境与商务文科学士，将要就读伦敦大学发展管理与规划硕士。曾担任studygroup 预科集团学生大使，利兹大学总校学生会语言与文化校学生代表，利兹大学环境与商务专业学生代表。论文主要方向研究可持续发展。毕业论文是以三亚市为案例研究新能源汽车在私人和租赁行业可能受到的影响性因素。','503');
insert into `council_members` (id, name, application, department, image, introduction, email, details, category) VALUE (8,'刘家昌','名誉理事','','','','','','503');
insert into `council_members` (id, name, application, department, image, introduction, email, details, category) VALUE (9,'冯桂芳','名誉理事','','','','','','503');

# 学术论坛——展示
drop table if exists `academic_forum`;
create table `academic_forum`
(
    `id`    bigint auto_increment not null comment '学术论坛id',
    `date`  varchar(100) comment '创建时间',
    `text`  varchar(500) comment '标题',
    `category`   char(8) not null comment '分类' default '00000401',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='学术论坛——展示';
ALTER TABLE `academic_forum` ADD COLUMN form VARCHAR(15);

# 学术论坛——文章详情
drop table if exists `academic_forum_content`;
create table `academic_forum_content`
(
    `id`      bigint     not null comment '对应学术论坛id',
    `content` mediumtext not null comment '论坛内容',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='学术论坛——文章详情';
ALTER TABLE academic_forum_content drop COLUMN view;
ALTER TABLE academic_forum_content ADD COLUMN view BIGINT default 0;


-- 学术论坛——文章链接（url）
drop table if exists `academic_forum_url`;
create table `academic_forum_url`
(
    `id`      bigint     not null comment '对应学术论坛id',
    `url` varchar(100) not null comment '链接',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='学术论坛——链接详情';

# 学术论坛——文章详情的图片/视频地址
drop table if exists `academic_forum_file`;
create table `academic_forum_file`
(
    `id`       bigint auto_increment not null comment 'id',
    `slide_id` bigint                not null comment '对应学术论坛id',
    `url`      varchar(100) comment '地址',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='学术论坛——文章详情的图片/视频地址';

#-----------------------------------------------------------------
# 学术报告——展示
drop table if exists `academic_report`;
create table `academic_report`
(
    `id`    bigint auto_increment not null comment '学术报告id',
    `date`  varchar(100) comment '创建时间',
    `text`  varchar(500) comment '标题',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='学术报告——展示';
ALTER TABLE `academic_report` ADD COLUMN form VARCHAR(15);
ALTER TABLE `academic_report` ADD COLUMN category VARCHAR(15) default '00000403';

# 学术报告——文章详情
drop table if exists `academic_report_content`;
create table `academic_report_content`
(
    `id`      bigint     not null comment '对应学术报告id',
    `content` mediumtext not null comment '报告内容',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='学术报告——文章详情';
ALTER TABLE academic_report_content drop COLUMN view;
ALTER TABLE academic_report_content ADD COLUMN view BIGINT default 0;

# 学术报告——文章链接（url）
drop table if exists `academic_report_url`;
create table `academic_report_url`
(
    `id`      bigint     not null comment '对应学术报告id',
    `url` varchar(100) not null comment '链接',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='学术报告——文章链接';

# 学术报告——文章详情的图片/视频地址
drop table if exists `academic_report_file`;
create table `academic_report_file`
(
    `id`       bigint auto_increment not null comment 'id',
    `slide_id` bigint                not null comment '对应学术报告id',
    `url`      varchar(100) comment '地址',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='学术报告——文章详情的图片/视频地址';

#----------------------------------自贸港专栏-----------------------------------
-- 自贸港专栏——政策福利
drop table if exists `trade_policy`;
create table `trade_policy`
(
    `id`    bigint auto_increment not null comment 'id',
    `date`  varchar(100) comment '时间',
    `image` varchar(100) comment '图片',
    `text`  varchar(500) comment '文案',
    `category`   char(8) not null comment '分类' default '00000201',
    `form` varchar(15),
    `name` varchar(100),
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='自贸港专栏——政策福利';

-- 自贸港专栏——政策福利——合作详情
drop table if exists `trade_policy_content`;
create table `trade_policy_content`
(
    `id`      bigint     not null comment '对应政策福利板块id',
    `content` mediumtext not null comment '内容',
    `view` bigint default 0,
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='自贸港专栏——政策福利——合作详情';

-- 自贸港专栏——政策福利——合作链接
drop table if exists `trade_policy_url`;
create table `trade_policy_url`
(
    `id`      bigint     not null comment '对应政策福利板块id',
    `url` varchar(100) not null comment '链接',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='自贸港专栏——政策福利——合作详情链接';

-- 自贸港专栏——政策福利——合作详情内容文件
drop table if exists `trade_policy_content_file`;
create table `trade_policy_content_file`
(
    `id`       bigint auto_increment not null comment 'id',
    `slide_id` bigint                not null comment '对应板块id',
    `url`      varchar(100) comment '地址',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='自贸港专栏——政策福利——合作详情内容文件';

#-----------------------------------------------------------------------------
# 自贸港专栏——招商引资
drop table if exists `trade_business`;
create table `trade_business`
(
    `id`    bigint auto_increment not null comment 'id',
    `date`  varchar(100) comment '时间',
    `image` varchar(100) comment '图片',
    `text`  varchar(500) comment '文案',
    `category`   char(8) not null comment '分类' default '00000202',
    `form` varchar(15),
    `name` varchar(100),
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='自贸港专栏——招商引资';

-- 自贸港专栏——招商引资——合作详情
drop table if exists `trade_business_content`;
create table `trade_business_content`
(
    `id`      bigint     not null comment '对应招商引资板块id',
    `content` mediumtext not null comment '内容',
    `view` bigint default 0,
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='自贸港专栏——招商引资——合作详情';

-- 自贸港专栏——招商引资——合作链接
drop table if exists `trade_business_url`;
create table `trade_business_url`
(
    `id`      bigint     not null comment '对应招商引资板块id',
    `url` varchar(100) not null comment '链接',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='自贸港专栏——招商引资——合作详情链接';

-- 自贸港专栏——招商引资——合作详情内容文件
drop table if exists `trade_business_content_file`;
create table `trade_business_content_file`
(
    `id`       bigint auto_increment not null comment 'id',
    `slide_id` bigint                not null comment '对应板块id',
    `url`      varchar(100) comment '地址',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='自贸港专栏——招商引资——合作详情内容文件';

#----------------------------------------------------------------------------- 自贸港专栏——项目合作
drop table if exists `trade_project`;
create table `trade_project`
(
    `id`    bigint auto_increment not null comment 'id',
    `date`  varchar(100) comment '时间',
    `image` varchar(100) comment '图片',
    `text`  varchar(500) comment '文案',
    `category`   char(8) not null comment '分类' default '00000203',
    `form` varchar(15),
    `name` varchar(100),
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='自贸港专栏——项目合作';

-- 自贸港专栏——项目合作——合作详情
drop table if exists `trade_project_content`;
create table `trade_project_content`
(
    `id`      bigint     not null comment '对应项目合作板块id',
    `content` mediumtext not null comment '内容',
    `view` bigint default 0,
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='自贸港专栏——项目合作——合作详情';

-- 自贸港专栏——项目合作——合作链接
drop table if exists `trade_project_url`;
create table `trade_project_url`
(
    `id`      bigint     not null comment '对应项目合作板块id',
    `url` varchar(100) not null comment '链接',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='自贸港专栏——项目合作——合作详情链接';

-- 自贸港专栏——项目合作——合作详情内容文件
drop table if exists `trade_project_content_file`;
create table `trade_project_content_file`
(
    `id`       bigint auto_increment not null comment 'id',
    `slide_id` bigint                not null comment '对应板块id',
    `url`      varchar(100) comment '地址',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='自贸港专栏——项目合作——合作详情内容文件';

#----------------------------------------------------------------------------- 自贸港专栏——宣传推广
drop table if exists `trade_promotion`;
create table `trade_promotion`
(
    `id`    bigint auto_increment not null comment 'id',
    `date`  varchar(100) comment '时间',
    `image` varchar(100) comment '图片',
    `text`  varchar(500) comment '文案',
    `category`   char(8) not null comment '分类' default '00000204',
    `form` varchar(15),
    `name` varchar(100),
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='自贸港专栏——宣传推广';

-- 自贸港专栏——宣传推广——合作详情
drop table if exists `trade_promotion_content`;
create table `trade_promotion_content`
(
    `id`      bigint     not null comment '对应宣传推广板块id',
    `content` mediumtext not null comment '内容',
    `view` bigint default 0,
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='自贸港专栏——宣传推广——合作详情';

-- 自贸港专栏——宣传推广——合作链接
drop table if exists `trade_promotion_url`;
create table `trade_promotion_url`
(
    `id`      bigint     not null comment '对应宣传推广板块id',
    `url` varchar(100) not null comment '链接',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='自贸港专栏——宣传推广——合作详情链接';

-- 自贸港专栏——宣传推广——合作详情内容文件
drop table if exists `trade_promotion_content_file`;
create table `trade_promotion_content_file`
(
    `id`       bigint auto_increment not null comment 'id',
    `slide_id` bigint                not null comment '对应板块id',
    `url`      varchar(100) comment '地址',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='自贸港专栏——宣传推广——合作详情内容文件';

ALTER TABLE `intro_activity_content` MODIFY `view`  BIGINT NOT NULL DEFAULT 1;
ALTER TABLE `academic_seminar_content` MODIFY `view`  BIGINT NOT NULL DEFAULT 1;
ALTER TABLE collaboration_China_content MODIFY `view`  BIGINT NOT NULL DEFAULT 1;
ALTER TABLE collaboration_UK_Ireland_content MODIFY `view`  BIGINT NOT NULL DEFAULT 1;
ALTER TABLE collaboration_CUI_content MODIFY `view`  BIGINT NOT NULL DEFAULT 1;
ALTER TABLE home_news_content MODIFY `view`  BIGINT NOT NULL DEFAULT 1;
ALTER TABLE home_ad_content MODIFY `view`  BIGINT NOT NULL DEFAULT 1;
ALTER TABLE academic_forum_content MODIFY `view`  BIGINT NOT NULL DEFAULT 1;
ALTER TABLE academic_report_content MODIFY `view`  BIGINT NOT NULL DEFAULT 1;
ALTER TABLE `trade_business_content` MODIFY `view`  BIGINT NOT NULL DEFAULT 1;
ALTER TABLE `trade_policy_content` MODIFY `view`  BIGINT NOT NULL DEFAULT 1;
ALTER TABLE `trade_project_content` MODIFY `view`  BIGINT NOT NULL DEFAULT 1;
ALTER TABLE `trade_promotion_content` MODIFY `view`  BIGINT NOT NULL DEFAULT 1;