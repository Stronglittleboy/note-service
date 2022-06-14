package com.hlw.noteservice.controller;
import java.time.LocalDateTime;


import java.util.HashMap;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.json.JSONUtil;
import com.hlw.noteservice.common.BusinessException;
import com.hlw.noteservice.common.VaildUtil;
import com.hlw.noteservice.model.*;
import com.hlw.noteservice.service.NoteExtInfoService;
import com.hlw.noteservice.service.NoteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("note")
public class NoteController {

    @Autowired
    private NoteInfoService noteInfoService;


    @Autowired
    private NoteExtInfoService noteExtInfoService;

    /**
     * 创建文件、文件夹
     *
     * @return
     */
    @PostMapping("creat")
    public Result<Boolean> create(@RequestBody CreateNoteReq request) {
        VaildUtil.vaildBean(request);
        businessVaild(request.getType(),request.getPid());
        if ( 1== request.getType()){
            NoteInfo pNote = noteInfoService.getById(request.getPid());
            if (null == pNote) {
                throw new BusinessException("父菜单不存在");
            }
            if (0 != pNote.getType()) {
                throw new BusinessException("父类必须是文件夹");
            }
        }
        NoteInfo noteInfo = new NoteInfo();
        noteInfo.setName(request.getName());
        noteInfo.setType(request.getType());
        noteInfo.setPid(request.getPid());
        boolean save = noteInfoService.save(noteInfo);
        return Result.success(save);
    }

    /**
     * 创建文件、文件夹
     *
     * @return
     */
    @PostMapping("modify")
    public Result<Boolean> modify(@RequestBody ModifyNoteReq request) {
        VaildUtil.vaildBean(request);
        businessVaild(request.getType(),request.getPid());
        if ( 1== request.getType()){
            NoteInfo pNote = noteInfoService.getById(request.getPid());
            if (null == pNote) {
                throw new BusinessException("父菜单不存在");
            }
            if (0 != pNote.getType()) {
                throw new BusinessException("父类必须是文件夹");
            }
        }
        NoteInfo noteInfo = new NoteInfo();
        noteInfo.setName(request.getName());
        noteInfo.setType(request.getType());
        noteInfo.setPid(request.getPid());
        noteInfo.setId(request.getId());
        boolean save = noteInfoService.updateById(noteInfo);
        return Result.success(save);
    }

    /**
     * 保存文本
     *
     * @return
     */
    @PostMapping("saveNote")
    public Result<Boolean> saveNote(@RequestBody SaveNoteReq request) {
        VaildUtil.vaildBean(request);
        NoteInfo pNote = noteInfoService.getById(request.getId());
        if (null == pNote) {
            throw new BusinessException("文章未创建");
        }
        if (0 == pNote.getType()) {
            throw new BusinessException("这个是文件夹，不是文件");
        }
        NoteExtInfo noteExtInfo = new NoteExtInfo();
        noteExtInfo.setNoteId(request.getId());
        noteExtInfo.setContent(request.getContent());
        boolean save = noteExtInfoService.save(noteExtInfo);
        return Result.success(save);
    }

    /**
     * 保存文本
     *
     * @return
     */
    @GetMapping("getNote")
    public Result<String> getNote(@RequestParam(required = true) Long id) {

        NoteInfo pNote = noteInfoService.getById(id);
        if (null == pNote) {
            throw new BusinessException("文章未创建");
        }
        if (0 == pNote.getType()) {
            throw new BusinessException("这个是文件夹，不是文件");
        }
        NoteExtInfo extInfo = noteExtInfoService.lambdaQuery().eq(NoteExtInfo::getDeleteStatus, true)
                .eq(NoteExtInfo::getNoteId, id).one();
        return Result.success(null == extInfo?"":extInfo.getContent());
    }

    /**
     * 保存文本
     *
     * @return
     */
    @PostMapping("delete")
    public Result<Boolean> delete(@RequestBody DeleteRequest request) {
        VaildUtil.vaildBean(request);
        NoteInfo pNote = noteInfoService.getById(request.getId());
        if (null == pNote) {
            return Result.success(true);
        }
        NoteInfo noteExtInfo = new NoteInfo();
        noteExtInfo.setId(request.getId());
        noteExtInfo.setDeleteStatus(false);
        boolean update = noteInfoService.updateById(noteExtInfo);
        return Result.success(update);
    }

    /**
     * 查询目录
     *
     * @return
     */
    @GetMapping("queryDirectory")
    public Result<List<Tree<Integer>>> queryDirectory() {
        List<NoteInfo> list = noteInfoService.lambdaQuery().eq(NoteInfo::getDeleteStatus, true).list();
        List<TreeNode<Integer>> nodeList = list.stream()
                .map(item -> {
                    TreeNode<Integer> treeNode = new TreeNode<>();
                    treeNode.setId(item.getId().intValue());
                    treeNode.setParentId(item.getPid().intValue());
                    treeNode.setName(item.getName());
//                                treeNode.setWeight();
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("type", item.getType());
                    map.put("hidden", false);
                    treeNode.setExtra(map);
                    treeNode.setName(item.getName());
                    return treeNode;
                }).collect(Collectors.toList());
        List<Tree<Integer>> build = TreeUtil.build(nodeList);
        return Result.success(build);
    }


    private void businessVaild(Integer type,Long pid) {
        if (1 == type && 0 == pid) {
            throw new BusinessException("文章必须创建在文件夹下面");
        }
    }
}
