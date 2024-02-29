package com.n0rth.amazontask.dto.response;

import com.n0rth.amazontask.model.SalesByDate;
import com.n0rth.amazontask.model.TrafficByDate;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SummaryStatisticByDate {
    private SalesByDate summarySalesByDate;
    private SummaryTrafficByDate summaryTrafficByDate;

}
