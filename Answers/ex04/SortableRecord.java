public class SortableRecord extends Record implements Comparable<SortableRecord> {

	/* Constructor */
	public SortableRecord(String id, int m, int j, int e) {
		super(id, m, j, e);
	}

	@Override
	public int compareTo(SortableRecord o) {
		// Compare it with its superclass's score_total attribute
		int result = o.score_total - this.score_total;
		switch(result) {
		case 0:
			// if score_total is same, compare it with its supreclass's score_math attribute
			result = o.score_math - this.score_math;
			switch(result) {
			case 0:
				// if score_math is same, compare it with its superclsss's score_Japanese attribute
				result = o.score_Japanese - this.score_Japanese;
				switch(result) {
				case 0:
					// if score_Japanese is same, compare it with its superclass's score_English attribute
					result = o.score_English - this.score_English;
				}
			}
		}
		return result;
	}

}
