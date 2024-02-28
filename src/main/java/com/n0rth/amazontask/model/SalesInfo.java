package com.n0rth.amazontask.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SalesInfo {
    private double amount;
    private String currencyCode;

}
