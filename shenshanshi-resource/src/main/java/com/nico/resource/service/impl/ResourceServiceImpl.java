package com.nico.resource.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nico.common.utils.DateUtils;
import com.nico.common.utils.QueryWrapperUtils;
import com.nico.resource.domain.Resource;
import com.nico.resource.mapper.ResourceMapper;
import com.nico.resource.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceMapper resourceMapper;

    QueryWrapperUtils<Resource> queryWrapperUtils = new QueryWrapperUtils<>();
    /**
     * 查询【请填写功能名称】
     *
     * @param resourceId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Resource selectResourceByResourceId(Long resourceId)
    {
        return resourceMapper.selectById(resourceId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param resource 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Resource> selectResourceList(Resource resource)
    {
        QueryWrapper<Resource> queryWrapper = queryWrapperUtils.getByNotNullField(resource, Resource.class);
        return resourceMapper.selectList(queryWrapper);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param resource 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertResource(Resource resource)
    {
        resource.setCreateTime(DateUtils.getNowDate());
        return resourceMapper.insert(resource);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param resource 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateResource(Resource resource)
    {
        return resourceMapper.updateById(resource);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param resourceIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteResourceByResourceIds(Long[] resourceIds)
    {
        return resourceMapper.deleteBatchIds(Arrays.asList(resourceIds));
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param resourceId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteResourceByResourceId(Long resourceId)
    {
        return resourceMapper.deleteById(resourceId);
    }
}
