package com.epam.task2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Shop {
	private static Map<SportEquipment, Integer> goods;

	public Shop() {
		goods = new HashMap<SportEquipment, Integer>();
	}

	public Shop(Map<SportEquipment, Integer> goods) {
		this.setGoods(goods);
	}
	
	public Map<SportEquipment, Integer> getGoods() {
		return goods;
	}
	
	public void setGoods(Map<SportEquipment, Integer> goods) {
		Shop.goods = goods;
	}
	
	public void initSportEquipment() throws IOException {
		String[] lines = ReadInfo.readLines("in.txt").split("\r\n");
		String[] categories = new String[lines.length];
		String[] titles = new String[lines.length];
		String[] prices = new String[lines.length];
		String[] counts = new String[lines.length];

		for (int i = 0; i < lines.length; ++i) {
			categories[i] = lines[i].split(" ")[0];
			titles[i] = lines[i].split(" ")[1];
			prices[i] = lines[i].split(" ")[2];
			counts[i] = lines[i].split(" ")[3];
			
			goods.put(new SportEquipment(new Category(categories[i]), titles[i], Integer.parseInt(prices[i])), Integer.parseInt(counts[i]));
		}
	}
}
