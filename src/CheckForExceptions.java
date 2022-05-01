public class CheckForExceptions {
    // проверяем 1 инпут на недопустимые знаки

    boolean isDigit(String length) throws NumberFormatException {
        try {
            Integer.parseInt(length);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // проверяем 1 инпут на длину
    boolean checkForInputLength(String length) {
        int len = Integer.parseInt(length);
        return len < 37 && len > 0;
    }

    boolean checkForInputsEquality(String length, String symbols) {
        int len = Integer.parseInt(length);
        int symbolLen = Integer.parseInt(symbols);
        return !(len > symbolLen);
    }

    boolean checkForVariant(String input, int len) {
        return input.length() == len;
    }
}
