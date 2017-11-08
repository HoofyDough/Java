class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    ListNode(int[] x) {
        ListNode head = generateListNodes(x);
        this.val = head.val;
        this.next = head.next;
    }

    public ListNode generateListNodes(int[] val) {
        ListNode listnode = new ListNode(val[0]);
        ListNode temp = listnode;
        for(int i=1; i<val.length; i++) {
            temp.next = new ListNode(val[i]);
            temp = temp.next;
        }
        return listnode;
    }

    public void printListNodes(ListNode l1) {
        while(l1 != null) {
            System.out.print(l1.val + " -> ");
            l1 = l1.next;
        }
        System.out.println("null");
    }
}