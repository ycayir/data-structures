package com.yc.interviews.localytics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Localytics coding challenge
 *
 * See the two tab delimited files attached:
 *
 *   products.tab = A list of product names tab delimited with categories
 *   sales.tab = A list of product names tab delimited with sales amount
 *
 * From this data we'd like you to answer two questions:
 *  1) What category has the highest average sales price? (Please include the average sale price)
 *  2) What is the minimum and maximum sale in the category 'Breakfast'
 *
 * This comes from when someone worked at a company that made back office software for restaurants.
 * You can imagine the second file is a Point of Sale record for the day.
 *
 * Please email the code in a zip file in approximately one hour, along with the answers.
 * If you have trouble emailing us the code, please send us a private gist (gist.github.com).
 *
 * P.S. - We've had people install MySQL, import the data and provide the answer by executing queries.
 * While that is a good approach, we'd rather see everything done within a self-contained, simple program.
 *
 * P.P.S - You can do this in any language.
 *
 */
public class CalculateSales2 {
    private static String PATH_TO_PRODUCTS = "src/main/resources/localytics/products.tab";
    private static String PATH_TO_SALES = "src/main/resources/localytics/sales.tab";

    private static Map<String, String> getProductsToCategories() {
        Map<String, String> productsToCategories = new HashMap<>();

        try {
            Scanner pScanner = new Scanner(new File(PATH_TO_PRODUCTS));
//            int lineCount = 1;
            while(pScanner.hasNextLine()) {
                String line = pScanner.nextLine();
//                System.out.println("DEBUG> lineCount: " + lineCount + ", line: " + line);
//                lineCount++;
                if (line.equals("")) {
                    continue;
                }
                String[] arr = line.split("\t");
                if (arr.length != 2) {
                    continue;
                }
//                System.out.println("DEBUG> product name: " + arr[0] + ", category: " + arr[1]);
                productsToCategories.put(arr[0], arr[1]);
            }

        } catch (FileNotFoundException e) {
            System.out.print(e.getMessage());
        }

        return productsToCategories;
    }

    private static Map<String, Double> getProductsToAverageDailyPrices() {
        Map<String, Double> productsToAverageDailyPrices = new HashMap<>();
        Map<String, Integer> productsByCounts = new HashMap<>();
        Map<String, Double> productsByDailyTotalPrice = new HashMap<>();

        try {
            Scanner sScanner = new Scanner(new File(PATH_TO_SALES));
//            int lineCount = 1;
            while(sScanner.hasNextLine()) {
                String line = sScanner.nextLine();
//                System.out.println("DEBUG> lineCount: " + lineCount + ", line: " + line);
//                lineCount++;
                if (line.equals("")) {
                    continue;
                }
                String[] arr = line.split("\t");
                if (arr.length != 2) {
                    continue;
                }
//                System.out.println("DEBUG> product name: " + arr[0] + ", sale price: " + arr[1]);
                if (productsByCounts.containsKey(arr[0])) {
                    productsByCounts.put(arr[0], productsByCounts.get(arr[0]) + 1);
                    productsByDailyTotalPrice.put(arr[0], productsByDailyTotalPrice.get(arr[0]) + Double.parseDouble(arr[1]));
                } else {
                    productsByCounts.put(arr[0], 1);
                    productsByDailyTotalPrice.put(arr[0], Double.parseDouble(arr[1]));
                }
            }

            for (Map.Entry<String, Integer> entry : productsByCounts.entrySet()) {
//                System.out.println("DEBUG> " + entry.getKey() + "    " + entry.getValue() + "    " + productsByDailyTotalPrice.get(entry.getKey()));
                double dailyTotalPriceForProduct = productsByDailyTotalPrice.get(entry.getKey());
                int dailySaleCountForProduct = productsByCounts.get(entry.getKey());
                productsToAverageDailyPrices.put(entry.getKey(), dailyTotalPriceForProduct / dailySaleCountForProduct);
            }

        } catch (FileNotFoundException e) {
            System.out.print(e.getMessage());
        }

        return productsToAverageDailyPrices;
    }

    public static void main(String[] args) {

        Map<String, String> productsToCategories = getProductsToCategories();

        Map<String, Double> productsToAverageDailyPrices = getProductsToAverageDailyPrices();

        double maxAverageDailyPrice = 0D;
        String maxAverageDailyPriceProduct = "";
        for (Map.Entry<String, Double> entry : productsToAverageDailyPrices.entrySet()) {
//            System.out.println("product: " + entry.getKey() + "   average sales: " + entry.getValue());
            if (entry.getValue() > maxAverageDailyPrice) {
                maxAverageDailyPrice = entry.getValue();
                maxAverageDailyPriceProduct = entry.getKey();
            }
        }

        System.out.println("Max average sale price is " + maxAverageDailyPrice + " for product '" + maxAverageDailyPriceProduct
                + "' in category '" + productsToCategories.get(maxAverageDailyPriceProduct) + "'");

        // TODO: Find min and max sales values for category 'Breakfast'
//        for (Map.Entry<String, String> entry : productsToCategories.entrySet()) {
//            if (entry.getValue().equalsIgnoreCase("Breakfast")) {
//
//            }
//        }
    }
}
