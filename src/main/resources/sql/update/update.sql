alter table sys_users add  type int COMMENT  '1老师 2学生 3管理员';
alter table homework_content add content_readed int comment '是否已阅'