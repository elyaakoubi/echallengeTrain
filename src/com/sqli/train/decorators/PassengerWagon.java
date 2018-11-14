package com.sqli.train.decorators;

import com.sqli.train.AbstractTrain;
		/**
		 * Concrete decoration with a passenger wagon
		 * @author Mohamed EL YAAKOUBI
		 *
		 */
public class PassengerWagon extends TrainDecorator{

	public PassengerWagon(AbstractTrain train) {
		super(train);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return train.print() + "|OOOO|";
	}

}
