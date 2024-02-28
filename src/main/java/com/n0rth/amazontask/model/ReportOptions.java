package com.n0rth.amazontask.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReportOptions {
    private String dateGranularity;
    private String asinGranularity;


}
