package com.pineone.icbms.so.processor.route;

import com.pineone.icbms.so.processor.context.ContextModelProcessor;
import com.pineone.icbms.so.processor.devicecontrol.DeviceControlProcessor;
import com.pineone.icbms.so.processor.interfaces.processor.AGenericProcessor;
import com.pineone.icbms.so.processor.interfaces.processor.IGenericProcessor;
import com.pineone.icbms.so.processor.orchestrationservice.OrchestrationServiceProcessor;
import com.pineone.icbms.so.processor.virtualobject.VirtualObjectProcessor;
import com.pineone.icbms.so.util.id.IdUtils;
import com.withwiz.plankton.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Process router class.<BR/>
 * This class is Singleton instance.<BR/>
 * <p>
 * Created by uni4love on 2016. 11. 24..
 */
public final class ProcessorRouter {
    /**
     * logger
     */
    private Logger log = LoggerFactory.getLogger(ProcessorRouter.class);

    /**
     * process line
     */
    private ProcessLine line = new ProcessLine();

    /**
     * processor list, <BR/>
     * <p>
     * 1. 추후 class loader를 이용하여 동적으로 구동하도록 처리 요망.
     * 2. 외부에서 inject할 수 있도록 함.<BR/>
     * 3. filter class도 동일 라인에 추가 가능.<BR/>
     */
    static Class[] processorList = {
            ContextModelProcessor.class,
            OrchestrationServiceProcessor.class,
            VirtualObjectProcessor.class,
            DeviceControlProcessor.class
    };

    /**
     * singleton instance holder
     */
    private static final class SingletonHolder {
        static final ProcessorRouter singleton = new ProcessorRouter();
    }

    /**
     * constructor
     */
    private ProcessorRouter() {
        init();
    }

    /**
     * return ProcessorRunner singleton instance.<BR/>
     *
     * @return ProcessorRunner
     */
    public static ProcessorRouter getInstance() {
        return SingletonHolder.singleton;
    }

    /**
     * initialize<BR/>
     */
    private void init() {
        //instance objects
        reload();
    }

    /**
     * reload environments<BR/>
     */
    public void reload() {
        //load classes
        loadClass();
    }

    /**
     * load classes.<BR/>
     */
    private void loadClass() {
        //temporary load static classes;
        //processor id is name.
        for (Class clz : processorList) {
            Class<?> cls = null;
            Class[] args = new Class[]{String.class, String.class};
            try {
                cls = Class.forName(clz.getName());
                Constructor constructor = cls.getConstructor(args);
                //parameters: id, name
                Object obj = constructor.newInstance(IdUtils.createRandomUUID(), cls.getName());
                addProcessor((IGenericProcessor) obj);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * add a processor to registry.<BR/>
     *
     * @param processor processor
     */
    public void addProcessor(IGenericProcessor processor) {
        this.line.addProcessor(processor);
    }

    /**
     * return a processor from registry.<BR/>
     *
     * @param key key for finding a processor.
     * @return IGenericProcessor
     */
    public IGenericProcessor getProcessor(String key) {
        return this.line.getProcessor(key);
    }

    /**
     * return existence of processor<BR/>
     *
     * @param processorName name
     */
    public boolean existProcess(String processorName) {
        return line.existProcessor(processorName);
    }

    /**
     * print USAGE.<BR/>
     */
    public static void printUsage() {
        StringBuilder sb = new StringBuilder("# Usage) java -jar so-serviceprocessor.jar -P[processor1,processor2,..]\n");
        sb.append("\n= current processor name list:\n");
        for (Class cls : processorList) {
            sb.append("+- " + cls.getName() + "\n");
        }
        System.out.println(sb);
    }

    /**
     * run processors.<BR/>
     *
     * @param args runnable processor name
     */
    public void run(String[] args) {
        log.info("user.dir: {}", System.getProperty("user.dir"));
        log.debug("arguments[{}]: {}", args.length, Arrays.stream(args).toArray());
        // processor name list from arguments
        ArrayList<String> processorNameListFromArguments = getProcessorNameListFromArguments(args);
        //
        if (processorNameListFromArguments == null || !checkExistProcessorNameList(processorNameListFromArguments)) {
            //usage
            ProcessorRouter.printUsage();
        } else {
            ProcessorRouter processRouter = ProcessorRouter.getInstance();
            for (String processorName : processorNameListFromArguments) {
                AGenericProcessor processor = (AGenericProcessor)processRouter.getProcessor(processorName);
                new Thread(processor).start();
            }
        }
    }

    /**
     * run parameter("processor class name") list.<BR/>
     *
     * @param processorNameList processor name list
     * @return result after checking
     */
    private boolean checkExistProcessorNameList(ArrayList<String> processorNameList) {
        //check processor class
        ProcessorRouter processRouter = ProcessorRouter.getInstance();
        for (String processorName : processorNameList) {
            log.info("Your processor name: {}", processorName);
            if (!processRouter.existProcess(processorName)) {
                log.error("Your processor NOT exist: {}", processorName);
                return false;
            }
        }
        return true;
    }

    /**
     * return processor name list from arguments.<BR/>
     *
     * @param args arguments
     * @return processor name list
     */
    private ArrayList<String> getProcessorNameListFromArguments(String[] args) {
        ArrayList<String> processorNameList = null;
        for(String arg: args) {
            if (arg.startsWith("-P")) {
                if(processorNameList == null)
                    processorNameList = new ArrayList<>();
                String filteredArgs = StringUtil.getRight(arg, "-P");
                log.debug("filteredArgs: {}", filteredArgs);
                String[] processorArray = filteredArgs.split(",");
                processorNameList.addAll(Arrays.asList(processorArray));
                log.debug("current processorList: {}", processorNameList);
            }
        }
        return processorNameList;
    }


    /**
     * runner test main method.<BR/>
     * <p>
     * usage) java -j [jar file] [processor name]
     *
     * @param args processor name
     */
    public static void main(String[] args) {
        ProcessorRouter.getInstance().run(args);
    }
}