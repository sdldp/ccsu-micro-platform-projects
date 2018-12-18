package cn.ccsu.score.api;

import cn.ccsu.score.entity.PostStudentScoreInfo;
import cn.ccsu.score.entity.ScoreEvent;
import cn.ccsu.score.entity.StudentData;
import cn.ccsu.score.enums.CodeMessage;
import cn.ccsu.score.entity.Result;
import cn.ccsu.score.service.impl.ScoreServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RefreshScope
public class ScoreController {

    Logger logger = LoggerFactory.getLogger(ScoreController.class);

    @Autowired
    ScoreServiceImpl scoreService;

    //获取全部综测信息
    @GetMapping(value = "/totalScore",produces = "application/json;character=UTF-8")
    public String getStudentTotalScore(@RequestParam String id){
        if (StringUtils.isEmpty(id)){
            return Result.error(CodeMessage.STUDENT_ID_EMPTY).toString();
        }
        StudentData studentData = scoreService.getStudentTotalScoreById(id);
        if (studentData==null){
            return Result.error(CodeMessage.STUDENT_NOT_FOUND).toString();
        }
        return Result.success(studentData).toString();
    }

    //获取综测具体信息
    @GetMapping(value = "scoreDetail",produces = "application/json;character=UTF-8")
    public String getStudentEvents(@RequestParam String id){
        if (StringUtils.isEmpty(id)){
            return Result.error(CodeMessage.STUDENT_ID_EMPTY).toString();
        }
        List<ScoreEvent> scoreEvents = scoreService.getStudentAllEventById(id);
        if (scoreEvents==null){
            return Result.error(CodeMessage.STUDENT_NOT_FOUND).toString();
        }
        return Result.success(scoreEvents).toString();
    }

    @GetMapping(value = "addScore",produces = "application/json;character=UTF-8")
    public String increaseScore(@RequestParam String id, PostStudentScoreInfo scoreInfo){
        //todo
        Boolean success  = scoreService.increaseScoreById("B20160304301",1,"英语四级",new Date());
        return Result.success(success).toString();
    }
}
