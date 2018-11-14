package com.sqli.train.decorators;

import com.sqli.train.AbstractTrain;
	/**
	 * Concrete decoration with a empty cargo
	 * @author Mohamed EL YAAKOUBI
	 *
	 */
public class EmptyCargo extends TrainDecorator{

	public EmptyCargo(AbstractTrain train) {
		super(train);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return train.print() + "|____|";
	}

}
