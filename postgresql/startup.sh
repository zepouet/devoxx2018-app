#!/usr/bin/env bash

docker rm -vf postgres-srv

docker run --name postgres-srv \
    -e POSTGRES_PASSWORD=mysecretpassword \
    -v `pwd`/pg-data:/var/lib/postgresql/data \
    -v `pwd`/scripts/users.sql:/opt/scripts/users.sql \
    -p 5432:5432 \
    -d postgres

