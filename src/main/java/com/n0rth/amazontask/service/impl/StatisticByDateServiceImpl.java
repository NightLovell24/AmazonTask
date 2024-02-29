package com.n0rth.amazontask.service.impl;

import com.n0rth.amazontask.model.SalesAndTrafficByDate;
import com.n0rth.amazontask.repository.SalesAndTrafficByDateRepository;
import com.n0rth.amazontask.service.StatisticByDateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatisticByDateServiceImpl implements StatisticByDateService {

    private final SalesAndTrafficByDateRepository byDateRepository;


    @Override
    public SalesAndTrafficByDate getStatisticByOneDate(String date) {
        return byDateRepository.findByDate(date);
    }

    @Override
    public List<SalesAndTrafficByDate> getStatisticByRangeDate(String start, String end) {
        return byDateRepository.findByDateDateBetween(start, end);
    }

    @Override
    public List<SalesAndTrafficByDate> getAllSalesAndTrafficByDate() {
        return byDateRepository.findAll();
    }


}
