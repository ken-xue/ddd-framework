package io.ddd.framework.adapter.rest.sys;

import io.ddd.framework.adapter.common.annotation.Permissions;
import io.ddd.framework.adapter.rest.common.BasicController;
import io.ddd.framework.coreclient.api.sys.RoleAppService;
import io.ddd.framework.coreclient.dto.common.response.Response;
import io.ddd.framework.coreclient.dto.sys.role.*;
import io.ddd.framework.sharedataobject.common.validator.group.Delete;
import io.ddd.framework.sharedataobject.common.validator.group.Insert;
import io.ddd.framework.sharedataobject.common.validator.group.Update;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
/**
 * 角色表
 * @author mikey
 * @date 2021-11-17 14:27:15
 */
@RestController
@Api(tags = "角色表模块",description = "包含用户新增/列表/删除")
@RequestMapping("sys/role")
public class RoleController extends BasicController {
    @Resource
    private RoleAppService roleAppService;

    @PostMapping("/add")
    @ApiOperation(value = "添加",httpMethod = "POST")
    @Permissions("sys:role:add")
    public Response add(@RequestBody @Validated({Insert.class}) RoleAddCmd roleAddCmd) {
        return roleAppService.add(roleAddCmd);
    }

    @DeleteMapping("/delete")
    @Permissions("sys:role:delete")
    @ApiOperation(value = "删除",httpMethod = "DELETE")
    public Response delete(@RequestBody @Validated({Delete.class}) RoleDeleteCmd roleDeleteCmd){
        return roleAppService.delete(roleDeleteCmd);
    }

    @GetMapping("/page")
    @Permissions("sys:role:page")
    @ApiOperation(value = "列表",httpMethod = "GET")
    public Response page(@ModelAttribute @Valid RolePageQry rolePageQry){
        return roleAppService.page(rolePageQry);
    }

    @GetMapping("/list")
    @Permissions("sys:role:list")
    @ApiOperation(value = "列表",httpMethod = "GET")
    public Response list(@ModelAttribute @Valid RoleListQry roleListQry){
        return roleAppService.list(roleListQry);
    }

    @GetMapping("/info")
    @Permissions("sys:role:info")
    @ApiOperation(value = "详情",httpMethod = "GET")
    public Response info(@ModelAttribute @Valid RoleGetQry roleGetQry){
        return roleAppService.getById(roleGetQry);
    }

    @PutMapping("/update")
    @Permissions("sys:role:update")
    @ApiOperation(value = "更新",httpMethod = "PUT")
    public Response update(@RequestBody @Validated({Update.class}) RoleUpdateCmd roleUpdateCmd){
        return roleAppService.update(roleUpdateCmd);
    }
}
