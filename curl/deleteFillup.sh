#!/usr/bin/env bash

id=${0:?"fillup id is required"}

curl \
-v \
-X DELETE \
--write-out "%{http_code}" \
--url "http://localhost:8080/fillup/${id}"
