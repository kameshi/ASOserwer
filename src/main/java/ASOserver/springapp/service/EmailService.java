package ASOserver.springapp.service;

import ASOserver.common.EmailSenderRunnable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class EmailService implements Lifecycle {
    private ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(1);
    @Autowired
    EmailSenderRunnable emailSenderRunnable;

    @PostConstruct
    public void setup() {
        threadPool.scheduleAtFixedRate(emailSenderRunnable, 60, 60, TimeUnit.SECONDS);
    }


    public boolean isRunning() {
        return threadPool.isTerminated();
    }

    public void start() {
    }

    public void stop() {
        threadPool.shutdown();
        while (isRunning()) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
            }
        }
    }
}
