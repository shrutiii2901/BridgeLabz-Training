import java.util.*;

interface MealPlan {
    void prepare();
}

class VegetarianMeal implements MealPlan {
    public void prepare() {
        System.out.println("Vegetarian meal prepared");
    }
}

class VeganMeal implements MealPlan {
    public void prepare() {
        System.out.println("Vegan meal prepared");
    }
}

class MealUtil {
    static <T extends MealPlan> void generateMeal(T meal) {
        meal.prepare();
    }
}

public class MealMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Choose meal (1-Vegetarian, 2-Vegan): ");
        int choice = sc.nextInt();

        if (choice == 1)
            MealUtil.generateMeal(new VegetarianMeal());
        else if (choice == 2)
            MealUtil.generateMeal(new VeganMeal());
        else
            System.out.println("Invalid choice");
    }
}
