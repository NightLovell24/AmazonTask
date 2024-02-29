package com.n0rth.amazontask.service;

import com.n0rth.amazontask.model.SalesAndTrafficByAsin;

import java.util.List;

public interface StatisticByASINService {

    List<SalesAndTrafficByAsin> getStatisticByASIN(List<String> asin);
}
