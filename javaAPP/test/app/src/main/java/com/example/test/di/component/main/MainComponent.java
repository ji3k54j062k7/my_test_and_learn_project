package com.example.test.di.component.main;


import com.example.test.di.annotation.main.MainAnnotation;
import com.example.test.di.component.BaseComponent;
import com.example.test.di.module.main.MainModule;
import com.example.test.ui.main.MainActivity;

import dagger.Component;

@MainAnnotation
@Component(
        dependencies = BaseComponent.class,
        modules = {
                MainModule.class
        }
)
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
