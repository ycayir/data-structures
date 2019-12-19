package com.yc.interviews.localytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Localytics coding challenge
 *
 * See the two tab delimited files attached:
 *
 *   products.tab = A list of product names tab delimited with categories
 *   sales.tab = A list of product names tab delimited with sales amount
 *
 * From this data we'd like you to answer two questions:
 * What category has the highest average sales price? (Please include the average sale price)
 * What is the minimum and maximum sale in the category 'Breakfast'
 * This comes from when someone worked at a company that made back office software for restaurants.  You can imagine the second file is a Point of Sale record for the day.
 *
 * Please email the code in a zip file in approximately one hour, along with the answers. If you have trouble emailing us the code, please send us a private gist (gist.github.com).
 *
 * P.S. - We've had people install MySQL, import the data and provide the answer by executing queries.  While that is a good approach, we'd rather see everything done within a self-contained, simple program.
 *
 * P.P.S - You can do this in any language.
 *
 */
public class CalculateSales {

    public static void main(String[] args) {

        String productsTable = "src/main/resources/products.tab";
        String salesTable = "src/main/resources/sales.tab";

        Map<String, Double> categoriesToAverageSales = new HashMap<>();

        Map<String, String> productsToCategories = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(productsTable))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split("\t");
                if (arr.length == 2) {
                    productsToCategories.put(arr[0], arr[1]);
                    categoriesToAverageSales.put(arr[1], 0d);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Double> productsToSales = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(salesTable))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split("\t");
                if (arr.length == 2) {
                    productsToSales.put(arr[0], Double.valueOf(arr[1]));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String category : categoriesToAverageSales.keySet()) {
            Double totalAmount = 0d;
            int numberOfProducts = 0;

            for (String product : productsToCategories.keySet()) {
                numberOfProducts++;
                Double sales = productsToSales.get(product);
                if (sales != null) {
                    totalAmount += sales;
                }
            }
            double averageAmount = totalAmount / numberOfProducts;
            categoriesToAverageSales.put(category, averageAmount);
        }

        String maxSaleCategory = "";
        Double highestAverageAmount = 0d;
        for (String category : categoriesToAverageSales.keySet()) {

            if (categoriesToAverageSales.get(category) > highestAverageAmount) {
                maxSaleCategory = category;
            }
        }

        System.out.println(maxSaleCategory + " has the highest average amount which is " + categoriesToAverageSales.get(maxSaleCategory));

        Double minSaleForBreakfastCat = Double.MAX_VALUE;
        Double maxSaleForBreakfastCat = 0d;
        for (String product : productsToCategories.keySet()) {
            String category = productsToCategories.get(product);
            if (category.equalsIgnoreCase("Breakfast")) {
                Double sale = productsToSales.get(product);
                if (sale != null && sale < minSaleForBreakfastCat) {
                    minSaleForBreakfastCat = sale;
                }
                if (sale != null && sale > maxSaleForBreakfastCat) {
                    maxSaleForBreakfastCat = sale;
                }
            }
        }

        System.out.println("Max sale in category 'Breakfast' is " + maxSaleForBreakfastCat);
        System.out.println("Max sale in category 'Breakfast' is " + minSaleForBreakfastCat);
    }
}
