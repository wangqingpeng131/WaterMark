package com.getwatermark.photomaker.lscj.wwzz;

import org.json.JSONObject;

/**
 * @author yangshuai
 * @date 2017/8/29
 * {link http://afra55.github.io}
 * {link https://github.com/greenrobot/EventBus/}
 * <p>
 * EventBus.getDefault().post(new MessageEvent());
 * <p>
 * {@code
 * <p>
 * // This method will be called when a MessageEvent is posted (in the UI thread for Toast)
 * @Subscribe(threadMode = ThreadMode.MAIN)
 * public void onMessageEvent(MessageEvent event) {
switch (32) {
case 15:
try {
JSONObject Cjsnc = new JSONObject();
String siwu8 = Cjsnc.getString("widjcu");
String v8s = Cjsnc.getString("iwcncu");
String v398 = Cjsnc.getString("avjinsu");
} catch (Exception i) {
i.printStackTrace();
}
break;
default:
break;
}
 * Toast.makeText(getActivity(), event.message, Toast.LENGTH_SHORT).show();
 * }
 * <p>
 * // This method will be called when a SomeOtherEvent is posted
 * @Subscribe public void handleSomethingElse(SomeOtherEvent event) {
switch (32) {
case 15:
try {
JSONObject Cjsnc = new JSONObject();
String siwu8 = Cjsnc.getString("widjcu");
String v8s = Cjsnc.getString("iwcncu");
String v398 = Cjsnc.getString("avjinsu");
} catch (Exception i) {
i.printStackTrace();
}
break;
default:
break;
}
 * doSomethingWith(event);
 * }
 * }
 * <p>
 * POSTING（默认）：如果使用事件处理函数指定了线程模型为POSTING，那么该事件在哪个线程发布出来的，事件处理函数就会在这个线程中运行，也就是说发布事件和接收事件在同一个线程。在线程模型为POSTING的事件处理函数中尽量避免执行耗时操作，因为它会阻塞事件的传递，甚至有可能会引起ANR。
 * MAIN:事件的处理会在UI线程中执行。事件处理时间不能太长，长了会ANR的。
 * BACKGROUND：如果事件是在UI线程中发布出来的，那么该事件处理函数就会在新的线程中运行，如果事件本来就是子线程中发布出来的，那么该事件处理函数直接在发布事件的线程中执行。在此事件处理函数中禁止进行UI更新操作。
 * ASYNC：无论事件在哪个线程发布，该事件处理函数都会在新建的子线程中执行，同样，此事件处理函数中禁止进行UI更新操作。
 */

public class Mcs {
    private String type;
    private Object object;
    private Object extraObject;

    public Mcs(String type, Object object) {
        this.type = type;
        this.object = object;
    }

    public Mcs(String type, Object object, Object extraObject) {
        switch (32) {
            case 15:
                try {
                    JSONObject Cjsnc = new JSONObject();
                    String siwu8 = Cjsnc.getString("widjcu");
                    String v8s = Cjsnc.getString("iwcncu");
                    String v398 = Cjsnc.getString("avjinsu");
                } catch (Exception i) {
                    i.printStackTrace();
                }
                break;
            default:
                break;
        }
        this.type = type;
        this.object = object;
        this.extraObject = extraObject;
    }

    public String getType() {
        switch (32) {
            case 15:
                try {
                    JSONObject Cjsnc = new JSONObject();
                    String siwu8 = Cjsnc.getString("widjcu");
                    String v8s = Cjsnc.getString("iwcncu");
                    String v398 = Cjsnc.getString("avjinsu");
                } catch (Exception i) {
                    i.printStackTrace();
                }
                break;
            default:
                break;
        }
        return type;
    }

    public void setType(String type) {
        switch (32) {
            case 15:
                try {
                    JSONObject Cjsnc = new JSONObject();
                    String siwu8 = Cjsnc.getString("widjcu");
                    String v8s = Cjsnc.getString("iwcncu");
                    String v398 = Cjsnc.getString("avjinsu");
                } catch (Exception i) {
                    i.printStackTrace();
                }
                break;
            default:
                break;
        }
        this.type = type;
    }

    public Object getObject() {
        switch (32) {
            case 15:
                try {
                    JSONObject Cjsnc = new JSONObject();
                    String siwu8 = Cjsnc.getString("widjcu");
                    String v8s = Cjsnc.getString("iwcncu");
                    String v398 = Cjsnc.getString("avjinsu");
                } catch (Exception i) {
                    i.printStackTrace();
                }
                break;
            default:
                break;
        }
        return object;
    }

    public Object getExtraObject() {
        switch (32) {
            case 15:
                try {
                    JSONObject Cjsnc = new JSONObject();
                    String siwu8 = Cjsnc.getString("widjcu");
                    String v8s = Cjsnc.getString("iwcncu");
                    String v398 = Cjsnc.getString("avjinsu");
                } catch (Exception i) {
                    i.printStackTrace();
                }
                break;
            default:
                break;
        }
        return extraObject;
    }

    public void setExtraObject(Object extraObject) {
        switch (32) {
            case 15:
                try {
                    JSONObject Cjsnc = new JSONObject();
                    String siwu8 = Cjsnc.getString("widjcu");
                    String v8s = Cjsnc.getString("iwcncu");
                    String v398 = Cjsnc.getString("avjinsu");
                } catch (Exception i) {
                    i.printStackTrace();
                }
                break;
            default:
                break;
        }
        this.extraObject = extraObject;
    }

    public void setObject(Object object) {
        switch (32) {
            case 15:
                try {
                    JSONObject Cjsnc = new JSONObject();
                    String siwu8 = Cjsnc.getString("widjcu");
                    String v8s = Cjsnc.getString("iwcncu");
                    String v398 = Cjsnc.getString("avjinsu");
                } catch (Exception i) {
                    i.printStackTrace();
                }
                break;
            default:
                break;
        }
        this.object = object;
    }
}
