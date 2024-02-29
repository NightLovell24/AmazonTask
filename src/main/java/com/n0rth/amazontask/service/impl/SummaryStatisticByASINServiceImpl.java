package com.n0rth.amazontask.service.impl;

import com.n0rth.amazontask.dto.response.SummaryStatisticByASIN;
import com.n0rth.amazontask.dto.response.SummaryTrafficByASIN;
import com.n0rth.amazontask.model.SalesAndTrafficByAsin;
import com.n0rth.amazontask.model.SalesByASIN;
import com.n0rth.amazontask.model.SalesInfo;
import com.n0rth.amazontask.model.TrafficByASIN;
import com.n0rth.amazontask.service.SummaryStatisticByASINService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SummaryStatisticByASINServiceImpl implements SummaryStatisticByASINService {

    @Override
    public SummaryStatisticByASIN getSummaryStatisticByASIN(List<SalesAndTrafficByAsin> byASINList) {
        SalesByASIN summarySalesByASIN = getSummarySalesByASIN(byASINList);
        SummaryTrafficByASIN summaryTrafficByASIN = getSummaryTrafficByASIN(byASINList);

        return new SummaryStatisticByASIN(summarySalesByASIN, summaryTrafficByASIN);
    }


    private SalesByASIN getSummarySalesByASIN(List<SalesAndTrafficByAsin> byASINList) {
        SalesByASIN salesByASIN = new SalesByASIN();
        SalesInfo totalOrderedProductSales = new SalesInfo();
        SalesInfo totalOrderedProductSalesB2B = new SalesInfo();

        for (SalesAndTrafficByAsin byASIN : byASINList) {
            SalesByASIN sba = byASIN.getSalesByAsin();

            salesByASIN.setUnitsOrdered(salesByASIN.getUnitsOrdered() + sba.getUnitsOrdered());
            salesByASIN.setUnitsOrderedB2B(salesByASIN.getUnitsOrderedB2B() + sba.getUnitsOrderedB2B());

            totalOrderedProductSales.setAmount(totalOrderedProductSales.getAmount() + sba.getOrderedProductSales().getAmount());
            totalOrderedProductSalesB2B.setAmount(totalOrderedProductSalesB2B.getAmount() + sba.getOrderedProductSalesB2B().getAmount());

            salesByASIN.setTotalOrderItems(salesByASIN.getTotalOrderItems() + sba.getTotalOrderItems());
            salesByASIN.setTotalOrderItemsB2B(salesByASIN.getTotalOrderItemsB2B() + sba.getTotalOrderItemsB2B());
        }

        salesByASIN.setOrderedProductSales(totalOrderedProductSales);
        salesByASIN.setOrderedProductSalesB2B(totalOrderedProductSalesB2B);

        return salesByASIN;
    }

    private SummaryTrafficByASIN getSummaryTrafficByASIN(List<SalesAndTrafficByAsin> byASINList) {
        SummaryTrafficByASIN summaryTrafficByASIN = new SummaryTrafficByASIN();

        for (SalesAndTrafficByAsin byASIN : byASINList) {
            TrafficByASIN tba = byASIN.getTrafficByAsin();

            summaryTrafficByASIN.setBrowserSessions(summaryTrafficByASIN.getBrowserSessions() +
                    tba.getBrowserSessions());
            summaryTrafficByASIN.setBrowserSessionsB2B(summaryTrafficByASIN.getBrowserSessionsB2B() +
                    tba.getBrowserSessionsB2B());
            summaryTrafficByASIN.setMobileAppSessions(summaryTrafficByASIN.getMobileAppSessions() +
                    tba.getMobileAppSessions());
            summaryTrafficByASIN.setMobileAppSessionsB2B(summaryTrafficByASIN.getMobileAppSessionsB2B() +
                    tba.getMobileAppSessionsB2B());
            summaryTrafficByASIN.setSessions(summaryTrafficByASIN.getSessions() + tba.getSessions());
            summaryTrafficByASIN.setSessionsB2B(summaryTrafficByASIN.getSessionsB2B() + tba.getSessionsB2B());
            summaryTrafficByASIN.setBrowserPageViews(summaryTrafficByASIN.getBrowserPageViews() +
                    tba.getBrowserPageViews());
            summaryTrafficByASIN.setBrowserPageViewsB2B(summaryTrafficByASIN.getBrowserPageViewsB2B() +
                    tba.getBrowserPageViewsB2B());
            summaryTrafficByASIN.setMobileAppPageViews(summaryTrafficByASIN.getMobileAppPageViews() +
                    tba.getMobileAppPageViews());
            summaryTrafficByASIN.setMobileAppPageViewsB2B(summaryTrafficByASIN.getMobileAppPageViewsB2B() +
                    tba.getMobileAppPageViewsB2B());
            summaryTrafficByASIN.setPageViews(summaryTrafficByASIN.getPageViews() + tba.getPageViews());
            summaryTrafficByASIN.setPageViewsB2B(summaryTrafficByASIN.getPageViewsB2B() + tba.getPageViewsB2B());
        }

        return summaryTrafficByASIN;
    }
}
