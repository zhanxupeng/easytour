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