package com.sqli.train.decorators;

import com.sqli.train.AbstractTrain;
	/**
	 * Concrete decoration with a loaded cargo
	 * @author Mohamed EL YAAKOUBI
	 *
	 */
public class LoadedCargo extends TrainDecorator{
	
	public LoadedCargo(){}
	

	public LoadedCargo(AbstractTrain train) {
		super(train);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return train.print() + "|^^^^|";
	}

}
