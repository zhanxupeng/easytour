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