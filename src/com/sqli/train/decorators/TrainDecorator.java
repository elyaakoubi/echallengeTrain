package com.sqli.train.decorators;

import com.sqli.train.AbstractTrain;
	/**
	 * Train abstract decorator.
	 * @author Mohamed EL YAAKOUBI
	 */
public abstract class TrainDecorator extends AbstractTrain {
	
	protected AbstractTrain train;


	public TrainDecorator() {
		super();
	}

	public TrainDecorator(AbstractTrain train) {
		this.train = train;
	}

	public AbstractTrain getTrain() {
		return train;
	}

	public void setTrain(AbstractTrain train) {
		this.train = train;
	}
	
    public void removeDecorator(TrainDecorator toremove){
    	if(train == null)
    		return;
    	else if (train.equals(toremove))
    		train = ((TrainDecorator) train).getTrain();
    	else
    	         ((TrainDecorator) train).removeDecorator(toremove);
    }	
     
}
