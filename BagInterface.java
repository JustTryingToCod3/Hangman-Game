package school;

public interface BagInterface<T> {

	public int getCurrentSize();
	public boolean isFull();
	public boolean isEmpty();
	public boolean add(T input);
	public T removeRandom();
	public boolean removeSpecific(T input);
	public void removeAll();
	public int getCountOf(T input);
	public boolean contains(T input);
}
