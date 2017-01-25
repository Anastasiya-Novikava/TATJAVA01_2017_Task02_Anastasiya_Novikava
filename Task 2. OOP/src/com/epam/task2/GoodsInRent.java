package com.epam.task2;

import java.util.ArrayList;

public class GoodsInRent {
	private ArrayList<SportEquipment> goodsInRent;

	public GoodsInRent() {
		goodsInRent = new ArrayList<SportEquipment>();
	}

	public ArrayList<SportEquipment> getGoodsInRent() {
		return goodsInRent;
	}

	public void setGoodsInRent(ArrayList<SportEquipment> goodsInRent) {
		this.goodsInRent = goodsInRent;
	}
}
