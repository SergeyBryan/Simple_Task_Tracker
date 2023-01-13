package objective;

import objective.exceptions.WrongInputException;

import java.time.LocalDateTime;

public class WeeklyO extends Objective implements Repeatable{
    public WeeklyO(String name, String description, TaskType tasktype, LocalDateTime time) throws WrongInputException {
        super(name, description, tasktype, time);
    }

    @Override
    public boolean checkIfSuitable(LocalDateTime requestedTime) {
       return getTime().getDayOfWeek().equals(requestedTime.getDayOfWeek());
    }
}
