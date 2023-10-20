//import LinkContainer.Box;

public class Box
	{
		private Box next;
		private Box previous;
		private Room data;
		public Box()
		{
			data = null;
			next = null;
			previous = null;
		}
		public Box(Room inputData)
		{
			data = inputData;
		}
		public Box getNext()
		{
			return next;
		}
		public void setNext(Box nextBox)
		{
			next = nextBox;
		}
		public Box getPrevious()
		{
			return previous;
		}
		public void setPrevious(Box lastBox)
		{
			previous = lastBox;
		}
		public Room getData()
		{
			return data;
		}
		public void setData(Room currentData)
		{
			data = currentData;
		}
	}