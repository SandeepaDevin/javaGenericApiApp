package com.lcrproject.lcrapp.algo;
import lombok.Data;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

@Data
public class KnapsackRequest {
    @Min(value = 1, message = "Capacity must be at least 1")
    private int capacity;
   
    @NotEmpty(message = "Items list cannot be empty")
    @Valid
    private List<KnapItem> items;   
}
