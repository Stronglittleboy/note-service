package com.hlw.noteservice.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

import java.io.Serializable;
@Data
public class CreateNoteReq implements Serializable {
    @NotNull(message = "名称不能为空")
    @NotBlank(message = "名称不能为空")
    private String name;
    @NotNull(message = "类型不能为空")
    private Integer type;
    @NotNull(message = "父类Id不能为空")
    private Long pid;
}
