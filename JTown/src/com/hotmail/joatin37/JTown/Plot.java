package com.hotmail.joatin37.JTown;

public abstract class Plot {

	private final BaseLand parentland;
	
	protected Plot(BaseLand parentland){
		this.parentland=parentland;
	}
	
	protected BaseLand getParent(){
		return parentland;
	}
	
	public abstract String getName();
}
