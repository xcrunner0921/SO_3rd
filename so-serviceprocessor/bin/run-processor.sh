#!/bin/sh
JAR_PATH=../build/libs/so-serviceprocessor-1.0.0-SNAPSHOT.jar

function usage() {
    echo usage\) run-processor.sh [processor name]
    echo = processor name list:
    echo +- ContextProcessor
    echo +- OrchestrationServiceProcessor
    echo +- VirtualObjectProcessor
    echo +- DeviceControlProcessor
    return
}

function run() {
    java -jar ${JAR_PATH} $1
    return
}

if [ 1 -eq $# ]; then
    run $1
else
    usage
fi