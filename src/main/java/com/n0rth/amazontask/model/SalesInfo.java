package com.n0rth.amazontask.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@ToString
public class SalesInfo {
    private double amount;
    private String currencyCode;

    public SalesInfo() {
        currencyCode = "USD";
    }
}
