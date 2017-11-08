/**
 * Definition for singly-linked list.
 */

// Put two numbers together
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;

        byte remainder = 0;
        while(l1 != null || l2 != null) {
            if(l1 == null)
                l1 = new ListNode(0);
            else if(l2 == null)
                l2 = new ListNode(0);

            int sum = l1.val + l2.val + remainder;
            temp.val = sum < 10 ? sum : sum%10;
            remainder = (byte)Math.floor(sum/10%10);

            if(l1.next != null || l2.next != null) {
                temp.next = new ListNode(0);
                temp = temp.next;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        if(remainder > 0)
            temp.next = new ListNode(remainder);

        return result;
    }
}
