import com.sqli.train.EmptyTrain;
import com.sqli.train.Train;
import com.sqli.train.AbstractTrain;
import com.sqli.train.decorators.LastHeadWagon;
import com.sqli.train.decorators.PassengerWagon;
import com.sqli.train.decorators.RestaurantWagon;
import com.sqli.train.decorators.TrainDecorator;

public class Test {
	public static void main(String[] args) {
		//Train train = new Train("HPRH");
		
		AbstractTrain train = new EmptyTrain();
		
		train = new LastHeadWagon(train);
		
		train = new PassengerWagon(train);
	
		train = new RestaurantWagon(train);
		
		TrainDecorator tr = (TrainDecorator) train;
		
	    ((TrainDecorator) train).removeDecorator(tr);
		
	    System.out.println(train.print());
	
	}
}
