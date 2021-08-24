package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {
	private final List<Advertisement> videos = new ArrayList<>();
	
	private static AdvertisementStorage instance;
	
	private AdvertisementStorage() {
		Object someContent = new Object();
		videos.add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60));
		videos.add(new Advertisement(someContent, "second Video", 100, 10, 15 * 60));
		videos.add(new Advertisement(someContent, "Третье видео", 400, 2, 10 * 60));
		videos.add(new Advertisement(someContent, "fourth Video", 400, 4, 5 * 60));
		videos.add(new Advertisement(someContent, "пятое видео", 1000, 15, 6 * 60));
		videos.add(new Advertisement(someContent, "Sixth Video", 500, 7, 4 * 60));
		videos.add(new Advertisement(someContent, "Seventh Video", 800, 10, 2 * 60));
		videos.add(new Advertisement(someContent, "Eighth Video", 250, 5, 2 * 60));
		videos.add(new Advertisement(someContent, "Девятое видео", 3000, 50, 5 * 60));
		videos.add(new Advertisement(someContent, "Tenth Video", 600, 10, 7 * 60));
	}
	
	public static AdvertisementStorage getInstance() {
		if (instance == null) {
			instance = new AdvertisementStorage();
		}
		return instance;
	}
	
	public List<Advertisement> list() {
		return videos;
	}
	
	public void add(Advertisement advertisement) {
		videos.add(advertisement);
	}
}
