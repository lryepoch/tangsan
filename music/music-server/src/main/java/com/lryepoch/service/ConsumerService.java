package com.lryepoch.service;

import com.lryepoch.entity.Consumer;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lryepoch
 * @since 2021-05-24
 */
public interface ConsumerService extends IService<Consumer> {

    Object allUser();

    Object userOfId(int parseInt);

    boolean addUser(Consumer consumer);

    boolean updateUserMsg(Consumer consumer);

    boolean updateUserAvator(Consumer consumer);

    boolean deleteUser(int parseInt);
}
