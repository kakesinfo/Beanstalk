package eu.beanstalk.api.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

public class Hologram
{
private UUID uuid;
	
	private List<String> titles = new ArrayList<>();
	private ItemStack item = null;
	
	public Location loc;
	
	public Hologram(){
		this.uuid = UUID.randomUUID();
	}
	
	public Hologram withTitle(String title){
		this.titles.add(title.replace("&", "§"));
		return this;
	}
	
	public Hologram withItem(ItemStack item){
		this.item = item;
		return this;
	}

	public void spawn(Location location){
		float offset = 0.30f;
		
		location.add(0, offset * titles.size(), 0);
		
		for(String title : titles){
			ArmorStand armor = location.getWorld().spawn(location, ArmorStand.class);
			armor.setCustomNameVisible(true);
			armor.setCustomName(title);
			armor.setGravity(false);
			armor.setVisible(false);
						
			location.subtract(0, offset, 0);
		}		
		
		if(this.item != null){
			Item item = location.getWorld().dropItem(location, this.item);
			ArmorStand floatingItem = location.getWorld().spawn(location.add(0, offset, 0), ArmorStand.class);
			floatingItem.setGravity(false);
			floatingItem.setVisible(false);
			floatingItem.setPassenger(item);			
		}
		
		this.loc = location;
	}

	public UUID getUuid() {
		return uuid;
	}

	public List<String> getTitles() {
		return titles;
	}

	public ItemStack getItem() {
		return item;
	}
	
}
