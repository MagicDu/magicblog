package cn.magicdu.blog.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask {
    private int count = 0;

    //@Scheduled(cron = "*/6 * * * * ?")
    public void process() {
        System.out.println("task running"+(count++));

    }
}
