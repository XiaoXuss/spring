package com.example.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.common.entity.Users;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xab
 * @since 2023-04-13
 */
@Mapper
public interface UsersMapper extends BaseMapper<Users> {

}
