

class Converter {

    double lengthStep = 0.00075;
    double kilo = 0.05;

    int convertToKm(int steps) {
        double km =  steps * lengthStep ;

        return (int) km;
    }
    int convertStepsToKilocalories(int steps){
        double kilokal = steps * kilo ;

        return (int) kilokal;
    }
}

