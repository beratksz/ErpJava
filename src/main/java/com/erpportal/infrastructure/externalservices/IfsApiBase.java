package com.erpportal.infrastructure.externalservices;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.concurrent.CompletableFuture;

public abstract class IfsApiBase {
    
    protected final RestTemplate restTemplate;
    protected final ObjectMapper objectMapper;
    protected final String baseUrl;
    protected final String username;
    protected final String password;
    protected final HttpHeaders headers;

    protected IfsApiBase(RestTemplate restTemplate, ObjectMapper objectMapper,
                        @Value("${ifs.api.base-url}") String baseUrl,
                        @Value("${ifs.api.username}") String username,
                        @Value("${ifs.api.password}") String password) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.baseUrl = baseUrl;
        this.username = username;
        this.password = password;
        this.headers = createAuthHeaders();
    }

    private HttpHeaders createAuthHeaders() {
        HttpHeaders headers = new HttpHeaders();
        String auth = username + ":" + password;
        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
        String authHeader = "Basic " + new String(encodedAuth);
        headers.set("Authorization", authHeader);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    protected <T> CompletableFuture<T> getAsync(String endpoint, Class<T> responseType) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                String url = baseUrl + "/" + endpoint;
                HttpEntity<?> entity = new HttpEntity<>(headers);
                ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.GET, entity, responseType);
                return response.getBody();
            } catch (HttpClientErrorException ex) {
                throw new IfsApiException("Error calling IFS API: " + ex.getMessage(), ex);
            } catch (Exception ex) {
                throw new IfsApiException("Error deserializing IFS API response: " + ex.getMessage(), ex);
            }
        });
    }

    protected <T> CompletableFuture<T> postAsync(String endpoint, Object data, Class<T> responseType) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                String url = baseUrl + "/" + endpoint;
                HttpEntity<Object> entity = new HttpEntity<>(data, headers);
                ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.POST, entity, responseType);
                return response.getBody();
            } catch (HttpClientErrorException ex) {
                throw new IfsApiException("Error calling IFS API: " + ex.getMessage(), ex);
            } catch (Exception ex) {
                throw new IfsApiException("Error deserializing IFS API response: " + ex.getMessage(), ex);
            }
        });
    }

    protected <T> CompletableFuture<T> patchAsync(String endpoint, Object data, String etag, Class<T> responseType) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                String url = baseUrl + "/" + endpoint;
                HttpHeaders patchHeaders = new HttpHeaders();
                patchHeaders.putAll(headers);
                
                if (etag == null || etag.equals("*")) {
                    patchHeaders.set("If-Match", "*");
                } else {
                    patchHeaders.set("If-Match", etag);
                }
                patchHeaders.set("Prefer", "return=minimal");

                HttpEntity<Object> entity = new HttpEntity<>(data, patchHeaders);
                ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.PATCH, entity, responseType);
                return response.getBody();
            } catch (HttpClientErrorException ex) {
                throw new IfsApiException("Error calling IFS API: " + ex.getMessage(), ex);
            } catch (Exception ex) {
                throw new IfsApiException("Error deserializing IFS API response: " + ex.getMessage(), ex);
            }
        });
    }

    public static class IfsApiException extends RuntimeException {
        public IfsApiException(String message) {
            super(message);
        }

        public IfsApiException(String message, Throwable cause) {
            super(message, cause);
        }
    }
} 