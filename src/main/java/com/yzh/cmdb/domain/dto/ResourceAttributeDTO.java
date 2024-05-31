package com.yzh.cmdb.domain.dto;

import lombok.Data;

/**
 * 模型属性
 *
 * @author yuanzhihao
 * @since 2024/5/31
 */
@Data
public class ResourceAttributeDTO {
    private Long id;
    private String name;
    private Long modelId;
    private String identifier;
    private String options;
    private Integer type;
    private Boolean isRequired;
    private String defaultValue;
    private String validationRule;
    private String validationMessage;
}
