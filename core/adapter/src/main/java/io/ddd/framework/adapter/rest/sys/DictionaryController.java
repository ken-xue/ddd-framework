package io.ddd.framework.adapter.rest.sys;

import io.ddd.framework.adapter.common.annotation.Permissions;
import io.ddd.framework.adapter.rest.common.BasicController;
import io.ddd.framework.coreclient.api.sys.DictionaryAppService;
import io.ddd.framework.coreclient.dto.common.response.Response;
import io.ddd.framework.coreclient.dto.sys.dictionary.*;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.validation.Valid;
/**
 * 
 * @author mikey
 * @date 2022-01-28 21:50:48
 */
@RestController
@Api(tags = "字典模块",description = "包含用户新增/列表/删除")
@RequestMapping("sys/dictionary")
public class DictionaryController extends BasicController {
    @Resource
    private DictionaryAppService dictionaryAppService;

    @PostMapping("/add")
    @Permissions("sys:dictionary:add")
    @ApiOperation(value = "添加",httpMethod = "POST")
    public Response add(@RequestBody @Valid DictionaryAddCmd dictionaryAddCmd) {
        return dictionaryAppService.add(dictionaryAddCmd);
    }

    @DeleteMapping("/delete")
    @Permissions("sys:dictionary:delete")
    @ApiOperation(value = "删除",httpMethod = "DELETE")
    public Response delete(@RequestBody @Valid DictionaryDeleteCmd dictionaryDeleteCmd){
        return dictionaryAppService.delete(dictionaryDeleteCmd);
    }

    @GetMapping("/page")
    @Permissions("sys:dictionary:page")
    @ApiOperation(value = "列表",httpMethod = "GET")
    public Response page(@ModelAttribute @Valid DictionaryPageQry dictionaryPageQry){
        return dictionaryAppService.page(dictionaryPageQry);
    }

    @GetMapping("/list")
    @Permissions("sys:dictionary:list")
    @ApiOperation(value = "列表",httpMethod = "GET")
    public Response list(@ModelAttribute @Valid DictionaryListQry dictionaryListQry){
        return dictionaryAppService.list(dictionaryListQry);
    }

    @GetMapping("/info")
    @Permissions("sys:dictionary:info")
    @ApiOperation(value = "详情",httpMethod = "GET")
    public Response info(@ModelAttribute @Valid DictionaryGetQry dictionaryGetQry){
        return dictionaryAppService.getById(dictionaryGetQry);
    }

    @PutMapping("/update")
    @Permissions("sys:dictionary:update")
    @ApiOperation(value = "更新",httpMethod = "PUT")
    public Response update(@RequestBody DictionaryUpdateCmd dictionaryUpdateCmd){
        return dictionaryAppService.update(dictionaryUpdateCmd);
    }
}
