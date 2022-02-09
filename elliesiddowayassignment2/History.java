package com.example.elliesiddowayassignment2;


import android.util.Log;

public class History {
    private class HistoryNode{
        String url;
        HistoryNode next = null;
        HistoryNode previous = null;
    }

    HistoryNode current = new HistoryNode();

    public void addToHistory(String url) {
        if(current.url == null) {
            current.url = url;
            current.next = new HistoryNode();
            current.next.previous = current;
        }
        else {
            current = current.next;
            current.url = url;
            current.next = new HistoryNode();
            current.next.previous = current;
        }
    }

    public String goForward() {
        if(current.next.url != null) {
            current = current.next;
            return current.url;
        }
        else return current.url;
    }

    public String goBack() {
        if(current.previous != null) {
            current = current.previous;
            return current.url;
        }
        else return current.url;
    }
}