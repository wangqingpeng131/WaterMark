package com.getwatermark.photomaker.plugin.eventbus;

import org.greenrobot.eventbus.EventBus;

/**
 * @author Afra55
 * @date 2018/4/4
 * A smile is the best business card.
 */
public class EventBusHelper {
    public static void post(String type, Object object, Object extra) {
        EventBus.getDefault().post(new MessageEvent(type, object, extra));
    }

    public static void post(String type, Object object) {
        EventBus.getDefault().post(new MessageEvent(type, object));
    }

    public static void postSticky(String type, Object object) {
        EventBus.getDefault().postSticky(new MessageEvent(type, object));
    }

    public static void postSticky(String type, Object object, Object extra) {
        EventBus.getDefault().postSticky(new MessageEvent(type, object, extra));
    }

    public static void removeStickyEvent(Object object) {
        EventBus.getDefault().removeStickyEvent(object);
    }
}
