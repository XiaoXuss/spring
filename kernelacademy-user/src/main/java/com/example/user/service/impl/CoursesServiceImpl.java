package com.example.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.entity.Courses;
import com.example.user.mapper.CoursesMapper;
import com.example.user.service.ICoursesService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xab
 * @since 2023-04-13
 */
@Service
public class CoursesServiceImpl extends ServiceImpl<CoursesMapper, Courses> implements ICoursesService {

}
