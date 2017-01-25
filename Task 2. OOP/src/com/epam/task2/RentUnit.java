package com.epam.task2;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class RentUnit {
	private ArrayList<SportEquipment> units;	//collection of goods, which user want to take in rent
	
	public RentUnit() {
		units = new ArrayList<SportEquipment>();
	}
	
	public RentUnit(ArrayList<SportEquipment> units) {
		this.setSportEquipment(units);
	}
	
	public ArrayList<SportEquipment> getSportEquipment() {
		return units;
	}
	
	public void setSportEquipment(ArrayList<SportEquipment> units) {
		this.units = units;
	}
	
	public boolean searchByKey(Shop shop, SportEquipment key){	//check the availability of good in the shop
		for (Map.Entry<SportEquipment, Integer> item : shop.getGoods().entrySet()) {
			if((item.getKey().getCategory().getCategory().equals(key.getCategory().getCategory())) && (item.getKey().getTitle()).equals(key.getTitle()) && ((item.getKey().getPrice()) == key.getPrice()) && (item.getValue() > 0)){
				return true;
			}
		}
		return false;
	}
	
	public void changeCount(Shop shop, SportEquipment key){
		for (Map.Entry<SportEquipment, Integer> item : shop.getGoods().entrySet()) {
			if((item.getKey().getCategory().getCategory().equals(key.getCategory().getCategory())) && (item.getKey().getTitle()).equals(key.getTitle()) && ((item.getKey().getPrice()) == key.getPrice())){
				item.setValue(item.getValue() - 1);
			}
		}
	}
	
	public void goodsInShop(Shop shop){
		System.out.println("\n" + "Goods in shop:" + "\n");
		for (Map.Entry<SportEquipment, Integer> item : shop.getGoods().entrySet()) {
			System.out.println(item.getKey().getCategory().getCategory() + " " + item.getKey().getTitle() + " "
					+ item.getKey().getPrice() + " " + item.getValue());
		}
	}
	
	public void addGoodInRent(ArrayList<SportEquipment> units){
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n" + "Please, input products, which you want to buy from the list above(no more than three)).");
		
		System.out.println("In first, please, input category of product");
		String category = scanner.next();
		
		System.out.println("In second, please, input title of product");
		String title = scanner.next();
		
		System.out.println("In third, please, input price of product");
		int price = 0;
		try{
		price = Integer.parseInt(scanner.next());
		} catch (NumberFormatException e1) {
			System.out.println("Wrong input format!");
			System.exit(0);
		}
		units.add(new SportEquipment(new Category(category), title, price));
	}

	
	public void rentGood(Shop shop, ArrayList<SportEquipment> units, ArrayList<SportEquipment> goodsInRent){
		for (SportEquipment item: units){
				if(searchByKey(shop, item)){
					changeCount(shop, item);
					goodsInRent.add(item);
				}
				else{
					System.out.println("\n" + "No such good in shop: " + item.getCategory().getCategory() + " " + item.getTitle() + " " + item.getPrice());
				}
			}
		}
}