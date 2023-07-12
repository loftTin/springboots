package com_bjut.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com_bjut.blog.domain.ResponseResult;
import com_bjut.blog.domain.dto.TagListDto;
import com_bjut.blog.domain.entity.LoginUser;
import com_bjut.blog.domain.entity.Tag;
import com_bjut.blog.domain.vo.PageVo;
import com_bjut.blog.domain.vo.TagVo;
import com_bjut.blog.mapper.TagMapper;
import com_bjut.blog.service.TagService;
import com_bjut.blog.utils.BeanCopyUtils;
import com_bjut.blog.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 标签(Tag)表服务实现类
 *
 * @author makejava
 * @since 2023-07-07 14:44:31
 */
@Service("tagService")
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public ResponseResult<PageVo> pageTagList(Integer pageNum, Integer pageSize, TagListDto tagListDto) {
        //分页查询
        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StringUtils.hasText(tagListDto.getName()),Tag::getName,tagListDto.getName());
        queryWrapper.eq(StringUtils.hasText(tagListDto.getRemark()),Tag::getRemark,tagListDto.getRemark());

        Page<Tag> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page(page, queryWrapper);
        //封装数据返回
        PageVo pageVo = new PageVo(page.getRecords(),page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    @Override
    public ResponseResult addTag(TagListDto tagListDto) {
//        // 标签是否存在
//        Tag existTag = tagMapper.selectOne(new LambdaQueryWrapper<Tag>()
//                .select(Tag::getId)
//                .eq(Tag::getName, tag.getName()));
//        Assert.isNull(existTag, tag.getName() + "标签已存在");

        // 新建标签，必然不存在更新人，更新时间，仅有创建人，创建时闻
        // 把新增数据转为tag 类型
        Tag tag = new Tag();
        // 获得[创建时间，创建人]
        LoginUser loginUser = SecurityUtils.getLoginUser();
        // 创建人Mid号，在sgL中可以通过id 号查询sg_user 中前user_name
        tag.setCreateBy(loginUser.getUser().getId());
        //创建、更新时间
        try {
            // 创建fSimpLeDateFormat对象，指定日期格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // 获取当前时间
            Date now = new Date();
            // 将当前时间格式化为指定格式的字符串
            String strNow = sdf.format(now);
            // 将宁符串转施为Date 类型
            Date date = sdf.parse(strNow);
            // 时间修改
            tag.setCreateTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 标签，描述修改
        tag .setName(tagListDto .getName());
        tag.setRemark(tagListDto .getRemark());
        // 添加到数据库
        tagMapper.insert(tag);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult<Object> deleteTag(List<Long> id) {
        for (Long tagId : id) {
            removeById(tagId);
        }
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult getLableById(Long id){
        //通过id查询找到tag类型数据包
        Tag tag = tagMapper.selectById(id);
        //封装成vo响应给前端
        TagVo tagVoData = BeanCopyUtils.copyBean(tag, TagVo.class);
        return ResponseResult.okResult(tagVoData);
    }

    @Override
    public ResponseResult myUpdateById(TagVo tagVo) {
        // 把修改数据转为tag类型
        Tag tag = new Tag();
        // 获得[更新时间，更新人]
        LoginUser loginUser = SecurityUtils.getLoginUser();
        // 更新人的id号，在sql中可以通过id号查询my_user中的user_name
        tag.setUpdateBy(loginUser.getUser().getId());
        //创建、更新时间
        try {
            // 创建fSimpLeDateFormat对象，指定日期格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // 获取当前时间
            Date now = new Date();
            // 将当前时间格式化为指定格式的字符串
            String strNow = sdf.format(now);
            // 将宁符串转施为Date 类型
            Date date = sdf.parse(strNow);
            // 时间修改
            tag.setCreateTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 标签，描述修改
        tag.setId(tagVo .getId());
        tag.setName(tagVo .getName());
        tag.setRemark(tagVo .getRemark());
        // 更新到数据库
        tagMapper.updateById(tag);
        return ResponseResult.okResult();
    }

    @Override
    public List<TagVo> listAllTag() {
        LambdaQueryWrapper<Tag> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(Tag::getId,Tag::getName);
        List<Tag> list = list(wrapper);
        List<TagVo> tagVos = BeanCopyUtils.copyBeanList(list, TagVo.class);
        return tagVos;
    }


}

