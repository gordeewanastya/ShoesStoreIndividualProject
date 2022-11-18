package com.gordeeva.courses.ShoesStore.models.dto;


import lombok.Data;

@Data
public class ResponseOrderDTO {
    private float amount;
    private int invoiceNumber;
    private String date;
    private String OrderDescription;
    private Long orderId;
}
