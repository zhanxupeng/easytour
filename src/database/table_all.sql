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
    id varchar2(32) not null,
    title varchar2(32) not null,
    picture varchar2(1024) not null,
    creator         varchar2(32) not null,
    create_date     timestamp(6) not null,
    updator         varchar2(32) not null,
    update_date     timestamp(6) not null,
    version         number(10) default 1 not null,
    remark          varchar2(256));

  comment on table common_sense
  is '小常识表';
comment on column common_sense.id
  is '主键';
comment on column common_sense.title
  is '标题';
comment on column common_sense.picture
  is '图片';
comment on column common_sense.creator
  is '创建人';
comment on column common_sense.create_date
  is '创建时间';
comment on column common_sense.updator
  is '更新人';
comment on column common_sense.update_date
  is '更新时间';
comment on column common_sense.version
  is '版本号';
comment on column common_sense.remark
  is '备注';
alter table common_sense
  add primary key (id);

/**
用户表，保存用户信息，user_name是用户名（也就是登录的账号），password登录密码,nick_name昵称，
sex性别，head_picture头像，gold_coin金币(APP提供一些方式可以获取金币，金币可以用于兑换优惠卷等)
 */

create table customer(
    id varchar2(32) not null,
    user_name varchar2(16) not null,
    password varchar2(64) not null,
    nick_name varchar2(256) not null,
    sex char(1) not null,
    head_picture varchar2(255),
    gold_coin number(8) not null,
    creator         varchar2(32) not null,
    create_date     timestamp(6) not null,
    updator         varchar2(32) not null,
    update_date     timestamp(6) not null,
    version         number(10) default 1 not null,
    remark          varchar2(256));

  comment on table customer
  is '用户表';
comment on column customer.id
  is '主键';
comment on column customer.user_name
  is '账号';
comment on column customer.password
  is '密码';
comment on column customer.nick_name
  is '昵称';
comment on column customer.sex
  is '性别 0未知 1男 2女';
comment on column customer.head_picture
  is '头像';
comment on column customer.gold_coin
  is '金币';
comment on column customer.creator
  is '创建人';
comment on column customer.create_date
  is '创建时间';
comment on column customer.updator
  is '更新人';
comment on column customer.update_date
  is '更新时间';
comment on column customer.version
  is '版本号';
comment on column customer.remark
  is '备注';
alter table customer
  add primary key (id);

  /**
   该表设计是提供一个每日获取金币的方式，也可以通过回答问题，增加游客出行知识度
  每日一题题目表（都是选择题），question是问题，abcd四个答案，answer是正确答案的选项
   */

create table day_question(
    id varchar2(32) not null,
    question varchar2(256) not null,
    answera varchar2(256) not null,
    answerb varchar2(256) not null,
    answerc varchar2(256) not null,
    answerd varchar2(256) not null,
    answer char(1) not null
    );

comment on table day_question
  is '每日一题题目表';
comment on column day_question.id
  is '主键';
comment on column day_question.question
  is '问题';
comment on column day_question.answera
  is '答案A';
comment on column day_question.answerb
  is '答案B';
comment on column day_question.answerc
  is '答案C';
comment on column day_question.answerd
  is '答案D';
comment on column day_question.answer
  is '正确答案';
alter table day_question
  add primary key (id);

/**
字典表，主要保存一些键值对数据，比如城市和城市代码对应
type是字典类型（比如城市） key键值(比如城市代码),label键描述(比如城市名)
 */
create table dictionary(
    id varchar2(32) not null,
    type varchar2(64) not null,
    key varchar2(64) not null,
    label varchar2(256) not null,
    creator         varchar2(32) not null,
    create_date     timestamp(6) not null,
    updator         varchar2(32) not null,
    update_date     timestamp(6) not null,
    version         number(10) default 1 not null,
    remark          varchar2(256));

comment on table dictionary
  is '字典表';
comment on column dictionary.id
  is '主键';
comment on column dictionary.type
  is '类型';
comment on column dictionary.key
  is '值';
comment on column dictionary.label
  is '说明';
comment on column dictionary.creator
  is '创建人';
comment on column dictionary.create_date
  is '创建时间';
comment on column dictionary.updator
  is '更新人';
comment on column dictionary.update_date
  is '更新时间';
comment on column dictionary.version
  is '版本号';
comment on column dictionary.remark
  is '备注';
alter table dictionary
  add primary key (id);

/**
风景表，用于保存景点的信息，具体字段见comment的描述,pictures是景色的照片，多张照片用逗号隔开
 */

create table scenery(
    id varchar2(32) not null,
    city_code varchar2(8) not null,
    name varchar2(32) not null,
    pictures varchar2(1024) not null,
    special varchar2(1024) not null,
    brief varchar2(255) not null,
    guide varchar2(1024) not null,
    adult_ticket number(8,2),
    student_ticket number(8,2),
    position varchar2(64) not null,
    advise_duration number(4,0) not null,
    creator         varchar2(32) not null,
    create_date     timestamp(6) not null,
    updator         varchar2(32) not null,
    update_date     timestamp(6) not null,
    version         number(10) default 1 not null,
    remark          varchar2(256));

  comment on table scenery
  is '景点表';
comment on column scenery.id
  is '主键';
comment on column scenery.city_code
  is '城市代码';
comment on column scenery.name
  is '景点名字';
comment on column scenery.pictures
  is '景点照片';
comment on column scenery.special
  is '景点特色';
comment on column scenery.brief
  is '景点简介';
comment on column scenery.guide
  is '游玩指南';
comment on column scenery.adult_ticket
  is '成人票';
comment on column scenery.student_ticket
  is '学生票';
comment on column scenery.position
  is '位置';
comment on column scenery.adviseDuration
  is '推荐时间';
comment on column scenery.creator
  is '创建人';
comment on column scenery.create_date
  is '创建时间';
comment on column scenery.updator
  is '更新人';
comment on column scenery.update_date
  is '更新时间';
comment on column scenery.version
  is '版本号';
comment on column scenery.remark
  is '备注';
alter table scenery
  add primary key (id);

/**
下面三张表都是保存了景色类别评分、偏好评分，天气评分，不全部做介绍，用景色类别评分表做介绍
 */
 /**
 景色类别表,scenery_id是景色id，对应唯一一个景点，其他字段都是该景点对应该类型的评分，比如nature，就是自然，保存的是自然的评分，
 比如千岛湖自然风景很好，可以打5分，但是不够有历史，所以history打1分,主要是作推荐用
  */

create table scenery_category_score(
    id varchar2(32) not null,
    scenery_id varchar2(32) not null,
    nature number(2) not null,
    history number(2) not null,
    former_residence number(2) not null,
    park number(2) not null,
    architecture number(2) not null,
    special_block number(2) not null,
    movie_city number(2) not null,
    religion number(2) not null,
    social_custom number(2) not null,
    creator         varchar2(32) not null,
    create_date     timestamp(6) not null,
    updator         varchar2(32) not null,
    update_date     timestamp(6) not null,
    version         number(10) default 1 not null,
    remark          varchar2(256));

  comment on table scenery_category_score
  is '景点类别评分表';
comment on column scenery_category_score.id
  is '主键';
comment on column scenery_category_score.scenery_id
  is '风景表主键'
comment on column scenery_category_score.nature
  is '自然风光';
comment on column scenery_category_score.history
  is '历史遗迹';
comment on column scenery_category_score.former_residence
  is '名人故居';
comment on column scenery_category_score.park
  is '公园花园';
comment on column scenery_category_score.architecture
  is '建筑人文';
comment on column scenery_category_score.special_block
  is '特色街区';
comment on column scenery_category_score.movie_city
  is '影视城';
comment on column scenery_category_score.religion
  is '宗教场所';
comment on column scenery_category_score.social_custom
  is '民风民俗';
comment on column scenery_category_score.creator
  is '创建人';
comment on column scenery_category_score.create_date
  is '创建时间';
comment on column scenery_category_score.updator
  is '更新人';
comment on column scenery_category_score.update_date
  is '更新时间';
comment on column scenery_category_score.version
  is '版本号';
comment on column scenery_category_score.remark
  is '备注';
alter table scenery_category_score
  add primary key (id);

create table scenery_preference_score(
    id varchar2(32) not null,
    scenery_id varchar2(32) not null,
    entertainment  number(2) not null,
    quiet  number(2) not null,
    natural  number(2) not null,
    history  number(2) not null,
    lively  number(2) not null,
    stimulate  number(2) not null,
    concealment  number(2) not null,
    creator         varchar2(32) not null,
    create_date     timestamp(6) not null,
    updator         varchar2(32) not null,
    update_date     timestamp(6) not null,
    version         number(10) default 1 not null,
    remark          varchar2(256));

  comment on table scenery_preference_score
  is '景点偏好评分表';
comment on column scenery_preference_score.id
  is '主键';
comment on column scenery_preference_score.scenery_id
  is '风景表主键'
comment on column scenery_preference_score.entertainment
  is '娱乐';
comment on column scenery_preference_score.quiet
  is '安静';
comment on column scenery_preference_score.natural
  is '自然';
comment on column scenery_preference_score.history
  is '历史';
comment on column scenery_preference_score.lively
  is '热闹';
comment on column scenery_preference_score.stimulate
  is '刺激';
comment on column scenery_preference_score.concealment
  is '隐蔽';
comment on column scenery_preference_score.creator
  is '创建人';
comment on column scenery_preference_score.create_date
  is '创建时间';
comment on column scenery_preference_score.updator
  is '更新人';
comment on column scenery_preference_score.update_date
  is '更新时间';
comment on column scenery_preference_score.version
  is '版本号';
comment on column scenery_preference_score.remark
  is '备注';
alter table scenery_preference_score
  add primary key (id);


create table scenery_weather_score(
    id varchar2(32) not null,
    scenery_id varchar2(32) not null,
    sunny   number(2) not null,
    cloudy   number(2) not null,
    rain   number(2) not null,
    creator         varchar2(32) not null,
    create_date     timestamp(6) not null,
    updator         varchar2(32) not null,
    update_date     timestamp(6) not null,
    version         number(10) default 1 not null,
    remark          varchar2(256));

  comment on table scenery_weather_score
  is '景点天气评分表';
comment on column scenery_weather_score.id
  is '主键';
comment on column scenery_weather_score.scenery_id
  is '风景表主键'
comment on column scenery_weather_score.sunny
  is '晴天';
comment on column scenery_weather_score.cloudy
  is '多云';
comment on column scenery_weather_score.rain
  is '雨天';
comment on column scenery_weather_score.creator
  is '创建人';
comment on column scenery_weather_score.create_date
  is '创建时间';
comment on column scenery_weather_score.updator
  is '更新人';
comment on column scenery_weather_score.update_date
  is '更新时间';
comment on column scenery_weather_score.version
  is '版本号';
comment on column scenery_weather_score.remark
  is '备注';
alter table scenery_weather_score
  add primary key (id);

/**
旅拍表，游客去一些地方玩，比较喜欢记录一下去游玩的体验，对景点有一些主观的评价，对以后
去游玩的游客更加有建议性，主要用户游客之间的分享互动
customer_id是用户id，这个旅拍是谁发的,category是类型，这个旅拍属于什么类型，主要做分类用，方便用户查看，比如影视、滑雪等
其他字段见comment
 */
create table travel_photo(
    id varchar2(32) not null,
    customer_id varchar2(16) not null,
    category varchar2(32) not null,
    pictures varchar2(256) not null,
    city char(1) not null,
    scenery_name varchar2(255),
    title number(8) not null,
    brief varchar2(255) not null,
    content varchar2(255) not null,
    creator         varchar2(32) not null,
    create_date     timestamp(6) not null,
    updator         varchar2(32) not null,
    update_date     timestamp(6) not null,
    version         number(10) default 1 not null,
    remark          varchar2(256));

comment on table travel_photo
  is '旅拍表';
comment on column travel_photo.id
  is '主键';
comment on column travel_photo.customer_id
  is '用户id';
comment on column travel_photo.category
  is '类别';
comment on column travel_photo.pictures
  is '照片';
comment on column travel_photo.city
  is '城市';
comment on column travel_photo.scenery_name
  is '景点名称';
comment on column travel_photo.title
  is '标题';
  comment on column travel_photo.brief
  is '简介';
  comment on column travel_photo.content
  is '内容';
comment on column travel_photo.creator
  is '创建人';
comment on column travel_photo.create_date
  is '创建时间';
comment on column travel_photo.updator
  is '更新人';
comment on column travel_photo.update_date
  is '更新时间';
comment on column travel_photo.version
  is '版本号';
comment on column travel_photo.remark
  is '备注';
alter table travel_photo
  add primary key (id);