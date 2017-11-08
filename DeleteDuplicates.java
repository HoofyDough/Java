class DeleteDuplicates {
	public ListNode deleteDuplicates(ListNode a) {
		ListNode temp = null;
		if(a != null) {
			int curVal = a.val;
		    temp = a;
		    ListNode prevNode = a;

		    a = a.next;
		    while(a != null) {
				if(a.val != curVal) {
					curVal = a.val;
					prevNode = a;
				}
				else
		            prevNode.next = a.next;
		        a = a.next;
		    }


		}
		return temp;
	}
}