package com.n0rth.amazontask.service.impl;

import com.n0rth.amazontask.dto.response.SummaryStatisticByDate;
import com.n0rth.amazontask.model.SalesAndTrafficByDate;
import com.n0rth.amazontask.model.SalesByDate;
import com.n0rth.amazontask.model.SalesInfo;
import com.n0rth.amazontask.model.TrafficByDate;
import com.n0rth.amazontask.service.SummaryStatisticByDateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SummaryStatisticByDateServiceImpl implements SummaryStatisticByDateService {


    @Override
    public SummaryStatisticByDate getSummaryStatisticByDate(List<SalesAndTrafficByDate> byDateList) {
        SummaryStatisticByDate summaryStatisticByDate = new SummaryStatisticByDate();

        for (SalesAndTrafficByDate salesAndTrafficByDate : byDateList) {
            SalesByDate salesByDate = salesAndTrafficByDate.getSalesByDate();
            TrafficByDate trafficByDate = salesAndTrafficByDate.getTrafficByDate();

            summaryStatisticByDate.setTotalOrderedProductSales(sumSalesInfo(summaryStatisticByDate.getTotalOrderedProductSales(), salesByDate.getOrderedProductSales()));
            summaryStatisticByDate.setTotalShippedProductSales(sumSalesInfo(summaryStatisticByDate.getTotalShippedProductSales(), salesByDate.getShippedProductSales()));
            summaryStatisticByDate.setTotalUnitsOrdered(summaryStatisticByDate.getTotalUnitsOrdered() + salesByDate.getUnitsOrdered());
            summaryStatisticByDate.setTotalUnitsOrderedB2B(summaryStatisticByDate.getTotalUnitsOrderedB2B() + salesByDate.getUnitsOrderedB2B());
            summaryStatisticByDate.setTotalUnitsShipped(summaryStatisticByDate.getTotalUnitsShipped() + salesByDate.getUnitsShipped());
            summaryStatisticByDate.setTotalOrdersShipped(summaryStatisticByDate.getTotalOrdersShipped() + salesByDate.getOrdersShipped());

            summaryStatisticByDate.setTotalBrowserPageViews(summaryStatisticByDate.getTotalBrowserPageViews() + trafficByDate.getBrowserPageViews());
            summaryStatisticByDate.setTotalMobileAppPageViews(summaryStatisticByDate.getTotalMobileAppPageViews() + trafficByDate.getMobileAppPageViews());
            summaryStatisticByDate.setTotalPageViews(summaryStatisticByDate.getTotalPageViews() + trafficByDate.getPageViews());
            summaryStatisticByDate.setTotalBrowserSessions(summaryStatisticByDate.getTotalBrowserSessions() + trafficByDate.getBrowserSessions());
            summaryStatisticByDate.setTotalMobileAppSessions(summaryStatisticByDate.getTotalMobileAppSessions() + trafficByDate.getMobileAppSessions());
            summaryStatisticByDate.setTotalSessions(summaryStatisticByDate.getTotalSessions() + trafficByDate.getSessions());
        }

        return summaryStatisticByDate;
    }

    private SalesInfo sumSalesInfo(SalesInfo accumInfo, SalesInfo info) {
        if (accumInfo == null) {
            return info;
        }
        if (info == null) {
            return accumInfo;
        }

        double totalAmount = accumInfo.getAmount() + info.getAmount();
        String currencyCode = accumInfo.getCurrencyCode();

        return new SalesInfo(totalAmount, currencyCode);
    }
}
