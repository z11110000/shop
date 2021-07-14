package com.shop.common.entity.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * @author
 * @version $Id: FileUtils.java,v 0.1 2021/7/5 14:25  Exp $
 */
public class FileUtils {

    public static Properties getProperties(String path) throws IOException {

        return PropertiesLoaderUtils
                .loadProperties(new EncodedResource(new ClassPathResource(path), "utf-8"));

    }

}
