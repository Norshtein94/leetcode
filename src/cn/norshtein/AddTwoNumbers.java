package cn.norshtein;

/**
 Share
 You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Example:

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    public static void main(String[] args){
        AddTwoNumbers test = new AddTwoNumbers();
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);
        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);
        ListNode listNode = test.addTwoNumbers(node1, node2);
        System.out.println(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode current = root;
        int upNum = 0;
        while (l1 != null || l2 != null || upNum > 0){
            int sum = (l1==null? 0 : l1.val) + (l2==null? 0 : l2.val) + upNum;
            upNum = sum/10;
            current.next = new ListNode(sum%10);
            current = current.next;
            l1 = l1==null?null:l1.next;
            l2 = l2==null?null:l2.next;
        }
        return root.next;
    }

    static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
