package com.ohgiraffers.section01.xmlconfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MenuController menuController = new MenuController();

        do{
            System.out.println("============Manege Menu============");
            System.out.println("1. Show All Menu");
            System.out.println("2. Find Menu By MenuCode");
            System.out.println("3. Add Menu");
            System.out.println("4. Modify Menu");
            System.out.println("5. Delete Menu");
            System.out.println("Please Choose an Opntion: ");
            int no = sc.nextInt();

            switch (no){
                case 1: menuController.findAllMenus(); break;
                case 2: menuController.findMenuByMenuCode(inputMenuCode()); break;
                case 3: menuController.registMenu(inputMenu()); break;
                case 4: menuController.modifyMenu(inputModifyMenu()); break;
                case 5: menuController.removeMenu(inputMenuCode()); break;
                default:
                    System.out.println("You've chosen a wrong option.");
                    break;
            }

        } while (true);
    }

    private static Map<String, String> inputMenuCode(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter Menu Code: ");
        String menuCode = sc.nextLine();

        //http는 파라미터를 key&value 방식으로 처리
        Map<String, String> parameter = new HashMap<String, String>();
        parameter.put("menuCode", menuCode);

        return parameter;
    }

    private static Map<String, String> inputMenu(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Menu Name : ");
        String menuName = sc.nextLine();
        System.out.println("Enter Menu Price  ");
        String menuPrice = sc.nextLine();
        System.out.println("Enter Category Code : ");
        String categoryCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("menuName", menuName);
        parameter.put("menuPrice", menuPrice);
        parameter.put("categoryCode", categoryCode);

        return parameter;
    }

    private static Map<String, String> inputModifyMenu(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Manu Code that you want to Modify : ");
        String menuCode = sc.nextLine();
        System.out.println("Enter Menu Name that you want to Modify : ");
        String menuName = sc.nextLine();
        System.out.println("Enter Menu Price that you want to Modify : ");
        String menuPrice = sc.nextLine();
        System.out.println("Enter Category Code that you want to Modify : ");
        String categoryCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("menuCode", menuCode);
        parameter.put("menuName", menuName);
        parameter.put("menuPrice", menuPrice);
        parameter.put("categoryCode", categoryCode);

        return parameter;
    }
}
