package com.sqli.train.decorators;

import com.sqli.train.AbstractTrain;
	/**
	 * Concrete decoration with a connector (::)
	 * @author Mohamed EL YAAKOUBI
	 *
	 */
public class WagonConnector extends TrainDecorator{

	public WagonConnector(AbstractTrain train) {
		super(train);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String print() {
		return train.print() + "::";
	}

}
