package com.n0rth.amazontask.dto.response;

import com.n0rth.amazontask.model.SalesByASIN;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SummaryStatisticByASIN {
    private SalesByASIN salesByAsin;
    private SummaryTrafficByASIN summaryTrafficByASIN;
}
