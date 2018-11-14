package com.sqli.train.decorators;

import com.sqli.train.AbstractTrain;
	/**
	 * Concrete decoration with a last head wagon
	 * @author Mohamed EL YAAKOUBI
	 *
	 */
public class LastHeadWagon extends TrainDecorator{

	public LastHeadWagon(AbstractTrain train) {
		super(train);
	}
   
	@Override
	public String print() {
		return train.print() + "<HHHH";
	}

}
