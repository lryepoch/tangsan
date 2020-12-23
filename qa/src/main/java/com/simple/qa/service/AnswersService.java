package com.simple.qa.service;

import com.simple.qa.mapper.AnswersMapper;
import com.simple.qa.po.Answers;
import com.simple.qa.po.AnswersExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswersService {

    @Autowired
    AnswersMapper answersMapper;

    public int countAnswersByQid(Integer qId) {
        AnswersExample answersExample = new AnswersExample();
        answersExample.or().andAIdEqualTo(qId);
        return answersMapper.countByExample(answersExample);
    }

    public int insert(Answers answers) {
        return answersMapper.insertSelective(answers);
    }

    public List<Answers> getAnswersById(int qId) {
        AnswersExample answersExample = new AnswersExample();
        answersExample.or().andQIdEqualTo(qId);
        return answersMapper.selectByExample(answersExample);
    }
}
