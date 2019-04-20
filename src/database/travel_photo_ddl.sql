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