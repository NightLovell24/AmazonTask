package com.n0rth.amazontask.service;

import com.n0rth.amazontask.model.SalesAndTrafficByDate;

import java.time.LocalDate;
import java.util.List;

public interface StatisticByDateService {
    SalesAndTrafficByDate getStatisticByOneDate(String date);

    List<SalesAndTrafficByDate> getStatisticByRangeDate(String start, String end);

    List<SalesAndTrafficByDate> getAllSalesAndTrafficByDate();
}
