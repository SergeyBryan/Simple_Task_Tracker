package objective;

import objective.exceptions.WrongInputException;

public class IfError {
    public static String validation(String name) throws WrongInputException {
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new WrongInputException("Поле не может быть пустым.");
        } else {
            return name;
        }
    }
}
