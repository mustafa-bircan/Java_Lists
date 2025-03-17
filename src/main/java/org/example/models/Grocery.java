package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n0: Uygulamayı Durdur");
            System.out.println("1: Eleman Ekle");
            System.out.println("2: Eleman Çıkar");
            System.out.print("Bir seçenek giriniz (0, 1, 2): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                System.out.println("Uygulama durduruluyor...");
                break;
            } else if (choice == 1) {
                System.out.print("Eklemek istediğiniz elemanları girin (virgülle ayırarak): ");
                String input = scanner.nextLine();
                addItems(input);
            } else if (choice == 2) {
                System.out.print("Çıkarmak istediğiniz elemanları girin (virgülle ayırarak): ");
                String input = scanner.nextLine();
                removeItems(input);
            } else {
                System.out.println("Geçersiz seçenek!");
            }
        }
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            item = item.trim();
            if (!checkItemIsInList(item)) {
                groceryList.add(item);
            } else {
                System.out.println(item + " zaten listede var!");
            }
        }
        Collections.sort(groceryList);
        printSorted();
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            item = item.trim();
            if (checkItemIsInList(item)) {
                groceryList.remove(item);
            } else {
                System.out.println(item + " listede bulunamadı!");
            }
        }
        Collections.sort(groceryList);
        printSorted();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        System.out.println("Grocery List: ");
        for (String item : groceryList) {
            System.out.println(item);
        }
    }
}
