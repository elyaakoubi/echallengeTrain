package com.sqli.train.decorators;

import com.sqli.train.AbstractTrain;
		/**
		 * Concrete decoration with a restaurant wagon
		 * @author Mohamed EL YAAKOUBI
		 *
		 */
public class RestaurantWagon extends TrainDecorator{

	public RestaurantWagon(AbstractTrain train) {
		super(train);
	}
   
	@Override
	public String print() {
		return train.print() + "|hThT|";
	}

}
