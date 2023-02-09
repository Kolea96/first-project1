

class Converter {

    double lengthStep = 0.00075;
    double kilo = 0.05;

    double convertToKm(int steps) {
        double km =  steps * lengthStep ;
        return km;
    }
    double convertStepsToKilocalories(int steps){
        double kilokal = steps * kilo ;

        return kilokal;
    }
}

