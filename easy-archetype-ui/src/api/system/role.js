import request from '@/utils/request'

let prefix = '/uaa/system/role'

// 查询角色列表
export function listRole(query) {
  return request({
    url: prefix+'/list',
    method: 'post',
    data: query
  })
}

// 查询角色详细
export function getRole(roleId) {
  return request({
    url: prefix+'/' + roleId,
    method: 'get'
  })
}

// 新增角色
export function addRole(data) {
  return request({
    url: prefix+'',
    method: 'post',
    data: data
  })
}

// 修改角色
export function updateRole(data) {
  return request({
    url: prefix+'',
    method: 'put',
    data: data
  })
}

// 角色数据权限
export function dataScope(data) {
  return request({
    url: prefix+'/dataScope',
    method: 'put',
    data: data
  })
}

// 角色状态修改
export function changeRoleStatus(roleId, status) {
  const data = {
    roleId,
    status
  }
  return request({
    url: prefix+'/changeStatus',
    method: 'put',
    data: data
  })
}

// 删除角色
export function delRole(roleId) {
  return request({
    url: prefix+'/' + roleId,
    method: 'delete'
  })
}

// 导出角色
export function exportRole(query) {
  return request({
    url: prefix+'/export',
    method: 'get',
    params: query
  })
}
