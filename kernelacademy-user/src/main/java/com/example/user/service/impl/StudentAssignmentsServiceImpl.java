package com.example.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.entity.StudentAssignments;
import com.example.user.mapper.StudentAssignmentsMapper;
import com.example.user.service.IStudentAssignmentsService;
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
public class StudentAssignmentsServiceImpl extends ServiceImpl<StudentAssignmentsMapper, StudentAssignments> implements IStudentAssignmentsService {

}
