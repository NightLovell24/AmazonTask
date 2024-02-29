package com.n0rth.amazontask.service.impl;

import com.n0rth.amazontask.dto.response.SummaryStatisticByDate;
import com.n0rth.amazontask.dto.response.SummaryTrafficByDate;
import com.n0rth.amazontask.model.SalesAndTrafficByDate;
import com.n0rth.amazontask.model.SalesByDate;
import com.n0rth.amazontask.model.SalesInfo;
import com.n0rth.amazontask.service.SummaryStatisticByDateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SummaryStatisticByDateServiceImpl implements SummaryStatisticByDateService {

    @Override
    public SummaryStatisticByDate getSummaryStatisticByDate(List<SalesAndTrafficByDate> byDateList) {

        SalesByDate summarySalesByDate = getSummarySalesByDate(byDateList);
        SummaryTrafficByDate summaryTrafficByDate = getSummaryTrafficByDate(byDateList);


        return new SummaryStatisticByDate(summarySalesByDate, summaryTrafficByDate);
    }

    private SummaryTrafficByDate getSummaryTrafficByDate(List<SalesAndTrafficByDate> byDateList) {
        SummaryTrafficByDate summaryTraffic = new SummaryTrafficByDate();

        for (SalesAndTrafficByDate byDate : byDateList) {
            summaryTraffic.setBrowserPageViews(summaryTraffic.getBrowserPageViews() + byDate.getTrafficByDate().getBrowserPageViews());
            summaryTraffic.setBrowserPageViewsB2B(summaryTraffic.getBrowserPageViewsB2B() + byDate.getTrafficByDate().getBrowserPageViewsB2B());
            summaryTraffic.setMobileAppPageViews(summaryTraffic.getMobileAppPageViews() + byDate.getTrafficByDate().getMobileAppPageViews());
            summaryTraffic.setMobileAppPageViewsB2B(summaryTraffic.getMobileAppPageViewsB2B() + byDate.getTrafficByDate().getMobileAppPageViewsB2B());
            summaryTraffic.setPageViews(summaryTraffic.getPageViews() + byDate.getTrafficByDate().getPageViews());
            summaryTraffic.setPageViewsB2B(summaryTraffic.getPageViewsB2B() + byDate.getTrafficByDate().getPageViewsB2B());
            summaryTraffic.setBrowserSessions(summaryTraffic.getBrowserSessions() + byDate.getTrafficByDate().getBrowserSessions());
            summaryTraffic.setBrowserSessionsB2B(summaryTraffic.getBrowserSessionsB2B() + byDate.getTrafficByDate().getBrowserSessionsB2B());
            summaryTraffic.setMobileAppSessions(summaryTraffic.getMobileAppSessions() + byDate.getTrafficByDate().getMobileAppSessions());
            summaryTraffic.setMobileAppSessionsB2B(summaryTraffic.getMobileAppSessionsB2B() + byDate.getTrafficByDate().getMobileAppSessionsB2B());
            summaryTraffic.setSessions(summaryTraffic.getSessions() + byDate.getTrafficByDate().getSessions());
            summaryTraffic.setSessionsB2B(summaryTraffic.getSessionsB2B() + byDate.getTrafficByDate().getSessionsB2B());
            summaryTraffic.setFeedbackReceived(summaryTraffic.getFeedbackReceived() + byDate.getTrafficByDate().getFeedbackReceived());
            summaryTraffic.setNegativeFeedbackReceived(summaryTraffic.getNegativeFeedbackReceived() + byDate.getTrafficByDate().getNegativeFeedbackReceived());
        }
        summaryTraffic.setReceivedNegativeFeedbackRate((double) (100 * summaryTraffic.getNegativeFeedbackReceived())
                / summaryTraffic.getFeedbackReceived());

        return summaryTraffic;
    }

    private SalesByDate getSummarySalesByDate(List<SalesAndTrafficByDate> byDateList) {
        SalesByDate salesByDate = new SalesByDate();

        SalesInfo orderedProductSales = new SalesInfo();
        SalesInfo orderedProductSalesB2B = new SalesInfo();

        int unitsOrdered = 0;
        int unitsOrderedB2B = 0;

        int totalOrderItems = 0;
        int totalOrderItemsB2B = 0;

        SalesInfo averageSalesPerOrderItem = new SalesInfo();
        SalesInfo averageSalesPerOrderItemB2B = new SalesInfo();

        double averageUnitsPerOrderItem;
        double averageUnitsPerOrderItemB2B;

        SalesInfo averageSellingPrice = new SalesInfo();
        SalesInfo averageSellingPriceB2B = new SalesInfo();

        int unitsRefunded = 0;
        int claimsGranted = 0;

        double refundRate = 0;


        SalesInfo claimsAmount = new SalesInfo();
        SalesInfo shippedProductSales = new SalesInfo();

        int unitsShipped = 0;
        int ordersShipped = 0;


        for (SalesAndTrafficByDate byDate : byDateList) {
            SalesByDate sbd = byDate.getSalesByDate();

            orderedProductSales.setAmount(orderedProductSales.getAmount() +
                    sbd.getOrderedProductSales().getAmount());
            orderedProductSalesB2B.setAmount(orderedProductSalesB2B.getAmount() +
                    sbd.getOrderedProductSalesB2B().getAmount());

            unitsOrdered += sbd.getUnitsOrdered();
            unitsOrderedB2B += sbd.getUnitsOrderedB2B();

            totalOrderItems += sbd.getTotalOrderItems();
            totalOrderItemsB2B += sbd.getTotalOrderItemsB2B();

            unitsRefunded += sbd.getUnitsRefunded();
            claimsGranted += sbd.getClaimsGranted();

            unitsShipped += sbd.getUnitsShipped();
            ordersShipped += sbd.getOrdersShipped();

            claimsAmount.setAmount(claimsAmount.getAmount() + sbd.getClaimsAmount().getAmount());
            shippedProductSales.setAmount(shippedProductSales.getAmount() + sbd.getShippedProductSales().getAmount());
        }
        averageSalesPerOrderItem.setAmount(orderedProductSales.getAmount() / totalOrderItems);
        averageSalesPerOrderItemB2B.setAmount(orderedProductSalesB2B.getAmount() / totalOrderItemsB2B);

        averageUnitsPerOrderItem = (double) unitsOrdered / totalOrderItems;
        averageUnitsPerOrderItemB2B = (double) unitsOrderedB2B / totalOrderItemsB2B;

        averageSellingPrice.setAmount(orderedProductSales.getAmount() / unitsOrdered);
        averageSellingPriceB2B.setAmount(orderedProductSalesB2B.getAmount() / unitsOrderedB2B);

        refundRate = ((double) (100 * unitsRefunded) / unitsOrdered);

        salesByDate.setOrderedProductSales(orderedProductSales);
        salesByDate.setOrderedProductSalesB2B(orderedProductSalesB2B);

        salesByDate.setUnitsOrdered(unitsOrdered);
        salesByDate.setUnitsOrderedB2B(unitsOrderedB2B);

        salesByDate.setTotalOrderItems(totalOrderItems);
        salesByDate.setTotalOrderItemsB2B(totalOrderItemsB2B);

        salesByDate.setAverageSalesPerOrderItem(averageSalesPerOrderItem);
        salesByDate.setAverageSalesPerOrderItemB2B(averageSalesPerOrderItemB2B);

        salesByDate.setAverageUnitsPerOrderItem(averageUnitsPerOrderItem);
        salesByDate.setAverageUnitsPerOrderItemB2B(averageUnitsPerOrderItemB2B);

        salesByDate.setAverageSellingPrice(averageSellingPrice);
        salesByDate.setAverageSellingPriceB2B(averageSellingPriceB2B);

        salesByDate.setUnitsRefunded(unitsRefunded);
        salesByDate.setClaimsGranted(claimsGranted);
        salesByDate.setRefundRate(refundRate);
        salesByDate.setClaimsAmount(claimsAmount);
        salesByDate.setShippedProductSales(shippedProductSales);
        salesByDate.setUnitsShipped(unitsShipped);
        salesByDate.setOrdersShipped(ordersShipped);

        return salesByDate;
    }
}
