package com.n0rth.amazontask.controller;

import com.n0rth.amazontask.dto.response.SummaryStatisticByDate;
import com.n0rth.amazontask.model.SalesAndTrafficByDate;
import com.n0rth.amazontask.service.StatisticByDateService;
import com.n0rth.amazontask.service.SummaryStatisticByDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stats/date")
@RequiredArgsConstructor
public class StatisticByDateController {

    private final StatisticByDateService statisticByDateService;
    private final SummaryStatisticByDateService summaryStatisticByDateService;

    @GetMapping("/{date}")
    public ResponseEntity<SalesAndTrafficByDate> getStatsByDate(@PathVariable("date")
                                                                String date) {

        return ResponseEntity.ok(statisticByDateService.getStatisticByOneDate(date));
    }

    @GetMapping("/range")
    public ResponseEntity<List<SalesAndTrafficByDate>> getStatsByDateRange(
            String start,
            String end) {

        List<SalesAndTrafficByDate> result = statisticByDateService.getStatisticByRangeDate(start, end);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/summary")
    public ResponseEntity<SummaryStatisticByDate> getStatsByDateRange() {
        List<SalesAndTrafficByDate> byDateList = statisticByDateService.getAllSalesAndTrafficByDate();

        return ResponseEntity.ok(summaryStatisticByDateService.getSummaryStatisticByDate(byDateList));
    }


}
