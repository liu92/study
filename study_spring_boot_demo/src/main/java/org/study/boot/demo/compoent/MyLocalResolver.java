package org.study.boot.demo.compoent;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @ClassName MyLocalResolver
 * @Description TODO
 * @Author liuwanlin
 * @Date 2019/6/25 16:19
 **/
public class MyLocalResolver implements LocaleResolver  {
    /**
     * Resolve the current locale via the given request.
     * Can return a default locale as fallback in any case.
     *
     * @param request the request to resolve the locale for
     * @return the current locale (never {@code null})
     */
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //这里只是举例判断是否存在l, 如果不存在就从传入参数中分割获取。如果有就直接获取默认的
        String l = request.getParameter("l");
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(l)){
            //因为语言代码 是en_US, zh_CN
            String[] split = l.split("_");
            // 数组分割 ，第一个值是语言代码，第二是国家代码
            new Locale(split[0],split[1]);

        }
        return locale;
    }

    /**
     * Set the current locale to the given one.
     *
     * @param request  the request to be used for locale modification
     * @param response the response to be used for locale modification
     * @param locale   the new locale, or {@code null} to clear the locale
     * @throws UnsupportedOperationException if the LocaleResolver
     *                                       implementation does not support dynamic changing of the locale
     */
    @Override
    public void setLocale(HttpServletRequest request, @Nullable HttpServletResponse response, @Nullable Locale locale) {

    }
}
