package com.n0rth.amazontask.service;

import com.n0rth.amazontask.dto.response.SummaryStatisticByASIN;
import com.n0rth.amazontask.model.SalesAndTrafficByAsin;

import java.util.List;

public interface SummaryStatisticByASINService {
    SummaryStatisticByASIN getSummaryStatisticByASIN(List<SalesAndTrafficByAsin> byASINList);

}
