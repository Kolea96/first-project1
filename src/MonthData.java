

class MonthData {
    int[] days = new int[30];


    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < 30; i++)
            System.out.println(" " + (i + 1) + " день: " + days[i]);


    }

    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < 30; i++) {
            sumSteps = sumSteps + days[i]; // подсчёт суммы элементов массива days[]
        }
        return sumSteps;
    }

    int maxSteps() {
        int maxSteps = 0;
        int temp;
        for (int i = 0; i < 30; i++) {
            if (maxSteps < days[i])
                maxSteps = days[i];// поиск максимального элемента
        }
        return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay) {
        int bestSession = 0;
        int countBest = 0;
        for (int steps : days) {
            if (steps >= goalByStepsPerDay) {
                if (++countBest > bestSession) {
                    bestSession = countBest;
                } else {
                    countBest = 0;
                }
            }
        }
        return bestSession;
    }
}






