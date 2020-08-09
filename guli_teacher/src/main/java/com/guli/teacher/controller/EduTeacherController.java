package com.guli.teacher.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.common.result.Result;
import com.guli.common.result.ResultCode;
import com.guli.teacher.entity.EduTeacher;
import com.guli.teacher.entity.query.TeacherQuery;
import com.guli.teacher.exception.EduException;
import com.guli.teacher.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-06-02
 */
@RestController
@RequestMapping("/teacher")
@Api(value = "讲师管理")
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    @ApiOperation(value = "查询所有的讲师列表")
    @GetMapping("list")
    public Result list() {
        try {
            List<EduTeacher> list = eduTeacherService.list(null);
            return Result.ok().data("items", list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
    }

    @ApiOperation(value = "根据id删除讲师")
    @DeleteMapping("{id}")
    public Result removeById(@ApiParam(name = "id", value = "讲师ID", required = true) @PathVariable String id) {
        try {
            return Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
    }

    @ApiOperation(value = "分页讲师列表")
    @GetMapping("/{page}/{limit}")
    public Result pageList(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Integer page,
            @ApiParam(name = "limit", value = "每页显示的记录数", required = true)
            @PathVariable Integer limit
    ) {
        Page<EduTeacher> teacherPage = new Page<>(page, limit);
        eduTeacherService.page(teacherPage, null);
        List<EduTeacher> teachers = teacherPage.getRecords();
        return Result.ok().data("total", teacherPage.getTotal()).data("rows", teacherPage.getRecords());
    }


    @ApiOperation(value = "根据讲师条件分页查询")
    @PostMapping("/{page}/{limit}")
    public Result selectTeacherByPageAndWrapper(
            @ApiParam(name = "page", value = "当前页", required = true)
            @PathVariable Integer page,
            @ApiParam(name = "limit", value = "每页显示的条数", required = true)
            @PathVariable Integer limit,
            @ApiParam(name = "teacherQuery", value = "查询对象", required = false)
            @RequestBody TeacherQuery teacherQuery
    ) {
        try {
            Page<EduTeacher> pageParam = new Page<>(page, limit);

            eduTeacherService.pageQuery(pageParam, teacherQuery);
            List<EduTeacher> records = pageParam.getRecords();
            long total = pageParam.getTotal();
            return Result.ok().data("total", total).data("rows", records);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
    }

    @ApiOperation(value = "新增讲师")
    @PostMapping("save")
    public Result saveTeacher(@ApiParam(name = "teacher", value = "讲师对象", required = true)
                              @RequestBody EduTeacher eduTeacher) {
        try {
            eduTeacherService.save(eduTeacher);
            return Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
    }

    @ApiOperation(value = "根据id查询讲师")
    @GetMapping("{id}")
    public Result selectTeacherById(@PathVariable String id) {
        EduTeacher teacher = eduTeacherService.getById(id);
        if (teacher == null) {
            throw new EduException(ResultCode.EDU_ID_ERROR, "没有这个讲师信息");
        }
        try {
            return Result.ok().data("teacher", teacher);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
    }

    @ApiOperation(value = "修改讲师信息")
    @PutMapping("update")
    public Result update(@RequestBody EduTeacher eduTeacher) {
        try {
            eduTeacherService.updateById(eduTeacher);
            return Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
    }

    @ApiOperation("测试")
    @GetMapping("hello")
    public Result hello(){
        return Result.ok();
    }

}