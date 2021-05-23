package com.example.shareelem.exception;

import androidx.annotation.NonNull;

public class Name implements Cloneable{

    @NonNull
    @Override
    protected Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
