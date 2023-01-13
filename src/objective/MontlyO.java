package objective;

import objective.exceptions.WrongInputException;

import java.time.LocalDateTime;

public class MontlyO extends Objective implements Repeatable {
    public MontlyO(String name, String description, TaskType tasktype, LocalDateTime time) throws WrongInputException {
        super(name, description, tasktype, time);
    }

    @Override
    public boolean checkIfSuitable(LocalDateTime requestedDate) {
        return getTime().getDayOfMonth() == requestedDate.getDayOfMonth();
    }
}
