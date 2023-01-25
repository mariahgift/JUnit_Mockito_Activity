public class AdvancedMath {
    private BasicMath basicMath;

    public double multiplyDifferenceBy5(double input1, double input2) {
        double difference = basicMath.subtract(input1, input2);
        return difference * 5;
    }

    public double multiplySumBy5(double input1, double input2) {
        double sum = basicMath.add(input1, input2);
        return sum * 5;
    }

    public double squareOfSum(double input1, double input2) {
        double sum = basicMath.add(input1, input2);
        return sum * sum;
    }

    public double getPercentage(double input1, double input2) {
        return basicMath.divide(input1, input2) * 100;
    }
}
