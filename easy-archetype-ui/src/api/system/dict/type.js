import request from '@/utils/request'

let prefix = '/uaa/system/dict/type'

// 查询字典类型列表
export function listType(query) {
  return request({
    url: prefix + '/list',
    method: 'post',
    data: query
  })
}

// 查询字典类型列表
export function listAllType() {
  return request({
    url: prefix + '/list/all',
    method: 'post'

  })
}

// 查询字典类型详细
export function getType(dictId) {
  return request({
    url: prefix + '/' + dictId,
    method: 'get'
  })
}

// 新增字典类型
export function addType(data) {
  return request({
    url: prefix + '',
    method: 'post',
    data: data
  })
}

// 修改字典类型
export function updateType(data) {
  return request({
    url: prefix + '',
    method: 'put',
    data: data
  })
}

// 删除字典类型
export function delType(dictId) {
  return request({
    url: prefix + '/' + dictId,
    method: 'delete'
  })
}

// 清理参数缓存
export function clearCache() {
  return request({
    url: prefix + '/clearCache',
    method: 'delete'
  })
}

// 导出字典类型
export function exportType(query) {
  return request({
    url: prefix + '/export',
    method: 'get',
    params: query
  })
}

// 获取字典选择框列表
export function optionselect() {
  return request({
    url: prefix + '/optionselect',
    method: 'get'
  })
}
