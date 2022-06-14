package com.hlw.noteservice.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 笔记信息表
 * @TableName t_note_info
 */
@TableName(value ="t_note_info")
@Data
public class NoteInfo implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 类型 0文件夹 1文章
     */
    private Integer type;

    /**
     * 名称
     */
    private String name;

    /**
     * 父类ID
     */
    private Long pid;

    /**
     * 是否删除 0删除 1可用
     */
    private Boolean deleteStatus;

    /**
     * 创建时间
     */
    private LocalDateTime createAt;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateAt;

    /**
     * 更新人
     */
    private String updateBy;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
