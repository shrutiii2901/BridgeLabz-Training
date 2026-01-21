class StandardRoom implements PricingStrategy {
    public double calculatePrice(int days) {
        return days * 2000;
    }
}