/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/11/19 17:22:07                          */
/*==============================================================*/


drop table if exists m_menu;

drop table if exists m_role;

drop table if exists m_user;

drop table if exists t_role_menu;

drop table if exists t_user_role;

/*==============================================================*/
/* Table: m_menu                                                */
/*==============================================================*/
create table m_menu
(
   id                   integer not null auto_increment comment 'id',
   menu_name            varchar(45) default NULL comment '菜单名',
   request_url          varchar(100) default NULL comment '请求地址',
   show_order           integer not null default 1 comment '排序',
   comments             varchar(200) default NULL comment '注释',
   parent_id            integer default NULL comment '上级菜单ID',
   create_time          datetime default NULL comment '创建时间',
   create_user          varchar(45) default NULL comment '创建者',
   update_time          datetime default NULL comment '更新时间',
   update_user          varchar(45) default NULL comment '更新者',
   menu_enname          varchar(100) default NULL comment '菜单英文名',
   primary key (id),
   key fk_m_menu_m_menu1_idx (parent_id)
);

alter table m_menu comment '菜单表';

/*==============================================================*/
/* Table: m_role                                                */
/*==============================================================*/
create table m_role
(
   id                   integer not null auto_increment comment 'id',
   role_id              int not null comment '角色编码',
   role_name            varchar(45) not null comment '角色名',
   comment              varchar(200) default NULL comment '备注',
   create_time          datetime default NULL comment '创建时间',
   create_user          varchar(45) default NULL comment '创建者',
   update_time          datetime default NULL comment '更新时间',
   update_user          varchar(45) default NULL comment '更新者',
   primary key (id),
   unique key role_code_UNIQUE (role_id)
)
ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

alter table m_role comment '角色表';

/*==============================================================*/
/* Table: m_user                                                */
/*==============================================================*/
create table m_user
(
   id                   integer not null auto_increment comment 'id',
   user_id              varchar(45) default NULL comment '用户名',
   pwd                  varchar(100) default NULL comment '登陆密码',
   nickname             varchar(45) default NULL comment '昵称',
   sex                  char(1) default NULL comment '性别（1：男 0：女）',
   openID               varchar(100) default NULL comment '微信授权码（openID）',
   unionID              varchar(100) default NULL comment '微信授权码（unionID）',
   auth_qq              varchar(100) default NULL comment 'QQ授权码',
   auth_weibo           varchar(100) default NULL comment '微博授权码',
   mobile               varchar(11) default NULL comment '手机号',
   email                varchar(100) default NULL comment '邮箱',
   delete_flg           char(1) not null default '0' comment '删除标记（0.有效 1.删除）',
   create_time          datetime default NULL comment '创建时间',
   create_user          varchar(45) default NULL comment '创建者',
   update_time          datetime default NULL comment '更新时间',
   update_user          varchar(45) default NULL comment '更新者',
   primary key (id),
   unique key user_id_UNIQUE (user_id)
)
ENGINE=InnoDB AUTO_INCREMENT=9590 DEFAULT CHARSET=utf8;

alter table m_user comment '用户表';

/*==============================================================*/
/* Table: t_role_menu                                           */
/*==============================================================*/
create table t_role_menu
(
   id                   integer not null auto_increment comment 'id',
   role_id              integer not null comment '角色ID',
   menu_id              integer not null comment '菜单ID',
   create_time          datetime default NULL comment '创建时间',
   create_user          varchar(45) default NULL comment '创建者',
   primary key (id),
   key fk_t_role_menu_m_role1_idx (role_id),
   key fk_t_role_menu_m_menu1_idx (menu_id)
)
ENGINE=InnoDB AUTO_INCREMENT=529 DEFAULT CHARSET=utf8;

alter table t_role_menu comment '角色菜单关系表';

/*==============================================================*/
/* Table: t_user_role                                           */
/*==============================================================*/
create table t_user_role
(
   id                   integer not null auto_increment comment 'id',
   user_id              integer not null comment '用户表ID',
   role_id              integer not null comment '角色表ID',
   create_time          datetime default NULL comment '创建时间',
   create_user          integer default NULL comment '创建者',
   primary key (id),
   key fk_t_user_role_m_user1_idx (user_id),
   key fk_t_user_role_m_role1_idx (role_id)
)
ENGINE=InnoDB AUTO_INCREMENT=9561 DEFAULT CHARSET=utf8;

alter table t_user_role comment '用户角色表';

