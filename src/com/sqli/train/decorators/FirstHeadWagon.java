package com.sqli.train.decorators;

import com.sqli.train.AbstractTrain;
	/**
	 * Concrete decoration with a first head wagon
	 * @author Mohamed EL YAAKOUBI
	 *
	 */
public class FirstHeadWagon extends TrainDecorator{

	public FirstHeadWagon(AbstractTrain train) {
		super(train);
	}
   
	@Override
	public String print() {
		return train.print() + "HHHH>";
	}

}
