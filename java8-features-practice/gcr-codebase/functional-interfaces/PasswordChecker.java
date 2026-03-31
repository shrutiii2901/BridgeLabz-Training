interface SecurityUtils {

    static boolean checkPassword(String password) {
        return password.length() >= 8;
    }
}

public class PasswordChecker {
    public static void main(String[] args) {
        System.out.println(SecurityUtils.checkPassword("Admin123"));
    }
}
