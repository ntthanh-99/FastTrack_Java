package com.example.WebFlux.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReportPatientResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String testResults;

    private String diagnosticResults;

}
