package com.example.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.entity.Examinations;
import com.example.user.mapper.ExaminationsMapper;
import com.example.user.service.IExaminationsService;
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
public class ExaminationsServiceImpl extends ServiceImpl<ExaminationsMapper, Examinations> implements IExaminationsService {

}
