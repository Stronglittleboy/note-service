DROP TABLE t_note_ext_info;
CREATE TABLE t_note_ext_info
(
    `id`            BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',

    `note_id`       BIGINT(20)          NOT NULL DEFAULT 0 COMMENT '角色ID',
    `content`       varchar (65535)          NOT NULL DEFAULT 0 COMMENT '文件内容',

    `delete_status` TINYINT(1)          NOT NULL DEFAULT '1' COMMENT '是否删除 0删除 1可用',

    `create_at`     DATETIME            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `create_by`     VARCHAR(32)         NOT NULL DEFAULT '' COMMENT '创建人',
    `update_at`     DATETIME            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `update_by`     VARCHAR(32)         NOT NULL DEFAULT '' COMMENT '更新人',
    PRIMARY KEY (`id`)
) COMMENT '笔记扩展信息表';
