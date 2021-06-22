package io.github.demony.forestparktextgame;

import io.github.demony.forestparktextgame.console.GardenPlantConsoleOutput;
import io.github.demony.forestparktextgame.console.PlantConsoleOutput;
import io.github.demony.forestparktextgame.dao.ConnectionDAO;

import java.util.Scanner;

public class App {

//    Что необходимо сделать:
//    1. Создать базу данных в любой СУБД (MySQL, MS SQL, SQLite, PostreSQL и тд) на ваш вкус;
//    2. Организовать доступ к базе данных из вашего приложения используя JDBC и шаблон DAO;
//    3. Релизовать необходимые сервисы, которые будут каки-либо образом использовать данные из
//    таблиц БД (просто получать, получать по параметру, получать в определённом порядке, считать
//    статистику на основе полученных данных и тд);
//    4. Реализовать вывод результатов работы сервисного слоя в консоль;
//    5. Написать тесты для сервисного слоя (TestNG, JUNIT);
//    6. Классы и интерфейсы должны быть хорошо структурированы по пакетам;
//    7. Соблюдать Java Code Conventions;
//
//    Задание 14.
//    Система Парк. Лесник выполняет Указания о высадке (лечении, художественной обработке, уничтожении) Растений.

    public static void main( String[] args){

        GardenPlantConsoleOutput gardenPlant = new GardenPlantConsoleOutput();
        gardenPlant.showAvailableCommands();
        String userAction;
        String userActionMode = "Main";
        while(true){
            System.out.print("" + userActionMode + "> ");
            Scanner scanner = new Scanner(System.in);
            try {
                userAction = scanner.next();
                System.out.println("Your action is -> '" + userAction + "'");
                if (userAction.equals("0")) {
                    break;
                }
                if (userActionMode.equals("Main")) {

                    switch (userAction){
                        case "help":
                            gardenPlant.showAvailableCommands();
                            break;
                        case "10":
                            userActionMode = "SelectPlantForPlanting";
                            PlantConsoleOutput plantConsoleOutput = new PlantConsoleOutput();
                            plantConsoleOutput.outputAllAvailablePlants();
                            break;
                        case "20":
                            System.out.println("userAction '" + userAction + "'");
                            break;
                        case "30":
                            System.out.println("userAction '" + userAction + "'");
                            break;
                        case "40":
                            System.out.println("userAction '" + userAction + "'");
                            break;
                        case "50":
                            gardenPlant.showStatistics();
                            break;
                        default:
                            System.out.println("Action is not not recognized - '" + userAction + "'");
                            break;
                    }

                } else if (userActionMode.equals("SelectPlantForPlanting")) {
                    userActionMode = "Main";
                    gardenPlant.plantThePlant(userAction);
                } else {
                    throw new RuntimeException("Menu corrupted!!! ");
                }
            } catch(Exception e) {
                System.out.println("There are some problems with producing your request. Try something else." + e);
            }
        }
        System.out.println("Bye!");
    }
}
