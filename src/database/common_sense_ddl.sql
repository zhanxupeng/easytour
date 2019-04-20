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