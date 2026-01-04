package eu.beanstalk.api.models;

import java.util.Collection;
import java.util.HashMap;

public abstract class Handler<CoreType, HandlerType>
{
	private CoreType core;
	protected HashMap<Object, HandlerType> items;

	public Handler(CoreType core)
	{
		this.core = core;
		this.items = new HashMap<>();

		this.run();
	}

	public void add(Object key, HandlerType item)
	{
		items.put(key, item);
	}

	public HandlerType get(Object key)
	{
		return items.get(key);
	}

	public int getInt(Object key)
	{
		return Integer.parseInt(get(key).toString());
	}

	public void remove(Object key)
	{
		items.remove(key);
	}

	public boolean exist(Object key)
	{
		return items.containsKey(String.valueOf(key));
	}

	protected abstract void run();

	public Collection<HandlerType> getItems()
	{
		return items.values();
	}

	public Collection<Object> getKeys()
	{
		return items.keySet();
	}

	public CoreType getCore()
	{
		return core;
	}
}
