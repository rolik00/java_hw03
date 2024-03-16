import java.time.DateTimeException;
import java.util.*;
import java.time.LocalDate;
import java.time.Period;

public class Main {
    private static String get_gender(String patronymic)
    {
        int n = patronymic.length();
        if (patronymic.substring(n - 2, n).equals("на")) return "женский";
        return "мужской";
    }
    private static int full_age(String date)
    {
        String[] date_parts = date.split("\\.");
        int d = Integer.parseInt(date_parts[0]);
        int m = Integer.parseInt(date_parts[1]);
        int y = Integer.parseInt(date_parts[2]);
        LocalDate current_date = LocalDate.now();
        int year = -1;
        try
        {
            LocalDate brith_date = LocalDate.of(y, m, d);
            Period difference = Period.between(brith_date, current_date);
            year = difference.getYears();
        }
        catch (DateTimeException ex) {
            System.out.println("Неверно введена дата! (Такой даты не существует)");
        }
        return year;
    }
    private static void print(String info)
    {
        String[] parts = info.split(" ");
        String gender = get_gender(parts[2]);
        int age = full_age(parts[3]);
        if (age == -1) return;
        System.out.println("ФИО: " + parts[0] + " " + parts[1].charAt(0) + parts[2].charAt(0));
        System.out.println("Пол: " + gender);
        System.out.println("Полный возраст: " + age + " лет");
    }
    public static void main(String[] args) {
        System.out.println("Введите Фамилию, Имя, Отчество и дату рождения: ");
        Scanner scanner = new Scanner(System.in);
        String info = scanner.nextLine();
        print(info);
    }
}
