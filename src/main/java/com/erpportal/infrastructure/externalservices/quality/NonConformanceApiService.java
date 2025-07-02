package com.erpportal.infrastructure.externalservices.quality;

import com.erpportal.application.dto.NcrDto;
import com.erpportal.application.interfaces.INonConformanceApiService;
import com.erpportal.infrastructure.externalservices.IfsApiBase;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class NonConformanceApiService extends IfsApiBase implements INonConformanceApiService {
    
    private static final Logger logger = LoggerFactory.getLogger(NonConformanceApiService.class);
    private static final String SERVICE_ROOT = "NonConformanceHandling.svc";

    public NonConformanceApiService(RestTemplate restTemplate, ObjectMapper objectMapper,
                                  @Value("${ifs.api.base-url}") String baseUrl,
                                  @Value("${ifs.api.username}") String username,
                                  @Value("${ifs.api.password}") String password) {
        super(restTemplate, objectMapper, baseUrl, username, password);
    }

    @Override
    public CompletableFuture<List<NcrDto>> getOpenNcrsAsync(String orderNo, Integer operationNo) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Özel alan isimleri Cf_Is_Emri_No ve Cf_Operation_No
                String filter = String.format("Objstate ne 'Closed' and Cf_Is_Emri_No eq '%s' and Cf_Operation_No eq '%d'", 
                                             orderNo, operationNo);
                String encodedFilter = URLEncoder.encode(filter, StandardCharsets.UTF_8);
                String endpoint = String.format("%s/NonConformanceReports?$filter=%s", SERVICE_ROOT, encodedFilter);
                
                CompletableFuture<ODataResponse> response = getAsync(endpoint, ODataResponse.class);
                ODataResponse data = response.join();
                return data.getValue();
            } catch (Exception ex) {
                String endpoint = String.format("%s/NonConformanceReports", SERVICE_ROOT);
                logger.error("NCR sorgusu başarısız. Endpoint: {}", endpoint, ex);
                return Collections.emptyList();
            }
        });
    }

    @Override
    public CompletableFuture<Boolean> closeNcrAsync(String ncrNo, String disposition, String notes, String closedBy) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                String endpoint = String.format("%s/NonConformanceReports(NcrNo='%s')", SERVICE_ROOT, ncrNo);
                
                Map<String, Object> payload = new HashMap<>();
                payload.put("Objstate", "Closed");
                payload.put("CompletionDate", java.time.Instant.now().toString());
                payload.put("Disposition", disposition);
                
                if (notes != null && !notes.isEmpty()) {
                    payload.put("Notes", notes);
                }
                if (closedBy != null && !closedBy.isEmpty()) {
                    payload.put("ResponsiblePersonId", closedBy);
                }

                CompletableFuture<Object> response = patchAsync(endpoint, payload, "*", Object.class);
                response.join();
                return true;
            } catch (Exception ex) {
                String endpoint = String.format("%s/NonConformanceReports(NcrNo='%s')", SERVICE_ROOT, ncrNo);
                logger.error("NCR kapatma başarısız. Endpoint: {}, NCR: {}", endpoint, ncrNo, ex);
                return false;
            }
        });
    }

    private static class ODataResponse {
        @JsonProperty("value")
        private List<NcrDto> value = Collections.emptyList();

        public List<NcrDto> getValue() {
            return value;
        }

        public void setValue(List<NcrDto> value) {
            this.value = value;
        }
    }
} 