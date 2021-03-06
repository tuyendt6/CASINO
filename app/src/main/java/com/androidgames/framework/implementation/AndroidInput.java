package com.androidgames.framework.implementation;

import android.content.Context;
import android.os.Build;
import android.view.View;

import com.androidgames.framework.Input;
import com.androidgames.framework.TouchHandler;

import java.util.List;

/**
 * Created by ammu on 7/13/2017.
 */

public class AndroidInput implements Input {

    AccelerometerHandler accelerometerHandler;
    KeyBoardHandler keyBoardHandler;
    TouchHandler touchHandler;

    public AndroidInput(Context context, View view,float scaleX,float scaleY){
        accelerometerHandler = new AccelerometerHandler(context);
        keyBoardHandler = new KeyBoardHandler(view);
        if (Integer.parseInt(Build.VERSION.SDK)<5){
            touchHandler = new SingleTouchHandler(view,scaleX,scaleY);
        }else
            touchHandler = new MultiTouchHandler(view,scaleX,scaleY);

    }

    @Override
    public boolean isKeyPressed(int keyCode) {
        return keyBoardHandler.isKeyPressed(keyCode);
    }

    @Override
    public boolean isTouchDown(int pointer) {

        return touchHandler.isTouchDown(pointer);
    }

    @Override
    public int getTouchX(int pointer) {

        return touchHandler.getTouchX(pointer);
    }

    @Override
    public int getTouchY(int pointer) {

        return touchHandler.getTouchY(pointer);
    }

    @Override
    public float getAccelX() {

        return accelerometerHandler.getAccelX();
    }

    @Override
    public float getAccelY() {

        return accelerometerHandler.getAccelY();
    }

    @Override
    public float getAccelZ() {

        return accelerometerHandler.getAccelZ();
    }

    @Override
    public List<KeyEvent> getKeyEvents() {

        return keyBoardHandler.getKeyEvents();
    }

    @Override
    public List<TouchEvent> getTouchEvents() {

        return touchHandler.getTouchEvents();
    }
}
