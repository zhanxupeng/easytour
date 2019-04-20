/**
以下所有的表,id是主键,creator是创建人,create_date是创建时间,updator是更新人,update_date是更新时间,version是版本号,remark备注
这些字段都是基础字段,id是唯一标识，其他字段用来记录更改信息
一下表中出现字段是图片的，都是指图片的地址
 */

/**
  小常识表，保存小常识的信息，主要是一些出游需要注意的一些小常识，提供给用户空闲的时候浏览，主要是以
  图片的方式，title是标题，picture是一张长图
 */
 create table common_sense(
    id varchar(32) PRIMARY KEY COMMENT '主键',
    title varchar(32) not null comment '标题',
    picture varchar(1024) not null comment '图片',
    creator varchar(32) not null comment '创建人',
    create_date timestamp not NULL comment '创建时间',
    updator varchar(32) not null comment '更新人',
    update_date timestamp not null comment '更新时间',
    version int default 1 not null comment '版本号',
    remark varchar(256) comment '备注'
 );


/**
用户表，保存用户信息，user_name是用户名（也就是登录的账号），password登录密码,nick_name昵称，
sex性别，head_picture头像，gold_coin金币(APP提供一些方式可以获取金币，金币可以用于兑换优惠卷等)
 */

create table customer(
    id varchar(32) primary key comment '主键',
    user_name varchar(16) not null comment '用户名',
    password varchar(64) not null comment '密码',
    nick_name varchar(256) not null comment '昵称',
    sex char(1) not null comment '性别 0未知 1男 2女',
    head_picture varchar(255) comment '头像',
    gold_coin int not null comment '金币',
    creator varchar(32) not null comment '创建人',
    create_date timestamp not NULL comment '创建时间',
    updator varchar(32) not null comment '更新人',
    update_date timestamp not null comment '更新时间',
    version int default 1 not null comment '版本号',
    remark varchar(256) comment '备注'
);

  /**
   该表设计是提供一个每日获取金币的方式，也可以通过回答问题，增加游客出行知识度
  每日一题题目表（都是选择题），question是问题，abcd四个答案，answer是正确答案的选项
   */

  create table day_question(
    id varchar(32) primary key comment '主键',
    question varchar(256) not null comment '问题',
    answera varchar(256) not null comment '答案A',
    answerb varchar(256) not null comment '答案B',
    answerc varchar(256) not null comment '答案C',
    answerd varchar(256) not null comment '答案D',
    answer char(1) not null comment '正确答案'
);


/**
字典表，主要保存一些键值对数据，比如城市和城市代码对应
type是字典类型（比如城市） key键值(比如城市代码),label键描述(比如城市名)
 */
create table dictionary(
    id varchar(32) primary key comment '主键',
    type varchar(64) not null comment '类型',
    `key` varchar(64) not null comment '值',
    label varchar(256) not null comment '说明',
    creator varchar(32) not null comment '创建人',
    create_date timestamp not NULL comment '创建时间',
    updator varchar(32) not null comment '更新人',
    update_date timestamp not null comment '更新时间',
    version int default 1 not null comment '版本号',
    remark varchar(256) comment '备注'
);
/**
风景表，用于保存景点的信息，具体字段见comment的描述,pictures是景色的照片，多张照片用逗号隔开
 */
create table scenery(
    id varchar(32) primary key comment '主键',
    city_code varchar(8) not null comment '城市代码',
    `name` varchar(32) not null comment '景点名字',
    pictures varchar(2048) not null comment '景点照片',
    special varchar(2048) not null comment '景点特色',
    brief varchar(1024) not null comment '景点简介',
    guide varchar(2048) not null comment '游玩指南',
    adult_ticket DECIMAL(8,2) comment '成人票',
    student_ticket DECIMAL(8,2) comment '学生票',
    position varchar(64) not null comment '位置',
    advise_duration int not null comment '推荐时间',
    creator varchar(32) not null comment '创建人',
    create_date timestamp not NULL comment '创建时间',
    updator varchar(32) not null comment '更新人',
    update_date timestamp not null comment '更新时间',
    version int default 1 not null comment '版本号',
    remark varchar(256) comment '备注'
);

/**
下面三张表都是保存了景色类别评分、偏好评分，天气评分，不全部做介绍，用景色类别评分表做介绍
 */
 /**
 景色类别表,scenery_id是景色id，对应唯一一个景点，其他字段都是该景点对应该类型的评分，比如nature，就是自然，保存的是自然的评分，
 比如千岛湖自然风景很好，可以打5分，但是不够有历史，所以history打1分,主要是作推荐用
  */
create table scenery_category_score(
    id varchar(32) primary key comment '主键',
    scenery_id varchar(32) not null comment '景点id',
    nature int not null comment '自然风光',
    history int not null comment '历史遗迹',
    former_residence int not null comment '名人故居',
    park int not null comment '公园花园',
    architecture int not null comment '建筑人文',
    special_block int not null comment '特色街区',
    movie_city int not null comment '影视城',
    religion int not null comment '宗教场所',
    social_custom int not null comment '民风民俗',
    creator varchar(32) not null comment '创建人',
    create_date timestamp not NULL comment '创建时间',
    updator varchar(32) not null comment '更新人',
    update_date timestamp not null comment '更新时间',
    version int default 1 not null comment '版本号',
    remark varchar(256) comment '备注'
);

create table scenery_preference_score(
    id varchar(32) primary key comment '主键',
    scenery_id varchar(32) not null comment '景点id',
    entertainment  int not null comment '娱乐',
    quiet  int not null comment '安静',
    `natural`  int not null comment '自然',
    history  int not null comment '历史',
    lively  int not null comment '热闹',
    stimulate  int not null comment '刺激',
    concealment  int not null comment '隐蔽',
    creator varchar(32) not null comment '创建人',
    create_date timestamp not NULL comment '创建时间',
    updator varchar(32) not null comment '更新人',
    update_date timestamp not null comment '更新时间',
    version int default 1 not null comment '版本号',
    remark varchar(256) comment '备注'
);

create table scenery_weather_score(
    id varchar(32) primary key comment '主键',
    scenery_id varchar(32) not null comment '景点id',
    sunny   int not null comment '晴天',
    cloudy   int not null comment '多云',
    rain   int not null comment '雨天',
    creator varchar(32) not null comment '创建人',
    create_date timestamp not NULL comment '创建时间',
    updator varchar(32) not null comment '更新人',
    update_date timestamp not null comment '更新时间',
    version int default 1 not null comment '版本号',
    remark varchar(256) comment '备注'
);

/**
旅拍表，游客去一些地方玩，比较喜欢记录一下去游玩的体验，对景点有一些主观的评价，对以后
去游玩的游客更加有建议性，主要用户游客之间的分享互动
customer_id是用户id，这个旅拍是谁发的,category是类型，这个旅拍属于什么类型，主要做分类用，方便用户查看，比如影视、滑雪等
其他字段见comment
 */
 create table travel_photo(
    id varchar(32) primary key comment '主键',
    customer_id varchar(32) not null comment '用户id',
    category varchar(32) not null comment '类别',
    pictures varchar(1024) not null comment '照片',
    city varchar(64) not null comment '城市',
    scenery_name varchar(255) not null comment '景点名称',
    title varchar(64) not null comment '标题',
    brief varchar(256) not null comment '简介',
    content varchar(256) not null comment '内容',
    creator varchar(32) not null comment '创建人',
    create_date timestamp not NULL comment '创建时间',
    updator varchar(32) not null comment '更新人',
    update_date timestamp not null comment '更新时间',
    version int default 1 not null comment '版本号',
    remark varchar(256) comment '备注'
);
