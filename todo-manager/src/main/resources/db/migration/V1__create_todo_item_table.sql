/*
drop table if exists todo_item;
*/

/*==============================================================*/
/* Table: todo_item                                             */
/*==============================================================*/
create table todo_item
(
   id                   int(11) not null auto_increment,
   name                 varchar(30) not null comment '容器Id',
   status_type          tinyint(1) not null default 0 comment '未完结: 0,完结: 1',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   modify_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (id)
);
