import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.*;
import uk.ac.soton.ecs.comp1206.labtestlibrary.recursion.Tuple;

public class Factory implements SeatFactory{

    @Override
    public Tuple<Class<? extends Seat>, Class<? extends Seat>> getSeats() {
        return null;
    }
}
