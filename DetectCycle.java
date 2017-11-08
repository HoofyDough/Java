class DetectCycle {
	public ListNode detectCycle(ListNode a) {
		if(a != null && a.next != null) {
			HashSet<Integer> hashSet = new HashSet<>();
			while(a != null) {
				if(hashSet.contains(a.val))
					return a;
				hashSet.add(a.val);
				a = a.next;
			}
		}

		return null;

		// if(a != null && a.next != null) {
		// 	int startVal = a.val;
		// 	do {
		// 		a = a.next;
		// 		if (a.next == null)
		// 			return null;
		// 		else if (a.next.val == startVal)
		// 			return a.next;
		// 	} while(a.val != startVal);
		// }
		// return null;
	}

	public ListNode detectCycleSP(ListNode a) {
		if(a != null && a.next != null) {
			HashSet<Integer> hashSet = new HashSet<>();
			while(a != null) {
				if(hashSet.contains(a.val))
					return a;
				hashSet.add(a.val);
				a = a.next;
			}
		}

		return null;
	}
}