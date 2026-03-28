package com.example.demo;

import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import scala.collection.mutable.HashSet;

@RestController
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(defaultValue = "World") String name) {
        return "Hello, " + name + "!";
    }

        // Copies all elements from a Set<Integer> into an int array
        public int[] setToIntArray(java.util.Set<Integer> set) {
            int[] arr = new int[set.size()];
            int i = 0;
            for (int num : set) {
                arr[i++] = num;
            }
            return arr;
        }
        public HashSet<Integer> convertToSet(int[] arr) {
            HashSet<Integer> set = new HashSet<>();
            for (int num : arr) {
                set.add(num);
            }
            return set;
        }
        public int findMissingNumber(int[] arr) {
            int n = arr.length + 1; // Since one number is missing
            int totalSum = n * (n + 1) / 2; // Sum of first n natural numbers
            int arrSum = 0;
            for (int num : arr) {
                arrSum += num;
            }
            return totalSum - arrSum; // The missing number
        }
}
