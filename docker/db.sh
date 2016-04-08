#!/usr/bin/env bash

cp ../target/vector-tiles-boot-0.0.1-SNAPSHOT.jar .

docker build\
 --force-rm=true\
 --ulimit nofile=65535:65535\
 --ulimit nproc=25059:25059\
 -t mraad/vector-tiles-boot .
