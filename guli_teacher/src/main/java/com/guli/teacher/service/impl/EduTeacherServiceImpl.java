package com.guli.teacher.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.teacher.entity.EduTeacher;
import com.guli.teacher.entity.query.TeacherQuery;
import com.guli.teacher.mapper.EduTeacherMapper;
import com.guli.teacher.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-06-02
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    @Override
    public void pageQuery(Page<EduTeacher> pageParam, TeacherQuery teacherQuery) {

        QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper<>();

        if (teacherQuery == null) {
            baseMapper.selectPage(pageParam, queryWrapper);
            return;
        }

        //获取对象的属性
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        //String level = teacherQuery.getLevel().toString();  报空指针异常
        String gmtCreate = teacherQuery.getGmtCreate();
        String gmtModified = teacherQuery.getGmtModified();


        //判断对象属性是否存在
        if (!StringUtils.isEmpty(name)) {
            //如果存在加入条件
            queryWrapper.like("name", name);
        }

        if (level != null) {
            queryWrapper.eq("level", level);
        }

        if (!StringUtils.isEmpty((CharSequence) gmtCreate)) {
            queryWrapper.ge("gmt_create", gmtCreate);
        }

        if (!StringUtils.isEmpty((CharSequence) gmtModified)) {
            queryWrapper.le("gmt_create", gmtModified);
        }
        baseMapper.selectPage(pageParam, queryWrapper);
    }
}
