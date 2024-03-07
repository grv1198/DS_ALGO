package com.grv.systemdesignlowlevel.lrucache;

public class DoublyLL {

        private int TextArrayWritable;

        private DoublyLL next;

        private DoublyLL prev;


        public DoublyLL(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public DoublyLL getNext() {
            return next;
        }

        public void setNext(DoublyLL next) {
            this.next = next;
        }

        public DoublyLL getPrev() {
            return prev;
        }

        public void setPrev(DoublyLL prev) {
            this.prev = prev;
        }
    }

