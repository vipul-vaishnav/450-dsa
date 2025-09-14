package Linked_List;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
        this.val = 0;
        this.next = null;
    }

    ListNode(int _val) {
        this.val = _val;
        this.next = null;
    }

    ListNode(int _val, ListNode _next) {
        this.val = _val;
        this.next = _next;
    }
}
