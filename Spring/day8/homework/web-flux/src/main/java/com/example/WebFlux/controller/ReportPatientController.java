package com.example.WebFlux.controller;

import com.example.WebFlux.response.ReportPatientResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/analysis-result")
public class ReportPatientController {

    private final WebClient webClient;

    public ReportPatientController(WebClient.Builder webClientBuilder ) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8082").build();
    }

    @GetMapping("/get")
    public Flux<ReportPatientResponse> findAnalysisResultById(@RequestParam String id) {
        return webClient.get()
                .uri("/api/analysis-result/get?id={id}", id)
                .retrieve()
                .bodyToFlux(ReportPatientResponse.class);
    }
}
