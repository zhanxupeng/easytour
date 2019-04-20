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