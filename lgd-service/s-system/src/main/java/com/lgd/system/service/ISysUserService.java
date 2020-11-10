package com.lgd.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lgd.system.mapper.SysUserMapper;
import com.lgd.system.pojo.entity.SysUser;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author YYJ
 * @since 2020-11-09
 */
@Service
public class ISysUserService extends ServiceImpl<SysUserMapper, SysUser> implements IService<SysUser> {
}
