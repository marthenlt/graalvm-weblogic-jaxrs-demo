#!/bin/bash

echo "Testing with 20,000,000 (20 millions) iterations"

time curl http://localhost:7001/GraalVMJAXRSDemo/rest/graal/benchmark/20000000
