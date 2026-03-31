class NormalPricing  implements PricingStrategy{
    public  double calculatePrice(double units){
        return units * 5;
    }   
}
