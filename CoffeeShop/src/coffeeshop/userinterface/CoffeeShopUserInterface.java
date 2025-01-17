package coffeeshop.userinterface;

import java.util.Scanner;

public class CoffeeShopUserInterface {

    private enum CoffeeShopUserInterfacePage {
        MAIN,
        MENU,
        ORDER
    }

    private enum CoffeeShopUserInterfaceOption {
        MENU,
        ORDER,
        QUIT,
        BACK,
        INVALID
    }

    private CoffeeShopUserInterfacePage currentPage;
    private Scanner scanner;

    public CoffeeShopUserInterface() {
        this.currentPage = CoffeeShopUserInterfacePage.MAIN;
        this.scanner = new Scanner(System.in);
    }

    public void welcome() {
        System.out.println("Welcome to Coffee Shop!");
    }

    public void show() {
        displayOptions(this.currentPage);
        CoffeeShopUserInterfaceOption option = getOption(this.currentPage);
        while (option != CoffeeShopUserInterfaceOption.QUIT) {
            if (option == CoffeeShopUserInterfaceOption.INVALID) {
                System.out.println("Invalid option");
            } else {
                handleOption(option);
            }

            displayOptions(this.currentPage);
            option = getOption(this.currentPage);
        }
    }

    public void close() {
        this.scanner.close();
    }

    private void displayOptions(CoffeeShopUserInterfacePage page) {
        switch (page) {
            case MAIN:
                System.out.println("m: menu");
                System.out.println("o: order");
                System.out.println("q: quit");
                break;
            case MENU:
                System.out.println("b: back");
                System.out.println("q: quit");
                break;
            case ORDER:
                System.out.println("b: back");
                System.out.println("q: quit");
                break;
            default:
                break;
        }
    }

    private CoffeeShopUserInterfaceOption getOption(CoffeeShopUserInterfacePage page) {
        String line = this.scanner.nextLine().trim().toLowerCase();
        switch (page) {
            case MAIN:
                if (line.equals("m")) {
                    return CoffeeShopUserInterfaceOption.MENU;
                } else if (line.equals("o")) {
                    return CoffeeShopUserInterfaceOption.ORDER;
                } else if (line.equals("q")) {
                    return CoffeeShopUserInterfaceOption.QUIT;
                } else {
                    return CoffeeShopUserInterfaceOption.INVALID;
                }
            case MENU:
                if (line.equals("b")) {
                    return CoffeeShopUserInterfaceOption.BACK;
                } else if (line.equals("q")) {
                    return CoffeeShopUserInterfaceOption.QUIT;
                } else {
                    return CoffeeShopUserInterfaceOption.INVALID;
                }
            case ORDER:
                if (line.equals("b")) {
                    return CoffeeShopUserInterfaceOption.BACK;
                } else if (line.equals("q")) {
                    return CoffeeShopUserInterfaceOption.QUIT;
                } else {
                    return CoffeeShopUserInterfaceOption.INVALID;
                }
            default:
                return CoffeeShopUserInterfaceOption.INVALID;
        }
    }

    private void handleOption(CoffeeShopUserInterfaceOption option) {
        switch (option) {
            case MENU:
                System.out.println("List of menu items:");
                this.currentPage = CoffeeShopUserInterfacePage.MENU;
                break;
            case ORDER:
                System.out.println("What would you like to order?");
                this.currentPage = CoffeeShopUserInterfacePage.ORDER;
                break;
            case BACK:
                this.currentPage = CoffeeShopUserInterfacePage.MAIN;
                break;
            default:
                break;
        }
    }
}
