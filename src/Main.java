import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CheckForExceptions check = new CheckForExceptions();
        System.out.println("Input the length of the secret code:");
        String length = scanner.nextLine();
        // Проверяем на то, чтобы в 1 вводе были только цифры
        if (check.isDigit(length)) {
            // Проверяем на максимальную длину строки для угадывания
            if (check.checkForInputLength(length)) {
                int len = Integer.parseInt(length);
                System.out.println("Input the number of possible symbols in the code:");
                String symbols = scanner.nextLine();

                // Проверяем на то, чтобы во 2 вводе были только цифры
                if (check.isDigit(symbols)) {
                    // Проверяем на максимальные символы для угадывания
                    if (check.checkForInputLength(symbols)) {
                        int symbolsLen = Integer.parseInt(symbols);
                        // Проверяем, чтобы второй ввод был больше или равен первому, иначе не хватит символов
                        if (check.checkForInputsEquality(length, symbols)) {
                            RandomNumber random = new RandomNumber(len, symbolsLen);
                            //Генерируем рандомное число
                            random.randomNumber();
                            Evaluator evaluator = new Evaluator();
                            // Циклим до победы
                            while (random.getNumberLength() != evaluator.getBulls()) {
                                //Получаем пользовательское число + считаем какой ход
                                evaluator.getPlayerNumber();
                                if (check.checkForVariant(evaluator.getPersonNumber(), len)) {
                                    // Смотрим сколько коров и быков
                                    evaluator.checker();
                                    // Печатаем
                                    evaluator.printer();
                                } else {
                                    System.out.println("Error: Wrong input");
                                    break;
                                }

                            }
                        } else {
                            System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols.", len, symbolsLen);
                        }
                    } else {
                        System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                    }
                } else {
                    System.out.printf("Error: \"%s\" isn't a valid number.", symbols);
                }
            } else {
                System.out.println("Error: maximum length of the secret code is 36");
            }
        } else {
            System.out.printf("Error: \"%s\" isn't a valid number.", length);
        }
    }
}

