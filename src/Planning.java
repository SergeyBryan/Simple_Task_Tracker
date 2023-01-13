import objective.*;
import objective.exceptions.WrongInputException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Planning {
    private final static Map<Integer, Repeatable> planOfDay = new HashMap<>();


    public static void inputTask(Scanner scanner) {
        try {
            scanner.nextLine();
            System.out.print("Введите название задачи: \n");
            String taskName = IfError.validation(scanner.nextLine());
            System.out.print("Введите описание задачи: \n");
            String taskDescription = IfError.validation(scanner.nextLine());
            System.out.print("Введите тип задачи: 0 - личная, 1 - рабочая \n");
            TaskType tasktype = TaskType.values()[scanner.nextInt()];
            System.out.print("Введите повторяемость задачи: 0 - однократная, 1 - ежедневная, 2 - еженедельная, 3 - ежемесячная, 4 - ежегодная \n");
            int duration = scanner.nextInt();
            System.out.print("Введите дату задачи в формате 'dd.MM.yyyy HH:mm' \n");
            scanner.nextLine();
            createEvent(scanner, taskName, taskDescription, tasktype, duration);
            System.out.println("Для выхода нажмите Enter\n");
            scanner.nextLine();
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createEvent(Scanner scanner, String name, String description, TaskType tasktype, int duration) {
        try {
            LocalDateTime create = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
            Repeatable task = null;
            try {
                task = createTask(duration, name, description, tasktype, create);
                System.out.println("Создана задача " + task);
            } catch (WrongInputException e) {
                System.out.println(e.getMessage());
            }
        } catch (DateTimeParseException e) {
            System.out.println("Проверье правильность заполнения даты");
            createEvent(scanner, name, description, tasktype, duration);
        }
    }

    private static Repeatable createTask(int duration, String name, String description, TaskType taskType, LocalDateTime localDateTime) throws WrongInputException {
        return switch (duration) {
            case 0 -> {
                SingleO singleO = new SingleO(name, description, taskType, localDateTime);
                planOfDay.put(singleO.getId(), singleO);
                yield singleO;
            }
            case 1 -> {
                DailyO task = new DailyO(name, description, taskType, localDateTime);
                planOfDay.put(task.getId(), task);
                yield task;
            }
            case 2 -> {
                WeeklyO task = new WeeklyO(name, description, taskType, localDateTime);
                planOfDay.put(task.getId(), task);
                yield task;
            }
            case 3 -> {
                MontlyO task = new MontlyO(name, description, taskType, localDateTime);
                planOfDay.put(task.getId(), task);
                yield task;

            }
            case 4 -> {
                YearlyO task = new YearlyO(name, description, taskType, localDateTime);
                planOfDay.put(task.getId(), task);
                yield task;
            }
            default -> null;
        };
    }

    public static void printObjects() {
        for (Map.Entry<Integer, Repeatable> integerObjectiveEntry : planOfDay.entrySet()) {
            System.out.println(integerObjectiveEntry.getKey() + "  : " + integerObjectiveEntry.getValue());
        }
    }

    public static void deleteObjective(Scanner scanner) {
        System.out.println("Текущие задачи");
        printObjects();
        System.out.println("Введите ID события, чтобы удалить ");
        int idNumber = scanner.nextInt();
        if (planOfDay.containsKey(idNumber)) {
            System.out.println("Задача " + idNumber + " была удалена");
            planOfDay.remove(idNumber);
        } else {
            System.out.println("Задача с ID " + idNumber + " не существует");
        }
    }

    public static void getObjectiveByDay(Scanner scanner) {
        System.out.println("Введите дату dd.MM.yyyy:");
        try {
            String date = scanner.next();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate requstedDate = LocalDate.parse(date, dateFormatter);
            List<Repeatable> foundEvents = findTaskByDate(requstedDate);
            System.out.println("События на " + requstedDate + ":");
            for (Repeatable task : foundEvents) {
                System.out.println(task);
            }
        } catch (DateTimeParseException e) {
            System.out.println("Формат даты должен быть введён в формате dd.MM.yyyy:");
        }
        scanner.nextLine();
        System.out.println("Для выхода нажмите Enter\n");
    }

    private static List<Repeatable> findTaskByDate(LocalDate date) {
        List<Repeatable> objectives = new ArrayList<>();
        for (Repeatable objective : planOfDay.values()) {
            if (objective.checkIfSuitable(date.atStartOfDay())) {
                objectives.add(objective);
            }
        }
        return objectives;
    }
}
