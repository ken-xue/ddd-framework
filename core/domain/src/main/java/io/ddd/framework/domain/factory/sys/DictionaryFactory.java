package io.ddd.framework.domain.factory.sys;

import io.ddd.framework.domain.domain.sys.Dictionary;
/**
 * 
 * @author mikey
 * @date 2022-01-28 21:50:48
 */
public class DictionaryFactory {
    public static Dictionary getDictionary(){
        return new Dictionary();
    }
}
