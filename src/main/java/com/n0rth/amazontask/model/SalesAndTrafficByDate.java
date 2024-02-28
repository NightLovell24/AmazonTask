package com.n0rth.amazontask.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "salesAndTrafficByDate")
public class SalesAndTrafficByDate {
    @Id
    private String id;
    private LocalDate date;
    private SalesByDate salesByDate;
    private TrafficByDate trafficByDate;

}
