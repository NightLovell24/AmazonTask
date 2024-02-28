package com.n0rth.amazontask.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "reportSpecification")
public class ReportSpecification {
    @Id
    private String id;
    private String reportType;
    private ReportOptions reportOptions;
    private LocalDate dataStartTime;
    private LocalDate dataEndTime;
    private List<String> marketplaceIds;

    public ReportSpecification(String reportType, ReportOptions reportOptions, LocalDate dataStartTime, LocalDate dataEndTime, List<String> marketplaceIds) {
        this.reportType = reportType;
        this.reportOptions = reportOptions;
        this.dataStartTime = dataStartTime;
        this.dataEndTime = dataEndTime;
        this.marketplaceIds = marketplaceIds;
    }
}
