package objective;

import objective.exceptions.WrongInputException;

import java.time.LocalDateTime;

public class DailyO extends Objective implements Repeatable {
    public DailyO(String name, String description, TaskType tasktype, LocalDateTime time) throws WrongInputException {
        super(name, description, tasktype, time);
    }

    @Override
    public boolean checkIfSuitable(LocalDateTime requestedDate) {
        return true;
    }

}
