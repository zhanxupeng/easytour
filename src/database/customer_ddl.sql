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