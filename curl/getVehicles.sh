#!/usr/bin/env bash

# [
#   "ACURA", 
#   "ACCORD", 
#   "VSTAR", 
#   "SCOOTER"
# ]

curl \
-v \
--header "Accept: application/json" \
--url "http://localhost:8080/vehicles" | python -mjson.tool

