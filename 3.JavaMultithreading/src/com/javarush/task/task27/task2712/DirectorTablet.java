package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.*;

public class DirectorTablet {
    public void printAdvertisementProfit() {
        NavigableMap<String, Double> profitByDay = ((TreeMap<String, Double>) StatisticManager.getInstance().calculateAdvertisementProfit()).descendingMap();
        double total = 0;
        
        for (Map.Entry<String, Double> pair : profitByDay.entrySet()) {
            System.out.println(pair.getKey() + " - " + (String.format("%.2f", pair.getValue())).replace(',', '.'));
            total += pair.getValue();
        }
    
        System.out.println("Total - " + (String.format("%.2f", total)).replace(',', '.'));
		System.out.println();
    }

    public void printCookWorkloading() {
        NavigableMap<String, Map<String, Integer>> cooksWorkloading = ((TreeMap<String, Map<String, Integer>>) StatisticManager.getInstance().calculateCookWorkloading()).descendingMap();
        
        for (Map.Entry<String, Map<String, Integer>> mapEntry : cooksWorkloading.entrySet()) {
			System.out.println(mapEntry.getKey());
			for (Map.Entry<String, Integer> pair : mapEntry.getValue().entrySet()) {
				int totalMinutes = pair.getValue();
				if (totalMinutes % 60 == 0) {
					System.out.println(pair.getKey() + " - " + totalMinutes / 60 + " min");
				} else {
					System.out.println(pair.getKey() + " - " + (totalMinutes / 60) + 1 + " min");
				}
			}
			System.out.println();
        }
    }

    public void printActiveVideoSet() {
		List<Advertisement> list = StatisticAdvertisementManager.getInstance().getAdStatistics();
		Collections.sort(list, (o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
		
		for (Advertisement video : list) {
		    if (video.isActive()) {
				System.out.println(video.getName() + " - " + video.getHits());
			}
		}
		
		System.out.println();
    }

    public void printArchivedVideoSet() {
		List<Advertisement> list = StatisticAdvertisementManager.getInstance().getAdStatistics();
		Collections.sort(list, (o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
		
		for (Advertisement video : list) {
			if (!video.isActive()) {
				System.out.println(video.getName());
			}
		}
		
		System.out.println();
	}
}
