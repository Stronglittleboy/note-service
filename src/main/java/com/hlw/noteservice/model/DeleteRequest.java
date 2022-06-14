package com.hlw.noteservice.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class DeleteRequest implements Serializable {
    private Long id;
}
