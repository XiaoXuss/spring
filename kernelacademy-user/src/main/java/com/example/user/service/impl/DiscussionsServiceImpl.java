package com.example.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.entity.Discussions;
import com.example.user.mapper.DiscussionsMapper;
import com.example.user.service.IDiscussionsService;
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
public class DiscussionsServiceImpl extends ServiceImpl<DiscussionsMapper, Discussions> implements IDiscussionsService {

}
