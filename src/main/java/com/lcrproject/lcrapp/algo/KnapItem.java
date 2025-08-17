package com.lcrproject.lcrapp.algo;

import lombok.Data;
import jakarta.validation.constraints.Min;

@Data
public class KnapItem {
    @Min(value = 1, message = "Weight must be at least 1")
    private int weight;

    @Min(value = 1, message = "Weight must be at least 1")
    private int value;    
}
