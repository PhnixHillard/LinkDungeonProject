//linklist chapter 2.5
public class CircularLinkedList <E>
{
	private Box head = new Box();
	private int size;
	
	public CircularLinkedList()
	{
		size = 0;
		head = null;
	}
	public void addInFront(Room currentData)
	{
		Box currentBox = new Box(currentData);
		currentBox.setNext(head);
		if (head == null)
		{
			head = currentBox;
		}
		else
		{
			Box b = head;
			Box c = head;
			while (b.getNext() != null && b.getNext() != head)
			{
				c = b;
				b = b.getNext();
				b.setPrevious(c);
			}
			b.setNext(currentBox);
			currentBox.setPrevious(b);
			currentBox.setNext(head);
			head.setPrevious(currentBox);
		}
		size++;
	}
	public void add(int index, Room currentData)
	{
		Box currentBox = new Box(currentData);
		Box a = head;
		for (int i = 0; i < index; i++)
		{
			if (a.getNext() != null) 
			{
				a = a.getNext();
			}
		}//need to put everything back in sequence
		currentBox.setNext(a.getNext());
		currentBox.setPrevious(a);
		a.setNext(currentBox);
		size++;
	}
	public void remove(int index)
	{
		Box a = head;
		Box b = null;
		for (int i = 0; i < index; i++)
		{
			a = a.getNext();
		}
		b = a;
		a = a.getNext().getNext();
		b.setNext(a);
		a.setPrevious(b);
		size--;
	}//gotta link things again
	public Box get(int index)
	{
		Box currentBox = head;
		for(int i = 0; i < index; i++)
		{
			currentBox = currentBox.getNext();
		}
		return currentBox;
	}
	public Box getLast()
	{
		Box currentBox = head;
		currentBox = currentBox.getPrevious();
		return currentBox;
	}
	public void printAll()
	{
		Box currentBox = head;
		while(currentBox.getNext() != null && currentBox.getNext() != head)
		{
			System.out.println(currentBox.getData());
			currentBox = currentBox.getNext();
		}
		System.out.println(currentBox.getData());
	}
	public int size()
	{
		return size;
	}
	public void clear()
	{
		Box currentBox = head;
		currentBox = null;
		head = currentBox;
		size = 0;
	}
	
}
