
public class SimpleLinkList {
	private static final int MAX_LENGTH = 1000;

	private int[] data;

	private int index;

	public SimpleLinkList() {
		data = new int[MAX_LENGTH];
		index = 0;
	}

	public void append(int value) {
		if (index == MAX_LENGTH) {
			System.out.println("The data is full");
			return;
		}
		data[index++] = value;
	}

	public void removeTail() {
		if (index == 0) {
			return;
		}
		index--;
	}

	public void removeAllGreater(int max) {
		// checke removed number
		boolean[] isRemoved = new boolean[index];
		for (int i = 0; i < index; i++) {
			if (data[i] > max) {
				isRemoved[i] = true;
			}
		}
		// fill remain data
		int newIndex = 0;
		for (int i = 0; i < index; i++) {
			if (!isRemoved[i]) {
				data[newIndex++] = data[i];
			}
		}
		index = newIndex;

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < index; i++) {
			sb.append(" " + data[i]);
		}
		return sb.toString();
	}

}
