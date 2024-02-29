package com.n0rth.amazontask.controller;

import com.n0rth.amazontask.dto.response.SummaryStatisticByASIN;
import com.n0rth.amazontask.model.SalesAndTrafficByAsin;
import com.n0rth.amazontask.service.StatisticByASINService;
import com.n0rth.amazontask.service.SummaryStatisticByASINService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stats/asin")
@RequiredArgsConstructor
public class StatisticByASINController {
    private final StatisticByASINService statisticByASINService;
    private final SummaryStatisticByASINService summaryStatisticByASINService;


    @GetMapping()
    public ResponseEntity<List<SalesAndTrafficByAsin>> getStatsByASIN(@RequestParam(value = "asin")
                                                                      List<String> asins) {

        return ResponseEntity.ok(statisticByASINService.getStatisticByASIN(asins));
    }

    @GetMapping("/summary")
    public ResponseEntity<SummaryStatisticByASIN> getStatsByDateRange() {
        List<SalesAndTrafficByAsin> byASINList = statisticByASINService.getAllStatisticsByASIN();

        return ResponseEntity.ok(summaryStatisticByASINService.getSummaryStatisticByASIN(byASINList));
    }

}
