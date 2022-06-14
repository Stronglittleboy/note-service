package com.hlw.noteservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hlw.noteservice.model.NoteInfo;
import com.hlw.noteservice.service.NoteInfoService;
import com.hlw.noteservice.mapper.NoteInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【t_note_info(笔记信息表)】的数据库操作Service实现
* @createDate 2022-06-08 16:14:58
*/
@Service
public class NoteInfoServiceImpl extends ServiceImpl<NoteInfoMapper, NoteInfo>
    implements NoteInfoService{

}




