import java.util.Stack;

class SortStackRecursion {

    static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sortStack(stack);
            insertSorted(stack, temp);
        }
    }

    static void insertSorted(Stack<Integer> stack, int value) {
        if (stack.isEmpty() || value > stack.peek()) {
            stack.push(value);
            return;
        }
        int temp = stack.pop();
        insertSorted(stack, value);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(10);
        stack.push(20);
        stack.push(5);

        sortStack(stack);
        System.out.println("Sorted Stack: " + stack);
    }
}
