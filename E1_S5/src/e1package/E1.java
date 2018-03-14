package e1package;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class E1 {
	public static Set<Integer> setOfValues() {
		Scanner sc = new Scanner(System.in);
		Set<Integer> values = new LinkedHashSet<Integer>();
		
		int userValue = Integer.MAX_VALUE;
		
		while (userValue != 0) {
			userValue = sc.nextInt();
			values.add(userValue);
		}
		
		return values;
	}
	
	public static void removeZero(Set<Integer> values) {
		Iterator<Integer> iterator = values.iterator();
		while(iterator.hasNext()) {
			Integer element = iterator.next();
			if (element == 0) {
				iterator.remove();
			}
		}
	}
	public static void displaySets() {
		System.out.println("Enter your values for your first set then type '0' to finish :");
		Set<Integer> set1 = setOfValues();
		removeZero(set1);
		System.out.println("Enter your values for your second set then type '0' to finish :");
		Set<Integer> set2 = setOfValues();
		removeZero(set2);
		
		System.out.println("Your first set is : " + set1);
		System.out.println("Your second set is : " + set2);
		
		Set<Integer> set3 = new LinkedHashSet<Integer>(set1);
		set3.addAll(set2);
		
		System.out.println("Your two sets comined are : " + set3);
	}
	
	public static void main(String[] args) {
		displaySets();
	}
}
