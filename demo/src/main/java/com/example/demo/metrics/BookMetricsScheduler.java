package com.example.demo.metrics;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BookMetricsScheduler {

    private final BookMetrics bookMetrics;

    public BookMetricsScheduler(BookMetrics bookMetrics) {
        this.bookMetrics = bookMetrics;
    }

    @Scheduled(fixedRate = 1000)
    public void triggerCustomMetrics() {
    	bookMetrics.getRandomMetricsData();
    }
}