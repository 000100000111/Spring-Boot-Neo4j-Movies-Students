package com.appleyk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 学生类
 * @Author lixy
 * @Date 2024/3/11 9:34
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@Schema(description = "学生表")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    /**
     * 学生ID 雪花算法
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @Schema(description = "学生ID 雪花算法")
    private Long id;
    /**
     * 用户ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @Schema(description = "用户ID")
    private Long userId;
    /**
     * 宝宝ID
     */
    @Schema(description = "宝宝ID")
    private Integer babyId;
    /**
     * 真实姓名
     */
    @Schema(description = "真实姓名")
    private String realName;
    /**
     * 手机号
     */
    @Schema(description = "手机号")
    private String telephone;
    /**
     * 出生日期
     */
    @DateTimeFormat(pattern = DateUtil.PATTERN_DATE)
    @JsonFormat(pattern = DateUtil.PATTERN_DATE)
    @Schema(description = "出生日期")
    private Date birthday;
    /**
     * 性别 0. 男   1. 女
     */
    @Schema(description = "性别 0. 男   1. 女")
    private Integer gender;
    /**
     * 总积分
     */
    @Schema(description = "总积分")
    private Integer cumulativeIntegral;
    /**
     * 公立学校
     */
    @Schema(description = "公立学校")
    private String publicSchool;
    /**
     * 是否注册 0. 未注册  1. 注册
     */
    @Schema(description = "是否注册 0. 未注册  1. 注册")
    private Integer isRegister;
    /**
     * 英文阅读等级ID （绘本等级ID）
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @Schema(description = "英文阅读等级ID")
    private Long enReadLevelId;
    /**
     * 英文阅读等级名称 （绘本等级名称）
     */
    @Schema(description = "英文阅读等级名称")
    private String enReadLevelName;
    /**
     * 中文阅读等级ID （绘本等级ID）
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @Schema(description = "中文阅读等级ID")
    private Long cnReadLevelId;
    /**
     * 中文阅读等级名称 （绘本等级名称）
     */
    @Schema(description = "中文阅读等级名称")
    private String cnReadLevelName;
    /**
     * 最后登录时间
     */
    @DateTimeFormat(pattern = DateUtil.PATTERN_DATETIME)
    @JsonFormat(pattern = DateUtil.PATTERN_DATETIME)
    @Schema(description = "最后登录时间")
    private Date lastLoginTime;

    @Schema(description = "学校名称")
    @TableField(exist = false)
    private String schoolName;

    @Schema(description = "班级ID")
    private Long classId;
}
