package com.hlw.noteservice.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class PageRequest implements Serializable {
    private Integer page;
    private Integer pageSize;
    private String order;

}
