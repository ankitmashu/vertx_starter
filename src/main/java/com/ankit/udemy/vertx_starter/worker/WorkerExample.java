package com.ankit.udemy.vertx_starter.worker;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorkerExample extends AbstractVerticle {

  private static final Logger LOG = LoggerFactory.getLogger(WorkerExample.class);

  public static void main(String[] args) {
    Vertx vertx= Vertx.vertx();
    vertx.deployVerticle(new WorkerExample());
  }

  @Override
  public void start(Promise<Void> startPromise) throws Exception {

    startPromise.complete();
    vertx.executeBlocking(event-> {
      LOG.debug("Executing blocking code");
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        LOG.error("Failed", e);
        event.fail(e);
      }
    }, result -> {
      if(result.succeeded())
      {
        LOG.debug("Blocking Call done");
      }
      else {
        LOG.debug("Blocking called failed due to", result.cause());
      }
    });

  }
}
