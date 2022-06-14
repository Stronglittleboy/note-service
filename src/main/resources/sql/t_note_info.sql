DROP TABLE t_note_info;
CREATE TABLE t_note_info
(
    `id`            BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',

    `type`       tinyint(1)          NOT NULL DEFAULT 0 COMMENT '类型 0文件夹 1文章',
    `name`       varchar(64)          NOT NULL DEFAULT '默认文件名' COMMENT '名称',
    `pid`      BIGINT(20)          NOT NULL DEFAULT 0 COMMENT '父类ID',

    `delete_status` TINYINT(1)          NOT NULL DEFAULT '1' COMMENT '是否删除 0删除 1可用',

    `create_at`     DATETIME            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `create_by`     VARCHAR(32)         NOT NULL DEFAULT '' COMMENT '创建人',
    `update_at`     DATETIME            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `update_by`     VARCHAR(32)         NOT NULL DEFAULT '' COMMENT '更新人',
    PRIMARY KEY (`id`)
) COMMENT '笔记信息表';
