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