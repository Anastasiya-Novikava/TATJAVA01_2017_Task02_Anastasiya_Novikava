package com.epam.task2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Runner {
	
	public static void main(String[] args) throws IOException {
		Shop shop = new Shop();
		shop.initSportEquipment();
		RentUnit rentUnit = new RentUnit();
		rentUnit.goodsInShop(shop);
		GoodsInRent goodsInRent = new GoodsInRent();
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<SportEquipment> units = new ArrayList<SportEquipment>();
		String answer = "yes";
		int countOfGood = 0;
		while (answer.equals("yes") ) {
			rentUnit.addGoodInRent(units);
			countOfGood++;
			if(countOfGood == 3){
				System.out.println("\n" + "You can take in rent no more than three goods");
				break;
			}
			System.out.println("Do you want to continue to choice product? Please, input yes/no");
			answer = scanner.next();
			if(answer.equals("no")){
				break;
			}
			if(answer.equals("yes")){
				continue;
			}
			else{
				System.out.println("\nYou are input wrong answer");
			}
		}
		
		rentUnit.rentGood(shop, units, goodsInRent.getGoodsInRent());
		
		System.out.println("\n" + "Goods in rent: " + "\n");
		for (SportEquipment item : goodsInRent.getGoodsInRent()) {
			System.out.println(item.getCategory().getCategory() + " " + item.getTitle() + " " + item.getPrice());
		}

		rentUnit.goodsInShop(shop);
	}
}