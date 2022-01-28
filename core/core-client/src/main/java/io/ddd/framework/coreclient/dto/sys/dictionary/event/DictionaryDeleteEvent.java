package io.ddd.framework.coreclient.dto.sys.dictionary.event;

import io.ddd.framework.coreclient.dto.common.event.DomainEventI;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 
 * @author mikey
 * @date 2022-01-28 21:50:48
 */
@Data
@AllArgsConstructor
public class DictionaryDeleteEvent implements DomainEventI {
    private String uuid;
}
