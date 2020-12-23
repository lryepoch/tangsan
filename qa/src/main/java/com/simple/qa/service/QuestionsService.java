package com.simple.qa.service;

import com.simple.qa.mapper.QuestionsMapper;
import com.simple.qa.po.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsService {

    @Autowired
    QuestionsMapper questionsMapper;

    public int countQuestions() {
        return questionsMapper.countByExample(null);
    }

    public List<Questions> findQuestionsByPage(int currentRecord, int pageSize) {
        return questionsMapper.findQuestionsByPage(currentRecord, pageSize);
    }

    public int insert(Questions questions) {
        return questionsMapper.insertSelective(questions);
    }

    public Questions getQuestionById(int qId) {
        return questionsMapper.selectByPrimaryKey(qId);
    }
}
