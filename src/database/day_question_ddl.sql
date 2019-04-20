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