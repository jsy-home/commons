package com.ethanzyc.commons.business.controller;

import com.ethanzyc.commons.business.domain.ScheduleJob;
import com.ethanzyc.commons.business.service.ScheduleJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ethan
 * @date 2019/9/2 23:34
 */
@RestController
@RequestMapping("/job")
public class ScheduleJobController {
    @Autowired
    private ScheduleJobService jobService;

    @GetMapping("/add")
    public String add() {
        ScheduleJob job = new ScheduleJob();
        job.setJobName("任务02");
        job.setCronExpression("0/2 * * * * ?");
        job.setBeanName("testJob02");
        job.setMethodName("execute");
        jobService.add(job);
        return "新增定时任务成功";
    }

    @GetMapping("/start/{id}")
    public String start(@PathVariable("id") Integer id) {
        jobService.start(id);
        return null;
    }

    @GetMapping("/pause/{id}")
    public String pause(@PathVariable("id") Integer id) {
        jobService.pause(id);
        return "暂停定时任务成功";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        jobService.delete(id);
        return "删除定时任务成功";
    }

    @GetMapping("/startAllJob")
    public String startAllJob() {
        jobService.startAllJob();
        return "启动所有定时任务成功";
    }

    @GetMapping("/pauseAllJob")
    public String pauseAllJob() {
        jobService.pauseAllJob();
        return "暂停所有定时任务成功";
    }
}
