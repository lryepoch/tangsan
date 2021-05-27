package com.lryepoch.service.impl;

import com.lryepoch.entity.Consumer;
import com.lryepoch.dao.ConsumerMapper;
import com.lryepoch.service.ConsumerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lryepoch
 * @since 2021-05-24
 */
@Service
public class ConsumerServiceImpl extends ServiceImpl<ConsumerMapper, Consumer> implements ConsumerService {

    @Autowired
    private ConsumerMapper consumerMapper;

    @Override
    public List<Consumer> allUser() {
        return list();
    }

    @Override
    public List<Consumer> userOfId(int id) {
        return consumerMapper.selectBatchIds(Collections.singleton(id));
    }

    @Override
    public boolean addUser(Consumer consumer) {
        return save(consumer);
    }

    @Override
    public boolean updateUserMsg(Consumer consumer) {
        return updateById(consumer);
    }

    @Override
    public boolean updateUserAvator(Consumer consumer) {
        return updateById(consumer);
    }

    @Override
    public boolean deleteUser(int parseInt) {
        return removeById(parseInt);
    }
}
