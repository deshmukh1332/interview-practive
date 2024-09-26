package com.example.lld.machine_coding.gossipalgo;

public class ServerNode {
    private final int id;
    private String gossip;
    private boolean isGossipReceived;
    private boolean isGossipSent;
    private boolean isSeedNode;

    public ServerNode(int id) {
        this.id = id;
        this.isGossipReceived = false;
        this.isGossipSent = false;
    }

    public int getId() {
        return id;
    }

    public boolean isGossipReceived() {
        return isGossipReceived;
    }

    public void setGossipReceived(boolean gossipReceived) {
        isGossipReceived = gossipReceived;
    }

    public boolean isGossipSent() {
        return isGossipSent;
    }

    public void setGossipSent(boolean gossipSent) {
        isGossipSent = gossipSent;
    }
}
