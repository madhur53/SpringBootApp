package com.cdac.hiring.runner;

import com.cdac.hiring.dto.WebhookRequest;
import com.cdac.hiring.service.WebhookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ChallengeRunner implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(ChallengeRunner.class);

    private final WebhookService webhookService;

    @Autowired
    public ChallengeRunner(WebhookService webhookService) {
        this.webhookService = webhookService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("========================================");
        logger.info("Starting CDAC Hiring Challenge");
        logger.info("========================================");


        WebhookRequest request = new WebhookRequest(
                "Madhur Chaudhari",           
                "250850120096",           
                "madhurnchaudhari@gmail.com"    
        );

        try {
            webhookService.executeChallenge(request);
            logger.info("========================================");
            logger.info("Challenge completed successfully!");
            logger.info("========================================");
        } catch (Exception e) {
            logger.error("========================================");
            logger.error("Challenge execution failed: {}", e.getMessage(), e);
            logger.error("========================================");
        }
    }
}
