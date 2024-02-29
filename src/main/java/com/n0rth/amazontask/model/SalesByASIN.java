package com.n0rth.amazontask.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SalesByASIN {
    private int unitsOrdered;
    private int unitsOrderedB2B;
    private SalesInfo orderedProductSales;
    private SalesInfo orderedProductSalesB2B;
    private int totalOrderItems;
    private int totalOrderItemsB2B;

}
