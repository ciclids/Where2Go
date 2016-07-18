package com.ciclids.where2go.lib;

public interface EvntBus {
    void register(Object subscriber);

    void unregister(Object subscriber);

    void post(Object event);

}
