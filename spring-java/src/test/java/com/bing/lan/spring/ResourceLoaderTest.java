package com.bing.lan.spring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.File;
import java.io.IOException;
import java.util.Set;

/**
 * Created by 蓝兵 on 2019/10/18.
 * 样式
 * classpath:/xxx/*as/aa.xml
 * classpath*:/xxx/*as/aa.xml
 * <p>
 * file:/xxx/*as/aa.xml
 * file:c:/xxx/*as/aa.xml
 * <p>
 * jar:file:/xxx/*as/aa.xml
 * jar:file:c:/xxx/*as/aa.xml
 */
public class ResourceLoaderTest {

    private PathMatchingResourcePatternResolverSon resolver = new PathMatchingResourcePatternResolverSon();
    private String fatherPath = "";
    private String pattern = "";
    private String location = "";

    //@Before
    public void setLocation1() {
        // UrlResource(rootDirResources) -> FileSystemResource
        fatherPath = "E:/IDEA_workspace/SpringLearningDemo/spring-java/src/main/resources/";
        pattern = "*/applicationContext-*.xml";
        location = "file:" + fatherPath + pattern;
        System.out.println("setLocation(): " + location);
    }

    //@Before
    public void setLocation2() {
        // UrlResource(rootDirResources) -> UrlResource
        fatherPath = "E:/IDEA_workspace/SpringLearningDemo/spring-java/target/spring-java-1.0-SNAPSHOT.jar!/";
        pattern = "*/applicationContext-*.xml";
        location = "jar:file:" + fatherPath + pattern;
        System.out.println("setLocation(): " + location);
    }

    @Before
    public void setLocation3() {
        // ClassPathResource(rootDirResources) -> FileSystemResource
        fatherPath = "a/";
        pattern = "applicationContext-*.xml";
        location = "classpath:" + fatherPath + pattern;
        System.out.println("setLocation(): " + location);
    }

    //@Before
    public void setLocation4() {
        // UrlResource(rootDirResources) -> FileSystemResource
        fatherPath = "a/";
        pattern = "applicationContext-*.xml";
        location = "classpath*:" + fatherPath + pattern;
        System.out.println("setLocation(): " + location);
    }

    //@Before
    public void setLocation5() {
        // ClassPathXmlApplicationContext
        // getResourceByPath() (rootDirResources) -> FileSystemResource
        fatherPath = "a/";
        pattern = "applicationContext-*.xml";
        location = fatherPath + pattern;//省略 协议名
        System.out.println("setLocation(): " + location);
    }

    //@Before
    public void setLocation6() {
        // FileSystemXmlApplicationContext
        // getResourceByPath() (rootDirResources) -> FileSystemResource
        resolver = new PathMatchingResourcePatternResolverSon(new DefaultResourceLoader() {
            protected Resource getResourceByPath(String path) {
                if (path != null && path.startsWith("/")) {
                    path = path.substring(1);
                }
                return new FileSystemResource(path);
            }
        });
        fatherPath = "E:/IDEA_workspace/SpringLearningDemo/spring-java/src/main/resources/";
        pattern = "*/applicationContext-*.xml";
        location = fatherPath + pattern;//省略 协议名

        System.out.println("setLocation(): " + location);
    }

    /**
     * 获取资源
     */
    @Test
    public void getResources() throws IOException {
        Resource[] resources = resolver.getResources(location);
        System.out.println("getResources(): " + resources.length);
    }

    /**
     * 拆分路径，获取 父路径（不含*部分）
     */
    @Test
    public void determineRootDir() {
        String determineRootDir = resolver.determineRootDirSon(location);
        System.out.println("determineRootDir(): " + determineRootDir);
    }

    /**
     * 正则的匹配逻辑
     */
    @Test
    public void retrieveMatchingFiles() throws IOException {
        String rootDir = "E:/IDEA_workspace/SpringLearningDemo/spring-java/src/main/resources/";
        String pattern = "*/applicationContext*.xml";

        Set<File> files = resolver.retrieveMatchingFilesSon(new File(rootDir), pattern);
        System.out.println("retrieveMatchingFiles(): " + files.toString());
    }

    public static class PathMatchingResourcePatternResolverSon extends PathMatchingResourcePatternResolver {

        public PathMatchingResourcePatternResolverSon() {
        }

        public PathMatchingResourcePatternResolverSon(ResourceLoader resourceLoader) {
            super(resourceLoader);
        }

        /**
         * 从末尾一条一条的去掉 / 直到没有*
         */
        public String determineRootDirSon(String location) {
            int prefixEnd = location.indexOf(":") + 1;
            int rootDirEnd = location.length();
            while (rootDirEnd > prefixEnd && getPathMatcher().isPattern(location.substring(prefixEnd, rootDirEnd))) {
                System.out.println("------------------------------- ");
                int fromIndex = (rootDirEnd - 1) - 1;
                rootDirEnd = location.lastIndexOf('/', fromIndex) + 1;
                System.out.println("determineRootDirSon(): " + location.substring(prefixEnd, rootDirEnd));
            }
            if (rootDirEnd == 0) {
                rootDirEnd = prefixEnd;
            }
            return location.substring(0, rootDirEnd);
        }

        public Set<File> retrieveMatchingFilesSon(File rootDir, String pattern) throws IOException {
            return retrieveMatchingFiles(rootDir, pattern);
        }
    }
}
