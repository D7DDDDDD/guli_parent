package com.guli.teacher.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.teacher.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guli.teacher.entity.query.TeacherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-06-02
 */
public interface EduTeacherService extends IService<EduTeacher> {
    /**
     * 根据多个条件查询讲师列表
     * @param pageParm
     * @param teacherQuery
     */
    void pageQuery(Page<EduTeacher>pageParm, TeacherQuery teacherQuery);
}
