package com.lryepoch.service;

import com.lryepoch.entity.Consumer;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lryepoch
 * @since 2021-05-24
 */
public interface ConsumerService extends IService<Consumer> {

    List<Consumer> allUser();

    List<Consumer> userOfId(int parseInt);

    boolean addUser(Consumer consumer);

    boolean updateUserMsg(Consumer consumer);

    boolean updateUserAvator(Consumer consumer);

    boolean deleteUser(int parseInt);

    boolean veritypasswd(String username, String password);

    List<Consumer> loginStatus(String username);
}
