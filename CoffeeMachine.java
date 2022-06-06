package machine;

import java.util.Scanner;

import static machine.States.*;

enum States {
    ESPRESSO("1"),
    LATTE("2"),
    CAPPUCCINO("3"),
    BACK("back"),
    BUY("buy"),
    FILL("fill"),
    TAKE("take"),
    REMAINING("remaining"),
    EXIT("exit"),
    START(""),
    PROCESS(""),
    WATER(""),
    MILK(""),
    COFFEE(""),
    CUPS("");

    String name;

    States(String name) {
        this.name = name;
    }
    public static States getState(String str) {
        for (States s : States.values()) {
            if (s.name.equals(str)) {
                return s;
            }
        }
        return null;
    }
}

public class CoffeeMachine {

    static States state1, state2;
    static int water = 400;
    static int milk = 540;
    static int coffee = 120;
    static int cups = 9;
    static int money = 550;
    static boolean power = true;


    public static void machineOutput(String act) {

        Scanner in = new Scanner(System.in);

        if (state1 == START) {
            state1 = States.getState(act);
        }

        switch (state1) {

            case REMAINING: {
                System.out.println("The Coffee machine has:");
                System.out.println(water + " of water");
                System.out.println(milk + " of milk");
                System.out.println(coffee + " of coffee beans");
                System.out.println(cups + " of cups");
                System.out.println(money + " of money");
                System.out.println("Write action (buy, fill, take, remaining, exit)");
                state1 = START;
                break;
            }

            case BUY: {
                if (state2 == START) {
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    state2 = PROCESS;
                    break;
                } else if (state2 == PROCESS) {

                    state2 = States.getState(act);

                    switch (state2) {

                        case ESPRESSO: {

                            if (water < 250) {
                                System.out.println("Sorry, not enough water!");
                                System.out.println("Write action (buy, fill, take, remaining, exit)");
                                state1 = START;
                                state2 = START;
                                break;
                            }
                            if (coffee < 16) {
                                System.out.println("Sorry, not enough coffee beans!");
                                System.out.println("Write action (buy, fill, take, remaining, exit)");
                                state1 = START;
                                state2 = START;
                                break;
                            }
                            if (cups < 1) {
                                System.out.println("Sorry, not enough disposable cups of coffee!");
                                System.out.println("Write action (buy, fill, take, remaining, exit)");
                                state1 = START;
                                state2 = START;
                                break;
                            }
                            water -= 250;
                            coffee -= 16;
                            money += 4;
                            cups--;
                            System.out.println("I have enough resources, making you a coffee!");
                            System.out.println("Write action (buy, fill, take, remaining, exit)");
                            state1 = START;
                            state2 = START;
                            break;
                        }

                        case LATTE: {

                            if (water < 350) {
                                System.out.println("Sorry, not enough water!");
                                System.out.println("Write action (buy, fill, take, remaining, exit)");
                                state1 = START;
                                state2 = START;
                                break;
                            }
                            if (milk < 75) {
                                System.out.println("Sorry, not enough milk!");
                                System.out.println("Write action (buy, fill, take, remaining, exit)");
                                state1 = States.START;
                                break;
                            }
                            if (coffee < 20) {
                                System.out.println("Sorry, not enough coffee beans!");
                                System.out.println("Write action (buy, fill, take, remaining, exit)");
                                state1 = START;
                                state2 = START;
                                break;
                            }
                            if (cups < 1) {
                                System.out.println("Sorry, not enough disposable cups of coffee!");
                                System.out.println("Write action (buy, fill, take, remaining, exit)");
                                state1 = START;
                                state2 = START;
                                break;
                            }

                            water -= 350;
                            milk -= 75;
                            coffee -= 20;
                            money += 7;
                            cups--;
                            System.out.println("I have enough resources, making you a coffee!");
                            System.out.println("Write action (buy, fill, take, remaining, exit)");
                            state1 = START;
                            state2 = START;
                            break;
                        }
                        case CAPPUCCINO: {

                            if (water < 200) {
                                System.out.println("Sorry, not enough water!");
                                System.out.println("Write action (buy, fill, take, remaining, exit)");
                                state1 = START;
                                state2 = START;
                                break;
                            }
                            if (milk < 100) {
                                System.out.println("Sorry, not enough milk!");
                                System.out.println("Write action (buy, fill, take, remaining, exit)");
                                state1 = START;
                                state2 = START;
                                break;
                            }
                            if (coffee < 12) {
                                System.out.println("Sorry, not enough coffee beans!");
                                System.out.println("Write action (buy, fill, take, remaining, exit)");
                                state1 = START;
                                state2 = START;
                                break;
                            }
                            if (cups < 1) {
                                System.out.println("Sorry, not enough disposable cups of coffee!");
                                System.out.println("Write action (buy, fill, take, remaining, exit)");
                                state1 = START;
                                state2 = START;
                                break;
                            }

                            water -= 200;
                            milk -= 100;
                            coffee -= 12;
                            money += 6;
                            cups--;
                            System.out.println("I have enough resources, making you a coffee!");
                            System.out.println("Write action (buy, fill, take, remaining, exit)");
                            state1 = START;
                            state2 = START;
                            break;
                        }
                        case BACK: {
                            state1 = START;
                            state2 = START;
                            System.out.println("Write action (buy, fill, take, remaining, exit)");
                            break;
                        }
                    }
                }
                break;
            }
            case FILL: {
                switch (state2) {
                    case START: {
                        System.out.println("Write how many ml of water do you want to add:");
                        state2 = WATER;
                        break;
                    }
                    case WATER: {
                        water += Integer.parseInt(act);
                        System.out.println("Write how many ml of milk do you want to add:");
                        state2 = MILK;
                        break;
                    }
                    case MILK: {
                        milk += Integer.parseInt(act);
                        System.out.println("Write how many grams of coffee beans do you want to add:");
                        state2 = COFFEE;
                        break;
                    }
                    case COFFEE: {
                        coffee += Integer.parseInt(act);
                        System.out.println("Write how many disposable cups of coffee do you want to add:");
                        state2 = CUPS;
                        break;
                    }
                    case CUPS: {
                        cups += Integer.parseInt(act);
                        System.out.println("Write action (buy, fill, take, remaining, exit)");
                        state2 = START;
                        state1 = START;
                        break;
                    }
                }
                break;
            }

            case TAKE: {
                System.out.println("I gave you $" + money);
                money = 0;
                state1 = States.START;
                System.out.println("Write action (buy, fill, take, remaining, exit)");
                break;
            }

            case EXIT: {
                power = false;
                break;
            }
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        state1 = START;
        state2 = START;

        System.out.println("Write action (buy, fill, take, remaining, exit)");

        while (power) {
            String act = input.nextLine();
            machineOutput(act);
        }

    }
}