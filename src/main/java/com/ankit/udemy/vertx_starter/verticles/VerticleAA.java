package com.ankit.udemy.vertx_starter.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class VerticleAA extends AbstractVerticle {
  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    //super.start(startPromise);
    System.out.println("Start-- "+getClass().getName());
    startPromise.complete();
  }

  @Override
  public void stop(Promise<Void> stopPromise) throws Exception {
    //super.stop(stopPromise);
    System.out.println("Stop"+getClass().getName());
    stopPromise.complete();

  }
}
