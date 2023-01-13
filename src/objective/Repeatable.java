package objective;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Repeatable {

    boolean checkIfSuitable(LocalDateTime time);

    void setName(String name);

    LocalDateTime getTime();


}