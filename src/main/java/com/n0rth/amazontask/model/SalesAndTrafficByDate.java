package com.n0rth.amazontask.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "salesAndTrafficByDate")
public class SalesAndTrafficByDate {
    @Id
    private String id;
    private String date;
    private SalesByDate salesByDate;
    private TrafficByDate trafficByDate;

}
