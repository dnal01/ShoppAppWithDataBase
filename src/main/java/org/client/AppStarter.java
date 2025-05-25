package org.client;

import java.util.Scanner;

public class AppStarter {

    static String productName;
    static int productQuota;

    public static void main(String[] args) throws Exception {

        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Write option: add product / quit");
            String input = scanner.nextLine();
            if (input.equals("quit")) {
                System.exit(0);
            } else if (input.equals("add product")) {
                getData();
                runClient();
            } else {
                System.out.println("Incorrect option");
            }
        }
    }

    private static void getData() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Input product name: ");
            productName = scanner.nextLine();
            System.out.print("Input product quota, pcs.: ");
            productQuota = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Incorrect input try again.");
            getData();
        }

    }

    private static void runClient() throws Exception {
        ClientRunner clientRunner = new ClientRunner();
        clientRunner.runClient(productName, productQuota);
    }
}
