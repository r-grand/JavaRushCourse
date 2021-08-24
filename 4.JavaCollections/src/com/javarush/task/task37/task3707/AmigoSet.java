package com.javarush.task.task37.task3707;

import java.io.*;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, Serializable {
	private static final Object PRESENT = new Object();
	private transient HashMap<E, Object> map;
	
	public AmigoSet() {
		this.map = new HashMap<>();
	}
	
	public AmigoSet(Collection<? extends E> collection) {
		this.map = new HashMap<>(Math.max((int) (collection.size() / .75f) + 1, 16));
		addAll(collection);
	}
	
	@Override
	public boolean add(E e) {
		return map.put(e, PRESENT) == null;
	}
	
	@Override
	public Iterator<E> iterator() {
		return map.keySet().iterator();
	}
	
	@Override
	public int size() {
		return map.size();
	}
	
	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}
	
	@Override
	public boolean contains(Object o) {
		return map.containsKey(o);
	}
	
	@Override
	public boolean remove(Object o) {
		return map.remove(o) == PRESENT;
	}
	
	@Override
	public void clear() {
		map.clear();
	}
	
	@Override
	public Object clone() {
		try {
			AmigoSet<E> set = (AmigoSet<E>) super.clone();
			set.map = (HashMap<E, Object>) map.clone();
			return set;
		} catch (Exception e) {
			throw new InternalError(e);
		}
	}
	
	private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
		objectOutputStream.defaultWriteObject();
		objectOutputStream.writeInt(HashMapReflectionHelper.<Integer>callHiddenMethod(map, "capacity"));
		objectOutputStream.writeFloat(HashMapReflectionHelper.<Float>callHiddenMethod(map, "loadFactor"));
		objectOutputStream.writeInt(map.size());
		
		for (E e : map.keySet()) {
			objectOutputStream.writeObject(e);
		}
	}
	
	private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
		objectInputStream.defaultReadObject();
		int capacity = objectInputStream.readInt();
		float loadFactor = objectInputStream.readFloat();
		map = new HashMap<>(capacity, loadFactor);
		
		int size = objectInputStream.readInt();
		
		for (int i = 0; i < size; i++) {
			E e = (E) objectInputStream.readObject();
			map.put(e, PRESENT);
		}
	}
}
