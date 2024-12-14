package com.narendra.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {

    public static void main(String[] args) {
        Waiter waiter = new Waiter(Arrays.asList(new PancakeHouseMenu(), new DineMenu()));
        waiter.printMenu();
    }
}

class Waiter {

    List<Menu> menus;

    Waiter(List<Menu> menus) {
        this.menus = menus;
    }

    void printMenu() {
        for(Menu menu : menus) {
            Iterator<MenuItem> menuIterator = menu.createIterator();

            printMenuItems(menuIterator);
            System.out.println();
        }
    }

    private void printMenuItems(Iterator<MenuItem> pancakeItems) {
        while(pancakeItems.hasNext()) {
            System.out.println(pancakeItems.next());
        }
    }
}

class MenuItem {

    private String title;
    private String description;
    private double price;

    MenuItem(String title, String description, double price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return title + " => " + description + " => " + price;
    }
}
interface Menu {
    Iterator<MenuItem> createIterator();
}

class PancakeHouseMenu implements Menu{

    private List<MenuItem> menuItems;

    PancakeHouseMenu() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Idly", "Idly with chutny", 2.0));
        menuItems.add(new MenuItem("Dosa", "Plain Dosa", 2.0));
        menuItems.add(new MenuItem("Poori", "Masala Puri", 2.0));
    }

    @Override
    public Iterator<MenuItem> createIterator() {
        return menuItems.iterator();
    }
}

class DineMenu implements Menu{

    private MenuItem[] menuItems;

    DineMenu() {
        menuItems = new MenuItem[]{
                new MenuItem("Veg rice", "Veg rice", 2.0),
                new MenuItem("Non Veg rice", "Non Veg rice", 2.0)
        };
    }

    @Override
    public Iterator<MenuItem> createIterator() {
        return new DineMenuIterator(menuItems);
    }
}

class DineMenuIterator implements Iterator<MenuItem> {

    private MenuItem[] menuItems;
    int position = 0;

    DineMenuIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        if(position >= menuItems.length) {
            return false;
        }
        return true;
    }

    @Override
    public MenuItem next() {
        if(hasNext()) {
            position ++;
            return menuItems[position - 1];
        }
        return null;
    }
}
