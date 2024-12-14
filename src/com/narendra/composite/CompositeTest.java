package com.narendra.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeTest {

    public static void main(String[] args) {
        MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
        MenuComponent dinerMenu = new Menu("DINER MENU", "Lunch");
        MenuComponent cafeMenu = new Menu("CAFE MENU", "Dinner");
        MenuComponent desertMenu = new Menu("DESERT MENU", "Dinner");

        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");

        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        dinerMenu.add(new MenuItem("Pasta", "Spaghetti with marinara sauce", true, 3.89));

        dinerMenu.add(desertMenu); //Adding MenuComponent to another MenuComponent. Both are of types Menu (Composite)

        desertMenu.add(new MenuItem("Apple pie", "Apple pie with crust", true, 1.59));

        Waitress waitress = new Waitress(allMenus);
        waitress.printMenu();

    }
}

class Waitress {
    MenuComponent allMenus;

    Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    void printMenu() {
        allMenus.print();
    }
}

abstract class MenuComponent {
    void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    String getName() {
        throw new UnsupportedOperationException();
    }

    String getDescription() {
        throw new UnsupportedOperationException();
    }

    double price() {
        throw new UnsupportedOperationException();
    }

    boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }

    void print() {
        throw new UnsupportedOperationException();
    }
}

class MenuItem extends MenuComponent {
    String name;
    String description;
    boolean vegetarian;
    double price;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    void print() {
        System.out.println(" " + getName());
        if(isVegetarian()) {
            System.out.println(" v ");
        }

        System.out.println(" " + getPrice());
        System.out.println("    -- " + getDescription());
    }
}

class Menu extends MenuComponent {
    List<MenuComponent> menuComponents = new ArrayList<>();
    String name;
    String description;

    Menu(String name, String description) {
        this.description = description;
        this.name = name;

    }

    @Override
    void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    void print() {
        System.out.println("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("-------------------------");

        for(MenuComponent menuComponent : menuComponents) {
            menuComponent.print();
        }
    }
}