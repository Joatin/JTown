package com.hotmail.joatin37.JTown;

import java.util.HashMap;

import org.bukkit.Location;

import com.hotmail.joatin37.JTown.exceptions.WrongWorldException;

public class ChunkMap {
	private HashMap<String, Byte[][]> chunkmap;
	private String world;
	private short maxheight;
	private short minheight;
	
	public ChunkMap (){
		chunkmap = new HashMap<String, Byte[][]>();
	}
	public void setMaxHeight(int height){
		maxheight = (short)height;
	}
	public void setMinHeight (int height){
		minheight = (short)height;
	}
	public short getMaxHeight (){
		return maxheight;
	}
	public short getMinHeight (){
		return minheight;
	}
	public void addBlockRow(Location loc)throws WrongWorldException{
		if(loc.getWorld().getName().equals(world)){
			
		}else{
			throw new WrongWorldException();
		}
	}
}
