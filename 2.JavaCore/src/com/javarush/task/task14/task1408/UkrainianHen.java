package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen {
	@Override
	int getCountOfEggsPerMonth() {
		return 13;
	}
	
	@Override
	String getDescription() {
		return super.getDescription() + " Моя страна - " + UKRAINE + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
	}
}