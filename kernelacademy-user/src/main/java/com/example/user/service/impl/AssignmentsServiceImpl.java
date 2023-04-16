package com.example.user.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.entity.Assignments;
import com.example.user.mapper.AssignmentsMapper;
import com.example.user.service.IAssignmentsService;
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
public class AssignmentsServiceImpl extends ServiceImpl<AssignmentsMapper, Assignments> implements IAssignmentsService {

}
