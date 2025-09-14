package Linked_List;

public class ReverseLinkedList {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        ListNode head = createLinkedListFromArray(arr);
        printList(head);
        head = reverse(head);
        printList(head);
    }

    static ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode currNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currNext;
        }

        return prev;
    }

    static ListNode createLinkedListFromArray(int[] arr) {
        ListNode head = null;
        ListNode tail = null;

        for (int num : arr) {
            ListNode node = new ListNode(num);

            if (head == null) {
                head = node;
                tail = head;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        return head;
    }

    static void printList(ListNode head) {
        if (head == null) {
            System.out.println("NULL");
            return;
        }

        System.out.print(head.val + " -> ");
        printList(head.next);
    }

}
