package com.yc.interviews.draftkings;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Here is the coding exercise from DraftKings, submitted on 03 January 2020
 *
 *
 * This is a program to manage the Organizational Structure in a company. The program should allow us to:
 * 1. Add Employees
 * 2. Generate the Org Chart in a specific format (explained further below)
 * 3. Remove employees
 * 4. Move an Employee from one manager to another.
 * 5. Count the number of employees that ultimately report up to a given manager.
 *
 * The input for this program is a text file comprising of a series of commands and parameters that may look like this:
 *
 * 6                           <== Number of lines of input data to process
 * add,10,Sharilyn Gruber,-1   <== Add Sharilyn Gruber as an employee with ID 10, with no manager
 * add,7,Denice Mattice,10     <== Add Denice Mattice as an employee with ID 7, with Sharilyn Gruber as the manager
 * add,3,Lawana Futrell,-1     <== Add Lawana Futrell as an employee with ID 3, with no manager
 * add,34,Lissette Gorney,7    <== Add Lissette Gorney as an employee with ID 34, with Denice Mattice as the manager
 * add,5,Lan Puls,3            <== Add Lan Puls as an employee with ID 5, with Lawana Futrell as the manager
 * print                       <== Print the Org Chart as specified below
 *
 * The output of the program, when fed the above as input, will be
 * Sharilyn Gruber [10]
 *   Denice Mattice [7]
 *     Lissette Gorney [34]
 * Lawana Futrell [3]
 *   Lan Puls [5]
 *
 * Each employee is printed as Name [employee_id] - there's a space between the name and the ID.
 * At each reporting level, add 2 spaces preceding the name.
 *
 * Employees are always displayed in the order they are processed.
 *
 * Adding an Employee:
 *      The command is of the format
 *      add,&ltemployee id&gt,&ltname&gt,&ltmanager id&gt
 *
 *      If an employee with an ID has been added, then subsequent additions of employees with the same ID are ignored.
 *      If an employee's manager has not already been added, then the employee is considered to have no manager.
 *
 * Moving an Employee:
 *      The command is of the format
 *      move,&ltemployee id&gt,&ltnew manager id&gt
 *
 *      If an employee of that ID does not exist, then do nothing
 *      If an employee with the new manager ID does not exist, then do nothing
 *      The newly moved employee will be appended to the manager's list of reports, when the org chart is printed.
 *      Subsequent adds will continue to be added to the end of the list of reports.
 *
 * Removing an Emloyee:
 *      The command is of the format
 *      remove,&ltemployee id&gt
 *
 *      If an employee of that ID does not exist, then do nothing
 *      After removal, if the employee had any reports, they should now report to the removed employee's manager.
 *      These employees will show up in the same order as they did under their former manager, but after any current
 *      reports of the new manager.
 *      If the removed employee had no manager, then the reports will have no manager either.
 *
 * Counting Employees:
 *      The command is of the format
 *      count,&ltemployee id&gt
 *
 *      This should return the total number of reports, including any indirect reports (all descendant reports),
 *      that the specified employee has.
 *
 * The processing of the input file is already implemented. You only have to implement Add, Print, Remove, Move, and Count
 * methods below
 * Feel free to add any other class members or other classes, as needed.
 */
public class OrgChart {

    private class Node {
        private String id;
        private String name;
        private List<Node> children = new ArrayList<>();

        Node(String id, String name) {
            this.id = id;
            this.name = name;
        }

        List<Node> getChildren() {
            return children;
        }
    }

    private Node root = null;

    public void add(String id, String name, String managerId) {
        System.out.println("Adding emp ID: " + id + " name: " + name + " manager id: " + managerId);
        Node newEmployee = new Node(id, name);

    }

    public void move(String employeeId, String newManagerId) {

    }

    public void remove(String employeeId) {

    }

    public void print() {
        print(root);
    }

    private void print(Node root) {
        if (root == null) {

        }
//        System.out.println(root.name + " [" + root.id + "]");
//        root.getChildren().forEach(Node -> );
    }

    public static void main(String[] args) {
        try {
            OrgChart orgChart = new OrgChart();

            Scanner scanner = new Scanner(new File("src/main/resources/draftkings/employees1.csv"));
            int numberOfLines = scanner.nextInt();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                if ("add".equalsIgnoreCase(data[0])) {
                    if (data.length != 4) {
                        throw new IllegalArgumentException("Add operation should be 4 arguments but has " + data.length);
                    }
                    orgChart.add(data[1], data[2], data[3]);
                } else if ("move".equalsIgnoreCase(data[0])) {
                    if (data.length != 3) {
                        throw new IllegalArgumentException("Move operation should be 3 arguments but has " + data.length);
                    }
                    orgChart.move(data[1], data[2]);
                } else if ("remove".equalsIgnoreCase(data[0])) {
                    if (data.length != 2) {
                        throw new IllegalArgumentException("Delete operation should be 2 arguments but has " + data.length);
                    }
                    orgChart.remove(data[1]);
                } else if ("print".equalsIgnoreCase(data[0])) {
                    if (data.length != 1) {
                        throw new IllegalArgumentException("Print operation should be 1 arguments but has " + data.length);
                    }
                    orgChart.print();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

}
