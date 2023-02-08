
import java.util.Scanner;

class StepTracker {

    int goalByStepsPerDay = 10000;
    Scanner scanner;

    Converter converter = new Converter();

    MonthData[] monthToData;


    StepTracker(Scanner scan) {

        scanner = scan;
        monthToData = new MonthData[12];
        for (int i = 0; i < 12; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");

        int month = scanner.nextInt();
        if (month < 0 || month > 11) {
            System.out.println(" Ошибка , введите номер месяца от 0 до 11");
            return;// ввод и проверка номера месяца
        }
        System.out.println("Введите день от 1 до 30 (включительно)");
        int day = scanner.nextInt();
        if (day < 1 || day > 30) {
            System.out.println(" Ошибка , введите номер месяца от 1 до 30");
            return;// ввод и проверка дня
        }

        System.out.println("Введите количество шагов");
        int steps = scanner.nextInt();
        if (steps < 1) {
            System.out.println(" Количество шагов должно быть больше 0 ");
            return;// ввод и проверка количества шагов
        }

        // сохранение данных
        MonthData monthData = monthToData[month];

        monthData.days[day - 1] = steps;
    }

    void changeStepGoal() {
        System.out.println(" Поставьте цель :");
        int target = scanner.nextInt();
        if (target <= 0) {
            System.out.println(" Цель должна быть больше 0");
        } else {
            goalByStepsPerDay = target;
        }
    }

    void printStatistic() {
        System.out.println("Введите номер месяца");

        int month = scanner.nextInt();


        printMonth(month);

// получение соответствующего месяца
        MonthData monthData = monthToData[month];


        System.out.println("Вывод общей статистики");
        monthData.printDaysAndStepsFromMonth();
        System.out.println("За выбраный месяц вы прошли : " + monthData.sumStepsFromMonth() + " шагов");
        System.out.println("Максимальное количество шагов за месяц: " + monthData.maxSteps() + " шагов");
        System.out.println("Среднее каличество шагов : " + ((monthData.sumStepsFromMonth()) / 30));
        System.out.println("Пройденные шаги в Км : " + converter.convertToKm(monthData.sumStepsFromMonth()));

        System.out.println("За месяц сожгли килокалорий :" + converter.convertStepsToKilocalories(monthData.sumStepsFromMonth()));

        System.out.println("Лучшая серия " + monthData.bestSeries(goalByStepsPerDay));
        System.out.println();
    }
    void printMonth (int month){
        if (month < 0 || month > 12) System.out.println("Такого месяца не существует");
    }


}



