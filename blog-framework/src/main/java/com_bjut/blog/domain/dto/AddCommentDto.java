package com_bjut.blog.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "添加评论dto")
public class AddCommentDto{
    private Long id;
    //评论类型（0代表文章评论，1代表友链评论）
    @ApiModelProperty(notes = "评论类型（0代表文章评论，1代表友链评论）")
    private String type;
    //文章id
    @ApiModelProperty(notes = "文章id")
    private Long articleId;
    //文章id
    @ApiModelProperty(notes = "文章id")
    private Long rootId;
    //文章id
    @ApiModelProperty(notes = "文章id")
    private String content;
    //所回复的目标评论的userid
    @ApiModelProperty(notes = "所回复的目标评论的userid")
    private Long toCommentUserId;
    //回复目标评论id
    @ApiModelProperty(notes = "回复目标评论id")
    private Long toCommentId;
    //删除标志（0代表未删除，1代表已删除）
    @ApiModelProperty(notes = "删除标志（0代表未删除，1代表已删除）")
    private Integer delFlag;
    //创建人的用户id
    @ApiModelProperty(notes = "创建人的用户id")
    private Long createBy;
    //创建时间
    @ApiModelProperty(notes = "创建时间")
    private Date createTime;
    //更新人
    @ApiModelProperty(notes = "更新人")
    private Long updateBy;
    //更新时间
    @ApiModelProperty(notes = "更新时间")
    private Date updateTime;
}