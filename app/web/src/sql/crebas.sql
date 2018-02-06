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
   menu_name            varchar(45) default NULL comment '�˵���',
   request_url          varchar(100) default NULL comment '�����ַ',
   show_order           integer not null default 1 comment '����',
   comments             varchar(200) default NULL comment 'ע��',
   parent_id            integer default NULL comment '�ϼ��˵�ID',
   create_time          datetime default NULL comment '����ʱ��',
   create_user          varchar(45) default NULL comment '������',
   update_time          datetime default NULL comment '����ʱ��',
   update_user          varchar(45) default NULL comment '������',
   menu_enname          varchar(100) default NULL comment '�˵�Ӣ����',
   primary key (id),
   key fk_m_menu_m_menu1_idx (parent_id)
);

alter table m_menu comment '�˵���';

/*==============================================================*/
/* Table: m_role                                                */
/*==============================================================*/
create table m_role
(
   id                   integer not null auto_increment comment 'id',
   role_id              int not null comment '��ɫ����',
   role_name            varchar(45) not null comment '��ɫ��',
   comment              varchar(200) default NULL comment '��ע',
   create_time          datetime default NULL comment '����ʱ��',
   create_user          varchar(45) default NULL comment '������',
   update_time          datetime default NULL comment '����ʱ��',
   update_user          varchar(45) default NULL comment '������',
   primary key (id),
   unique key role_code_UNIQUE (role_id)
)
ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

alter table m_role comment '��ɫ��';

/*==============================================================*/
/* Table: m_user                                                */
/*==============================================================*/
create table m_user
(
   id                   integer not null auto_increment comment 'id',
   user_id              varchar(45) default NULL comment '�û���',
   pwd                  varchar(100) default NULL comment '��½����',
   nickname             varchar(45) default NULL comment '�ǳ�',
   sex                  char(1) default NULL comment '�Ա�1���� 0��Ů��',
   openID               varchar(100) default NULL comment '΢����Ȩ�루openID��',
   unionID              varchar(100) default NULL comment '΢����Ȩ�루unionID��',
   auth_qq              varchar(100) default NULL comment 'QQ��Ȩ��',
   auth_weibo           varchar(100) default NULL comment '΢����Ȩ��',
   mobile               varchar(11) default NULL comment '�ֻ���',
   email                varchar(100) default NULL comment '����',
   delete_flg           char(1) not null default '0' comment 'ɾ����ǣ�0.��Ч 1.ɾ����',
   create_time          datetime default NULL comment '����ʱ��',
   create_user          varchar(45) default NULL comment '������',
   update_time          datetime default NULL comment '����ʱ��',
   update_user          varchar(45) default NULL comment '������',
   primary key (id),
   unique key user_id_UNIQUE (user_id)
)
ENGINE=InnoDB AUTO_INCREMENT=9590 DEFAULT CHARSET=utf8;

alter table m_user comment '�û���';

/*==============================================================*/
/* Table: t_role_menu                                           */
/*==============================================================*/
create table t_role_menu
(
   id                   integer not null auto_increment comment 'id',
   role_id              integer not null comment '��ɫID',
   menu_id              integer not null comment '�˵�ID',
   create_time          datetime default NULL comment '����ʱ��',
   create_user          varchar(45) default NULL comment '������',
   primary key (id),
   key fk_t_role_menu_m_role1_idx (role_id),
   key fk_t_role_menu_m_menu1_idx (menu_id)
)
ENGINE=InnoDB AUTO_INCREMENT=529 DEFAULT CHARSET=utf8;

alter table t_role_menu comment '��ɫ�˵���ϵ��';

/*==============================================================*/
/* Table: t_user_role                                           */
/*==============================================================*/
create table t_user_role
(
   id                   integer not null auto_increment comment 'id',
   user_id              integer not null comment '�û���ID',
   role_id              integer not null comment '��ɫ��ID',
   create_time          datetime default NULL comment '����ʱ��',
   create_user          integer default NULL comment '������',
   primary key (id),
   key fk_t_user_role_m_user1_idx (user_id),
   key fk_t_user_role_m_role1_idx (role_id)
)
ENGINE=InnoDB AUTO_INCREMENT=9561 DEFAULT CHARSET=utf8;

alter table t_user_role comment '�û���ɫ��';

