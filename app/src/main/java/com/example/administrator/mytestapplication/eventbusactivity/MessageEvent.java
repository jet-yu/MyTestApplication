package com.example.administrator.mytestapplication.eventbusactivity;

/**
 * Created by xu.yu
 *
 * @date 16/6/27.
 * @update
 * @function
 */
public class MessageEvent {
    private String message;

    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
