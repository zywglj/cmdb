package com.yzh.cmdb.controller;

import com.yzh.cmdb.domain.Result;
import com.yzh.cmdb.domain.dto.ResourceGroupDTO;
import com.yzh.cmdb.service.ResourceGroupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 资源分组controller
 *
 * @author yuanzhihao
 * @since 2024/5/30
 */
@RestController
@RequestMapping(value = "group")
@AllArgsConstructor
@Tag(name = "资源分组")
public class ResourceGroupController {

    private final ResourceGroupService resourceGroupService;


    /**
     * 新增分组
     *
     * @param resourceGroupDTO 资源配置参数
     * @return res
     */
    @PostMapping("add")
    @Operation(summary = "新增分组")
    public Result<Void> add(@Valid @RequestBody ResourceGroupDTO resourceGroupDTO) {
        resourceGroupService.add(resourceGroupDTO);
        return Result.ok();
    }

    /**
     * 删除分组
     *
     * @param id 分组id
     * @return res
     */
    @PostMapping("delete")
    @Operation(summary = "删除分组")
    @Parameter(name = "id", description = "分组id", required = true, in = ParameterIn.QUERY)
    public Result<Void> delete(@RequestParam("id") Long id) {
        resourceGroupService.delete(id);
        return Result.ok();
    }

    /**
     * 更新分组
     *
     * @param resourceGroupDTO 分组信息
     * @return res
     */
    @PostMapping("update")
    @Operation(summary = "更新分组")
    public Result<Void> update(@Valid @RequestBody ResourceGroupDTO resourceGroupDTO) {
        resourceGroupService.update(resourceGroupDTO);
        return Result.ok();
    }


    /**
     * 获取分组列表
     *
     * @return 分组列表
     */
    @GetMapping("list")
    @Operation(summary = "获取分组列表")
    public Result<List<ResourceGroupDTO>> list() {
        return Result.ok(resourceGroupService.list());
    }
}
