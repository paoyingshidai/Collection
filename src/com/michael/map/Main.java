package com.michael.map;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		MapInterface.hashMapSize();
		System.out.println();
		System.out.println("identifyHashMap()");
		MapInterface.identifyHashMap();
		System.out.println();
		System.out.println();

		MapInterface.treeMapOrder();
		System.out.println();
		System.out.println();

		MapInterface.linkedHashMap();

//		MapInterface.treeMap();

	}

}
