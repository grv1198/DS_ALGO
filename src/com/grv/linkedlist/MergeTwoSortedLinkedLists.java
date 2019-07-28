package com.grv.linkedlist;

public class MergeTwoSortedLinkedLists {

    /**
     * Uses a dummy node to maintain tail
     *
     * @param headA
     * @param headB
     * @return head of merged sorted list
     */
    public LLNode mergeSorted(LLNode headA, LLNode headB) {


        LLNode dummyNode = new LLNode(0);

        LLNode tail = dummyNode;

        while (true) {

            //base case 1
            if (headA == null) {
                tail.next = headB;
                break;
            }

            //base case 2

            if (headB == null) {
                tail.next = headA;
                break;
            }

            if (headA.data <= headB.data) {
                tail.next = headA;
                headA = headA.next;
            } else {
                tail.next = headB;
                headB = headB.next;
            }

            tail = tail.next;

        }
        return dummyNode.next;
    }

    public static void main(String args[]) {

        LLNode l11 = new LLNode(1);
        LLNode l12 = new LLNode(3);
        LLNode l13 = new LLNode(5);
        LLNode l14 = new LLNode(7);

        l11.next = l12; l12.next = l13; l13.next = l14;

        LLNode l21 = new LLNode(2);
        LLNode l22 = new LLNode(4);
        LLNode l23 = new LLNode(5);
        LLNode l24 = new LLNode(8);
        l21.next = l22; l22.next = l23; l23.next = l24;

        MergeTwoSortedLinkedLists mergeTwoSortedLinkedLists = new MergeTwoSortedLinkedLists();

        LLNode resultHead = mergeTwoSortedLinkedLists.mergeSorted(l11, l21);


        while(resultHead != null){
            System.out.print(resultHead.data + ", ");
            resultHead = resultHead.next;
        }

    }
}
