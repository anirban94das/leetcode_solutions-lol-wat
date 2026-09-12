public class LC_19_Remove_nth_node_from_end_of_list {
    // Driver Code
    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Function call
        head = deleteNthNodeFromEnd(head, 2);

        // Print updated linked list
        printList(head);
    }


    // Node class
    static class ListNode {
        int data;
        ListNode next;

        ListNode(int x) {
            this.data = x;
            this.next = null;
        }
    }

    // Function to delete Nth node from end

    static ListNode deleteNthNodeFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        int listSize = 0;

        ListNode pointer = head;

        // Find length of linked list
        while (pointer != null) {
            pointer = pointer.next;
            listSize++;
        }
        // If n is greater than length
        if (n > listSize) {
            return head;
        }

        // If head node needs to be deleted
        if (listSize - n == 0) {
            head = head.next;
            return head;
        }

        // Reach node just before target node
        pointer = head;
        for (int i = 1; i < listSize - n; i++) {
            pointer = pointer.next;
        }

        // Delete target node
        pointer.next = pointer.next.next;

        return head;
    }

    // Function to print linked list
    static void printList(ListNode head) {
        ListNode curr = head;

        while (curr != null) {
            System.out.print(curr.data + " ");

            curr = curr.next;
        }
    }
}


