#!/bin/sh

sh ./run-processor.sh com.pineone.icbms.so.processor.context.ContextModelProcessor &
sh ./run-processor.sh com.pineone.icbms.so.processor.orchestrationservice.OrchestrationServiceProcessor &
sh ./run-processor.sh com.pineone.icbms.so.processor.virtualobject.VirtualObjectProcessor &
sh ./run-processor.sh com.pineone.icbms.so.processor.devicecontrol.DeviceControlProcessor &