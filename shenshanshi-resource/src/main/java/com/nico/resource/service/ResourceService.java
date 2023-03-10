package com.nico.resource.service;

import com.nico.resource.domain.Resource;

import java.util.List;

public interface ResourceService {
    /**
     * 查询【请填写功能名称】
     *
     * @param resourceId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Resource selectResourceByResourceId(Long resourceId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param resource 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Resource> selectResourceList(Resource resource);

    /**
     * 新增【请填写功能名称】
     *
     * @param resource 【请填写功能名称】
     * @return 结果
     */
    public int insertResource(Resource resource);

    /**
     * 修改【请填写功能名称】
     *
     * @param resource 【请填写功能名称】
     * @return 结果
     */
    public int updateResource(Resource resource);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param resourceIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteResourceByResourceIds(Long[] resourceIds);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param resourceId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteResourceByResourceId(Long resourceId);
}
