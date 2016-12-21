package com.co4gsl;

import com.co4gsl.modules.ServiceModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Created by rpayal on 20/12/2016.
 */
public class InjectorFactory {
    private InjectorFactory() {
    }

    // Singleton instance
    private static Injector injector;

    static {
        injector = Guice.createInjector(new ServiceModule());
    }

    /**
     * Return the default injector.
     */
    public static Injector getInjector() {
        return injector;
    }
}
