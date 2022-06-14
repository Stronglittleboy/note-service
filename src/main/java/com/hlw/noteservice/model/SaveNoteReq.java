package com.hlw.noteservice.model;

import lombok.Data;
import net.sf.oval.constraint.NotNull;

import java.io.Serializable;

@Data
public class SaveNoteReq implements Serializable {
    @NotNull(message = "文章ID不能为空")
    private Long id;
    @NotNull(message = "文章内容不能为空")
    private String content;
}
