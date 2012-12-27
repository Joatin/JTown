package com.hotmail.joatin37.JTown.worldmap;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.Vector;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.hotmail.joatin37.JTown.JTown;
import com.hotmail.joatin37.JTown.worldmap.WorldMap.chunk;
import com.hotmail.joatin37.JTown.worldmap.WorldMap.chunk.blockrow;

public class WorldMap {
	
	private HashMap<String, chunk>chunks;
	private final JTown jtown;
	private final String world;
	FileConfiguration config;
	File configfile;

	public WorldMap(JTown jtown, String world){
		this.jtown=jtown;
		this.world=world;
		load();
	}
	
	private void load(){
		if (configfile == null) {
			configfile = new File(jtown.getDataFolder(), "world-"+world+".sav");
		    }
		    config = YamlConfiguration.loadConfiguration(configfile);
		    List<String>list=config.getStringList("chunks");
		    if(list==null)return;
		    Iterator<String> iterator = list.listIterator();
		    while(iterator.hasNext()){
		    	String s = iterator.next();
		    	chunks.put(s, new chunk(config, s));
		    }
	}
	
	public void save() {
		if (config == null || configfile == null) {
	    return;
	    }
		Iterator<chunk> iterator = chunks.values().iterator();
		List<String>list = new Vector<String>(100, 50);
		while(iterator.hasNext()){
			list.add(iterator.next().save(config));
		}
		config.set("chunks", list);
		
	    try {
	    	config.save(configfile);
	    	jtown.getLogger().info("Succesfully saved world-"+world+".sav");
	    } catch (IOException ex) {
	    	jtown.getLogger().log(Level.SEVERE, "Could not save config to " + configfile, ex);
	    }
	}
	
	public class chunk{
		private final String chunkname;
		private final int posx;
		private final int posz;
		private HashMap<String, blockrow>blockrows;
		
		private chunk(FileConfiguration config, String chunkname){
			blockrows=new HashMap<String, blockrow>(256);
			this.chunkname=chunkname;
			String[] s = chunkname.split(";");
			posx=Integer.parseInt(s[0]);
			posz=Integer.parseInt(s[1]);
			List<String>list=config.getStringList(chunkname+"blockrows");
			if(list==null)return;
			Iterator<String> iterator = config.getStringList(chunkname+"blockrows").listIterator();
			while(iterator.hasNext()){
				String s2 = iterator.next();
				blockrows.put(s2, new blockrow(config, chunkname, s2));
			}
			
		}
		
		public String save(FileConfiguration config){
			Iterator<blockrow> iterator = blockrows.values().iterator();
			List <String> list = new Vector<String>(256, 0);
			while(iterator.hasNext()){
				list.add(iterator.next().save());
			}
			config.set(chunkname+"blockrows", list);
			return chunkname;
		}
		
		public class blockrow{
			private final String blockname;
			private final int posx;
			private final int posz;
			private int maxheight;
			private int minheight;
			private int collection;
			private int baseland;
			private int plot;
			
		private blockrow(FileConfiguration config, String chunkname, String blockname){
			this.blockname=blockname;
			String[] s1 = blockname.split(";");
			posx=Integer.parseInt(s1[0]);
			posz=Integer.parseInt(s1[1]);
			maxheight = config.getInt(chunkname+"."+blockname+".maxheight");
			minheight = config.getInt(chunkname+"."+blockname+".minheight");
			collection = config.getInt(chunkname+"."+blockname+".collection");
			baseland = config.getInt(chunkname+"."+blockname+".baseland");
			plot = config.getInt(chunkname+"."+blockname+".plot");
		}
		public String save(){
			config.set(chunkname+"."+blockname+".maxheight", maxheight);
			config.set(chunkname+"."+blockname+".minheight", minheight);
			config.set(chunkname+"."+blockname+".collection", collection);
			config.set(chunkname+"."+blockname+".baseland", baseland);
			config.set(chunkname+"."+blockname+".plot", plot);
			
			return blockname;
		}
			
		}
	}
}
