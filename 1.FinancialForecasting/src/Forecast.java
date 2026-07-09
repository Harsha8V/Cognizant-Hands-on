public class Forecast {

    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return calculateFutureValue(presentValue + (presentValue * growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        double initialAmount = 1000.0;
        double annualGrowthRate = 0.05;
        int targetYears = 10;

        double futureValue = calculateFutureValue(initialAmount, annualGrowthRate, targetYears);
        System.out.println(futureValue);
    }
}