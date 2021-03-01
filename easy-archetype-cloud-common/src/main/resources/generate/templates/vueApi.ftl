import request from '@/utils/request'

const  prefix = "${pathPrefix}"


// 查询列表
export function list(query) {
 return request({
    url: prefix+'/list',
    method: 'post',
    data: query
})
}

// 查询详细
export function get(id) {
 return request({
    url: prefix+'/' + id,
    method: 'get'
})
}



// 新增参数配置
export function add(data) {
 return request({
    url: prefix+'',
    method: 'post',
    data: data
})
}

// 修改参数配置
export function update(data) {
 return request({
    url: prefix+'',
    method: 'put',
    data: data
})
}

// 删除参数配置
export function del(id) {
 return request({
    url: prefix+'/' + id,
    method: 'delete'
})
}

