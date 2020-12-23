package com.simple.qa.mapper;

import com.simple.qa.po.Answers;
import com.simple.qa.po.AnswersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnswersMapper {
    int countByExample(AnswersExample example);

    int deleteByExample(AnswersExample example);

    int deleteByPrimaryKey(Integer aId);

    int insert(Answers record);

    int insertSelective(Answers record);

    List<Answers> selectByExample(AnswersExample example);

    Answers selectByPrimaryKey(Integer aId);

    int updateByExampleSelective(@Param("record") Answers record, @Param("example") AnswersExample example);

    int updateByExample(@Param("record") Answers record, @Param("example") AnswersExample example);

    int updateByPrimaryKeySelective(Answers record);

    int updateByPrimaryKey(Answers record);
}