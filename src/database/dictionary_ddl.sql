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