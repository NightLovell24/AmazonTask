package com.n0rth.amazontask.service;

import com.n0rth.amazontask.dto.response.SummaryStatisticByDate;
import com.n0rth.amazontask.model.SalesAndTrafficByDate;

import java.util.List;

public interface SummaryStatisticByDateService {

    SummaryStatisticByDate getSummaryStatisticByDate(List<SalesAndTrafficByDate> byDateList);

}
