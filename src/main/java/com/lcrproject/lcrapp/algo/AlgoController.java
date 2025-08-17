package com.lcrproject.lcrapp.algo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/v1/algo/")
public class AlgoController {
    
    private static final Logger logger = LoggerFactory.getLogger(AlgoController.class);

    @Autowired
    private final AlgoService algoService;

    public AlgoController(AlgoService algoService) {
        this.algoService = algoService;
    }

    @PostMapping("sort/bubble")
    public int[] sortArray(@RequestBody int[] input) {
        logger.info("Bubble sort input: {}", input);
        return algoService.bubbleSort(input);
    }

    @PostMapping("sort/insertion")
    public int[] insertionsortArray(@RequestBody int[] input) {
        logger.info("Insertion sort input: {}", input);
        return algoService.insertionSort(input);
    }

    @PostMapping("dynamic/knapsack")
    public int knapsackAlgo(@RequestBody KnapsackRequest request) {
        logger.info("Knapsack input: {}", request);
        return algoService.solveKnapsack(request);

    }
}
