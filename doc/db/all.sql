drop table if exists `user`;
create table `user`
(
    `id`         char(8)     not null default '' comment 'id',
    `login_name` varchar(50) not null comment '登录名',
    `password`   char(32)    not null comment '密码',
    primary key (`id`),
    unique key `login_name_unique` (`login_name`)
) engine = innodb
  default charset = utf8mb4 comment ='管理员';

-- 同乡会介绍——同乡会活动部分轮播图
drop table if exists `intro_activity_slide`;
create table `intro_activity_slide`
(
    `id`    bigint auto_increment not null comment 'id',
    `date`  datetime comment '创建时间',
    `image` varchar(100) comment '图片',
    `text`  varchar(500) comment '文案',
    `category`   char(8) not null comment '分类',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='同乡会介绍——同乡会活动部分轮播图';
ALTER TABLE intro_activity_slide ADD COLUMN form VARCHAR(15);
alter table intro_activity_slide change text title varchar(100);
ALTER TABLE intro_activity_slide change date date varchar(100);
ALTER TABLE intro_activity_slide ADD COLUMN text VARCHAR(1000);



-- 同乡会介绍——同乡会活动——活动内容详情
drop table if exists `intro_activity_content`;
create table `intro_activity_content`
(
    `id`      bigint     not null comment '对应轮播图id',
    `content` mediumtext not null comment '活动内容',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='同乡会介绍——同乡会活动——活动内容详情';
ALTER TABLE intro_activity_content drop COLUMN view;
ALTER TABLE intro_activity_content ADD COLUMN view BIGINT default 0;

-- 同乡会介绍——同乡会活动——活动内容详情
drop table if exists `intro_activity_url`;
create table `intro_activity_url`
(
    `id`      bigint     not null comment '对应轮播图id',
    `url` varchar(100) not null comment '链接',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='同乡会介绍——同乡会活动——活动内容链接';

-- 同乡会介绍——同乡会活动——活动内容文件
drop table if exists `intro_activity_content_file`;
create table `intro_activity_content_file`
(
    `id`       bigint auto_increment not null comment 'id',
    `slide_id` bigint                not null comment '对应轮播图id',
    `url`      varchar(100) comment '地址',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='同乡会介绍——同乡会活动——活动内容详情';

-- 学术交流——研讨会部分封面信息
drop table if exists `academic_seminar`;
create table `academic_seminar`
(
    `id`    bigint auto_increment not null comment 'id',
    `date`  varchar(100) comment '时间',
    `image` varchar(100) comment '图片',
    `text`  varchar(500) comment '文案',
    `category`   char(8) not null comment '分类',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='学术交流——研讨会部分封面信息';
ALTER TABLE academic_seminar ADD COLUMN form VARCHAR(15);

-- 学术交流——研讨会——研讨会详情
drop table if exists `academic_seminar_content`;
create table `academic_seminar_content`
(
    `id`      bigint     not null comment '对应研讨会id',
    `content` mediumtext not null comment '活动内容',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='学术交流——研讨会——研讨会详情内容';
ALTER TABLE academic_seminar_content drop COLUMN view;
ALTER TABLE academic_seminar_content ADD COLUMN view BIGINT default 0;

-- 学术交流——研讨会——研讨会链接
drop table if exists `academic_seminar_url`;
create table `academic_seminar_url`
(
    `id`      bigint     not null comment '对应研讨会id',
    `url` varchar(100) not null comment '链接',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='学术交流——研讨会——研讨会链接';

-- 学术交流——研讨会——研讨会详情内容文件
drop table if exists `academic_seminar_content_file`;
create table `academic_seminar_content_file`
(
    `id`       bigint auto_increment not null comment 'id',
    `slide_id` bigint                not null comment '对应研讨会id',
    `url`      varchar(100) comment '地址',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='学术交流——研讨会——研讨会详情内容文件';


-- 学术交流——留学申请部分封面信息
drop table if exists `academic_study_abroad`;
create table `academic_study_abroad`
(
    `id`    bigint auto_increment not null comment 'id',
    `image` varchar(100) comment '图片',
    `text`  varchar(500) comment '文案',
    `category`   char(8) not null comment '分类',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='学术交流——留学申请部分封面信息';
ALTER TABLE academic_study_abroad ADD COLUMN form VARCHAR(15);

-- 学术交流——留学申请——留学申请详情
drop table if exists `academic_study_abroad_content`;
create table `academic_study_abroad_content`
(
    `id`      bigint     not null comment '对应留学申请板块id',
    `content` mediumtext not null comment '内容',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='学术交流——留学申请——留学申请详情';
ALTER TABLE academic_study_abroad_content drop COLUMN view;
ALTER TABLE academic_study_abroad_content ADD COLUMN view BIGINT default 0;

-- 学术交流——留学申请——留学申请链接
drop table if exists `academic_study_abroad_url`;
create table `academic_study_abroad_url`
(
    `id`      bigint     not null comment '对应留学申请板块id',
    `url` varchar(100) not null comment '链接',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='学术交流——留学申请——留学申请链接';

-- 学术交流——留学申请——留学申请详情内容文件
drop table if exists `academic_study_abroad_content_file`;
create table `academic_study_abroad_content_file`
(
    `id`       bigint auto_increment not null comment 'id',
    `slide_id` bigint                not null comment '对应板块id',
    `url`      varchar(100) comment '地址',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='学术交流——留学申请——留学申请详情内容文件';


-- 产业合作——国内产业合作
drop table if exists `collaboration_China`;
create table `collaboration_China`
(
    `id`    bigint auto_increment not null comment 'id',
    `date`  varchar(100) comment '时间',
    `image` varchar(100) comment '图片',
    `text`  varchar(500) comment '文案',
    `category`   char(8) not null comment '分类',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='产业合作——国内产业合作';
ALTER TABLE collaboration_China ADD COLUMN form VARCHAR(15);
ALTER TABLE collaboration_China ADD COLUMN name VARCHAR(100);

-- 产业合作——国内产业合作——合作详情
drop table if exists `collaboration_China_content`;
create table `collaboration_China_content`
(
    `id`      bigint     not null comment '对应国内产业合作板块id',
    `content` mediumtext not null comment '内容',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='产业合作——国内产业合作——合作详情';
ALTER TABLE collaboration_China_content drop COLUMN view;
ALTER TABLE collaboration_China_content ADD COLUMN view BIGINT default 0;

-- 产业合作——国内产业合作——合作链接
drop table if exists `collaboration_China_url`;
create table `collaboration_China_url`
(
    `id`      bigint     not null comment '对应国内产业合作板块id',
    `url` varchar(100) not null comment '链接',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='产业合作——国内产业合作——合作详情链接';

-- 产业合作——国内产业合作——合作详情内容文件
drop table if exists `collaboration_China_content_file`;
create table `collaboration_China_content_file`
(
    `id`       bigint auto_increment not null comment 'id',
    `slide_id` bigint                not null comment '对应板块id',
    `url`      varchar(100) comment '地址',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='产业合作——国内产业合作——合作详情内容文件';


-- 产业合作——英国及爱尔兰企业合作
drop table if exists `collaboration_UK_Ireland`;
create table `collaboration_UK_Ireland`
(
    `id`    bigint auto_increment not null comment 'id',
    `date`  varchar(100) comment '时间',
    `image` varchar(100) comment '图片',
    `text`  varchar(500) comment '文案',
    `category`   char(8) not null comment '分类',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='产业合作——英国及爱尔兰企业合作';
ALTER TABLE collaboration_UK_Ireland ADD COLUMN form VARCHAR(15);
ALTER TABLE collaboration_UK_Ireland ADD COLUMN name VARCHAR(100);

-- 产业合作——英国及爱尔兰企业合作——合作详情
drop table if exists `collaboration_UK_Ireland_content`;
create table `collaboration_UK_Ireland_content`
(
    `id`      bigint     not null comment '对应产业合作板块id',
    `content` mediumtext not null comment '内容',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='产业合作——英国及爱尔兰企业合作——合作详情';
ALTER TABLE collaboration_UK_Ireland_content drop COLUMN view;
ALTER TABLE collaboration_UK_Ireland_content ADD COLUMN view BIGINT default 0;

-- 产业合作——英国及爱尔兰企业合作——合作链接
drop table if exists `collaboration_UK_Ireland_url`;
create table `collaboration_UK_Ireland_url`
(
    `id`      bigint     not null comment '对应产业合作板块id',
    `url` varchar(100) not null comment '链接',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='产业合作——英国及爱尔兰企业合作——合作详情链接';

-- 产业合作——英国及爱尔兰企业合作——合作详情文件
drop table if exists `collaboration_UK_Ireland_content_file`;
create table `collaboration_UK_Ireland_content_file`
(
    `id`       bigint auto_increment not null comment 'id',
    `slide_id` bigint                not null comment '对应板块id',
    `url`      varchar(100) comment '地址',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='产业合作——英国及爱尔兰企业合作——合作详情文件';

-- 产业合作——中英、中爱企业合作
drop table if exists `collaboration_CUI`;
create table `collaboration_CUI`
(
    `id`    bigint auto_increment not null comment 'id',
    `date`  varchar(100) comment '时间',
    `image` varchar(100) comment '图片',
    `text`  varchar(500) comment '文案',
    `category`   char(8) not null comment '分类',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='产业合作——中英、中爱企业合作';
ALTER TABLE collaboration_CUI ADD COLUMN form VARCHAR(15);
ALTER TABLE collaboration_CUI ADD COLUMN name VARCHAR(100);

-- 产业合作——中英、中爱企业合作——合作详情
drop table if exists `collaboration_CUI_content`;
create table `collaboration_CUI_content`
(
    `id`      bigint     not null comment '对应产业合作板块id',
    `content` mediumtext not null comment '内容',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='产业合作——中英、中爱企业合作——合作详情';
ALTER TABLE collaboration_CUI_content drop COLUMN view;
ALTER TABLE collaboration_CUI_content ADD COLUMN view BIGINT default 0;
-- 产业合作——中英、中爱企业合作——合作链接
drop table if exists `collaboration_CUI_url`;
create table `collaboration_CUI_url`
(
    `id`      bigint     not null comment '对应产业合作板块id',
    `url` varchar(100) not null comment '链接',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='产业合作——中英、中爱企业合作——合作详情链接';

-- 产业合作——中英、中爱企业合作——合作详情文件
drop table if exists `collaboration_CUI_content_file`;
create table `collaboration_CUI_content_file`
(
    `id`       bigint auto_increment not null comment 'id',
    `slide_id` bigint                not null comment '对应板块id',
    `url`      varchar(100) comment '地址',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='产业合作——中英、中爱企业合作——合作详情文件';

-- 首页——最新通告轮播图
drop table if exists `home_news`;
create table `home_news`
(
    `id`    bigint auto_increment not null comment 'id',
    `date`  varchar(100) comment '时间',
    `image` varchar(100) comment '图片',
    `title`  varchar(500) comment '标题',
    `form`  varchar(15) comment '形式',
    `category`   char(8) not null comment '分类',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='首页——最新通告轮播图';

-- 首页——最新通告轮播图详情
drop table if exists `home_news_content`;
create table `home_news_content`
(
    `id`      bigint     not null comment '对应通告id',
    `content` mediumtext not null comment '内容',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='首页——最新通告轮播图详情';
ALTER TABLE home_news_content drop COLUMN view;
ALTER TABLE home_news_content ADD COLUMN view BIGINT default 0;
-- 首页——最新通告轮播图链接
drop table if exists `home_news_url`;
create table `home_news_url`
(
    `id`      bigint     not null comment '对应通告id',
    `url` varchar(100) not null comment '链接',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='首页——最新通告轮播图链接';

-- 首页——最新通告轮播图详情文件
drop table if exists `home_news_file`;
create table `home_news_file`
(
    `id`       bigint auto_increment not null comment 'id',
    `slide_id` bigint                not null comment '对应板块id',
    `url`      varchar(100) comment '地址',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='首页——最新通告轮播图文件';

-- 首页——广告
drop table if exists `home_ad`;
create table `home_ad`
(
    `id`    bigint auto_increment not null comment 'id',
    `date`  varchar(100) comment '时间',
    `image` varchar(100) comment '图片',
    `title`  varchar(500) comment '标题',
    `text`  varchar(500) comment '文案',
    `form`  varchar(15) comment '形式',
    `category`   char(8) not null comment '分类',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='首页——广告轮播图';

-- 首页——广告轮播图详情
drop table if exists `home_ad_content`;
create table `home_ad_content`
(
    `id`      bigint     not null comment '对应通告id',
    `content` mediumtext not null comment '内容',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='首页——广告轮播图详情';
ALTER TABLE home_ad_content drop COLUMN view;
ALTER TABLE home_ad_content ADD COLUMN view BIGINT default 0;
-- 首页——广告轮播图链接
drop table if exists `home_ad_url`;
create table `home_ad_url`
(
    `id`      bigint     not null comment '对应通告id',
    `url` varchar(100) not null comment '链接',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='首页——广告轮播图链接';

-- 首页——广告轮播图详情文件
drop table if exists `home_ad_file`;
create table `home_ad_file`
(
    `id`       bigint auto_increment not null comment 'id',
    `slide_id` bigint                not null comment '对应板块id',
    `url`      varchar(100) comment '地址',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='首页——广告轮播图文件';

-- 首页——合作机构
drop table if exists `home_partners`;
create table `home_partners`
(
    `id`    bigint auto_increment not null comment 'id',
    `image` varchar(100) comment '图片',
    `name`  varchar(20) comment '机构名称',
    `url`  varchar(200) comment '官网链接',
    `category`   char(8) not null comment '分类',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='首页——合作机构';

ALTER TABLE home_partners ADD COLUMN type VARCHAR(15);
ALTER TABLE home_partners MODIFY COLUMN name varchar(50);

-- 文件
drop table if exists `file`;
create table `file`
(
    `id`         bigint auto_increment not null comment 'id',
    `path`       varchar(100)          not null comment '相对路径',
    `name`       varchar(100) comment '文件名',
    `suffix`     varchar(10) comment '后缀',
    `size`       int comment '大小|字节B',
    `category`   char(8) comment '分类',
    `created_at` datetime(3) comment '创建时间',
    `updated_at` datetime(3) comment '修改时间',
    primary key (`id`),
    unique key `path_unique` (`path`)
) engine = innodb
  default charset = utf8mb4 comment ='文件';

-- 同乡会介绍--招新
drop table if exists `intro_enroll`;
create table `intro_enroll`
(
    `id` char(8) not null comment 'id',
    `phone`   varchar(50)  not null comment '联系电话',
    `email`   varchar(50)  not null comment '邮箱',
    `address` varchar(100) not null comment '地址',
    `hint`    varchar(100) not null comment '信息',
        primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='同乡会介绍--招新';

insert into `intro_enroll` (id,phone, email, address, hint)
values ('00000001','8888-88888888', 'ukhainan01@163.com',
        '71-75 Shelton Street, Covent Garden, Shelton Street, London, England, WC2H 9JQ',
        '请发送您的个人简历发送到指定邮箱，我们将尽快给您答复');

-- 分类
drop table if exists `category`;
create table `category` (
                            `id` char(8) not null default '' comment 'id',
                            `parent` char(8) not null default '' comment '父id',
                            `name` varchar(50) not null comment '名称',
                            `sort` int comment '顺序',
                            primary key (`id`)
) engine=innodb default charset=utf8mb4 comment='分类';

insert into `category` (id, parent, name, sort) values ('00000100', '00000000', '首页', 100);
insert into `category` (id, parent, name, sort) values ('00000101', '00000100', '通告', 101);
insert into `category` (id, parent, name, sort) values ('00000102', '00000100', '广告', 102);
insert into `category` (id, parent, name, sort) values ('00000103', '00000100', '合作机构', 103);

insert into `category` (id, parent, name, sort) values ('00000200', '00000000', '自贸港专栏', 200);
insert into `category` (id, parent, name, sort) values ('00000201', '00000200', '政策福利', 201);
insert into `category` (id, parent, name, sort) values ('00000202', '00000200', '招商引资', 202);
insert into `category` (id, parent, name, sort) values ('00000203', '00000200', '项目合作', 203);
insert into `category` (id, parent, name, sort) values ('00000204', '00000200', '宣传推广', 204);

insert into `category` (id, parent, name, sort) values ('00000300', '00000000', '产业合作', 300);
insert into `category` (id, parent, name, sort) values ('00000301', '00000300', '国内企业合作', 301);
insert into `category` (id, parent, name, sort) values ('00000302', '00000300', '英国及爱尔兰企业合作', 302);
insert into `category` (id, parent, name, sort) values ('00000303', '00000300', '中英、中爱企业合作', 303);

insert into `category` (id, parent, name, sort) values ('00000400', '00000000', '学术交流', 400);
insert into `category` (id, parent, name, sort) values ('00000401', '00000400', '学术论坛', 401);
insert into `category` (id, parent, name, sort) values ('00000402', '00000400', '研讨会', 402);
insert into `category` (id, parent, name, sort) values ('00000403', '00000400', '学术报告', 403);
insert into `category` (id, parent, name, sort) values ('00000404', '00000400', '留学申请', 404);

insert into `category` (id, parent, name, sort) values ('00000500', '00000000', '同乡会介绍', 500);
insert into `category` (id, parent, name, sort) values ('00000501', '00000500', '同乡会活动', 501);
insert into `category` (id, parent, name, sort) values ('00000502', '00000500', '简介', 502);
insert into `category` (id, parent, name, sort) values ('00000503', '00000500', '理事会', 503);
insert into `category` (id, parent, name, sort) values ('00000504', '00000500', '招新', 504);

-- 首页访问量
drop table if exists `view`;
create table `view` (
                        `id` char(8) not null default '0' comment 'id',
                        `view` BIGINT not null default 1 comment '访问量',
                        primary key (`id`)
) engine=innodb default charset=utf8mb4 comment='首页访问量';