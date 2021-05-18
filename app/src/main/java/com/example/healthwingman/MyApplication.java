package com.example.healthwingman;

import android.app.Application;

public class MyApplication extends Application {
    private Double someVariable;
    public Double getSomeVariable() {
        return someVariable;
    }

    public void setSomeVariable(Double someVariable) {
        this.someVariable = someVariable;
    }
}
