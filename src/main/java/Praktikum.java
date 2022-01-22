public class Praktikum {

    public static void main(String[] args) {

        String name = "Имя Фамилия";

        Account account = new Account(name);
        if (account.checkNameToEmboss()) {
            System.out.println("Печатаем");
        } else {
            System.out.println("Ошибка");
        }

    }

}