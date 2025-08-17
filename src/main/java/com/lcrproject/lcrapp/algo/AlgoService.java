package com.lcrproject.lcrapp.algo;

import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class AlgoService {

    public int[] bubbleSort(int[] input) {
        
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j] > input[j+1]) {
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
        }
        return input;
    }

    public int[] insertionSort(int[] arr){
        int n =arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i-1;

            while (j>=0 && arr[j]>key){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public int solveKnapsack(KnapsackRequest request){

        int capacity = request.getCapacity();
        List<KnapItem> items = request.getItems();
        int n = items.size();

        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            KnapItem item = items.get(i-1);
            for (int w = 0; w <= capacity; w++) {
                if (item.getWeight() <= w) {
                    dp[i][w] = Math.max(item.getValue() + dp[i - 1][w - item.getWeight()],dp[i - 1][w]);
                }
                else {
                    dp[i][w] = dp[i - 1][w];
                }

            }
        }

        return dp[n][capacity];
    }
}
