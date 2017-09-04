package com.jiangyc.library;

import com.jiangyc.library.spi.NovelProvider;
import com.jiangyc.library.util.UrlUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

public class LibraryProviderFactory {
    /**
     * 所有实现的书籍提供者
     */
    private static final ServiceLoader<NovelProvider> providers;
    /** 书籍提供者的集合，以提供者的Host作为Key */
    private static final Map<String, NovelProvider> providerMap;

    /**
     * 静态代码块，从类路径中自动加载所有的{@code NovelProvider}的实现
     */
    static {
        providers = ServiceLoader.load(NovelProvider.class);

        if (providers == null || !providers.iterator().hasNext()) {
            throw new RuntimeException("Have no implements of NovelProvider");
        }

        providerMap = new HashMap<>();
        for (NovelProvider provider : providers) {
            providerMap.put(provider.getHost().toLowerCase(), provider);
        }
    }

    /**
     * 获取当前类路径中所有的{@code NovelProvider}的实现
     * @return
     */
    public static Iterator<NovelProvider> getNovelProviders() {
        return providers.iterator();
    }

    /**
     * 根据网址获取NovelProvider
     * @param address host或网址
     * @return NovelProvider
     */
    public static NovelProvider getNovelProvider(String address) {
        String host = UrlUtils.getHost(address);

        if (host == null || "".equals(host)) {
            return null;
        }

        return providerMap.get(host.toLowerCase());
    }
}
