package com.easv.oe.sqlite3;

public class BEPerson {

    long m_id;
    String m_name;

    public BEPerson(long id, String name) {
        m_id = id;
        m_name = name;
    }

    public String toString() {
        return "" + m_id + ": " + m_name;
    }

}
