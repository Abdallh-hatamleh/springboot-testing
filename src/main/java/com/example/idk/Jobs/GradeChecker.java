package com.example.idk.Jobs;

import com.example.idk.Services.StudentService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class GradeChecker {

    private final static Logger logger = LogManager.getLogger(GradeChecker.class);

    @Autowired
    private StudentService studentService;

    @Scheduled(fixedRate = 1800000)
    public void checkGrades()
    {
        studentService.checkAndUpdateGrades();
//        System.out.println("Grades Checked And Updated if low");
        logger.info("Done checking grades");
    }

}
