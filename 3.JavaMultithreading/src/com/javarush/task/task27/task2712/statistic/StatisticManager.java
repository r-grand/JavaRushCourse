package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
	private static StatisticManager instance;
	private final StatisticStorage statisticStorage = new StatisticStorage();
	
	private StatisticManager() {
	}
	
	public static StatisticManager getInstance() {
		if (instance == null) {
			instance = new StatisticManager();
		}
		return instance;
	}
	
	public void register(EventDataRow data) {
		statisticStorage.put(data);
	}
	
	public Map<String, Double> calculateAdvertisementProfit() {
		Map<EventType, List<EventDataRow>> dataForCalculating = statisticStorage.getStorage();
		List<EventDataRow> selectedVideos = dataForCalculating.get(EventType.SELECTED_VIDEOS);
		Map<String, Double> profitByDay = new TreeMap<>();
		SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
		
		for (EventDataRow eventDataRow : selectedVideos) {
			String date = format.format(eventDataRow.getDate());
			Double amount = ((double) ((VideoSelectedEventDataRow) eventDataRow).getAmount()) / 100;
			profitByDay.merge(date, amount, Double::sum);
		}
		return profitByDay;
	}
	
	public Map<String, Map<String, Integer>> calculateCookWorkloading() {
		Map<EventType, List<EventDataRow>> dataForCalculating = statisticStorage.getStorage();
        List<EventDataRow> cookedOrders = dataForCalculating.get(EventType.COOKED_ORDER);
        Map<String, Map<String, Integer>> cooksWorkloading = new TreeMap<>();
		SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
		
		for (EventDataRow eventDataRow : cookedOrders) {
			String date = format.format(eventDataRow.getDate());
			String cookName = ((CookedOrderEventDataRow) eventDataRow).getCookName();
			Integer cookingTimeSeconds = eventDataRow.getTime();
			
			if (cooksWorkloading.get(date) != null) {
				Map<String, Integer> cookLoading = cooksWorkloading.get(date);
				cookLoading.merge(cookName, cookingTimeSeconds, Integer::sum);
				cooksWorkloading.put(date, cookLoading);
			} else {
				Map<String, Integer> cookLoading = new HashMap<>();
				cookLoading.put(cookName, cookingTimeSeconds);
				cooksWorkloading.put(date, cookLoading);
			}
		}
		return cooksWorkloading;
	}
	
	private static class StatisticStorage {
		private final Map<EventType, List<EventDataRow>> storage = new TreeMap<>();
		
		public StatisticStorage() {
			for (EventType type : EventType.values()) {
				storage.put(type, new ArrayList<>());
			}
		}
		
		public Map<EventType, List<EventDataRow>> getStorage() {
			return storage;
		}
		
		private void put(EventDataRow data) {
			storage.get(data.getType()).add(data);
		}
	}
}
