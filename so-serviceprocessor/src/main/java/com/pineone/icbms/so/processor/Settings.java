package com.pineone.icbms.so.processor;

/**
 * settings for message queue.<BR/>
 * Created by uni4love on 2016. 12. 16..
 */
public class Settings {
    //테스트 이후 주요 properties는 외부 파일로 변경 처리 필요

    /**
     * broker(kafka) list
     */
    public static final String BROKER_LIST = "localhost:9092";

    /**
     * Zookeeper list
     */
    public static final String ZOOKEEPER_LIST = "localhost:2181";

    /**
     * kafka topic: contextmodel<BR/>
     */
    public static final String TOPIC_CONTEXT_MODEL = "contextmodel";

    /**
     * kafka topic: orchestrationservice<BR/>
     */
    public static final String TOPIC_ORCHESTRATION_SERVICE = "orchestrationservice";

    /**
     * kafka topic: virtual object<BR/>
     */
    public static final String TOPIC_VIRTUAL_OBJECT = "virtualobject";

    /**
     * kafka topic: devicecontrol<BR/>
     */
    public static final String TOPIC_DEVICE_CONTROL = "devicecontrol";

}
