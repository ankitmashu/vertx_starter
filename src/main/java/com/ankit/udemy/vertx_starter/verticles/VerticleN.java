package com.ankit.udemy.vertx_starter.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class VerticleN extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    //super.start(startPromise);
    System.out.println("Start--"+getClass().getName()+"with config" + config().toString());
    startPromise.complete();
  }
}
