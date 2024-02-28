package com.n0rth.amazontask.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SalesByDate {
    private SalesInfo orderedProductSales;
    private SalesInfo orderedProductSalesB2B;
    private int unitsOrdered;
    private int unitsOrderedB2B;
    private int totalOrderItems;
    private int totalOrderItemsB2B;
    private SalesInfo averageSalesPerOrderItem;
    private SalesInfo averageSalesPerOrderItemB2B;
    private double averageUnitsPerOrderItem;
    private double averageUnitsPerOrderItemB2B;
    private SalesInfo averageSellingPrice;
    private SalesInfo averageSellingPriceB2B;
    private int unitsRefunded;
    private double refundRate;
    private int claimsGranted;
    private SalesInfo claimsAmount;
    private SalesInfo shippedProductSales;
    private int unitsShipped;
    private int ordersShipped;

}
