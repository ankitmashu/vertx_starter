package com.ankit.udemy.vertx_starter.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class VerticleA extends AbstractVerticle {
  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    //super.start(startPromise);
    System.out.println("Start-- "+getClass().getName());
    vertx.deployVerticle(new VerticleAA(), whenDeployed ->{
      System.out.println("Deployed --"+VerticleAA.class.getName());
      vertx.undeploy(whenDeployed.result());
    });
    System.out.println("Start-- "+getClass().getName());
    vertx.deployVerticle(new VerticleAB(),whenDeplyed->{
      System.out.println("Deployed--"+VerticleAB.class.getName());
    });
    startPromise.complete();

  }
}
