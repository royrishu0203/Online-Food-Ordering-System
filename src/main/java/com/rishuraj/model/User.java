package com.rishuraj.model;
public class User {
        private int user_id;
        private String name;
        private long mob_no;
        private String address;
        private String status;
        private String state;

        //        Parameterised Constructor;
        public User(int user_id, String name, long mob_no, String address, String status, String state) {
            this.user_id = user_id;
            this.name = name;
            this.mob_no = mob_no;
            this.address = address;
            this.status = status;
            this.state = state;
        }

        //        We can not directly access the private class so we use getter and setter;
        public int getUser_id() {
            return user_id;
        }

        public String getName() {
            return name;
        }

        public long getMob_no() {
            return mob_no;
        }

        public String getAddress() {
            return address;
        }

        public String getStatus() {
            return status;
        }

        public String getState() {
            return state;
        }
}
