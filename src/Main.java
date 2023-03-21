import java.util.*;

public class Main {
    static List<String> basket = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static Scanner scannerAdd = new Scanner(System.in);
    public static Scanner scannerDelete = new Scanner(System.in);
    public static Scanner scannerFind = new Scanner(System.in);

    public static void addItem() {
        System.out.println("Какую покупку хотите добавить?");
        String inputAdd = scannerAdd.nextLine();
        basket.add(inputAdd);
        System.out.println("Итого в списке покупок: " + basket.size());
    }

    public static void showItem() {
        System.out.println("Список покупок:");
        for (int i = 0; i < basket.size(); i++) {
            System.out.println(i + 1 + ". " + basket.get(i));
        }
        System.out.println("-----");
    }


    public static void deleteItem() {
        showItem();
        System.out.println("Какую хотите удалить? Выберите номер или название");
        String inputDelete = scannerDelete.nextLine();
        try {
            int intInputDelete = Integer.parseInt(inputDelete) - 1;
            System.out.println("Покупка \"" + basket.get(intInputDelete) + "\" удалена.");
            basket.remove(intInputDelete);
        } catch (NumberFormatException exception) {
            System.out.println("Покупка \"" + inputDelete + "\" удалена.");
            basket.remove(inputDelete);
        }
        showItem();
    }

    public static void findItem() {
        System.out.println("Введите текст для поиска");
        String inputFind = scannerFind.nextLine();
        System.out.println("Найдено:");
        int check = 0;
        for (int i = 0; i < basket.size(); i++) {
            if (basket.get(i).toLowerCase().contains(inputFind.toLowerCase())) {
                System.out.println(i + 1 + ". " + basket.get(i));
                check++;
            }
        }
        if (check == 0) {
            System.out.println("совпадений 0...");
        }
        System.out.println("------");
    }

    public static void main(String[] args) {
        System.out.println("Выберите нужную операцию");

        while (true) {
            System.out.println("""
                    1. Добавить\s
                    2. Показать\s
                    3. Удалить\s
                    4. Найти\s
                    99. Выйти""");
                int input = scanner.nextInt();
                if (input == 99) {
                    System.out.println("Программа завершена!");
                    break;
                }
                switch (input) {
                    case 1 -> addItem();
                    case 2 -> showItem();
                    case 3 -> deleteItem();
                    case 4 -> findItem();
                }


        }
    }
}