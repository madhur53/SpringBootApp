package com.cdac.hiring.service;

import com.cdac.hiring.dto.SolutionRequest;
import com.cdac.hiring.dto.WebhookRequest;
import com.cdac.hiring.dto.WebhookResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WebhookService {

    private static final Logger logger = LoggerFactory.getLogger(WebhookService.class);
    
    private static final String BASE_URL = "https://bfhldevapigw.healthrx.co.in";
    private static final String GENERATE_WEBHOOK_PATH = "/hiring/generateWebhook/JAVA";
    private static final String TEST_WEBHOOK_PATH = "/hiring/testWebhook/JAVA";

    private final WebClient webClient;
    private final SqlQueryService sqlQueryService;

    @Autowired
    public WebhookService(SqlQueryService sqlQueryService) {
        this.sqlQueryService = sqlQueryService;
        this.webClient = WebClient.builder()
                .baseUrl(BASE_URL)
                .build();
    }

    /**
     * Step 1: Generate webhook by sending POST request with user details
     */
    public WebhookResponse generateWebhook(WebhookRequest request) {
        logger.info("Generating webhook for regNo: {}", request.getRegNo());
        
        try {
            WebhookResponse response = webClient.post()
                    .uri(GENERATE_WEBHOOK_PATH)
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(request)
                    .retrieve()
                    .bodyToMono(WebhookResponse.class)
                    .block();
            
            logger.info("Webhook generated successfully");
            logger.info("Webhook URL: {}", response.getWebhook());
            logger.info("Access Token received");
            
            return response;
        } catch (Exception e) {
            logger.error("Error generating webhook: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to generate webhook", e);
        }
    }

    /**
     * Step 2: Submit the SQL solution using the webhook and access token
     */
    public void submitSolution(String accessToken, String sqlQuery) {
        logger.info("Submitting SQL solution");
        logger.info("SQL Query: {}", sqlQuery);
        
        SolutionRequest solutionRequest = new SolutionRequest(sqlQuery);
        
        try {
            String response = webClient.post()
                    .uri(TEST_WEBHOOK_PATH)
                    .header(HttpHeaders.AUTHORIZATION, accessToken)
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(solutionRequest)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            
            logger.info("Solution submitted successfully");
            logger.info("Response: {}", response);
        } catch (Exception e) {
            logger.error("Error submitting solution: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to submit solution", e);
        }
    }

    /**
     * Main workflow: Generate webhook, solve problem, and submit solution
     */
    public void executeChallenge(WebhookRequest request) {
        logger.info("Starting challenge execution for: {}", request.getName());
        
        // Step 1: Generate webhook
        WebhookResponse webhookResponse = generateWebhook(request);
        
        // Step 2: Generate SQL query based on registration number
        String sqlQuery = sqlQueryService.generateSqlQuery(request.getRegNo());
        logger.info("Generated SQL query for regNo {}: {}", request.getRegNo(), sqlQuery);
        
        // Step 3: Submit solution
        submitSolution(webhookResponse.getAccessToken(), sqlQuery);
        
        logger.info("Challenge execution completed successfully");
    }
}
