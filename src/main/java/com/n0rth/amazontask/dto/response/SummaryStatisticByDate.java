package com.n0rth.amazontask.dto.response;

import com.n0rth.amazontask.model.SalesInfo;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SummaryStatisticByDate {
    private SalesInfo totalOrderedProductSales;
    private SalesInfo totalShippedProductSales;
    private int totalUnitsOrdered;
    private int totalUnitsOrderedB2B;
    private int totalUnitsShipped;
    private int totalOrdersShipped;
    private int totalBrowserPageViews;
    private int totalMobileAppPageViews;
    private int totalPageViews;
    private int totalBrowserSessions;
    private int totalMobileAppSessions;
    private int totalSessions;



}
