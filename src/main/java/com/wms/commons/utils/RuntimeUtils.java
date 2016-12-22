package com.wms.commons.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 工具类
 *
 * @author L.cm
 */
public class RuntimeUtils {

    private static Logger logger = LoggerFactory.getLogger(RuntimeUtils.class);

    /**
     * 运行shell
     *
     * @param script
     */
    public static void runShell(String script) {
        Process process = null;
        try {
            String[] cmd = {"sh", script};
            //执行liunx命令
            process = Runtime.getRuntime().exec(cmd);
            process.waitFor();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (null != process) {
                process.destroy();
            }
        }
    }

}
