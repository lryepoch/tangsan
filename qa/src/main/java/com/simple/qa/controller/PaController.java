package com.simple.qa.controller;

import com.simple.qa.po.Answers;
import com.simple.qa.po.Questions;
import com.simple.qa.service.AnswersService;
import com.simple.qa.service.QuestionsService;
import com.simple.qa.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("qa")
public class PaController {

    @Autowired
    QuestionsService questionsService;

    @Autowired
    AnswersService answersService;

    /**
     * 分页获取问题记录
     * @param page
     * @return
     */
    @GetMapping("showProblem")
    public Map<String, Object> showProblem(Page<Questions> page) {
        Map<String, Object> map = new HashMap<>();

        //总记录数
        int qcount = questionsService.countQuestions();
        page.setTotal(qcount);

        List<Questions> list = questionsService.findQuestionsByPage((page.getCurrentPage() - 1) * page.getPageSize(), page.getPageSize());

        for (Questions q : list) {
            int acount = answersService.countAnswersByQid(q.getqId());
            q.setaNum(acount);
        }
        page.setRecordList(list);

        map.put("list", list);
        return map;
    }

    /**
     * 提问问题
     * @param questions
     * @return
     */
    @PostMapping("insertProblem")
    public Map<String,Object> insertProblem(@RequestBody Questions questions) {
        Map<String,Object> map = new HashMap<>();
        int enabled = questionsService.insert(questions);
        if (enabled==1){
            map.put("code",100);
            map.put("message","提问成功");
        } else {
            map.put("code",200);
            map.put("message","提问失败");
        }
        return map;
    }

    /**
     * 根据问题id查找问题及其答案
     * @param qId
     * @return
     */
    @GetMapping("getQuestionAndAnswersById")
    public Map<String,Object> getQuestionAndAnswersById(int qId){
        Map<String,Object> map = new HashMap<>();
        Questions questions = questionsService.getQuestionById(qId);
        List<Answers> answers = answersService.getAnswersById(qId);
        if (questions!=null || answers !=null) {
            map.put("当前问题答案",answers);
            map.put("当前问题",questions);
        }
        return map;
    }

    /**
     * 回答问题
     * @param answers
     * @return
     */
    @PostMapping("insertAnswer")
    public Map<String,Object> insertAnswer(@RequestBody Answers answers){
        Map<String,Object> map = new HashMap<>();
        int enabled = answersService.insert(answers);
        if (enabled==1){
            map.put("code",100);
            map.put("message","回答成功");
        } else {
            map.put("code",200);
            map.put("message","回答失败");
        }
        return map;
    }



}
