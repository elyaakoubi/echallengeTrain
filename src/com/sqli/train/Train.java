package com.sqli.train;

import java.util.List;

import com.sqli.train.decorators.EmptyCargo;
import com.sqli.train.decorators.FirstHeadWagon;
import com.sqli.train.decorators.LastHeadWagon;
import com.sqli.train.decorators.LoadedCargo;
import com.sqli.train.decorators.PassengerWagon;
import com.sqli.train.decorators.RestaurantWagon;
import com.sqli.train.decorators.TrainDecorator;
import com.sqli.train.decorators.WagonConnector;

/**
 * Train.
 *
 * @author Mohamed El yaakoubi
 */

public class Train extends AbstractTrain {
	
	
	private AbstractTrain emptytrain;
	private AbstractTrain lastConnector;

	/**
	 * the train constructor 
	 * @param train : representation 
	 */
	public Train(String train){
		// empty train
		emptytrain = new EmptyTrain();
		
		// decorate emptytrain according to its specific representation 
		for(int i = 0; i < train.length(); i++)
		{	if( i !=0)
			emptytrain = new WagonConnector(emptytrain);
		
		    /**
		     * if i equals to 1 the wagon is a connector 
		     * and it is the last connector
		     */
		    if(i==1)
		    	lastConnector = emptytrain;
			
			if (train.charAt(i) == 'H' && i == 0) 
				{
				emptytrain = new LastHeadWagon(emptytrain);
				}
			    
			if (train.charAt(i) == 'H' && i==train.length()-1) 
				{
				emptytrain = new FirstHeadWagon(emptytrain);				
				}
			
			if (train.charAt(i) == 'P' && i != 0) 
				emptytrain = new PassengerWagon(emptytrain);
			
			if (train.charAt(i) == 'R' && i != 0) 
				emptytrain = new RestaurantWagon(emptytrain);
			if (train.charAt(i) =='C' && i != 0)
				emptytrain = new EmptyCargo(emptytrain);
		}			
	}

	/**
	 * detach the last wagon and its connector
	 */
	public void detachEnd(){
		emptytrain= ((TrainDecorator) emptytrain).getTrain();		
		emptytrain= ((TrainDecorator) emptytrain).getTrain();
	}

	/**
	 * Detach the first wagon (Head wagon) and its connector
	 */
	public void detachHead()
	{
		AbstractTrain temp = emptytrain; 
		
			while( (  (TrainDecorator) temp).getTrain().equals(lastConnector)==false)
				{
				/**
				 * temp move to the next part of train
				 * a part of train can be either a wagon or a connector
				 */
				temp= ((TrainDecorator) temp).getTrain();	
				}
			    ((TrainDecorator) temp).setTrain(new EmptyTrain());           
	}
	
	/**
	 * Fill the first empty cargo.
	 * @return if any empty cargo found, return true else return false.
	 */

	public boolean fill(){
		AbstractTrain temp = emptytrain; 
		AbstractTrain lastEmptyCargo=null;
		
		while(temp instanceof EmptyTrain == false)
			{
			  if(((TrainDecorator)temp) instanceof EmptyCargo )
			    lastEmptyCargo = temp;
			  temp= ((TrainDecorator) temp).getTrain();	
			}
		
		if( lastEmptyCargo != null  && lastEmptyCargo!=emptytrain)
		{
			temp = emptytrain;
		    while( (  (TrainDecorator) temp).getTrain().equals(lastEmptyCargo)==false)
				{
				temp= ((TrainDecorator) temp).getTrain();	
				}
		
		AbstractTrain loadedCargo = new LoadedCargo();
		/**
		 * replace the empty cargo by a loaded cargo.
		 */
		((TrainDecorator) loadedCargo).setTrain(((TrainDecorator) ((TrainDecorator) temp).getTrain()).getTrain()   );
		((TrainDecorator) temp).setTrain(loadedCargo);
		 
			return true;	
		}
		
		if(lastEmptyCargo==emptytrain)
			/**
			 * the last empty wagon is the first wagon that is referenced by 
			 * the object emtytrain  
			 */
		{
			temp=emptytrain;
			emptytrain = new LoadedCargo(  ((TrainDecorator)emptytrain).getTrain()  );
			return true;
		}
		
		    /**
		    * the last empty wagon is null so it can't be filled 
		    */
		
			return false;
	}
	
	/**
	 * @return Train representation
	 */
	@Override
	public String print() {
		return emptytrain.print();
	}

	public AbstractTrain getEmptytrain() {
		return emptytrain;
	}

	public void setEmptytrain(AbstractTrain emptytrain) {
		this.emptytrain = emptytrain;
	}
	
}
