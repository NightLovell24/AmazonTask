package com.n0rth.amazontask.service.impl;

import com.n0rth.amazontask.model.SalesAndTrafficByAsin;
import com.n0rth.amazontask.repository.SalesAndTrafficByAsinRepository;
import com.n0rth.amazontask.service.StatisticByASINService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticByASINServiceImpl implements StatisticByASINService {

    private final SalesAndTrafficByAsinRepository byAsinRepository;


    @Override
    public List<SalesAndTrafficByAsin> getStatisticByASIN(List<String> asin) {
        return byAsinRepository.findByParentAsinIn(asin);
    }
}
